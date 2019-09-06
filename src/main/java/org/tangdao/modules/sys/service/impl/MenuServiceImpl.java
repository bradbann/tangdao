package org.tangdao.modules.sys.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.tangdao.common.config.Contents;
import org.tangdao.common.service.impl.TreeServiceImpl;
import org.tangdao.common.utils.ListUtils;
import org.tangdao.common.utils.MapUtils;
import org.tangdao.common.utils.StringUtils;
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
	
	@Resource
	RedisTemplate<String, Object> redisTemplate;
	
	@SuppressWarnings("unchecked")
	public String getMenuNamePath(String href, String permission) {	
		Map<String, String> menuNamePathMap = (Map<String, String>) this.redisTemplate.opsForValue().get(Contents.CACHE_MENU_NAME_PATH_MAP);
		if(menuNamePathMap==null) {
			menuNamePathMap = MapUtils.newLinkedHashMap();
			List<Menu> menuList = this.findByStatusNormal(new Menu());
			for (Menu menu : menuList) {
				 String menuHref = StringUtils.substringBefore(menu.getMenuHref(), "?");
				 if (StringUtils.isNotBlank(menuHref)) {
					 if (StringUtils.endsWith(menuHref, "/")) {	
						 menuHref = StringUtils.substring(menuHref, menuHref.length() - 1);
                     }	
					 menuNamePathMap.put(menuHref, menu.getTreeNames());	
					 menuNamePathMap.put(StringUtils.substringBeforeLast(menuHref, "/"), menu.getTreeNames());	
				 }
				 if (!StringUtils.isNotBlank(menu.getPermission())) continue;
				 String[] pers = StringUtils.split(menu.getPermission(), ",");
				 for (String p : pers) {
					 menuNamePathMap.put(p, menu.getTreeNames());	
					 menuNamePathMap.put(StringUtils.substringBeforeLast(p, ":"), StringUtils.substringBeforeLast(menu.getTreeNames(), "/"));	
				 }
			}
			this.redisTemplate.opsForValue().set(Contents.CACHE_MENU_NAME_PATH_MAP, menuNamePathMap);
		}
		if (StringUtils.endsWith(href, "/")) {	
            String string = href;	
            href = StringUtils.substring(string, string.length() - 1);	
        }
		String s;
		if((s=menuNamePathMap.get(href))==null) {
			String[] pers = StringUtils.split(permission, ",");
			for (String p : pers) {
				s = menuNamePathMap.get(p);
				if (StringUtils.isNotBlank(s)) {
					return s;
				}
			}
		}
		if(s==null) {
			 s = menuNamePathMap.get(StringUtils.substringBeforeLast(href, "/"));	
		}
		if(s==null) {
			return StringUtils.EMPTY;
		}
		return s;
	}
}
