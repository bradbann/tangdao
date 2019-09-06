package org.tangdao.modules.sms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.modules.sms.model.domain.SmsPassageReachrateSettings;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 通道重连配置Mapper接口
 * @author ruyang
 * @version 2019-09-06
 */
@Mapper
public interface SmsPassageReachrateSettingsMapper extends BaseMapper<SmsPassageReachrateSettings> {
	
}