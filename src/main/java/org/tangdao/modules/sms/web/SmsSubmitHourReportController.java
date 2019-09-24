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
//import org.tangdao.modules.sms.model.domain.SmsSubmitHourReport;
//import org.tangdao.modules.sms.service.ISmsSubmitHourReportService;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//
///**
// * 提交报告（小时）Controller
// * @author ruyang
// * @version 2019-09-06
// */
//@Controller
//@RequestMapping(value = "${adminPath}/sms/SubmitHourReport")
//public class SmsSubmitHourReportController extends BaseController {
//
//	@Autowired
//	private ISmsSubmitHourReportService smsSubmitHourReportService;
//	
//	/**
//	 * 获取数据
//	 */
//	@ModelAttribute
//	public SmsSubmitHourReport get(String id, boolean isNewRecord) {
//		return smsSubmitHourReportService.get(id, isNewRecord);
//	}
//	
//	/**
//	 * 查询列表
//	 */
//	@PreAuthorize("hasAuthority('sms:smsSubmitHourReport:view')")
//	@RequestMapping(value = {"list", ""})
//	public String list(SmsSubmitHourReport smsSubmitHourReport, Model model) {
//		model.addAttribute("smsSubmitHourReport", smsSubmitHourReport);
//		return "modules/sms/SubmitHourReportList";
//	}
//	
//	/**
//	 * 查询列表数据
//	 */
//	@PreAuthorize("hasAuthority('sms:smsSubmitHourReport:view')")
//	@RequestMapping(value = "listData")
//	public @ResponseBody IPage<SmsSubmitHourReport> listData(SmsSubmitHourReport smsSubmitHourReport, HttpServletRequest request, HttpServletResponse response) {
//		QueryWrapper<SmsSubmitHourReport> queryWrapper = new QueryWrapper<SmsSubmitHourReport>();
//		return smsSubmitHourReportService.page(smsSubmitHourReport.getPage(), queryWrapper);
//	}
//
//	/**
//	 * 查看编辑表单
//	 */
//	@PreAuthorize("hasAuthority('sms:smsSubmitHourReport:view')")
//	@RequestMapping(value = "form")
//	public String form(SmsSubmitHourReport smsSubmitHourReport, Model model) {
//		model.addAttribute("smsSubmitHourReport", smsSubmitHourReport);
//		return "modules/sms/SubmitHourReportForm";
//	}
//
//	/**
//	 * 保存提交报告（小时）
//	 */
//	@PreAuthorize("hasAuthority('sms:smsSubmitHourReport:edit')")
//	@PostMapping(value = "save")
//	public @ResponseBody String save(@Validated SmsSubmitHourReport smsSubmitHourReport) {
//		smsSubmitHourReportService.saveOrUpdate(smsSubmitHourReport);
//		return renderResult(Global.TRUE, "保存成功！");
//	}
//	
//	/**
//	 * 停用提交报告（小时）
//	 */
//	@PreAuthorize("hasAuthority('sms:smsSubmitHourReport:edit')")
//	@RequestMapping(value = "disable")
//	public @ResponseBody String disable(SmsSubmitHourReport smsSubmitHourReport) {
//		smsSubmitHourReport.setStatus(SmsSubmitHourReport.STATUS_DISABLE);
//		smsSubmitHourReportService.updateById(smsSubmitHourReport);
//		return renderResult(Global.TRUE, "停用成功");
//	}
//	
//	/**
//	 * 启用提交报告（小时）
//	 */
//	@PreAuthorize("hasAuthority('sms:smsSubmitHourReport:edit')")
//	@RequestMapping(value = "enable")
//	public @ResponseBody String enable(SmsSubmitHourReport smsSubmitHourReport) {
//		smsSubmitHourReport.setStatus(SmsSubmitHourReport.STATUS_NORMAL);
//		smsSubmitHourReportService.updateById(smsSubmitHourReport);
//		return renderResult(Global.TRUE, "启用成功");
//	}
//	
//	/**
//	 * 删除提交报告（小时）
//	 */
//	@PreAuthorize("hasAuthority('sms:smsSubmitHourReport:edit')")
//	@RequestMapping(value = "delete")
//	public @ResponseBody String delete(SmsSubmitHourReport smsSubmitHourReport) {
//		smsSubmitHourReportService.deleteById(smsSubmitHourReport);
//		return renderResult(Global.TRUE, "删除成功！");
//	}
//	
//}