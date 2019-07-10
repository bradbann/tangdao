package org.tangdao.common.suports;

public class Meta {

	private Long page = 0L;
	
	private Long pages = 0L;
	
	private Long perpage = 10L;
	
	private Long total = 0L;
	
	private String sort;
	
	private String field;

	public Long getPage() {
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getPages() {
		return pages;
	}

	public void setPages(Long pages) {
		this.pages = pages;
	}

	public Long getPerpage() {
		return perpage;
	}

	public void setPerpage(Long perpage) {
		this.perpage = perpage;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
	
}
