package org.tangdao.config.redis.serializer;

import java.io.IOException;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.tangdao.common.serializer.SerializationUtils;

public class RedisObjectSerializer implements RedisSerializer<Object> {

	/**
	 * 
	 */
	public RedisObjectSerializer() {
		// TODO Auto-generated constructor stub
		SerializationUtils.init("json", null);
	}

	// 为了方便进行对象与字节数组的转换，所以应该首先准备出两个转换器
	private static final byte[] EMPTY_BYTE_ARRAY = new byte[0]; // 做一个空数组，不是null

	@Override
	public byte[] serialize(Object obj) throws SerializationException {
		if (obj == null) { // 这个时候没有要序列化的对象出现，所以返回的字节数组应该就是一个空数组
			return EMPTY_BYTE_ARRAY;
		}
//		return this.serializingConverter.convert(obj); // 将对象变为字节数组
		try {
			return SerializationUtils.serialize(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new SerializationException(e.getMessage(), e);
		}
	}

	@Override
	public Object deserialize(byte[] data) throws SerializationException {
		if (data == null || data.length == 0) { // 此时没有对象的内容信息
			return null;
		}
		try {
			return SerializationUtils.deserialize(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new SerializationException(e.getMessage(), e);
		}
	}
}
