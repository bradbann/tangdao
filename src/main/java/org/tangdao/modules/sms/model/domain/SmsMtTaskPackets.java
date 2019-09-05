package org.tangdao.modules.sms.model.domain;

import org.tangdao.common.suports.DataEntity;
import org.tangdao.common.utils.StringUtils;
import org.tangdao.modules.sms.config.TaskContext.PacketsActionActor;
import org.tangdao.modules.sms.config.TaskContext.PacketsActionPosition;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsMtTaskPackets extends DataEntity<SmsMtTaskPackets> {

	private static final long serialVersionUID = 8642988970825916882L;

	private String id;

	private String sid;

	private String mobile;

	private Integer cmcp;

	private Integer provinceCode;

	// 省份名称
	private String provinceName;

	private String content;

	private Integer mobileSize;

	private Long messageTemplateId;

	private Integer passageId;

	private Integer finalPassageId;

	private String passageProtocol;

	private String passageUrl;

	private String passageParameter;

	private String resultFormat;

	private String successCode;

	private String position;

	private Integer priority;

	private String forceActions;

	private Integer retryTimes;

	private String passageName;

	private String userCode;
	
	private String callback;
	// 用户自定义内容
	private String attach;
	
	// 用户传入的扩展号码
	private String extNumber;
	// add by 20170621 短信模板扩展号码
	private String templateExtNumber;
	
	private int fee = 1;
	// 单条计费（主要针对点对点和模板点对点）
	private int singleFee =1;

	// 通道代码
	private String passageCode;
	// 通道流速
	private Integer passageSpeed;
	// 通道签名模式
	private Integer passageSignMode;

	public char[] getActions() {
		if (StringUtils.isNotBlank(forceActions)) {
			return forceActions.toCharArray();
		}
		return null;
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
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

	/**
	 * 
	 * TODO 是否无可用通道
	 * 
	 * @return
	 */
	public boolean isPassageError() {
		char[] actions = getActions();
		if (actions != null && actions.length > 2) {
			return actions[PacketsActionPosition.PASSAGE_NOT_AVAIABLE.getPosition()] == PacketsActionActor.BROKEN
					.getActor();
		}
		return false;
	}

}
