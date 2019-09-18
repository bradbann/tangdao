package org.tangdao.modules.paas.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.tangdao.modules.paas.model.domain.UserPassage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 用户通道配置Mapper接口
 * @author ruyang
 * @version 2019-09-06
 */
@Mapper
public interface UserPassageMapper extends BaseMapper<UserPassage> {
	
	public int updateByUserCodeAndType(@Param("passageGroupId") String passageGroupId, @Param("userCode") String userCode, @Param("type") Integer type);
}