package org.tangdao.modules.sms.model.domain;

import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

/**
 * 手机白名单信息表Entity
 * @author ruyang
 * @version 2019-09-06
 */
@Getter
@Setter
@TableName("sms_mobile_whitelist")
public class SmsMobileWhitelist extends DataEntity<SmsMobileWhitelist> {
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private String id;
	
	private String mobile;		// mobile
	private String userCode;		// 用户编码
	
	public SmsMobileWhitelist() {
		super();
	}

	public SmsMobileWhitelist(String id){
		super(id);
	}
	
}