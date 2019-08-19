package org.tangdao.modules.jobs.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.tangdao.modules.jobs.mapper.JobsLogMapper;
import org.tangdao.modules.jobs.service.IJobsLogService;
import org.tangdao.modules.jobs.service.vo.JobsDateDistributionVO;
import org.tangdao.modules.jobs.service.vo.JobsDateTempVO;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tangdao.jobs.model.JobsLog;

@Service
public class JobsLogServiceImpl implements IJobsLogService {
    @Resource
    private JobsLogMapper jobsLogMapper;

    @Override
    public int countAll() {
        return jobsLogMapper.selectCount(null);
    }

    @Override
    public int countSuccess() {
        return jobsLogMapper.selectCount(Wrappers.<JobsLog>lambdaQuery()
                .eq(JobsLog::getTriggerCode, 0));
    }

    @Override
    public JobsLog getById(String id) {
        return jobsLogMapper.selectById(id);
    }

    @Override
    public boolean updateById(JobsLog jobsLog) {
        return jobsLogMapper.updateById(jobsLog) > 0;
    }

    @Override
    public boolean save(JobsLog jobsLog) {
        return jobsLogMapper.insert(jobsLog) > 0;
    }

    @Override
    public boolean removeById(String id) {
        return jobsLogMapper.deleteById(id) > 0;
    }

    @Override
    public IPage<JobsLog> page(IPage<JobsLog> page, QueryWrapper<JobsLog> queryWrapper) {
        return jobsLogMapper.selectPage(page, queryWrapper);
    }

    @Override
    public List<JobsDateDistributionVO> getJobsDateDistributionVO() {
        List<JobsDateTempVO> tempVOList = jobsLogMapper.selectJobsDateTempVO();
        if (CollectionUtils.isEmpty(tempVOList)) {
            return null;
        }
        List<JobsDateDistributionVO> voList = new ArrayList<>();
        for (JobsDateTempVO tempVO : tempVOList) {
            JobsDateDistributionVO vo = new JobsDateDistributionVO();
            if (0 == tempVO.getCode()) {
                vo.setSuccessful(tempVO.getNum());
                vo.setFailed(0);
            } else {
                vo.setSuccessful(0);
                vo.setFailed(tempVO.getNum());
            }
            vo.setAtDate(tempVO.getAtDate());
            voList.add(vo);
        }
        return voList;
    }
}