package org.tangdao.modules.sms.service;

import java.util.List;

import org.tangdao.common.service.ICrudService;
import org.tangdao.modules.sms.model.domain.SmsPassageGroupDetail;

/**
 * 通道组内容Service
 * @author ruyang
 * @version 2019-09-06
 */
public interface ISmsPassageGroupDetailService extends ICrudService<SmsPassageGroupDetail> {
		
	public List<String> findGroupIdByPassageId(String passageId);
	
	public List<SmsPassageGroupDetail> findPassageByGroupId(String passageGroupId);
}