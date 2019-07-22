package org.tangdao.modules.sys.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.tangdao.common.config.Global;
import org.tangdao.common.service.impl.TreeServiceImpl;
import org.tangdao.common.utils.ListUtils;
import org.tangdao.common.utils.StringUtils;
import org.tangdao.modules.sys.mapper.MenuMapper;
import org.tangdao.modules.sys.model.domain.Menu;
import org.tangdao.modules.sys.model.domain.Role;
import org.tangdao.modules.sys.model.domain.User;
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
	public List<Menu> findByRoleCode(Menu menu) {
		return this.baseMapper.findByRoleCode(menu);
	}

	/**
	 * 根据用户获取菜单
	 * 
	 * @param menu
	 * @return
	 */
	public List<Menu> findByUserCode(Menu menu) {
		List<Menu> menuList = findByStatusNormal(menu);
		return findParentAndChild(menuList, this.baseMapper.findByUserCode(menu));
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
	

	public List<Menu> findByUser(User user) {
//		String sysId = ObjectUtils.toStringIgnoreNull(getSession().getAttribute("sysId"), Menu.SYS_ID_DEFAULT);
//		StringBuffer key = new StringBuffer("menuList_" + sysId);
//		if (StringUtils.isNotBlank(parentId)) {
//			key.append("_" + parentId);
//		}
//		List<Menu> list = (List<Menu>) UserUtils.getCache(key.toString());
//		if (list != null) {
//			return list;
//		}
//		Menu menu = new Menu();
//		menu.setSysId(sysId);
//		menu.setParentId(parentId);
//		User user = null;
		List<Menu> menus = null;
		if(user.isSuperAdmin()) {
			QueryWrapper<Menu> queryWrapper = new QueryWrapper<Menu>();
			queryWrapper.ne("status", Menu.STATUS_DELETE);
			queryWrapper.ge("weight", Menu.SUPER_ADMIN_GET_MENU_MIN_WEIGHT);
			
			queryWrapper.orderByAsc("tree_sort");
			menus = this.select(queryWrapper);
		} else {
			Menu menu = new Menu();
			// 获取用户类型指定默认角色
			String defaultRoleCodes = Global.getConfig("sys.user.defaultRoleCodes." + user.getUserType());
			if (!User.USER_TYPE_NONE.equals(user.getUserType()) && StringUtils.isNotBlank(defaultRoleCodes)) {
				menu.setDefaultRoleCodes(Arrays.asList(StringUtils.split(defaultRoleCodes, ",")));
			}
			// 管理员角色追加
			if (user.isAdmin()) {
				Collection<String> roleCodes = menu.getDefaultRoleCodes();
				if (ListUtils.isEmpty(roleCodes)) {
					roleCodes = new ArrayList<>();
					menu.setDefaultRoleCodes(roleCodes);
				}
				roleCodes.add(Role.DEFAULT_ADMIN_ROLE_CODE);
				menu.setDefaultRoleCodes(roleCodes);
			}
			menu.setUserCode(user.getUserCode());
//			menu.setParentCode(parentCode);
			menus = findByUserCode(menu);
		}
//		UserUtils.putCache(key.toString(), menus);
		return menus;
	}
}
