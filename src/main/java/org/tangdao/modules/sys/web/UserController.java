package org.tangdao.modules.sys.web;
//package org.tangdao.modules.sys.controller;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.tangdao.common.config.Global;
//import org.tangdao.common.suports.BaseController;
//import org.tangdao.common.suports.Page;
//import org.tangdao.common.utils.StringUtils;
//import org.tangdao.modules.sys.model.domain.Role;
//import org.tangdao.modules.sys.model.domain.User;
//import org.tangdao.modules.sys.service.IRoleService;
//import org.tangdao.modules.sys.service.IUserService;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.toolkit.Wrappers;
//
///**
// * <p>
// * 用户表 前端控制器
// * </p>
// *
// * @author ruyang
// * @since 2019-07-02
// */
//@Controller
//@RequestMapping("/sys/user")
//@PreAuthorize("isAuthenticated()")
//public class UserController extends BaseController {
//
//	@Autowired
//	private IUserService userService;
//
//	@Autowired
//	private IRoleService roleService;
//
//	@ModelAttribute
//	public User get(String userCode, boolean isNewRecord) {
//		return userService.get(userCode, isNewRecord);
//	}
//
//	@GetMapping("/list")
//	public String list(User user, Model model) {
//		return "modules/sys/userList";
//	}
//
//	@PostMapping("/listData")
//	public @ResponseBody Page<User> listData(User user, HttpServletRequest request) {
//		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//		
//		if(StringUtils.isNotBlank(user.getStatus())) {
//			queryWrapper.eq("status", user.getStatus());
//		}
//		if(StringUtils.isNotBlank(user.getUsername())) {
//			queryWrapper.likeRight("username", user.getUsername());
//		}
//		return this.userService.findPage(user, queryWrapper);
//	}
//
//	@GetMapping("/form")
//	public String form(User user, Model model) {
//		model.addAttribute("roles",
//				roleService.select(Wrappers.<Role>lambdaQuery().eq(Role::getStatus, Role.STATUS_NORMAL)));
////		Role r = new Role();
////		r.setUserCode(user.getUserCode());
////		user.setRoles(roleService.findByUserCode(user));
//		model.addAttribute("user", user);
//		return "modules/sys/userForm";
//	}
//
//	@PostMapping(value = "save")
//	public @ResponseBody String save(@Validated User user, String oldUsername, Model model) {
////		if (!"true".equals(checkPostName(oldRoleName, post.getPostName()))) {
////			return renderResult(Global.FALSE, text("保存岗位失败，岗位名称''{0}''已存在", post.getPostName()));
////		}
////		postService.save(post);
//		return renderResult(Global.TRUE, "操作成功");
//	}
//
//}
