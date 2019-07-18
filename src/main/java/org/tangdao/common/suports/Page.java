package org.tangdao.common.suports;

import java.util.List;

import org.tangdao.common.utils.ListUtils;

import com.baomidou.mybatisplus.core.metadata.IPage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Page<T> extends com.baomidou.mybatisplus.extension.plugins.pagination.Page<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Meta meta;

	private List<?> data = ListUtils.newArrayList();

	public Page() {
		if (meta == null) {
			meta = new Meta();
		}
	}

	public Page(IPage<?> dataSet) {
		if (meta == null) {
			meta = new Meta();
		}
		getMeta().setPage(dataSet.getCurrent());
		getMeta().setPages(dataSet.getPages());
		getMeta().setPerpage(dataSet.getSize());
		getMeta().setTotal(dataSet.getTotal());

		this.setData(dataSet.getRecords());
	}
}
