package org.tangdao.modules.exchanger.config;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.tangdao.common.utils.JsonMapper;
import org.tangdao.common.utils.MapUtils;

/**
 * TODO 融合平台接口状态码
 *
 * @version V1.0.0
 * @date 2016年7月24日 下午10:18:47
 */
public class OpenApiCode {

    // 调用平台成功码
    public static final String SUCCESS         = "0";
    // 推送至用户侧成功码
    public static final String DELIVER_SUCCESS = "DELIVRD";

    /**
     * TODO 融合平台公用状态码
     *
     * @version V1.0.0
     * @date 2016年9月21日 上午12:00:33
     */
    public enum CommonApiCode {
        COMMON_SUCCESS("0", "调用成功"), COMMON_REQUEST_EXCEPTION("P0001", "用户请求参数不匹配"),
        COMMON_REQUEST_ENCODING_ERROR("P0002", "参数内容编码不正确"), COMMON_REQUEST_TIMESTAMPS_EXPIRED("P0003", "时间戳已过期"),
        COMMON_REQUEST_IP_INVALID("P0004", "IP未报备"), COMMON_APPKEY_INVALID("P0005", "账户无效"),
        COMMON_APPKEY_NOT_AVAIABLE("P0006", "账户冻结或停用"), COMMON_AUTHENTICATION_FAILED("P0007", "账户鉴权失败"),
        COMMON_BALANCE_EXCEPTION("P0008", "账户计费异常"), COMMON_BALANCE_NOT_ENOUGH("P0009", "账户余额不足"),
        COMMON_BEYOND_MOBILE_THRESHOLD("P0010", "手机号码数量超限（1000个）"), COMMON_SERVER_EXCEPTION("P0100", "未知异常");

        private String code;
        private String message;

        private CommonApiCode(String code, String message) {
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
     * 彩信API回执状态码
     *
     * @version V1.0
     * @date 2019年3月15日 下午11:01:27
     */
    public enum SmsApiCode {

        SMS_P2P_BODY_IS_WRONG("S0010", "点对点短信报文数据不符合"), SMS_P2P_TEMPLATE_BODY_IS_WRONG("S0011", "模板点对点短信报文数据不符合");

        private String code;
        private String message;

        private SmsApiCode(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public String toString() {
            return enumToJsonMessage(code, message);
        }
    }

    /**
     * 彩信API回执信息
     *
     * @version V1.0
     * @date 2019年3月15日 下午10:59:38
     */
    public enum MmsApiCode {
        MMS_MODEL_BODY_RULE_NOT_MATCHED("M0001", "彩信模板信息不匹配"), MMS_MODEL_APPLY_FAILED("M0002", "彩信模板信息报备失败"),
        MMS_MODEL_ID_UNDEFAINED("M0003", "彩信模板ID不可用"), MMS_CUSTOM_BODY_RULE_NOT_MATCHED("M0004", "彩信发送内容格式不匹配"),
        MMS_BEYOND_BODY_SIZE( "M0005", "彩信内容大小超限");

        private String code;
        private String message;

        private MmsApiCode(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public String toString() {
            return enumToJsonMessage(code, message);
        }
    }

    /**
     * TODO 融合平台-流量平台状态码
     *
     * @author ruyang
     * @version V1.0.0
     * @date 2016年9月21日 上午12:01:46
     */
    public enum FluxApiCode {
        FLUX_MOBILE_NOT_AVAIABLE("F0001", "手机号码不合法"), FLUX_FLUX_DATA_PACKAGE_NOT_EXISTS("F0002", "流量包不存在或已失效"),
        FLUX_FLUX_DATA_NOT_SUPPORT_LOCAL("F0003", "流量包不支持该归属地"), FLUX_CUSTOMER_DISCOUNT_INVALID("F0004", "用户折扣无效"),
        FLUX_ORDER_IS_NOT_EXISTS("F0005", "充值记录不存在");

        private String code;
        private String message;

        private FluxApiCode(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public static FluxApiCode parse(String code) {
            if (StringUtils.isEmpty(code)) {
                return null;
            }

            for (FluxApiCode api : FluxApiCode.values()) {
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
     * TODO 融合平台-语音平台状态码
     *
     * @author ruyang
     * @version V1.0.0
     * @date 2016年9月21日 上午12:07:24
     */
    public enum VoiceApiCode {
        VOICE_MOBILE_NOT_AVAIABLE("V0001", "手机号码不合法(为空或者不符合正则)"),
        VOICE_SEND_CODE_ERROR("V0002", "语音验证码无效(为空或者非4-8位数字)"),
        VOICE_SAME_MOBILE_NUM_BEYOND_LIMIT_IN_ONE_DAY("V0003", "同一个手机号码一天内超限"),
        VOICE_SAME_MOBILE_NUM_SEND_BY_HIGN_FREQUENCY("V0004", "同一个手机号码发送频率过快");

        private String code;
        private String message;

        private VoiceApiCode(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public static VoiceApiCode parse(String code) {
            if (StringUtils.isEmpty(code)) {
                return null;
            }

            for (VoiceApiCode api : VoiceApiCode.values()) {
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

    /**
     * TODO 短信推送状态码
     *
     * @author ruyang
     * @version V1.0.0
     * @date 2016年12月25日 下午2:44:28
     */
    public enum SmsPushCode {
        SMS_SAME_MOBILE_NUM_SEND_BY_HIGN_FREQUENCY("BEYOND_SPEED", "同一个手机号码发送频率过快"),
        SMS_SAME_MOBILE_NUM_BEYOND_LIMIT_IN_ONE_DAY("BEYOND_TIMES", "同一个手机号码一天内超限"), SMS_MOBILE_BLACKLIST("BLACK",
                                                                                                          "短信黑名单"),
        SMS_TASK_REJECT("REJECT", "驳回任务"), SMS_PASSAGE_AUTH_NOT_MATCHED("S0013", "通道鉴权失败"),
        SMS_SUBMIT_PASSAGE_FAILED("S0099", "提交通道失败");

        private String code;
        private String message;

        private SmsPushCode(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public static SmsPushCode parse(String code) {
            if (StringUtils.isEmpty(code)) {
                return null;
            }

            for (SmsPushCode api : SmsPushCode.values()) {
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

}