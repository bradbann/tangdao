package org.tangdao.modules.sms.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsDeliverLogService;
import org.tangdao.modules.sms.model.domain.SmsMessageDeliverLog;
import org.tangdao.modules.sms.mapper.SmsMessageDeliverLogMapper;

/**
 * 下行短信回执日志ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsMessageDeliverLogServiceImpl extends CrudServiceImpl<SmsMessageDeliverLogMapper, SmsMessageDeliverLog> implements ISmsDeliverLogService{
		
}