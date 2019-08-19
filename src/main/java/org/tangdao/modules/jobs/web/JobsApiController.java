package org.tangdao.modules.jobs.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tangdao.jobs.JobsConstant;
import com.tangdao.jobs.starter.JobsScheduler;

/**
 * Jobs Api
 *
 * @author jobob
 * @since 2019-07-13
 */
@Controller
public class JobsApiController implements InitializingBean {


    @Override
    public void afterPropertiesSet() throws Exception {
        // to do nothing
    }

    @RequestMapping(JobsConstant.JOBS_API)
    public void api(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        JobsScheduler.invokeAdminService(request, response);
    }
}
