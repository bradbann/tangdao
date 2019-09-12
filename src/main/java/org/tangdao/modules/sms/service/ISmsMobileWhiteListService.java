package org.tangdao.modules.sms.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.tangdao.common.service.ICrudService;
import org.tangdao.modules.sms.model.domain.SmsMobileWhitelist;

/**
 * 手机白名单信息表Service
 * @author ruyang
 * @version 2019-09-06
 */
public interface ISmsMobileWhiteListService extends ICrudService<SmsMobileWhitelist> {
	
	 
	Map<String, Object> batchInsert(SmsMobileWhitelist white);
	/**
	 * 
	 * TODO 查询
	 * 
	 * @param UserCode
	 * @return
	 */
	List<SmsMobileWhitelist> selectByUserCode(String userCode);


	/**
	 * 
	   * TODO 加载到REDIS
	   * @return
	 */
	boolean reloadToRedis();
	
	/**
	 * 
	   * TODO 是否是报备白名单手机号码
	   * @param UserCode
	   * @param mobile
	   * @return
	 */
	boolean isMobileWhitelist(String userCode, String mobile);
	
	/**
	 * 
	   * TODO 根据用户ID获取白名单手机号码集合
	   * 
	   * @param UserCode
	   * @return
	 */
	Set<String> getByUserCode(String userCode);
}