package org.tangdao.modules.sys.controller;


import javax.servlet.http.HttpServletRequest;

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
import org.tangdao.common.suports.Page;
import org.tangdao.common.utils.StringUtils;
import org.tangdao.modules.sys.model.domain.Role;
import org.tangdao.modules.sys.service.IMenuService;
import org.tangdao.modules.sys.service.IRoleService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author ruyang
 * @since 2019-07-02
 */
@Controller
@RequestMapping("/sys/role")
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
	public @ResponseBody Page<Role> listData(Role role){
		QueryWrapper<Role> queryWrapper = new QueryWrapper<Role>();
		
		if(StringUtils.isNotBlank(role.getStatus())) {
			queryWrapper.eq("status", role.getStatus());
		}
		if(StringUtils.isNotBlank(role.getRoleName())) {
			queryWrapper.likeRight("role_name", role.getRoleName());
		}
		return this.roleService.findPage(role, queryWrapper);
	}
	
	@RequestMapping(value = "form")
	public String form(Role role, Model model, String op){
		model.addAttribute("op", op);	
	    model.addAttribute("role", role);
		return "modules/sys/roleForm";
	}
	
	@PostMapping(value = "save")
	public @ResponseBody String save(@Validated Role role, String oldRoleCode, String oldRoleName, String[] menuCodes, String op, HttpServletRequest request){
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
	
//	@ResponseBody
//	@PostMapping(value = "delete")
//	public String delete(Role role){
//		if(Role.TENANT_ADMIN_ROLE_ID.equals(role.getRoleId())) {
//			return this.renderResult(Global.FALSE, "非法操作，此角色为内置角色，不允许删除！");
//		}else {
//			if(Global.YES.equals(role.getIsSys())&&!role.getShiroUser().isSuperAdmin()) {
//				return renderResult(Global.FALSE, "越权操作，只有超级管理员才能操作此数据");
//			}else {
//				roleService.deleteByPrimaryKey(role);
//				return renderResult(Global.TRUE, "角色删除成功");
//			}
//		}
//	}
//	
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
//	
//	@ResponseBody
//	@RequestMapping(value = "menuTreeData")
//	public Map<String, Object> treeMenu(Role role){
//		String mgrType = role.getShiroUser().getParam("mgrType");
//		Map<String, Object> resultMap = new HashMap<>();
//		Map<String, List<Map<String, Object>>> menuMap = new HashMap<>();
//		Map<String, List<String>> defaultMenuIdMap = new HashMap<>();
//		Example example = new Example(Menu.class);
//		example.and().andEqualTo("status", Menu.STATUS_NORMAL);
//		if(User.isSuperAdmin(role.getShiroUser().getId())) {
//			example.and().andLessThan("weight", Menu.WEIGHT_SUPER_ADMIN);
//		} else if(User.MGR_TYPE_TENANT_ADMIN.equals(mgrType)) {
//			example.and().andLessThan("weight", Menu.WEIGHT_TENANT_ADMIN);
//		} else if(User.MGR_TYPE_SEC_ADMIN.equals(mgrType)) {
//			example.and().andLessThan("weight", Menu.WEIGHT_SEC_ADMIN);
//		}else {
//			example.and().andLessThan("weight", Menu.WEIGHT_DEFAULT);
//		}
//		
//		example.setOrderByClause("sys_id, tree_sort, menu_id ");
//		List<Menu> menuList =  menuService.selectByExample(example);
//		List<Map<String, Object>> tempList = null;
//		Map<String, Object> tempMap = null;
//		for (Menu menu : menuList) {
//			String sysId = menu.getSysId();
//			tempMap = MapUtils.newHashMap();
//			tempMap.put("id", menu.getMenuId());
//			tempMap.put("pId", menu.getParentId());
//			tempMap.put("name", menu.getMenuName());
//			tempMap.put("title", menu.getMenuName());
//			if(menuMap.containsKey(sysId)) {
//				tempList = menuMap.get(sysId);
//				tempList.add(tempMap);
//			}else {
//				tempList = new ArrayList<>();
//				tempList.add(tempMap);
//				menuMap.put(sysId, tempList);
//			}
//		}
//		for (Map.Entry<String, List<Map<String, Object>>> entry : menuMap.entrySet()) {
////			List<Map<String, Object>> targetList = new ArrayList<>();
////			menuService.execChildListBulid(entry.getValue(), targetList, Menu.ROOT_ID);
//			
//			List<String> defaultMenuId = new ArrayList<>();
//			if(StringUtils.isNotBlank(role.getRoleId())) {
//				Menu menu = new Menu();
//				menu.setRoleId(role.getRoleId());
//				menu.setSysId(entry.getKey());
//				menuList = menuService.findByRoleId(menu);
//				for (Menu m : menuList) {
//					defaultMenuId.add(m.getMenuId());
//				}
//			}
////			menuMap.put(entry.getKey(), targetList);
//			menuMap.put(entry.getKey(), entry.getValue());
//			defaultMenuIdMap.put(entry.getKey(), defaultMenuId);
//		}
//		
//		resultMap.put("treeMenuMap", menuMap);
//		resultMap.put("defaultMenuIdMap", defaultMenuIdMap);
////		resultMap.put("role", role);
////		return renderResult(Global.TRUE, "启用成功", resultMap);
//		return resultMap;
//	}
}
