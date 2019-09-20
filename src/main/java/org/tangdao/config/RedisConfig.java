package org.tangdao.config;

import java.io.Serializable;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.tangdao.config.redis.constant.SmsRedisConstant;
import org.tangdao.config.redis.pubsub.SmsMessageTemplateListener;
import org.tangdao.config.redis.pubsub.SmsMobileBlacklistListener;
import org.tangdao.config.redis.pubsub.SmsPassageAccessListener;
import org.tangdao.config.redis.serializer.RedisObjectSerializer;


@Configuration
@EnableCaching
//maxInactiveIntervalInSeconds 默认是1800秒过期，这里测试修改为60秒
@EnableRedisHttpSession
public class RedisConfig {
	
	@Primary
	@Bean("redisTemplate")
	public RedisTemplate<String, Serializable> redisTemplate(
			RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setDefaultSerializer(new RedisObjectSerializer());
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		return redisTemplate;
	}
	
	@Primary
	@Bean(name = "stringRedisTemplate")
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory connectionFactory) {
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setDefaultSerializer(new RedisObjectSerializer());
		redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }

	@Bean
	public static ConfigureRedisAction configureRedisAction() {
		return ConfigureRedisAction.NO_OP;
	}
	
	/**
     * 黑名单数据变更广播通知监听配置
     * 
     * @return 消息监听适配器
     */
    @Bean
    MessageListenerAdapter smsMobileBlacklistMessageListener(StringRedisTemplate stringRedisTemplate) {
        return new SmsMobileBlacklistListener(stringRedisTemplate);
    }

    /**
     * 短信模板变更广播通知监听配置
     * 
     * @return 短信模板监听器
     */
    @Bean
    MessageListenerAdapter smsMessageTemplateMessageListener() {
        return new SmsMessageTemplateListener();
    }

    /**
     * 可用通道变更广播通知监听配置
     * 
     * @return 可用通道监听器
     */
    @Bean
    MessageListenerAdapter smsPassageAccessMessageListener() {
        return new SmsPassageAccessListener();
    }

    @Bean
    RedisMessageListenerContainer redisContainer(StringRedisTemplate stringRedisTemplate,
    			RedisConnectionFactory connectionFactory) {
        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(smsMobileBlacklistMessageListener(stringRedisTemplate), mobileBlacklistTopic());
        container.addMessageListener(smsMessageTemplateMessageListener(), messageTemplateTopic());
        container.addMessageListener(smsPassageAccessMessageListener(), passageAccessTopic());
        return container;
    }

    @Bean
    Topic mobileBlacklistTopic() {
        return new PatternTopic(SmsRedisConstant.BROADCAST_MOBILE_BLACKLIST_TOPIC);
    }

    @Bean
    Topic messageTemplateTopic() {
        return new PatternTopic(SmsRedisConstant.BROADCAST_MESSAGE_TEMPLATE_TOPIC);
    }

    @Bean
    Topic passageAccessTopic() {
        return new PatternTopic(SmsRedisConstant.BROADCAST_PASSAGE_ACCESS_TOPIC);
    }
    
}
