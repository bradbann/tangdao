package org.tangdao.modules.sms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.tangdao.modules.sms.model.domain.SmsPassageGroupDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 通道组内容Mapper接口
 * @author ruyang
 * @version 2019-09-06
 */
@Mapper
public interface SmsPassageGroupDetailMapper extends BaseMapper<SmsPassageGroupDetail> {
	
	@Select("select distinct group_id from sms_passage_group_detail where passage_id =#{passageId}")
	public List<String> selectGroupIdByPassageId(String passageId);
}