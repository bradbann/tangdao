package org.tangdao.modules.sys.web;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tangdao.common.config.Global;
import org.tangdao.common.suports.BaseController;
import org.tangdao.common.suports.TreeEntity;
import org.tangdao.common.utils.ListUtils;
import org.tangdao.common.utils.MapUtils;
import org.tangdao.common.utils.StringUtils;
import org.tangdao.modules.sys.model.domain.Menu;
import org.tangdao.modules.sys.model.domain.Role;
import org.tangdao.modules.sys.service.IMenuService;
import org.tangdao.modules.sys.service.IRoleService;
import org.tangdao.modules.sys.utils.UserUtils;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author ruyang
 * @since 2019-07-02
 */
@Controller
@RequestMapping("${adminPath}/sys/role")
public class RoleController extends BaseController {

	@Autowired
	IRoleService roleService;
	
	@Autowired
	IMenuService menuService;
	
	@ModelAttribute
	public Role get(String roleCode, boolean isNewRecord) {
		return roleService.get(roleCode, isNewRecord);
	}
	
	@RequestMapping(value = "list")
	public String list(Role role, Model model){
		return "modules/sys/roleList";
	}
	
	@RequestMapping(value = "listData")
	public @ResponseBody IPage<Role> listData(Role role){
		QueryWrapper<Role> queryWrapper = new QueryWrapper<Role>();
		
		if(StringUtils.isNotBlank(role.getStatus())) {
			queryWrapper.eq("status", role.getStatus());
		}
		if(StringUtils.isNotBlank(role.getRoleName())) {
			queryWrapper.likeRight("role_name", role.getRoleName());
		}
		
		return this.roleService.page(role.getPage(), queryWrapper);
	}
	
	@RequestMapping(value = "form")
	public String form(Role role, Model model, String op){
		model.addAttribute("op", op);	
	    model.addAttribute("role", role);
		return "modules/sys/roleForm";
	}
	
	@PostMapping(value = "save")
	public @ResponseBody String save(@Validated Role role, String oldRoleName, String[] menuCodes, String op){
		if (!roleService.checkRoleNameExists(oldRoleName, role.getRoleName())) {	
			return this.renderResult(Global.FALSE, "保存失败，角色名称已存在");	
		}
		
		if (StringUtils.inString(op, "add", "edit")) {	
			roleService.saveOrUpdate(role);
		}
		
		if (StringUtils.inString(op, "add", "auth")) {	
			roleService.insertRoleMenu(role, menuCodes);
		}
		
		return renderResult(Global.TRUE,"保存成功");
	}
	
	@PostMapping(value = "delete")
	public @ResponseBody String delete(Role role){
		if(Role.DEFAULT_ADMIN_ROLE_CODE.equals(role.getRoleCode())) {
			return this.renderResult(Global.FALSE, "非法操作，此角色为内置角色，不允许删除！");
		}else {
			roleService.deleteById(role);
			return renderResult(Global.TRUE, "角色删除成功");
		}
	}
	
//	@ResponseBody
//	@PostMapping(value = "disable")
//	public String disable(Role role){
//		if(Global.YES.equals(role.getIsSys())&&!role.getShiroUser().isSuperAdmin()) {
//			return renderResult(Global.FALSE, "越权操作，只有超级管理员才能操作此数据");
//		}else {
//			role.setStatus(Role.STATUS_DISABLE);
//			roleService.updateByPrimaryKeySelective(role);
//			return renderResult(Global.TRUE, "停用成功");
//		}
//	}
//	
//	@ResponseBody
//	@PostMapping(value = "enable")
//	public String enable(Role role){
//		if(Global.YES.equals(role.getIsSys())&&!role.getShiroUser().isSuperAdmin()) {
//			return renderResult(Global.FALSE, "越权操作，只有超级管理员才能操作此数据");
//		}else {
//			role.setStatus(Role.STATUS_NORMAL);
//			roleService.updateByPrimaryKeySelective(role);
//			return renderResult(Global.TRUE, "启用成功");
//		}
//	}
	
	@RequestMapping(value = "treeData")
	public @ResponseBody List<Map<String, Object>> listDataNormal(Role role, Boolean isAll, String isShowCode){
		List<Map<String, Object>> list = ListUtils.newLinkedList();
		LambdaQueryWrapper<Role> queryWrapper = Wrappers.<Role>lambdaQuery();
		queryWrapper.eq(Role::getStatus, Role.STATUS_NORMAL);
		if(isAll==null || !isAll.booleanValue()) {
			queryWrapper.eq(Role::getUserType, role.getUserType());
		}
		roleService.select(queryWrapper).forEach(item->{
			Map<String, Object> e = MapUtils.newHashMap();
			e.put("id", item.getKey());
			e.put("pId", TreeEntity.ROOT_CODE);
			e.put("name", StringUtils.getTreeNodeName(isShowCode, item.getRoleCode(), item.getRoleName()));
			e.put("remarks", item.getRemarks());
			list.add(e);
		});
		return list;
	}
	
	@RequestMapping(value = "menuTreeData")
	public @ResponseBody Map<String, Object> treeMenu(Role role, String isShowCode){
		Map<String, Object> resultMap = MapUtils.newHashMap();
		QueryWrapper<Menu> queryWrapper = new QueryWrapper<Menu>();
		queryWrapper.eq("status", Menu.STATUS_NORMAL);
		if(UserUtils.getUser().isSuperAdmin()) {
			queryWrapper.lt("weight", Menu.WEIGHT_SUPER_ADMIN);
		} else if(UserUtils.getUser().isAdmin()) {
			queryWrapper.lt("weight", Menu.WEIGHT_DEFAULT_ADMIN);
		} else {
			queryWrapper.lt("weight", Menu.WEIGHT_DEFAULT);
		}
		queryWrapper.orderByAsc("tree_sort","menu_code");
		
		List<Menu> menuList =  menuService.select(queryWrapper);
		List<Map<String, Object>> menus = ListUtils.newArrayList();
		Map<String, Object> tempMap = null;
		for (Menu menu : menuList) {
			tempMap = MapUtils.newHashMap();
			tempMap.put("id", menu.getMenuCode());
			tempMap.put("pId", menu.getParentCode());
			tempMap.put("name", StringUtils.getTreeNodeName(isShowCode, menu.getMenuCode(), menu.getMenuName()));
			
			menus.add(tempMap);
		}
		
		List<String> roleMenuCodes = ListUtils.newArrayList();
		if(StringUtils.isNotBlank(role.getRoleCode())) {
			Menu menu = new Menu();
			menu.setRoleCode(role.getRoleCode());
			menuList = menuService.findByRoleMenu(menu);
			for (Menu m : menuList) {
				roleMenuCodes.add(m.getMenuCode());
			}
		}
		
		resultMap.put("menuList", menus);
		
		resultMap.put("roleMenuCodes", roleMenuCodes);
		return resultMap;
	}
}
