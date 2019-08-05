package org.tangdao.modules.sys.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.tangdao.common.service.impl.TreeServiceImpl;
import org.tangdao.common.utils.ListUtils;
import org.tangdao.modules.sys.mapper.MenuMapper;
import org.tangdao.modules.sys.model.domain.Menu;
import org.tangdao.modules.sys.service.IMenuService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author ruyang
 * @since 2019-07-02
 */
@Service
public class MenuServiceImpl extends TreeServiceImpl<MenuMapper, Menu> implements IMenuService {

	/**
	 * 根据角色获取菜单
	 * 
	 * @param menu
	 * @return
	 */
	public List<Menu> findByRoleMenu(Menu menu) {
		return this.baseMapper.findByRoleMenu(menu);
	}

	/**
	 * 根据用户获取菜单
	 * @param menu
	 * @param isFindParentAndChild 是否查找父子节点
	 * @return
	 */
	public List<Menu> findByUserMenu(Menu menu, boolean isFindParentAndChild) {
		if(isFindParentAndChild) {
			List<Menu> menuList = findByStatusNormal(menu);
			return findParentAndChild(menuList, this.baseMapper.findByUserMenu(menu));
		}
		return this.baseMapper.findByUserMenu(menu);
	}

	/**
	 * 查询正常菜单
	 * 
	 * @param menu
	 * @return
	 */
	public List<Menu> findByStatusNormal(Menu menu) {
		QueryWrapper<Menu> queryWrapper = new QueryWrapper<Menu>();
		queryWrapper.eq("status", Menu.STATUS_NORMAL);
		if (menu.getMenuType() != null) {
			queryWrapper.eq("menuType", menu.getMenuType());
		}
		queryWrapper.orderByAsc("tree_sort");
		return this.select(queryWrapper);
	}

	/**
	 * 获取菜单的所有父节点，所有子节点
	 * 
	 * @param menuList     所有菜单
	 * @param roleMenuList 授权菜单
	 * @return
	 */
	public List<Menu> findParentAndChild(List<Menu> menuList, List<Menu> roleMenuList) {
		List<Menu> sourcelist = ListUtils.newArrayList();
		sourcelist.addAll(roleMenuList);
		for (Menu roleMenu : roleMenuList) {
			// 查找父节点
			String[] parentCodes = roleMenu.getParentCodes().split(",");
			for (String parentCode : parentCodes) {
				for (Menu menu : menuList) {
					if (parentCode.equalsIgnoreCase(menu.getMenuCode())) {
						sourcelist.add(menu);
					}
				}
			}
		}
		return sourcelist;
	}
}
