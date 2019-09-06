package org.tangdao.modules.sms.service.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.mapper.SmsMobileBlacklistMapper;
import org.tangdao.modules.sms.model.domain.SmsMobileBlacklist;
import org.tangdao.modules.sms.service.ISmsMobileBlackListService;

/**
 * 手机黑名单信息表ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsMobileBlacklistServiceImpl extends CrudServiceImpl<SmsMobileBlacklistMapper, SmsMobileBlacklist> implements ISmsMobileBlackListService{
	private Logger                              logger                  = LoggerFactory.getLogger(getClass());
	
	/**
     * 全局手机号码（与REDIS 同步采用广播模式）
     */
    public static volatile Map<String, Integer> GLOBAL_MOBILE_BLACKLIST = new ConcurrentHashMap<>();
}