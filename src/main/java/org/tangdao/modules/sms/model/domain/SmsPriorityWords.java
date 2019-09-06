package org.tangdao.modules.sms.model.domain;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 优先级词库配置Entity
 * @author ruyang
 * @version 2019-09-06
 */
@TableName("sms_priority_words")
public class SmsPriorityWords extends DataEntity<SmsPriorityWords> {
	
	private static final long serialVersionUID = 1L;
	
	private String userCode;		// 用户编码
	private String content;		// 内容
	private String priority;		// 优先级
	
	public SmsPriorityWords() {
		super();
	}

	public SmsPriorityWords(String id){
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
	
	@NotBlank(message="内容不能为空")
	@Length(min=0, max=64, message="内容长度不能超过  64 个字符")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@NotBlank(message="优先级不能为空")
	@Length(min=0, max=4, message="优先级长度不能超过  4 个字符")
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
}