package org.tangdao.modules.paas.service;

import java.util.List;

import org.tangdao.common.service.ICrudService;
import org.tangdao.modules.paas.model.domain.UserPassage;

/**
 * 用户通道配置Service
 * @author ruyang
 * @version 2019-09-06
 */
public interface IUserPassageService extends ICrudService<UserPassage> {
	/**
     * TODO 初始添加通道
     * 
     * @param userId
     * @param passageList
     * @return
     */
    boolean initUserPassage(String userCode, List<UserPassage> passageList);

    /**
     * TODO 批量添加通道
     * 
     * @param userId
     * @param userPassage
     * @return
     */
    boolean save(String userCode, UserPassage userPassage);

    /**
     * TODO 保存多个通道信息
     * 
     * @param userId
     * @param userPassages
     * @return
     */
    boolean save(String userCode, List<UserPassage> userPassages);

    /**
     * 根据用户ID获取用户相关业务类型的通道组ID
     * 
     * @param userId
     * @return
     */
    List<UserPassage> findByUserCode(String userCode);

    /**
     * TODO 根据用户ID和平台类型获取通道组信息
     * 
     * @param userId
     * @param type
     * @return
     */
    Integer getByUserCodeAndType(String userCode, int type);

    /**
     * TODO 根据通道组ID获取所有的用户通道信息
     * 
     * @param passageGroupId
     * @return
     */
    List<UserPassage> getPassageGroupListByGroupId(String passageGroupId);

    /**
     * TODO 更新通道组ID
     * 
     * @param userId 用户ID
     * @param type 平台类型
     * @param passageGroupId 通道组ID
     * @return
     */
    boolean update(String userCode, int type, String passageGroupId);

    /**
     * TODO 重载用户关系数据到REDIS
     * 
     * @return
     */
    boolean reloadModelToRedis();
}