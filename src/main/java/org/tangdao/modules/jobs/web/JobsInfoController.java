package org.tangdao.modules.jobs.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tangdao.common.config.Global;
import org.tangdao.common.suports.BaseController;
import org.tangdao.common.suports.Page;
import org.tangdao.modules.jobs.service.IJobsInfoService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tangdao.jobs.model.JobsInfo;

/**
 * 任务信息
 *
 * @author jobob
 * @since 2019-05-31
 */
@Controller
@RequestMapping("${adminPath}/jobsInfo")
public class JobsInfoController extends BaseController {
    @Resource
    private IJobsInfoService jobInfoService;
    
    @RequestMapping(value = "list")
	public String list(JobsInfo jobsInfo, Model model){
		return "modules/jobs/infoList";
	}

    @RequestMapping(value = "listData")
	public @ResponseBody IPage<JobsInfo> listData(JobsInfo jobInfo, HttpServletRequest request, HttpServletResponse response) {
    	Page<JobsInfo> page = new Page<JobsInfo>(request, response);
        return jobInfoService.page(page, jobInfo);
    }

    /**
     * 总任务数
     */
    @GetMapping("/count")
    public @ResponseBody Integer count() {
        return jobInfoService.count();
    }

    /**
     * 执行
     */
    @PostMapping("/execute")
    public @ResponseBody String execute(JobsInfo jobsInfo) {
        try {
			jobInfoService.execute(jobsInfo.getId(), jobsInfo.getParam());
			return renderResult(Global.TRUE, "执行成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return renderResult(Global.FALSE, "执行失败");
		}
    }

    /**
     * 启动
     */
    @PostMapping("/start")
    public @ResponseBody String start(JobsInfo jobsInfo) {
    	try {
			jobInfoService.start(jobsInfo.getId());
			return renderResult(Global.TRUE, "启动成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return renderResult(Global.FALSE, "启动失败");
		}
    }

    /**
     * 停止
     */
    @PostMapping("/stop")
    public @ResponseBody String stop(JobsInfo jobsInfo) {
    	try {
			jobInfoService.stop(jobsInfo.getId());
			return renderResult(Global.TRUE, "停止成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return renderResult(Global.FALSE, "停止失败");
		}
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    public @ResponseBody String remove(JobsInfo jobsInfo) {
    	try {
			jobInfoService.remove(jobsInfo.getId());
			return renderResult(Global.TRUE, "删除成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return renderResult(Global.FALSE, "删除失败");
		}
    }
}
