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
//import org.tangdao.modules.sms.model.domain.SmsPassageGroupDetail;
//import org.tangdao.modules.sms.service.ISmsPassageGroupDetailService;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//
///**
// * 通道组内容Controller
// * @author ruyang
// * @version 2019-09-06
// */
//@Controller
//@RequestMapping(value = "${adminPath}/sms/PassageGroupDetail")
//public class SmsPassageGroupDetailController extends BaseController {
//
//	@Autowired
//	private ISmsPassageGroupDetailService smsPassageGroupDetailService;
//	
//	/**
//	 * 获取数据
//	 */
//	@ModelAttribute
//	public SmsPassageGroupDetail get(String id, boolean isNewRecord) {
//		return smsPassageGroupDetailService.get(id, isNewRecord);
//	}
//	
//	/**
//	 * 查询列表
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageGroupDetail:view')")
//	@RequestMapping(value = {"list", ""})
//	public String list(SmsPassageGroupDetail smsPassageGroupDetail, Model model) {
//		model.addAttribute("smsPassageGroupDetail", smsPassageGroupDetail);
//		return "modules/sms/PassageGroupDetailList";
//	}
//	
//	/**
//	 * 查询列表数据
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageGroupDetail:view')")
//	@RequestMapping(value = "listData")
//	public @ResponseBody IPage<SmsPassageGroupDetail> listData(SmsPassageGroupDetail smsPassageGroupDetail, HttpServletRequest request, HttpServletResponse response) {
//		QueryWrapper<SmsPassageGroupDetail> queryWrapper = new QueryWrapper<SmsPassageGroupDetail>();
//		return smsPassageGroupDetailService.page(smsPassageGroupDetail.getPage(), queryWrapper);
//	}
//
//	/**
//	 * 查看编辑表单
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageGroupDetail:view')")
//	@RequestMapping(value = "form")
//	public String form(SmsPassageGroupDetail smsPassageGroupDetail, Model model) {
//		model.addAttribute("smsPassageGroupDetail", smsPassageGroupDetail);
//		return "modules/sms/PassageGroupDetailForm";
//	}
//
//	/**
//	 * 保存通道组内容
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageGroupDetail:edit')")
//	@PostMapping(value = "save")
//	public @ResponseBody String save(@Validated SmsPassageGroupDetail smsPassageGroupDetail) {
//		smsPassageGroupDetailService.saveOrUpdate(smsPassageGroupDetail);
//		return renderResult(Global.TRUE, "保存成功！");
//	}
//	
//	/**
//	 * 停用通道组内容
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageGroupDetail:edit')")
//	@RequestMapping(value = "disable")
//	public @ResponseBody String disable(SmsPassageGroupDetail smsPassageGroupDetail) {
//		smsPassageGroupDetail.setStatus(SmsPassageGroupDetail.STATUS_DISABLE);
//		smsPassageGroupDetailService.updateById(smsPassageGroupDetail);
//		return renderResult(Global.TRUE, "停用成功");
//	}
//	
//	/**
//	 * 启用通道组内容
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageGroupDetail:edit')")
//	@RequestMapping(value = "enable")
//	public @ResponseBody String enable(SmsPassageGroupDetail smsPassageGroupDetail) {
//		smsPassageGroupDetail.setStatus(SmsPassageGroupDetail.STATUS_NORMAL);
//		smsPassageGroupDetailService.updateById(smsPassageGroupDetail);
//		return renderResult(Global.TRUE, "启用成功");
//	}
//	
//	/**
//	 * 删除通道组内容
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageGroupDetail:edit')")
//	@RequestMapping(value = "delete")
//	public @ResponseBody String delete(SmsPassageGroupDetail smsPassageGroupDetail) {
//		smsPassageGroupDetailService.deleteById(smsPassageGroupDetail);
//		return renderResult(Global.TRUE, "删除成功！");
//	}
//	
//}