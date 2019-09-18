package org.tangdao.modules.sms.config.worker.fork;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.tangdao.common.utils.SpringUtils;
import org.tangdao.modules.sms.config.worker.AbstractWorker;
import org.tangdao.modules.sms.service.ISmsMtPushService;

import com.alibaba.fastjson.JSONObject;

/**
 * 针对短信下行报告推送给下家（首次数据未入库或者REDIS无相关数据，后续追加推送）
 * 
 * @author ruyang
 * @version V1.0
 * @date 2017年12月5日 下午5:46:12
 */
public class MtReportPushToDeveloperWorker extends AbstractWorker<JSONObject> {

    private String developerPushQueueName;

//    public MtReportPushToDeveloperWorker(ApplicationContext applicationContext) {
//        super(applicationContext);
//    }
//
    public MtReportPushToDeveloperWorker(String developerPushQueueName) {
        this.developerPushQueueName = developerPushQueueName;
    }

    @Override
    protected void operate(List<JSONObject> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        SpringUtils.getBean(ISmsMtPushService.class).pushMessageBodyToDeveloper(list);
//        getInstance(ISmsMtPushService.class).pushMessageBodyToDeveloper(list);
    }

    @Override
    protected String redisKey() {
        return developerPushQueueName;
    }

    @Override
    protected String jobTitle() {
        return "短信状态报告推送";
    }

    @Override
    protected long timeout() {
        return super.timeout();
    }

}
