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
import org.tangdao.modules.sms.model.domain.SmsMoMessageReceive;
import org.tangdao.modules.sms.service.ISmsMoReceiveService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 上行消息回复Controller
 * @author ruyang
 * @version 2019-09-06
 */
@Controller
@RequestMapping(value = "${adminPath}/sms/MoMessageReceive")
public class SmsMoMessageReceiveController extends BaseController {

	@Autowired
	private ISmsMoReceiveService smsMoMessageReceiveService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SmsMoMessageReceive get(String id, boolean isNewRecord) {
		return smsMoMessageReceiveService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@PreAuthorize("hasAuthority('sms:smsMoMessageReceive:view')")
	@RequestMapping(value = {"list", ""})
	public String list(SmsMoMessageReceive smsMoMessageReceive, Model model) {
		model.addAttribute("smsMoMessageReceive", smsMoMessageReceive);
		return "modules/sms/MoMessageReceiveList";
	}
	
	/**
	 * 查询列表数据
	 */
	@PreAuthorize("hasAuthority('sms:smsMoMessageReceive:view')")
	@RequestMapping(value = "listData")
	public @ResponseBody IPage<SmsMoMessageReceive> listData(SmsMoMessageReceive smsMoMessageReceive, HttpServletRequest request, HttpServletResponse response) {
		QueryWrapper<SmsMoMessageReceive> queryWrapper = new QueryWrapper<SmsMoMessageReceive>();
		return smsMoMessageReceiveService.page(smsMoMessageReceive.getPage(), queryWrapper);
	}

	/**
	 * 查看编辑表单
	 */
	@PreAuthorize("hasAuthority('sms:smsMoMessageReceive:view')")
	@RequestMapping(value = "form")
	public String form(SmsMoMessageReceive smsMoMessageReceive, Model model) {
		model.addAttribute("smsMoMessageReceive", smsMoMessageReceive);
		return "modules/sms/MoMessageReceiveForm";
	}

	/**
	 * 保存上行消息回复
	 */
	@PreAuthorize("hasAuthority('sms:smsMoMessageReceive:edit')")
	@PostMapping(value = "save")
	public @ResponseBody String save(@Validated SmsMoMessageReceive smsMoMessageReceive) {
		smsMoMessageReceiveService.saveOrUpdate(smsMoMessageReceive);
		return renderResult(Global.TRUE, "保存成功！");
	}
	
}