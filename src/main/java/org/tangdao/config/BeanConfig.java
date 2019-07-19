package org.tangdao.config;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.tangdao.common.utils.SpringUtils;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

@Configuration
@EnableCaching
@EnableRedisHttpSession
@AutoConfigureAfter({ RedisAutoConfiguration.class })
public class BeanConfig {

	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}

	@Bean
	@Lazy(false)
	@ConditionalOnMissingBean
	public SpringUtils springUtils() {
		return new SpringUtils();
	}

	@Primary
	@Bean({ "redisTemplate" })
	public RedisTemplate<String, Serializable> redisTemplate(
			@Qualifier("redisConnectionFactory") RedisConnectionFactory redisConnectionFactory,
			@Qualifier("tangdaoSerializer") RedisSerializer<Object> tangdaoSerializer) {
		RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setDefaultSerializer(tangdaoSerializer);
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		return redisTemplate;
	}

	@Bean("tangdaoSerializer")
	@ConditionalOnMissingBean(name = "tangdaoSerializer")
	public RedisSerializer<Object> tangdaoSerializer() {
		return new RedisSerializer<Object>() {

			// 为了方便进行对象与字节数组的转换，所以应该首先准备出两个转换器
			private Converter<Object, byte[]> serializingConverter = new SerializingConverter();
			private Converter<byte[], Object> deserializingConverter = new DeserializingConverter();

			@Override
			public byte[] serialize(Object obj) throws SerializationException {
				if (obj == null) { // 这个时候没有要序列化的对象出现，所以返回的字节数组应该就是一个空数组
					return new byte[0];
				}
				return this.serializingConverter.convert(obj); // 将对象变为字节数组
			}

			@Override
			public Object deserialize(byte[] data) throws SerializationException {
				if (data == null || data.length == 0) { // 此时没有对象的内容信息
					return null;
				}
				return this.deserializingConverter.convert(data);
			}
		};
	}

	@Bean("tangdaoRedisMessageListenerContainer")
	RedisMessageListenerContainer container(
			@Qualifier("redisConnectionFactory") RedisConnectionFactory redisConnectionFactory) {
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(redisConnectionFactory);
		return container;
	}

}
