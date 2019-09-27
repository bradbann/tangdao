package org.tangdao.modules.sys.model.domain;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import org.tangdao.common.suports.TreeEntity;
import org.tangdao.common.suports.TreeName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 行政区划Entity
 * @author ruyang
 * @version 2019-09-27
 */
@TableName("sys_area")
public class Area extends TreeEntity<Area> {
	
	private static final long serialVersionUID = 1L;
	
	@TableId
	private String areaCode;		// 区域编码
	@TreeName
	private String areaName;		// 区域名称
	private String areaType;		// 区域类型
	
	public Area() {
		super();
	}

	public Area(String areaCode){
		super(areaCode);
	}
	
	@Override
	public Area getParent() {
		return parent;
	}

	
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
	@NotBlank(message="区域名称不能为空")
	@Length(min=0, max=100, message="区域名称长度不能超过  100 个字符")
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	@Length(min=0, max=1, message="区域类型长度不能超过  1 个字符")
	public String getAreaType() {
		return areaType;
	}

	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}
	
}