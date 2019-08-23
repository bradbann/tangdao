package org.tangdao.modules.sys.model.domain;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import org.tangdao.common.suports.DataEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 岗位Entity
 * @author ruyang
 * @version 2019-08-23
 */
@TableName("sys_post")
public class Post extends DataEntity<Post> {
	
	private static final long serialVersionUID = 1L;
	
	@TableId
	private String postCode;		// 岗位编码
	private String postName;		// 岗位名称
	private String postType;		// 岗位分类（高管、中层、基层）
	private Integer postSort;		// 岗位排序（升序）
	
	public Post() {
		super();
	}

	public Post(String postCode){
		super(postCode);
	}
	
	@Length(min=0, max=64, message="岗位编码长度必须介于 0 和 64 之间")
	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	@Length(min=0, max=100, message="岗位名称长度必须介于 0 和 100 之间")
	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}
	
	@Length(min=1, max=1, message="岗位分类（高管、中层、基层）长度必须介于 1 和 1 之间")
	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}
	
	@NotNull(message="岗位排序（升序）不能为空")
	public Integer getPostSort() {
		return postSort;
	}

	public void setPostSort(Integer postSort) {
		this.postSort = postSort;
	}
	
}