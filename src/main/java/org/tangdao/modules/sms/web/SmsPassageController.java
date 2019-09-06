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
import org.tangdao.modules.sms.model.domain.SmsPassage;
import org.tangdao.modules.sms.service.ISmsPassageService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 通道管理Controller
 * @author ruyang
 * @version 2019-09-06
 */
@Controller
@RequestMapping(value = "${adminPath}/sms/Passage")
public class SmsPassageController extends BaseController {

	@Autowired
	private ISmsPassageService smsPassageService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SmsPassage get(String id, boolean isNewRecord) {
		return smsPassageService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@PreAuthorize("hasAuthority('sms:smsPassage:view')")
	@RequestMapping(value = {"list", ""})
	public String list(SmsPassage smsPassage, Model model) {
		model.addAttribute("smsPassage", smsPassage);
		return "modules/sms/PassageList";
	}
	
	/**
	 * 查询列表数据
	 */
	@PreAuthorize("hasAuthority('sms:smsPassage:view')")
	@RequestMapping(value = "listData")
	public @ResponseBody IPage<SmsPassage> listData(SmsPassage smsPassage, HttpServletRequest request, HttpServletResponse response) {
		QueryWrapper<SmsPassage> queryWrapper = new QueryWrapper<SmsPassage>();
		return smsPassageService.page(smsPassage.getPage(), queryWrapper);
	}

	/**
	 * 查看编辑表单
	 */
	@PreAuthorize("hasAuthority('sms:smsPassage:view')")
	@RequestMapping(value = "form")
	public String form(SmsPassage smsPassage, Model model) {
		model.addAttribute("smsPassage", smsPassage);
		return "modules/sms/PassageForm";
	}

	/**
	 * 保存通道管理
	 */
	@PreAuthorize("hasAuthority('sms:smsPassage:edit')")
	@PostMapping(value = "save")
	public @ResponseBody String save(@Validated SmsPassage smsPassage) {
		smsPassageService.saveOrUpdate(smsPassage);
		return renderResult(Global.TRUE, "保存成功！");
	}
	
	/**
	 * 停用通道管理
	 */
	@PreAuthorize("hasAuthority('sms:smsPassage:edit')")
	@RequestMapping(value = "disable")
	public @ResponseBody String disable(SmsPassage smsPassage) {
		smsPassage.setStatus(SmsPassage.STATUS_DISABLE);
		smsPassageService.updateById(smsPassage);
		return renderResult(Global.TRUE, "停用成功");
	}
	
	/**
	 * 启用通道管理
	 */
	@PreAuthorize("hasAuthority('sms:smsPassage:edit')")
	@RequestMapping(value = "enable")
	public @ResponseBody String enable(SmsPassage smsPassage) {
		smsPassage.setStatus(SmsPassage.STATUS_NORMAL);
		smsPassageService.updateById(smsPassage);
		return renderResult(Global.TRUE, "启用成功");
	}
	
	/**
	 * 删除通道管理
	 */
	@PreAuthorize("hasAuthority('sms:smsPassage:edit')")
	@RequestMapping(value = "delete")
	public @ResponseBody String delete(SmsPassage smsPassage) {
		smsPassageService.deleteById(smsPassage);
		return renderResult(Global.TRUE, "删除成功！");
	}
	
}