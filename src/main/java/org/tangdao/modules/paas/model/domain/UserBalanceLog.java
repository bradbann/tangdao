package org.tangdao.modules.paas.model.domain;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 用户余额日志Entity
 * @author ruyang
 * @version 2019-09-06
 */
@TableName("paas_user_balance_log")
public class UserBalanceLog extends DataEntity<UserBalanceLog> {
	
	private static final long serialVersionUID = 1L;
	
	private String userCode;		// 用户ID
	private String platformType;		// 平台类型：1-短信，2-流量，3-语音
	private String balance;		// 充值额度
	private String paySource;		// 充值源,1:订单充值，2：账号额度划拨,3:系统续充,4:消费
	private String payType;		// 支付方式，1：账户转账，2:线下转账，3：支付宝，4：微信支付
	private String orderNo;		// 订单号
	private String fromUserId;		// 划拨人ID
	private String price;		// 单价
	private String totalPrice;		// 总价
	
	public UserBalanceLog() {
		super();
	}

	public UserBalanceLog(String id){
		super(id);
	}
	
	@NotBlank(message="用户ID不能为空")
	@Length(min=0, max=64, message="用户ID长度不能超过  64 个字符")
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	@NotBlank(message="平台类型：1-短信，2-流量，3-语音不能为空")
	@Length(min=0, max=4, message="平台类型：1-短信，2-流量，3-语音长度不能超过  4 个字符")
	public String getPlatformType() {
		return platformType;
	}

	public void setPlatformType(String platformType) {
		this.platformType = platformType;
	}
	
	@NotBlank(message="充值额度不能为空")
	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	@NotBlank(message="充值源,1:订单充值，2：账号额度划拨,3:系统续充,4:消费不能为空")
	@Length(min=0, max=4, message="充值源,1:订单充值，2：账号额度划拨,3:系统续充,4:消费长度不能超过  4 个字符")
	public String getPaySource() {
		return paySource;
	}

	public void setPaySource(String paySource) {
		this.paySource = paySource;
	}
	
	@Length(min=0, max=4, message="支付方式，1：账户转账，2:线下转账，3：支付宝，4：微信支付长度不能超过  4 个字符")
	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}
	
	@Length(min=0, max=32, message="订单号长度不能超过  32 个字符")
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	@Length(min=0, max=11, message="划拨人ID长度不能超过  11 个字符")
	public String getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(String fromUserId) {
		this.fromUserId = fromUserId;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}