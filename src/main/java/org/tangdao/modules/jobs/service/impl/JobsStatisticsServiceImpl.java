package org.tangdao.modules.jobs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tangdao.modules.jobs.service.IJobsLogService;
import org.tangdao.modules.jobs.service.IJobsRegistryService;
import org.tangdao.modules.jobs.service.IJobsStatisticsService;
import org.tangdao.modules.jobs.service.vo.JobsDateDistributionVO;
import org.tangdao.modules.jobs.service.vo.JobsImportantNumVO;
import org.tangdao.modules.jobs.service.vo.JobsSuccessRatioVO;

@Service
public class JobsStatisticsServiceImpl implements IJobsStatisticsService {
//    @Autowired
//    private IJobsInfoService jobsInfoService;
    @Autowired
    private IJobsLogService jobsLogService;
    @Autowired
    private IJobsRegistryService jobsRegistryService;

    @Override
    public JobsImportantNumVO getImportantNum() {
        JobsImportantNumVO vo = new JobsImportantNumVO();
        vo.setRunTaskNum(jobsRegistryService.countAll());
        vo.setTriggeredNum(jobsLogService.countAll());
        vo.setOnlineExecutorNum(jobsRegistryService.countOnline());
        return vo;
    }

    @Override
    public JobsSuccessRatioVO getSuccessRatio() {
        JobsSuccessRatioVO vo = new JobsSuccessRatioVO();
        vo.setSuccessful(jobsLogService.countSuccess());
        vo.setFailed(jobsLogService.countAll() - vo.getSuccessful());
        return vo;
    }

    @Override
    public List<JobsDateDistributionVO> getDateDistribution() {
        return jobsLogService.getJobsDateDistributionVO();
    }
}
