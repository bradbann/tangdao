package org.tangdao.modules.paas.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.modules.paas.model.domain.UserBalance;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface UserBalanceMapper extends BaseMapper<UserBalance> {

	public int updateWarning(UserBalance userBalance);
}
