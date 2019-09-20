package org.tangdao.common.security;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.tangdao.common.utils.JsonMapper;
import org.tangdao.common.utils.MapUtils;
import org.tangdao.modules.exchanger.config.OpenApiCode.CommonApiCode;

public class SecurityContent {

	/**
	 * api认证的token信息
	 */
	public static String RED_SECURITY_TOKEN_LIST = "red_security_token_list";
	
	/**
     * TODO API平台安全状态码
     *
     * @version V1.0.0
     * @date 2016年9月21日 上午12:00:33
     */
    public enum AuthResponseStatus {
    	EC_TOKENATTR_NOTFOND("EC_101004", "用户信息获取失败"), EC_TOKEN_EXPIRATION("EC_101007", "认证信息已经过期");

        private String code;
        private String message;

        private AuthResponseStatus(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public static CommonApiCode parse(String code) {
            if (StringUtils.isEmpty(code)) {
                return null;
            }

            for (CommonApiCode api : CommonApiCode.values()) {
                if (api.getCode().equalsIgnoreCase(code)) {
                    return api;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return enumToJsonMessage(code, message);
        }
    }
    
    /**
     * TODO 枚举信息转JSON格式输出
     *
     * @param code
     * @param message
     * @return
     */
    public static String enumToJsonMessage(String code, String message) {
        Map<String, Object> object = MapUtils.newHashMap();
        object.put("code", code);
        object.put("message", message);
        return JsonMapper.toJson(object);
    }

}
