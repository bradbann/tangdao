package org.tangdao.modules.sms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.modules.sms.model.domain.SmsPassageMessageTemplate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 通道消息模板Mapper接口
 * @author ruyang
 * @version 2019-09-06
 */
@Mapper
public interface SmsPassageMessageTemplateMapper extends BaseMapper<SmsPassageMessageTemplate> {
	
}