package org.tangdao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sys.entity.Role;
import org.tangdao.modules.sys.mapper.RoleMapper;
import org.tangdao.modules.sys.service.IRoleService;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author ruyang
 * @since 2019-07-02
 */
@Service
public class RoleServiceImpl extends CrudServiceImpl<RoleMapper, Role> implements IRoleService {

}
