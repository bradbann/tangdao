package org.tangdao.modules.sms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tangdao.common.suports.BaseController;
import org.tangdao.modules.sms.model.domain.SmsMtMessageSubmit;
import org.tangdao.modules.sms.service.ISmsMtSubmitService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 下行短信提交Controller
 * @author ruyang
 * @version 2019-09-06
 */
@Controller
@RequestMapping(value = "${adminPath}/sms/mtMessageSubmit")
public class SmsMtMessageSubmitController extends BaseController {

	@Autowired
	private ISmsMtSubmitService smsMtSubmitService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SmsMtMessageSubmit get(String id, boolean isNewRecord) {
		return smsMtSubmitService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(SmsMtMessageSubmit smsMtMessageSubmit, Model model) {
		model.addAttribute("smsMtMessageSubmit", smsMtMessageSubmit);
		return "modules/sms/mtMessageSubmitList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	public @ResponseBody IPage<SmsMtMessageSubmit> listData(SmsMtMessageSubmit smsMtMessageSubmit) {
		QueryWrapper<SmsMtMessageSubmit> queryWrapper = new QueryWrapper<SmsMtMessageSubmit>();
		
		
		return smsMtSubmitService.page(smsMtMessageSubmit.getPage(), queryWrapper);
	}
	
	
//
//	/**
//	 * 查看编辑表单
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtMessageSubmit:view')")
//	@RequestMapping(value = "form")
//	public String form(SmsMtMessageSubmit smsMtMessageSubmit, Model model) {
//		model.addAttribute("smsMtMessageSubmit", smsMtMessageSubmit);
//		return "modules/sms/MtMessageSubmitForm";
//	}
//
//	/**
//	 * 保存下行短信提交
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtMessageSubmit:edit')")
//	@PostMapping(value = "save")
//	public @ResponseBody String save(@Validated SmsMtMessageSubmit smsMtMessageSubmit) {
//		smsMtMessageSubmitService.saveOrUpdate(smsMtMessageSubmit);
//		return renderResult(Global.TRUE, "保存成功！");
//	}
//	
//	/**
//	 * 删除下行短信提交
//	 */
//	@PreAuthorize("hasAuthority('sms:smsMtMessageSubmit:edit')")
//	@RequestMapping(value = "delete")
//	public @ResponseBody String delete(SmsMtMessageSubmit smsMtMessageSubmit) {
//		smsMtMessageSubmitService.deleteById(smsMtMessageSubmit);
//		return renderResult(Global.TRUE, "删除成功！");
//	}
//	
}