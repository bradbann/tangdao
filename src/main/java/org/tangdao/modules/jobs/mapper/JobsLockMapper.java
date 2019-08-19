package org.tangdao.modules.jobs.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tangdao.jobs.model.JobsLock;

/**
 * 锁信息 Mapper
 *
 * @author jobob
 * @since 2019-07-13
 */
@Mapper
public interface JobsLockMapper extends BaseMapper<JobsLock> {

}
