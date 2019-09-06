package org.tangdao.modules.sms.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsMtDeliverLogService;
import org.tangdao.modules.sms.model.domain.SmsMtMessageDeliverLog;
import org.tangdao.modules.sms.mapper.SmsMtMessageDeliverLogMapper;

/**
 * 下行短信回执状态日志ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsMtMessageDeliverLogServiceImpl extends CrudServiceImpl<SmsMtMessageDeliverLogMapper, SmsMtMessageDeliverLog> implements ISmsMtDeliverLogService{
		
}