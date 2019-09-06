package org.tangdao.modules.sms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.modules.sms.model.domain.SmsMtProcessFailed;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 下行短信处理失败Mapper接口
 * @author ruyang
 * @version 2019-09-06
 */
@Mapper
public interface SmsMtProcessFailedMapper extends BaseMapper<SmsMtProcessFailed> {
	
}