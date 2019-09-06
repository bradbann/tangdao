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
import org.tangdao.modules.sms.model.domain.SmsMessageDeliverLog;
import org.tangdao.modules.sms.service.ISmsDeliverLogService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 下行短信回执日志Controller
 * @author ruyang
 * @version 2019-09-06
 */
@Controller
@RequestMapping(value = "${adminPath}/sms/MessageDeliverLog")
public class SmsMessageDeliverLogController extends BaseController {

	@Autowired
	private ISmsDeliverLogService smsMessageDeliverLogService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SmsMessageDeliverLog get(String id, boolean isNewRecord) {
		return smsMessageDeliverLogService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@PreAuthorize("hasAuthority('sms:smsMessageDeliverLog:view')")
	@RequestMapping(value = {"list", ""})
	public String list(SmsMessageDeliverLog smsMessageDeliverLog, Model model) {
		model.addAttribute("smsMessageDeliverLog", smsMessageDeliverLog);
		return "modules/sms/MessageDeliverLogList";
	}
	
	/**
	 * 查询列表数据
	 */
	@PreAuthorize("hasAuthority('sms:smsMessageDeliverLog:view')")
	@RequestMapping(value = "listData")
	public @ResponseBody IPage<SmsMessageDeliverLog> listData(SmsMessageDeliverLog smsMessageDeliverLog, HttpServletRequest request, HttpServletResponse response) {
		QueryWrapper<SmsMessageDeliverLog> queryWrapper = new QueryWrapper<SmsMessageDeliverLog>();
		return smsMessageDeliverLogService.page(smsMessageDeliverLog.getPage(), queryWrapper);
	}

	/**
	 * 查看编辑表单
	 */
	@PreAuthorize("hasAuthority('sms:smsMessageDeliverLog:view')")
	@RequestMapping(value = "form")
	public String form(SmsMessageDeliverLog smsMessageDeliverLog, Model model) {
		model.addAttribute("smsMessageDeliverLog", smsMessageDeliverLog);
		return "modules/sms/MessageDeliverLogForm";
	}

	/**
	 * 保存下行短信回执日志
	 */
	@PreAuthorize("hasAuthority('sms:smsMessageDeliverLog:edit')")
	@PostMapping(value = "save")
	public @ResponseBody String save(@Validated SmsMessageDeliverLog smsMessageDeliverLog) {
		smsMessageDeliverLogService.saveOrUpdate(smsMessageDeliverLog);
		return renderResult(Global.TRUE, "保存成功！");
	}
	
}