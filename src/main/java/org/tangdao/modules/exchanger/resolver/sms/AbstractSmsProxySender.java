package org.tangdao.modules.exchanger.resolver.sms;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.tangdao.modules.exchanger.service.ISmsProxyManager;
import org.tangdao.modules.exchanger.service.template.SmsProxyManagerTemplate;
import org.tangdao.modules.sms.model.domain.SmsMoMessageReceive;
import org.tangdao.modules.sms.model.domain.SmsMtMessageDeliver;
import org.tangdao.modules.sms.model.domain.SmsPassageParameter;

/**
 * TODO 直连抽象类
 * 
 * @author ruyang
 * @version V1.0
 * @date 2018年8月5日 上午12:21:38
 */
public abstract class AbstractSmsProxySender {
	
    @Autowired
    protected ISmsProxyManager         smsProxyManageService;

//    @Resource
//    protected RabbitTemplate           rabbitTemplate;

    protected final Logger             logger             = LoggerFactory.getLogger(getClass());

    /**
     * 通道ID锁
     */
    private final Map<String, Object> passageLockMonitor = new ConcurrentHashMap<>();

    private void addPassageLockMonitor(String passageId) {
        passageLockMonitor.putIfAbsent(passageId, new Object());
    }

    /**
     * TODO 获取直连对象的代理信息（不同通道间初始化互不影响）
     * 
     * @param parameter
     * @return
     */
    protected Object getSmManageProxy(SmsPassageParameter parameter) {
        addPassageLockMonitor(parameter.getPassageId());

        synchronized (passageLockMonitor.get(parameter.getPassageId())) {
            if (smsProxyManageService.isProxyAvaiable(parameter.getPassageId())) {
                return SmsProxyManagerTemplate.getManageProxy(parameter.getPassageId());
            }

            boolean isOk = smsProxyManageService.startProxy(parameter);
            if (!isOk) {
                return null;
            }

            // 重新初始化后将错误计数器归零
            smsProxyManageService.clearSendErrorTimes(parameter.getPassageId());

            return SmsProxyManagerTemplate.GLOBAL_PROXIES.get(parameter.getPassageId());
        }
    }

    /**
     * TODO 断开直连协议连接
     * 
     * @param passageId
     */
    public void onTerminate(String passageId) {
        smsProxyManageService.stopProxy(passageId);
    }
    
    /**
	 * 短信上行状态报告
     */
    public static final String MQ_SMS_MT_WAIT_RECEIPT = "mq_sms_mt_wait_receipt";
    
    protected void sendMtMessageDeliver(final List<SmsMtMessageDeliver> list) {
    	
    }
    
    /**
     * 短信上行回执数据
     */
    public static final String MQ_SMS_MO_RECEIVE      = "mq_sms_mo_receive";
    
    protected void sendMoMessageReceive(final List<SmsMoMessageReceive> list) {
    	
    }
}
