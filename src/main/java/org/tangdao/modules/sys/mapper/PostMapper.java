package org.tangdao.modules.sys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.modules.sys.model.domain.Post;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 员工岗位表 Mapper 接口
 * </p>
 *
 * @author ruyang
 * @since 2019-08-20
 */
@Mapper
public interface PostMapper extends BaseMapper<Post> {

}
