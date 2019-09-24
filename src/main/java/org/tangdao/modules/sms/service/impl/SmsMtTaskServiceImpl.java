package org.tangdao.modules.sms.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.common.utils.ListUtils;
import org.tangdao.modules.sms.mapper.SmsMtTaskMapper;
import org.tangdao.modules.sms.model.domain.SmsMtTask;
import org.tangdao.modules.sms.service.ISmsMtTaskPacketsService;
import org.tangdao.modules.sms.service.ISmsMtTaskService;

/**
 * 下行短信任务ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsMtTaskServiceImpl extends CrudServiceImpl<SmsMtTaskMapper, SmsMtTask> implements ISmsMtTaskService{
	
	@Autowired
	private ISmsMtTaskPacketsService smsMtTaskPacketsService;

	private final Logger               logger = LoggerFactory.getLogger(getClass());
	
	@Override
    public boolean save(SmsMtTask task) {
        if (task == null) {
            logger.error("任务数据为空，处理失败");
            return false;
        }

        boolean effect = super.save(task);
        if (effect) {
            if (ListUtils.isNotEmpty(task.getPackets())) {
            	smsMtTaskPacketsService.saveBatch(task.getPackets());
            }
        }
        return effect;
    }
}