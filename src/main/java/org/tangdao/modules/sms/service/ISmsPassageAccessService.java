package org.tangdao.modules.sms.service;

import java.util.List;
import java.util.Map;

import org.tangdao.common.service.ICrudService;
import org.tangdao.modules.exchanger.config.CommonContext.PassageCallType;
import org.tangdao.modules.sms.model.domain.SmsPassageAccess;

/**
 * 通道资产Service
 * 
 * 可用通道服务（用户ID，最后的通道ID以及运营商标识）
 * @author ruyang
 * @version 2019-09-06
 */
public interface ISmsPassageAccessService extends ICrudService<SmsPassageAccess> {
	/**
	 * 
	 * TODO 查找全部的通道信息
	 * 
	 * @return
	 */
	List<SmsPassageAccess> findPassageAccess();

	/**
	 * 
	   * TODO 根据用户ID获取可用通道集合信息 
	   * 
	   * @param userId
	   * @return
	 */
	Map<String, SmsPassageAccess> getByUserCode(String userCode);
	
	/**
	 * 
	 * TODO 根据条件查询可用通道
	 * 
	 * @param userId
	 *            用户编号
	 * @param routeType
	 *            路由类型
	 * @param cmcp
	 *            运营商
	 * @param provinceCode
	 *            省份代码
	 * @return
	 */
	SmsPassageAccess get(String userCode, int routeType, int cmcp, String areaCode);

	/**
	 * 根据id获取对象信息
	 * 
	 * @param id
	 * @return
	 */
	SmsPassageAccess get(String id);

	/**
	 * 
	 * TODO 保存新的通道信息
	 * 
	 * @param access
	 * @return
	 */
	boolean save(SmsPassageAccess access);

	/**
	 * 
	 * TODO 重新加载数据
	 * 
	 * @return
	 */
	boolean reload();

	/**
	 * 
	 * TODO 根据通道ID更新数据（通道出错）
	 * 
	 * @param passageId
	 * @return
	 */
	boolean updateWhenPassageBroken(String passageId);

	/**
	 * 
	 * TODO 更新用户访问通道
	 * 
	 * @param access
	 * @return
	 */
	boolean update(SmsPassageAccess access);

	/**
	 * 当更新用户信息时，如果通道组发生变化，更新access（DB,REDIS及通道参数信息）
	 * 
	 * @param userId
	 * @return
	 */
	boolean updateByModifyUser(String userCode);

	/**
	 * 当更新通道组时，通道组信息发生变化，更新access
	 * 
	 * @param passageGroupId
	 * @return
	 */
	boolean updateByModifyPassageGroup(String passageGroupId);

	/**
	 * 当更新通道时，通道信息发生变化，更新access
	 * 
	 * Expect: 根据passageId更新Access 思路可改为 1.根据passageId 批量更新 passgaeAccess
	 * 2.根据passageId查询所有passageAccess集合并压存到REDIS
	 * 
	 * Current: 1.根据passageId找到通道组信息 2.根据通道组信息查询用户和通道组对应关系 3.
	 * 
	 * @param passageId
	 * @return
	 */
	boolean updateByModifyPassage(String passageId);

	/**
	 * 
	 * TODO 查询带轮训通道
	 * 
	 * @return
	 */
	List<SmsPassageAccess> findWaitPulling(PassageCallType callType);

	/**
	 * 
	 * TODO 查询通道余额信息
	 * 
	 * @return
	 */
	List<SmsPassageAccess> findPassageBalace();

	/**
	 * 
	 * TODO 根据通道代码获取参数详细信息（主要针对回执报告和上行信息）
	 * 
	 * @param passageCode
	 *            通道代码（当通道调用类型为 状态回执推送 或 上行推送时，passage_url 值为 通道代码[唯一]）
	 * @param callType
	 *            通道调用类型，本例主要用于[状态回执推送,上行推送]
	 * @return
	 */
	SmsPassageAccess getByType(PassageCallType callType, String passageCode);
	
	/**
	 * 
	   * TODO 根据通道ID删除可用通道
	   * 
	   * @param passageId
	   * @return
	 */
	boolean deletePassageAccess(String passageId);
	
	/**
	 * 
	   * TODO 更新可用通道状态
	   * 
	   * @param passageId
	   * @param status
	   * @return
	 */
	boolean updateAccessStatus(String passageId, String status);
	
	/**
	 * 
	   * TODO 获取REDIS通道组合KEY（用于REDIS用户通道组合使用）
	   * 
	   * @param routeType
	   * 	路由类型
	   * @param cmcp
	   * 	运营商
	   * @param areaCode
	   * 	省份代码 
	   * @return
	 */
	String getAssistKey(Integer routeType, Integer cmcp, String areaCode);
}