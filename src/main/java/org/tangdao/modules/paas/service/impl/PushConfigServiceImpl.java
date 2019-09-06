package org.tangdao.modules.paas.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.paas.service.IPushConfigService;
import org.tangdao.modules.paas.model.domain.PushConfig;
import org.tangdao.modules.paas.mapper.PushConfigMapper;

/**
 * 推送配置信息表ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class PushConfigServiceImpl extends CrudServiceImpl<PushConfigMapper, PushConfig> implements IPushConfigService{
		
}