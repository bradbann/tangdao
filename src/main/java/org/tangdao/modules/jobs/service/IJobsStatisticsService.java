package org.tangdao.modules.jobs.service;

import java.util.List;

import org.tangdao.modules.jobs.model.vo.JobsDateDistributionVO;
import org.tangdao.modules.jobs.model.vo.JobsImportantNumVO;
import org.tangdao.modules.jobs.model.vo.JobsSuccessRatioVO;

/**
 * 统计接口
 */
public interface IJobsStatisticsService {

    /**
     * 重要数量统计
     */
    JobsImportantNumVO getImportantNum();

    /**
     * 成功比例统计
     */
    JobsSuccessRatioVO getSuccessRatio();

    /**
     * 日期分布统计
     */
    List<JobsDateDistributionVO> getDateDistribution();

}
