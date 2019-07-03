package org.tangdao.modules.sys.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 操作日志表
 * </p>
 *
 * @author ruyang
 * @since 2019-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_log")
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String id;

    /**
     * 日志类型
     */
    private String logType;

    /**
     * 日志标题
     */
    private String logTitle;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 用户名称
     */
    private String createByName;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 请求URI
     */
    private String requestUri;

    /**
     * 操作方式
     */
    private String requestMethod;

    /**
     * 操作提交的数据
     */
    private String requestParams;

    /**
     * 新旧数据比较结果
     */
    private String diffModifyData;

    /**
     * 业务主键
     */
    private String bizKey;

    /**
     * 业务类型
     */
    private String bizType;

    /**
     * 操作IP地址
     */
    private String remoteAddr;

    /**
     * 请求服务器地址
     */
    private String serverAddr;

    /**
     * 是否异常
     */
    private String isException;

    /**
     * 异常信息
     */
    private String exceptionInfo;

    /**
     * 用户代理
     */
    private String userAgent;

    /**
     * 设备名称/操作系统
     */
    private String deviceName;

    /**
     * 浏览器名称
     */
    private String browserName;

    /**
     * 执行时间
     */
    private BigDecimal executeTime;


}
