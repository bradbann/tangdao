package org.tangdao.modules.sms.model.domain;

import java.util.Date;
import java.util.List;

import org.tangdao.common.suports.DataEntity;
import org.tangdao.common.utils.StringUtils;
import org.tangdao.modules.sms.config.TaskContext.PacketsActionActor;
import org.tangdao.modules.sms.config.TaskContext.PacketsActionPosition;
import org.tangdao.modules.sms.config.TaskContext.TaskSubmitType;

import com.alibaba.fastjson.JSONObject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsMtTask extends DataEntity<SmsMtTask> {

	private static final long serialVersionUID = -3844143801379748603L;

	private String id;

	private String userCode;

	private Long sid;

	private String appType;

	private String mobile;

	private String content;

	private String extNumber;

	private String attach;

	private String callback;

	private Integer fee;

	private Integer totalFee;

	private String submitUrl;

	private String ip;

	private Integer processStatus;

	private Integer approveStatus;

	private String errorMobiles;

	private String repeatMobiles;

	private String finalContent;

	private Date processTime;

	private Long messageTemplateId;

	private String forceActions;

	// 黑名单手机号码（暂存）
	private String blackMobiles;
	
	// 敏感词
	private String forbiddenWords;

	// 提交类型：Enum@TaskSubmitType
	private String submitType = TaskSubmitType.BATCH_MESSAGE.getCode();

	// 返还条数
	private Integer returnFee;

	// 用户原提交手机号码，未进行黑名单等处理的号码
	private String originMobile;
	
	private Long createUnixtime;

	// 点对点短信用户原内容
	private String p2pBody;
	// 点对点短信分析后报文内容
	private List<JSONObject> p2pBodies;
	
	// 敏感词标签
	private List<SmsForbiddenWords> forbiddenWordLabels;
	
	private List<SmsMtTaskPackets> packets;

	// 汇总错误信息
	private transient StringBuilder errorMessageReport = new StringBuilder();
	
	// 允许操作的强制动作，如敏感词报备，模板报备，切换通道
	private transient StringBuilder forceActionsReport = new StringBuilder("000");

	public char[] getActions() {
		if (StringUtils.isNotBlank(forceActions)) {
			return forceActions.toCharArray();
		}
		return null;
	}

	/**
	 * 
	 * TODO 是否模板存在问题
	 * 
	 * @return
	 */
	public boolean isTemplateError() {
		char[] actions = getActions();
		if (actions != null && actions.length > 2) {
			return actions[PacketsActionPosition.SMS_TEMPLATE_MISSED.getPosition()] == PacketsActionActor.BROKEN
					.getActor();
		}
		return false;
	}

	/**
	 * 
	 * TODO 是否包含敏感词
	 * 
	 * @return
	 */
	public boolean isWordError() {
		char[] actions = getActions();
		if (actions != null && actions.length > 2) {
			return actions[PacketsActionPosition.FOBIDDEN_WORDS.getPosition()] == PacketsActionActor.BROKEN.getActor();
		}
		return false;
	}
	
	public String[] getMobiles() {
		if (StringUtils.isNotBlank(mobile)) {
			return mobile.split(",");
		}
		return null;
	}

	public String getFirstMobile() {
		String[] mobiles = getMobiles();
		if (mobiles != null && mobiles.length > 0) {
			return mobiles[0];
		}
		return mobile;
	}

	public String[] getShowErrorMobiles() {
		if (StringUtils.isNotBlank(errorMobiles)) {
			return errorMobiles.split(",");
		}
		return null;
	}

	public String getShowErrorFirstMobile() {
		String[] mobiles = getShowErrorMobiles();
		if (mobiles != null && mobiles.length > 0) {
			return mobiles[0];
		}
		return mobile;
	}

	public String[] getShowRepeatMobiles() {
		if (StringUtils.isNotBlank(repeatMobiles)) {
			return repeatMobiles.split(",");
		}
		return null;
	}

	public String getShowRepeatFirstMobiles() {
		String[] mobiles = getShowRepeatMobiles();
		if (mobiles != null && mobiles.length > 0) {
			return mobiles[0];
		}
		return mobile;
	}
}
