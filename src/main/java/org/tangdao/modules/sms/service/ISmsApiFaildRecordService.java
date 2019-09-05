package org.tangdao.modules.sms.service;

import org.tangdao.modules.sms.model.domain.SmsApiFailedRecord;

/**
 * 短信错误记录服务接口类
 *
 */
public interface ISmsApiFaildRecordService {

    /**
     * TODO 添加错误记录
     *
     * @param record
     * @return
     */
    boolean save(SmsApiFailedRecord record);

}
