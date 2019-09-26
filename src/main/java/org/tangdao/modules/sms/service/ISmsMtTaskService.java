package org.tangdao.modules.sms.service;

import org.tangdao.common.service.ICrudService;
import org.tangdao.modules.sms.model.domain.SmsMtTask;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 下行短信任务Service
 * @author ruyang
 * @version 2019-09-06
 */
public interface ISmsMtTaskService extends ICrudService<SmsMtTask> {
		
	public boolean save(SmsMtTask task);
	
	public IPage<SmsMtTask> page(IPage<SmsMtTask> page, Wrapper<SmsMtTask> queryWrapper);
	
}