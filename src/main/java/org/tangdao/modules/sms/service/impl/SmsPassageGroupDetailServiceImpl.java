package org.tangdao.modules.sms.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsPassageGroupDetailService;
import org.tangdao.modules.sms.model.domain.SmsPassageGroupDetail;
import org.tangdao.modules.sms.mapper.SmsPassageGroupDetailMapper;

/**
 * 通道组内容ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsPassageGroupDetailServiceImpl extends CrudServiceImpl<SmsPassageGroupDetailMapper, SmsPassageGroupDetail> implements ISmsPassageGroupDetailService{
		
}