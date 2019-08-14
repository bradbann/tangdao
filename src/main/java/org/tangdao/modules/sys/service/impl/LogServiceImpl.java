package org.tangdao.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tangdao.modules.sys.mapper.LogMapper;
import org.tangdao.modules.sys.model.domain.Log;
import org.tangdao.modules.sys.service.ILogService;

/**
 * <p>
 * 操作日志表 服务实现类
 * </p>
 *
 * @author ruyang
 * @since 2019-07-02
 */
@Service
public class LogServiceImpl  implements ILogService {

	@Autowired
	private LogMapper logMapper;
	
	/**
	 * 不使用数据库事务，执行插入日志
	 */
	public void insertLog(Log entity) {
		this.logMapper.insert(entity);
	}
}
