package org.tangdao.modules.sms.model.domain;

import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

/**
 * 告警敏感词Entity
 * @author ruyang
 * @version 2019-09-06
 */
@Getter
@Setter
@TableName("sms_forbidden_words")
public class SmsForbiddenWords extends DataEntity<SmsForbiddenWords> {
	
	private static final long serialVersionUID = 1L;
	
	@TableId
	private String id;
	
	private String word;		// 敏感词
	private int    level;		// 告警级别，区分颜色
	private String label;		// 标签
	
	public SmsForbiddenWords() {
		super();
	}

	public SmsForbiddenWords(String id){
		super(id);
	}
}