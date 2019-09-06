package org.tangdao.modules.sms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.modules.sms.model.domain.SmsPriorityWords;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 优先级词库配置Mapper接口
 * @author ruyang
 * @version 2019-09-06
 */
@Mapper
public interface SmsPriorityWordsMapper extends BaseMapper<SmsPriorityWords> {
	
}