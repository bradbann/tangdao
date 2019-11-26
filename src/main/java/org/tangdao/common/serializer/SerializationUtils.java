/**
 *
 */
package org.tangdao.common.serializer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Properties;

import org.apache.ibatis.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tangdao.common.exception.ServiceException;

/**
 * 对象序列化工具包
 * 
 * @author Ryan Ru(ruyangit@gmail.com)
 */
public class SerializationUtils {

    private final static Logger log = LoggerFactory.getLogger(SerializationUtils.class);
    private static Serializer g_serializer;

    /**
     * 初始化序列化器
     * @param ser  serialization method
     * @param props serializer properties
     */
    public static void init(String ser, Properties props) {
        if (ser == null || "".equals(ser.trim()))
            g_serializer = new JavaSerializer();
        else {
            if ("java".equals(ser)) {
                g_serializer = new JavaSerializer();
            } else if ("fst".equals(ser)) {
                g_serializer = new FSTSerializer();
            } else if ("json".equals(ser)) {
                g_serializer = new FstJSONSerializer(props);
            } else if ("fastjson".equals(ser)) {
                g_serializer = new FastjsonSerializer();
            } else {
                try {
                    g_serializer = (Serializer) Class.forName(ser).newInstance();
                } catch (Exception e) {
                    throw new ServiceException("Cannot initialize Serializer named [" + ser + ']', e);
                }
            }
        }
        log.info("Using Serializer -> [" + g_serializer.name() + ":" + g_serializer.getClass().getName() + ']');
    }

    /**
     * 针对不同类型做单独处理
     * @param obj 待序列化的对象
     * @return 返回序列化后的字节数组
     * @throws IOException io exception
     */
    public static byte[] serialize(Object obj) throws IOException {
        if (obj == null)
            return null;
        return g_serializer.serialize(obj);
    }

    public static byte[] serializeWithoutException(Object obj) {
        try {
            return serialize(obj);
        } catch (IOException e) {
            throw new CacheException(e);
        }
    }

    /**
     * 反序列化
     * @param bytes 待反序列化的字节数组
     * @return 序列化后的对象
     * @throws IOException io exception
     */
    public static Object deserialize(byte[] bytes) throws IOException {
        if (bytes == null || bytes.length == 0)
            return null;
        return g_serializer.deserialize(bytes);
    }
    
    /**
     * 反序列化
     * @param obj 待反序列化的字节数组
     * @return 序列化后的对象
     * @throws IOException io exception
     */
    public static Object deserialize(Object obj) throws IOException {
    	byte[] bytes = null;     
        ByteArrayOutputStream bos = new ByteArrayOutputStream();     
        try {       
            ObjectOutputStream oos = new ObjectOutputStream(bos);        
            oos.writeObject(obj);       
            oos.flush();        
            bytes = bos.toByteArray();     
            oos.close();        
            bos.close();       
        } catch (IOException ex) {       
            ex.printStackTrace();  
        }     
        return deserialize(bytes);   
    }
}