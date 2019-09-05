package org.tangdao.modules.paas.model.domain;

import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("paas_host_whitelist")
public class HostWhiteList extends DataEntity<HostWhiteList> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9097531341163310828L;
	
	@TableId
	private String id;
	private String ip;
	private String userCode;

}
