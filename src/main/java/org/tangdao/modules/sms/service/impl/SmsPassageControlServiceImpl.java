package org.tangdao.modules.sms.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsPassageControlService;
import org.tangdao.modules.sms.model.domain.SmsPassageControl;
import org.tangdao.modules.sms.mapper.SmsPassageControlMapper;

/**
 * 通道控制ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsPassageControlServiceImpl extends CrudServiceImpl<SmsPassageControlMapper, SmsPassageControl> implements ISmsPassageControlService{
		
}