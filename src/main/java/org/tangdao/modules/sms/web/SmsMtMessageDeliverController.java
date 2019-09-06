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
import org.tangdao.modules.sms.model.domain.SmsMtMessageDeliver;
import org.tangdao.modules.sms.service.ISmsMtDeliverService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 下行短信回执状态Controller
 * @author ruyang
 * @version 2019-09-06
 */
@Controller
@RequestMapping(value = "${adminPath}/sms/MtMessageDeliver")
public class SmsMtMessageDeliverController extends BaseController {

	@Autowired
	private ISmsMtDeliverService smsMtMessageDeliverService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SmsMtMessageDeliver get(String id, boolean isNewRecord) {
		return smsMtMessageDeliverService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@PreAuthorize("hasAuthority('sms:smsMtMessageDeliver:view')")
	@RequestMapping(value = {"list", ""})
	public String list(SmsMtMessageDeliver smsMtMessageDeliver, Model model) {
		model.addAttribute("smsMtMessageDeliver", smsMtMessageDeliver);
		return "modules/sms/MtMessageDeliverList";
	}
	
	/**
	 * 查询列表数据
	 */
	@PreAuthorize("hasAuthority('sms:smsMtMessageDeliver:view')")
	@RequestMapping(value = "listData")
	public @ResponseBody IPage<SmsMtMessageDeliver> listData(SmsMtMessageDeliver smsMtMessageDeliver, HttpServletRequest request, HttpServletResponse response) {
		QueryWrapper<SmsMtMessageDeliver> queryWrapper = new QueryWrapper<SmsMtMessageDeliver>();
		return smsMtMessageDeliverService.page(smsMtMessageDeliver.getPage(), queryWrapper);
	}

	/**
	 * 查看编辑表单
	 */
	@PreAuthorize("hasAuthority('sms:smsMtMessageDeliver:view')")
	@RequestMapping(value = "form")
	public String form(SmsMtMessageDeliver smsMtMessageDeliver, Model model) {
		model.addAttribute("smsMtMessageDeliver", smsMtMessageDeliver);
		return "modules/sms/MtMessageDeliverForm";
	}

	/**
	 * 保存下行短信回执状态
	 */
	@PreAuthorize("hasAuthority('sms:smsMtMessageDeliver:edit')")
	@PostMapping(value = "save")
	public @ResponseBody String save(@Validated SmsMtMessageDeliver smsMtMessageDeliver) {
		smsMtMessageDeliverService.saveOrUpdate(smsMtMessageDeliver);
		return renderResult(Global.TRUE, "保存成功！");
	}
	
	/**
	 * 删除下行短信回执状态
	 */
	@PreAuthorize("hasAuthority('sms:smsMtMessageDeliver:edit')")
	@RequestMapping(value = "delete")
	public @ResponseBody String delete(SmsMtMessageDeliver smsMtMessageDeliver) {
		smsMtMessageDeliverService.deleteById(smsMtMessageDeliver);
		return renderResult(Global.TRUE, "删除成功！");
	}
	
}