package org.tangdao.modules.paas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.tangdao.modules.paas.model.domain.UserDeveloper;

@Mapper
public interface UserDeveloperMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UserDeveloper record);

    int insertSelective(UserDeveloper record);

    UserDeveloper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDeveloper record);

    int updateByPrimaryKey(UserDeveloper record);

    /**
     * TODO 根据用户编号获取接口信息（有效状态）
     * 
     * @param UserCode
     * @return
     */
    UserDeveloper selectAvaiableByUserCode(String userCode);
    
    /**
     * TODO 根据用户编号获取接口信息
     * 
     * @param UserCode
     * @return
     */
    UserDeveloper selectByUserCode(String userCode);

    /**
     * TODO 根据接口账号查询开发者信息
     * 
     * @param appkey
     * @return
     */
    UserDeveloper selectByAppkey(@Param("appkey") String appkey);

    /**
     * TODO 根据接口账号查询开发者信息
     * 
     * @param appkey
     * @return
     */
    UserDeveloper selectByAppkeyAndSecret(@Param("appkey") String appkey, @Param("appsecret") String appSecret);

    /**
     * TODO 更新开发者账号状态信息
     * 
     * @param UserCode
     * @param status
     * @return
     */
    int updateDeveloperStatus(@Param("userCode") String userCode, @Param("status") int status);

    /**
     * TODO 查询全部
     * 
     * @return
     */
    List<UserDeveloper> selectAll();

}
