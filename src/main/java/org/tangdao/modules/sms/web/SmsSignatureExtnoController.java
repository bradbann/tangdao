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
import org.tangdao.modules.sms.model.domain.SmsSignatureExtno;
import org.tangdao.modules.sms.service.ISmsSignatureExtnoService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 签名扩展Controller
 * @author ruyang
 * @version 2019-09-06
 */
@Controller
@RequestMapping(value = "${adminPath}/sms/SignatureExtno")
public class SmsSignatureExtnoController extends BaseController {

	@Autowired
	private ISmsSignatureExtnoService smsSignatureExtnoService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SmsSignatureExtno get(String id, boolean isNewRecord) {
		return smsSignatureExtnoService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@PreAuthorize("hasAuthority('sms:smsSignatureExtno:view')")
	@RequestMapping(value = {"list", ""})
	public String list(SmsSignatureExtno smsSignatureExtno, Model model) {
		model.addAttribute("smsSignatureExtno", smsSignatureExtno);
		return "modules/sms/SignatureExtnoList";
	}
	
	/**
	 * 查询列表数据
	 */
	@PreAuthorize("hasAuthority('sms:smsSignatureExtno:view')")
	@RequestMapping(value = "listData")
	public @ResponseBody IPage<SmsSignatureExtno> listData(SmsSignatureExtno smsSignatureExtno, HttpServletRequest request, HttpServletResponse response) {
		QueryWrapper<SmsSignatureExtno> queryWrapper = new QueryWrapper<SmsSignatureExtno>();
		return smsSignatureExtnoService.page(smsSignatureExtno.getPage(), queryWrapper);
	}

	/**
	 * 查看编辑表单
	 */
	@PreAuthorize("hasAuthority('sms:smsSignatureExtno:view')")
	@RequestMapping(value = "form")
	public String form(SmsSignatureExtno smsSignatureExtno, Model model) {
		model.addAttribute("smsSignatureExtno", smsSignatureExtno);
		return "modules/sms/SignatureExtnoForm";
	}

	/**
	 * 保存签名扩展
	 */
	@PreAuthorize("hasAuthority('sms:smsSignatureExtno:edit')")
	@PostMapping(value = "save")
	public @ResponseBody String save(@Validated SmsSignatureExtno smsSignatureExtno) {
		smsSignatureExtnoService.saveOrUpdate(smsSignatureExtno);
		return renderResult(Global.TRUE, "保存成功！");
	}
	
	/**
	 * 停用签名扩展
	 */
	@PreAuthorize("hasAuthority('sms:smsSignatureExtno:edit')")
	@RequestMapping(value = "disable")
	public @ResponseBody String disable(SmsSignatureExtno smsSignatureExtno) {
		smsSignatureExtno.setStatus(SmsSignatureExtno.STATUS_DISABLE);
		smsSignatureExtnoService.updateById(smsSignatureExtno);
		return renderResult(Global.TRUE, "停用成功");
	}
	
	/**
	 * 启用签名扩展
	 */
	@PreAuthorize("hasAuthority('sms:smsSignatureExtno:edit')")
	@RequestMapping(value = "enable")
	public @ResponseBody String enable(SmsSignatureExtno smsSignatureExtno) {
		smsSignatureExtno.setStatus(SmsSignatureExtno.STATUS_NORMAL);
		smsSignatureExtnoService.updateById(smsSignatureExtno);
		return renderResult(Global.TRUE, "启用成功");
	}
	
	/**
	 * 删除签名扩展
	 */
	@PreAuthorize("hasAuthority('sms:smsSignatureExtno:edit')")
	@RequestMapping(value = "delete")
	public @ResponseBody String delete(SmsSignatureExtno smsSignatureExtno) {
		smsSignatureExtnoService.deleteById(smsSignatureExtno);
		return renderResult(Global.TRUE, "删除成功！");
	}
	
}