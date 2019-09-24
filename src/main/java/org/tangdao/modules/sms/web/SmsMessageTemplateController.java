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
//import org.tangdao.modules.sms.model.domain.SmsMessageTemplate;
//import org.tangdao.modules.sms.service.ISmsTemplateService;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//
///**
// * 消息模板Controller
// * @author ruyang
// * @version 2019-09-06
// */
//@Controller
//@RequestMapping(value = "${adminPath}/sms/MessageTemplate")
//public class SmsMessageTemplateController extends BaseController {
//
//	@Autowired
//	private ISmsTemplateService smsMessageTemplateService;
//	
//	/**
//	 * 获取数据
//	 */
//	@ModelAttribute
//	public SmsMessageTemplate get(String id, boolean isNewRecord) {
//		return smsMessageTemplateService.get(id, isNewRecord);
//	}
//	
//	/**
//	 * 查询列表
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMessageTemplate:view')")
//	@RequestMapping(value = {"list", ""})
//	public String list(SmsMessageTemplate smsMessageTemplate, Model model) {
//		model.addAttribute("smsMessageTemplate", smsMessageTemplate);
//		return "modules/sms/MessageTemplateList";
//	}
//	
//	/**
//	 * 查询列表数据
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMessageTemplate:view')")
//	@RequestMapping(value = "listData")
//	public @ResponseBody IPage<SmsMessageTemplate> listData(SmsMessageTemplate smsMessageTemplate, HttpServletRequest request, HttpServletResponse response) {
//		QueryWrapper<SmsMessageTemplate> queryWrapper = new QueryWrapper<SmsMessageTemplate>();
//		return smsMessageTemplateService.page(smsMessageTemplate.getPage(), queryWrapper);
//	}
//
//	/**
//	 * 查看编辑表单
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMessageTemplate:view')")
//	@RequestMapping(value = "form")
//	public String form(SmsMessageTemplate smsMessageTemplate, Model model) {
//		model.addAttribute("smsMessageTemplate", smsMessageTemplate);
//		return "modules/sms/MessageTemplateForm";
//	}
//
//	/**
//	 * 保存消息模板
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMessageTemplate:edit')")
//	@PostMapping(value = "save")
//	public @ResponseBody String save(@Validated SmsMessageTemplate smsMessageTemplate) {
//		smsMessageTemplateService.saveOrUpdate(smsMessageTemplate);
//		return renderResult(Global.TRUE, "保存成功！");
//	}
//	
//	/**
//	 * 停用消息模板
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMessageTemplate:edit')")
//	@RequestMapping(value = "disable")
//	public @ResponseBody String disable(SmsMessageTemplate smsMessageTemplate) {
//		smsMessageTemplate.setStatus(SmsMessageTemplate.STATUS_DISABLE);
//		smsMessageTemplateService.updateById(smsMessageTemplate);
//		return renderResult(Global.TRUE, "停用成功");
//	}
//	
//	/**
//	 * 启用消息模板
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMessageTemplate:edit')")
//	@RequestMapping(value = "enable")
//	public @ResponseBody String enable(SmsMessageTemplate smsMessageTemplate) {
//		smsMessageTemplate.setStatus(SmsMessageTemplate.STATUS_NORMAL);
//		smsMessageTemplateService.updateById(smsMessageTemplate);
//		return renderResult(Global.TRUE, "启用成功");
//	}
//	
//	/**
//	 * 删除消息模板
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMessageTemplate:edit')")
//	@RequestMapping(value = "delete")
//	public @ResponseBody String delete(SmsMessageTemplate smsMessageTemplate) {
//		smsMessageTemplateService.deleteById(smsMessageTemplate);
//		return renderResult(Global.TRUE, "删除成功！");
//	}
//	
//}