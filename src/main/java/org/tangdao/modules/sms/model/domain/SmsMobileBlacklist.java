package org.tangdao.modules.sms.model.domain;

import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

/**
 * 手机黑名单信息表Entity
 * @author ruyang
 * @version 2019-09-06
 */
@Getter
@Setter
@TableName("sms_mobile_blacklist")
public class SmsMobileBlacklist extends DataEntity<SmsMobileBlacklist> {
	
	private static final long serialVersionUID = 1L;
	
	@TableId
	private String id;
	
	private String mobile;		// 手机号码
	private int    type;		// 类型
	
	public SmsMobileBlacklist() {
		super();
	}

	public SmsMobileBlacklist(String id){
		super(id);
	}
	
}