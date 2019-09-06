package org.tangdao.modules.sms.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsMoPushService;
import org.tangdao.modules.sms.model.domain.SmsMoMessagePush;
import org.tangdao.modules.sms.mapper.SmsMoMessagePushMapper;

/**
 * 上行消息推送ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsMoMessagePushServiceImpl extends CrudServiceImpl<SmsMoMessagePushMapper, SmsMoMessagePush> implements ISmsMoPushService{
		
}