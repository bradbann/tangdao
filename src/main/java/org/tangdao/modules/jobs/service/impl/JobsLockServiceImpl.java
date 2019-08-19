package org.tangdao.modules.jobs.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tangdao.modules.jobs.mapper.JobsLockMapper;
import org.tangdao.modules.jobs.service.IJobsLockService;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tangdao.jobs.JobsClock;
import com.tangdao.jobs.model.JobsLock;

@Service
public class JobsLockServiceImpl implements IJobsLockService {
    @Resource
    private JobsLockMapper jobsLockMapper;

    @Override
    public int insert(String name, String owner) {
        JobsLock jobsLock = new JobsLock();
        jobsLock.setName(name);
        jobsLock.setOwner(owner);
        jobsLock.setCreateTime(JobsClock.now());
        return jobsLockMapper.insert(jobsLock);
    }

    @Override
    public int delete(String name, String owner) {
        return jobsLockMapper.delete(Wrappers.<JobsLock>lambdaQuery().eq(JobsLock::getName, name)
                .eq(null != owner, JobsLock::getOwner, owner));
    }
}
