package org.tangdao.modules.sms.service;

import org.tangdao.common.service.ICrudService;
import org.tangdao.modules.sms.model.domain.SmsMessageTemplate;

/**
 * 消息模板Service
 * @author ruyang
 * @version 2019-09-06
 */
public interface ISmsTemplateService extends ICrudService<SmsMessageTemplate> {

    /**
     * TODO 添加模板
     * 
     * @param template
     * @return
     */
    boolean save(SmsMessageTemplate template);

    /**
     * TODO 模板审核
     * 
     * @param id
     * @param status
     * @param remarks
     * @return
     */
    boolean approve(String id, int status, String remarks);

    /**
     * TODO 更新模板内容
     * 
     * @param template
     * @return
     */
    boolean update(SmsMessageTemplate template);

    /**
     * TODO 删除模板
     * 
     * @param id
     * @return
     */
    boolean deleteById(String id);

    /**
     * TODO 删除模板（判断模板是否属于该用户）
     * 
     * @param id
     * @param userId
     * @return
     */
    boolean delete(String id, String userCode);


    /**
     * TODO 根据用户ID和短信内容查询模板信息（优先级排序）
     * 
     * @param userId
     * @param content
     * @return
     */
    SmsMessageTemplate getByContent(String userCode, String content);

    /**
     * TODO 判断输入内容是否符合模板内容
     * 
     * @param id
     * @param content
     * @return
     */
    boolean isContentMatched(String id, String content);

    /**
     * TODO 批量添加短信模板（针对其他配置项都一样，只有模板内容为多个的情况）
     * 
     * @param template
     * @param contents
     * @return
     */
    boolean saveToBatchContent(SmsMessageTemplate template, String[] contents);

    /**
     * TODO 将模板数据加载到REDIS
     * 
     * @return
     */
    boolean reloadToRedis();
}