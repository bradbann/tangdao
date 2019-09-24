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
//import org.tangdao.modules.sms.model.domain.SmsPassageAccess;
//import org.tangdao.modules.sms.service.ISmsPassageAccessService;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//
///**
// * 通道资产Controller
// * @author ruyang
// * @version 2019-09-06
// */
//@Controller
//@RequestMapping(value = "${adminPath}/sms/PassageAccess")
//public class SmsPassageAccessController extends BaseController {
//
//	@Autowired
//	private ISmsPassageAccessService smsPassageAccessService;
//	
//	/**
//	 * 获取数据
//	 */
//	@ModelAttribute
//	public SmsPassageAccess get(String id, boolean isNewRecord) {
//		return smsPassageAccessService.get(id, isNewRecord);
//	}
//	
//	/**
//	 * 查询列表
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageAccess:view')")
//	@RequestMapping(value = {"list", ""})
//	public String list(SmsPassageAccess smsPassageAccess, Model model) {
//		model.addAttribute("smsPassageAccess", smsPassageAccess);
//		return "modules/sms/PassageAccessList";
//	}
//	
//	/**
//	 * 查询列表数据
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageAccess:view')")
//	@RequestMapping(value = "listData")
//	public @ResponseBody IPage<SmsPassageAccess> listData(SmsPassageAccess smsPassageAccess, HttpServletRequest request, HttpServletResponse response) {
//		QueryWrapper<SmsPassageAccess> queryWrapper = new QueryWrapper<SmsPassageAccess>();
//		return smsPassageAccessService.page(smsPassageAccess.getPage(), queryWrapper);
//	}
//
//	/**
//	 * 查看编辑表单
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageAccess:view')")
//	@RequestMapping(value = "form")
//	public String form(SmsPassageAccess smsPassageAccess, Model model) {
//		model.addAttribute("smsPassageAccess", smsPassageAccess);
//		return "modules/sms/PassageAccessForm";
//	}
//
//	/**
//	 * 保存通道资产
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageAccess:edit')")
//	@PostMapping(value = "save")
//	public @ResponseBody String save(@Validated SmsPassageAccess smsPassageAccess) {
//		smsPassageAccessService.saveOrUpdate(smsPassageAccess);
//		return renderResult(Global.TRUE, "保存成功！");
//	}
//	
//	/**
//	 * 停用通道资产
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageAccess:edit')")
//	@RequestMapping(value = "disable")
//	public @ResponseBody String disable(SmsPassageAccess smsPassageAccess) {
//		smsPassageAccess.setStatus(SmsPassageAccess.STATUS_DISABLE);
//		smsPassageAccessService.updateById(smsPassageAccess);
//		return renderResult(Global.TRUE, "停用成功");
//	}
//	
//	/**
//	 * 启用通道资产
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageAccess:edit')")
//	@RequestMapping(value = "enable")
//	public @ResponseBody String enable(SmsPassageAccess smsPassageAccess) {
//		smsPassageAccess.setStatus(SmsPassageAccess.STATUS_NORMAL);
//		smsPassageAccessService.updateById(smsPassageAccess);
//		return renderResult(Global.TRUE, "启用成功");
//	}
//	
//	/**
//	 * 删除通道资产
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageAccess:edit')")
//	@RequestMapping(value = "delete")
//	public @ResponseBody String delete(SmsPassageAccess smsPassageAccess) {
//		smsPassageAccessService.deleteById(smsPassageAccess);
//		return renderResult(Global.TRUE, "删除成功！");
//	}
//	
//}