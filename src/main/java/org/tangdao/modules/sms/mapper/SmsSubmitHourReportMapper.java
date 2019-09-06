package org.tangdao.modules.sms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.modules.sms.model.domain.SmsSubmitHourReport;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 提交报告（小时）Mapper接口
 * @author ruyang
 * @version 2019-09-06
 */
@Mapper
public interface SmsSubmitHourReportMapper extends BaseMapper<SmsSubmitHourReport> {
	
}