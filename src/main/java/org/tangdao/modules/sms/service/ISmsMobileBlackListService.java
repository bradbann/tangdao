package org.tangdao.modules.sms.service;

import java.util.List;

import org.tangdao.common.service.ICrudService;
import org.tangdao.modules.sms.model.domain.SmsMobileBlacklist;

/**
 * 手机黑名单信息表Service
 * @author ruyang
 * @version 2019-09-06
 */
public interface ISmsMobileBlackListService extends ICrudService<SmsMobileBlacklist> {
		
	/**
	 * 
	 * TODO 手机号码是否为黑名单
	 * 
	 * @param mobile
	 * @return
	 */
	boolean isMobileBelongtoBlacklist(String mobile);

	/**
	 * 
	 * TODO 过滤号码中的所有黑名单手机号码
	 * 
	 * @param mobiles
	 * @param isIgnored
	 *         是否忽略（一般黑名单/回退黑名单）
	 * @return
	 */
	List<String> filterBlacklistMobile(List<String> mobiles, boolean isIgnored);

	/**
	 * 
	   * TODO 加载到REDIS
	   * @return
	 */
	boolean reloadToRedis();
}