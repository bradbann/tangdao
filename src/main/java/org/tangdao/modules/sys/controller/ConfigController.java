//package org.tangdao.modules.sys.controller;
//
//
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
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
//import org.tangdao.modules.sys.model.domain.Config;
//import org.tangdao.modules.sys.service.IConfigService;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//
///**
// * <p>
// * 参数配置表 前端控制器
// * </p>
// *
// * @author ruyang
// * @since 2019-07-02
// */
//@Controller
//@RequestMapping("/sys/config")
//public class ConfigController extends BaseController {
//
//	@Autowired
//	private IConfigService configService;
//	
//	@ModelAttribute
//	public Config get(String id, boolean isNewRecord) {
//		return configService.get(id, isNewRecord);
//	}
//	
//	@GetMapping("/list")
//	public String list(Config config, Model model) {
//		return "modules/sys/configList";
//	}
//
//	@PostMapping("/listData")
//	public @ResponseBody Page<Config> listData(Config config) {
//		QueryWrapper<Config> wrapper = new QueryWrapper<Config>();
//		if(StringUtils.isNotBlank(config.getStatus())) {
//			wrapper.eq("status", config.getStatus());
//		}
//		if(StringUtils.isNotBlank(config.getConfigName())) {
//			wrapper.likeRight("config_name", config.getConfigName());
//		}
//		return this.configService.findPage(config, wrapper);
//	}
//	
//	@GetMapping("/form")
//	public String form(Config config, Model model) {
//		model.addAttribute("config", config);
//		return "modules/sys/configForm";
//	}
//	
//	@PostMapping(value = "save")
//	public @ResponseBody String save(@Validated Config config) {
//		configService.saveOrUpdate(config);
//		return renderResult(Global.TRUE, "保存成功");
//	}
//}
