package org.tangdao.common.suports;

import lombok.Data;

@Data
public class Meta {

	private Long page = 0L;

	private Long pages = 0L;

	private Long perpage = 10L;

	private Long total = 0L;

	private String field;

	private String sort;
}
