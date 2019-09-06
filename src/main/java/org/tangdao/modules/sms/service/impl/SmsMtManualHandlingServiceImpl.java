package org.tangdao.modules.sms.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsMtManualHandlingService;
import org.tangdao.modules.sms.model.domain.SmsMtManualHandling;
import org.tangdao.modules.sms.mapper.SmsMtManualHandlingMapper;

/**
 * 下行短信创建ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsMtManualHandlingServiceImpl extends CrudServiceImpl<SmsMtManualHandlingMapper, SmsMtManualHandling> implements ISmsMtManualHandlingService{
		
}