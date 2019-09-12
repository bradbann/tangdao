package org.tangdao.modules.paas.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.modules.paas.model.domain.PushConfig;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 推送配置信息表Mapper接口
 * @author ruyang
 * @version 2019-09-06
 */
@Mapper
public interface PushConfigMapper extends BaseMapper<PushConfig> {
	
	public int updateByUserCode(PushConfig pushConfig);
}