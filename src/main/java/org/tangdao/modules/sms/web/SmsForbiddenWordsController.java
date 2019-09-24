//package org.tangdao.modules.sms.web;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.tangdao.common.config.Global;
//import org.tangdao.common.suports.BaseController;
//import org.tangdao.modules.sms.model.domain.SmsForbiddenWords;
//import org.tangdao.modules.sms.service.ISmsForbiddenWordsService;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//
///**
// * 告警敏感词Controller
// * @author ruyang
// * @version 2019-09-06
// */
//@Controller
//@RequestMapping(value = "${adminPath}/sms/ForbiddenWords")
//public class SmsForbiddenWordsController extends BaseController {
//
//	@Autowired
//	private ISmsForbiddenWordsService smsForbiddenWordsService;
//	
//	/**
//	 * 获取数据
//	 */
//	@ModelAttribute
//	public SmsForbiddenWords get(String id, boolean isNewRecord) {
//		return smsForbiddenWordsService.get(id, isNewRecord);
//	}
//	
//	/**
//	 * 查询列表
//	 */
//	@PreAuthorize("hasAuthority('sms:smsForbiddenWords:view')")
//	@RequestMapping(value = {"list", ""})
//	public String list(SmsForbiddenWords smsForbiddenWords, Model model) {
//		model.addAttribute("smsForbiddenWords", smsForbiddenWords);
//		return "modules/sms/ForbiddenWordsList";
//	}
//	
//	/**
//	 * 查询列表数据
//	 */
//	@PreAuthorize("hasAuthority('sms:smsForbiddenWords:view')")
//	@RequestMapping(value = "listData")
//	public @ResponseBody IPage<SmsForbiddenWords> listData(SmsForbiddenWords smsForbiddenWords, HttpServletRequest request, HttpServletResponse response) {
//		QueryWrapper<SmsForbiddenWords> queryWrapper = new QueryWrapper<SmsForbiddenWords>();
//		return smsForbiddenWordsService.page(smsForbiddenWords.getPage(), queryWrapper);
//	}
//
//	/**
//	 * 查看编辑表单
//	 */
//	@PreAuthorize("hasAuthority('sms:smsForbiddenWords:view')")
//	@RequestMapping(value = "form")
//	public String form(SmsForbiddenWords smsForbiddenWords, Model model) {
//		model.addAttribute("smsForbiddenWords", smsForbiddenWords);
//		return "modules/sms/ForbiddenWordsForm";
//	}
//
//	/**
//	 * 保存告警敏感词
//	 */
//	@PreAuthorize("hasAuthority('sms:smsForbiddenWords:edit')")
//	@PostMapping(value = "save")
//	public @ResponseBody String save(@Validated SmsForbiddenWords smsForbiddenWords) {
//		smsForbiddenWordsService.saveOrUpdate(smsForbiddenWords);
//		return renderResult(Global.TRUE, "保存成功！");
//	}
//	
//	/**
//	 * 停用告警敏感词
//	 */
//	@PreAuthorize("hasAuthority('sms:smsForbiddenWords:edit')")
//	@RequestMapping(value = "disable")
//	public @ResponseBody String disable(SmsForbiddenWords smsForbiddenWords) {
//		smsForbiddenWords.setStatus(SmsForbiddenWords.STATUS_DISABLE);
//		smsForbiddenWordsService.updateById(smsForbiddenWords);
//		return renderResult(Global.TRUE, "停用成功");
//	}
//	
//	/**
//	 * 启用告警敏感词
//	 */
//	@PreAuthorize("hasAuthority('sms:smsForbiddenWords:edit')")
//	@RequestMapping(value = "enable")
//	public @ResponseBody String enable(SmsForbiddenWords smsForbiddenWords) {
//		smsForbiddenWords.setStatus(SmsForbiddenWords.STATUS_NORMAL);
//		smsForbiddenWordsService.updateById(smsForbiddenWords);
//		return renderResult(Global.TRUE, "启用成功");
//	}
//	
//	/**
//	 * 删除告警敏感词
//	 */
//	@PreAuthorize("hasAuthority('sms:smsForbiddenWords:edit')")
//	@RequestMapping(value = "delete")
//	public @ResponseBody String delete(SmsForbiddenWords smsForbiddenWords) {
//		smsForbiddenWordsService.deleteById(smsForbiddenWords);
//		return renderResult(Global.TRUE, "删除成功！");
//	}
//	
//}