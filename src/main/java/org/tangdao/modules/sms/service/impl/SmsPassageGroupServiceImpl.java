package org.tangdao.modules.sms.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsPassageGroupService;
import org.tangdao.modules.sms.model.domain.SmsPassageGroup;
import org.tangdao.modules.sms.mapper.SmsPassageGroupMapper;

/**
 * 通道组ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsPassageGroupServiceImpl extends CrudServiceImpl<SmsPassageGroupMapper, SmsPassageGroup> implements ISmsPassageGroupService{
		
}