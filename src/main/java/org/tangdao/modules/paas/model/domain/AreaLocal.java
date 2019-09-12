package org.tangdao.modules.paas.model.domain;

import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

/**
 * 号码归属地Entity
 * @author ruyang
 * @version 2019-09-06
 */
@Getter
@Setter
@TableName("paas_area_local")
public class AreaLocal extends DataEntity<AreaLocal> {
	
	private static final long serialVersionUID = 1L;
	
	@TableId
	private String id;
	
	private String areaCode;		// 归属地代码
	private String numberArea;		// 号段
	private int    cmcp;		// 运营商
	
	public AreaLocal() {
		super();
	}

	public AreaLocal(String id){
		super(id);
	}
	
	public AreaLocal(String areaCode, int cmcp) {
		super();
		this.areaCode = areaCode;
		this.cmcp = cmcp;
	}
}