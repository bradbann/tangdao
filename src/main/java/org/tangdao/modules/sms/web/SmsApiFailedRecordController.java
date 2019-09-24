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
//import org.tangdao.modules.sms.model.domain.SmsApiFailedRecord;
//import org.tangdao.modules.sms.service.ISmsApiFailedRecordService;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//
///**
// * 下行失败短信Controller
// * @author ruyang
// * @version 2019-09-06
// */
//@Controller
//@RequestMapping(value = "${adminPath}/sms/ApiFailedRecord")
//public class SmsApiFailedRecordController extends BaseController {
//
//	@Autowired
//	private ISmsApiFailedRecordService smsApiFailedRecordService;
//	
//	/**
//	 * 获取数据
//	 */
//	@ModelAttribute
//	public SmsApiFailedRecord get(String id, boolean isNewRecord) {
//		return smsApiFailedRecordService.get(id, isNewRecord);
//	}
//	
//	/**
//	 * 查询列表
//	 */
//	@PreAuthorize("hasAuthority('sms:smsApiFailedRecord:view')")
//	@RequestMapping(value = {"list", ""})
//	public String list(SmsApiFailedRecord smsApiFailedRecord, Model model) {
//		model.addAttribute("smsApiFailedRecord", smsApiFailedRecord);
//		return "modules/sms/ApiFailedRecordList";
//	}
//	
//	/**
//	 * 查询列表数据
//	 */
//	@PreAuthorize("hasAuthority('sms:smsApiFailedRecord:view')")
//	@RequestMapping(value = "listData")
//	public @ResponseBody IPage<SmsApiFailedRecord> listData(SmsApiFailedRecord smsApiFailedRecord, HttpServletRequest request, HttpServletResponse response) {
//		QueryWrapper<SmsApiFailedRecord> queryWrapper = new QueryWrapper<SmsApiFailedRecord>();
//		return smsApiFailedRecordService.page(smsApiFailedRecord.getPage(), queryWrapper);
//	}
//
//	/**
//	 * 查看编辑表单
//	 */
//	@PreAuthorize("hasAuthority('sms:smsApiFailedRecord:view')")
//	@RequestMapping(value = "form")
//	public String form(SmsApiFailedRecord smsApiFailedRecord, Model model) {
//		model.addAttribute("smsApiFailedRecord", smsApiFailedRecord);
//		return "modules/sms/ApiFailedRecordForm";
//	}
//
//	/**
//	 * 保存下行失败短信
//	 */
//	@PreAuthorize("hasAuthority('sms:smsApiFailedRecord:edit')")
//	@PostMapping(value = "save")
//	public @ResponseBody String save(@Validated SmsApiFailedRecord smsApiFailedRecord) {
//		smsApiFailedRecordService.saveOrUpdate(smsApiFailedRecord);
//		return renderResult(Global.TRUE, "保存成功！");
//	}
//	
//}