package org.tangdao.modules.paas.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.modules.paas.model.domain.UserSmsConfig;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 用户短信配置Mapper接口
 * @author ruyang
 * @version 2019-09-05
 */
@Mapper
public interface UserSmsConfigMapper extends BaseMapper<UserSmsConfig> {
	
}