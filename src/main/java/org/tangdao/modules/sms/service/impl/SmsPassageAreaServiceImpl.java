package org.tangdao.modules.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsPassageAreaService;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import org.tangdao.modules.sms.model.domain.SmsPassageArea;
import org.tangdao.modules.sms.mapper.SmsPassageAreaMapper;

/**
 * 通道支持省份ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsPassageAreaServiceImpl extends CrudServiceImpl<SmsPassageAreaMapper, SmsPassageArea> implements ISmsPassageAreaService{
		
	public List<SmsPassageArea> selectSmsPassageAreaByPassageId(String passageId){
		return this.select(Wrappers.<SmsPassageArea>lambdaQuery().eq(SmsPassageArea::getPassageId, passageId));
	}
	
	public boolean deleteByPassageId(String passageId) {
		return this.getBaseMapper().deleteByPassageId(passageId)>0;
	}
}