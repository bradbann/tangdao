package org.tangdao.modules.paas.model.domain;

import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("paas_user_developer")
public class UserDeveloper extends DataEntity<UserDeveloper>{
	
	private static final long serialVersionUID = 1652989610979690232L;

	@TableId
	private String id;

    private String userCode;

    private String appKey;

    private String appSecret;

    private String salt;

}