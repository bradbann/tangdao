package org.tangdao.modules.developer.request.sms;

import org.tangdao.modules.developer.annotation.ValidateField;
import org.tangdao.modules.developer.request.AuthorizationRequest;

import lombok.Getter;
import lombok.Setter;

/**
 * 
  * 单条/批量短信MODEL
  *
  * @version V1.0.0   
  * @date 2017年3月31日 下午9:39:53
 */
@Getter
@Setter
public class SmsSendRequest extends AuthorizationRequest {

	private static final long serialVersionUID = 2029866580659952586L;

	/**
	 * 手机号码
	 */
	@ValidateField(value = "mobile", required = true)
	private String mobile;

	/**
	 * 短信内容
	 */
	@ValidateField(value = "content", required = true, utf8 = true)
	private String content;

	/**
	 * 扩展码号
	 */
	@ValidateField(value = "extNumber", number = true)
	private String extNumber;

	/**
	 * 用于调用者自定义内容，主要为了实现调用侧的自行业务逻辑标识，如调用方自己的 会员标识，最终我方会原样返回
	 */
	@ValidateField(value = "attach")
	private String attach;

	/**
	 * 回调URL
	 */
	@ValidateField(value = "callback")
	private String callback;

}
