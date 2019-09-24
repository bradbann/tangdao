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
//import org.tangdao.modules.sms.model.domain.SmsPassageControl;
//import org.tangdao.modules.sms.service.ISmsPassageControlService;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//
///**
// * 通道控制Controller
// * @author ruyang
// * @version 2019-09-06
// */
//@Controller
//@RequestMapping(value = "${adminPath}/sms/PassageControl")
//public class SmsPassageControlController extends BaseController {
//
//	@Autowired
//	private ISmsPassageControlService smsPassageControlService;
//	
//	/**
//	 * 获取数据
//	 */
//	@ModelAttribute
//	public SmsPassageControl get(String id, boolean isNewRecord) {
//		return smsPassageControlService.get(id, isNewRecord);
//	}
//	
//	/**
//	 * 查询列表
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageControl:view')")
//	@RequestMapping(value = {"list", ""})
//	public String list(SmsPassageControl smsPassageControl, Model model) {
//		model.addAttribute("smsPassageControl", smsPassageControl);
//		return "modules/sms/PassageControlList";
//	}
//	
//	/**
//	 * 查询列表数据
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageControl:view')")
//	@RequestMapping(value = "listData")
//	public @ResponseBody IPage<SmsPassageControl> listData(SmsPassageControl smsPassageControl, HttpServletRequest request, HttpServletResponse response) {
//		QueryWrapper<SmsPassageControl> queryWrapper = new QueryWrapper<SmsPassageControl>();
//		return smsPassageControlService.page(smsPassageControl.getPage(), queryWrapper);
//	}
//
//	/**
//	 * 查看编辑表单
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageControl:view')")
//	@RequestMapping(value = "form")
//	public String form(SmsPassageControl smsPassageControl, Model model) {
//		model.addAttribute("smsPassageControl", smsPassageControl);
//		return "modules/sms/PassageControlForm";
//	}
//
//	/**
//	 * 保存通道控制
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageControl:edit')")
//	@PostMapping(value = "save")
//	public @ResponseBody String save(@Validated SmsPassageControl smsPassageControl) {
//		smsPassageControlService.saveOrUpdate(smsPassageControl);
//		return renderResult(Global.TRUE, "保存成功！");
//	}
//	
//	/**
//	 * 停用通道控制
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageControl:edit')")
//	@RequestMapping(value = "disable")
//	public @ResponseBody String disable(SmsPassageControl smsPassageControl) {
//		smsPassageControl.setStatus(SmsPassageControl.STATUS_DISABLE);
//		smsPassageControlService.updateById(smsPassageControl);
//		return renderResult(Global.TRUE, "停用成功");
//	}
//	
//	/**
//	 * 启用通道控制
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageControl:edit')")
//	@RequestMapping(value = "enable")
//	public @ResponseBody String enable(SmsPassageControl smsPassageControl) {
//		smsPassageControl.setStatus(SmsPassageControl.STATUS_NORMAL);
//		smsPassageControlService.updateById(smsPassageControl);
//		return renderResult(Global.TRUE, "启用成功");
//	}
//	
//	/**
//	 * 删除通道控制
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageControl:edit')")
//	@RequestMapping(value = "delete")
//	public @ResponseBody String delete(SmsPassageControl smsPassageControl) {
//		smsPassageControlService.deleteById(smsPassageControl);
//		return renderResult(Global.TRUE, "删除成功！");
//	}
//	
//}