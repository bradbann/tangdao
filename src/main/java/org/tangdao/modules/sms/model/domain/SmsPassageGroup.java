package org.tangdao.modules.sms.model.domain;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 通道组Entity
 * @author ruyang
 * @version 2019-09-06
 */
@TableName("sms_passage_group")
public class SmsPassageGroup extends DataEntity<SmsPassageGroup> {
	
	private static final long serialVersionUID = 1L;
	
	private String passageGroupName;		// 通道组名称
	
	public SmsPassageGroup() {
		super();
	}

	public SmsPassageGroup(String id){
		super(id);
	}
	
	@NotBlank(message="通道组名称不能为空")
	@Length(min=0, max=32, message="通道组名称长度不能超过  32 个字符")
	public String getPassageGroupName() {
		return passageGroupName;
	}

	public void setPassageGroupName(String passageGroupName) {
		this.passageGroupName = passageGroupName;
	}
	
}