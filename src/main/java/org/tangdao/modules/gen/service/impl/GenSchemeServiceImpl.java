package org.tangdao.modules.gen.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tangdao.common.config.Global;
import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.gen.mapper.GenSchemeMapper;
import org.tangdao.modules.gen.mapper.GenTableColumnMapper;
import org.tangdao.modules.gen.mapper.GenTableMapper;
import org.tangdao.modules.gen.model.domain.GenScheme;
import org.tangdao.modules.gen.model.domain.GenTable;
import org.tangdao.modules.gen.model.domain.GenTableColumn;
import org.tangdao.modules.gen.model.vo.GenConfig;
import org.tangdao.modules.gen.model.vo.GenTemplate;
import org.tangdao.modules.gen.utils.GenUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

@Service
public class GenSchemeServiceImpl extends CrudServiceImpl<GenSchemeMapper, GenScheme>{

	@Autowired
	private GenSchemeMapper genSchemeMapper;
	
	@Autowired
	private GenTableMapper genTableMapper;
	
	@Autowired
	private GenTableColumnMapper genTableColumnMapper;
	
	public IPage<GenScheme> page(IPage<GenScheme> page, QueryWrapper<GenScheme> queryWrapper) {
		GenUtils.getTemplatePath();
        return genSchemeMapper.selectPage(page, queryWrapper);
	}
	
	public String saveGenScheme(GenScheme genScheme) {
		super.saveOrUpdate(genScheme);
		// 生成代码
		if (Global.YES.equals(genScheme.getFlag())){
			return generateCode(genScheme);
		}
		return "";
	}
	
	private String generateCode(GenScheme genScheme){

		StringBuilder result = new StringBuilder();
		
		// 查询主表及字段列
		GenTable genTable = genTableMapper.selectById(genScheme.getGenTable().getId());
		genTable.setColumnList(genTableColumnMapper.findList(new GenTableColumn(new GenTable(genTable.getId()))));
		
		// 获取所有代码模板
		GenConfig config = GenUtils.getConfig();
		
		// 获取模板列表
		List<GenTemplate> templateList = GenUtils.getTemplateList(config, genScheme.getCategory(), false);
		List<GenTemplate> childTableTemplateList = GenUtils.getTemplateList(config, genScheme.getCategory(), true);
		
		// 如果有子表模板，则需要获取子表列表
		if (childTableTemplateList.size() > 0){
			QueryWrapper<GenTable> queryWrapper = new QueryWrapper<GenTable>();
			queryWrapper.eq("parent_table", genTable.getName());
			genTable.setChildList(genTableMapper.selectList(queryWrapper));
		}
		String projectPath = GenUtils.getProjectPath(null);
		System.out.println("----------------------------------"+projectPath);
		// 生成子表模板代码
		for (GenTable childTable : genTable.getChildList()){
			childTable.setParent(genTable);
			childTable.setColumnList(genTableColumnMapper.findList(new GenTableColumn(new GenTable(childTable.getId()))));
			genScheme.setGenTable(childTable);
			Map<String, Object> childTableModel = GenUtils.getDataModel(genScheme);
			for (GenTemplate tpl : childTableTemplateList){
				result.append(GenUtils.generateToFile(projectPath, tpl, childTableModel, genScheme.getReplaceFile()));
			}
		}
		
		// 生成主表模板代码
		genScheme.setGenTable(genTable);
		Map<String, Object> model = GenUtils.getDataModel(genScheme);
		for (GenTemplate tpl : templateList){
			result.append(GenUtils.generateToFile(projectPath, tpl, model, genScheme.getReplaceFile()));
		}
		return result.toString();
	}

}
