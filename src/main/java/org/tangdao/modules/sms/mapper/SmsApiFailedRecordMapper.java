package org.tangdao.modules.sms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.modules.sms.model.domain.SmsApiFailedRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 下行失败短信Mapper接口
 * @author ruyang
 * @version 2019-09-06
 */
@Mapper
public interface SmsApiFailedRecordMapper extends BaseMapper<SmsApiFailedRecord> {
	
}