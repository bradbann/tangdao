package org.tangdao.modules.developer.response;

import org.tangdao.modules.exchanger.config.OpenApiCode;

public class CommonResponse {

	private String code = OpenApiCode.SUCCESS; // 状态码
	private String message; // 成功发送的短信计费条数

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
