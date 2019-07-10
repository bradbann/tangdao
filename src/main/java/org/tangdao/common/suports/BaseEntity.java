package org.tangdao.common.suports;

import java.io.Serializable;

import org.tangdao.common.utils.ObjectUtils;
import org.tangdao.modules.sys.model.domain.User;
import org.tangdao.modules.sys.utils.UserUtils;

import com.baomidou.mybatisplus.annotation.TableField;
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

	@JsonIgnore	
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
//	@JsonIgnore
//	@TableField(exist = false)
//	protected Pagination pagination;

	public BaseEntity() {
		this(null);
	}

	public BaseEntity(String key) {
		this.isNewRecord = false;
		this.key = key;
	}
	
	public User getCurrentUser() {
		if(currentUser == null){
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
//		this.isNewRecord = this.isNewRecord || StrUtil.isBlank(this.getKey());
		return this.isNewRecord;
	}

	public void setIsNewRecord(boolean isNewRecord) {
		this.isNewRecord = isNewRecord;
	}

//	/**
//	 * 全局配置
//	 */
//	public Global getGlobal() {
//		return Global.getInstance();
//	}
//
	public Object clone() {
		return ObjectUtils.cloneBean(this);
	}
//
//	/**
//	 * 获取主键
//	 * 
//	 * @return
//	 */
//	public String getKey() {
//		if (StringUtils.isBlank(this.key)) {
//			String value = null;
//			try {
//				EntityColumn entityColumn = EntityHelper.getPKColumns(this.getClass()).iterator().next();
//				value = ReflectUtils.invokeGetter(this, entityColumn.getEntityField().getName());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			if (StringUtils.isBlank(value)) {
//				return null;
//			}
//			this.setKey(value);
//		}
//		if (StringUtils.isBlank(this.key)) {
//			return null;
//		}
//		return this.key;
//	}
//
//	public void setKey(String key) {
//		EntityColumn entityColumn = EntityHelper.getPKColumns(this.getClass()).iterator().next();
//		this.setKeyColumnName(entityColumn.getColumn());
//		this.setKeyAttrName(entityColumn.getEntityField().getName());
//		ReflectUtils.invokeSetter(this, this.keyAttrName, key);
//		this.key = key;
//	}
	
	/**
	 * 正常
	 */
	public static final String STATUS_NORMAL = "0";
	/**
	 * 已删除
	 */
	public static final String STATUS_DELETE = "1";
	/**
	 * 停用
	 */
	public static final String STATUS_DISABLE = "2";
	/**
	 * 冻结
	 */
	public static final String STATUS_FREEZE = "3";
	/**
	 * 审核
	 */
	public static final String STATUS_AUDIT = "4";
	/**
	 * 回退
	 */
	public static final String STATUS_AUDIT_BACK = "5";
	/**
	 * 草稿
	 */
	public static final String STATUS_DRAFT = "9";

}
