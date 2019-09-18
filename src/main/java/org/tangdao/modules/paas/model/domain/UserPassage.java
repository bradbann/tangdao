package org.tangdao.modules.paas.model.domain;

import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户通道配置Entity
 * @author ruyang
 * @version 2019-09-06
 */
@Getter
@Setter
@TableName("paas_user_passage")
public class UserPassage extends DataEntity<UserPassage> {
	
	private static final long serialVersionUID = 1L;
	
	@TableId
	private String id;
	
	private String userCode;		// 用户编码
	private int    type;		// 类型 1-短信，2-流量，3-语音
	private String passageGroupId;		// 业务通道组ID，如短信通道组ID，流量通道组ID
	
	public UserPassage() {
		super();
	}

	public UserPassage(String id){
		super(id);
	}
	public UserPassage(String userCode, Integer type, String passageGroupId) {

        this.userCode = userCode;
        this.type = type;
        this.passageGroupId = passageGroupId;
    }
}