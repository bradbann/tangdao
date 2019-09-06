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
import org.tangdao.modules.sms.model.domain.SmsMobileWhitelist;
import org.tangdao.modules.sms.service.ISmsMobileWhiteListService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 手机白名单信息表Controller
 * @author ruyang
 * @version 2019-09-06
 */
@Controller
@RequestMapping(value = "${adminPath}/sms/MobileWhitelist")
public class SmsMobileWhitelistController extends BaseController {

	@Autowired
	private ISmsMobileWhiteListService smsMobileWhitelistService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SmsMobileWhitelist get(String id, boolean isNewRecord) {
		return smsMobileWhitelistService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@PreAuthorize("hasAuthority('sms:smsMobileWhitelist:view')")
	@RequestMapping(value = {"list", ""})
	public String list(SmsMobileWhitelist smsMobileWhitelist, Model model) {
		model.addAttribute("smsMobileWhitelist", smsMobileWhitelist);
		return "modules/sms/MobileWhitelistList";
	}
	
	/**
	 * 查询列表数据
	 */
	@PreAuthorize("hasAuthority('sms:smsMobileWhitelist:view')")
	@RequestMapping(value = "listData")
	public @ResponseBody IPage<SmsMobileWhitelist> listData(SmsMobileWhitelist smsMobileWhitelist, HttpServletRequest request, HttpServletResponse response) {
		QueryWrapper<SmsMobileWhitelist> queryWrapper = new QueryWrapper<SmsMobileWhitelist>();
		return smsMobileWhitelistService.page(smsMobileWhitelist.getPage(), queryWrapper);
	}

	/**
	 * 查看编辑表单
	 */
	@PreAuthorize("hasAuthority('sms:smsMobileWhitelist:view')")
	@RequestMapping(value = "form")
	public String form(SmsMobileWhitelist smsMobileWhitelist, Model model) {
		model.addAttribute("smsMobileWhitelist", smsMobileWhitelist);
		return "modules/sms/MobileWhitelistForm";
	}

	/**
	 * 保存手机白名单信息表
	 */
	@PreAuthorize("hasAuthority('sms:smsMobileWhitelist:edit')")
	@PostMapping(value = "save")
	public @ResponseBody String save(@Validated SmsMobileWhitelist smsMobileWhitelist) {
		smsMobileWhitelistService.saveOrUpdate(smsMobileWhitelist);
		return renderResult(Global.TRUE, "保存成功！");
	}
	
	/**
	 * 删除手机白名单信息表
	 */
	@PreAuthorize("hasAuthority('sms:smsMobileWhitelist:edit')")
	@RequestMapping(value = "delete")
	public @ResponseBody String delete(SmsMobileWhitelist smsMobileWhitelist) {
		smsMobileWhitelistService.deleteById(smsMobileWhitelist);
		return renderResult(Global.TRUE, "删除成功！");
	}
	
}