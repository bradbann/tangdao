package org.tangdao.modules.sms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.modules.sms.model.domain.SmsMtMessageSubmit;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 下行短信提交Mapper接口
 * @author ruyang
 * @version 2019-09-06
 */
@Mapper
public interface SmsMtMessageSubmitMapper extends BaseMapper<SmsMtMessageSubmit> {
	
//	public List<SmsMtMessageSubmit> findList(Map<String, Object> queryParams);
}