package org.tangdao.modules.sms.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsPassageChangeLogService;
import org.tangdao.modules.sms.model.domain.SmsPassageChangeLog;
import org.tangdao.modules.sms.mapper.SmsPassageChangeLogMapper;

/**
 * 通道变更日志ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsPassageChangeLogServiceImpl extends CrudServiceImpl<SmsPassageChangeLogMapper, SmsPassageChangeLog> implements ISmsPassageChangeLogService{
		
}