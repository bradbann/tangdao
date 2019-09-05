package org.tangdao.modules.paas.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.tangdao.modules.exchanger.config.CommonContext.PlatformType;
import org.tangdao.modules.paas.config.PayContext.PaySource;
import org.tangdao.modules.paas.config.PayContext.PayType;
import org.tangdao.modules.paas.model.domain.UserBalance;
import org.tangdao.modules.paas.model.vo.P2pBalanceResponse;
import org.tangdao.modules.paas.service.IUserBalanceService;

import com.alibaba.fastjson.JSONObject;

@Service
public class UserBalanceServiceImpl implements IUserBalanceService {

	@Override
	public List<UserBalance> findByUserCode(String userCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserBalance getByUserCode(String userCode, PlatformType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveBalance(UserBalance balance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBalance(String userCode, int amount, int platformType, PaySource paySource, PayType payType,
			Double price, Double totalPrice, String remark, boolean isNotice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deductBalance(String userCode, int amount, int platformType, String remark) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exchange(String userCode, int fromuserCode, int platformType, int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBalanceEnough(String userCode, PlatformType type, Double fee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserBalance getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateBalanceWarning(UserBalance userBalance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserBalance> findAvaibleUserBalace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateStatus(Integer id, Integer status) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int calculateSmsAmount(String userCode, String content) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public P2pBalanceResponse calculateP2pSmsAmount(String userCode, List<JSONObject> p2pBody) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public P2pBalanceResponse calculateP2ptSmsAmount(String userCode, String content, List<JSONObject> p2pBody) {
		// TODO Auto-generated method stub
		return null;
	}

}
