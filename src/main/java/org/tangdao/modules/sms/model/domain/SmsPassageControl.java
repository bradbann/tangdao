package org.tangdao.modules.sms.model.domain;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 通道控制Entity
 * @author ruyang
 * @version 2019-09-06
 */
@TableName("sms_passage_control")
public class SmsPassageControl extends DataEntity<SmsPassageControl> {
	
	private static final long serialVersionUID = 1L;
	
	private String passageId;		// 通道ID
	private String cron;		// 轮训表达式
	private String parameterId;		// 通道参数ID
	
	public SmsPassageControl() {
		super();
	}

	public SmsPassageControl(String id){
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
	
	@Length(min=0, max=64, message="轮训表达式长度不能超过  64 个字符")
	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}
	
	@Length(min=0, max=11, message="通道参数ID长度不能超过  11 个字符")
	public String getParameterId() {
		return parameterId;
	}

	public void setParameterId(String parameterId) {
		this.parameterId = parameterId;
	}
	
}