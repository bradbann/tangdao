package org.tangdao.modules.paas.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.paas.service.IUserBalanceLogService;
import org.tangdao.modules.paas.model.domain.UserBalanceLog;
import org.tangdao.modules.paas.mapper.UserBalanceLogMapper;

/**
 * 用户余额日志ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class UserBalanceLogServiceImpl extends CrudServiceImpl<UserBalanceLogMapper, UserBalanceLog> implements IUserBalanceLogService{
		
}