package org.tangdao.modules.sms.model.domain;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 提交报告（小时）Entity
 * @author ruyang
 * @version 2019-09-06
 */
@TableName("sms_submit_hour_report")
public class SmsSubmitHourReport extends DataEntity<SmsSubmitHourReport> {
	
	private static final long serialVersionUID = 1L;
	
	private String userCode;		// 用户编码
	private String passageId;		// 通道ID
	private String provinceCode;		// 省份代码
	private String submitCount;		// 提交数量
	private String billCount;		// 计费数
	private String unknownCount;		// 未知数量
	private String successCount;		// 成功数量
	private String submitFailedCount;		// 发送失败数量
	private String otherCount;		// 其他数量
	private String bornHours;		// 落地小时阀值
	private Long hourTime;		// 当前小时毫秒数
	
	public SmsSubmitHourReport() {
		super();
	}

	public SmsSubmitHourReport(String id){
		super(id);
	}
	
	@NotBlank(message="用户编码不能为空")
	@Length(min=0, max=64, message="用户编码长度不能超过  64 个字符")
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	@NotBlank(message="通道ID不能为空")
	@Length(min=0, max=11, message="通道ID长度不能超过  11 个字符")
	public String getPassageId() {
		return passageId;
	}

	public void setPassageId(String passageId) {
		this.passageId = passageId;
	}
	
	@NotBlank(message="省份代码不能为空")
	@Length(min=0, max=4, message="省份代码长度不能超过  4 个字符")
	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	
	@NotBlank(message="提交数量不能为空")
	@Length(min=0, max=11, message="提交数量长度不能超过  11 个字符")
	public String getSubmitCount() {
		return submitCount;
	}

	public void setSubmitCount(String submitCount) {
		this.submitCount = submitCount;
	}
	
	@NotBlank(message="计费数不能为空")
	@Length(min=0, max=11, message="计费数长度不能超过  11 个字符")
	public String getBillCount() {
		return billCount;
	}

	public void setBillCount(String billCount) {
		this.billCount = billCount;
	}
	
	@Length(min=0, max=11, message="未知数量长度不能超过  11 个字符")
	public String getUnknownCount() {
		return unknownCount;
	}

	public void setUnknownCount(String unknownCount) {
		this.unknownCount = unknownCount;
	}
	
	@Length(min=0, max=11, message="成功数量长度不能超过  11 个字符")
	public String getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(String successCount) {
		this.successCount = successCount;
	}
	
	@Length(min=0, max=11, message="发送失败数量长度不能超过  11 个字符")
	public String getSubmitFailedCount() {
		return submitFailedCount;
	}

	public void setSubmitFailedCount(String submitFailedCount) {
		this.submitFailedCount = submitFailedCount;
	}
	
	@Length(min=0, max=11, message="其他数量长度不能超过  11 个字符")
	public String getOtherCount() {
		return otherCount;
	}

	public void setOtherCount(String otherCount) {
		this.otherCount = otherCount;
	}
	
	@Length(min=0, max=11, message="落地小时阀值长度不能超过  11 个字符")
	public String getBornHours() {
		return bornHours;
	}

	public void setBornHours(String bornHours) {
		this.bornHours = bornHours;
	}
	
	public Long getHourTime() {
		return hourTime;
	}

	public void setHourTime(Long hourTime) {
		this.hourTime = hourTime;
	}
	
}