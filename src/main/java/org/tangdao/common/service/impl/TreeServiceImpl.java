package org.tangdao.common.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.tangdao.common.config.Global;
import org.tangdao.common.exception.ServiceException;
import org.tangdao.common.service.ITreeService;
import org.tangdao.common.suports.TreeEntity;
import org.tangdao.common.utils.ListUtils;
import org.tangdao.common.utils.MapUtils;
import org.tangdao.common.utils.ReflectUtils;
import org.tangdao.common.utils.StringUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;

public class TreeServiceImpl<M extends BaseMapper<T>, T extends TreeEntity<T>> extends CrudServiceImpl<M, T>
		implements ITreeService<T> {

	@Override
	public void convertTreeSort(List<T> sourceList, List<T> targetList, String parentId) {
		sourceList.stream().filter(tree -> tree.getParentCode() != null && tree.getParentCode().equals(parentId))
				.forEach(tree -> {
					targetList.add(tree);
					// 判断是否还有子节点, 有则继续获取子节点
					sourceList.stream().filter(
							child -> child.getParentCode() != null && child.getParentCode().equals(tree.getKey()))
							.peek(child -> convertTreeSort(targetList, sourceList, tree.getKey())).findFirst();
				});
	}

	@Override
	public void convertChildList(List<T> sourceList, List<T> targetList, String parentId) {

		// 构建一个Map,把所有原始数据的ID作为Key,原始数据对象作为VALUE
		Map<String, T> dtoMap = MapUtils.newLinkedHashMap();
		for (T tree : sourceList) {
			// 原始数据对象为Node，放入dtoMap中。
			tree.setChildren(null);
			dtoMap.put(tree.getKey(), tree);
		}

		for (Map.Entry<String, T> entry : dtoMap.entrySet()) {
			T node = entry.getValue();
			String tParentId = node.getParentCode();
			if (dtoMap.get(tParentId) == null) {
				// 如果是顶层节点，直接添加到结果集合中
				targetList.add(node);
			} else {
				// 如果不是顶层节点，有父节点，然后添加到父节点的子节点中
				T parent = dtoMap.get(tParentId);
				if (parent.getChildren() == null) {
					parent.setChildren(ListUtils.newArrayList());
				}
				parent.addChild(node);
			}
		}

	}

	@Override
	public boolean saveOrUpdate(T entity) {

		if (null != entity) {
			//旧的对象
			T oldEntity = this.get(entity.getKey());
			//新的父对象
			T parentEntity = null;
			if (StringUtils.isNotBlank(entity.getParentCode())
					&& !TreeEntity.ROOT_CODE.equals(entity.getParentCode())) {
				parentEntity = this.get(entity.getParentCode());
			}
			@SuppressWarnings("unchecked")
			Class<T> entityClass = ReflectUtils.getClassGenricType(getClass(), 1);
			if (parentEntity == null || StringUtils.isBlank(entity.getParentCode())
					|| TreeEntity.ROOT_CODE.equals(entity.getParentCode())) {
				try {
					// 构造一个父节点
					parentEntity = entityClass.getConstructor(String.class).newInstance(TreeEntity.ROOT_CODE);
				} catch (Exception e) {
					throw new ServiceException("初始化父类对象", e);
				}
				parentEntity.setParentCodes(StringUtils.EMPTY);
				parentEntity.setTreeNames(StringUtils.EMPTY);

				// 设置保存对象的父节点
				entity.setParentCode(parentEntity.getKey());
			}
			entity.setParent(parentEntity);

			String oldParentCodes = entity.getParentCodes();
			String oldTreeNames = entity.getTreeNames();

			entity.setParentCodes(parentEntity.getParentCodes() + parentEntity.getKey() + ",");
			entity.setTreeLevel(entity.getParentCodes().replaceAll("[^,]", "").length() - 1);

			String treeId = entity.getKey();
			String treeName = entity.getTreeName_();

			if (treeName == null) {
				treeName = StringUtils.EMPTY;
			}

			if (entity.isRoot()) {
				entity.setTreeNames(treeName);
			} else {
				entity.setTreeNames(parentEntity.getTreeNames() + "/" + treeName);
			}

			if (StringUtils.isBlank(treeId)) {
				// 排序处理
				if (entity.getTreeSort() == null) {
					entity.setTreeSort(T.DEFAULT_TREE_SORT);
				}
				entity.setTreeLeaf(Global.YES);
				this.save(entity);
			} else {
				this.updateById(entity);
			}
			QueryWrapper<T> queryWrapper = new QueryWrapper<T>();
			queryWrapper.like("parent_codes", entity.getKey());
			List<T> list = this.select(queryWrapper);
			for (T e : list) {
				if (e.getParentCodes() != null && oldParentCodes != null) {
					e.setParentCodes(e.getParentCodes().replace(oldParentCodes, entity.getParentCodes()));
					e.setTreeNames(e.getTreeNames().replace(oldTreeNames, entity.getTreeNames()));
					e.setTreeLevel(e.getParentCodes().replaceAll("[^,]", "").length() - 1);
					preUpdateChild(entity, e);
					this.updateById(e);
				}
			}
			// 更新原始父节点的对象
			if (oldEntity != null && oldEntity.getParentCode()!=null&&!TreeEntity.ROOT_CODE.equals(oldEntity.getParentCode())) {
				try {
					// 构造一个父节点
					parentEntity = entityClass.getConstructor(String.class).newInstance(TreeEntity.ROOT_CODE);
				} catch (Exception e) {
					throw new ServiceException("初始化父类对象", e);
				}
				parentEntity.setKey(oldEntity.getParentCode());
				this.updateTreeLeaf(parentEntity);
			}
			if (entity != null && entity.getParent() != null && !StringUtils.equals(entity.getParentCode(),  oldEntity.getParentCode())) {
				this.updateTreeLeaf(entity.getParent());
			}

			return true;
		}
		return false;

	}

	/**
	 * 预留接口，用户更新子节前调用
	 * 
	 * @param childEntity
	 */
	protected void preUpdateChild(T entity, T childEntity) {

	}

	@Transactional(readOnly = false, isolation = Isolation.READ_UNCOMMITTED)
	public void updateTreeLeaf(T entity) {
		if (TreeEntity.ROOT_CODE.equals(entity.getKey())) {
			return;
		}
		TableInfo tableInfo = TableInfoHelper.getTableInfo(entity.getClass());
		StringBuffer sql = new StringBuffer();
		sql.append(" tree_leaf = (");
		sql.append(" select tree_leaf from(");
		sql.append(" SELECT (case when count(1) > 0 then '0' else '1' end) tree_leaf");
		sql.append(" from " + tableInfo.getTableName());
		sql.append(" where status='0'").append(" and parent_code = '").append(entity.getKey()).append("'");
		sql.append(" ) a )");
		UpdateWrapper<T> updateWrapper = new UpdateWrapper<T>();
		updateWrapper.setSql(sql.toString());
		updateWrapper.eq(tableInfo.getKeyColumn(), entity.getKey());
		this.update(updateWrapper);
	}
	
	public void delete(T entity) {
	}

}
