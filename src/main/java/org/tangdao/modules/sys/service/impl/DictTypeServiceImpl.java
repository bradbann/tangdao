package org.tangdao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sys.mapper.DictTypeMapper;
import org.tangdao.modules.sys.model.domain.DictType;
import org.tangdao.modules.sys.service.IDictTypeService;

/**
 * <p>
 * 字典类型表 服务实现类
 * </p>
 *
 * @author ruyang
 * @since 2019-07-02
 */
@Service
public class DictTypeServiceImpl extends CrudServiceImpl<DictTypeMapper, DictType> implements IDictTypeService {

}
