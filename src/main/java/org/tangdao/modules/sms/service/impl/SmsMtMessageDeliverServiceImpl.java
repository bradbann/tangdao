package org.tangdao.modules.sms.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsMtDeliverService;
import org.tangdao.modules.sms.model.domain.SmsMtMessageDeliver;
import org.tangdao.modules.sms.mapper.SmsMtMessageDeliverMapper;

/**
 * 下行短信回执状态ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsMtMessageDeliverServiceImpl extends CrudServiceImpl<SmsMtMessageDeliverMapper, SmsMtMessageDeliver> implements ISmsMtDeliverService{
		
}