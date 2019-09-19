package org.tangdao.modules.sms.service;

import java.util.List;

import org.tangdao.common.service.ICrudService;
import org.tangdao.modules.sms.model.domain.SmsMtMessageDeliver;

import com.alibaba.fastjson.JSONObject;

/**
 * 下行短信回执状态Service
 * @author ruyang
 * @version 2019-09-06
 */
public interface ISmsMtDeliverService extends ICrudService<SmsMtMessageDeliver> {
	/**
     * TODO 根据消息ID和手机号码查询回执信息
     * 
     * @param mobile
     * @param msgId
     * @return
     */
    SmsMtMessageDeliver findByMobileAndMsgid(String mobile, String msgId);

    /**
     * TODO 批量插入信息
     * 
     * @param list
     * @return
     */
    void batchInsert(List<SmsMtMessageDeliver> list);

    /**
     * TODO 完成回执逻辑
     * 
     * @param list
     * @return
     */
    int doFinishDeliver(List<SmsMtMessageDeliver> list);

    /**
     * TODO 上家回执数据正常回执 但处理发生异常情况需要记录错误信息，以便人工补偿机制
     * 
     * @param obj
     * @return
     */
    boolean doDeliverToException(JSONObject obj);
}