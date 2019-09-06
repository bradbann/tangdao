package org.tangdao.modules.sms.service.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.mapper.SmsPassageAccessMapper;
import org.tangdao.modules.sms.model.domain.SmsPassageAccess;
import org.tangdao.modules.sms.service.ISmsPassageAccessService;

/**
 * 通道资产ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsPassageAccessServiceImpl extends CrudServiceImpl<SmsPassageAccessMapper, SmsPassageAccess> implements ISmsPassageAccessService{
	/**
     * 全局可用通道缓存
     */
    public static Map<String, SmsPassageAccess>  GLOBAL_PASSAGE_ACCESS_CONTAINER = new ConcurrentHashMap<>();

    /**
     * 通道代码+通道类型组装的共享本地数据
     */
    private static Map<String, SmsPassageAccess> CODE_TYPE_ACCESS_CONTAINER      = new ConcurrentHashMap<>();

    /**
     * 内存键分隔符
     */
    public static final String                   MAP_KEY_SEPERATOR               = "-";

    /**
     * 日志输入
     */
    private final Logger                         logger                          = LoggerFactory.getLogger(getClass());
}