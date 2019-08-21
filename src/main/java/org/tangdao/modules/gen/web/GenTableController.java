package org.tangdao.modules.gen.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tangdao.common.suports.BaseController;
import org.tangdao.common.utils.StringUtils;
import org.tangdao.modules.gen.model.domain.GenTable;
import org.tangdao.modules.gen.service.GenTableService;
import org.tangdao.modules.gen.utils.GenUtils;
import org.tangdao.modules.sys.model.domain.DictType;
import org.tangdao.modules.sys.service.IDictTypeService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

@Controller
@RequestMapping(value = "${adminPath}/genTable")
public class GenTableController extends BaseController {
	
	@Autowired
	private IDictTypeService dictTypeService;
	
	@Autowired
	private GenTableService genTableService;
	
	@ModelAttribute
	public GenTable get(String tableName) {
		GenTable genTable;
		if(StringUtils.isNoneEmpty(tableName)&&(genTable =genTableService.get(tableName))!=null) {
			return genTable;
		}
		return new GenTable();
	}
	
	@RequestMapping(value = "list")
	public String list(GenTable genTable, Model model){
		return "modules/gen/tableList";
	}
	
	@RequestMapping({"listData"})
	public @ResponseBody IPage<GenTable> listData(GenTable genTable) {
		QueryWrapper<GenTable> queryWrapper = new QueryWrapper<GenTable>();
		return genTableService.page(genTable.getPage(), queryWrapper);
	}
	
	@RequestMapping(value = "form")
	public String form(GenTable genTable, String op, Model model) {
		boolean newRecord;
		// 验证表是否存在
		if ((newRecord=genTable.getIsNewRecord())&&StringUtils.isNotBlank(genTable.getTableName()) && !genTableService.checkTableName(genTable.getTableName())){
			model.addAttribute("message", "下一步失败！" + genTable.getTableName() + " 表已经添加！自动跳转到编辑");
			return "redirect:"+this.adminPath+"/genTable/form?table_name="+genTable.getTableName();
		}else{
			genTable = genTableService.getTableFormDb(genTable);
			if(newRecord) {
				genTable.setIsNewRecord(newRecord);
			}
			model.addAttribute("genTable", genTable);
			model.addAttribute("config",  GenUtils.getConfig());
			QueryWrapper<DictType> queryWrapper = new QueryWrapper<DictType>();
			List<DictType> dictTypeList = this.dictTypeService.select(queryWrapper);
			model.addAttribute("dictTypeList",  dictTypeList);
			
			if (StringUtils.isBlank(genTable.getTableName())) {
				
				// 获取物理表列表
				List<GenTable> tableList = genTableService.findTableListFormDb(new GenTable());
				model.addAttribute("tableList", tableList);
				
				return "modules/gen/tableFormSelect";
			}else {
				List<GenTable> tableList = this.genTableService.select();
				model.addAttribute("tableList", tableList);
				if (StringUtils.isBlank(op)) {
		               op = "step1";
		        }
			}
			
		}
		model.addAttribute("op", op);
		return "modules/gen/tableForm";
	}
	
//	@ResponseBody
//	@PostMapping(value = "save")
//	public void save(GenTable genTable) {
////		if (!beanValidator(model, genTable)){
////			return form(genTable, model);
////		}
//		// 验证表是否已经存在
//		if (StringUtils.isBlank(genTable.getId()) && !genTableService.checkTableName(genTable.getName())){
////			addMessage(model, "保存失败！" + genTable.getName() + " 表已经存在！");
////			return form(genTable, model);
////			genTable.setName(null);
//			this.err("保存失败！");
//		}else{
//			genTableService.save(genTable);
//			this.succ("恭喜，保存业务表'" + genTable.getName() + "'成功！");
//		}
////		addMessage(redirectAttributes, "保存业务表'" + genTable.getName() + "'成功");
////		return "redirect:" + adminPath + "/gen/genTable/?repage";
//	}
//	
////	@RequiresPermissions("gen:genTable:edit")
//	@ResponseBody
//	@PostMapping(value = "delete")
//	public void delete(GenTable genTable) {
//		genTableService.delete(genTable);
//		this.succ("删除业务表'" + genTable.getName() + "'成功！");
//	};

}
