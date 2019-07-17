package org.tangdao.modules.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
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

	public List<User> findPage(User user, Wrapper<User> queryWrapper);
}
