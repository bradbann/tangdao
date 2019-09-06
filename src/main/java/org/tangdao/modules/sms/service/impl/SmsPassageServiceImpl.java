package org.tangdao.modules.sms.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsPassageService;
import org.tangdao.modules.sms.model.domain.SmsPassage;
import org.tangdao.modules.sms.mapper.SmsPassageMapper;

/**
 * 通道管理ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsPassageServiceImpl extends CrudServiceImpl<SmsPassageMapper, SmsPassage> implements ISmsPassageService{
		
}