package org.tangdao.modules.sys.web;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.tangdao.common.config.Global;
import org.tangdao.common.suports.BaseController;
import org.tangdao.common.utils.ListUtils;
import org.tangdao.common.utils.MapUtils;
import org.tangdao.common.utils.StringUtils;

import org.tangdao.modules.sys.model.domain.Office;
import org.tangdao.modules.sys.service.IOfficeService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * 机构Controller
 * @author ruyang
 * @version 2019-08-24
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/office")
public class OfficeController extends BaseController {

	@Autowired
	private IOfficeService officeService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Office get(String officeCode, boolean isNewRecord) {
		return officeService.get(officeCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@PreAuthorize("hasAuthority('sys:office:view')")
	@RequestMapping(value = {"list", ""})
	public String list(Office office, Model model) {
		model.addAttribute("office", office);
		return "modules/sys/officeList";
	}
	
	/**
	 * 查询列表数据
	 */
	@PreAuthorize("hasAuthority('sys:office:view')")
	@RequestMapping(value = "listData")
	public @ResponseBody List<Office> listData(Office office) {
		QueryWrapper<Office> queryWrapper = new QueryWrapper<Office>();
		return officeService.select(queryWrapper);
	}

	/**
	 * 查看编辑表单
	 */
	@PreAuthorize("hasAuthority('sys:office:view')")
	@RequestMapping(value = "form")
	public String form(Office office, Model model) {
		if (StringUtils.isNotBlank(office.getParentCode())) {
			office.setParent(officeService.get(office.getParentCode()));
		}
		if (office.getParent() == null) {
			office.setParent(new Office(Office.ROOT_CODE));
		}
		model.addAttribute("office", office);
		return "modules/sys/officeForm";
	}

	/**
	 * 保存机构
	 */
	@PreAuthorize("hasAuthority('sys:office:edit')")
	@PostMapping(value = "save")
	public @ResponseBody String save(@Validated Office office) {
		officeService.saveOrUpdate(office);
		return renderResult(Global.TRUE, "保存成功！");
	}
	
	/**
	 * 停用机构
	 */
	@PreAuthorize("hasAuthority('sys:office:edit')")
	@RequestMapping(value = "disable")
	public @ResponseBody String disable(Office office) {
		QueryWrapper<Office> queryWrapper = new QueryWrapper<Office>();
		queryWrapper.eq("status",Office.STATUS_NORMAL);
		queryWrapper.like("office_code","," + office.getOfficeCode() + ",");
		long count = officeService.count(queryWrapper);
		if (count > 0) {
			return renderResult(Global.FALSE, "该机构包含未停用的子机构！");
		}
		office.setStatus(Office.STATUS_DISABLE);
		officeService.updateById(office);
		return renderResult(Global.TRUE, "停用成功");
	}
	
	/**
	 * 启用机构
	 */
	@PreAuthorize("hasAuthority('sys:office:edit')")
	@RequestMapping(value = "enable")
	public @ResponseBody String enable(Office office) {
		office.setStatus(Office.STATUS_NORMAL);
		officeService.updateById(office);
		return renderResult(Global.TRUE, "启用成功");
	}
	
	/**
	 * 删除机构
	 */
	@PreAuthorize("hasAuthority('sys:office:edit')")
	@RequestMapping(value = "delete")
	public @ResponseBody String delete(Office office) {
		officeService.deleteById(office);
		return renderResult(Global.TRUE, "删除成功！");
	}
	
	/**
	 * 获取树结构数据
	 * @param excludeCode 排除的Code
	 * @param isShowCode 是否显示编码（true or 1：显示在左侧；2：显示在右侧；false or null：不显示）
	 * @return
	 */
	@RequestMapping(value = "treeData")
	public @ResponseBody List<Map<String, Object>> treeData(String excludeCode, String isShowCode) {
		QueryWrapper<Office> queryWrapper = new QueryWrapper<Office>();
		if (StringUtils.isNotBlank(excludeCode)) {
			queryWrapper.ne("office_code", excludeCode);
			queryWrapper.notLike("parent_codes", excludeCode);
		}
		queryWrapper.ne("status", Office.STATUS_DELETE);
		
		queryWrapper.orderByAsc("tree_sort");
		List<Office> sourceList = officeService.select(queryWrapper);
		List<Map<String, Object>> targetList = ListUtils.newArrayList();
		Map<String, Object> tempMap = null;
		for (Office office : sourceList) {
			// 过滤被排除的编码（包括所有子级）
			if (StringUtils.isNotEmpty(excludeCode)){
				if (office.getOfficeCode().equals(excludeCode)){
					continue;
				}
				if (office.getParentCodes().contains("," + excludeCode + ",")){
					continue;
				}
			}
		
			tempMap = MapUtils.newHashMap();
			tempMap.put("id", office.getOfficeCode());
			tempMap.put("pId", office.getParentCode());
			tempMap.put("name", office.getOfficeName());
			targetList.add(tempMap);
		}
		return targetList;
	}
	
}