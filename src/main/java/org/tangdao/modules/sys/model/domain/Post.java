package org.tangdao.modules.sys.model.domain;

import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 员工岗位表
 * </p>
 *
 * @author ruyang
 * @since 2019-08-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_post")
public class Post extends DataEntity<Post> {

    private static final long serialVersionUID = 1L;

    /**
     * 岗位编码
     */
    @TableId
    private String postCode;

    /**
     * 岗位名称
     */
    private String postName;

    /**
     * 岗位分类（高管、中层、基层）
     */
    private String postType;

    /**
     * 岗位排序（升序）
     */
    private Integer postSort;

}
