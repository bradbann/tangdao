package org.tangdao.modules.paas.model.domain;

import org.tangdao.common.suports.DataEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDeveloper extends DataEntity<UserDeveloper>{
	
	private static final long serialVersionUID = 1652989610979690232L;

	private String id;

    private String userCode;

    private String appKey;

    private String appSecret;

    private String salt;

}
