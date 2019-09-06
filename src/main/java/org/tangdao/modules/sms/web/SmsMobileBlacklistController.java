package org.tangdao.modules.sms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tangdao.common.config.Global;
import org.tangdao.common.suports.BaseController;
import org.tangdao.modules.sms.model.domain.SmsMobileBlacklist;
import org.tangdao.modules.sms.service.ISmsMobileBlackListService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 手机黑名单信息表Controller
 * @author ruyang
 * @version 2019-09-06
 */
@Controller
@RequestMapping(value = "${adminPath}/sms/MobileBlacklist")
public class SmsMobileBlacklistController extends BaseController {

	@Autowired
	private ISmsMobileBlackListService smsMobileBlacklistService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SmsMobileBlacklist get(String id, boolean isNewRecord) {
		return smsMobileBlacklistService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@PreAuthorize("hasAuthority('sms:smsMobileBlacklist:view')")
	@RequestMapping(value = {"list", ""})
	public String list(SmsMobileBlacklist smsMobileBlacklist, Model model) {
		model.addAttribute("smsMobileBlacklist", smsMobileBlacklist);
		return "modules/sms/MobileBlacklistList";
	}
	
	/**
	 * 查询列表数据
	 */
	@PreAuthorize("hasAuthority('sms:smsMobileBlacklist:view')")
	@RequestMapping(value = "listData")
	public @ResponseBody IPage<SmsMobileBlacklist> listData(SmsMobileBlacklist smsMobileBlacklist, HttpServletRequest request, HttpServletResponse response) {
		QueryWrapper<SmsMobileBlacklist> queryWrapper = new QueryWrapper<SmsMobileBlacklist>();
		return smsMobileBlacklistService.page(smsMobileBlacklist.getPage(), queryWrapper);
	}

	/**
	 * 查看编辑表单
	 */
	@PreAuthorize("hasAuthority('sms:smsMobileBlacklist:view')")
	@RequestMapping(value = "form")
	public String form(SmsMobileBlacklist smsMobileBlacklist, Model model) {
		model.addAttribute("smsMobileBlacklist", smsMobileBlacklist);
		return "modules/sms/MobileBlacklistForm";
	}

	/**
	 * 保存手机黑名单信息表
	 */
	@PreAuthorize("hasAuthority('sms:smsMobileBlacklist:edit')")
	@PostMapping(value = "save")
	public @ResponseBody String save(@Validated SmsMobileBlacklist smsMobileBlacklist) {
		smsMobileBlacklistService.saveOrUpdate(smsMobileBlacklist);
		return renderResult(Global.TRUE, "保存成功！");
	}
	
	/**
	 * 停用手机黑名单信息表
	 */
	@PreAuthorize("hasAuthority('sms:smsMobileBlacklist:edit')")
	@RequestMapping(value = "disable")
	public @ResponseBody String disable(SmsMobileBlacklist smsMobileBlacklist) {
		smsMobileBlacklist.setStatus(SmsMobileBlacklist.STATUS_DISABLE);
		smsMobileBlacklistService.updateById(smsMobileBlacklist);
		return renderResult(Global.TRUE, "停用成功");
	}
	
	/**
	 * 启用手机黑名单信息表
	 */
	@PreAuthorize("hasAuthority('sms:smsMobileBlacklist:edit')")
	@RequestMapping(value = "enable")
	public @ResponseBody String enable(SmsMobileBlacklist smsMobileBlacklist) {
		smsMobileBlacklist.setStatus(SmsMobileBlacklist.STATUS_NORMAL);
		smsMobileBlacklistService.updateById(smsMobileBlacklist);
		return renderResult(Global.TRUE, "启用成功");
	}
	
	/**
	 * 删除手机黑名单信息表
	 */
	@PreAuthorize("hasAuthority('sms:smsMobileBlacklist:edit')")
	@RequestMapping(value = "delete")
	public @ResponseBody String delete(SmsMobileBlacklist smsMobileBlacklist) {
		smsMobileBlacklistService.deleteById(smsMobileBlacklist);
		return renderResult(Global.TRUE, "删除成功！");
	}
	
}