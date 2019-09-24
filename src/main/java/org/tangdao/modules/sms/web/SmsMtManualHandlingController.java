//package org.tangdao.modules.sms.web;
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
//import org.tangdao.modules.sms.model.domain.SmsMtManualHandling;
//import org.tangdao.modules.sms.service.ISmsMtManualHandlingService;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//
///**
// * 下行短信创建Controller
// * @author ruyang
// * @version 2019-09-06
// */
//@Controller
//@RequestMapping(value = "${adminPath}/sms/MtManualHandling")
//public class SmsMtManualHandlingController extends BaseController {
//
//	@Autowired
//	private ISmsMtManualHandlingService smsMtManualHandlingService;
//	
//	/**
//	 * 获取数据
//	 */
//	@ModelAttribute
//	public SmsMtManualHandling get(String id, boolean isNewRecord) {
//		return smsMtManualHandlingService.get(id, isNewRecord);
//	}
//	
//	/**
//	 * 查询列表
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtManualHandling:view')")
//	@RequestMapping(value = {"list", ""})
//	public String list(SmsMtManualHandling smsMtManualHandling, Model model) {
//		model.addAttribute("smsMtManualHandling", smsMtManualHandling);
//		return "modules/sms/MtManualHandlingList";
//	}
//	
//	/**
//	 * 查询列表数据
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtManualHandling:view')")
//	@RequestMapping(value = "listData")
//	public @ResponseBody IPage<SmsMtManualHandling> listData(SmsMtManualHandling smsMtManualHandling, HttpServletRequest request, HttpServletResponse response) {
//		QueryWrapper<SmsMtManualHandling> queryWrapper = new QueryWrapper<SmsMtManualHandling>();
//		return smsMtManualHandlingService.page(smsMtManualHandling.getPage(), queryWrapper);
//	}
//
//	/**
//	 * 查看编辑表单
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtManualHandling:view')")
//	@RequestMapping(value = "form")
//	public String form(SmsMtManualHandling smsMtManualHandling, Model model) {
//		model.addAttribute("smsMtManualHandling", smsMtManualHandling);
//		return "modules/sms/MtManualHandlingForm";
//	}
//
//	/**
//	 * 保存下行短信创建
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtManualHandling:edit')")
//	@PostMapping(value = "save")
//	public @ResponseBody String save(@Validated SmsMtManualHandling smsMtManualHandling) {
//		smsMtManualHandlingService.saveOrUpdate(smsMtManualHandling);
//		return renderResult(Global.TRUE, "保存成功！");
//	}
//	
//	/**
//	 * 停用下行短信创建
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtManualHandling:edit')")
//	@RequestMapping(value = "disable")
//	public @ResponseBody String disable(SmsMtManualHandling smsMtManualHandling) {
//		smsMtManualHandling.setStatus(SmsMtManualHandling.STATUS_DISABLE);
//		smsMtManualHandlingService.updateById(smsMtManualHandling);
//		return renderResult(Global.TRUE, "停用成功");
//	}
//	
//	/**
//	 * 启用下行短信创建
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtManualHandling:edit')")
//	@RequestMapping(value = "enable")
//	public @ResponseBody String enable(SmsMtManualHandling smsMtManualHandling) {
//		smsMtManualHandling.setStatus(SmsMtManualHandling.STATUS_NORMAL);
//		smsMtManualHandlingService.updateById(smsMtManualHandling);
//		return renderResult(Global.TRUE, "启用成功");
//	}
//	
//	/**
//	 * 删除下行短信创建
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtManualHandling:edit')")
//	@RequestMapping(value = "delete")
//	public @ResponseBody String delete(SmsMtManualHandling smsMtManualHandling) {
//		smsMtManualHandlingService.deleteById(smsMtManualHandling);
//		return renderResult(Global.TRUE, "删除成功！");
//	}
//	
//}