package org.tangdao.modules.sms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
@RequestMapping(value = "${adminPath}/sms/mtTask")
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
	 * 待处理任务列表
	 */
	@RequestMapping(value = "underWayList")
	public String underWayList(SmsMtTask smsMtTask, Model model) {
		model.addAttribute("smsMtTask", smsMtTask);
		return "modules/sms/mtTaskUnderWayList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "underWayListData")
	public @ResponseBody IPage<SmsMtTask> underWayListData(SmsMtTask smsMtTask, HttpServletRequest request, HttpServletResponse response) {
		QueryWrapper<SmsMtTask> queryWrapper = new QueryWrapper<SmsMtTask>();
		queryWrapper.eq("approve_status", "0");
		return smsMtTaskService.page(smsMtTask.getPage(), queryWrapper);
	}
	
	/**
	 * 已完成任务列表
	 */
	@RequestMapping(value = "completedList")
	public String completedList(SmsMtTask smsMtTask, Model model) {
		model.addAttribute("smsMtTask", smsMtTask);
		return "modules/sms/mtTaskCompletedList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "completedListData")
	public @ResponseBody IPage<SmsMtTask> completedListData(SmsMtTask smsMtTask, HttpServletRequest request, HttpServletResponse response) {
		QueryWrapper<SmsMtTask> queryWrapper = new QueryWrapper<SmsMtTask>();
		queryWrapper.eq("approve_status", "1");
		return smsMtTaskService.page(smsMtTask.getPage(), queryWrapper);
	}
	
//	/**
//	 * 查看编辑表单
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtTask:view')")
//	@RequestMapping(value = "form")
//	public String form(SmsMtTask smsMtTask, Model model) {
//		model.addAttribute("smsMtTask", smsMtTask);
//		return "modules/sms/MtTaskForm";
//	}
//
//	/**
//	 * 保存下行短信任务
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtTask:edit')")
//	@PostMapping(value = "save")
//	public @ResponseBody String save(@Validated SmsMtTask smsMtTask) {
//		smsMtTaskService.saveOrUpdate(smsMtTask);
//		return renderResult(Global.TRUE, "保存成功！");
//	}
//	
//	/**
//	 * 停用下行短信任务
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtTask:edit')")
//	@RequestMapping(value = "disable")
//	public @ResponseBody String disable(SmsMtTask smsMtTask) {
//		smsMtTask.setStatus(SmsMtTask.STATUS_DISABLE);
//		smsMtTaskService.updateById(smsMtTask);
//		return renderResult(Global.TRUE, "停用成功");
//	}
//	
//	/**
//	 * 启用下行短信任务
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtTask:edit')")
//	@RequestMapping(value = "enable")
//	public @ResponseBody String enable(SmsMtTask smsMtTask) {
//		smsMtTask.setStatus(SmsMtTask.STATUS_NORMAL);
//		smsMtTaskService.updateById(smsMtTask);
//		return renderResult(Global.TRUE, "启用成功");
//	}
//	
//	/**
//	 * 删除下行短信任务
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtTask:edit')")
//	@RequestMapping(value = "delete")
//	public @ResponseBody String delete(SmsMtTask smsMtTask) {
//		smsMtTaskService.deleteById(smsMtTask);
//		return renderResult(Global.TRUE, "删除成功！");
//	}
	
}