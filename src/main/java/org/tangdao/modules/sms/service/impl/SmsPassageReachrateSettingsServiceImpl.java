package org.tangdao.modules.sms.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsPassageReachrateSettingsService;
import org.tangdao.modules.sms.model.domain.SmsPassageReachrateSettings;
import org.tangdao.modules.sms.mapper.SmsPassageReachrateSettingsMapper;

/**
 * 通道重连配置ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsPassageReachrateSettingsServiceImpl extends CrudServiceImpl<SmsPassageReachrateSettingsMapper, SmsPassageReachrateSettings> implements ISmsPassageReachrateSettingsService{
		
}