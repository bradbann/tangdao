package org.tangdao.modules.sys.model.domain;

import javax.validation.constraints.NotNull;

import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author ruyang
 * @since 2019-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_role")
public class Role extends DataEntity<Role> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色编码
     */
    @TableId
    @NotNull(message="角色编码不能为空")
    private String roleCode;

    /**
     * 角色名称
     */
    @NotNull(message="角色名称不能为空")
    private String roleName;

    /**
     * 角色排序（升序）
     */
    @NotNull(message="角色排序不能为空")
    private Integer roleSort;

    /**
     * 数据范围设置（0未设置  1全部数据 2自定义数据）
     */
    private String dataScope;
    
}
