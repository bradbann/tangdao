package org.tangdao.modules.jobs.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tangdao.jobs.model.JobsInfo;

/**
 * 任务信息 Mapper
 *
 * @author jobob
 * @since 2019-05-31
 */
@Mapper
public interface JobsInfoMapper extends BaseMapper<JobsInfo> {

}
