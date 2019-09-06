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
import org.tangdao.modules.sms.model.domain.SmsMtMessageDeliverLog;
import org.tangdao.modules.sms.service.ISmsMtDeliverLogService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 下行短信回执状态日志Controller
 * @author ruyang
 * @version 2019-09-06
 */
@Controller
@RequestMapping(value = "${adminPath}/sms/MtMessageDeliverLog")
public class SmsMtMessageDeliverLogController extends BaseController {

	@Autowired
	private ISmsMtDeliverLogService smsMtMessageDeliverLogService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SmsMtMessageDeliverLog get(String id, boolean isNewRecord) {
		return smsMtMessageDeliverLogService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@PreAuthorize("hasAuthority('sms:smsMtMessageDeliverLog:view')")
	@RequestMapping(value = {"list", ""})
	public String list(SmsMtMessageDeliverLog smsMtMessageDeliverLog, Model model) {
		model.addAttribute("smsMtMessageDeliverLog", smsMtMessageDeliverLog);
		return "modules/sms/MtMessageDeliverLogList";
	}
	
	/**
	 * 查询列表数据
	 */
	@PreAuthorize("hasAuthority('sms:smsMtMessageDeliverLog:view')")
	@RequestMapping(value = "listData")
	public @ResponseBody IPage<SmsMtMessageDeliverLog> listData(SmsMtMessageDeliverLog smsMtMessageDeliverLog, HttpServletRequest request, HttpServletResponse response) {
		QueryWrapper<SmsMtMessageDeliverLog> queryWrapper = new QueryWrapper<SmsMtMessageDeliverLog>();
		return smsMtMessageDeliverLogService.page(smsMtMessageDeliverLog.getPage(), queryWrapper);
	}

	/**
	 * 查看编辑表单
	 */
	@PreAuthorize("hasAuthority('sms:smsMtMessageDeliverLog:view')")
	@RequestMapping(value = "form")
	public String form(SmsMtMessageDeliverLog smsMtMessageDeliverLog, Model model) {
		model.addAttribute("smsMtMessageDeliverLog", smsMtMessageDeliverLog);
		return "modules/sms/MtMessageDeliverLogForm";
	}

	/**
	 * 保存下行短信回执状态日志
	 */
	@PreAuthorize("hasAuthority('sms:smsMtMessageDeliverLog:edit')")
	@PostMapping(value = "save")
	public @ResponseBody String save(@Validated SmsMtMessageDeliverLog smsMtMessageDeliverLog) {
		smsMtMessageDeliverLogService.saveOrUpdate(smsMtMessageDeliverLog);
		return renderResult(Global.TRUE, "保存成功！");
	}
	
}