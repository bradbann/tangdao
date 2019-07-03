package org.tangdao.modules.sys.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
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
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色编码
     */
    @TableId
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色排序（升序）
     */
    private BigDecimal roleSort;

    /**
     * 数据范围设置（0未设置  1全部数据 2自定义数据）
     */
    private String dataScope;

    /**
     * 状态（0正常 1删除 2停用）
     */
    private String status;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 备注信息
     */
    private String remarks;


}
