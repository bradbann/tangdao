package org.tangdao.modules.sms.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsPassageProvinceService;
import org.tangdao.modules.sms.model.domain.SmsPassageProvince;
import org.tangdao.modules.sms.mapper.SmsPassageProvinceMapper;

/**
 * 通道支持省份ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsPassageProvinceServiceImpl extends CrudServiceImpl<SmsPassageProvinceMapper, SmsPassageProvince> implements ISmsPassageProvinceService{
		
}