package org.tangdao.modules.paas.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.tangdao.modules.paas.model.domain.PassageTemplateDetail;
import org.tangdao.modules.paas.service.IPassageTemplateDetailService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 通道模板内容Controller
 * @author ruyang
 * @version 2019-09-06
 */
@Controller
@RequestMapping(value = "${adminPath}/paas/paasPassageTemplateDetail")
public class PassageTemplateDetailController extends BaseController {

	@Autowired
	private IPassageTemplateDetailService paasPassageTemplateDetailService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public PassageTemplateDetail get(String id, boolean isNewRecord) {
		return paasPassageTemplateDetailService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@PreAuthorize("hasAuthority('paas:paasPassageTemplateDetail:view')")
	@RequestMapping(value = {"list", ""})
	public String list(PassageTemplateDetail paasPassageTemplateDetail, Model model) {
		model.addAttribute("paasPassageTemplateDetail", paasPassageTemplateDetail);
		return "modules/paas/paasPassageTemplateDetailList";
	}
	
	/**
	 * 查询列表数据
	 */
	@PreAuthorize("hasAuthority('paas:paasPassageTemplateDetail:view')")
	@RequestMapping(value = "listData")
	public @ResponseBody IPage<PassageTemplateDetail> listData(PassageTemplateDetail paasPassageTemplateDetail, HttpServletRequest request, HttpServletResponse response) {
		QueryWrapper<PassageTemplateDetail> queryWrapper = new QueryWrapper<PassageTemplateDetail>();
		return paasPassageTemplateDetailService.page(paasPassageTemplateDetail.getPage(), queryWrapper);
	}

	/**
	 * 查看编辑表单
	 */
	@PreAuthorize("hasAuthority('paas:paasPassageTemplateDetail:view')")
	@RequestMapping(value = "form")
	public String form(PassageTemplateDetail paasPassageTemplateDetail, Model model) {
		model.addAttribute("paasPassageTemplateDetail", paasPassageTemplateDetail);
		return "modules/paas/paasPassageTemplateDetailForm";
	}

	/**
	 * 保存通道模板内容
	 */
	@PreAuthorize("hasAuthority('paas:paasPassageTemplateDetail:edit')")
	@PostMapping(value = "save")
	public @ResponseBody String save(@Validated PassageTemplateDetail paasPassageTemplateDetail) {
		paasPassageTemplateDetailService.saveOrUpdate(paasPassageTemplateDetail);
		return renderResult(Global.TRUE, "保存成功！");
	}
	
	/**
	 * 停用通道模板内容
	 */
	@PreAuthorize("hasAuthority('paas:paasPassageTemplateDetail:edit')")
	@RequestMapping(value = "disable")
	public @ResponseBody String disable(PassageTemplateDetail paasPassageTemplateDetail) {
		paasPassageTemplateDetail.setStatus(PassageTemplateDetail.STATUS_DISABLE);
		paasPassageTemplateDetailService.updateById(paasPassageTemplateDetail);
		return renderResult(Global.TRUE, "停用成功");
	}
	
	/**
	 * 启用通道模板内容
	 */
	@PreAuthorize("hasAuthority('paas:paasPassageTemplateDetail:edit')")
	@RequestMapping(value = "enable")
	public @ResponseBody String enable(PassageTemplateDetail paasPassageTemplateDetail) {
		paasPassageTemplateDetail.setStatus(PassageTemplateDetail.STATUS_NORMAL);
		paasPassageTemplateDetailService.updateById(paasPassageTemplateDetail);
		return renderResult(Global.TRUE, "启用成功");
	}
	
	/**
	 * 删除通道模板内容
	 */
	@PreAuthorize("hasAuthority('paas:paasPassageTemplateDetail:edit')")
	@RequestMapping(value = "delete")
	public @ResponseBody String delete(PassageTemplateDetail paasPassageTemplateDetail) {
		paasPassageTemplateDetailService.deleteById(paasPassageTemplateDetail);
		return renderResult(Global.TRUE, "删除成功！");
	}
	
}