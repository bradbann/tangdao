package org.tangdao.modules.sms.model.domain;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 通道组内容Entity
 * @author ruyang
 * @version 2019-09-06
 */
@TableName("sms_passage_group_detail")
public class SmsPassageGroupDetail extends DataEntity<SmsPassageGroupDetail> {
	
	private static final long serialVersionUID = 1L;
	
	private String groupId;		// 通道组id
	private String passageId;		// 通道id
	private String provinceCode;		// 通道代码
	private String routeType;		// 路由类型，0默认路由，1验证码路由,2即时通知路由，3批量通知路由，4高风险投诉路由
	private String priority;		// 优先级
	private String cmcp;		// 运营商1-移动 2-联通 3-电信
	
	public SmsPassageGroupDetail() {
		super();
	}

	public SmsPassageGroupDetail(String id){
		super(id);
	}
	
	@NotBlank(message="通道组id不能为空")
	@Length(min=0, max=11, message="通道组id长度不能超过  11 个字符")
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	@NotBlank(message="通道id不能为空")
	@Length(min=0, max=11, message="通道id长度不能超过  11 个字符")
	public String getPassageId() {
		return passageId;
	}

	public void setPassageId(String passageId) {
		this.passageId = passageId;
	}
	
	@Length(min=0, max=11, message="通道代码长度不能超过  11 个字符")
	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	
	@Length(min=0, max=4, message="路由类型，0默认路由，1验证码路由,2即时通知路由，3批量通知路由，4高风险投诉路由长度不能超过  4 个字符")
	public String getRouteType() {
		return routeType;
	}

	public void setRouteType(String routeType) {
		this.routeType = routeType;
	}
	
	@Length(min=0, max=4, message="优先级长度不能超过  4 个字符")
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	@Length(min=0, max=4, message="运营商1-移动 2-联通 3-电信长度不能超过  4 个字符")
	public String getCmcp() {
		return cmcp;
	}

	public void setCmcp(String cmcp) {
		this.cmcp = cmcp;
	}
	
}