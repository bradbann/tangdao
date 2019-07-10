package org.tangdao.modules.sys.model.dto;

import org.tangdao.common.suports.Pagination;
import org.tangdao.common.suports.Sort;

import lombok.Data;

@Data
public class UserDTO {

	private Pagination pagination;
	
	private Sort sort;
	
}
