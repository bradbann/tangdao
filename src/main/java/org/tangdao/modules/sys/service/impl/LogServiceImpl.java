package org.tangdao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sys.entity.Log;
import org.tangdao.modules.sys.mapper.LogMapper;
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
public class LogServiceImpl extends CrudServiceImpl<LogMapper, Log> implements ILogService {

}
