package org.tangdao.modules.sys.service;

import java.util.List;

import org.tangdao.common.service.ITreeService;
import org.tangdao.modules.sys.model.domain.Menu;
import org.tangdao.modules.sys.model.domain.User;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author ruyang
 * @since 2019-07-02
 */
public interface IMenuService extends ITreeService<Menu> {

	public List<Menu> findByRoleCode(Menu menu);
	
	public List<Menu> findByUserCode(Menu menu);
	
	public List<Menu> findByUser(User user);
	
}
