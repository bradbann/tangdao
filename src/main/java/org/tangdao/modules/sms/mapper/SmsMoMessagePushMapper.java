package org.tangdao.modules.sms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.modules.sms.model.domain.SmsMoMessagePush;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 上行消息推送Mapper接口
 * @author ruyang
 * @version 2019-09-06
 */
@Mapper
public interface SmsMoMessagePushMapper extends BaseMapper<SmsMoMessagePush> {
	
}