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
import org.tangdao.modules.sms.model.domain.SmsMtTask;
import org.tangdao.modules.sms.service.ISmsMtTaskService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 下行短信任务Controller
 * @author ruyang
 * @version 2019-09-06
 */
@Controller
@RequestMapping(value = "${adminPath}/sms/MtTask")
public class SmsMtTaskController extends BaseController {

	@Autowired
	private ISmsMtTaskService smsMtTaskService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SmsMtTask get(String id, boolean isNewRecord) {
		return smsMtTaskService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@PreAuthorize("hasAuthority('sms:smsMtTask:view')")
	@RequestMapping(value = {"list", ""})
	public String list(SmsMtTask smsMtTask, Model model) {
		model.addAttribute("smsMtTask", smsMtTask);
		return "modules/sms/MtTaskList";
	}
	
	/**
	 * 查询列表数据
	 */
	@PreAuthorize("hasAuthority('sms:smsMtTask:view')")
	@RequestMapping(value = "listData")
	public @ResponseBody IPage<SmsMtTask> listData(SmsMtTask smsMtTask, HttpServletRequest request, HttpServletResponse response) {
		QueryWrapper<SmsMtTask> queryWrapper = new QueryWrapper<SmsMtTask>();
		return smsMtTaskService.page(smsMtTask.getPage(), queryWrapper);
	}

	/**
	 * 查看编辑表单
	 */
	@PreAuthorize("hasAuthority('sms:smsMtTask:view')")
	@RequestMapping(value = "form")
	public String form(SmsMtTask smsMtTask, Model model) {
		model.addAttribute("smsMtTask", smsMtTask);
		return "modules/sms/MtTaskForm";
	}

	/**
	 * 保存下行短信任务
	 */
	@PreAuthorize("hasAuthority('sms:smsMtTask:edit')")
	@PostMapping(value = "save")
	public @ResponseBody String save(@Validated SmsMtTask smsMtTask) {
		smsMtTaskService.saveOrUpdate(smsMtTask);
		return renderResult(Global.TRUE, "保存成功！");
	}
	
	/**
	 * 停用下行短信任务
	 */
	@PreAuthorize("hasAuthority('sms:smsMtTask:edit')")
	@RequestMapping(value = "disable")
	public @ResponseBody String disable(SmsMtTask smsMtTask) {
		smsMtTask.setStatus(SmsMtTask.STATUS_DISABLE);
		smsMtTaskService.updateById(smsMtTask);
		return renderResult(Global.TRUE, "停用成功");
	}
	
	/**
	 * 启用下行短信任务
	 */
	@PreAuthorize("hasAuthority('sms:smsMtTask:edit')")
	@RequestMapping(value = "enable")
	public @ResponseBody String enable(SmsMtTask smsMtTask) {
		smsMtTask.setStatus(SmsMtTask.STATUS_NORMAL);
		smsMtTaskService.updateById(smsMtTask);
		return renderResult(Global.TRUE, "启用成功");
	}
	
	/**
	 * 删除下行短信任务
	 */
	@PreAuthorize("hasAuthority('sms:smsMtTask:edit')")
	@RequestMapping(value = "delete")
	public @ResponseBody String delete(SmsMtTask smsMtTask) {
		smsMtTaskService.deleteById(smsMtTask);
		return renderResult(Global.TRUE, "删除成功！");
	}
	
}