package org.tangdao.modules.paas.model.domain;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 用户通道配置Entity
 * @author ruyang
 * @version 2019-09-06
 */
@TableName("paas_user_passage")
public class UserPassage extends DataEntity<UserPassage> {
	
	private static final long serialVersionUID = 1L;
	
	private String userCode;		// 用户编码
	private String type;		// 类型 1-短信，2-流量，3-语音
	private String passageGroupId;		// 业务通道组ID，如短信通道组ID，流量通道组ID
	
	public UserPassage() {
		super();
	}

	public UserPassage(String id){
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
	
	@NotBlank(message="类型 1-短信，2-流量，3-语音不能为空")
	@Length(min=0, max=4, message="类型 1-短信，2-流量，3-语音长度不能超过  4 个字符")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@NotBlank(message="业务通道组ID，如短信通道组ID，流量通道组ID不能为空")
	@Length(min=0, max=11, message="业务通道组ID，如短信通道组ID，流量通道组ID长度不能超过  11 个字符")
	public String getPassageGroupId() {
		return passageGroupId;
	}

	public void setPassageGroupId(String passageGroupId) {
		this.passageGroupId = passageGroupId;
	}
	
}