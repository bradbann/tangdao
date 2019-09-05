package org.tangdao.modules.paas.service;

import java.util.List;

import org.tangdao.modules.exchanger.config.CommonContext.PlatformType;
import org.tangdao.modules.paas.config.PayContext.PaySource;
import org.tangdao.modules.paas.config.PayContext.PayType;
import org.tangdao.modules.paas.model.domain.UserBalance;
import org.tangdao.modules.paas.model.vo.P2pBalanceResponse;

import com.alibaba.fastjson.JSONObject;

public interface IUserBalanceService {

	/**
	 * 
	 * TODO 根据用户ID获取所有业务平台的数据量
	 * 
	 * @param userCode
	 * @return
	 */
	List<UserBalance> findByUserCode(String userCode);

	/**
	 * 
	 * TODO 根据平台类型获取用户相关余额量
	 * 
	 * @param userCode
	 * @param type
	 * @return
	 */
	UserBalance getByUserCode(String userCode, PlatformType type);

	/**
	 * 
	 * TODO 添加余额
	 * 
	 * @param balance
	 * @return
	 */
	boolean saveBalance(UserBalance balance);

	/**
	 * 
	 * TODO 更新余额信息
	 * 
	 * @param userCode
	 *            用户编号
	 * @param balance
	 *            修改余额
	 * @param platformType
	 *            平台类型 短信/流量/语音
	 * @param paySource
	 *            支付途径
	 * @param payType
	 *            支付类型
	 * @param isNotice
	 *            是否需要通知
	 * @param price
	 *            单价
	 * @param totalPrice
	 *            总价
	 * @param remark
	 *            备注信息
	 * @return
	 */
	boolean updateBalance(String userCode, int amount, int platformType, PaySource paySource, PayType payType, Double price,
			Double totalPrice, String remark, boolean isNotice);

	/**
	 * 
	 * TODO 用户扣减余额
	 * 
	 * @param userCode
	 * @param amount
	 * @param platformType
	 * @param remark
	 * @return
	 */
	boolean deductBalance(String userCode, int amount, int platformType, String remark);

	/**
	 * 
	 * TODO 余额转赠
	 * 
	 * @param userCode
	 * @param fromuserCode
	 * @param platformType
	 * @param amount
	 * @return
	 */
	boolean exchange(String userCode, int fromuserCode, int platformType, int amount);

	/**
	 * 
	 * TODO 用户余额是否足够
	 * 
	 * @param userCode
	 * @param type
	 * @param fee
	 *            计费
	 * @return
	 */
	boolean isBalanceEnough(String userCode, PlatformType type, Double fee);

	/**
	 * 根据id获取余额信息
	 * 
	 * @param id
	 * @return
	 */
	UserBalance getById(int id);
	
	/**
	 * 
	   * TODO 修改余额告警信息
	   * 
	   * @param userBalance
	   * @return
	 */
	boolean updateBalanceWarning(UserBalance userBalance);
	
	/**
	 * 
	   * TODO 获取所有有效的用户余额数据
	   * 
	   * @return
	 */
	List<UserBalance> findAvaibleUserBalace();
	
	/**
	 * 
	   * TODO 请在此处添加注释
	   * @param id
	   * @param status
	   * 	状态：0：正常，1：高警中
	   * @return
	 */
	boolean updateStatus(Integer id, Integer status);
	

    /**
     * 
     * TODO 根据用户传递的短信内容计算短信计费数
     * 
     * @param userCode
     *      用户ID
     * @param content
     *      短信内容
     * @return
     */
    int calculateSmsAmount(String userCode, String content);

    /**
     * 
     * TODO 计算用户点对点短信计费条数
     * 
     * @param userCode
     * @param p2pBody
     *            点对点短信报文
     * @return
     */
    P2pBalanceResponse calculateP2pSmsAmount(String userCode, List<JSONObject> p2pBody);
    
    /**
     * 
     * TODO 计算用户模板点对点短信计费条数
     * 
     * @param userCode
     * @param content   
     *              模板内容
     * @param p2pBody
     *            点对点短信报文
     * @return
     */
    P2pBalanceResponse calculateP2ptSmsAmount(String userCode, String content, List<JSONObject> p2pBody);
}
