package org.tangdao.common.suports;

import java.util.List;

import org.tangdao.common.utils.ListUtils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class Page {
	private Meta meta;
	private List<?> data = ListUtils.newArrayList();
	
	@JsonIgnore
	private IPage<?> dataSet;
	
	public Page(IPage<?> dataSet, Sort sort) {
		if(meta==null) {
			meta = new Meta();
		}
		getMeta().setPage(dataSet.getCurrent());
		getMeta().setPages(dataSet.getPages());
		getMeta().setPerpage(dataSet.getSize());
		getMeta().setTotal(dataSet.getTotal());
		if(sort!=null) {
			getMeta().setField(sort.getField());
			getMeta().setSort(sort.getSort());
		}
		this.setData(dataSet.getRecords());
	}
}
