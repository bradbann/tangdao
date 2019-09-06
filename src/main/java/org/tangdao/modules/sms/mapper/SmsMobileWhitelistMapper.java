package org.tangdao.modules.sms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.modules.sms.model.domain.SmsMobileWhitelist;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 手机白名单信息表Mapper接口
 * @author ruyang
 * @version 2019-09-06
 */
@Mapper
public interface SmsMobileWhitelistMapper extends BaseMapper<SmsMobileWhitelist> {
	
}