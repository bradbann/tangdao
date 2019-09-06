package org.tangdao.modules.sms.model.domain;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 下行短信创建Entity
 * @author ruyang
 * @version 2019-09-06
 */
@TableName("sms_mt_manual_handling")
public class SmsMtManualHandling extends DataEntity<SmsMtManualHandling> {
	
	private static final long serialVersionUID = 1L;
	
	private Long sid;		// sid
	private String appType;		// 调用类型 1:融合WEB平台,2:开发者平台,3:运营支撑系统
	private String ip;		// 发送IP
	private String userCode;		// 用户编码
	private String mobile;		// 手机号
	private String cmcp;		// 运营商，参见cmcp枚举
	private String templateId;		// 模板编号
	private String content;		// 短信内容
	private String fee;		// 计费条数
	private String extNumber;		// 拓展号码
	private String attach;		// 自定义内容
	private String callback;		// 回调URL（选填）
	private String lastestStatus;		// 初始状态，刚开始与status一致
	
	public SmsMtManualHandling() {
		super();
	}

	public SmsMtManualHandling(String id){
		super(id);
	}
	
	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}
	
	@NotBlank(message="调用类型 1:融合WEB平台,2:开发者平台,3:运营支撑系统不能为空")
	@Length(min=0, max=2, message="调用类型 1:融合WEB平台,2:开发者平台,3:运营支撑系统长度不能超过  2 个字符")
	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}
	
	@Length(min=0, max=32, message="发送IP长度不能超过  32 个字符")
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@NotBlank(message="用户编码不能为空")
	@Length(min=0, max=64, message="用户编码长度不能超过  64 个字符")
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	@NotBlank(message="手机号不能为空")
	@Length(min=0, max=1024, message="手机号长度不能超过  1024 个字符")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@NotBlank(message="运营商，参见cmcp枚举不能为空")
	@Length(min=0, max=4, message="运营商，参见cmcp枚举长度不能超过  4 个字符")
	public String getCmcp() {
		return cmcp;
	}

	public void setCmcp(String cmcp) {
		this.cmcp = cmcp;
	}
	
	@Length(min=0, max=10, message="模板编号长度不能超过  10 个字符")
	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	
	@NotBlank(message="短信内容不能为空")
	@Length(min=0, max=1024, message="短信内容长度不能超过  1024 个字符")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@NotBlank(message="计费条数不能为空")
	@Length(min=0, max=4, message="计费条数长度不能超过  4 个字符")
	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}
	
	@Length(min=0, max=20, message="拓展号码长度不能超过  20 个字符")
	public String getExtNumber() {
		return extNumber;
	}

	public void setExtNumber(String extNumber) {
		this.extNumber = extNumber;
	}
	
	@Length(min=0, max=64, message="自定义内容长度不能超过  64 个字符")
	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}
	
	@Length(min=0, max=256, message="回调URL（选填）长度不能超过  256 个字符")
	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}
	
	@Length(min=0, max=4, message="初始状态，刚开始与status一致长度不能超过  4 个字符")
	public String getLastestStatus() {
		return lastestStatus;
	}

	public void setLastestStatus(String lastestStatus) {
		this.lastestStatus = lastestStatus;
	}
	
}