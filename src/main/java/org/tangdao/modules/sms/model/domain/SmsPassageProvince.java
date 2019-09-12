package org.tangdao.modules.sms.model.domain;

import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

/**
 * 通道支持省份Entity
 * @author ruyang
 * @version 2019-09-06
 */
@Getter
@Setter
@TableName("sms_passage_province")
public class SmsPassageProvince extends DataEntity<SmsPassageProvince> {
	
	private static final long serialVersionUID = 1L;
	
	@TableId
	private String id;
	private String passageId;		// 通道ID
	private String provinceCode;		// 省份代码
	
	public SmsPassageProvince() {
		super();
	}

	public SmsPassageProvince(String id){
		super(id);
	}
	
	public SmsPassageProvince(String passageId,String provinceCode){
        this.passageId = passageId;
        this.provinceCode = provinceCode;
    }
	
}