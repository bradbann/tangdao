package org.tangdao.modules.sys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.common.suports.Page;
import org.tangdao.modules.sys.model.domain.User;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author ruyang
 * @since 2019-07-02
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

	public Page<User> findPage(Page<User> page, Wrapper<User> queryWrapper);
}
