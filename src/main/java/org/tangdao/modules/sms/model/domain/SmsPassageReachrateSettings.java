package org.tangdao.modules.sms.model.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 通道重连配置Entity
 * @author ruyang
 * @version 2019-09-06
 */
@TableName("sms_passage_reachrate_settings")
public class SmsPassageReachrateSettings extends DataEntity<SmsPassageReachrateSettings> {
	
	private static final long serialVersionUID = 1L;
	
	private Long passageId;		// 短信通道ID
	private Long interval;		// 轮询间隔（单位秒）
	private Long startTime;		// 数据源时间（开始执行时间点，单位秒）
	private Long timeLength;		// 数据源时长
	private String countPoint;		// 计数阀值，起始点
	private String rateThreshold;		// 到达率，整数，最大100
	private String mobile;		// 通知手机号码
	
	public SmsPassageReachrateSettings() {
		super();
	}

	public SmsPassageReachrateSettings(String id){
		super(id);
	}
	
	@NotNull(message="短信通道ID不能为空")
	public Long getPassageId() {
		return passageId;
	}

	public void setPassageId(Long passageId) {
		this.passageId = passageId;
	}
	
	@NotNull(message="轮询间隔（单位秒）不能为空")
	public Long getInterval() {
		return interval;
	}

	public void setInterval(Long interval) {
		this.interval = interval;
	}
	
	@NotNull(message="数据源时间（开始执行时间点，单位秒）不能为空")
	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	
	@NotNull(message="数据源时长不能为空")
	public Long getTimeLength() {
		return timeLength;
	}

	public void setTimeLength(Long timeLength) {
		this.timeLength = timeLength;
	}
	
	@NotBlank(message="计数阀值，起始点不能为空")
	@Length(min=0, max=11, message="计数阀值，起始点长度不能超过  11 个字符")
	public String getCountPoint() {
		return countPoint;
	}

	public void setCountPoint(String countPoint) {
		this.countPoint = countPoint;
	}
	
	@NotBlank(message="到达率，整数，最大100不能为空")
	@Length(min=0, max=4, message="到达率，整数，最大100长度不能超过  4 个字符")
	public String getRateThreshold() {
		return rateThreshold;
	}

	public void setRateThreshold(String rateThreshold) {
		this.rateThreshold = rateThreshold;
	}
	
	@Length(min=0, max=64, message="通知手机号码长度不能超过  64 个字符")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}