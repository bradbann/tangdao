package org.tangdao.modules.sms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tangdao.common.suports.BaseController;
import org.tangdao.common.utils.DateUtils;
import org.tangdao.common.utils.StringUtils;
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
	
	private static final Integer       UNWDER_WAY = 0;
    private static final Integer       COMPLETED  = 1;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SmsMtTask get(String id, boolean isNewRecord) {
		return smsMtTaskService.get(id, isNewRecord);
	}
	
	private QueryWrapper<SmsMtTask> appendTaskQueryParams(SmsMtTask smsMtTask, Integer searchType, String d1, String d2){
		QueryWrapper<SmsMtTask> queryWrapper = new QueryWrapper<SmsMtTask>();
		if(UNWDER_WAY == searchType) {
			queryWrapper.eq("approve_status", UNWDER_WAY);
		}
		if(COMPLETED == searchType) {
			queryWrapper.ne("approve_status", UNWDER_WAY);
		}
		if(StringUtils.isNotBlank(smsMtTask.getUserCode())) {
			queryWrapper.eq("user_code", smsMtTask.getUserCode());
		}
		if(StringUtils.isNotBlank(smsMtTask.getMobile())) {
			queryWrapper.like("mobile", smsMtTask.getMobile());
		}
		if(StringUtils.isNotBlank(smsMtTask.getContent())) {
			queryWrapper.like("content", smsMtTask.getContent());
		}
		if(smsMtTask.getApproveStatus()!=null) {
			queryWrapper.eq("approve_status", smsMtTask.getApproveStatus());
		}
		if(smsMtTask.getProcessStatus()!=null) {
			queryWrapper.eq("process_status", smsMtTask.getProcessStatus());
		}
		if(smsMtTask.getSid()!=null) {
			queryWrapper.eq("sid", smsMtTask.getSid());
		}
		if(StringUtils.isNotBlank(smsMtTask.getMessageTemplateId())) {
			queryWrapper.eq("messageTemplateId", smsMtTask.getMessageTemplateId());
		}
		 // 已完成需要设置当前时间值 待处理不需要
        if (COMPLETED == searchType && StringUtils.isEmpty(d1)) {
        	d1 = DateUtils.getDate() + " 00:00:00";
        }
		if(StringUtils.isNotBlank(d1)) {
			queryWrapper.ge("create_time", d1);
		}
		if(StringUtils.isNotBlank(d2)) {
			queryWrapper.le("create_time", d2);
		}
		if(UNWDER_WAY == searchType) {
			queryWrapper.orderByAsc("create_time");
		}
		if(COMPLETED == searchType) {
			queryWrapper.orderByDesc("create_time");
		}
		return queryWrapper;
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
	public @ResponseBody IPage<SmsMtTask> underWayListData(SmsMtTask smsMtTask,String d1,String d2) {
		return smsMtTaskService.page(smsMtTask.getPage(), appendTaskQueryParams(smsMtTask, UNWDER_WAY, d1, d2));
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
	public @ResponseBody IPage<SmsMtTask> completedListData(SmsMtTask smsMtTask,String d1,String d2) {
		return smsMtTaskService.page(smsMtTask.getPage(), appendTaskQueryParams(smsMtTask, COMPLETED, d1, d2));
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