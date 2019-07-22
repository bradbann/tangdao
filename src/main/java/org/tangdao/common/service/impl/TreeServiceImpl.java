package org.tangdao.common.service.impl;

import java.util.List;
import java.util.Map;

import org.tangdao.common.exception.ServiceException;
import org.tangdao.common.service.ITreeService;
import org.tangdao.common.suports.TreeEntity;
import org.tangdao.common.utils.ListUtils;
import org.tangdao.common.utils.MapUtils;
import org.tangdao.common.utils.ReflectUtils;
import org.tangdao.common.utils.StringUtils;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

public class TreeServiceImpl<M extends BaseMapper<T>, T extends TreeEntity<T>> extends CrudServiceImpl<M, T> implements ITreeService<T> {

	@Override
	public void convertTreeSort(List<T> sourceList, List<T> targetList, String parentId) {
		sourceList.stream().filter(tree -> tree.getParentCode() != null && tree.getParentCode().equals(parentId))
				.forEach(tree -> {
					targetList.add(tree);
					// 判断是否还有子节点, 有则继续获取子节点
					sourceList.stream()
							.filter(child -> child.getParentCode() != null && child.getParentCode().equals(tree.getKey()))
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
			T parentEntity = null;
			if (StringUtils.isNotBlank(entity.getParentCode()) && !TreeEntity.ROOT_CODE.equals(entity.getParentCode())) {
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
			
			String oldParentIds = entity.getParentCodes();
			String oldTreeNames = entity.getTreeNames();
			
			entity.setParentCodes(parentEntity.getParentCodes() + parentEntity.getKey() + ",");
			
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
				this.save(entity);

			} else {
				this.updateById(entity);
			}
			
			List<T> list = this.select(Wrappers.<T>lambdaQuery().like(T::getParentCodes, treeId));
			for (T e : list) {
				if (e.getParentCodes() != null && oldParentIds != null) {
					e.setParentCodes(e.getParentCodes().replace(oldParentIds, entity.getParentCodes()));
					e.setTreeNames(e.getTreeNames().replace(oldTreeNames, entity.getTreeNames()));

					preUpdateChild(entity, e);
					this.updateById(e);
				}
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

    
}
