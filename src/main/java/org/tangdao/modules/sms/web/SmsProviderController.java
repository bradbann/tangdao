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
import org.tangdao.modules.sms.model.domain.SmsProvider;
import org.tangdao.modules.sms.service.ISmsProviderService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 短信接口提供商Controller
 * @author ruyang
 * @version 2019-09-06
 */
@Controller
@RequestMapping(value = "${adminPath}/sms/Provider")
public class SmsProviderController extends BaseController {

	@Autowired
	private ISmsProviderService smsProviderService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SmsProvider get(String id, boolean isNewRecord) {
		return smsProviderService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@PreAuthorize("hasAuthority('sms:smsProvider:view')")
	@RequestMapping(value = {"list", ""})
	public String list(SmsProvider smsProvider, Model model) {
		model.addAttribute("smsProvider", smsProvider);
		return "modules/sms/ProviderList";
	}
	
	/**
	 * 查询列表数据
	 */
	@PreAuthorize("hasAuthority('sms:smsProvider:view')")
	@RequestMapping(value = "listData")
	public @ResponseBody IPage<SmsProvider> listData(SmsProvider smsProvider, HttpServletRequest request, HttpServletResponse response) {
		QueryWrapper<SmsProvider> queryWrapper = new QueryWrapper<SmsProvider>();
		return smsProviderService.page(smsProvider.getPage(), queryWrapper);
	}

	/**
	 * 查看编辑表单
	 */
	@PreAuthorize("hasAuthority('sms:smsProvider:view')")
	@RequestMapping(value = "form")
	public String form(SmsProvider smsProvider, Model model) {
		model.addAttribute("smsProvider", smsProvider);
		return "modules/sms/ProviderForm";
	}

	/**
	 * 保存短信接口提供商
	 */
	@PreAuthorize("hasAuthority('sms:smsProvider:edit')")
	@PostMapping(value = "save")
	public @ResponseBody String save(@Validated SmsProvider smsProvider) {
		smsProviderService.saveOrUpdate(smsProvider);
		return renderResult(Global.TRUE, "保存成功！");
	}
	
	/**
	 * 停用短信接口提供商
	 */
	@PreAuthorize("hasAuthority('sms:smsProvider:edit')")
	@RequestMapping(value = "disable")
	public @ResponseBody String disable(SmsProvider smsProvider) {
		smsProvider.setStatus(SmsProvider.STATUS_DISABLE);
		smsProviderService.updateById(smsProvider);
		return renderResult(Global.TRUE, "停用成功");
	}
	
	/**
	 * 启用短信接口提供商
	 */
	@PreAuthorize("hasAuthority('sms:smsProvider:edit')")
	@RequestMapping(value = "enable")
	public @ResponseBody String enable(SmsProvider smsProvider) {
		smsProvider.setStatus(SmsProvider.STATUS_NORMAL);
		smsProviderService.updateById(smsProvider);
		return renderResult(Global.TRUE, "启用成功");
	}
	
	/**
	 * 删除短信接口提供商
	 */
	@PreAuthorize("hasAuthority('sms:smsProvider:edit')")
	@RequestMapping(value = "delete")
	public @ResponseBody String delete(SmsProvider smsProvider) {
		smsProviderService.deleteById(smsProvider);
		return renderResult(Global.TRUE, "删除成功！");
	}
	
}