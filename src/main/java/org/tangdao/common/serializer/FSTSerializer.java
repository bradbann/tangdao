/**
 *
 */
package org.tangdao.common.serializer;

import org.nustaq.serialization.FSTConfiguration;

/**
 * 使用 FST 实现序列化
 * 
 * @author Ryan Ru(ruyangit@gmail.com)
 */
public class FSTSerializer implements Serializer {

	private FSTConfiguration fstConfiguration ;

	public FSTSerializer() {
		fstConfiguration = FSTConfiguration.getDefaultConfiguration();
		fstConfiguration.setClassLoader(Thread.currentThread().getContextClassLoader());
	}

	@Override
	public String name() {
		return "fst";
	}

	@Override
	public byte[] serialize(Object obj) {
		return fstConfiguration.asByteArray(obj);
	}

	@Override
	public Object deserialize(byte[] bytes) {
		return fstConfiguration.asObject(bytes);
	}

}
