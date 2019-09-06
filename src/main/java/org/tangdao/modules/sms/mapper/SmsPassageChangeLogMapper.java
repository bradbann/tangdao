package org.tangdao.modules.sms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.modules.sms.model.domain.SmsPassageChangeLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 通道变更日志Mapper接口
 * @author ruyang
 * @version 2019-09-06
 */
@Mapper
public interface SmsPassageChangeLogMapper extends BaseMapper<SmsPassageChangeLog> {
	
}