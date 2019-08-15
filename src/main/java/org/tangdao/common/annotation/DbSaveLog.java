package org.tangdao.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DbSaveLog {

   String logTitle() default "";

   //// 日志类型（access：接入日志；update：修改日志；select：查询日志；loginLogout：登录登出；）
   String logType() default "";
   
   String bizType() default "";
   
   String bizKey() default "";
   
   //设置为true后 不进行数据库保存
   boolean logIgnore() default false;
}
