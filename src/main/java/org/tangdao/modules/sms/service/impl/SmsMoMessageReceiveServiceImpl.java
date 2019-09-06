package org.tangdao.modules.sms.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsMoReceiveService;
import org.tangdao.modules.sms.model.domain.SmsMoMessageReceive;
import org.tangdao.modules.sms.mapper.SmsMoMessageReceiveMapper;

/**
 * 上行消息回复ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsMoMessageReceiveServiceImpl extends CrudServiceImpl<SmsMoMessageReceiveMapper, SmsMoMessageReceive> implements ISmsMoReceiveService{
		
}