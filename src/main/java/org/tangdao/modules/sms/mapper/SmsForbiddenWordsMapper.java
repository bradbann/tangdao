package org.tangdao.modules.sms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.modules.sms.model.domain.SmsForbiddenWords;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 告警敏感词Mapper接口
 * @author ruyang
 * @version 2019-09-06
 */
@Mapper
public interface SmsForbiddenWordsMapper extends BaseMapper<SmsForbiddenWords> {
	
}