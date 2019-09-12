package org.tangdao.modules.sms.service.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.mapper.SmsMessageTemplateMapper;
import org.tangdao.modules.sms.model.domain.SmsMessageTemplate;
import org.tangdao.modules.sms.service.ISmsTemplateService;

/**
 * 消息模板ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsMessageTemplateServiceImpl extends CrudServiceImpl<SmsMessageTemplateMapper, SmsMessageTemplate> implements ISmsTemplateService{
	
	private final Logger                                       logger                  = LoggerFactory.getLogger(getClass());

    /**
     * 全局短信模板（与REDIS 同步采用广播模式）
     */
    public static volatile Map<String, List<SmsMessageTemplate>> GLOBAL_MESSAGE_TEMPLATE = new ConcurrentHashMap<>();

    /**
     * 超级模板正则表达式（一般指无限制）
     */
    private static final String                                SUPER_TEMPLATE_REGEX    = "^[\\s\\S]*$";
}