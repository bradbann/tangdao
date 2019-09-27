package org.tangdao.modules.sms.service;

import org.tangdao.common.service.ICrudService;
import org.tangdao.modules.sms.model.domain.SmsMtTaskPackets;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 下行短信任务分包Service
 * @author ruyang
 * @version 2019-09-06
 */
public interface ISmsMtTaskPacketsService extends ICrudService<SmsMtTaskPackets> {
	
	public SmsMtTaskPackets getSmsMtTaskPackets(SmsMtTaskPackets smsMtTaskPackets);
		
	public IPage<SmsMtTaskPackets> page(IPage<SmsMtTaskPackets> page, Wrapper<SmsMtTaskPackets> queryWrapper);
}