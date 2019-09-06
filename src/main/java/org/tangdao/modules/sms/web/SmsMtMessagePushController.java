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
import org.tangdao.modules.sms.model.domain.SmsMtMessagePush;
import org.tangdao.modules.sms.service.ISmsMtPushService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 下行短信推送Controller
 * @author ruyang
 * @version 2019-09-06
 */
@Controller
@RequestMapping(value = "${adminPath}/sms/MtMessagePush")
public class SmsMtMessagePushController extends BaseController {

	@Autowired
	private ISmsMtPushService smsMtMessagePushService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SmsMtMessagePush get(String id, boolean isNewRecord) {
		return smsMtMessagePushService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@PreAuthorize("hasAuthority('sms:smsMtMessagePush:view')")
	@RequestMapping(value = {"list", ""})
	public String list(SmsMtMessagePush smsMtMessagePush, Model model) {
		model.addAttribute("smsMtMessagePush", smsMtMessagePush);
		return "modules/sms/MtMessagePushList";
	}
	
	/**
	 * 查询列表数据
	 */
	@PreAuthorize("hasAuthority('sms:smsMtMessagePush:view')")
	@RequestMapping(value = "listData")
	public @ResponseBody IPage<SmsMtMessagePush> listData(SmsMtMessagePush smsMtMessagePush, HttpServletRequest request, HttpServletResponse response) {
		QueryWrapper<SmsMtMessagePush> queryWrapper = new QueryWrapper<SmsMtMessagePush>();
		return smsMtMessagePushService.page(smsMtMessagePush.getPage(), queryWrapper);
	}

	/**
	 * 查看编辑表单
	 */
	@PreAuthorize("hasAuthority('sms:smsMtMessagePush:view')")
	@RequestMapping(value = "form")
	public String form(SmsMtMessagePush smsMtMessagePush, Model model) {
		model.addAttribute("smsMtMessagePush", smsMtMessagePush);
		return "modules/sms/MtMessagePushForm";
	}

	/**
	 * 保存下行短信推送
	 */
	@PreAuthorize("hasAuthority('sms:smsMtMessagePush:edit')")
	@PostMapping(value = "save")
	public @ResponseBody String save(@Validated SmsMtMessagePush smsMtMessagePush) {
		smsMtMessagePushService.saveOrUpdate(smsMtMessagePush);
		return renderResult(Global.TRUE, "保存成功！");
	}
	
	/**
	 * 停用下行短信推送
	 */
	@PreAuthorize("hasAuthority('sms:smsMtMessagePush:edit')")
	@RequestMapping(value = "disable")
	public @ResponseBody String disable(SmsMtMessagePush smsMtMessagePush) {
		smsMtMessagePush.setStatus(SmsMtMessagePush.STATUS_DISABLE);
		smsMtMessagePushService.updateById(smsMtMessagePush);
		return renderResult(Global.TRUE, "停用成功");
	}
	
	/**
	 * 启用下行短信推送
	 */
	@PreAuthorize("hasAuthority('sms:smsMtMessagePush:edit')")
	@RequestMapping(value = "enable")
	public @ResponseBody String enable(SmsMtMessagePush smsMtMessagePush) {
		smsMtMessagePush.setStatus(SmsMtMessagePush.STATUS_NORMAL);
		smsMtMessagePushService.updateById(smsMtMessagePush);
		return renderResult(Global.TRUE, "启用成功");
	}
	
	/**
	 * 删除下行短信推送
	 */
	@PreAuthorize("hasAuthority('sms:smsMtMessagePush:edit')")
	@RequestMapping(value = "delete")
	public @ResponseBody String delete(SmsMtMessagePush smsMtMessagePush) {
		smsMtMessagePushService.deleteById(smsMtMessagePush);
		return renderResult(Global.TRUE, "删除成功！");
	}
	
}