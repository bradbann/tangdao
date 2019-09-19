package org.tangdao.modules.sms.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import org.tangdao.common.service.ICrudService;
import org.tangdao.modules.sms.model.domain.SmsMtMessageDeliver;
import org.tangdao.modules.sms.model.domain.SmsMtMessagePush;
import org.tangdao.modules.sms.model.domain.SmsMtMessageSubmit;
import org.tangdao.modules.sms.model.vo.SmsPushReport;

import com.alibaba.fastjson.JSONObject;

/**
 * 下行短信推送Service
 * 短信推送服务
 * @author ruyang
 * @version 2019-09-06
 */
public interface ISmsMtPushService extends ICrudService<SmsMtMessagePush> {
	
	/**
     * 根据手机号码和消息ID查询推送记录信息
     * 
     * @param mobile
     * @param msgId
     * @return
     */
    SmsMtMessagePush findByMobileAndMsgid(String mobile, String msgId);
	
    /**
     * 监听所有用户信息
     * 
     * @return
     */
    boolean doListenerAllUser();

    /**
     * 根据用户ID获取用户待推送队列名称
     * 
     * @param userCode
     * @return
     */
    String getUserPushQueueName(String userCode);

    /**
     * 设置消息ID组装待推送数据配置信息（异步）
     * 
     * @param submits
     * @return
     */
    void setMessageReadyPushConfigurations(List<SmsMtMessageSubmit> submits);

    /**
     * 比对回执报文数据并且发送报文至下家（异步）
     * 
     * @param delivers
     * @return
     */
    Future<Boolean> compareAndPushBody(List<SmsMtMessageDeliver> delivers);

    /**
     * 推送下行短信回执报告至开发者（下家客户）
     * 
     * @param bodies 组装的推送报文数据
     */
    void pushMessageBodyToDeveloper(List<JSONObject> bodies);

    /**
     * 获取待推送数据报告（如 SID,用户自定义内容）
     * 
     * @param msgId 消息ID
     * @param mobile 手机号码
     * @return
     */
    JSONObject getWaitPushBodyArgs(String msgId, String mobile);

    /**
     * 添加用户推送队列监听（添加用户后需要添加监听）
     * 
     * @param userCode
     * @return
     */
    boolean addUserMtPushListener(String userCode);

    /**
     * 获取下行短信待推送消息 KEY
     * 
     * @param msgId
     * @return
     */
    String getMtPushConfigKey(String msgId);

    /**
     * 开启针对状态回执过快/插入submit慢的数据进行重试（防止丢数据）
     * 
     * @return
     */
    boolean startFailoverListener();

    /**
     * 获取推送数据报告
     * 
     * @param queryParams
     * @return
     */
    SmsPushReport getPushReport(Map<String, Object> queryParams);

    /**
     * 重新推送数据
     * 
     * @param serialNo 批号
     * @return 返回结果
     */
    boolean repush(Long serialNo);
}