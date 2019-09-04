package org.tangdao.modules.sms.model.domain;

import org.tangdao.common.suports.DataEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsMtMessageDeliver extends DataEntity<SmsMtMessageDeliver> {
    
	private static final long serialVersionUID = -2700315453061170679L;

	private String id;

    private String msgId;

    private String cmcp;

    private String mobile;

    private String statusCode;

    private String deliverTime;

}