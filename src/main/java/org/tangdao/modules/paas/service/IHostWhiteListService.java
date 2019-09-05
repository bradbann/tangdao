package org.tangdao.modules.paas.service;

import org.tangdao.common.service.ICrudService;
import org.tangdao.modules.paas.model.domain.HostWhiteList;

public interface IHostWhiteListService extends ICrudService<HostWhiteList>{

	/**
	 * 
	 * TODO 服务器IP是否允许通过
	 * 
	 * @param userCode
	 * @param ip
	 * @return
	 */
	boolean ipAllowedPass(String userCode, String ip);

	/**
	 * 
	 * TODO 重新载入REDIS
	 * 
	 * @return
	 */
	boolean reloadToRedis();
	
	public int updateByPrimaryKey(HostWhiteList record);
}
