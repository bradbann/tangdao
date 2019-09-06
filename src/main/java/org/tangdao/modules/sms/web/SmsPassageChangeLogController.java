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
import org.tangdao.modules.sms.model.domain.SmsPassageChangeLog;
import org.tangdao.modules.sms.service.ISmsPassageChangeLogService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 通道变更日志Controller
 * @author ruyang
 * @version 2019-09-06
 */
@Controller
@RequestMapping(value = "${adminPath}/sms/PassageChangeLog")
public class SmsPassageChangeLogController extends BaseController {

	@Autowired
	private ISmsPassageChangeLogService smsPassageChangeLogService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SmsPassageChangeLog get(String id, boolean isNewRecord) {
		return smsPassageChangeLogService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@PreAuthorize("hasAuthority('sms:smsPassageChangeLog:view')")
	@RequestMapping(value = {"list", ""})
	public String list(SmsPassageChangeLog smsPassageChangeLog, Model model) {
		model.addAttribute("smsPassageChangeLog", smsPassageChangeLog);
		return "modules/sms/PassageChangeLogList";
	}
	
	/**
	 * 查询列表数据
	 */
	@PreAuthorize("hasAuthority('sms:smsPassageChangeLog:view')")
	@RequestMapping(value = "listData")
	public @ResponseBody IPage<SmsPassageChangeLog> listData(SmsPassageChangeLog smsPassageChangeLog, HttpServletRequest request, HttpServletResponse response) {
		QueryWrapper<SmsPassageChangeLog> queryWrapper = new QueryWrapper<SmsPassageChangeLog>();
		return smsPassageChangeLogService.page(smsPassageChangeLog.getPage(), queryWrapper);
	}

	/**
	 * 查看编辑表单
	 */
	@PreAuthorize("hasAuthority('sms:smsPassageChangeLog:view')")
	@RequestMapping(value = "form")
	public String form(SmsPassageChangeLog smsPassageChangeLog, Model model) {
		model.addAttribute("smsPassageChangeLog", smsPassageChangeLog);
		return "modules/sms/PassageChangeLogForm";
	}

	/**
	 * 保存通道变更日志
	 */
	@PreAuthorize("hasAuthority('sms:smsPassageChangeLog:edit')")
	@PostMapping(value = "save")
	public @ResponseBody String save(@Validated SmsPassageChangeLog smsPassageChangeLog) {
		smsPassageChangeLogService.saveOrUpdate(smsPassageChangeLog);
		return renderResult(Global.TRUE, "保存成功！");
	}
	
}