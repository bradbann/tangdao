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
//import org.tangdao.modules.sms.model.domain.SmsPassageArea;
//import org.tangdao.modules.sms.service.ISmsPassageAreaService;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//
///**
// * 通道支持省份Controller
// * @author ruyang
// * @version 2019-09-06
// */
//@Controller
//@RequestMapping(value = "${adminPath}/sms/PassageProvince")
//public class SmsPassageProvinceController extends BaseController {
//
//	@Autowired
//	private ISmsPassageAreaService smsPassageProvinceService;
//	
//	/**
//	 * 获取数据
//	 */
//	@ModelAttribute
//	public SmsPassageArea get(String id, boolean isNewRecord) {
//		return smsPassageProvinceService.get(id, isNewRecord);
//	}
//	
//	/**
//	 * 查询列表
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageProvince:view')")
//	@RequestMapping(value = {"list", ""})
//	public String list(SmsPassageArea smsPassageProvince, Model model) {
//		model.addAttribute("smsPassageProvince", smsPassageProvince);
//		return "modules/sms/PassageProvinceList";
//	}
//	
//	/**
//	 * 查询列表数据
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageProvince:view')")
//	@RequestMapping(value = "listData")
//	public @ResponseBody IPage<SmsPassageArea> listData(SmsPassageArea smsPassageProvince, HttpServletRequest request, HttpServletResponse response) {
//		QueryWrapper<SmsPassageArea> queryWrapper = new QueryWrapper<SmsPassageArea>();
//		return smsPassageProvinceService.page(smsPassageProvince.getPage(), queryWrapper);
//	}
//
//	/**
//	 * 查看编辑表单
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageProvince:view')")
//	@RequestMapping(value = "form")
//	public String form(SmsPassageArea smsPassageProvince, Model model) {
//		model.addAttribute("smsPassageProvince", smsPassageProvince);
//		return "modules/sms/PassageProvinceForm";
//	}
//
//	/**
//	 * 保存通道支持省份
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageProvince:edit')")
//	@PostMapping(value = "save")
//	public @ResponseBody String save(@Validated SmsPassageArea smsPassageProvince) {
//		smsPassageProvinceService.saveOrUpdate(smsPassageProvince);
//		return renderResult(Global.TRUE, "保存成功！");
//	}
//	
//	/**
//	 * 删除通道支持省份
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageProvince:edit')")
//	@RequestMapping(value = "delete")
//	public @ResponseBody String delete(SmsPassageArea smsPassageProvince) {
//		smsPassageProvinceService.deleteById(smsPassageProvince);
//		return renderResult(Global.TRUE, "删除成功！");
//	}
//	
//}