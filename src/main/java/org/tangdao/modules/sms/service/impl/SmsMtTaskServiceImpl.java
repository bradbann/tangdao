package org.tangdao.modules.sms.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsMtTaskService;
import org.tangdao.modules.sms.model.domain.SmsMtTask;
import org.tangdao.modules.sms.mapper.SmsMtTaskMapper;

/**
 * 下行短信任务ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsMtTaskServiceImpl extends CrudServiceImpl<SmsMtTaskMapper, SmsMtTask> implements ISmsMtTaskService{
		
}