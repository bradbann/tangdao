package org.tangdao.modules.sms.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsDeliverService;
import org.tangdao.modules.sms.model.domain.SmsMessageDeliver;
import org.tangdao.modules.sms.mapper.SmsMessageDeliverMapper;

/**
 * 回执推送信息ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsMessageDeliverServiceImpl extends CrudServiceImpl<SmsMessageDeliverMapper, SmsMessageDeliver> implements ISmsDeliverService{
		
}