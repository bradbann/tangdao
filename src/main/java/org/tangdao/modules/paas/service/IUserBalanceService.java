package org.tangdao.modules.paas.service;

import org.tangdao.modules.exchanger.config.CommonContext.PlatformType;

public interface IUserBalanceService {

	public int calculateSmsAmount(String userCode, String content);
	
	public double isBalanceEnough(String userCode, PlatformType platformType, double totalFee);
}
