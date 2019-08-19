package org.tangdao.modules.jobs.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tangdao.jobs.model.JobsRegistry;

/**
 * 注册任务信息 Mapper
 *
 * @author jobob
 * @since 2019-05-31
 */
@Mapper
public interface JobsRegistryMapper extends BaseMapper<JobsRegistry> {

}
