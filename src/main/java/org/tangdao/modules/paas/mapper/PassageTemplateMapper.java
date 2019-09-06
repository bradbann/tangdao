package org.tangdao.modules.paas.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.modules.paas.model.domain.PassageTemplate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 通道模板Mapper接口
 * @author ruyang
 * @version 2019-09-06
 */
@Mapper
public interface PassageTemplateMapper extends BaseMapper<PassageTemplate> {
	
}