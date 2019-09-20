package org.tangdao.config.redis.pubsub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.tangdao.modules.sms.model.domain.SmsMessageTemplate;
import org.tangdao.modules.sms.service.impl.SmsMessageTemplateServiceImpl;

import com.alibaba.fastjson.JSON;

/**
 * 短信模板广播监听
 * 
 * @author ruyang
 * @version V1.0
 * @date 2017年9月3日 上午12:14:52
 */
public class SmsMessageTemplateListener extends MessageListenerAdapter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            if (message == null) {
                return;
            }

            SmsMessageTemplate template = JSON.parseObject(message.toString(), SmsMessageTemplate.class);
            if (template == null) {
                return;
            }

            logger.info("订阅短信模板数据[" + message.toString() + "]，将做清除处理");

            // 清空后，采用延期加载方式填充数据，即使用的时候才会去REDIS查询并填充
            SmsMessageTemplateServiceImpl.GLOBAL_MESSAGE_TEMPLATE.remove(template.getUserCode());

        } catch (Exception e) {
            logger.warn("短信模板订阅删除数据失败", e);
        }
    }
}
