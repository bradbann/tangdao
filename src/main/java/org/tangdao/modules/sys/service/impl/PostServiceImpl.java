package org.tangdao.modules.sys.service.impl;

import org.tangdao.modules.sys.mapper.PostMapper;
import org.tangdao.modules.sys.model.domain.Post;
import org.tangdao.modules.sys.service.IPostService;
import org.tangdao.common.service.impl.CrudServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工岗位表 服务实现类
 * </p>
 *
 * @author ruyang
 * @since 2019-08-20
 */
@Service
public class PostServiceImpl extends CrudServiceImpl<PostMapper, Post> implements IPostService {

}
