package org.tangdao.modules.jobs.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tangdao.modules.sys.service.ILogService;

import com.tangdao.jobs.api.JobsResponse;
import com.tangdao.jobs.exception.JobsException;
import com.tangdao.jobs.handler.IJobsHandler;


/**
 * 处理器 DEMO
 *
 * @author jobob
 * @since 2019-07-16
 */
@Component
public class DemoJobHandler implements IJobsHandler {
	
	@Autowired
	private ILogService logService;

    @Override
    public JobsResponse execute(String param) throws JobsException {
        System.out.println("清理全部日志任务" );
        logService.clearAll();
        return JobsResponse.ok();
    }
}
