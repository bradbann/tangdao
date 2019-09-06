package org.tangdao.modules.paas.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

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
import org.tangdao.common.utils.ListUtils;
import org.tangdao.common.utils.MapUtils;
import org.tangdao.common.utils.StringUtils;

import org.tangdao.modules.paas.model.domain.PushConfig;
import org.tangdao.modules.paas.service.IPushConfigService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 推送配置信息表Controller
 * @author ruyang
 * @version 2019-09-06
 */
@Controller
@RequestMapping(value = "${adminPath}/paas/pushConfig")
public class PushConfigController extends BaseController {

	@Autowired
	private IPushConfigService pushConfigService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public PushConfig get(String id, boolean isNewRecord) {
		return pushConfigService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@PreAuthorize("hasAuthority('paas:pushConfig:view')")
	@RequestMapping(value = {"list", ""})
	public String list(PushConfig pushConfig, Model model) {
		model.addAttribute("pushConfig", pushConfig);
		return "modules/paas/pushConfigList";
	}
	
	/**
	 * 查询列表数据
	 */
	@PreAuthorize("hasAuthority('paas:pushConfig:view')")
	@RequestMapping(value = "listData")
	public @ResponseBody IPage<PushConfig> listData(PushConfig pushConfig, HttpServletRequest request, HttpServletResponse response) {
		QueryWrapper<PushConfig> queryWrapper = new QueryWrapper<PushConfig>();
		return pushConfigService.page(pushConfig.getPage(), queryWrapper);
	}

	/**
	 * 查看编辑表单
	 */
	@PreAuthorize("hasAuthority('paas:pushConfig:view')")
	@RequestMapping(value = "form")
	public String form(PushConfig pushConfig, Model model) {
		model.addAttribute("pushConfig", pushConfig);
		return "modules/paas/pushConfigForm";
	}

	/**
	 * 保存推送配置信息表
	 */
	@PreAuthorize("hasAuthority('paas:pushConfig:edit')")
	@PostMapping(value = "save")
	public @ResponseBody String save(@Validated PushConfig pushConfig) {
		pushConfigService.saveOrUpdate(pushConfig);
		return renderResult(Global.TRUE, "保存成功！");
	}
	
	/**
	 * 删除推送配置信息表
	 */
	@PreAuthorize("hasAuthority('paas:pushConfig:edit')")
	@RequestMapping(value = "delete")
	public @ResponseBody String delete(PushConfig pushConfig) {
		pushConfigService.deleteById(pushConfig);
		return renderResult(Global.TRUE, "删除成功！");
	}
	
}