package org.tangdao.modules.gen.model.domain;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlTransient;

import org.tangdao.common.config.Global;
import org.tangdao.common.suports.DataEntity;
import org.tangdao.common.utils.JsonMapper;
import org.tangdao.common.utils.ListUtils;
import org.tangdao.common.utils.MapUtils;
import org.tangdao.common.utils.StringUtils;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("gen_table")
public class GenTable extends DataEntity<GenTable> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@TableId
	private String tableName; 	// 名称
	private String comments;		// 描述
	private String className;		// 实体类名称
	private String parentTable;		// 关联父表
	private String parentTableFk;		// 关联父表外键
	
	private String tplCategory;		// 分类
	private String packageName;		// 生成包路径
	private String moduleName;		// 生成模块名
	private String subModuleName;		// 生成子模块名
	private String functionName;		// 生成功能名
	private String functionNameSimple;		// 生成功能名（简写）
	private String functionAuthor;		// 生成功能作者
	private String genBaseDir;	//生成基础路径

	@TableField(exist = false)
	private List<GenTableColumn> columnList = ListUtils.newArrayList();	// 表列

	@TableField(exist = false)
	private List<GenTableColumn> pkList; // 当前表主键列表
	
	@TableField(exist = false)
	private GenTable parent;	// 父表对象
	
	@TableField(exist = false)
	private List<GenTable> childList = ListUtils.newArrayList();	// 子表列表
	
	@TableField(exist = false)
	private String flag; 	// 0：保存方案； 1：保存方案并生成代码
	
	@TableField(exist = false)
	private Boolean replaceFile;	// 是否替换现有文件    0：不替换；1：替换文件
	
	private String options;
	
	@SuppressWarnings("rawtypes")
	@TableField(exist = false)
	private Map optionMap;
	
	@SuppressWarnings("rawtypes")
	public void setOptions(String options) {
	      if (StringUtils.isNotBlank(options)) {
	         this.optionMap = (Map)JsonMapper.fromJson(options, Map.class);
	      }

	      this.options = options;
	}
	
	@JsonIgnore
	public String getOptions() {
		if (this.optionMap != null) {
			this.options = JsonMapper.toJson(this.optionMap);
		}
		return this.options;
	}
	
	@SuppressWarnings("rawtypes")
	public Map getOptionMap() {
		if (this.optionMap == null) {
			this.optionMap = MapUtils.newHashMap();
		}
		return this.optionMap;
	}
	
	@JsonIgnore	
	@XmlTransient	
	public Global getGlobal() {	
		return Global.getInstance();	
	}
	
	public GenTable() {
		super();
	}

	public GenTable(String id){
		super(id);
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getParentTable() {
		return StringUtils.lowerCase(parentTable);
	}

	public void setParentTable(String parentTable) {
		this.parentTable = parentTable;
	}

	public String getParentTableFk() {
		return StringUtils.lowerCase(parentTableFk);
	}

	public void setParentTableFk(String parentTableFk) {
		this.parentTableFk = parentTableFk;
	}

	public GenTable getParent() {
		return parent;
	}

	public void setParent(GenTable parent) {
		this.parent = parent;
	}

	public List<GenTableColumn> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<GenTableColumn> columnList) {
		this.columnList = columnList;
	}

	public List<GenTable> getChildList() {
		return childList;
	}

	public void setChildList(List<GenTable> childList) {
		this.childList = childList;
	}
	
	/**
	 * 获取列名和说明
	 * @return
	 */
	public String getTableNameAndComments() {
		return getTableName() + (comments == null ? "" : "  :  " + comments);
	}

	/**
	 * 获取导入依赖包字符串
	 * @return
	 */
	public List<String> getImportList(){
		List<String> importList = ListUtils.newArrayList(); // 引用列表
		for (GenTableColumn column : getColumnList()){
			if (column.getIsNotBaseField() || ("1".equals(column.getIsQuery()) && "between".equals(column.getQueryType())
							&& ("createTime".equals(column.getSimpleJavaField()) || "updateTime".equals(column.getSimpleJavaField())))){
				// 导入类型依赖包， 如果类型中包含“.”，则需要导入引用。
				if (StringUtils.indexOf(column.getJavaType(), ".") != -1 && !importList.contains(column.getJavaType())){
					importList.add(column.getJavaType());
				}
			}
			if (column.getIsNotBaseField()){
				// 导入JSR303、Json等依赖包
				for (String ann : column.getAnnotationList()){
					if (!importList.contains(StringUtils.substringBeforeLast(ann, "("))){
						importList.add(StringUtils.substringBeforeLast(ann, "("));
					}
				}
			}
		}
		// 如果有子表，则需要导入List相关引用
		if (getChildList() != null && getChildList().size() > 0){
			if (!importList.contains("java.util.List")){
				importList.add("java.util.List");
			}
		}
		return importList;
	}
	
	/**
	 * 是否存在父类
	 * @return
	 */
	public Boolean getParentExists(){
		return parent != null && StringUtils.isNotBlank(parentTable) && StringUtils.isNotBlank(parentTableFk);
	}

	/**
	 * 是否存在create_date列
	 * @return
	 */
	public Boolean getCreateTimeExists(){
		for (GenTableColumn c : columnList){
			if ("create_time".equals(c.getColumnName())){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 是否存在update_date列
	 * @return
	 */
	public Boolean getUpdateTimeExists(){
		for (GenTableColumn c : columnList){
			if ("update_time".equals(c.getColumnName())){
				return true;
			}
		}
		return false;
	}

	/**
	 * 是否存在status列
	 * @return
	 */
	public Boolean getStatusExists(){
		for (GenTableColumn c : columnList){
			if ("status".equals(c.getColumnName())){
				return true;
			}
		}
		return false;
	}

	public Boolean getReplaceFile() {
		if(replaceFile==null){
			return false;
		}
		return replaceFile;
	}
	
	public String getParentTableName() {
		return StringUtils.lowerCase(this.parentTable);
	}

}
