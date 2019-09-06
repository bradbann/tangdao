package org.tangdao.modules.sms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.modules.sms.model.domain.SmsMessageDeliverLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 下行短信回执日志Mapper接口
 * @author ruyang
 * @version 2019-09-06
 */
@Mapper
public interface SmsMessageDeliverLogMapper extends BaseMapper<SmsMessageDeliverLog> {
	
}