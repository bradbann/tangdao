package org.tangdao.modules.sys.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tangdao.common.config.Global;
import org.tangdao.common.suports.BaseController;
import org.tangdao.common.utils.StringUtils;

/**
 * @ClassName: GlobalController.java
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ruyang
 * @date 2019年3月1日 上午10:04:23
 * 
 */
@Controller
public class GlobalController extends BaseController {

	@RequestMapping({ "" })
	public String defaultPath() {
		return REDIRECT + Global.getConfig("web.defaultPath", "/");
	}

	@RequestMapping({ "error/{status}" })
	public String error(@PathVariable String status) {
		return "error/" + status;
	}
	
	@RequestMapping({ "components/{path}" })
	public String components(@PathVariable String path) {
		return "fragments/components/" + path;
	}

	@RequestMapping({ "/global.min.js" })
	@ResponseBody
	public String globalJs(String ctx, HttpServletRequest request, Model model) {
		StringBuilder bui = new StringBuilder();
		String ctxPath = request.getContextPath();
		bui.append("ctx='").append(StringUtils.defaultIfBlank(ctx, ctxPath)).append("',");
		bui.append("ctxPath='").append(ctxPath).append("',");
		bui.append("ctxAdmin='").append(ctxPath).append(Global.getAdminPath()+"',");
		bui.append("ctxStatic='").append(ctxPath).append("/static',");
		bui.append("Global=").append(Global.getConst("Global.Fields"));
		return bui.toString();
	}
}
