package org.tangdao.modules.sms.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsPassageParameterService;
import org.tangdao.modules.sms.model.domain.SmsPassageParameter;
import org.tangdao.modules.sms.mapper.SmsPassageParameterMapper;

/**
 * 通道消息模板参数ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsPassageParameterServiceImpl extends CrudServiceImpl<SmsPassageParameterMapper, SmsPassageParameter> implements ISmsPassageParameterService{
		
}