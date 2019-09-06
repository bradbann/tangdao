package org.tangdao.modules.sms.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsPassageMessageTemplateService;
import org.tangdao.modules.sms.model.domain.SmsPassageMessageTemplate;
import org.tangdao.modules.sms.mapper.SmsPassageMessageTemplateMapper;

/**
 * 通道消息模板ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsPassageMessageTemplateServiceImpl extends CrudServiceImpl<SmsPassageMessageTemplateMapper, SmsPassageMessageTemplate> implements ISmsPassageMessageTemplateService{
		
}