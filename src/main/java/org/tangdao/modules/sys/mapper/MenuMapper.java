package org.tangdao.modules.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.modules.sys.model.domain.Menu;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author ruyang
 * @since 2019-07-02
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

	public List<Menu> findByRoleCode(Menu menu);
	
	public List<Menu> findByUserCode(Menu menu);
}
