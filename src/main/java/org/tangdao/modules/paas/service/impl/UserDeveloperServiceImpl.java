package org.tangdao.modules.paas.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.tangdao.modules.paas.model.domain.UserDeveloper;
import org.tangdao.modules.paas.service.IUserDeveloperService;

@Service
public class UserDeveloperServiceImpl implements IUserDeveloperService {

	@Override
	public UserDeveloper getByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDeveloper getByAppkey(String appkey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDeveloper getByAppkey(String appkey, String appSecret) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDeveloper saveWithReturn(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDeveloper> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UserDeveloper developer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reloadToRedis() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStatus(int userId, int status) {
		// TODO Auto-generated method stub
		return false;
	}

}
