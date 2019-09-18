package org.tangdao.modules.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsPassageParameterService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import org.tangdao.modules.sms.model.domain.SmsPassageParameter;
import org.tangdao.modules.exchanger.config.CommonContext.PassageCallType;
import org.tangdao.modules.sms.mapper.SmsPassageParameterMapper;

/**
 * 通道消息模板参数ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsPassageParameterServiceImpl extends CrudServiceImpl<SmsPassageParameterMapper, SmsPassageParameter> implements ISmsPassageParameterService{

	@Override
	public List<SmsPassageParameter> findByPassageId(String passageId) {
		// TODO Auto-generated method stub
		return this.select(Wrappers.<SmsPassageParameter>lambdaQuery().eq(SmsPassageParameter::getPassageId, passageId));
	}

	@Override
	public SmsPassageParameter getByType(PassageCallType callType, String passageCode) {
		// TODO Auto-generated method stub
		return this.getOne(Wrappers.<SmsPassageParameter>lambdaQuery().eq(SmsPassageParameter::getUrl, passageCode).eq(SmsPassageParameter::getCallType, callType.getCode()));
	}

	@Override
	public boolean deleteByPassageId(String passageId) {
		// TODO Auto-generated method stub
		return this.delete(Wrappers.<SmsPassageParameter>lambdaQuery().eq(SmsPassageParameter::getPassageId, passageId));
	}
	
	public SmsPassageParameter selectSendProtocol(String passageId) {
		QueryWrapper<SmsPassageParameter> queryWrapper = new QueryWrapper<SmsPassageParameter>();
		queryWrapper.eq("passage_id", passageId);
		queryWrapper.eq("call_type", 1);
		queryWrapper.orderByDesc("id").last(" limit 1");
		return this.getOne(queryWrapper);
	}
		
}