package org.tangdao.modules.sms.service;

/**
 * 
 * TODO 手机号码拦截防火墙
 * 
 * @author ruyang
 * @version V1.0
 * @date 2016年12月15日 上午9:42:57
 */
public interface ISmsMobileTablesService {

	/**
	 * 
	 * TODO 设置同一个手机号码发送的记录（最后一次发送时间，发送总数量）
	 * 
	 * @param userCode
	 * @param templateId
	 * @param mobile
	 * @param sendCount
	 */
	void setMobileSendRecord(String userCode, Long templateId, String mobile, int sendCount);

	/**
	 * 
	 * TODO 同一个手机号码同一模板下号码是否已超速/是否超限（一天内）
	 * 
	 * @param userCode
	 * @param templateId
	 * @param mobile
	 * @param maxSpeed
	 * @param maxLimit
	 * @return
	 */
	int checkMobileIsBeyondExpected(String userCode, Long templateId, String mobile, int maxSpeed, int maxLimit);

	public static final int NICE_PASSED = 0;
	public static final int MOBILE_BEYOND_SPEED = 1;
	public static final int MOBILE_BEYOND_TIMES = 2;
}
