package org.tangdao.modules.sms.service;

import java.util.List;

import org.tangdao.common.service.ICrudService;
import org.tangdao.modules.sms.model.domain.SmsPassageArea;

/**
 * 通道支持省份Service
 * @author ruyang
 * @version 2019-09-06
 */
public interface ISmsPassageAreaService extends ICrudService<SmsPassageArea> {
		
	public List<SmsPassageArea> selectSmsPassageAreaByPassageId(String passageId);
	
	public boolean deleteByPassageId(String passageId);
}