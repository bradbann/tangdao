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
//import org.tangdao.modules.sms.model.domain.SmsPriorityWords;
//import org.tangdao.modules.sms.service.ISmsPriorityWordsService;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//
///**
// * 优先级词库配置Controller
// * @author ruyang
// * @version 2019-09-06
// */
//@Controller
//@RequestMapping(value = "${adminPath}/sms/PriorityWords")
//public class SmsPriorityWordsController extends BaseController {
//
//	@Autowired
//	private ISmsPriorityWordsService smsPriorityWordsService;
//	
//	/**
//	 * 获取数据
//	 */
//	@ModelAttribute
//	public SmsPriorityWords get(String id, boolean isNewRecord) {
//		return smsPriorityWordsService.get(id, isNewRecord);
//	}
//	
//	/**
//	 * 查询列表
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPriorityWords:view')")
//	@RequestMapping(value = {"list", ""})
//	public String list(SmsPriorityWords smsPriorityWords, Model model) {
//		model.addAttribute("smsPriorityWords", smsPriorityWords);
//		return "modules/sms/PriorityWordsList";
//	}
//	
//	/**
//	 * 查询列表数据
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPriorityWords:view')")
//	@RequestMapping(value = "listData")
//	public @ResponseBody IPage<SmsPriorityWords> listData(SmsPriorityWords smsPriorityWords, HttpServletRequest request, HttpServletResponse response) {
//		QueryWrapper<SmsPriorityWords> queryWrapper = new QueryWrapper<SmsPriorityWords>();
//		return smsPriorityWordsService.page(smsPriorityWords.getPage(), queryWrapper);
//	}
//
//	/**
//	 * 查看编辑表单
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPriorityWords:view')")
//	@RequestMapping(value = "form")
//	public String form(SmsPriorityWords smsPriorityWords, Model model) {
//		model.addAttribute("smsPriorityWords", smsPriorityWords);
//		return "modules/sms/PriorityWordsForm";
//	}
//
//	/**
//	 * 保存优先级词库配置
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPriorityWords:edit')")
//	@PostMapping(value = "save")
//	public @ResponseBody String save(@Validated SmsPriorityWords smsPriorityWords) {
//		smsPriorityWordsService.saveOrUpdate(smsPriorityWords);
//		return renderResult(Global.TRUE, "保存成功！");
//	}
//	
//	/**
//	 * 停用优先级词库配置
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPriorityWords:edit')")
//	@RequestMapping(value = "disable")
//	public @ResponseBody String disable(SmsPriorityWords smsPriorityWords) {
//		smsPriorityWords.setStatus(SmsPriorityWords.STATUS_DISABLE);
//		smsPriorityWordsService.updateById(smsPriorityWords);
//		return renderResult(Global.TRUE, "停用成功");
//	}
//	
//	/**
//	 * 启用优先级词库配置
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPriorityWords:edit')")
//	@RequestMapping(value = "enable")
//	public @ResponseBody String enable(SmsPriorityWords smsPriorityWords) {
//		smsPriorityWords.setStatus(SmsPriorityWords.STATUS_NORMAL);
//		smsPriorityWordsService.updateById(smsPriorityWords);
//		return renderResult(Global.TRUE, "启用成功");
//	}
//	
//	/**
//	 * 删除优先级词库配置
//	 */
//	@PreAuthorize("hasAuthority('sms:smsPriorityWords:edit')")
//	@RequestMapping(value = "delete")
//	public @ResponseBody String delete(SmsPriorityWords smsPriorityWords) {
//		smsPriorityWordsService.deleteById(smsPriorityWords);
//		return renderResult(Global.TRUE, "删除成功！");
//	}
//	
//}