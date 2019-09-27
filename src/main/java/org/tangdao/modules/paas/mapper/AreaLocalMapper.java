package org.tangdao.modules.paas.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.modules.paas.model.domain.AreaLocal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 号码归属地Mapper接口
 * @author ruyang
 * @version 2019-09-27
 */
@Mapper
public interface AreaLocalMapper extends BaseMapper<AreaLocal> {
	
}