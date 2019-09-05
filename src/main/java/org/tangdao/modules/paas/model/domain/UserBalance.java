package org.tangdao.modules.paas.model.domain;

import org.tangdao.common.suports.DataEntity;
import org.tangdao.modules.paas.config.PayContext.PaySource;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("paas_user_balance")
public class UserBalance extends DataEntity<UserBalance> {

	private static final long serialVersionUID = -8492197326319323515L;

	@TableId
	private String id;

	private String userCode;
	
	private String mobile;
	// 虚拟列
	@TableField(exist = false)
	private String name;

	private Integer type;

	private Double balance;
	
	// 告警阀值
	private Integer threshold;

	private Integer payType;

	@TableField(exist = false)
    private Double price;

	@TableField(exist = false)
    private Double totalPrice;
    
	@TableField(exist = false)
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
