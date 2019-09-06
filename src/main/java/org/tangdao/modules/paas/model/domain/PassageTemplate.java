package org.tangdao.modules.paas.model.domain;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 通道模板Entity
 * @author ruyang
 * @version 2019-09-06
 */
@TableName("paas_passage_template")
public class PassageTemplate extends DataEntity<PassageTemplate> {
	
	private static final long serialVersionUID = 1L;
	
	private String name;		// 模板名称
	private String protocol;		// 协议
	private String passageType;		// 1-短信通道模板 2-流量通道模板 3-语音通道模板
	
	public PassageTemplate() {
		super();
	}

	public PassageTemplate(String id){
		super(id);
	}
	
	@NotBlank(message="模板名称不能为空")
	@Length(min=0, max=100, message="模板名称长度不能超过  100 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@NotBlank(message="协议不能为空")
	@Length(min=0, max=32, message="协议长度不能超过  32 个字符")
	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	
	@NotBlank(message="1-短信通道模板 2-流量通道模板 3-语音通道模板不能为空")
	@Length(min=0, max=2, message="1-短信通道模板 2-流量通道模板 3-语音通道模板长度不能超过  2 个字符")
	public String getPassageType() {
		return passageType;
	}

	public void setPassageType(String passageType) {
		this.passageType = passageType;
	}
	
}