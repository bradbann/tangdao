package org.tangdao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sys.entity.Menu;
import org.tangdao.modules.sys.mapper.MenuMapper;
import org.tangdao.modules.sys.service.IMenuService;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author ruyang
 * @since 2019-07-02
 */
@Service
public class MenuServiceImpl extends CrudServiceImpl<MenuMapper, Menu> implements IMenuService {

}
