package org.tangdao.modules.sms.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsMtProcessFailedService;
import org.tangdao.modules.sms.model.domain.SmsMtProcessFailed;
import org.tangdao.modules.sms.mapper.SmsMtProcessFailedMapper;

/**
 * 下行短信处理失败ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsMtProcessFailedServiceImpl extends CrudServiceImpl<SmsMtProcessFailedMapper, SmsMtProcessFailed> implements ISmsMtProcessFailedService{
		
}