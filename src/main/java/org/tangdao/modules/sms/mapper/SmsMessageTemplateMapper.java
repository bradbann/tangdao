package org.tangdao.modules.sms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.modules.sms.model.domain.SmsMessageTemplate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 消息模板Mapper接口
 * @author ruyang
 * @version 2019-09-06
 */
@Mapper
public interface SmsMessageTemplateMapper extends BaseMapper<SmsMessageTemplate> {
	
}