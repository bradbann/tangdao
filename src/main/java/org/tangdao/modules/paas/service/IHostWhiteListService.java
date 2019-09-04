package org.tangdao.modules.paas.service;

public interface IHostWhiteListService {

	public boolean ipAllowedPass(String userCode, String ip);
}
