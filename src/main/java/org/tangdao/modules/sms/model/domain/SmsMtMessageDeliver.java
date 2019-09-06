package org.tangdao.modules.sms.model.domain;

import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

/**
 * 下行短信回执状态Entity
 * 
 * @author ruyang
 * @version 2019-09-06
 */
@Setter
@Getter
@TableName("sms_mt_message_deliver")
public class SmsMtMessageDeliver extends DataEntity<SmsMtMessageDeliver> {

	private static final long serialVersionUID = 1L;

	@TableId
	private String id;

	private String msgId; // 消息ID
	private int cmcp; // 运营商
	private String mobile; // 用户手机号
	private String statusCode; // 状态码
	private String deliverTime; // 短信提供商回复的时间，可为空

	public SmsMtMessageDeliver() {
		super();
	}

	public SmsMtMessageDeliver(String id) {
		super(id);
	}

}