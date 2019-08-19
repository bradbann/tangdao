package org.tangdao.modules.jobs.service;

import java.util.List;

import org.tangdao.modules.jobs.service.vo.JobsDateDistributionVO;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tangdao.jobs.model.JobsLog;

/**
 * 任务日志接口
 *
 * @author jobob
 * @since 2019-07-18
 */
public interface IJobsLogService {

    /**
     * 任务执行总数
     *
     * @return
     */
    int countAll();

    /**
     * 执行成功日志记录总数
     */
    int countSuccess();

    JobsLog getById(String id);

    boolean updateById(JobsLog jobsInfo);

    boolean save(JobsLog jobsInfo);

    /**
     *
     * @param id
     * @return
     */
    boolean removeById(String id);

    IPage<JobsLog> page(IPage<JobsLog> page, QueryWrapper<JobsLog> queryWrapper);

    List<JobsDateDistributionVO> getJobsDateDistributionVO();
}
