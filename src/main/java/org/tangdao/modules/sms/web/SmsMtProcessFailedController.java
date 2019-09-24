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
//import org.tangdao.modules.sms.model.domain.SmsMtProcessFailed;
//import org.tangdao.modules.sms.service.ISmsMtProcessFailedService;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//
///**
// * 下行短信处理失败Controller
// * @author ruyang
// * @version 2019-09-06
// */
//@Controller
//@RequestMapping(value = "${adminPath}/sms/MtProcessFailed")
//public class SmsMtProcessFailedController extends BaseController {
//
//	@Autowired
//	private ISmsMtProcessFailedService smsMtProcessFailedService;
//	
//	/**
//	 * 获取数据
//	 */
//	@ModelAttribute
//	public SmsMtProcessFailed get(String id, boolean isNewRecord) {
//		return smsMtProcessFailedService.get(id, isNewRecord);
//	}
//	
//	/**
//	 * 查询列表
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtProcessFailed:view')")
//	@RequestMapping(value = {"list", ""})
//	public String list(SmsMtProcessFailed smsMtProcessFailed, Model model) {
//		model.addAttribute("smsMtProcessFailed", smsMtProcessFailed);
//		return "modules/sms/MtProcessFailedList";
//	}
//	
//	/**
//	 * 查询列表数据
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtProcessFailed:view')")
//	@RequestMapping(value = "listData")
//	public @ResponseBody IPage<SmsMtProcessFailed> listData(SmsMtProcessFailed smsMtProcessFailed, HttpServletRequest request, HttpServletResponse response) {
//		QueryWrapper<SmsMtProcessFailed> queryWrapper = new QueryWrapper<SmsMtProcessFailed>();
//		return smsMtProcessFailedService.page(smsMtProcessFailed.getPage(), queryWrapper);
//	}
//
//	/**
//	 * 查看编辑表单
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtProcessFailed:view')")
//	@RequestMapping(value = "form")
//	public String form(SmsMtProcessFailed smsMtProcessFailed, Model model) {
//		model.addAttribute("smsMtProcessFailed", smsMtProcessFailed);
//		return "modules/sms/MtProcessFailedForm";
//	}
//
//	/**
//	 * 保存下行短信处理失败
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtProcessFailed:edit')")
//	@PostMapping(value = "save")
//	public @ResponseBody String save(@Validated SmsMtProcessFailed smsMtProcessFailed) {
//		smsMtProcessFailedService.saveOrUpdate(smsMtProcessFailed);
//		return renderResult(Global.TRUE, "保存成功！");
//	}
//	
//	/**
//	 * 删除下行短信处理失败
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtProcessFailed:edit')")
//	@RequestMapping(value = "delete")
//	public @ResponseBody String delete(SmsMtProcessFailed smsMtProcessFailed) {
//		smsMtProcessFailedService.deleteById(smsMtProcessFailed);
//		return renderResult(Global.TRUE, "删除成功！");
//	}
//	
//}