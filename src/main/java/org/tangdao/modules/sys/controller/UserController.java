package org.tangdao.modules.sys.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tangdao.common.suports.BaseController;
import org.tangdao.modules.sys.entity.User;

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

	@RequestMapping(value = "list")
	public String list(User user, Model model) {
		return "modules/sys/userList";
	}

//	@RequestMapping(value = "listData")
//	@ResponseBody
//	public Page<User> listData(User user, HttpServletRequest request, HttpServletResponse response) {
//		user.setMgrType(User.MGR_TYPE_CORP_ADMIN);	// 租户管理员
//		// 禁用自动添加租户代码条件，添加自定义租户查询条件
//		user.getSqlMap().getWhere().disableAutoAddCorpCodeWhere()
//			.and("corp_code", QueryType.EQ, user.getCorpCode_())
//			.and("corp_name", QueryType.LIKE, user.getCorpName_());
//		user.setPage(new Page<>(request, response));
//		Page<User> page = userService.findPage(user);
//		return page;
//	}

}
