package org.tangdao.modules.sms.config.redis.serializer;

import org.tangdao.modules.sms.model.domain.SmsMtMessageDeliver;
import org.tangdao.modules.sms.model.domain.SmsMtMessageSubmit;

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

public class MesssageReceiptFilter extends SimplePropertyPreFilter {

	public MesssageReceiptFilter() {
		
		super(SmsMtMessageSubmit.class,"sid", "msgId", "passageId","createTime");
	}


	public MesssageReceiptFilter(SmsMtMessageDeliver deliver) {
		
		super(SmsMtMessageSubmit.class, "sid", "msgId", "passageId","createTime", "pushUrl", "retryTimes");
	}
	
}
