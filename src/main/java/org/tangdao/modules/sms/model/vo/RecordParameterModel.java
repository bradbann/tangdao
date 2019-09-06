package org.tangdao.modules.sms.model.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class RecordParameterModel implements Serializable {

	private static final long serialVersionUID = -6313094398425420761L;
	private String userCode;
	private String phoneNumber;
	private String startDate;
	private String endDate;
	private String currentPage;
	
	private Long startDateLong;
	private Long endDateLong;
	
	private int startPage;
	private int pageRecord;
}