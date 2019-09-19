package org.tangdao.modules.sms.service;

import java.util.List;

import org.tangdao.common.service.ICrudService;
import org.tangdao.modules.sms.model.domain.SmsMoMessageReceive;

/**
 * 上行消息回复Service
 * @author ruyang
 * @version 2019-09-06
 */
public interface ISmsMoReceiveService extends ICrudService<SmsMoMessageReceive> {
	/**
     * 
       * TODO 完成上行回复逻辑
       * 
       * @param list
       * @return
     */
    int doFinishReceive(List<SmsMoMessageReceive> list);
    
    /**
     * 
       * TODO 发送错误信息值异常回执数据
       * 
       * @param obj
       * @return
     */
    boolean doReceiveToException(Object obj);
}