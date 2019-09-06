package org.tangdao.modules.sms.redis.pubsub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.tangdao.modules.sms.model.domain.SmsPassageAccess;
import org.tangdao.modules.sms.redis.constant.SmsRedisConstant;
import org.tangdao.modules.sms.service.impl.SmsPassageAccessServiceImpl;

import com.alibaba.fastjson.JSON;

/**
 * 可用通道广播监听
 * 
 * @author ruyang
 * @version V1.0
 * @date 2018年6月9日 下午3:04:21
 */
public class SmsPassageAccessListener extends MessageListenerAdapter {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            if (message == null) {
                return;
            }

            SmsPassageAccess access = JSON.parseObject(message.toString(), SmsPassageAccess.class);
            if (access == null) {
                return;
            }

            logger.info("订阅可用通道数据[" + message.toString() + "]，将做清除处理");

            // 清空后，采用延期加载方式填充数据，即使用的时候才会去REDIS查询并填充
            SmsPassageAccessServiceImpl.GLOBAL_PASSAGE_ACCESS_CONTAINER.remove(getKey(access));

        } catch (Exception e) {
            logger.warn("可用通道订阅数据失败", e);
        }
    }

    private String getKey(SmsPassageAccess access) {
        return getMainKey(access) + SmsPassageAccessServiceImpl.MAP_KEY_SEPERATOR + getAssistKey(access);
    }

    private String getAssistKey(SmsPassageAccess access) {
        return String.format("%d:%d:%d", access.getRouteType(), access.getCmcp(), access.getProvinceCode());
    }

    /**
     * 获取REDIS主KEY
     *
     * @param access 可用通道数据
     * @return KEY
     */
    private String getMainKey(SmsPassageAccess access) {
        return String.format("%s:%d:%d", SmsRedisConstant.RED_USER_PASSAGE_ACCESS, access.getUserCode(),
                             access.getCallType());
    }
}
