package org.tangdao.modules.paas.service;

import org.tangdao.common.service.ICrudService;
import org.tangdao.modules.paas.model.domain.UserDeveloper;

/**
 * 
 * TODO 开发者服务
 * 
 */

public interface IUserDeveloperService extends ICrudService<UserDeveloper>{

	/**
	 * 
	 * TODO 根据用户ID获取有效的用户接口信息（状态为启用）
	 * 
	 * @param userId
	 * @return
	 */
	UserDeveloper getByUserCode(String userCode);

	/**
	 * 
	 * TODO 根据接口账号获取接口账号
	 * 
	 * @param appkey
	 * @return
	 */
	UserDeveloper getByAppkey(String appkey);

	/**
	 * 
	 * TODO 根据接口账号和接口密码查询开发者信息
	 * 
	 * @param appkey
	 * @param appSecret
	 * @return
	 */
	UserDeveloper getByAppkey(String appkey, String appSecret);
	
	/**
	 * 
	   * TODO 保存开发者信息
	   * 
	   * @param userCode
	   * @return
	 */
	UserDeveloper saveWithReturn(String userCode);
	
	/**
	 * 
	 * TODO 重载用户关系数据到REDIS
	 * 
	 * @return
	 */
	boolean reloadToRedis();
	
}
