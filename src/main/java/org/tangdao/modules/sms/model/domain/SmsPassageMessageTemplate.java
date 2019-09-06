package org.tangdao.modules.sms.model.domain;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

/**
 * 通道消息模板Entity
 * @author ruyang
 * @version 2019-09-06
 */
@Getter
@Setter
@TableName("sms_passage_message_template")
public class SmsPassageMessageTemplate extends DataEntity<SmsPassageMessageTemplate> {
	
	private static final long serialVersionUID = 1L;
	
	@TableId
	private String id;
	
	private String templateId;		// 通道模板ID（通道方提供）
	private String templateContent;		// 模板内容
	private String regexValue;		// 模板表达式
	private String paramNames;		// 参数名称，多个以,分割(有序)
	private String passageId;		// 通道ID
	
	public SmsPassageMessageTemplate() {
		super();
	}

	public SmsPassageMessageTemplate(String id){
		super(id);
	}
	
	@NotBlank(message="通道模板ID（通道方提供）不能为空")
	@Length(min=0, max=64, message="通道模板ID（通道方提供）长度不能超过  64 个字符")
	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	
	@NotBlank(message="模板内容不能为空")
	@Length(min=0, max=256, message="模板内容长度不能超过  256 个字符")
	public String getTemplateContent() {
		return templateContent;
	}

	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}
	
	@Length(min=0, max=256, message="模板表达式长度不能超过  256 个字符")
	public String getRegexValue() {
		return regexValue;
	}

	public void setRegexValue(String regexValue) {
		this.regexValue = regexValue;
	}
	
	@Length(min=0, max=64, message="参数名称，多个以,分割(有序)长度不能超过  64 个字符")
	public String getParamNames() {
		return paramNames;
	}

	public void setParamNames(String paramNames) {
		this.paramNames = paramNames;
	}
	
	@NotBlank(message="通道ID不能为空")
	@Length(min=0, max=11, message="通道ID长度不能超过  11 个字符")
	public String getPassageId() {
		return passageId;
	}

	public void setPassageId(String passageId) {
		this.passageId = passageId;
	}
	
}