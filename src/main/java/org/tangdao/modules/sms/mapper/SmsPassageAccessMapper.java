package org.tangdao.modules.sms.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.tangdao.modules.sms.model.domain.SmsPassageAccess;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 通道资产Mapper接口
 * @author ruyang
 * @version 2019-09-06
 */
@Mapper
public interface SmsPassageAccessMapper extends BaseMapper<SmsPassageAccess> {
	
	@Delete("delete from sms_passage_access where passage_id = ${passageId}")
	public int deleteByPasageId(String passageId);
	
	@Update("update sms_passage_access set status = #{status} where passage_id = ${passageId}")
	public int updateStatusByPassageId(String status, String passageId);
	
	@Delete("delete from sms_passage_access where user_code = ${userCode}")
	public int deleteByUserCode(String userCode);
}