package org.tangdao.modules.sms.model.domain;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 通道变更日志Entity
 * @author ruyang
 * @version 2019-09-06
 */
@TableName("sms_passage_change_log")
public class SmsPassageChangeLog extends DataEntity<SmsPassageChangeLog> {
	
	private static final long serialVersionUID = 1L;
	
	private String passageId;		// 通道ID
	private String oldPassageId;		// 原通道ID
	private String groupId;		// 通道组id
	private String userCode;		// 用户编码
	private String routeType;		// 路由类型
	private String cmcp;		// 运营商
	private String operateMode;		// 操作方式
	private String operateUser;		// 操作人 工号
	
	public SmsPassageChangeLog() {
		super();
	}

	public SmsPassageChangeLog(String id){
		super(id);
	}
	
	@NotBlank(message="通道ID不能为空")
	@Length(min=0, max=11, message="通道ID长度不能超过  11 个字符")
	public String getPassageId() {
		return passageId;
	}

	public void setPassageId(String passageId) {
		this.passageId = passageId;
	}
	
	@NotBlank(message="原通道ID不能为空")
	@Length(min=0, max=11, message="原通道ID长度不能超过  11 个字符")
	public String getOldPassageId() {
		return oldPassageId;
	}

	public void setOldPassageId(String oldPassageId) {
		this.oldPassageId = oldPassageId;
	}
	
	@NotBlank(message="通道组id不能为空")
	@Length(min=0, max=11, message="通道组id长度不能超过  11 个字符")
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	@NotBlank(message="用户编码不能为空")
	@Length(min=0, max=64, message="用户编码长度不能超过  64 个字符")
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	@NotBlank(message="路由类型不能为空")
	@Length(min=0, max=4, message="路由类型长度不能超过  4 个字符")
	public String getRouteType() {
		return routeType;
	}

	public void setRouteType(String routeType) {
		this.routeType = routeType;
	}
	
	@NotBlank(message="运营商不能为空")
	@Length(min=0, max=2, message="运营商长度不能超过  2 个字符")
	public String getCmcp() {
		return cmcp;
	}

	public void setCmcp(String cmcp) {
		this.cmcp = cmcp;
	}
	
	@NotBlank(message="操作方式不能为空")
	@Length(min=0, max=2, message="操作方式长度不能超过  2 个字符")
	public String getOperateMode() {
		return operateMode;
	}

	public void setOperateMode(String operateMode) {
		this.operateMode = operateMode;
	}
	
	@Length(min=0, max=32, message="操作人 工号长度不能超过  32 个字符")
	public String getOperateUser() {
		return operateUser;
	}

	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}
	
}