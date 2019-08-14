package org.tangdao.modules.sys.service;

import org.tangdao.modules.sys.model.domain.Log;

/**
 * <p>
 * 操作日志表 服务类
 * </p>
 *
 * @author ruyang
 * @since 2019-07-02
 */
public interface ILogService {

	public void insertLog(Log entity);
}
