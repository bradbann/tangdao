package org.tangdao.modules.sys.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tangdao.common.suports.BaseController;
import org.tangdao.common.suports.Page;
import org.tangdao.modules.sys.model.domain.User;
import org.tangdao.modules.sys.model.dto.UserDTO;
import org.tangdao.modules.sys.service.IUserService;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author ruyang
 * @since 2019-07-02
 */
@Controller
@RequestMapping("/sys/user")
public class UserController extends BaseController {
	
	private IUserService userService;
	
	@Autowired
	private UserController(IUserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/list")
	public String list(User user, Model model) {
		return "modules/sys/userList";
	}

	@RequestMapping("/listData")
	public @ResponseBody Page listData(@RequestBody UserDTO userDTO) {
		return this.userService.findPage(userDTO.getPagination(), userDTO.getSort());
	}

}
