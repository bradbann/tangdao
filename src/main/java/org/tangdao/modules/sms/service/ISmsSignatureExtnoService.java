package org.tangdao.modules.sms.service;

import org.tangdao.common.service.ICrudService;
import org.tangdao.modules.sms.model.domain.SmsSignatureExtno;

/**
 * 签名扩展Service
 * @author ruyang
 * @version 2019-09-06
 */
public interface ISmsSignatureExtnoService extends ICrudService<SmsSignatureExtno> {
		
	/**
	 * 
	   * TODO 保存
	   * 
	   * @param signatureExtNo
	   * @return
	 */
	boolean save(SmsSignatureExtno signatureExtNo);

	/**
	 * 
	   * TODO 修改
	   * 
	   * @param signatureExtNo
	   * @return
	 */
	boolean update(SmsSignatureExtno signatureExtNo);

	/**
	 * 
	 * TODO 删除模板
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(String id);

	/**
	 * 
	 * TODO 将签名扩展号数据加载到REDIS
	 * 
	 * @return
	 */
	boolean reloadToRedis();

	/**
	 * 
	   * TODO 根据内容模糊匹配得到扩展号信息（起始内容或者结尾内容包括 匹配签名）
	   * 
	   * @param userCode
	   * @param content
	   * @return
	 */
	String getExtNumber(String userCode, String content);
}