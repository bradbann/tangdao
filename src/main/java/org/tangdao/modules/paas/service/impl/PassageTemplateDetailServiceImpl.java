package org.tangdao.modules.paas.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.paas.service.IPassageTemplateDetailService;
import org.tangdao.modules.paas.model.domain.PassageTemplateDetail;
import org.tangdao.modules.paas.mapper.PassageTemplateDetailMapper;

/**
 * 通道模板内容ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class PassageTemplateDetailServiceImpl extends CrudServiceImpl<PassageTemplateDetailMapper, PassageTemplateDetail> implements IPassageTemplateDetailService{
		
}