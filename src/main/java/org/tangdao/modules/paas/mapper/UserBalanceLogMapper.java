package org.tangdao.modules.paas.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.modules.paas.model.domain.UserBalanceLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 用户余额日志Mapper接口
 * @author ruyang
 * @version 2019-09-06
 */
@Mapper
public interface UserBalanceLogMapper extends BaseMapper<UserBalanceLog> {
	
}