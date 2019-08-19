package org.tangdao.modules.jobs.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tangdao.common.suports.BaseController;
import org.tangdao.common.suports.Page;
import org.tangdao.modules.jobs.service.IJobsLogService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tangdao.jobs.model.JobsLog;

/**
 * 日志信息
 *
 * @author jobob
 * @since 2019-05-31
 */
@Controller
@RequestMapping("${adminPath}/jobsLog")
public class JobsLogController extends BaseController {
	
    @Autowired
    private IJobsLogService jobsInfoService;
    
    @RequestMapping(value = "list")
   	public String list(JobsLog jobsLog, Model model){
   		return "modules/jobs/jobsLogList";
   	}

    @RequestMapping(value = "listData")
   	public @ResponseBody IPage<JobsLog> listData(JobsLog jobsLog, HttpServletRequest request, HttpServletResponse response) {
       	QueryWrapper<JobsLog> queryWrapper = new QueryWrapper<JobsLog>();
    	Page<JobsLog> page = new Page<JobsLog>(request, response);
    	queryWrapper.orderByDesc("create_time");
        return jobsInfoService.page(page, queryWrapper);
    }

    /**
     * 总执行次数
     */
    @GetMapping("/count")
    public @ResponseBody Integer count() {
        return jobsInfoService.countAll();
    }

    /**
     * 总执行成功次数
     */
    @GetMapping("/countSuccess")
    public @ResponseBody Integer countSuccess() {
        return jobsInfoService.countSuccess();
    }
}
