package org.tangdao.modules.jobs.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tangdao.jobs.model.JobsInfo;

/**
 * 任务信息接口
 *
 * @author jobob
 * @since 2019-07-18
 */
public interface IJobsInfoService {

	public IPage<JobsInfo> page(IPage<JobsInfo> page, JobsInfo jobsInfo);

    /**
     * 执行任务总数
     *
     * @return
     */
    int count();

    List<JobsInfo> listNextTime(long nextTime);

    /**
     * 根据 ID 更新任务信息
     *
     * @param jobInfo 任务信息对象
     * @return
     */
    boolean updateById(JobsInfo jobInfo);

    /**
     * 执行、指定 ID 任务
     *
     * @param id    主键 ID
     * @param param 执行参数
     * @return
     */
    boolean execute(String id, String param);

    /**
     * 启动、指定 ID 任务
     *
     * @param id 主键 ID
     * @return
     */
    boolean start(String id);

    /**
     * 停止、指定 ID 任务
     *
     * @param id 主键 ID
     * @return
     */
    boolean stop(String id);

    /**
     * 删除、指定 ID 任务
     *
     * @param id 主键 ID
     * @return
     */
    boolean remove(String id);

    /**
     * 根据 ID 获取任务信息对象
     *
     * @param id 任务 ID
     * @return
     */
    JobsInfo getById(String id);
}
