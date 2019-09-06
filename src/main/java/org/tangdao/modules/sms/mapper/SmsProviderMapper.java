package org.tangdao.modules.sms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.modules.sms.model.domain.SmsProvider;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 短信接口提供商Mapper接口
 * @author ruyang
 * @version 2019-09-06
 */
@Mapper
public interface SmsProviderMapper extends BaseMapper<SmsProvider> {
	
}