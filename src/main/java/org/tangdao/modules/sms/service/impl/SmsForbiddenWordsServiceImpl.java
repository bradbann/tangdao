package org.tangdao.modules.sms.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsForbiddenWordsService;
import org.tangdao.modules.sms.model.domain.SmsForbiddenWords;
import org.tangdao.modules.sms.mapper.SmsForbiddenWordsMapper;

/**
 * 告警敏感词ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsForbiddenWordsServiceImpl extends CrudServiceImpl<SmsForbiddenWordsMapper, SmsForbiddenWords> implements ISmsForbiddenWordsService{
		
}