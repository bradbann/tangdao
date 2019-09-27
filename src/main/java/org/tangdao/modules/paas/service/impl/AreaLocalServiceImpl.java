package org.tangdao.modules.paas.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.paas.service.IAreaLocalService;
import org.tangdao.modules.paas.model.domain.AreaLocal;
import org.tangdao.modules.paas.mapper.AreaLocalMapper;

/**
 * 号码归属地ServiceImpl
 * @author ruyang
 * @version 2019-09-27
 */
@Service
public class AreaLocalServiceImpl extends CrudServiceImpl<AreaLocalMapper, AreaLocal> implements IAreaLocalService{
		
}