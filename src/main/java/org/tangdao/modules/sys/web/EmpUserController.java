package org.tangdao.modules.sys.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.tangdao.common.utils.StringUtils;
import org.tangdao.modules.sys.model.domain.Employee;
import org.tangdao.modules.sys.model.domain.Post;
import org.tangdao.modules.sys.model.domain.User;
import org.tangdao.modules.sys.model.vo.EmpUser;
import org.tangdao.modules.sys.service.IEmployeeService;
import org.tangdao.modules.sys.service.IPostService;
import org.tangdao.modules.sys.service.IRoleService;
import org.tangdao.modules.sys.service.IUserService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * 员工Controller
 * @author ruyang
 * @version 2019-12-16
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/empUser")
public class EmpUserController extends BaseController {

	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IPostService postService;
	
	@Autowired
	private IUserService userService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public EmpUser getEmpUser(String userCode, boolean isNewRecord) {
		return employeeService.getEmpUserByUserCode(userCode, isNewRecord);
	}
	
	/**
	 * 机构管理主页面
	 */
	@RequestMapping(value = "index")
	public String index(Model model) {
		return "modules/sys/empUserIndex";
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(EmpUser empUser, Model model) {
		model.addAttribute("empUser", empUser);
		return "modules/sys/empUserList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	public @ResponseBody IPage<EmpUser> listData(Employee employee, EmpUser empUser, HttpServletRequest request, HttpServletResponse response) {
		return employeeService.findEmpUserPage(employee.getPage(), empUser);
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(EmpUser empUser, String op, Model model) {
		model.addAttribute("postList", postService.select(Wrappers.<Post>lambdaQuery().eq(Post::getStatus, Post.STATUS_NORMAL)));
		
		if (StringUtils.inString(op, Global.OP_AUTH)) {
			empUser.setRoles(roleService.findByUserCode(empUser.getUserCode()));
		}
		// 操作类型：add: 全部； edit: 编辑； auth: 授权
		model.addAttribute("op", op);
		model.addAttribute("empUser", empUser);
		return "modules/sys/empUserForm";
	}

	/**
	 * 保存员工
	 */
	@PostMapping(value = "save")
	public @ResponseBody String save(@Validated EmpUser empUser, String oldUsername, String op, Model model) {
		if (User.MGR_TYPE_DEFAULT_ADMIN.equals(empUser.getMgrType())&&!empUser.getCurrentUser().isSuperAdmin()){
			return renderResult(Global.FALSE, "越权操作，只有超级管理员才能修改此数据！");
		}
		if (User.isSuperAdmin(empUser.getUserCode())) {
			return renderResult(Global.FALSE, "非法操作，不能够操作此用户！");
		}
		if (!User.USER_TYPE_EMPLOYEE.equals(empUser.getUserType())){
			return renderResult(Global.FALSE, "非法操作，不能够操作此用户！");
		}
		if (!userService.checkUsernameExists(oldUsername, empUser.getUsername())) {
			return renderResult(Global.FALSE, "保存用户'" + empUser.getUsername() + "'失败，登录账号已存在");
		}
		if(StringUtils.inString(op, Global.OP_ADD, Global.OP_EDIT)) {
			employeeService.saveEmpUser(empUser);
		}
		if(StringUtils.inString(op, Global.OP_ADD, Global.OP_AUTH)) {
			userService.saveAuth(empUser);
		}
		return renderResult(Global.TRUE, "操作成功");
	}
	
//	/**
//	 * 停用员工
//	 */
//	@PreAuthorize("hasAuthority('sys:employee:edit')")
//	@RequestMapping(value = "disable")
//	public @ResponseBody String disable(Employee employee) {
//		employee.setStatus(Employee.STATUS_DISABLE);
//		employeeService.updateById(employee);
//		return renderResult(Global.TRUE, "停用成功");
//	}
//	
//	/**
//	 * 启用员工
//	 */
//	@PreAuthorize("hasAuthority('sys:employee:edit')")
//	@RequestMapping(value = "enable")
//	public @ResponseBody String enable(Employee employee) {
//		employee.setStatus(Employee.STATUS_NORMAL);
//		employeeService.updateById(employee);
//		return renderResult(Global.TRUE, "启用成功");
//	}
//	
//	/**
//	 * 删除员工
//	 */
//	@PreAuthorize("hasAuthority('sys:employee:edit')")
//	@RequestMapping(value = "delete")
//	public @ResponseBody String delete(Employee employee) {
//		employeeService.deleteById(employee);
//		return renderResult(Global.TRUE, "删除成功！");
//	}
	
}