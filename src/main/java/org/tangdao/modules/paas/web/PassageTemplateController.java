//package org.tangdao.modules.paas.web;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.tangdao.common.config.Global;
//import org.tangdao.common.suports.BaseController;
//import org.tangdao.modules.paas.model.domain.PassageTemplate;
//import org.tangdao.modules.paas.service.IPassageTemplateService;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//
///**
// * 通道模板Controller
// * @author ruyang
// * @version 2019-09-06
// */
//@Controller
//@RequestMapping(value = "${adminPath}/paas/paasPassageTemplate")
//public class PassageTemplateController extends BaseController {
//
//	@Autowired
//	private IPassageTemplateService paasPassageTemplateService;
//	
//	/**
//	 * 获取数据
//	 */
//	@ModelAttribute
//	public PassageTemplate get(String id, boolean isNewRecord) {
//		return paasPassageTemplateService.get(id, isNewRecord);
//	}
//	
//	/**
//	 * 查询列表
//	 */
//	@PreAuthorize("hasAuthority('paas:paasPassageTemplate:view')")
//	@RequestMapping(value = {"list", ""})
//	public String list(PassageTemplate paasPassageTemplate, Model model) {
//		model.addAttribute("paasPassageTemplate", paasPassageTemplate);
//		return "modules/paas/paasPassageTemplateList";
//	}
//	
//	/**
//	 * 查询列表数据
//	 */
//	@PreAuthorize("hasAuthority('paas:paasPassageTemplate:view')")
//	@RequestMapping(value = "listData")
//	public @ResponseBody IPage<PassageTemplate> listData(PassageTemplate paasPassageTemplate, HttpServletRequest request, HttpServletResponse response) {
//		QueryWrapper<PassageTemplate> queryWrapper = new QueryWrapper<PassageTemplate>();
//		return paasPassageTemplateService.page(paasPassageTemplate.getPage(), queryWrapper);
//	}
//
//	/**
//	 * 查看编辑表单
//	 */
//	@PreAuthorize("hasAuthority('paas:paasPassageTemplate:view')")
//	@RequestMapping(value = "form")
//	public String form(PassageTemplate paasPassageTemplate, Model model) {
//		model.addAttribute("paasPassageTemplate", paasPassageTemplate);
//		return "modules/paas/paasPassageTemplateForm";
//	}
//
//	/**
//	 * 保存通道模板
//	 */
//	@PreAuthorize("hasAuthority('paas:paasPassageTemplate:edit')")
//	@PostMapping(value = "save")
//	public @ResponseBody String save(@Validated PassageTemplate paasPassageTemplate) {
//		paasPassageTemplateService.saveOrUpdate(paasPassageTemplate);
//		return renderResult(Global.TRUE, "保存成功！");
//	}
//	
//	/**
//	 * 停用通道模板
//	 */
//	@PreAuthorize("hasAuthority('paas:paasPassageTemplate:edit')")
//	@RequestMapping(value = "disable")
//	public @ResponseBody String disable(PassageTemplate paasPassageTemplate) {
//		paasPassageTemplate.setStatus(PassageTemplate.STATUS_DISABLE);
//		paasPassageTemplateService.updateById(paasPassageTemplate);
//		return renderResult(Global.TRUE, "停用成功");
//	}
//	
//	/**
//	 * 启用通道模板
//	 */
//	@PreAuthorize("hasAuthority('paas:paasPassageTemplate:edit')")
//	@RequestMapping(value = "enable")
//	public @ResponseBody String enable(PassageTemplate paasPassageTemplate) {
//		paasPassageTemplate.setStatus(PassageTemplate.STATUS_NORMAL);
//		paasPassageTemplateService.updateById(paasPassageTemplate);
//		return renderResult(Global.TRUE, "启用成功");
//	}
//	
//	/**
//	 * 删除通道模板
//	 */
//	@PreAuthorize("hasAuthority('paas:paasPassageTemplate:edit')")
//	@RequestMapping(value = "delete")
//	public @ResponseBody String delete(PassageTemplate paasPassageTemplate) {
//		paasPassageTemplateService.deleteById(paasPassageTemplate);
//		return renderResult(Global.TRUE, "删除成功！");
//	}
//	
//}