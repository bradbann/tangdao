package org.tangdao.modules.sms.worker.fork;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.tangdao.common.utils.SpringUtils;
import org.tangdao.modules.sms.model.domain.SmsMtMessageDeliver;
import org.tangdao.modules.sms.redis.constant.SmsRedisConstant;
import org.tangdao.modules.sms.service.ISmsMtPushService;
import org.tangdao.modules.sms.worker.AbstractWorker;

/**
 * TODO 针对短信下行报告推送（首次数据未入库或者REDIS无相关数据，后续追加推送）
 * 
 * @author ruyang
 * @version V1.0
 * @date 2017年12月5日 下午5:45:18
 */
public class MtReportFailoverPushWorker extends AbstractWorker<SmsMtMessageDeliver> {

    @Override
    protected String jobTitle() {
        return "短信状态补偿轮训";
    }

//    public MtReportFailoverPushWorker(ApplicationContext applicationContext) {
//        super(applicationContext);
//    }

    @Override
    protected void operate(List<SmsMtMessageDeliver> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        SpringUtils.getBean(ISmsMtPushService.class).compareAndPushBody(list);
//        getInstance(ISmsMtPushService.class).compareAndPushBody(list);
    }

    @Override
    protected String redisKey() {
        return SmsRedisConstant.RED_QUEUE_SMS_DELIVER_FAILOVER;
    }

    @Override
    protected int scanSize() {
        return 1000;
    }

    @Override
    protected long timeout() {
        return super.timeout();
    }

}
