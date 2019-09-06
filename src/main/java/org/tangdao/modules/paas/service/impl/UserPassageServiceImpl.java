package org.tangdao.modules.paas.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.paas.service.IUserPassageService;
import org.tangdao.modules.paas.model.domain.UserPassage;
import org.tangdao.modules.paas.mapper.UserPassageMapper;

/**
 * 用户通道配置ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class UserPassageServiceImpl extends CrudServiceImpl<UserPassageMapper, UserPassage> implements IUserPassageService{
		
}