package org.tangdao.modules.paas.model.domain;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 号码归属地Entity
 * @author ruyang
 * @version 2019-09-06
 */
@TableName("paas_area_local")
public class AreaLocal extends DataEntity<AreaLocal> {
	
	private static final long serialVersionUID = 1L;
	
	private String areaCode;		// 归属地代码
	private String numberArea;		// 号段
	private String cmcp;		// 运营商
	
	public AreaLocal() {
		super();
	}

	public AreaLocal(String id){
		super(id);
	}
	
	@NotBlank(message="归属地代码不能为空")
	@Length(min=0, max=64, message="归属地代码长度不能超过  64 个字符")
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
	@NotBlank(message="号段不能为空")
	@Length(min=0, max=32, message="号段长度不能超过  32 个字符")
	public String getNumberArea() {
		return numberArea;
	}

	public void setNumberArea(String numberArea) {
		this.numberArea = numberArea;
	}
	
	@NotBlank(message="运营商不能为空")
	@Length(min=0, max=4, message="运营商长度不能超过  4 个字符")
	public String getCmcp() {
		return cmcp;
	}

	public void setCmcp(String cmcp) {
		this.cmcp = cmcp;
	}
	
}