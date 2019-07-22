package org.tangdao.modules.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.tangdao.modules.sys.model.domain.Role;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author ruyang
 * @since 2019-07-02
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

	public List<Role> findByUserCode(Role role);
	
	public int deleteRoleMenu(String roleCode);
	
	public int insertRoleMenu(@Param("roleCode") String roleCode, @Param("menuCodes") String[] menuCodes);
}
