package org.tangdao.modules.sms.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsMobileWhiteListService;
import org.tangdao.modules.sms.model.domain.SmsMobileWhitelist;
import org.tangdao.modules.sms.mapper.SmsMobileWhitelistMapper;

/**
 * 手机白名单信息表ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsMobileWhitelistServiceImpl extends CrudServiceImpl<SmsMobileWhitelistMapper, SmsMobileWhitelist> implements ISmsMobileWhiteListService{
		
}