package org.tangdao.modules.jobs.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tangdao.modules.jobs.mapper.JobsRegistryMapper;
import org.tangdao.modules.jobs.service.IJobsRegistryService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tangdao.jobs.JobsClock;
import com.tangdao.jobs.model.JobsRegistry;

@Service
public class JobsRegistryServiceImpl implements IJobsRegistryService {
    @Resource
    private JobsRegistryMapper jobRegistryMapper;

    @Override
    public int removeTimeOut(int timeout) {
        return jobRegistryMapper.update(new JobsRegistry().setStatus("1"), Wrappers.<JobsRegistry>lambdaQuery()
                .eq(JobsRegistry::getStatus, 0).le(JobsRegistry::getUpdateTime, JobsClock.currentTimeMillis() - timeout));
    }
    
    @Override
    public IPage<JobsRegistry> page(IPage<JobsRegistry> page, QueryWrapper<JobsRegistry> queryWrapper) {
        return jobRegistryMapper.selectPage(page, queryWrapper);
    }

    @Override
    public List<String> listAddress(String app) {
        List<JobsRegistry> jobsRegistryList = jobRegistryMapper.selectList(Wrappers.<JobsRegistry>lambdaQuery()
                .eq(JobsRegistry::getApp, app).eq(JobsRegistry::getStatus, 0));
        return CollectionUtils.isEmpty(jobsRegistryList) ? null : jobsRegistryList.stream()
                .map(j -> j.getAddress()).collect(Collectors.toList());
    }

    @Override
    public int update(String app, String address, String status) {
        return jobRegistryMapper.update(new JobsRegistry().setStatus(status).setUpdateTime(JobsClock.now()),
                Wrappers.<JobsRegistry>lambdaQuery().eq(JobsRegistry::getApp, app)
                        .eq(JobsRegistry::getAddress, address));
    }

    @Override
    public int save(String app, String address, String status) {
        return jobRegistryMapper.insert(new JobsRegistry().setApp(app).setStatus(status)
                .setAddress(address).setUpdateTime(JobsClock.now()));
    }

    @Override
    public int countOnline() {
        return jobRegistryMapper.selectCount(Wrappers.<JobsRegistry>lambdaQuery()
        .eq(JobsRegistry::getStatus, 0));
    }

    @Override
    public int countAll() {
        return jobRegistryMapper.selectCount(null);
    }
}
