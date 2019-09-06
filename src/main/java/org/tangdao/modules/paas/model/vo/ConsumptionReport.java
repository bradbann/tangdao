package org.tangdao.modules.paas.model.vo;

import java.io.Serializable;
import java.util.Date;

public class ConsumptionReport implements Serializable{
    
	private static final long serialVersionUID = -8177329372067297473L;

	private Integer id;

    private Integer type;

    private String userCode;

    private Integer amount;

    private String remark;

    private Date recordDate;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    
    public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public ConsumptionReport(Integer type, String userCode, Integer amount) {
		super();
		this.type = type;
		this.userCode = userCode;
		this.amount = amount;
	}

	public ConsumptionReport() {
		super();
	}
    
}