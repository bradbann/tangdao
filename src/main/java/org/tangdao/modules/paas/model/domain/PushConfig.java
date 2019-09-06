package org.tangdao.modules.paas.model.domain;

import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

/**
 * 推送配置信息表Entity
 * @author ruyang
 * @version 2019-09-06
 */
@Getter
@Setter
@TableName("paas_push_config")
public class PushConfig extends DataEntity<PushConfig> {
	
	private static final long serialVersionUID = 1L;
	
	@TableId
	private String id;
	
	private String userCode;		// 用户编码
	private String url;		// 状态报告地址/上行地址
	private String type;		// 类型 1:短信状态报告,2:短信上行回执报告,3:流量充值报告,4:语音发送报告
	private String retryTimes;		// 重推次数
	
	public PushConfig() {
		super();
	}

	public PushConfig(String id){
		super(id);
	}
	
}