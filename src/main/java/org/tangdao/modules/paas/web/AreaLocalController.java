package org.tangdao.modules.paas.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import org.tangdao.modules.paas.model.domain.AreaLocal;
import org.tangdao.modules.paas.service.IAreaLocalService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 号码归属地Controller
 * @author ruyang
 * @version 2019-09-27
 */
@Controller
@RequestMapping(value = "${adminPath}/paas/areaLocal")
public class AreaLocalController extends BaseController {

	@Autowired
	private IAreaLocalService areaLocalService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public AreaLocal get(String id, boolean isNewRecord) {
		return areaLocalService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@PreAuthorize("hasAuthority('paas:areaLocal:view')")
	@RequestMapping(value = {"list", ""})
	public String list(AreaLocal areaLocal, Model model) {
		model.addAttribute("areaLocal", areaLocal);
		return "modules/paas/areaLocalList";
	}
	
	/**
	 * 查询列表数据
	 */
	@PreAuthorize("hasAuthority('paas:areaLocal:view')")
	@RequestMapping(value = "listData")
	public @ResponseBody IPage<AreaLocal> listData(AreaLocal areaLocal, HttpServletRequest request, HttpServletResponse response) {
		QueryWrapper<AreaLocal> queryWrapper = new QueryWrapper<AreaLocal>();
		return areaLocalService.page(areaLocal.getPage(), queryWrapper);
	}

	/**
	 * 查看编辑表单
	 */
	@PreAuthorize("hasAuthority('paas:areaLocal:view')")
	@RequestMapping(value = "form")
	public String form(AreaLocal areaLocal, Model model) {
		model.addAttribute("areaLocal", areaLocal);
		return "modules/paas/areaLocalForm";
	}

	/**
	 * 保存号码归属地
	 */
	@PreAuthorize("hasAuthority('paas:areaLocal:edit')")
	@PostMapping(value = "save")
	public @ResponseBody String save(@Validated AreaLocal areaLocal) {
		areaLocalService.saveOrUpdate(areaLocal);
		return renderResult(Global.TRUE, "保存成功！");
	}
	
	/**
	 * 停用号码归属地
	 */
	@PreAuthorize("hasAuthority('paas:areaLocal:edit')")
	@RequestMapping(value = "disable")
	public @ResponseBody String disable(AreaLocal areaLocal) {
		areaLocal.setStatus(AreaLocal.STATUS_DISABLE);
		areaLocalService.updateById(areaLocal);
		return renderResult(Global.TRUE, "停用成功");
	}
	
	/**
	 * 启用号码归属地
	 */
	@PreAuthorize("hasAuthority('paas:areaLocal:edit')")
	@RequestMapping(value = "enable")
	public @ResponseBody String enable(AreaLocal areaLocal) {
		areaLocal.setStatus(AreaLocal.STATUS_NORMAL);
		areaLocalService.updateById(areaLocal);
		return renderResult(Global.TRUE, "启用成功");
	}
	
	/**
	 * 删除号码归属地
	 */
	@PreAuthorize("hasAuthority('paas:areaLocal:edit')")
	@RequestMapping(value = "delete")
	public @ResponseBody String delete(AreaLocal areaLocal) {
		areaLocalService.deleteById(areaLocal);
		return renderResult(Global.TRUE, "删除成功！");
	}
	
}