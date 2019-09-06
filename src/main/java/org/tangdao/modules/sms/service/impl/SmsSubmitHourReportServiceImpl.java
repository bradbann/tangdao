package org.tangdao.modules.sms.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsSubmitHourReportService;
import org.tangdao.modules.sms.model.domain.SmsSubmitHourReport;
import org.tangdao.modules.sms.mapper.SmsSubmitHourReportMapper;

/**
 * 提交报告（小时）ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsSubmitHourReportServiceImpl extends CrudServiceImpl<SmsSubmitHourReportMapper, SmsSubmitHourReport> implements ISmsSubmitHourReportService{
		
}