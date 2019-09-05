package org.tangdao.modules.paas.model.domain;

import org.tangdao.common.suports.DataEntity;
import org.tangdao.modules.paas.config.PayContext.PaySource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBalance extends DataEntity<UserBalance> {

	private static final long serialVersionUID = -8492197326319323515L;

	private String id;

	private String userCode;
	
	private String mobile;
	// 虚拟列
	private String name;

	private Integer type;

	private Double balance;
	
	// 告警阀值
	private Integer threshold;

	private Integer payType;

    private Double price;

    private Double totalPrice;
    
    private PaySource paySource;

	public UserBalance() {
	}

	public UserBalance(String userCode, Integer type, Double balance) {
		this.userCode = userCode;
		this.type = type;
		this.balance = balance;
	}

	public UserBalance(String userCode, Integer type, Integer payType, Double balance) {
		this.userCode = userCode;
		this.type = type;
		this.payType = payType;
		this.balance = balance;
	}

}
