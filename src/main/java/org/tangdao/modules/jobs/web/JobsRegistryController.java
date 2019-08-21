package org.tangdao.modules.jobs.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tangdao.common.suports.BaseController;
import org.tangdao.common.suports.Page;
import org.tangdao.modules.jobs.service.IJobsRegistryService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tangdao.jobs.model.JobsRegistry;

/**
 * 
 *
 * @author jobob
 * @since 2019-05-31
 */
@Controller
@RequestMapping("${adminPath}/jobsRegistry")
public class JobsRegistryController extends BaseController {
	
    @Autowired
    private IJobsRegistryService jobRegistryService;
    
    @RequestMapping(value = "list")
	public String list(JobsRegistry jobsRegistry, Model model){
		return "modules/jobs/registryList";
	}
    
    @RequestMapping(value = "listData")
	public @ResponseBody IPage<JobsRegistry> listData(JobsRegistry jobInfo, HttpServletRequest request, HttpServletResponse response) {
    	QueryWrapper<JobsRegistry> queryWrapper = new QueryWrapper<JobsRegistry>();
    	Page<JobsRegistry> page = new Page<JobsRegistry>(request, response);
    	return jobRegistryService.page(page, queryWrapper);
    }
}
