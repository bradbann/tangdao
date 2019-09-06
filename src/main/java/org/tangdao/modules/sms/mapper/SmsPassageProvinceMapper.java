package org.tangdao.modules.sms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.modules.sms.model.domain.SmsPassageProvince;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 通道支持省份Mapper接口
 * @author ruyang
 * @version 2019-09-06
 */
@Mapper
public interface SmsPassageProvinceMapper extends BaseMapper<SmsPassageProvince> {
	
}