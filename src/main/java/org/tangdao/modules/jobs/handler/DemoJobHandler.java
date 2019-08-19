package org.tangdao.modules.jobs.handler;

import org.springframework.stereotype.Component;

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

    @Override
    public JobsResponse execute(String param) throws JobsException {
        System.out.println("执行 DemoJobHandler param=" + param);
        return JobsResponse.ok();
    }
}
