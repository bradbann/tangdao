package org.tangdao.modules.sms.web;

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
import org.tangdao.modules.sms.model.domain.SmsPassageMessageTemplate;
import org.tangdao.modules.sms.service.ISmsPassageMessageTemplateService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 通道消息模板Controller
 * @author ruyang
 * @version 2019-09-06
 */
@Controller
@RequestMapping(value = "${adminPath}/sms/PassageMessageTemplate")
public class SmsPassageMessageTemplateController extends BaseController {

	@Autowired
	private ISmsPassageMessageTemplateService smsPassageMessageTemplateService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SmsPassageMessageTemplate get(String id, boolean isNewRecord) {
		return smsPassageMessageTemplateService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@PreAuthorize("hasAuthority('sms:smsPassageMessageTemplate:view')")
	@RequestMapping(value = {"list", ""})
	public String list(SmsPassageMessageTemplate smsPassageMessageTemplate, Model model) {
		model.addAttribute("smsPassageMessageTemplate", smsPassageMessageTemplate);
		return "modules/sms/PassageMessageTemplateList";
	}
	
	/**
	 * 查询列表数据
	 */
	@PreAuthorize("hasAuthority('sms:smsPassageMessageTemplate:view')")
	@RequestMapping(value = "listData")
	public @ResponseBody IPage<SmsPassageMessageTemplate> listData(SmsPassageMessageTemplate smsPassageMessageTemplate, HttpServletRequest request, HttpServletResponse response) {
		QueryWrapper<SmsPassageMessageTemplate> queryWrapper = new QueryWrapper<SmsPassageMessageTemplate>();
		return smsPassageMessageTemplateService.page(smsPassageMessageTemplate.getPage(), queryWrapper);
	}

	/**
	 * 查看编辑表单
	 */
	@PreAuthorize("hasAuthority('sms:smsPassageMessageTemplate:view')")
	@RequestMapping(value = "form")
	public String form(SmsPassageMessageTemplate smsPassageMessageTemplate, Model model) {
		model.addAttribute("smsPassageMessageTemplate", smsPassageMessageTemplate);
		return "modules/sms/PassageMessageTemplateForm";
	}

	/**
	 * 保存通道消息模板
	 */
	@PreAuthorize("hasAuthority('sms:smsPassageMessageTemplate:edit')")
	@PostMapping(value = "save")
	public @ResponseBody String save(@Validated SmsPassageMessageTemplate smsPassageMessageTemplate) {
		smsPassageMessageTemplateService.saveOrUpdate(smsPassageMessageTemplate);
		return renderResult(Global.TRUE, "保存成功！");
	}
	
	/**
	 * 停用通道消息模板
	 */
	@PreAuthorize("hasAuthority('sms:smsPassageMessageTemplate:edit')")
	@RequestMapping(value = "disable")
	public @ResponseBody String disable(SmsPassageMessageTemplate smsPassageMessageTemplate) {
		smsPassageMessageTemplate.setStatus(SmsPassageMessageTemplate.STATUS_DISABLE);
		smsPassageMessageTemplateService.updateById(smsPassageMessageTemplate);
		return renderResult(Global.TRUE, "停用成功");
	}
	
	/**
	 * 启用通道消息模板
	 */
	@PreAuthorize("hasAuthority('sms:smsPassageMessageTemplate:edit')")
	@RequestMapping(value = "enable")
	public @ResponseBody String enable(SmsPassageMessageTemplate smsPassageMessageTemplate) {
		smsPassageMessageTemplate.setStatus(SmsPassageMessageTemplate.STATUS_NORMAL);
		smsPassageMessageTemplateService.updateById(smsPassageMessageTemplate);
		return renderResult(Global.TRUE, "启用成功");
	}
	
	/**
	 * 删除通道消息模板
	 */
	@PreAuthorize("hasAuthority('sms:smsPassageMessageTemplate:edit')")
	@RequestMapping(value = "delete")
	public @ResponseBody String delete(SmsPassageMessageTemplate smsPassageMessageTemplate) {
		smsPassageMessageTemplateService.deleteById(smsPassageMessageTemplate);
		return renderResult(Global.TRUE, "删除成功！");
	}
	
}