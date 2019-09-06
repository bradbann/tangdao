package org.tangdao.modules.paas.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.paas.service.IPassageTemplateService;
import org.tangdao.modules.paas.model.domain.PassageTemplate;
import org.tangdao.modules.paas.mapper.PassageTemplateMapper;

/**
 * 通道模板ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class PassageTemplateServiceImpl extends CrudServiceImpl<PassageTemplateMapper, PassageTemplate> implements IPassageTemplateService{
		
}