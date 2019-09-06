package org.tangdao.modules.sms.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsPriorityWordsService;
import org.tangdao.modules.sms.model.domain.SmsPriorityWords;
import org.tangdao.modules.sms.mapper.SmsPriorityWordsMapper;

/**
 * 优先级词库配置ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsPriorityWordsServiceImpl extends CrudServiceImpl<SmsPriorityWordsMapper, SmsPriorityWords> implements ISmsPriorityWordsService{
		
}