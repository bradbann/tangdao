package org.tangdao.modules.paas.service;

import org.tangdao.common.service.ICrudService;
import org.tangdao.modules.paas.model.domain.UserSmsConfig;

/**
 * 用户短信配置Service
 * @author ruyang
 * @version 2019-09-05
 */
public interface IUserSmsConfigService extends ICrudService<UserSmsConfig> {
	
	public UserSmsConfig getByUserCode(String userCode);
		
	/**
	 * 
	   * TODO 根据用户查询单条计费字数
	   * 
	   * @param userCode
	   * @return
	 */
	int getSingleChars(String userCode);

	/**
	 * 
	 * TODO 添加短信设置
	 * 
	 * @param userCode
	 * @param words
	 * @param extNumber
	 * @return
	 */
	boolean save(String userCode, int words, String extNumber);

	/**
	 * 修改
	 * 
	 * @param config
	 * @return
	 */
	boolean update(UserSmsConfig config);

	/**
	 * 
	 * TODO 添加短信设置
	 * 
	 * @param userSmsConfig
	 * @return
	 */
	boolean save(UserSmsConfig userSmsConfig);
	
	/**
	 * 
	   * TODO 重新载入REDIS
	   * @return
	 */
	boolean reloadToRedis();
}