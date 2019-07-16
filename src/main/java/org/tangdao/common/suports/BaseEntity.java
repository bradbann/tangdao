package org.tangdao.common.suports;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.tangdao.common.config.Global;
import org.tangdao.common.utils.ObjectUtils;
import org.tangdao.common.utils.ReflectUtils;
import org.tangdao.modules.sys.model.domain.User;
import org.tangdao.modules.sys.utils.UserUtils;

import com.baomidou.mybatisplus.annotation.TableField;
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

	@JsonIgnore
	@TableField(exist = false)
	protected String key;

	@JsonIgnore
	@TableField(exist = false)
	protected String keyAttrName;

	@JsonIgnore
	@TableField(exist = false)
	protected String keyColumnName;

	@TableField(exist = false)
	protected boolean isNewRecord;

	/**
	 * 当前用户
	 */
	@JsonIgnore
	@TableField(exist = false)
	protected User currentUser;

	/**
	 * 分页对象
	 */
	@TableField(exist = false)
	@JsonIgnore
	protected Pagination pagination;

	public void setPerpage(Long perpage) {
		if (perpage != null) {
			if (this.pagination == null) {
				this.pagination = new Pagination();
			}
			this.pagination.setPerpage(perpage);
		}
	}

	public void setPage(Long page) {
		if (page != null) {
			if (this.pagination == null) {
				this.pagination = new Pagination();
			}
			this.pagination.setPage(page);
		}
	}

	/**
	 * 排序对象
	 */
	@TableField(exist = false)
	@JsonIgnore
	protected Sort sort;

	public void setField(String field) {
		if (field != null) {
			if (this.sort == null) {
				this.sort = new Sort();
			}
			this.sort.setField(field);
		}
	}

	public void setSort(String sort) {
		if (sort != null) {
			if (this.sort == null) {
				this.sort = new Sort();
			}
			this.sort.setSort(sort);
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

	/**
	 * 全局配置
	 */
	public Global getGlobal() {
		return Global.getInstance();
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
				value = ReflectUtils.invokeGetter(this, tableInfo.getKeyProperty());
			} catch (Exception e) {
				e.printStackTrace();
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
