package org.tangdao.modules.sms.model.domain;

import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

/**
 * 通道组内容Entity
 * @author ruyang
 * @version 2019-09-06
 */
@Getter
@Setter
@TableName("sms_passage_group_detail")
public class SmsPassageGroupDetail extends DataEntity<SmsPassageGroupDetail> {
	
	private static final long serialVersionUID = 1L;
	
	@TableId
	private String id;
	
	private String groupId;		// 通道组id
	private String passageId;		// 通道id
	private String areaCode;		// 通道代码
	private int    routeType;		// 路由类型，0默认路由，1验证码路由,2即时通知路由，3批量通知路由，4高风险投诉路由
	private String priority;		// 优先级
	private int    cmcp;		// 运营商1-移动 2-联通 3-电信
	
	public SmsPassageGroupDetail() {
		super();
	}

	public SmsPassageGroupDetail(String id){
		super(id);
	}
}