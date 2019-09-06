package org.tangdao.modules.sms.model.domain;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 上行消息回复Entity
 * @author ruyang
 * @version 2019-09-06
 */
@TableName("sms_mo_message_receive")
public class SmsMoMessageReceive extends DataEntity<SmsMoMessageReceive> {
	
	private static final long serialVersionUID = 1L;
	
	private String userCode;		// 用户编码
	private String passageId;		// 通道标识
	private String msgId;		// 短信标识
	private String mobile;		// 用户手机号
	private String content;		// 短信内容
	private String destnationNo;		// 服务号长号码
	private String needPush;		// 是否需要推送，0：不需要，1：需要
	private String pushUrl;		// 推送地址
	private String receiveTime;		// 收到信息的时间
	
	public SmsMoMessageReceive() {
		super();
	}

	public SmsMoMessageReceive(String id){
		super(id);
	}
	
	@NotBlank(message="用户编码不能为空")
	@Length(min=0, max=64, message="用户编码长度不能超过  64 个字符")
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	@Length(min=0, max=11, message="通道标识长度不能超过  11 个字符")
	public String getPassageId() {
		return passageId;
	}

	public void setPassageId(String passageId) {
		this.passageId = passageId;
	}
	
	@Length(min=0, max=64, message="短信标识长度不能超过  64 个字符")
	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	@Length(min=0, max=64, message="用户手机号长度不能超过  64 个字符")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@NotBlank(message="短信内容不能为空")
	@Length(min=0, max=1024, message="短信内容长度不能超过  1024 个字符")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=0, max=64, message="服务号长号码长度不能超过  64 个字符")
	public String getDestnationNo() {
		return destnationNo;
	}

	public void setDestnationNo(String destnationNo) {
		this.destnationNo = destnationNo;
	}
	
	@Length(min=0, max=1, message="是否需要推送，0：不需要，1：需要长度不能超过  1 个字符")
	public String getNeedPush() {
		return needPush;
	}

	public void setNeedPush(String needPush) {
		this.needPush = needPush;
	}
	
	@Length(min=0, max=128, message="推送地址长度不能超过  128 个字符")
	public String getPushUrl() {
		return pushUrl;
	}

	public void setPushUrl(String pushUrl) {
		this.pushUrl = pushUrl;
	}
	
	@Length(min=0, max=64, message="收到信息的时间长度不能超过  64 个字符")
	public String getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}
	
}