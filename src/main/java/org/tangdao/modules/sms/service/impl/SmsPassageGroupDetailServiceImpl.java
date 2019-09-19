package org.tangdao.modules.sms.service.impl;

import java.util.List;

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

	@Override
	public List<String> findGroupIdByPassageId(String passageId) {
		// TODO Auto-generated method stub
		return this.getBaseMapper().findGroupIdByPassageId(passageId);
	}
	
	public List<SmsPassageGroupDetail> findPassageByGroupId(String passageGroupId){
		return this.getBaseMapper().findPassageByGroupId(passageGroupId);
	}
		
}