package org.tangdao.modules.sms.model.domain;

import org.tangdao.common.suports.DataEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsMoMessagePush extends DataEntity<SmsMoMessagePush>{
    
	private static final long serialVersionUID = 2668633789030695868L;

	private String id;

    private String msgId;

    private String mobile;

    private String content;

    private Integer retryTimes;

    private Long responseMilliseconds;

    private String responseContent;

}