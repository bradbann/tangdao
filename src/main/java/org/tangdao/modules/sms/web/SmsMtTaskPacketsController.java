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
//import org.tangdao.modules.sms.model.domain.SmsMtTaskPackets;
//import org.tangdao.modules.sms.service.ISmsMtTaskPacketsService;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//
///**
// * 下行短信任务分包Controller
// * @author ruyang
// * @version 2019-09-06
// */
//@Controller
//@RequestMapping(value = "${adminPath}/sms/MtTaskPackets")
//public class SmsMtTaskPacketsController extends BaseController {
//
//	@Autowired
//	private ISmsMtTaskPacketsService smsMtTaskPacketsService;
//	
//	/**
//	 * 获取数据
//	 */
//	@ModelAttribute
//	public SmsMtTaskPackets get(String id, boolean isNewRecord) {
//		return smsMtTaskPacketsService.get(id, isNewRecord);
//	}
//	
//	/**
//	 * 查询列表
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtTaskPackets:view')")
//	@RequestMapping(value = {"list", ""})
//	public String list(SmsMtTaskPackets smsMtTaskPackets, Model model) {
//		model.addAttribute("smsMtTaskPackets", smsMtTaskPackets);
//		return "modules/sms/MtTaskPacketsList";
//	}
//	
//	/**
//	 * 查询列表数据
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtTaskPackets:view')")
//	@RequestMapping(value = "listData")
//	public @ResponseBody IPage<SmsMtTaskPackets> listData(SmsMtTaskPackets smsMtTaskPackets, HttpServletRequest request, HttpServletResponse response) {
//		QueryWrapper<SmsMtTaskPackets> queryWrapper = new QueryWrapper<SmsMtTaskPackets>();
//		return smsMtTaskPacketsService.page(smsMtTaskPackets.getPage(), queryWrapper);
//	}
//
//	/**
//	 * 查看编辑表单
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtTaskPackets:view')")
//	@RequestMapping(value = "form")
//	public String form(SmsMtTaskPackets smsMtTaskPackets, Model model) {
//		model.addAttribute("smsMtTaskPackets", smsMtTaskPackets);
//		return "modules/sms/MtTaskPacketsForm";
//	}
//
//	/**
//	 * 保存下行短信任务分包
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtTaskPackets:edit')")
//	@PostMapping(value = "save")
//	public @ResponseBody String save(@Validated SmsMtTaskPackets smsMtTaskPackets) {
//		smsMtTaskPacketsService.saveOrUpdate(smsMtTaskPackets);
//		return renderResult(Global.TRUE, "保存成功！");
//	}
//	
//	/**
//	 * 停用下行短信任务分包
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtTaskPackets:edit')")
//	@RequestMapping(value = "disable")
//	public @ResponseBody String disable(SmsMtTaskPackets smsMtTaskPackets) {
//		smsMtTaskPackets.setStatus(SmsMtTaskPackets.STATUS_DISABLE);
//		smsMtTaskPacketsService.updateById(smsMtTaskPackets);
//		return renderResult(Global.TRUE, "停用成功");
//	}
//	
//	/**
//	 * 启用下行短信任务分包
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtTaskPackets:edit')")
//	@RequestMapping(value = "enable")
//	public @ResponseBody String enable(SmsMtTaskPackets smsMtTaskPackets) {
//		smsMtTaskPackets.setStatus(SmsMtTaskPackets.STATUS_NORMAL);
//		smsMtTaskPacketsService.updateById(smsMtTaskPackets);
//		return renderResult(Global.TRUE, "启用成功");
//	}
//	
//	/**
//	 * 删除下行短信任务分包
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtTaskPackets:edit')")
//	@RequestMapping(value = "delete")
//	public @ResponseBody String delete(SmsMtTaskPackets smsMtTaskPackets) {
//		smsMtTaskPacketsService.deleteById(smsMtTaskPackets);
//		return renderResult(Global.TRUE, "删除成功！");
//	}
//	
//}