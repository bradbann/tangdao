package org.tangdao.modules.paas.service;

import org.tangdao.modules.paas.model.domain.UserDeveloper;

public interface IUserDeveloperService {

	public UserDeveloper getByAppkey(String appKey);
}
