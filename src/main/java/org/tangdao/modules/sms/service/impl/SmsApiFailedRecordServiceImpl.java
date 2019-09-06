package org.tangdao.modules.sms.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsApiFailedRecordService;
import org.tangdao.modules.sms.model.domain.SmsApiFailedRecord;
import org.tangdao.modules.sms.mapper.SmsApiFailedRecordMapper;

/**
 * 下行失败短信ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsApiFailedRecordServiceImpl extends CrudServiceImpl<SmsApiFailedRecordMapper, SmsApiFailedRecord> implements ISmsApiFailedRecordService{
		
}