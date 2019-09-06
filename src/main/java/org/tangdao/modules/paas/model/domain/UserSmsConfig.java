package org.tangdao.modules.paas.model.domain;

import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户短信配置Entity
 * @author ruyang
 * @version 2019-09-05
 */
@Getter
@Setter
@TableName("paas_user_sms_config")
public class UserSmsConfig extends DataEntity<UserSmsConfig> {
	
	private static final long serialVersionUID = 1L;
	
	@TableId
	private String id;
	
	private String userCode;		// 用户ID
	private Integer smsWords;		// 每条计费字数
	private String smsReturnRule;		// 短信返还规则，0:不返还，1：失败自动返还，2：超时未回执返还；
	private Long smsTimeout;		// 短信超时时间（毫秒）
	private Boolean messagePass;		// 短信内容免审核，1：需要审核，0：不需要
	private String needTemplate;		// 是否需要报备模板，1：需要，0：不需要
	private String autoTemplate;		// 自动提取短信模板,0-不提取，1-提取
	private Integer signatureSource;		// 签名途径，0：自维护，1：系统强制
	private String signatureContent;		// 签名内容
	private String extNumber;		// 扩展号码
	private Integer submitInterval;		// 短信提交时间间隔（同一号码）
	private Integer limitTimes;		// 短信每天提交次数上限（同一号码）
	private String userDeveloperId;		// user_developer_id
	
	public UserSmsConfig() {
		super();
	}

	public UserSmsConfig(String id){
		super(id);
	}
	
	
	
}