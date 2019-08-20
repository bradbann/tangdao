package org.tangdao.modules.gen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.common.utils.StringUtils;
import org.tangdao.modules.gen.mapper.GenDataDictMapper;
import org.tangdao.modules.gen.mapper.GenTableColumnMapper;
import org.tangdao.modules.gen.mapper.GenTableMapper;
import org.tangdao.modules.gen.model.domain.GenTable;
import org.tangdao.modules.gen.model.domain.GenTableColumn;
import org.tangdao.modules.gen.utils.GenUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

@Service
public class GenTableServiceImpl extends CrudServiceImpl<GenTableMapper, GenTable>{

	@Autowired
	private GenTableMapper genTableMapper;
	@Autowired
	private GenTableColumnMapper genTableColumnMapper;
	@Autowired
	private GenDataDictMapper genDataDictMapper;
	
	public GenTable get(String id) {
		GenTable genTable = genTableMapper.selectById(id);
		GenTableColumn genTableColumn = new GenTableColumn();
		genTableColumn.setGenTable(new GenTable(genTable.getId()));
		genTable.setColumnList(genTableColumnMapper.findList(genTableColumn));
		return genTable;
	}
	
	/**
	 * 获取物理数据表列表
	 * @param genTable
	 * @return
	 */
	public List<GenTable> findTableListFormDb(GenTable genTable){
		return genDataDictMapper.findTableList(genTable);
	}
	
	/**
	 * 验证表名是否可用，如果已存在，则返回false
	 * @param genTable
	 * @return
	 */
	public boolean checkTableName(String tableName){
		if (StringUtils.isBlank(tableName)){
			return true;
		}
		QueryWrapper<GenTable> queryWrapper = new QueryWrapper<GenTable>();
		return genTableMapper.selectCount(queryWrapper)==0;
	}
	
	/**
	 * 获取物理数据表列表
	 * @param genTable
	 * @return
	 */
	public GenTable getTableFormDb(GenTable genTable){
		// 如果有表名，则获取物理表
		if (StringUtils.isNotBlank(genTable.getName())){
			
			List<GenTable> list = genDataDictMapper.findTableList(genTable);
			if (list.size() > 0){
				
				// 如果是新增，初始化表属性
				if (StringUtils.isBlank(genTable.getId())){
					genTable = list.get(0);
					// 设置字段说明
					if (StringUtils.isBlank(genTable.getComments())){
						genTable.setComments(genTable.getName());
					}
					genTable.setClassName(StringUtils.capCamelCase(genTable.getName()));
				}
				
				// 添加新列
				List<GenTableColumn> columnList = genDataDictMapper.findTableColumnList(genTable);
				for (GenTableColumn column : columnList){
					boolean b = false;
					for (GenTableColumn e : genTable.getColumnList()){
						if (e.getName().equals(column.getName())){
							b = true;
						}
					}
					if (!b){
						genTable.getColumnList().add(column);
					}
				}
				
				// 删除已删除的列
				for (GenTableColumn e : genTable.getColumnList()){
					boolean b = false;
					for (GenTableColumn column : columnList){
						if (column.getName().equals(e.getName())){
							b = true;
						}
					}
					if (!b){
						e.setStatus(GenTableColumn.STATUS_DELETE);
					}
				}
				
				// 获取主键
				genTable.setPkList(genDataDictMapper.findTablePK(genTable));
				
				// 初始化列属性字段
				GenUtils.initColumnField(genTable);
				
			}
		}
		return genTable;
	}
	
	@Transactional(readOnly = false)
	public void saveGenTable(GenTable genTable) {
		super.saveOrUpdate(genTable);
		// 保存列
		for (GenTableColumn column : genTable.getColumnList()){
			column.setGenTable(genTable);
			if (StringUtils.isBlank(column.getId())){
				column.preInsert();
				genTableColumnMapper.insert(column);
			}else{
				column.preUpdate();
				genTableColumnMapper.updateById(column);
			}
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(GenTable genTable) {
		genTableMapper.deleteById(genTable);
		QueryWrapper<GenTableColumn> wrapper = new QueryWrapper<GenTableColumn>();
		wrapper.eq("gen_table_id", genTable.getId());
		genTableColumnMapper.delete(wrapper);
	}


}
