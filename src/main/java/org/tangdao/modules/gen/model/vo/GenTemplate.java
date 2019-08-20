package org.tangdao.modules.gen.model.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.tangdao.common.suports.DataEntity;
import org.tangdao.common.utils.ListUtils;
import org.tangdao.common.utils.StringUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name="template")
public class GenTemplate extends DataEntity<GenTemplate> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name; 	// 名称
	private String category;		// 分类
	private String filePath;		// 生成文件路径
	private String fileName;		// 文件名
	private String content;		// 内容

	public GenTemplate() {
		super();
	}

	public GenTemplate(String id){
		super(id);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	@XmlTransient
	public List<String> getCategoryList() {
		if (category == null){
			return ListUtils.newArrayList();
		}else{
			return ListUtils.newArrayList(StringUtils.split(category, ","));
		}
	}

	public void setCategoryList(List<String> categoryList) {
		if (categoryList == null){
			this.category = "";
		}else{
			this.category = ","+StringUtils.join(categoryList, ",") + ",";
		}
	}
}
