package org.tangdao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tangdao.jobs.executor.JobsSpringExecutor;
import com.tangdao.jobs.handler.IJobsResultHandler;
import com.tangdao.jobs.starter.EnableJobsAdmin;
import com.tangdao.jobs.starter.JobsProperties;

@Configuration
@EnableJobsAdmin
public class JobsConfig {

	@Bean
    public IJobsResultHandler jobsResultHandler() {
        return (jobInfo, address, jobsResponse) ->
                System.out.println("Jobs 报警处理器，调度地址：" + address);
    }
	
	/**
	 * 使用延时方法启动
	 * @param jobsProperties
	 * @return
	 */
	@Bean(initMethod = "startDelay", destroyMethod = "destroy")
    public JobsSpringExecutor jobsSpringExecutor(JobsProperties jobsProperties) {
        JobsSpringExecutor jobsSpringExecutor = new JobsSpringExecutor();
        jobsSpringExecutor.setAccessToken(jobsProperties.getAdminAccessToken());
        jobsSpringExecutor.setAdminAddress(jobsProperties.getAdminAddress());
        jobsSpringExecutor.setApp(jobsProperties.getAppName());
        jobsSpringExecutor.setIp(jobsProperties.getAppIp());
        jobsSpringExecutor.setPort(jobsProperties.getAppPort());
        jobsSpringExecutor.setStartupDelay(jobsProperties.getStartupDelay()*1000);
        return jobsSpringExecutor;
    }
	
}
