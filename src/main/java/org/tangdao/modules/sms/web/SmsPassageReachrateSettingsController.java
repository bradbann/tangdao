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
import org.tangdao.modules.sms.model.domain.SmsPassageReachrateSettings;
import org.tangdao.modules.sms.service.ISmsPassageReachrateSettingsService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 通道重连配置Controller
 * @author ruyang
 * @version 2019-09-06
 */
@Controller
@RequestMapping(value = "${adminPath}/sms/PassageReachrateSettings")
public class SmsPassageReachrateSettingsController extends BaseController {

	@Autowired
	private ISmsPassageReachrateSettingsService smsPassageReachrateSettingsService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SmsPassageReachrateSettings get(String id, boolean isNewRecord) {
		return smsPassageReachrateSettingsService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@PreAuthorize("hasAuthority('sms:smsPassageReachrateSettings:view')")
	@RequestMapping(value = {"list", ""})
	public String list(SmsPassageReachrateSettings smsPassageReachrateSettings, Model model) {
		model.addAttribute("smsPassageReachrateSettings", smsPassageReachrateSettings);
		return "modules/sms/PassageReachrateSettingsList";
	}
	
	/**
	 * 查询列表数据
	 */
	@PreAuthorize("hasAuthority('sms:smsPassageReachrateSettings:view')")
	@RequestMapping(value = "listData")
	public @ResponseBody IPage<SmsPassageReachrateSettings> listData(SmsPassageReachrateSettings smsPassageReachrateSettings, HttpServletRequest request, HttpServletResponse response) {
		QueryWrapper<SmsPassageReachrateSettings> queryWrapper = new QueryWrapper<SmsPassageReachrateSettings>();
		return smsPassageReachrateSettingsService.page(smsPassageReachrateSettings.getPage(), queryWrapper);
	}

	/**
	 * 查看编辑表单
	 */
	@PreAuthorize("hasAuthority('sms:smsPassageReachrateSettings:view')")
	@RequestMapping(value = "form")
	public String form(SmsPassageReachrateSettings smsPassageReachrateSettings, Model model) {
		model.addAttribute("smsPassageReachrateSettings", smsPassageReachrateSettings);
		return "modules/sms/PassageReachrateSettingsForm";
	}

	/**
	 * 保存通道重连配置
	 */
	@PreAuthorize("hasAuthority('sms:smsPassageReachrateSettings:edit')")
	@PostMapping(value = "save")
	public @ResponseBody String save(@Validated SmsPassageReachrateSettings smsPassageReachrateSettings) {
		smsPassageReachrateSettingsService.saveOrUpdate(smsPassageReachrateSettings);
		return renderResult(Global.TRUE, "保存成功！");
	}
	
	/**
	 * 停用通道重连配置
	 */
	@PreAuthorize("hasAuthority('sms:smsPassageReachrateSettings:edit')")
	@RequestMapping(value = "disable")
	public @ResponseBody String disable(SmsPassageReachrateSettings smsPassageReachrateSettings) {
		smsPassageReachrateSettings.setStatus(SmsPassageReachrateSettings.STATUS_DISABLE);
		smsPassageReachrateSettingsService.updateById(smsPassageReachrateSettings);
		return renderResult(Global.TRUE, "停用成功");
	}
	
	/**
	 * 启用通道重连配置
	 */
	@PreAuthorize("hasAuthority('sms:smsPassageReachrateSettings:edit')")
	@RequestMapping(value = "enable")
	public @ResponseBody String enable(SmsPassageReachrateSettings smsPassageReachrateSettings) {
		smsPassageReachrateSettings.setStatus(SmsPassageReachrateSettings.STATUS_NORMAL);
		smsPassageReachrateSettingsService.updateById(smsPassageReachrateSettings);
		return renderResult(Global.TRUE, "启用成功");
	}
	
	/**
	 * 删除通道重连配置
	 */
	@PreAuthorize("hasAuthority('sms:smsPassageReachrateSettings:edit')")
	@RequestMapping(value = "delete")
	public @ResponseBody String delete(SmsPassageReachrateSettings smsPassageReachrateSettings) {
		smsPassageReachrateSettingsService.deleteById(smsPassageReachrateSettings);
		return renderResult(Global.TRUE, "删除成功！");
	}
	
}