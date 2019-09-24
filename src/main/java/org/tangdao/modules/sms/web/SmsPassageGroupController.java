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
//import org.tangdao.modules.sms.model.domain.SmsPassageGroup;
//import org.tangdao.modules.sms.service.ISmsPassageGroupService;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//
///**
// * 通道组Controller
// * @author ruyang
// * @version 2019-09-06
// */
//@Controller
//@RequestMapping(value = "${adminPath}/sms/PassageGroup")
//public class SmsPassageGroupController extends BaseController {
//
//	@Autowired
//	private ISmsPassageGroupService smsPassageGroupService;
//	
//	/**
//	 * 获取数据
//	 */
//	@ModelAttribute
//	public SmsPassageGroup get(String id, boolean isNewRecord) {
//		return smsPassageGroupService.get(id, isNewRecord);
//	}
//	
//	/**
//	 * 查询列表
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageGroup:view')")
//	@RequestMapping(value = {"list", ""})
//	public String list(SmsPassageGroup smsPassageGroup, Model model) {
//		model.addAttribute("smsPassageGroup", smsPassageGroup);
//		return "modules/sms/PassageGroupList";
//	}
//	
//	/**
//	 * 查询列表数据
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageGroup:view')")
//	@RequestMapping(value = "listData")
//	public @ResponseBody IPage<SmsPassageGroup> listData(SmsPassageGroup smsPassageGroup, HttpServletRequest request, HttpServletResponse response) {
//		QueryWrapper<SmsPassageGroup> queryWrapper = new QueryWrapper<SmsPassageGroup>();
//		return smsPassageGroupService.page(smsPassageGroup.getPage(), queryWrapper);
//	}
//
//	/**
//	 * 查看编辑表单
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageGroup:view')")
//	@RequestMapping(value = "form")
//	public String form(SmsPassageGroup smsPassageGroup, Model model) {
//		model.addAttribute("smsPassageGroup", smsPassageGroup);
//		return "modules/sms/PassageGroupForm";
//	}
//
//	/**
//	 * 保存通道组
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageGroup:edit')")
//	@PostMapping(value = "save")
//	public @ResponseBody String save(@Validated SmsPassageGroup smsPassageGroup) {
//		smsPassageGroupService.saveOrUpdate(smsPassageGroup);
//		return renderResult(Global.TRUE, "保存成功！");
//	}
//	
//	/**
//	 * 停用通道组
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageGroup:edit')")
//	@RequestMapping(value = "disable")
//	public @ResponseBody String disable(SmsPassageGroup smsPassageGroup) {
//		smsPassageGroup.setStatus(SmsPassageGroup.STATUS_DISABLE);
//		smsPassageGroupService.updateById(smsPassageGroup);
//		return renderResult(Global.TRUE, "停用成功");
//	}
//	
//	/**
//	 * 启用通道组
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageGroup:edit')")
//	@RequestMapping(value = "enable")
//	public @ResponseBody String enable(SmsPassageGroup smsPassageGroup) {
//		smsPassageGroup.setStatus(SmsPassageGroup.STATUS_NORMAL);
//		smsPassageGroupService.updateById(smsPassageGroup);
//		return renderResult(Global.TRUE, "启用成功");
//	}
//	
//	/**
//	 * 删除通道组
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPassageGroup:edit')")
//	@RequestMapping(value = "delete")
//	public @ResponseBody String delete(SmsPassageGroup smsPassageGroup) {
//		smsPassageGroupService.deleteById(smsPassageGroup);
//		return renderResult(Global.TRUE, "删除成功！");
//	}
//	
//}