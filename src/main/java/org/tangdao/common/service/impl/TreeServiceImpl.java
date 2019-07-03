package org.tangdao.common.service.impl;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.tangdao.common.service.ITreeService;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public class TreeServiceImpl<M extends BaseMapper<T>, T> extends CrudServiceImpl<BaseMapper<T>, T> implements ITreeService<T> {

	protected Log log = LogFactory.getLog(getClass());

	@Override
	public void convertTreeSort(List<T> sourceList, List<T> targetList, String parentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void convertChildList(List<T> sourceList, List<T> targetList, String parentId) {
		// TODO Auto-generated method stub
		
	}

    
}
