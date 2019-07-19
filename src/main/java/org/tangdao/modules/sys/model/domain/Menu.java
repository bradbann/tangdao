package org.tangdao.modules.sys.model.domain;

import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author ruyang
 * @since 2019-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_menu")
public class Menu extends DataEntity<Menu> {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单编码
     */
    @TableId
    private String menuCode;

    /**
     * 父级编号
     */
    private String parentCode;

    /**
     * 所有父级编号
     */
    private String parentCodes;

    /**
     * 本级排序号（升序）
     */
    private Integer treeSort;

    /**
     * 全节点名
     */
    private String treeNames;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单类型（1菜单 2权限 3开发）
     */
    private String menuType;

    /**
     * 链接
     */
    private String menuHref;

    /**
     * 目标
     */
    private String menuTarget;

    /**
     * 图标
     */
    private String menuIcon;

    /**
     * 权限标识
     */
    private String permission;

    /**
     * 菜单权重
     */
    private Integer weight;

    /**
     * 是否显示（1显示 0隐藏）
     */
    private String isShow;

}
