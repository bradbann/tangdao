package org.tangdao.modules.sms.model.domain;

import org.tangdao.common.suports.DataEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsForbiddenWords extends DataEntity<SmsForbiddenWords> {
	
	private static final long serialVersionUID = 8652648544338513081L;

	private String id;

	private String word;

	private String label;
	
	private Integer level;

}
