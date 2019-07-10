package org.tangdao.common.suports;

public class Pagination{
	
	private Long page;
	
	private Long pages;
	
	private Long perpage;
	
	private Long total;

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
}
