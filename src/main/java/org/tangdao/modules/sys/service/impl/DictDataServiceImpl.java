package org.tangdao.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sys.entity.DictData;
import org.tangdao.modules.sys.mapper.DictDataMapper;
import org.tangdao.modules.sys.service.IDictDataService;

/**
 * <p>
 * 字典数据表 服务实现类
 * </p>
 *
 * @author ruyang
 * @since 2019-07-02
 */
@Service
public class DictDataServiceImpl extends CrudServiceImpl<DictDataMapper, DictData> implements IDictDataService {

}
