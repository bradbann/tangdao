package org.tangdao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sys.mapper.ConfigMapper;
import org.tangdao.modules.sys.model.domain.Config;
import org.tangdao.modules.sys.service.IConfigService;

/**
 * <p>
 * 参数配置表 服务实现类
 * </p>
 *
 * @author ruyang
 * @since 2019-07-02
 */
@Service
public class ConfigServiceImpl extends CrudServiceImpl<ConfigMapper, Config> implements IConfigService {

}
