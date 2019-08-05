package org.tangdao.modules.sys.service;

import java.util.List;

import org.tangdao.common.service.ITreeService;
import org.tangdao.modules.sys.model.domain.Menu;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author ruyang
 * @since 2019-07-02
 */
public interface IMenuService extends ITreeService<Menu> {

	public List<Menu> findByRoleMenu(Menu menu);
	
	public List<Menu> findByUserMenu(Menu menu, boolean isFindParentAndChild);
	
}
