package org.tangdao.modules.sms.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sms.service.ISmsSignatureExtnoService;
import org.tangdao.modules.sms.model.domain.SmsSignatureExtno;
import org.tangdao.modules.sms.mapper.SmsSignatureExtnoMapper;

/**
 * 签名扩展ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsSignatureExtnoServiceImpl extends CrudServiceImpl<SmsSignatureExtnoMapper, SmsSignatureExtno> implements ISmsSignatureExtnoService{
		
}