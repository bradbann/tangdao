package org.tangdao.modules.gen.mapper;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.modules.gen.model.domain.GenTableColumn;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface GenTableColumnMapper extends BaseMapper<GenTableColumn>{

	public GenTableColumn get(Serializable id);
	
	public List<GenTableColumn> findList(GenTableColumn genTable);
	
	public List<GenTableColumn> findAllList(GenTableColumn genTable);
}
