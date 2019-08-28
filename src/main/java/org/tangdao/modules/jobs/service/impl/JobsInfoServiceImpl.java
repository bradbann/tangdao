package org.tangdao.modules.jobs.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tangdao.modules.jobs.mapper.JobsInfoMapper;
import org.tangdao.modules.jobs.service.IJobsInfoService;
import org.tangdao.modules.jobs.service.IJobsLogService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tangdao.jobs.cron.CronExpression;
import com.tangdao.jobs.model.JobsInfo;
import com.tangdao.jobs.trigger.JobsTrigger;
import com.tangdao.jobs.trigger.TriggerTypeEnum;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JobsInfoServiceImpl implements IJobsInfoService {
    @Resource
    private JobsInfoMapper jobInfoMapper;
    @Autowired
    private IJobsLogService jobsInfoService;

    @Override
    public IPage<JobsInfo> page(IPage<JobsInfo> page, JobsInfo jobsInfo) {
        return jobInfoMapper.selectPage(page, Wrappers.query(jobsInfo));
    }

    @Override
    public int count() {
        return jobInfoMapper.selectCount(null);
    }

    @Override
    public List<JobsInfo> listNextTime(long nextTime) {
        return jobInfoMapper.selectList(Wrappers.<JobsInfo>lambdaQuery()
                .le(JobsInfo::getNextTime, nextTime).eq(JobsInfo::getStatus, JobsInfo.STATUS_START));
    }

    @Override
    public boolean updateById(JobsInfo jobInfo) {
        return jobInfoMapper.updateById(jobInfo) > 0;
    }

    @Override
    public boolean execute(String id, String param) {
        return JobsTrigger.trigger(id, TriggerTypeEnum.MANUAL, -1, param);
    }

    @Override
    public boolean start(String id) {
        JobsInfo dbJobInfo = getById(id);
        if (null == dbJobInfo) {
            return false;
        }
        JobsInfo jobsInfo = new JobsInfo();
        jobsInfo.setId(dbJobInfo.getId());

        // next trigger time (10s后生效，避开预读周期)
        long nextTriggerTime;
        try {
            nextTriggerTime = new CronExpression(dbJobInfo.getCron())
                    .getNextValidTimeAfter(new Date(System.currentTimeMillis() + 10000)).getTime();
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
            return false;
        }

        jobsInfo.setStatus(JobsInfo.STATUS_START);
        jobsInfo.setLastTime(0L);
        jobsInfo.setNextTime(nextTriggerTime);
        return jobInfoMapper.updateById(jobsInfo) > 0;
    }

    @Override
    public boolean stop(String id) {
        JobsInfo jobsInfo = new JobsInfo();
        jobsInfo.setId(id);
        jobsInfo.setStatus(JobsInfo.STATUS_STOP);
        jobsInfo.setLastTime(0L);
        jobsInfo.setNextTime(0L);
        return jobInfoMapper.updateById(jobsInfo) > 0;
    }

    @Override
    public boolean remove(String id) {
        jobsInfoService.removeById(id);
        return jobInfoMapper.deleteById(id) > 0;
    }

    @Override
    public JobsInfo getById(String id) {
        return jobInfoMapper.selectById(id);
    }
}
