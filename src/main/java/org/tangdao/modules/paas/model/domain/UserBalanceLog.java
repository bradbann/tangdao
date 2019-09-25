package org.tangdao.modules.paas.model.domain;

import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户余额日志Entity
 * @author ruyang
 * @version 2019-09-06
 */
@Getter
@Setter
@TableName("paas_user_balance_log")
public class UserBalanceLog extends DataEntity<UserBalanceLog> {
	
	private static final long serialVersionUID = 1L;
	
	@TableId
	private String id;
	
	private String userCode;		// 用户ID
	private int    platformType;		// 平台类型：1-短信，2-流量，3-语音
	private Double balance;		// 充值额度
	private int    paySource;		// 充值源,1:订单充值，2：账号额度划拨,3:系统续充,4:消费
	private int    payType;		// 支付方式，1：账户转账，2:线下转账，3：支付宝，4：微信支付
	private String orderNo;		// 订单号
	private String fromUserId;		// 划拨人ID
	private Double price;		// 单价
	private Double totalPrice;		// 总价
	
	public UserBalanceLog() {
		super();
	}

	public UserBalanceLog(String id){
		super(id);
	}
	
}