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
//import org.tangdao.modules.sms.model.domain.SmsMoMessagePush;
//import org.tangdao.modules.sms.service.ISmsMoPushService;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//
///**
// * 上行消息推送Controller
// * @author ruyang
// * @version 2019-09-06
// */
//@Controller
//@RequestMapping(value = "${adminPath}/sms/MoMessagePush")
//public class SmsMoMessagePushController extends BaseController {
//
//	@Autowired
//	private ISmsMoPushService smsMoMessagePushService;
//	
//	/**
//	 * 获取数据
//	 */
//	@ModelAttribute
//	public SmsMoMessagePush get(String id, boolean isNewRecord) {
//		return smsMoMessagePushService.get(id, isNewRecord);
//	}
//	
//	/**
//	 * 查询列表
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMoMessagePush:view')")
//	@RequestMapping(value = {"list", ""})
//	public String list(SmsMoMessagePush smsMoMessagePush, Model model) {
//		model.addAttribute("smsMoMessagePush", smsMoMessagePush);
//		return "modules/sms/MoMessagePushList";
//	}
//	
//	/**
//	 * 查询列表数据
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMoMessagePush:view')")
//	@RequestMapping(value = "listData")
//	public @ResponseBody IPage<SmsMoMessagePush> listData(SmsMoMessagePush smsMoMessagePush, HttpServletRequest request, HttpServletResponse response) {
//		QueryWrapper<SmsMoMessagePush> queryWrapper = new QueryWrapper<SmsMoMessagePush>();
//		return smsMoMessagePushService.page(smsMoMessagePush.getPage(), queryWrapper);
//	}
//
//	/**
//	 * 查看编辑表单
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMoMessagePush:view')")
//	@RequestMapping(value = "form")
//	public String form(SmsMoMessagePush smsMoMessagePush, Model model) {
//		model.addAttribute("smsMoMessagePush", smsMoMessagePush);
//		return "modules/sms/MoMessagePushForm";
//	}
//
//	/**
//	 * 保存上行消息推送
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMoMessagePush:edit')")
//	@PostMapping(value = "save")
//	public @ResponseBody String save(@Validated SmsMoMessagePush smsMoMessagePush) {
//		smsMoMessagePushService.saveOrUpdate(smsMoMessagePush);
//		return renderResult(Global.TRUE, "保存成功！");
//	}
//	
//}