package org.tangdao.common.config;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.tangdao.common.utils.FileUtils;
import org.tangdao.common.utils.MapUtils;
import org.tangdao.common.utils.ObjectUtils;
import org.tangdao.common.utils.PropertiesUtils;
import org.tangdao.common.utils.ServletUtils;
import org.tangdao.common.utils.StringUtils;

public class Global implements PropertySourceLoader {

	private static Map<String, String> props = MapUtils.newHashMap();
	private static final Global global = new Global();
	private static boolean isLoadPropertySource = false;

	static {
		isLoadPropertySource = false;
	}

	@Override
	public String[] getFileExtensions() {
		return new String[] { "properties", "yml" };
	}

	@Override
	public List<PropertySource<?>> load(String name, Resource resource) throws IOException {
		if (!isLoadPropertySource) {
			isLoadPropertySource = true;
			Properties properties = PropertiesUtils.getInstance().getProperties();
			return Collections.singletonList(new OriginTrackedMapPropertySource("framework", properties));
		}
		return Collections.emptyList();
	}

	/**
	 * 获取当前对象实例
	 */
	public static Global getInstance() {
		return global;
	}

	public static final String YES = "1";
	public static final String NO = "0";
	public static final String SHOW = "1";
	public static final String HIDE = "0";
	public static final String TRUE = "true";
	public static final String FALSE = "false";

	public static final String OP_ADD = "add";
	public static final String OP_EDIT = "edit";
	public static final String OP_AUTH = "auth";

	public static final String USERFILES_BASE_URL = "/userfiles/";

	/**
	 * 获取配置
	 */
	public static String getConfig(String key) {
		String value = props.get(key);
		if (value == null) {
			value = PropertiesUtils.getInstance().getProperty(key);
			props.put(key, value != null ? value : StringUtils.EMPTY);
		}
		return value;
	}

	/**
	 * 获取配置
	 */
	public static String getConfig(String key, String defValue) {
		String value = props.get(key);
		if (value == null) {
			value = PropertiesUtils.getInstance().getProperty(key);
			props.put(key, value != null ? value : defValue);
		}
		return props.get(key);
	}

	public static Boolean getConfigToBoolean(String key, String defValue) {
		return ObjectUtils.toBoolean(getConfig(key, defValue));
	}

	public static Integer getConfigToInteger(String key, String defValue) {
		return ObjectUtils.toInteger(getConfig(key, defValue));
	}

	public static String getUserfilesBaseDir(String path) {
		String baseDir = getConfig("file.baseDir");
		if (StringUtils.isBlank(baseDir)) {
			baseDir = ServletUtils.getRequest().getSession().getServletContext().getRealPath("/");
		}

		if (StringUtils.isBlank(baseDir)) {
			baseDir = System.getProperty("user.dir");
		}

		if (!baseDir.endsWith("/")) {
			baseDir = (new StringBuilder()).insert(0, baseDir).append("/").toString();
		}

		return path != null
				? FileUtils
						.path(new StringBuilder().insert(0, baseDir).append(USERFILES_BASE_URL).append(path).toString())
				: FileUtils.path(baseDir);
	}
}
