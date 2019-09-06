package org.tangdao.modules.sms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.modules.sms.model.domain.SmsMessageDeliver;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 回执推送信息Mapper接口
 * @author ruyang
 * @version 2019-09-06
 */
@Mapper
public interface SmsMessageDeliverMapper extends BaseMapper<SmsMessageDeliver> {
	
}