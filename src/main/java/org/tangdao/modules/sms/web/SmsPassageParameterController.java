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
//import org.tangdao.modules.sms.model.domain.SmsPassageParameter;
//import org.tangdao.modules.sms.service.ISmsPassageParameterService;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//
///**
// * 通道消息模板参数Controller
// * @author ruyang
// * @version 2019-09-06
// */
//@Controller
//@RequestMapping(value = "${adminPath}/sms/PassageParameter")
//public class SmsPassageParameterController extends BaseController {
//
//	@Autowired
//	private ISmsPassageParameterService smsPassageParameterService;
//	
//	/**
//	 * 获取数据
//	 */
//	@ModelAttribute
//	public SmsPassageParameter get(String id, boolean isNewRecord) {
//		return smsPassageParameterService.get(id, isNewRecord);
//	}
//	
//	/**
//	 * 查询列表
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageParameter:view')")
//	@RequestMapping(value = {"list", ""})
//	public String list(SmsPassageParameter smsPassageParameter, Model model) {
//		model.addAttribute("smsPassageParameter", smsPassageParameter);
//		return "modules/sms/PassageParameterList";
//	}
//	
//	/**
//	 * 查询列表数据
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageParameter:view')")
//	@RequestMapping(value = "listData")
//	public @ResponseBody IPage<SmsPassageParameter> listData(SmsPassageParameter smsPassageParameter, HttpServletRequest request, HttpServletResponse response) {
//		QueryWrapper<SmsPassageParameter> queryWrapper = new QueryWrapper<SmsPassageParameter>();
//		return smsPassageParameterService.page(smsPassageParameter.getPage(), queryWrapper);
//	}
//
//	/**
//	 * 查看编辑表单
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageParameter:view')")
//	@RequestMapping(value = "form")
//	public String form(SmsPassageParameter smsPassageParameter, Model model) {
//		model.addAttribute("smsPassageParameter", smsPassageParameter);
//		return "modules/sms/PassageParameterForm";
//	}
//
//	/**
//	 * 保存通道消息模板参数
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageParameter:edit')")
//	@PostMapping(value = "save")
//	public @ResponseBody String save(@Validated SmsPassageParameter smsPassageParameter) {
//		smsPassageParameterService.saveOrUpdate(smsPassageParameter);
//		return renderResult(Global.TRUE, "保存成功！");
//	}
//	
//	/**
//	 * 停用通道消息模板参数
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageParameter:edit')")
//	@RequestMapping(value = "disable")
//	public @ResponseBody String disable(SmsPassageParameter smsPassageParameter) {
//		smsPassageParameter.setStatus(SmsPassageParameter.STATUS_DISABLE);
//		smsPassageParameterService.updateById(smsPassageParameter);
//		return renderResult(Global.TRUE, "停用成功");
//	}
//	
//	/**
//	 * 启用通道消息模板参数
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageParameter:edit')")
//	@RequestMapping(value = "enable")
//	public @ResponseBody String enable(SmsPassageParameter smsPassageParameter) {
//		smsPassageParameter.setStatus(SmsPassageParameter.STATUS_NORMAL);
//		smsPassageParameterService.updateById(smsPassageParameter);
//		return renderResult(Global.TRUE, "启用成功");
//	}
//	
//	/**
//	 * 删除通道消息模板参数
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageParameter:edit')")
//	@RequestMapping(value = "delete")
//	public @ResponseBody String delete(SmsPassageParameter smsPassageParameter) {
//		smsPassageParameterService.deleteById(smsPassageParameter);
//		return renderResult(Global.TRUE, "删除成功！");
//	}
//	
//}