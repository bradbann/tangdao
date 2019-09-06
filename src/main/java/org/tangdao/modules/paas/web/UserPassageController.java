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
import org.tangdao.modules.paas.model.domain.UserPassage;
import org.tangdao.modules.paas.service.IUserPassageService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 用户通道配置Controller
 * @author ruyang
 * @version 2019-09-06
 */
@Controller
@RequestMapping(value = "${adminPath}/paas/paasUserPassage")
public class UserPassageController extends BaseController {

	@Autowired
	private IUserPassageService paasUserPassageService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public UserPassage get(String id, boolean isNewRecord) {
		return paasUserPassageService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@PreAuthorize("hasAuthority('paas:paasUserPassage:view')")
	@RequestMapping(value = {"list", ""})
	public String list(UserPassage paasUserPassage, Model model) {
		model.addAttribute("paasUserPassage", paasUserPassage);
		return "modules/paas/paasUserPassageList";
	}
	
	/**
	 * 查询列表数据
	 */
	@PreAuthorize("hasAuthority('paas:paasUserPassage:view')")
	@RequestMapping(value = "listData")
	public @ResponseBody IPage<UserPassage> listData(UserPassage paasUserPassage, HttpServletRequest request, HttpServletResponse response) {
		QueryWrapper<UserPassage> queryWrapper = new QueryWrapper<UserPassage>();
		return paasUserPassageService.page(paasUserPassage.getPage(), queryWrapper);
	}

	/**
	 * 查看编辑表单
	 */
	@PreAuthorize("hasAuthority('paas:paasUserPassage:view')")
	@RequestMapping(value = "form")
	public String form(UserPassage paasUserPassage, Model model) {
		model.addAttribute("paasUserPassage", paasUserPassage);
		return "modules/paas/paasUserPassageForm";
	}

	/**
	 * 保存用户通道配置
	 */
	@PreAuthorize("hasAuthority('paas:paasUserPassage:edit')")
	@PostMapping(value = "save")
	public @ResponseBody String save(@Validated UserPassage paasUserPassage) {
		paasUserPassageService.saveOrUpdate(paasUserPassage);
		return renderResult(Global.TRUE, "保存成功！");
	}
	
	/**
	 * 停用用户通道配置
	 */
	@PreAuthorize("hasAuthority('paas:paasUserPassage:edit')")
	@RequestMapping(value = "disable")
	public @ResponseBody String disable(UserPassage paasUserPassage) {
		paasUserPassage.setStatus(UserPassage.STATUS_DISABLE);
		paasUserPassageService.updateById(paasUserPassage);
		return renderResult(Global.TRUE, "停用成功");
	}
	
	/**
	 * 启用用户通道配置
	 */
	@PreAuthorize("hasAuthority('paas:paasUserPassage:edit')")
	@RequestMapping(value = "enable")
	public @ResponseBody String enable(UserPassage paasUserPassage) {
		paasUserPassage.setStatus(UserPassage.STATUS_NORMAL);
		paasUserPassageService.updateById(paasUserPassage);
		return renderResult(Global.TRUE, "启用成功");
	}
	
	/**
	 * 删除用户通道配置
	 */
	@PreAuthorize("hasAuthority('paas:paasUserPassage:edit')")
	@RequestMapping(value = "delete")
	public @ResponseBody String delete(UserPassage paasUserPassage) {
		paasUserPassageService.deleteById(paasUserPassage);
		return renderResult(Global.TRUE, "删除成功！");
	}
	
}