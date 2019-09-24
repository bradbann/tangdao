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
//import org.tangdao.modules.sms.model.domain.SmsMessageDeliver;
//import org.tangdao.modules.sms.service.ISmsDeliverService;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//
///**
// * 回执推送信息Controller
// * @author ruyang
// * @version 2019-09-06
// */
//@Controller
//@RequestMapping(value = "${adminPath}/sms/MessageDeliver")
//public class SmsMessageDeliverController extends BaseController {
//
//	@Autowired
//	private ISmsDeliverService smsMessageDeliverService;
//	
//	/**
//	 * 获取数据
//	 */
//	@ModelAttribute
//	public SmsMessageDeliver get(String id, boolean isNewRecord) {
//		return smsMessageDeliverService.get(id, isNewRecord);
//	}
//	
//	/**
//	 * 查询列表
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMessageDeliver:view')")
//	@RequestMapping(value = {"list", ""})
//	public String list(SmsMessageDeliver smsMessageDeliver, Model model) {
//		model.addAttribute("smsMessageDeliver", smsMessageDeliver);
//		return "modules/sms/MessageDeliverList";
//	}
//	
//	/**
//	 * 查询列表数据
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMessageDeliver:view')")
//	@RequestMapping(value = "listData")
//	public @ResponseBody IPage<SmsMessageDeliver> listData(SmsMessageDeliver smsMessageDeliver, HttpServletRequest request, HttpServletResponse response) {
//		QueryWrapper<SmsMessageDeliver> queryWrapper = new QueryWrapper<SmsMessageDeliver>();
//		return smsMessageDeliverService.page(smsMessageDeliver.getPage(), queryWrapper);
//	}
//
//	/**
//	 * 查看编辑表单
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMessageDeliver:view')")
//	@RequestMapping(value = "form")
//	public String form(SmsMessageDeliver smsMessageDeliver, Model model) {
//		model.addAttribute("smsMessageDeliver", smsMessageDeliver);
//		return "modules/sms/MessageDeliverForm";
//	}
//
//	/**
//	 * 保存回执推送信息
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMessageDeliver:edit')")
//	@PostMapping(value = "save")
//	public @ResponseBody String save(@Validated SmsMessageDeliver smsMessageDeliver) {
//		smsMessageDeliverService.saveOrUpdate(smsMessageDeliver);
//		return renderResult(Global.TRUE, "保存成功！");
//	}
//	
//	/**
//	 * 停用回执推送信息
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMessageDeliver:edit')")
//	@RequestMapping(value = "disable")
//	public @ResponseBody String disable(SmsMessageDeliver smsMessageDeliver) {
//		smsMessageDeliver.setStatus(SmsMessageDeliver.STATUS_DISABLE);
//		smsMessageDeliverService.updateById(smsMessageDeliver);
//		return renderResult(Global.TRUE, "停用成功");
//	}
//	
//	/**
//	 * 启用回执推送信息
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMessageDeliver:edit')")
//	@RequestMapping(value = "enable")
//	public @ResponseBody String enable(SmsMessageDeliver smsMessageDeliver) {
//		smsMessageDeliver.setStatus(SmsMessageDeliver.STATUS_NORMAL);
//		smsMessageDeliverService.updateById(smsMessageDeliver);
//		return renderResult(Global.TRUE, "启用成功");
//	}
//	
//	/**
//	 * 删除回执推送信息
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMessageDeliver:edit')")
//	@RequestMapping(value = "delete")
//	public @ResponseBody String delete(SmsMessageDeliver smsMessageDeliver) {
//		smsMessageDeliverService.deleteById(smsMessageDeliver);
//		return renderResult(Global.TRUE, "删除成功！");
//	}
//	
//}