package org.tangdao.common.suports;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.tangdao.common.utils.ObjectUtils;
import org.tangdao.common.utils.ReflectUtils;
import org.tangdao.modules.sys.model.domain.User;
import org.tangdao.modules.sys.utils.UserUtils;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public abstract class BaseEntity<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@TableField(exist = false)
	protected String key;

	@JsonIgnore
	@TableField(exist = false)
	protected transient String keyAttrName;

	@JsonIgnore
	@TableField(exist = false)
	protected transient String keyColumnName;

	@TableField(exist = false)
	protected transient boolean isNewRecord;

	/**
	 * 当前用户
	 */
	@JsonIgnore
	@TableField(exist = false)
	protected transient User currentUser;

	/**
	 * 分页对象
	 */
	@TableField(exist = false)
	protected transient Page<T> page;

	public void setPageSize(Integer pageSize) {
		if (this.page == null) {
			this.page = new Page<T>();
		}
		if (pageSize != null) {
			this.getPage().setSize(pageSize);
		}else {
			this.getPage().setSize(20);
		}
	}

	public void setPageNo(Integer pageNo) {
		if (this.page == null) {
			this.page = new Page<T>();
		}
		if (pageNo != null) {
			this.getPage().setCurrent(pageNo);
		}else {
			this.getPage().setCurrent(1);
		}
	}

	public void setOrderBy(String orderBy) {
		if (this.page == null) {
			this.page = new Page<T>();
		}
		if (StringUtils.isNotBlank(orderBy)) {
			String[] orderBys = orderBy.split(" ");
			if(orderBys!=null&&orderBys.length==2) {
				if (StringUtils.isNoneEmpty(orderBys[1])&&"asc".equalsIgnoreCase(orderBys[1])) {
					this.getPage().addOrder(OrderItem.asc(orderBys[0]));
				} else {
					this.getPage().addOrder(OrderItem.desc(orderBys[0]));
				}
			}
		}

	 }

	public BaseEntity() {
		this(null);
	}

	public BaseEntity(String key) {
		this.isNewRecord = false;
		if (key == null) {
			this.setKey(key);
		}
	}

	public User getCurrentUser() {
		if (currentUser == null) {
			currentUser = UserUtils.getUser();
		}
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	/**
	 * 插入之前执行方法，子类实现
	 */
	public abstract void preInsert();

	/**
	 * 更新之前执行方法，子类实现
	 */
	public abstract void preUpdate();

	/**
	 * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。 设置为true后强制執行主鍵策略
	 */
	public boolean getIsNewRecord() {
		return this.isNewRecord || StringUtils.isBlank(this.getKey());
	}

	public void setIsNewRecord(boolean isNewRecord) {
		this.isNewRecord = isNewRecord;
	}

	public Object clone() {
		return ObjectUtils.cloneBean(this);
	}

	/**
	 * 获取主键
	 * 
	 * @return
	 */
	public String getKey() {
		if (StringUtils.isBlank(this.key)) {
			String value = null;
			try {
				TableInfo tableInfo = TableInfoHelper.getTableInfo(this.getClass());
				if(tableInfo==null) {
					return null;
				}
				value = ReflectUtils.invokeGetter(this, tableInfo.getKeyProperty());
			} catch (Exception e) {
			}
			if (StringUtils.isBlank(value)) {
				return null;
			}
			this.setKey(value);
		}
		if (StringUtils.isBlank(this.key)) {
			return null;
		}
		return this.key;
	}

	/**
	 * 主键信息
	 * 
	 * @param key
	 */
	public void setKey(String key) {
		TableInfo tableInfo = TableInfoHelper.getTableInfo(this.getClass());
		if (tableInfo != null) {
			this.setKeyAttrName(tableInfo.getKeyProperty());
			this.setKeyColumnName(tableInfo.getKeyColumn());
			ReflectUtils.invokeSetter(this, this.keyAttrName, key);
			this.key = key;
		}
	}
}
