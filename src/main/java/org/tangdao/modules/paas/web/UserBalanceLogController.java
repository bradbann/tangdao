package org.tangdao.modules.paas.web;

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
import org.tangdao.modules.paas.model.domain.UserBalanceLog;
import org.tangdao.modules.paas.service.IUserBalanceLogService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 用户余额日志Controller
 * @author ruyang
 * @version 2019-09-06
 */
@Controller
@RequestMapping(value = "${adminPath}/paas/paasUserBalanceLog")
public class UserBalanceLogController extends BaseController {

	@Autowired
	private IUserBalanceLogService paasUserBalanceLogService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public UserBalanceLog get(String id, boolean isNewRecord) {
		return paasUserBalanceLogService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@PreAuthorize("hasAuthority('paas:paasUserBalanceLog:view')")
	@RequestMapping(value = {"list", ""})
	public String list(UserBalanceLog paasUserBalanceLog, Model model) {
		model.addAttribute("paasUserBalanceLog", paasUserBalanceLog);
		return "modules/paas/paasUserBalanceLogList";
	}
	
	/**
	 * 查询列表数据
	 */
	@PreAuthorize("hasAuthority('paas:paasUserBalanceLog:view')")
	@RequestMapping(value = "listData")
	public @ResponseBody IPage<UserBalanceLog> listData(UserBalanceLog paasUserBalanceLog, HttpServletRequest request, HttpServletResponse response) {
		QueryWrapper<UserBalanceLog> queryWrapper = new QueryWrapper<UserBalanceLog>();
		return paasUserBalanceLogService.page(paasUserBalanceLog.getPage(), queryWrapper);
	}

	/**
	 * 查看编辑表单
	 */
	@PreAuthorize("hasAuthority('paas:paasUserBalanceLog:view')")
	@RequestMapping(value = "form")
	public String form(UserBalanceLog paasUserBalanceLog, Model model) {
		model.addAttribute("paasUserBalanceLog", paasUserBalanceLog);
		return "modules/paas/paasUserBalanceLogForm";
	}

	/**
	 * 保存用户余额日志
	 */
	@PreAuthorize("hasAuthority('paas:paasUserBalanceLog:edit')")
	@PostMapping(value = "save")
	public @ResponseBody String save(@Validated UserBalanceLog paasUserBalanceLog) {
		paasUserBalanceLogService.saveOrUpdate(paasUserBalanceLog);
		return renderResult(Global.TRUE, "保存成功！");
	}
	
	/**
	 * 停用用户余额日志
	 */
	@PreAuthorize("hasAuthority('paas:paasUserBalanceLog:edit')")
	@RequestMapping(value = "disable")
	public @ResponseBody String disable(UserBalanceLog paasUserBalanceLog) {
		paasUserBalanceLog.setStatus(UserBalanceLog.STATUS_DISABLE);
		paasUserBalanceLogService.updateById(paasUserBalanceLog);
		return renderResult(Global.TRUE, "停用成功");
	}
	
	/**
	 * 启用用户余额日志
	 */
	@PreAuthorize("hasAuthority('paas:paasUserBalanceLog:edit')")
	@RequestMapping(value = "enable")
	public @ResponseBody String enable(UserBalanceLog paasUserBalanceLog) {
		paasUserBalanceLog.setStatus(UserBalanceLog.STATUS_NORMAL);
		paasUserBalanceLogService.updateById(paasUserBalanceLog);
		return renderResult(Global.TRUE, "启用成功");
	}
	
	/**
	 * 删除用户余额日志
	 */
	@PreAuthorize("hasAuthority('paas:paasUserBalanceLog:edit')")
	@RequestMapping(value = "delete")
	public @ResponseBody String delete(UserBalanceLog paasUserBalanceLog) {
		paasUserBalanceLogService.deleteById(paasUserBalanceLog);
		return renderResult(Global.TRUE, "删除成功！");
	}
	
}