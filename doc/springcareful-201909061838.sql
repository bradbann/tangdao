-- MySQL dump 10.16  Distrib 10.3.9-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: springcareful
-- ------------------------------------------------------
-- Server version	5.6.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `gen_table`
--

DROP TABLE IF EXISTS `gen_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gen_table` (
  `table_name` varchar(200) NOT NULL DEFAULT '' COMMENT '名称',
  `comments` varchar(500) DEFAULT NULL COMMENT '描述',
  `class_name` varchar(100) DEFAULT NULL COMMENT '实体类名称',
  `parent_table` varchar(200) DEFAULT NULL COMMENT '关联父表',
  `parent_table_fk` varchar(100) DEFAULT NULL COMMENT '关联父表外键',
  `tpl_category` varchar(2000) DEFAULT NULL COMMENT '分类',
  `package_name` varchar(500) DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) DEFAULT NULL COMMENT '生成模块名',
  `sub_module_name` varchar(30) DEFAULT NULL COMMENT '生成子模块名',
  `function_name` varchar(500) DEFAULT NULL COMMENT '生成功能名',
  `function_name_simple` varchar(100) DEFAULT NULL COMMENT '生成功能名（简写）',
  `function_author` varchar(100) DEFAULT NULL COMMENT '生成功能作者',
  `gen_base_dir` varchar(100) DEFAULT NULL COMMENT '生成基础路径',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  `options` varchar(1000) DEFAULT NULL COMMENT '其它生成选项',
  PRIMARY KEY (`table_name`),
  KEY `gen_table_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代码生成表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gen_table`
--

LOCK TABLES `gen_table` WRITE;
/*!40000 ALTER TABLE `gen_table` DISABLE KEYS */;
INSERT INTO `gen_table` VALUES ('paas_area_local','号码归属地','AreaLocal',NULL,NULL,'crud','org.tangdao.modules','paas',NULL,'号码归属地','号码归属地','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 16:51:12','system','2019-09-06 16:51:18','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\"}'),('paas_passage_template','通道模板','PaasPassageTemplate',NULL,NULL,'crud','org.tangdao.modules','paas',NULL,'通道模板','通道模板','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:12:07','system','2019-09-06 11:12:13','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\"}'),('paas_passage_template_detail','通道模板内容','PaasPassageTemplateDetail',NULL,NULL,'crud','org.tangdao.modules','paas',NULL,'通道模板内容','通道模板内容','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:12:30','system','2019-09-06 11:12:34','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\"}'),('paas_push_config','推送配置信息表','PushConfig',NULL,NULL,'crud','org.tangdao.modules','paas',NULL,'推送配置信息表','推送配置信息表','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 16:38:10','system','2019-09-06 16:38:22','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"0\",\"isImageUpload\":\"0\"}'),('paas_user_balance_log','用户余额日志','PaasUserBalanceLog',NULL,NULL,'crud','org.tangdao.modules','paas',NULL,'用户余额日志','用户余额日志','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:12:58','system','2019-09-06 11:13:03','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\"}'),('paas_user_passage','用户通道配置','PaasUserPassage',NULL,NULL,'crud','org.tangdao.modules','paas',NULL,'用户通道配置','用户通道配置','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:13:31','system','2019-09-06 11:13:36','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\"}'),('paas_user_sms_config','用户短信配置表','UserSmsConfig',NULL,NULL,'service','org.tangdao.modules','paas',NULL,'用户短信配置','用户短信配置','ruyang','D:\\mywork\\springcareful','0','system','2019-09-05 15:45:53','system','2019-09-05 15:50:20','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"0\",\"isImageUpload\":\"0\"}'),('sms_api_failed_record','下行失败短信','SmsApiFailedRecord',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'下行失败短信','下行失败短信','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 10:46:36','system','2019-09-06 10:47:03','','{\"treeViewName\":\"\",\"isHaveDelete\":\"0\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"0\",\"isImageUpload\":\"0\"}'),('sms_forbidden_words','告警敏感词','SmsForbiddenWords',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'告警敏感词','告警敏感词','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 10:48:47','system','2019-09-06 10:49:11','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\"}'),('sms_message_deliver','回执推送信息','SmsMessageDeliver',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'回执推送信息','回执推送信息','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:15:20','system','2019-09-06 11:15:24','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\"}'),('sms_message_deliver_log','下行短信回执日志','SmsMessageDeliverLog',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'下行短信回执日志','下行短信回执日志','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 10:50:26','system','2019-09-06 10:50:37','','{\"treeViewName\":\"\",\"isHaveDelete\":\"0\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"0\",\"isImageUpload\":\"0\"}'),('sms_message_template','消息模板','SmsMessageTemplate',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'消息模板','消息模板','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 10:51:10','system','2019-09-06 10:51:25','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\"}'),('sms_mobile_blacklist','手机黑名单信息表','SmsMobileBlacklist',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'手机黑名单信息表','手机黑名单信息表','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:00:35','system','2019-09-06 11:01:04','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\"}'),('sms_mobile_whitelist','手机白名单信息表','SmsMobileWhitelist',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'手机白名单信息表','手机白名单信息表','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:01:19','system','2019-09-06 11:01:24','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"0\",\"isImageUpload\":\"0\"}'),('sms_mo_message_push','上行消息推送','SmsMoMessagePush',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'上行消息推送','上行消息推送','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 10:52:39','system','2019-09-06 10:52:48','','{\"treeViewName\":\"\",\"isHaveDelete\":\"0\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"0\",\"isImageUpload\":\"0\"}'),('sms_mo_message_receive','上行消息回复','SmsMoMessageReceive',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'上行消息回复','上行消息回复','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 10:59:39','system','2019-09-06 10:59:47','','{\"treeViewName\":\"\",\"isHaveDelete\":\"0\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"0\",\"isImageUpload\":\"0\"}'),('sms_msg_deliver','回执推送信息','SmsMsgDeliver',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'回执推送信息','回执推送信息','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:01:54','system','2019-09-06 11:02:00','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"0\",\"isImageUpload\":\"0\"}'),('sms_mt_manual_handling','下行短信创建','SmsMtManualHandling',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'下行短信创建','下行短信创建','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:02:19','system','2019-09-06 11:02:33','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\"}'),('sms_mt_message_deliver','下行短信回执状态','SmsMtMessageDeliver',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'下行短信回执状态','下行短信回执状态','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:02:49','system','2019-09-06 11:02:53','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"0\",\"isImageUpload\":\"0\"}'),('sms_mt_message_deliver_log','下行短信回执状态日志','SmsMtMessageDeliverLog',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'下行短信回执状态日志','下行短信回执状态日志','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:03:12','system','2019-09-06 11:03:25','','{\"treeViewName\":\"\",\"isHaveDelete\":\"0\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"0\",\"isImageUpload\":\"0\"}'),('sms_mt_message_push','下行短信推送','SmsMtMessagePush',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'下行短信推送','下行短信推送','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:03:43','system','2019-09-06 11:03:52','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\"}'),('sms_mt_message_submit','下行短信提交','SmsMtMessageSubmit',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'下行短信提交','下行短信提交','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:04:10','system','2019-09-06 11:04:19','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"0\",\"isImageUpload\":\"0\"}'),('sms_mt_process_failed','下行短信处理失败','SmsMtProcessFailed',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'下行短信处理失败','下行短信处理失败','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:04:36','system','2019-09-06 11:04:39','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"0\",\"isImageUpload\":\"0\"}'),('sms_mt_task','下行短信任务','SmsMtTask',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'下行短信任务','下行短信任务','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\"}'),('sms_mt_task_packets','下行短信任务分包','SmsMtTaskPackets',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'下行短信任务分包','下行短信任务分包','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\"}'),('sms_passage','通道管理','SmsPassage',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'通道管理','通道管理','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\"}'),('sms_passage_access','通道资产','SmsPassageAccess',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'通道资产','通道资产','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\"}'),('sms_passage_change_log','通道变更日志','SmsPassageChangeLog',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'通道变更日志','通道变更日志','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:06:44','system','2019-09-06 11:06:51','','{\"treeViewName\":\"\",\"isHaveDelete\":\"0\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"0\",\"isImageUpload\":\"0\"}'),('sms_passage_control','通道控制','SmsPassageControl',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'通道控制','通道控制','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:07:10','system','2019-09-06 11:07:17','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\"}'),('sms_passage_group','通道组','SmsPassageGroup',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'通道组','通道组','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:07:35','system','2019-09-06 11:07:42','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\"}'),('sms_passage_group_detail','通道组内容','SmsPassageGroupDetail',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'通道组内容','通道组内容','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:08:00','system','2019-09-06 11:08:05','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\"}'),('sms_passage_message_template','通道消息模板','SmsPassageMessageTemplate',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'通道消息模板','通道消息模板','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:08:22','system','2019-09-06 11:08:32','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\"}'),('sms_passage_parameter','通道消息模板参数','SmsPassageParameter',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'通道消息模板参数','通道消息模板参数','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:08:47','system','2019-09-06 11:08:52','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\"}'),('sms_passage_province','通道支持省份','SmsPassageProvince',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'通道支持省份','通道支持省份','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:09:08','system','2019-09-06 11:09:12','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"0\",\"isImageUpload\":\"0\"}'),('sms_passage_reachrate_settings','通道重连配置','SmsPassageReachrateSettings',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'通道重连配置','通道重连配置','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:09:31','system','2019-09-06 11:09:38','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\"}'),('sms_priority_words','优先级词库配置','SmsPriorityWords',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'优先级词库配置','优先级词库配置','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:09:53','system','2019-09-06 11:09:59','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\"}'),('sms_provider','短信接口提供商','SmsProvider',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'短信接口提供商','短信接口提供商','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:10:14','system','2019-09-06 11:10:19','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\"}'),('sms_signature_extno','签名扩展','SmsSignatureExtno',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'签名扩展','签名扩展','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:10:34','system','2019-09-06 11:10:39','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\"}'),('sms_submit_hour_report','提交报告（小时）','SmsSubmitHourReport',NULL,NULL,'crud','org.tangdao.modules','sms',NULL,'提交报告（小时）','提交报告（小时）','ruyang','D:\\mywork\\springcareful','0','system','2019-09-06 11:10:55','system','2019-09-06 11:11:02','','{\"treeViewName\":\"\",\"isHaveDelete\":\"1\",\"treeViewCode\":\"\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\"}'),('sys_company','公司表','Company',NULL,NULL,'treeGrid','org.tangdao.modules','sys','','公司','公司','ruyang','D:\\mywork\\springcareful','0','system','2019-08-22 17:39:22','system','2019-08-28 08:58:42','','{\"isHaveDelete\":\"1\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\",\"treeViewCode\":\"company_code\",\"treeViewName\":\"company_name\"}'),('sys_office','组织机构表','SysOffice',NULL,NULL,'','org.tangdao.modules','sys','','组织机构表','组织机构表','ruyang','D:\\mywork\\springcareful','0','system','2019-08-22 18:59:03','system','2019-08-22 18:59:03','','{\"isHaveDelete\":\"1\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"0\",\"isImageUpload\":\"0\"}'),('sys_post','员工岗位表','Post',NULL,NULL,'crud','org.tangdao.modules','sys','','岗位','岗位','ruyang','D:\\mywork\\springcareful','0','system','2019-08-22 16:49:08','system','2019-08-23 18:35:12','','{\"isHaveDelete\":\"1\",\"isFileUpload\":\"0\",\"isHaveDisableEnable\":\"1\",\"isImageUpload\":\"0\",\"treeViewCode\":\"\",\"treeViewName\":\"\"}');
/*!40000 ALTER TABLE `gen_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gen_table_column`
--

DROP TABLE IF EXISTS `gen_table_column`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gen_table_column` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `table_name` varchar(64) DEFAULT NULL COMMENT '归属表',
  `column_name` varchar(200) DEFAULT NULL COMMENT '名称',
  `column_sort` decimal(10,0) DEFAULT NULL COMMENT '排序（升序）',
  `comments` varchar(500) DEFAULT NULL COMMENT '描述',
  `jdbc_type` varchar(100) DEFAULT NULL COMMENT '列的数据类型的字节长度',
  `java_type` varchar(500) DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) DEFAULT NULL COMMENT '是否主键',
  `is_null` char(1) DEFAULT NULL COMMENT '是否可为空',
  `is_insert` char(1) DEFAULT NULL COMMENT '是否为插入字段',
  `is_edit` char(1) DEFAULT NULL COMMENT '是否编辑字段',
  `is_list` char(1) DEFAULT NULL COMMENT '是否列表字段',
  `is_query` char(1) DEFAULT NULL COMMENT '是否查询字段',
  `query_type` varchar(200) DEFAULT NULL COMMENT '查询方式（等于、不等于、大于、小于、范围、左LIKE、右LIKE、左右LIKE）',
  `show_type` varchar(200) DEFAULT NULL COMMENT '字段生成方案（文本框、文本域、下拉框、复选框、单选框、字典选择、人员选择、部门选择、区域选择）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  `is_update` char(1) DEFAULT NULL COMMENT '是否更新字段',
  `options` varchar(1000) DEFAULT NULL COMMENT '其它生成选项',
  PRIMARY KEY (`id`),
  KEY `gen_table_column_status` (`status`),
  KEY `gen_table_column_name` (`column_name`),
  KEY `gen_table_column_sort` (`column_sort`),
  KEY `gen_table_column_table_id` (`table_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='业务表字段';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gen_table_column`
--

LOCK TABLES `gen_table_column` WRITE;
/*!40000 ALTER TABLE `gen_table_column` DISABLE KEYS */;
INSERT INTO `gen_table_column` VALUES ('1164459474214535170','sys_post','post_code',10,'岗位编码','varchar(64)','String','postCode','1','1','1','1','','','EQ','input','0','system','2019-08-22 16:49:08','system','2019-08-23 18:35:12',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164459474344558594','sys_post','post_name',20,'岗位名称','varchar(100)','String','postName','','1','1','1','1','1','EQ','input','0','system','2019-08-22 16:49:08','system','2019-08-23 18:35:12',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164459474411667458','sys_post','post_type',30,'岗位分类','char(1)','String','postType','','1','1','1','1','1','EQ','select','0','system','2019-08-22 16:49:08','system','2019-08-23 18:35:12',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_post_type\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_post_type\"}'),('1164459474411667459','sys_post','post_sort',40,'岗位排序','decimal(10,0)','Integer','postSort','','1','1','1','1','','EQ','input','0','system','2019-08-22 16:49:08','system','2019-08-23 18:35:12',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164459474411667460','sys_post','status',50,'状态','char(1)','String','status','','','1','','1','1','EQ','select','0','system','2019-08-22 16:49:08','system','2019-08-23 18:35:12',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_search_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_search_status\"}'),('1164459474474582017','sys_post','create_by',60,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-08-22 16:49:08','system','2019-08-23 18:35:12',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164459474541690881','sys_post','create_time',70,'创建时间','datetime','java.util.Date','createTime','','','1','','','','EQ','datetime','0','system','2019-08-22 16:49:08','system','2019-08-23 18:35:12',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164459474541690882','sys_post','update_by',80,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-08-22 16:49:08','system','2019-08-23 18:35:12',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164459474608799745','sys_post','update_time',90,'更新时间','datetime','java.util.Date','updateTime','','','1','','1','','EQ','datetime','0','system','2019-08-22 16:49:08','system','2019-08-23 18:35:12',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164459474608799746','sys_post','remarks',100,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-08-22 16:49:08','system','2019-08-23 18:35:12',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1164472115192496129','sys_company','company_code',70,'公司编码','varchar(64)','String','companyCode','1','1','1','1','','','EQ','input','0','system','2019-08-22 17:39:22','system','2019-08-28 08:58:42',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164472115259604994','sys_company','parent_code',10,'父级编号','varchar(64)','This','parentCode','','1','1','','','','EQ','input','0','system','2019-08-22 17:39:22','system','2019-08-28 08:58:42',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164472115326713857','sys_company','parent_codes',20,'所有父级编号','varchar(1000)','String','parentCodes','','1','1','','','','EQ','input','0','system','2019-08-22 17:39:22','system','2019-08-28 08:58:42',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164472115326713858','sys_company','tree_sort',90,'排序号','decimal(10,0)','Integer','treeSort','','1','1','1','1','','EQ','input','0','system','2019-08-22 17:39:22','system','2019-08-28 08:58:42',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"digits\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164472115326713859','sys_company','tree_names',30,'全节点名','varchar(1000)','String','treeNames','','1','1','','','','EQ','input','0','system','2019-08-22 17:39:22','system','2019-08-28 08:58:42',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164472115389628417','sys_company','tree_leaf',40,'是否最末级','char(1)','String','treeLeaf','','','1','','','','EQ','input','0','system','2019-08-22 17:39:22','system','2019-08-28 08:58:42',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164472115389628418','sys_company','tree_level',50,'层次级别','char(1)','String','treeLevel','','','1','','','','EQ','input','0','system','2019-08-22 17:39:22','system','2019-08-28 08:58:42',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"digits\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164472115389628419','sys_company','view_code',100,'公司代码','varchar(100)','String','viewCode','','','1','1','1','1','EQ','input','0','system','2019-08-22 17:39:22','system','2019-08-28 08:58:42',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164472115456737282','sys_company','company_name',60,'公司名称','varchar(200)','String','companyName','','1','1','1','1','1','EQ','input','0','system','2019-08-22 17:39:22','system','2019-08-28 08:58:42',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164472115456737283','sys_company','full_name',80,'公司全称','varchar(200)','String','fullName','','1','1','1','1','','EQ','input','0','system','2019-08-22 17:39:22','system','2019-08-28 08:58:42',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164472115456737284','sys_company','area_code',110,'区域编码','varchar(100)','String','areaCode','','','1','1','1','','EQ','input','0','system','2019-08-22 17:39:22','system','2019-08-28 08:58:42',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164472115523846145','sys_company','status',120,'状态','char(1)','String','status','','','1','','1','1','EQ','select','0','system','2019-08-22 17:39:22','system','2019-08-28 08:58:42',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_search_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_search_status\"}'),('1164472115523846146','sys_company','create_by',130,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-08-22 17:39:22','system','2019-08-28 08:58:42',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164472115586760706','sys_company','create_time',140,'创建时间','datetime','java.util.Date','createTime','','','1','','','','EQ','datetime','0','system','2019-08-22 17:39:22','system','2019-08-28 08:58:42',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164472115586760707','sys_company','update_by',150,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-08-22 17:39:22','system','2019-08-28 08:58:42',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164472115586760708','sys_company','update_time',160,'更新时间','datetime','java.util.Date','updateTime','','','1','','1','','EQ','datetime','0','system','2019-08-22 17:39:22','system','2019-08-28 08:58:42',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164472115653869570','sys_company','remarks',170,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-08-22 17:39:22','system','2019-08-28 08:58:42',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1164492167996309505','sys_office','office_code',10,'机构编码','varchar(64)','String','officeCode','1','1','1','1','','','EQ','input','0','system','2019-08-22 18:59:03','system','2019-08-22 18:59:03',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164492168126332929','sys_office','parent_code',20,'父级编号','varchar(64)','This','parentCode','','1','1','','','1','EQ','input','0','system','2019-08-22 18:59:03','system','2019-08-22 18:59:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164492168126332930','sys_office','parent_codes',30,'所有父级编号','varchar(1000)','String','parentCodes','','1','1','','','1','EQ','input','0','system','2019-08-22 18:59:03','system','2019-08-22 18:59:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164492168189247489','sys_office','tree_sort',40,'本级排序号（升序）','decimal(10,0)','Integer','treeSort','','1','1','1','1','','EQ','input','0','system','2019-08-22 18:59:03','system','2019-08-22 18:59:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"digits\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164492168189247490','sys_office','tree_names',50,'全节点名','varchar(1000)','String','treeNames','','1','1','','','1','EQ','input','0','system','2019-08-22 18:59:03','system','2019-08-22 18:59:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164492168256356353','sys_office','tree_leaf',60,'是否最末级','char(1)','String','treeLeaf','','','1','','','','EQ','input','0','system','2019-08-22 18:59:03','system','2019-08-22 18:59:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164492168256356354','sys_office','tree_level',70,'层次级别','char(1)','String','treeLevel','','','1','','','','EQ','input','0','system','2019-08-22 18:59:03','system','2019-08-22 18:59:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"digits\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164492168323465217','sys_office','view_code',80,'机构代码','varchar(100)','String','viewCode','','1','1','1','1','','EQ','input','0','system','2019-08-22 18:59:03','system','2019-08-22 18:59:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164492168386379778','sys_office','office_name',90,'机构名称','varchar(100)','String','officeName','','1','1','1','1','','EQ','input','0','system','2019-08-22 18:59:03','system','2019-08-22 18:59:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164492168386379779','sys_office','full_name',100,'机构全称','varchar(200)','String','fullName','','1','1','1','1','','EQ','input','0','system','2019-08-22 18:59:03','system','2019-08-22 18:59:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164492168386379780','sys_office','office_type',110,'机构类型','char(1)','String','officeType','','1','1','1','1','','EQ','input','0','system','2019-08-22 18:59:03','system','2019-08-22 18:59:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164492168386379781','sys_office','leader',120,'负责人','varchar(100)','String','leader','','','1','1','1','','EQ','input','0','system','2019-08-22 18:59:03','system','2019-08-22 18:59:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164492168453488641','sys_office','phone',130,'办公电话','varchar(100)','String','phone','','','1','1','1','','EQ','input','0','system','2019-08-22 18:59:03','system','2019-08-22 18:59:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164492168453488642','sys_office','address',140,'联系地址','varchar(255)','String','address','','','1','1','1','','EQ','input','0','system','2019-08-22 18:59:03','system','2019-08-22 18:59:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164492168520597505','sys_office','zip_code',150,'邮政编码','varchar(100)','String','zipCode','','','1','1','1','','EQ','input','0','system','2019-08-22 18:59:03','system','2019-08-22 18:59:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164492168520597506','sys_office','email',160,'电子邮箱','varchar(300)','String','email','','','1','1','1','','EQ','input','0','system','2019-08-22 18:59:03','system','2019-08-22 18:59:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164492168520597507','sys_office','status',170,'状态（0正常 1删除 2停用）','char(1)','String','status','','','1','','1','1','EQ','radio','0','system','2019-08-22 18:59:03','system','2019-08-22 18:59:03',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1164492168650620929','sys_office','create_by',180,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-08-22 18:59:03','system','2019-08-22 18:59:03',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164492168650620930','sys_office','create_time',190,'创建时间','datetime','java.util.Date','createTime','','','1','','','','EQ','datetime','0','system','2019-08-22 18:59:03','system','2019-08-22 18:59:03',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164492168713535489','sys_office','update_by',200,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-08-22 18:59:03','system','2019-08-22 18:59:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164492168780644353','sys_office','update_time',210,'更新时间','datetime','java.util.Date','updateTime','','','1','','1','','EQ','datetime','0','system','2019-08-22 18:59:03','system','2019-08-22 18:59:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1164492168780644354','sys_office','remarks',220,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-08-22 18:59:03','system','2019-08-22 18:59:03',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169516985607000065','paas_user_sms_config','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-05 15:45:53','system','2019-09-05 15:50:20',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169516985690886145','paas_user_sms_config','user_code',20,'用户ID','varchar(64)','String','userCode','','1','1','1','1','','EQ','input','0','system','2019-09-05 15:45:53','system','2019-09-05 15:50:20',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169516985716051970','paas_user_sms_config','sms_words',30,'每条计费字数','int(4)','String','smsWords','','1','1','1','1','','EQ','input','0','system','2019-09-05 15:45:53','system','2019-09-05 15:50:20',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169516985737023490','paas_user_sms_config','sms_return_rule',40,'短信返还规则，0:不返还，1：失败自动返还，2：超时未回执返还；','int(4)','String','smsReturnRule','','','1','1','1','','EQ','input','0','system','2019-09-05 15:45:53','system','2019-09-05 15:50:20',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169516985762189314','paas_user_sms_config','sms_timeout',50,'短信超时时间（毫秒）','bigint(20)','Long','smsTimeout','','','1','1','1','','EQ','input','0','system','2019-09-05 15:45:53','system','2019-09-05 15:50:20',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169516985774772225','paas_user_sms_config','message_pass',60,'短信内容免审核，1：需要审核，0：不需要','tinyint(1)','String','messagePass','','','1','1','1','','EQ','input','0','system','2019-09-05 15:45:53','system','2019-09-05 15:50:20',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169516985799938050','paas_user_sms_config','need_template',70,'是否需要报备模板，1：需要，0：不需要','tinyint(1)','String','needTemplate','','','1','1','1','','EQ','input','0','system','2019-09-05 15:45:53','system','2019-09-05 15:50:20',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169516985837686785','paas_user_sms_config','auto_template',80,'自动提取短信模板,0-不提取，1-提取','tinyint(1)','String','autoTemplate','','','1','1','1','','EQ','input','0','system','2019-09-05 15:45:53','system','2019-09-05 15:50:20',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169516985854464001','paas_user_sms_config','signature_source',90,'签名途径，0：自维护，1：系统强制','int(4)','String','signatureSource','','1','1','1','1','','EQ','input','0','system','2019-09-05 15:45:53','system','2019-09-05 15:50:20',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169516985854464002','paas_user_sms_config','signature_content',100,'签名内容','varchar(64)','String','signatureContent','','','1','1','1','','EQ','input','0','system','2019-09-05 15:45:53','system','2019-09-05 15:50:20',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169516985854464003','paas_user_sms_config','ext_number',110,'扩展号码','varchar(32)','String','extNumber','','','1','1','1','','EQ','input','0','system','2019-09-05 15:45:53','system','2019-09-05 15:50:20',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169516985854464004','paas_user_sms_config','submit_interval',120,'短信提交时间间隔（同一号码）','int(8)','String','submitInterval','','','1','1','1','','EQ','input','0','system','2019-09-05 15:45:53','system','2019-09-05 15:50:20',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169516986286477313','paas_user_sms_config','limit_times',130,'短信每天提交次数上限（同一号码）','int(8)','String','limitTimes','','','1','1','1','','EQ','input','0','system','2019-09-05 15:45:53','system','2019-09-05 15:50:20',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169516986311643137','paas_user_sms_config','status',140,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-05 15:45:53','system','2019-09-05 15:50:20',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169516986345197570','paas_user_sms_config','create_by',150,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-05 15:45:53','system','2019-09-05 15:50:20',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169516986361974785','paas_user_sms_config','create_time',160,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-05 15:45:53','system','2019-09-05 15:50:20',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169516986361974786','paas_user_sms_config','update_by',170,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-05 15:45:53','system','2019-09-05 15:50:20',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169516986399723521','paas_user_sms_config','update_time',180,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-05 15:45:53','system','2019-09-05 15:50:21',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169516986450055169','paas_user_sms_config','remarks',190,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-05 15:45:53','system','2019-09-05 15:50:21',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169516986559107074','paas_user_sms_config','user_developer_id',200,'user_developer_id','varchar(100)','String','userDeveloperId','','','1','1','1','','EQ','input','0','system','2019-09-05 15:45:53','system','2019-09-05 15:50:21',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804059098755074','sms_api_failed_record','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 10:46:36','system','2019-09-06 10:47:03',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804059195224065','sms_api_failed_record','user_code',20,'用户编码','varchar(64)','String','userCode','','1','1','1','1','','EQ','input','0','system','2019-09-06 10:46:36','system','2019-09-06 10:47:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804059388162050','sms_api_failed_record','app_type',30,'调用类型','tinyint(2) unsigned','String','appType','','','1','1','1','','EQ','input','0','system','2019-09-06 10:46:36','system','2019-09-06 10:47:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804059459465217','sms_api_failed_record','submit_type',40,'请求类型','tinyint(2)','String','submitType','','','1','1','1','','EQ','input','0','system','2019-09-06 10:46:36','system','2019-09-06 10:47:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804059505602561','sms_api_failed_record','app_key',50,'接口账号','varchar(45)','String','appKey','','','1','1','1','','EQ','input','0','system','2019-09-06 10:46:36','system','2019-09-06 10:47:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804059551739905','sms_api_failed_record','app_secret',60,'接口密码','varchar(45)','String','appSecret','','','1','1','1','','EQ','input','0','system','2019-09-06 10:46:36','system','2019-09-06 10:47:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804059576905730','sms_api_failed_record','mobile',70,'手机号','varchar(6144)','String','mobile','','','1','1','1','','EQ','input','0','system','2019-09-06 10:46:36','system','2019-09-06 10:47:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804059602071554','sms_api_failed_record','timestamps',80,'提交时间戳','varchar(45)','String','timestamps','','','1','1','1','','EQ','input','0','system','2019-09-06 10:46:36','system','2019-09-06 10:47:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804059618848769','sms_api_failed_record','content',90,'content','varchar(2048)','String','content','','','1','1','1','','EQ','textarea','0','system','2019-09-06 10:46:36','system','2019-09-06 10:47:03',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169804059618848770','sms_api_failed_record','ext_number',100,'拓展号码','varchar(20)','String','extNumber','','','1','1','1','','EQ','input','0','system','2019-09-06 10:46:36','system','2019-09-06 10:47:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804059618848771','sms_api_failed_record','attach',110,'自定义内容','varchar(64)','String','attach','','','1','1','1','','EQ','input','0','system','2019-09-06 10:46:36','system','2019-09-06 10:47:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804059618848772','sms_api_failed_record','callback',120,'回调URL','varchar(256)','String','callback','','','1','1','1','','EQ','input','0','system','2019-09-06 10:46:36','system','2019-09-06 10:47:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804059719512066','sms_api_failed_record','submit_url',130,'程序调用URL','varchar(256)','String','submitUrl','','1','1','1','1','','EQ','input','0','system','2019-09-06 10:46:36','system','2019-09-06 10:47:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804059757260802','sms_api_failed_record','ip',140,'提交IP','varchar(45)','String','ip','','','1','1','1','','EQ','input','0','system','2019-09-06 10:46:36','system','2019-09-06 10:47:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804059769843713','sms_api_failed_record','resp_code',150,'错误码','varchar(2048)','String','respCode','','1','1','1','1','','EQ','input','0','system','2019-09-06 10:46:36','system','2019-09-06 10:47:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804059769843714','sms_api_failed_record','status',160,'状态','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 10:46:36','system','2019-09-06 10:47:03',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169804059769843715','sms_api_failed_record','create_by',170,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 10:46:36','system','2019-09-06 10:47:03',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804059946004482','sms_api_failed_record','create_time',180,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 10:46:36','system','2019-09-06 10:47:03',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804059962781698','sms_api_failed_record','update_by',190,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 10:46:36','system','2019-09-06 10:47:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804059962781699','sms_api_failed_record','update_time',200,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 10:46:36','system','2019-09-06 10:47:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804059962781700','sms_api_failed_record','remarks',210,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 10:46:36','system','2019-09-06 10:47:03',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169804605738201090','sms_forbidden_words','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 10:48:47','system','2019-09-06 10:49:11',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804605738201091','sms_forbidden_words','word',20,'敏感词','varchar(64)','String','word','','1','1','1','1','','EQ','input','0','system','2019-09-06 10:48:47','system','2019-09-06 10:49:11',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804605864030210','sms_forbidden_words','level',30,'告警级别，区分颜色','int(2)','String','level','','','1','1','1','','EQ','input','0','system','2019-09-06 10:48:47','system','2019-09-06 10:49:12',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804605864030211','sms_forbidden_words','label',40,'标签','varchar(32)','String','label','','','1','1','1','','EQ','input','0','system','2019-09-06 10:48:47','system','2019-09-06 10:49:12',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804605864030212','sms_forbidden_words','status',50,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 10:48:47','system','2019-09-06 10:49:12',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169804605864030213','sms_forbidden_words','create_by',60,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 10:48:47','system','2019-09-06 10:49:12',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804605981470722','sms_forbidden_words','create_time',70,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 10:48:47','system','2019-09-06 10:49:12',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804606006636545','sms_forbidden_words','update_by',80,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 10:48:47','system','2019-09-06 10:49:12',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804606019219458','sms_forbidden_words','update_time',90,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 10:48:47','system','2019-09-06 10:49:12',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169804606027608066','sms_forbidden_words','remarks',100,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 10:48:47','system','2019-09-06 10:49:12',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169805024552038402','sms_message_deliver_log','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 10:50:26','system','2019-09-06 10:50:37',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805024552038403','sms_message_deliver_log','passage_code',20,'通道简码','varchar(32)','String','passageCode','','','1','1','1','','EQ','input','0','system','2019-09-06 10:50:26','system','2019-09-06 10:50:37',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805024552038404','sms_message_deliver_log','msg_id',30,'消息ID','varchar(64)','String','msgId','','1','1','1','1','','EQ','input','0','system','2019-09-06 10:50:26','system','2019-09-06 10:50:37',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805024744976386','sms_message_deliver_log','status_code',40,'状态码','varchar(64)','String','statusCode','','1','1','1','1','','EQ','input','0','system','2019-09-06 10:50:26','system','2019-09-06 10:50:37',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805024744976387','sms_message_deliver_log','deliver_time',50,'短信提供商回复的时间，可为空','varchar(32)','String','deliverTime','','','1','1','1','','EQ','input','0','system','2019-09-06 10:50:26','system','2019-09-06 10:50:37',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805024744976388','sms_message_deliver_log','status',60,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 10:50:26','system','2019-09-06 10:50:37',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169805024744976389','sms_message_deliver_log','create_by',70,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 10:50:27','system','2019-09-06 10:50:38',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805024866611202','sms_message_deliver_log','create_time',80,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 10:50:27','system','2019-09-06 10:50:38',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805024866611203','sms_message_deliver_log','update_by',90,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 10:50:27','system','2019-09-06 10:50:38',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805024900165634','sms_message_deliver_log','update_time',100,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 10:50:27','system','2019-09-06 10:50:38',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805024900165635','sms_message_deliver_log','remarks',110,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 10:50:27','system','2019-09-06 10:50:38',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169805206270259202','sms_message_template','id',10,'作为用户在系统中的唯一标识','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 10:51:10','system','2019-09-06 10:51:25',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805206270259203','sms_message_template','user_code',20,'归属用户，如果为0，则表示为系统模板（使用所有人）','varchar(64)','String','userCode','','1','1','1','1','','EQ','input','0','system','2019-09-06 10:51:10','system','2019-09-06 10:51:25',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805206270259204','sms_message_template','content',30,'模板内容','varchar(1024)','String','content','','1','1','1','1','','EQ','textarea','0','system','2019-09-06 10:51:10','system','2019-09-06 10:51:25',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169805206438031361','sms_message_template','app_type',40,'操作方式，1:融合WEB平台,2:开发者平台,3:运营支撑系统','int(4)','String','appType','','','1','1','1','','EQ','input','0','system','2019-09-06 10:51:10','system','2019-09-06 10:51:25',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805206438031362','sms_message_template','approve_time',50,'审批时间','datetime','java.util.Date','approveTime','','','1','1','1','','EQ','input','0','system','2019-09-06 10:51:10','system','2019-09-06 10:51:25',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805206438031363','sms_message_template','approve_user',60,'审批账号','varchar(64)','String','approveUser','','','1','1','1','','EQ','input','0','system','2019-09-06 10:51:10','system','2019-09-06 10:51:25',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805206438031364','sms_message_template','notice_mode',70,'审核后短信通知类型,0:不需要通知，1：需要通知','int(4)','String','noticeMode','','','1','1','1','','EQ','input','0','system','2019-09-06 10:51:10','system','2019-09-06 10:51:25',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805206534500354','sms_message_template','mobile',80,'审核后通知的手机号码','varchar(32)','String','mobile','','','1','1','1','','EQ','input','0','system','2019-09-06 10:51:10','system','2019-09-06 10:51:25',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805206534500355','sms_message_template','regex_value',90,'匹配正则表达式，后台自动生成','varchar(1024)','String','regexValue','','','1','1','1','','EQ','input','0','system','2019-09-06 10:51:10','system','2019-09-06 10:51:25',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805206534500356','sms_message_template','submit_interval',100,'短信提交时间间隔（同一号码）','int(8)','String','submitInterval','','1','1','1','1','','EQ','input','0','system','2019-09-06 10:51:10','system','2019-09-06 10:51:25',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805206534500357','sms_message_template','limit_times',110,'短信每天提交次数上限（同一号码）','int(8)','String','limitTimes','','','1','1','1','','EQ','input','0','system','2019-09-06 10:51:10','system','2019-09-06 10:51:25',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805206534500358','sms_message_template','white_word',120,'敏感词白名单 |符号隔开','varchar(512)','String','whiteWord','','','1','1','1','','EQ','input','0','system','2019-09-06 10:51:10','system','2019-09-06 10:51:25',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805206534500359','sms_message_template','route_type',130,'模板路由类型','int(4)','String','routeType','','1','1','1','1','','EQ','input','0','system','2019-09-06 10:51:10','system','2019-09-06 10:51:25',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805206534500360','sms_message_template','priority',140,'优先级（越大越优先）','int(4)','String','priority','','1','1','1','1','','EQ','input','0','system','2019-09-06 10:51:10','system','2019-09-06 10:51:25',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805206534500361','sms_message_template','ext_number',150,'扩展号','varchar(32)','String','extNumber','','','1','1','1','','EQ','input','0','system','2019-09-06 10:51:10','system','2019-09-06 10:51:25',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805206534500362','sms_message_template','ignore_blacklist',160,'忽略手机号码黑名单','int(4)','String','ignoreBlacklist','','','1','1','1','','EQ','input','0','system','2019-09-06 10:51:10','system','2019-09-06 10:51:25',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805206534500363','sms_message_template','ignore_forbidden_words',170,'忽略短信中敏感词信息，强制放行','int(4)','String','ignoreForbiddenWords','','','1','1','1','','EQ','input','0','system','2019-09-06 10:51:10','system','2019-09-06 10:51:25',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805207176228865','sms_message_template','status',180,'0：待审核，1：审核成功，2：审核失败','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 10:51:10','system','2019-09-06 10:51:25',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169805207176228866','sms_message_template','create_by',190,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 10:51:10','system','2019-09-06 10:51:25',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805207176228867','sms_message_template','create_time',200,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 10:51:10','system','2019-09-06 10:51:25',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805207176228868','sms_message_template','update_by',210,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 10:51:10','system','2019-09-06 10:51:25',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805207251726337','sms_message_template','update_time',220,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 10:51:10','system','2019-09-06 10:51:25',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805207251726338','sms_message_template','remarks',230,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 10:51:10','system','2019-09-06 10:51:25',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169805581039710210','sms_mo_message_push','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 10:52:39','system','2019-09-06 10:52:48',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805581039710211','sms_mo_message_push','msg_id',20,'消息ID','varchar(64)','String','msgId','','','1','1','1','','EQ','input','0','system','2019-09-06 10:52:39','system','2019-09-06 10:52:48',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805581039710212','sms_mo_message_push','mobile',30,'手机号码','varchar(6000)','String','mobile','','1','1','1','1','','EQ','input','0','system','2019-09-06 10:52:39','system','2019-09-06 10:52:48',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805581106819073','sms_mo_message_push','content',40,'推送内容','varchar(1024)','String','content','','1','1','1','1','','EQ','textarea','0','system','2019-09-06 10:52:39','system','2019-09-06 10:52:48',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169805581106819074','sms_mo_message_push','retry_times',50,'重试次数','int(4)','String','retryTimes','','','1','1','1','','EQ','input','0','system','2019-09-06 10:52:39','system','2019-09-06 10:52:48',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805581106819075','sms_mo_message_push','response_milliseconds',60,'推送相应时间','bigint(20)','Long','responseMilliseconds','','','1','1','1','','EQ','input','0','system','2019-09-06 10:52:39','system','2019-09-06 10:52:48',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805581106819076','sms_mo_message_push','response_content',70,'响应内容','varchar(1024)','String','responseContent','','','1','1','1','','EQ','input','0','system','2019-09-06 10:52:39','system','2019-09-06 10:52:48',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805581249425409','sms_mo_message_push','status',80,'0：待审核，1：审核成功，2：审核失败','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 10:52:39','system','2019-09-06 10:52:48',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169805581249425410','sms_mo_message_push','create_by',90,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 10:52:39','system','2019-09-06 10:52:48',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805581249425411','sms_mo_message_push','create_time',100,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 10:52:39','system','2019-09-06 10:52:48',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805581249425412','sms_mo_message_push','update_by',110,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 10:52:39','system','2019-09-06 10:52:48',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805581249425413','sms_mo_message_push','update_time',120,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 10:52:39','system','2019-09-06 10:52:48',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169805581249425414','sms_mo_message_push','remarks',130,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 10:52:39','system','2019-09-06 10:52:48',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169807341909192706','sms_mo_message_receive','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 10:59:39','system','2019-09-06 10:59:47',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807342026633217','sms_mo_message_receive','user_code',20,'用户编码','varchar(64)','String','userCode','','1','1','1','1','','EQ','input','0','system','2019-09-06 10:59:39','system','2019-09-06 10:59:47',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807342026633218','sms_mo_message_receive','passage_id',30,'通道标识','int(11)','String','passageId','','','1','1','1','','EQ','input','0','system','2019-09-06 10:59:39','system','2019-09-06 10:59:47',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807342026633219','sms_mo_message_receive','msg_id',40,'短信标识','varchar(64)','String','msgId','','','1','1','1','','EQ','input','0','system','2019-09-06 10:59:39','system','2019-09-06 10:59:47',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807342085353474','sms_mo_message_receive','mobile',50,'用户手机号','varchar(64)','String','mobile','','','1','1','1','','EQ','input','0','system','2019-09-06 10:59:39','system','2019-09-06 10:59:47',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807342085353475','sms_mo_message_receive','content',60,'短信内容','varchar(1024)','String','content','','1','1','1','1','','EQ','textarea','0','system','2019-09-06 10:59:39','system','2019-09-06 10:59:47',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169807342085353476','sms_mo_message_receive','destnation_no',70,'服务号长号码','varchar(64)','String','destnationNo','','','1','1','1','','EQ','input','0','system','2019-09-06 10:59:39','system','2019-09-06 10:59:47',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807342085353477','sms_mo_message_receive','need_push',80,'是否需要推送，0：不需要，1：需要','tinyint(1)','String','needPush','','','1','1','1','','EQ','input','0','system','2019-09-06 10:59:39','system','2019-09-06 10:59:47',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807342257319937','sms_mo_message_receive','push_url',90,'推送地址','varchar(128)','String','pushUrl','','','1','1','1','','EQ','input','0','system','2019-09-06 10:59:39','system','2019-09-06 10:59:47',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807342257319938','sms_mo_message_receive','receive_time',100,'收到信息的时间','varchar(64)','String','receiveTime','','','1','1','1','','EQ','input','0','system','2019-09-06 10:59:39','system','2019-09-06 10:59:47',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807342257319939','sms_mo_message_receive','status',110,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 10:59:39','system','2019-09-06 10:59:47',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169807342257319940','sms_mo_message_receive','create_by',120,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 10:59:39','system','2019-09-06 10:59:47',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807342257319941','sms_mo_message_receive','create_time',130,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 10:59:39','system','2019-09-06 10:59:47',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807342257319942','sms_mo_message_receive','update_by',140,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 10:59:39','system','2019-09-06 10:59:47',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807342257319943','sms_mo_message_receive','update_time',150,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 10:59:39','system','2019-09-06 10:59:47',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807342257319944','sms_mo_message_receive','remarks',160,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 10:59:39','system','2019-09-06 10:59:47',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169807577322893314','sms_mobile_blacklist','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:00:35','system','2019-09-06 11:01:04',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807577322893315','sms_mobile_blacklist','mobile',20,'手机号码','varchar(16)','String','mobile','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:00:35','system','2019-09-06 11:01:04',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807577322893316','sms_mobile_blacklist','type',30,'类型','int(4)','String','type','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:00:35','system','2019-09-06 11:01:04',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807577419362306','sms_mobile_blacklist','remark',40,'备注','varchar(256)','String','remark','','','1','1','1','','EQ','input','0','system','2019-09-06 11:00:35','system','2019-09-06 11:01:04',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807577419362307','sms_mobile_blacklist','status',50,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:00:35','system','2019-09-06 11:01:04',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169807577419362308','sms_mobile_blacklist','create_by',60,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:00:35','system','2019-09-06 11:01:04',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807577419362309','sms_mobile_blacklist','create_time',70,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:00:35','system','2019-09-06 11:01:04',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807577494859777','sms_mobile_blacklist','update_by',80,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:00:35','system','2019-09-06 11:01:04',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807577494859778','sms_mobile_blacklist','update_time',90,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:00:35','system','2019-09-06 11:01:04',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807577494859779','sms_mobile_blacklist','remarks',100,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:00:35','system','2019-09-06 11:01:04',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169807760739807233','sms_mobile_whitelist','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:01:19','system','2019-09-06 11:01:24',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807760773361666','sms_mobile_whitelist','mobile',20,'mobile','varchar(16)','String','mobile','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:01:19','system','2019-09-06 11:01:24',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807760773361667','sms_mobile_whitelist','user_code',30,'用户编码','varchar(64)','String','userCode','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:01:19','system','2019-09-06 11:01:24',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807760773361668','sms_mobile_whitelist','status',40,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:01:19','system','2019-09-06 11:01:24',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169807760957911042','sms_mobile_whitelist','create_by',50,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:01:19','system','2019-09-06 11:01:24',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807760957911043','sms_mobile_whitelist','create_time',60,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:01:19','system','2019-09-06 11:01:24',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807760957911044','sms_mobile_whitelist','update_by',70,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:01:19','system','2019-09-06 11:01:24',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807760957911045','sms_mobile_whitelist','update_time',80,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:01:19','system','2019-09-06 11:01:24',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807760957911046','sms_mobile_whitelist','remarks',90,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:01:19','system','2019-09-06 11:01:24',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169807906366042113','sms_msg_deliver','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:01:54','system','2019-09-06 11:02:00',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807906366042114','sms_msg_deliver','deliverStatus',20,'deliverStatus','int(11)','String','deliverstatus','','','1','1','1','1','EQ','input','0','system','2019-09-06 11:01:54','system','2019-09-06 11:02:00',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807906366042115','sms_msg_deliver','statusDes',30,'statusDes','varchar(500)','String','statusdes','','','1','1','1','','EQ','input','0','system','2019-09-06 11:01:54','system','2019-09-06 11:02:00',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807906366042116','sms_msg_deliver','deliverTimeStart',40,'deliverTimeStart','bigint(20)','Long','delivertimestart','','','1','1','1','','EQ','input','0','system','2019-09-06 11:01:54','system','2019-09-06 11:02:00',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807906366042117','sms_msg_deliver','deliverTimeEnd',50,'deliverTimeEnd','bigint(20)','Long','delivertimeend','','','1','1','1','','EQ','input','0','system','2019-09-06 11:01:54','system','2019-09-06 11:02:00',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169807906366042118','sms_msg_deliver','httpTryTimes',60,'httpTryTimes','int(11)','String','httptrytimes','','','1','1','1','','EQ','input','0','system','2019-09-06 11:01:54','system','2019-09-06 11:02:00',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808013752807425','sms_mt_manual_handling','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:02:19','system','2019-09-06 11:02:33',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808013761196033','sms_mt_manual_handling','sid',20,'sid','bigint(20)','Long','sid','','','1','1','1','','EQ','input','0','system','2019-09-06 11:02:19','system','2019-09-06 11:02:33',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808013769584641','sms_mt_manual_handling','app_type',30,'调用类型 1:融合WEB平台,2:开发者平台,3:运营支撑系统','tinyint(2)','String','appType','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:02:19','system','2019-09-06 11:02:33',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808013769584642','sms_mt_manual_handling','ip',40,'发送IP','varchar(32)','String','ip','','','1','1','1','','EQ','input','0','system','2019-09-06 11:02:19','system','2019-09-06 11:02:33',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808013769584643','sms_mt_manual_handling','user_code',50,'用户编码','varchar(64)','String','userCode','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:02:19','system','2019-09-06 11:02:33',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808013769584644','sms_mt_manual_handling','mobile',60,'手机号','varchar(1024)','String','mobile','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:02:19','system','2019-09-06 11:02:33',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808013769584645','sms_mt_manual_handling','cmcp',70,'运营商，参见cmcp枚举','int(4)','String','cmcp','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:02:19','system','2019-09-06 11:02:33',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808013769584646','sms_mt_manual_handling','template_id',80,'模板编号','int(10)','String','templateId','','','1','1','1','','EQ','input','0','system','2019-09-06 11:02:19','system','2019-09-06 11:02:33',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808013769584647','sms_mt_manual_handling','content',90,'短信内容','varchar(1024)','String','content','','1','1','1','1','','EQ','textarea','0','system','2019-09-06 11:02:19','system','2019-09-06 11:02:33',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169808013866053634','sms_mt_manual_handling','fee',100,'计费条数','int(4)','String','fee','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:02:19','system','2019-09-06 11:02:33',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808013866053635','sms_mt_manual_handling','ext_number',110,'拓展号码','varchar(20)','String','extNumber','','','1','1','1','','EQ','input','0','system','2019-09-06 11:02:19','system','2019-09-06 11:02:33',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808013866053636','sms_mt_manual_handling','attach',120,'自定义内容','varchar(64)','String','attach','','','1','1','1','','EQ','input','0','system','2019-09-06 11:02:19','system','2019-09-06 11:02:33',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808013895413762','sms_mt_manual_handling','callback',130,'回调URL（选填）','varchar(256)','String','callback','','','1','1','1','','EQ','input','0','system','2019-09-06 11:02:19','system','2019-09-06 11:02:33',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808013912190977','sms_mt_manual_handling','lastest_status',140,'初始状态，刚开始与status一致','int(4)','String','lastestStatus','','','1','1','1','','EQ','input','0','system','2019-09-06 11:02:19','system','2019-09-06 11:02:33',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808013916385282','sms_mt_manual_handling','status',150,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:02:19','system','2019-09-06 11:02:33',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169808013933162497','sms_mt_manual_handling','create_by',160,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:02:19','system','2019-09-06 11:02:33',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808013941551106','sms_mt_manual_handling','create_time',170,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:02:19','system','2019-09-06 11:02:33',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808013941551107','sms_mt_manual_handling','update_by',180,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:02:19','system','2019-09-06 11:02:33',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808013941551108','sms_mt_manual_handling','update_time',190,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:02:19','system','2019-09-06 11:02:33',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808013941551109','sms_mt_manual_handling','remarks',200,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:02:19','system','2019-09-06 11:02:33',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169808138608848897','sms_mt_message_deliver','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:02:49','system','2019-09-06 11:02:53',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808138894061570','sms_mt_message_deliver','msg_id',20,'消息ID','varchar(64)','String','msgId','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:02:49','system','2019-09-06 11:02:53',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808138906644482','sms_mt_message_deliver','cmcp',30,'运营商','int(4)','String','cmcp','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:02:49','system','2019-09-06 11:02:53',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808138919227393','sms_mt_message_deliver','mobile',40,'用户手机号','varchar(64)','String','mobile','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:02:49','system','2019-09-06 11:02:53',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808138927616002','sms_mt_message_deliver','status_code',50,'状态码','varchar(64)','String','statusCode','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:02:49','system','2019-09-06 11:02:53',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808138936004610','sms_mt_message_deliver','deliver_time',60,'短信提供商回复的时间，可为空','varchar(32)','String','deliverTime','','','1','1','1','','EQ','input','0','system','2019-09-06 11:02:49','system','2019-09-06 11:02:53',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808138944393218','sms_mt_message_deliver','status',70,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:02:49','system','2019-09-06 11:02:53',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169808138952781826','sms_mt_message_deliver','create_by',80,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:02:49','system','2019-09-06 11:02:53',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808138952781827','sms_mt_message_deliver','create_time',90,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:02:49','system','2019-09-06 11:02:53',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808138952781828','sms_mt_message_deliver','update_by',100,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:02:49','system','2019-09-06 11:02:53',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808138986336258','sms_mt_message_deliver','update_time',110,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:02:49','system','2019-09-06 11:02:53',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808138998919169','sms_mt_message_deliver','remarks',120,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:02:49','system','2019-09-06 11:02:53',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169808236566818817','sms_mt_message_deliver_log','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:03:12','system','2019-09-06 11:03:25',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808236575207425','sms_mt_message_deliver_log','passage_code',20,'通道简码','varchar(32)','String','passageCode','','','1','1','1','','EQ','input','0','system','2019-09-06 11:03:12','system','2019-09-06 11:03:25',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808236575207426','sms_mt_message_deliver_log','msg_id',30,'消息ID','varchar(64)','String','msgId','','','1','1','1','','EQ','input','0','system','2019-09-06 11:03:12','system','2019-09-06 11:03:25',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808236575207427','sms_mt_message_deliver_log','deliver_time',40,'短信提供商回复的时间，可为空','varchar(32)','String','deliverTime','','','1','1','1','1','EQ','input','0','system','2019-09-06 11:03:12','system','2019-09-06 11:03:25',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808236604567553','sms_mt_message_deliver_log','create_time',50,'插入数据时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:03:12','system','2019-09-06 11:03:25',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808236617150465','sms_mt_message_deliver_log','report',60,'报文数据','longtext','String','report','','','1','1','1','','EQ','input','0','system','2019-09-06 11:03:12','system','2019-09-06 11:03:25',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808363893305346','sms_mt_message_push','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:03:43','system','2019-09-06 11:03:52',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808363893305347','sms_mt_message_push','msg_id',20,'消息ID','varchar(64)','String','msgId','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:03:43','system','2019-09-06 11:03:52',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808363893305348','sms_mt_message_push','mobile',30,'手机号码','varchar(6000)','String','mobile','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:03:43','system','2019-09-06 11:03:52',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808363922665474','sms_mt_message_push','content',40,'推送内容','varchar(256)','String','content','','','1','1','1','','EQ','textarea','0','system','2019-09-06 11:03:43','system','2019-09-06 11:03:52',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169808363943636994','sms_mt_message_push','retry_times',50,'重试次数','int(4)','String','retryTimes','','','1','1','1','','EQ','input','0','system','2019-09-06 11:03:43','system','2019-09-06 11:03:52',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808363952025602','sms_mt_message_push','response_milliseconds',60,'推送相应时间','bigint(20)','Long','responseMilliseconds','','','1','1','1','','EQ','input','0','system','2019-09-06 11:03:43','system','2019-09-06 11:03:52',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808363952025603','sms_mt_message_push','response_content',70,'响应内容','varchar(1024)','String','responseContent','','','1','1','1','','EQ','input','0','system','2019-09-06 11:03:43','system','2019-09-06 11:03:52',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808364010745858','sms_mt_message_push','status',80,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:03:43','system','2019-09-06 11:03:52',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169808364010745859','sms_mt_message_push','create_by',90,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:03:43','system','2019-09-06 11:03:52',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808364010745860','sms_mt_message_push','create_time',100,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:03:43','system','2019-09-06 11:03:52',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808364589559810','sms_mt_message_push','update_by',110,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:03:43','system','2019-09-06 11:03:52',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808364958658562','sms_mt_message_push','update_time',120,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:03:43','system','2019-09-06 11:03:52',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808364967047170','sms_mt_message_push','remarks',130,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:03:43','system','2019-09-06 11:03:52',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169808476959158273','sms_mt_message_submit','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:04:10','system','2019-09-06 11:04:19',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808476967546881','sms_mt_message_submit','user_code',20,'用户编码','varchar(64)','String','userCode','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:04:10','system','2019-09-06 11:04:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808476975935489','sms_mt_message_submit','sid',30,'消息ID','bigint(20)','Long','sid','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:04:10','system','2019-09-06 11:04:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808476984324097','sms_mt_message_submit','mobile',40,'手机号码','varchar(32)','String','mobile','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:04:10','system','2019-09-06 11:04:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808476996907009','sms_mt_message_submit','province_code',50,'省份代码','int(4)','String','provinceCode','','','1','1','1','','EQ','input','0','system','2019-09-06 11:04:10','system','2019-09-06 11:04:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808476996907010','sms_mt_message_submit','cmcp',60,'运营商','int(4)','String','cmcp','','','1','1','1','','EQ','input','0','system','2019-09-06 11:04:10','system','2019-09-06 11:04:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808476996907011','sms_mt_message_submit','content',70,'短信内容','varchar(2048)','String','content','','','1','1','1','','EQ','textarea','0','system','2019-09-06 11:04:10','system','2019-09-06 11:04:19',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169808476996907012','sms_mt_message_submit','fee',80,'计费条数','int(4)','String','fee','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:04:10','system','2019-09-06 11:04:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808476996907013','sms_mt_message_submit','attach',90,'自定义内容','varchar(64)','String','attach','','','1','1','1','','EQ','input','0','system','2019-09-06 11:04:10','system','2019-09-06 11:04:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808476996907014','sms_mt_message_submit','passage_id',100,'通道ID','int(11) unsigned','String','passageId','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:04:10','system','2019-09-06 11:04:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808476996907015','sms_mt_message_submit','need_push',110,'是否需要推送，0：不需要，1：需要','tinyint(1)','String','needPush','','','1','1','1','','EQ','input','0','system','2019-09-06 11:04:10','system','2019-09-06 11:04:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808476996907016','sms_mt_message_submit','push_url',120,'推送地址','varchar(128)','String','pushUrl','','','1','1','1','','EQ','input','0','system','2019-09-06 11:04:10','system','2019-09-06 11:04:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808476996907017','sms_mt_message_submit','destnation_no',130,'扩展号码','varchar(32)','String','destnationNo','','','1','1','1','','EQ','input','0','system','2019-09-06 11:04:10','system','2019-09-06 11:04:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808476996907018','sms_mt_message_submit','msg_id',140,'调用接口回执ID，默认与SID一致','varchar(64)','String','msgId','','','1','1','1','','EQ','input','0','system','2019-09-06 11:04:10','system','2019-09-06 11:04:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808476996907019','sms_mt_message_submit','status',150,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:04:10','system','2019-09-06 11:04:19',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169808476996907020','sms_mt_message_submit','create_by',160,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:04:10','system','2019-09-06 11:04:19',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808476996907021','sms_mt_message_submit','create_time',170,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:04:10','system','2019-09-06 11:04:19',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808476996907022','sms_mt_message_submit','update_by',180,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:04:10','system','2019-09-06 11:04:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808476996907023','sms_mt_message_submit','update_time',190,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:04:10','system','2019-09-06 11:04:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808477160484865','sms_mt_message_submit','remarks',200,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:04:10','system','2019-09-06 11:04:19',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169808585872650241','sms_mt_process_failed','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:04:36','system','2019-09-06 11:04:39',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808585893621762','sms_mt_process_failed','sid',20,'sid','bigint(20)','Long','sid','','','1','1','1','','EQ','input','0','system','2019-09-06 11:04:36','system','2019-09-06 11:04:39',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808585902010370','sms_mt_process_failed','app_type',30,'调用类型 1:融合WEB平台,2:开发者平台,3:运营支撑系统','tinyint(2)','String','appType','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:04:36','system','2019-09-06 11:04:39',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808585906204673','sms_mt_process_failed','ip',40,'发送IP','varchar(50)','String','ip','','','1','1','1','','EQ','input','0','system','2019-09-06 11:04:36','system','2019-09-06 11:04:39',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808585906204674','sms_mt_process_failed','user_code',50,'用户编码','varchar(64)','String','userCode','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:04:36','system','2019-09-06 11:04:39',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808585906204675','sms_mt_process_failed','mobile',60,'手机号','varchar(1024)','String','mobile','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:04:36','system','2019-09-06 11:04:39',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808585906204676','sms_mt_process_failed','cmcp',70,'运营商，参见cmcp枚举','int(4)','String','cmcp','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:04:36','system','2019-09-06 11:04:39',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808585906204677','sms_mt_process_failed','template_id',80,'模板编号','int(10)','String','templateId','','','1','1','1','','EQ','input','0','system','2019-09-06 11:04:36','system','2019-09-06 11:04:39',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808585906204678','sms_mt_process_failed','content',90,'短信内容','varchar(1024)','String','content','','1','1','1','1','','EQ','textarea','0','system','2019-09-06 11:04:36','system','2019-09-06 11:04:39',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169808586292080641','sms_mt_process_failed','fee',100,'计费条数','int(4)','String','fee','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:04:36','system','2019-09-06 11:04:39',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808586300469249','sms_mt_process_failed','ext_number',110,'拓展号码','varchar(20)','String','extNumber','','','1','1','1','','EQ','input','0','system','2019-09-06 11:04:36','system','2019-09-06 11:04:39',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808586308857857','sms_mt_process_failed','attach',120,'自定义内容','varchar(64)','String','attach','','','1','1','1','','EQ','input','0','system','2019-09-06 11:04:36','system','2019-09-06 11:04:39',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808586325635074','sms_mt_process_failed','callback',130,'回调URL（选填）','varchar(256)','String','callback','','','1','1','1','','EQ','input','0','system','2019-09-06 11:04:36','system','2019-09-06 11:04:39',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808586334023681','sms_mt_process_failed','lastest_status',140,'上一条状态','int(4)','String','lastestStatus','','','1','1','1','','EQ','input','0','system','2019-09-06 11:04:36','system','2019-09-06 11:04:39',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808586334023682','sms_mt_process_failed','status',150,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:04:36','system','2019-09-06 11:04:39',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169808586334023683','sms_mt_process_failed','create_by',160,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:04:36','system','2019-09-06 11:04:39',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808586334023684','sms_mt_process_failed','create_time',170,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:04:36','system','2019-09-06 11:04:39',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808586334023685','sms_mt_process_failed','update_by',180,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:04:36','system','2019-09-06 11:04:39',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808586334023686','sms_mt_process_failed','update_time',190,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:04:36','system','2019-09-06 11:04:39',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808586396938241','sms_mt_process_failed','remarks',200,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:04:36','system','2019-09-06 11:04:39',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169808690860273665','sms_mt_task','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808690872856577','sms_mt_task','user_code',20,'用户编码','varchar(64)','String','userCode','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808690881245186','sms_mt_task','sid',30,'消息ID','bigint(20)','Long','sid','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808690885439489','sms_mt_task','app_type',40,'调用类型 1:融合WEB平台,2:开发者平台,3:运营支撑系统','tinyint(2)','String','appType','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808690893828098','sms_mt_task','mobile',50,'手机号','longtext','String','mobile','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808690906411009','sms_mt_task','content',60,'content','varchar(2048)','String','content','','','1','1','1','','EQ','textarea','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169808690914799617','sms_mt_task','ext_number',70,'拓展号码','varchar(20)','String','extNumber','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808690914799618','sms_mt_task','attach',80,'自定义内容','varchar(64)','String','attach','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808690914799619','sms_mt_task','callback',90,'回调URL（选填）','varchar(256)','String','callback','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808690944159746','sms_mt_task','fee',100,'计费条数','int(8)','String','fee','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808690952548353','sms_mt_task','return_fee',110,'返还条数','int(4)','String','returnFee','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808690977714177','sms_mt_task','submit_url',120,'程序调用URL','varchar(256)','String','submitUrl','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808690994491393','sms_mt_task','ip',130,'提交IP','varchar(45)','String','ip','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808691002880001','sms_mt_task','submit_type',140,'提交类型：0：批量短信，1：普通点对点，2：模板点对点','int(4)','String','submitType','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808691015462913','sms_mt_task','process_status',150,'分包状态,0:正在分包，1：分包完成，待发送，2:分包异常，待处理，3:分包失败，终止','int(4)','String','processStatus','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808691019657217','sms_mt_task','approve_status',160,'0：待审核，1：自动通过，2：手动通过，3：审核未通过','int(4)','String','approveStatus','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808691028045825','sms_mt_task','error_mobiles',170,'错号手机号码','text','String','errorMobiles','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808691036434434','sms_mt_task','repeat_mobiles',180,'重复手机号码','text','String','repeatMobiles','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808691044823041','sms_mt_task','black_mobiles',190,'黑名单手机号码','text','String','blackMobiles','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808691053211649','sms_mt_task','final_content',200,'final_content','varchar(2048)','String','finalContent','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808691061600257','sms_mt_task','process_time',210,'分包完成时间','datetime','java.util.Date','processTime','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808691078377473','sms_mt_task','force_actions',220,'异常分包情况下允许的操作，如000,010，第一位:未报备模板，第二位：敏感词，第三位：通道不可用','varchar(32)','String','forceActions','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808691078377474','sms_mt_task','message_template_id',230,'短信模板ID','bigint(20)','Long','messageTemplateId','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808691090960386','sms_mt_task','forbidden_words',240,'敏感词','varchar(64)','String','forbiddenWords','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808691090960387','sms_mt_task','status',250,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169808691090960388','sms_mt_task','create_by',260,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808691120320513','sms_mt_task','create_time',270,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808691120320514','sms_mt_task','update_by',280,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808691128709121','sms_mt_task','update_time',290,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808691141292034','sms_mt_task','remarks',300,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:05:01','system','2019-09-06 11:05:09',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169808805964558337','sms_mt_task_packets','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808805972946945','sms_mt_task_packets','sid',20,'消息ID','bigint(20)','Long','sid','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808805981335554','sms_mt_task_packets','mobile',30,'手机号码（批量时为多个）','longtext','String','mobile','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808805989724161','sms_mt_task_packets','cmcp',40,'运营商','int(4)','String','cmcp','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808805998112769','sms_mt_task_packets','content',50,'content','varchar(2048)','String','content','','','1','1','1','','EQ','textarea','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169808806006501378','sms_mt_task_packets','mobile_size',60,'号码总个数','int(10)','String','mobileSize','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808806014889985','sms_mt_task_packets','message_template_id',70,'短信模板ID','bigint(20)','Long','messageTemplateId','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808806023278593','sms_mt_task_packets','passage_id',80,'通道ID','int(11)','String','passageId','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808806023278594','sms_mt_task_packets','final_passage_id',90,'最终使用的通道ID','int(11)','String','finalPassageId','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808806023278595','sms_mt_task_packets','passage_protocol',100,'协议类型','varchar(32)','String','passageProtocol','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808806023278596','sms_mt_task_packets','passage_url',110,'通道URL','varchar(128)','String','passageUrl','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808806023278597','sms_mt_task_packets','passage_parameter',120,'参数信息','varchar(512)','String','passageParameter','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808806023278598','sms_mt_task_packets','result_format',130,'结果模板','varchar(255)','String','resultFormat','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808806086193154','sms_mt_task_packets','success_code',140,'成功码','varchar(100)','String','successCode','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808806086193155','sms_mt_task_packets','position',150,'定位','varchar(1024)','String','position','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808806111358978','sms_mt_task_packets','priority',160,'优先级','int(10)','String','priority','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808806123941889','sms_mt_task_packets','force_actions',170,'异常分包情况下允许的操作，如000,010，第一位:未报备模板，第二位：敏感词，第三位：通道不可用','varchar(32)','String','forceActions','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808806128136194','sms_mt_task_packets','retry_times',180,'调用上家重试次数','int(11)','String','retryTimes','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808806329462785','sms_mt_task_packets','province_code',190,'省份代码','int(4)','String','provinceCode','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808806337851393','sms_mt_task_packets','status',200,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169808806354628610','sms_mt_task_packets','create_by',210,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808806354628611','sms_mt_task_packets','create_time',220,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808806367211522','sms_mt_task_packets','update_by',230,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808806383988737','sms_mt_task_packets','update_time',240,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808806388183042','sms_mt_task_packets','remarks',250,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:05:28','system','2019-09-06 11:05:36',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169808918485151745','sms_passage','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808918510317569','sms_passage','name',20,'通道名称','varchar(64)','String','name','','1','1','1','1','1','EQ','input','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808918510317570','sms_passage','code',30,'通道字母编码','varchar(32)','String','code','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808918531289090','sms_passage','cmcp',40,'运营商','int(4)','String','cmcp','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808918539677697','sms_passage','word_number',50,'计费字数','tinyint(4)','String','wordNumber','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808918548066305','sms_passage','priority',60,'优先级','tinyint(4)','String','priority','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808918564843522','sms_passage','paas_template_id',70,'通道模板','int(11)','String','paasTemplateId','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808918573232130','sms_passage','type',80,'通道类型 0 公共通道 1 独立通道','tinyint(4)','String','type','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808918581620738','sms_passage','exclusive_user_id',90,'独立通道时绑定的用户','int(11)','String','exclusiveUserId','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808918590009345','sms_passage','sign_mode',100,'签名模式 0:不处理，1：自动前置，2：自动后置，3：自动去除签名','tinyint(4)','String','signMode','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808918598397954','sms_passage','access_code',110,'10690接入号，需与params表接入号一致','varchar(32)','String','accessCode','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808918606786562','sms_passage','account',120,'接入账号(上家提供的用户账号)','varchar(32)','String','account','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808918610980866','sms_passage','pay_type',130,'付费方式(1预付2后付)','tinyint(4)','String','payType','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808918619369473','sms_passage','balance',140,'剩余条数','int(10)','String','balance','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808918619369474','sms_passage','mobile_size',150,'手机号码分包数','int(10)','String','mobileSize','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808918619369475','sms_passage','packets_size',160,'1秒钟允许提交的网络包数量','int(10)','String','packetsSize','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808918619369476','sms_passage','connection_size',170,'最大连接数','int(10)','String','connectionSize','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808918665506818','sms_passage','read_timeout',180,'超时时间（毫秒）','int(10)','String','readTimeout','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808918673895425','sms_passage','ext_number',190,'拓展号长度,0表示不允许拓展','int(10)','String','extNumber','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808918673895426','sms_passage','born_term',200,'统计落地时限（小时）','int(10)','String','bornTerm','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808918686478337','sms_passage','sms_template_param',210,'是否需要短信模板参数信息','int(4)','String','smsTemplateParam','','','1','1','1','','EQ','input','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808918699061250','sms_passage','status',220,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169808918707449858','sms_passage','create_by',230,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808918720032769','sms_passage','create_time',240,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808918724227074','sms_passage','update_by',250,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808918732615682','sms_passage','update_time',260,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169808918741004289','sms_passage','remarks',270,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:05:55','system','2019-09-06 11:06:02',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169809024944975873','sms_passage_access','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809024961753090','sms_passage_access','user_code',20,'用户编码','varchar(64)','String','userCode','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809024978530305','sms_passage_access','group_id',30,'通道组id','int(11)','String','groupId','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809024978530306','sms_passage_access','route_type',40,'路由类型','int(4)','String','routeType','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809024991113217','sms_passage_access','cmcp',50,'运营商','int(2)','String','cmcp','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809024999501826','sms_passage_access','province_code',60,'省份','int(11)','String','provinceCode','','','1','1','1','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809025007890434','sms_passage_access','passage_id',70,'通道ID','int(11)','String','passageId','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809025016279041','sms_passage_access','passage_code',80,'通道代码','varchar(32)','String','passageCode','','','1','1','1','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809025024667649','sms_passage_access','protocol',90,'协议类型','varchar(32)','String','protocol','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809025024667650','sms_passage_access','call_type',100,'1-发送2-下行推送 3-下行自取 4-上行推送 5-上行自取','tinyint(4)','String','callType','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809025024667651','sms_passage_access','url',110,'url','varchar(255)','String','url','','','1','1','1','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809025305686017','sms_passage_access','params_definition',120,'定义，直接取模板里的值','varchar(1024)','String','paramsDefinition','','','1','1','1','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809025314074626','sms_passage_access','params',130,'具体的参数值，取模板中的key作为KEY，如{＂username＂:＂test＂, ＂password＂:＂123456＂}','varchar(1024)','String','params','','','1','1','1','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809025330851842','sms_passage_access','result_format',140,'result_format','varchar(255)','String','resultFormat','','','1','1','1','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809025347629058','sms_passage_access','success_code',150,'成功码','varchar(100)','String','successCode','','','1','1','1','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809025347629059','sms_passage_access','position',160,'返回值的具体位置，json存储','varchar(1024)','String','position','','','1','1','1','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809025368600577','sms_passage_access','mobile_size',170,'手机号码分包数','int(10)','String','mobileSize','','','1','1','1','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809025376989186','sms_passage_access','packets_size',180,'1秒钟允许提交的网络包数量','int(10)','String','packetsSize','','','1','1','1','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809025385377793','sms_passage_access','connection_size',190,'最大连接数','int(10)','String','connectionSize','','','1','1','1','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809025402155009','sms_passage_access','read_timeout',200,'超时时间（毫秒）','int(10)','String','readTimeout','','','1','1','1','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809025410543617','sms_passage_access','access_code',210,'接入号码（10690...）','varchar(32)','String','accessCode','','','1','1','1','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809025418932225','sms_passage_access','ext_number',220,'拓展号长度,0表示不允许拓展','int(10)','String','extNumber','','','1','1','1','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809025431515138','sms_passage_access','sign_mode',230,'签名模式 0:不处理，1：自动前置，2：自动后置，3：自动去除签名','tinyint(4)','String','signMode','','','1','1','1','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809025439903746','sms_passage_access','sms_template_param',240,'是否需要短信模板参数信息','int(4)','String','smsTemplateParam','','','1','1','1','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809025444098050','sms_passage_access','status',250,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169809025595092993','sms_passage_access','create_by',260,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809025607675906','sms_passage_access','create_time',270,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809025624453121','sms_passage_access','update_by',280,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809025658007554','sms_passage_access','update_time',290,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809025670590466','sms_passage_access','remarks',300,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:06:20','system','2019-09-06 11:06:26',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169809124245123073','sms_passage_change_log','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:06:44','system','2019-09-06 11:06:51',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809124249317377','sms_passage_change_log','passage_id',20,'通道ID','int(11)','String','passageId','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:06:44','system','2019-09-06 11:06:51',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809124270288898','sms_passage_change_log','old_passage_id',30,'原通道ID','int(11)','String','oldPassageId','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:06:44','system','2019-09-06 11:06:51',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809124270288899','sms_passage_change_log','group_id',40,'通道组id','int(11)','String','groupId','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:06:44','system','2019-09-06 11:06:51',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809124270288900','sms_passage_change_log','user_code',50,'用户编码','varchar(64)','String','userCode','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:06:44','system','2019-09-06 11:06:51',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809124270288901','sms_passage_change_log','route_type',60,'路由类型','int(4)','String','routeType','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:06:44','system','2019-09-06 11:06:51',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809124270288902','sms_passage_change_log','cmcp',70,'运营商','int(2)','String','cmcp','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:06:44','system','2019-09-06 11:06:51',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809124329009154','sms_passage_change_log','operate_mode',80,'操作方式','int(2)','String','operateMode','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:06:44','system','2019-09-06 11:06:51',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809124329009155','sms_passage_change_log','operate_user',90,'操作人 工号','varchar(32)','String','operateUser','','','1','1','1','','EQ','input','0','system','2019-09-06 11:06:44','system','2019-09-06 11:06:51',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809124349980674','sms_passage_change_log','status',100,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:06:44','system','2019-09-06 11:06:51',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169809124370952194','sms_passage_change_log','create_by',110,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:06:44','system','2019-09-06 11:06:51',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809124370952195','sms_passage_change_log','create_time',120,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:06:44','system','2019-09-06 11:06:51',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809124391923713','sms_passage_change_log','update_by',130,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:06:44','system','2019-09-06 11:06:51',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809124404506626','sms_passage_change_log','update_time',140,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:06:44','system','2019-09-06 11:06:51',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809124404506627','sms_passage_change_log','remarks',150,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:06:44','system','2019-09-06 11:06:51',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169809233636765697','sms_passage_control','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:07:10','system','2019-09-06 11:07:17',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809233653542914','sms_passage_control','passage_id',20,'通道ID','int(11)','String','passageId','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:07:10','system','2019-09-06 11:07:17',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809233666125826','sms_passage_control','cron',30,'轮训表达式','varchar(64)','String','cron','','','1','1','1','','EQ','input','0','system','2019-09-06 11:07:10','system','2019-09-06 11:07:17',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809233783566338','sms_passage_control','parameter_id',40,'通道参数ID','int(11)','String','parameterId','','','1','1','1','','EQ','input','0','system','2019-09-06 11:07:10','system','2019-09-06 11:07:17',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809234500792321','sms_passage_control','status',50,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:07:10','system','2019-09-06 11:07:17',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169809234848919553','sms_passage_control','create_by',60,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:07:10','system','2019-09-06 11:07:17',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809234865696769','sms_passage_control','create_time',70,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:07:10','system','2019-09-06 11:07:17',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809234899251201','sms_passage_control','update_by',80,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:07:10','system','2019-09-06 11:07:17',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809234899251202','sms_passage_control','update_time',90,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:07:10','system','2019-09-06 11:07:17',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809234899251203','sms_passage_control','remarks',100,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:07:10','system','2019-09-06 11:07:17',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169809337680670721','sms_passage_group','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:07:35','system','2019-09-06 11:07:42',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809337693253634','sms_passage_group','passage_group_name',20,'通道组名称','varchar(32)','String','passageGroupName','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:07:35','system','2019-09-06 11:07:42',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809337710030850','sms_passage_group','status',30,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:07:35','system','2019-09-06 11:07:42',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169809337718419458','sms_passage_group','create_by',40,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:07:35','system','2019-09-06 11:07:42',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809337726808065','sms_passage_group','create_time',50,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:07:35','system','2019-09-06 11:07:42',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809337731002370','sms_passage_group','update_by',60,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:07:35','system','2019-09-06 11:07:42',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809337747779585','sms_passage_group','update_time',70,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:07:35','system','2019-09-06 11:07:42',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809337747779586','sms_passage_group','remarks',80,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:07:35','system','2019-09-06 11:07:42',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169809444018860033','sms_passage_group_detail','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:08:00','system','2019-09-06 11:08:05',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809444027248641','sms_passage_group_detail','group_id',20,'通道组id','int(11)','String','groupId','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:08:00','system','2019-09-06 11:08:05',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809444035637250','sms_passage_group_detail','passage_id',30,'通道id','int(11)','String','passageId','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:08:00','system','2019-09-06 11:08:05',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809444035637251','sms_passage_group_detail','province_code',40,'通道代码','int(11)','String','provinceCode','','','1','1','1','','EQ','input','0','system','2019-09-06 11:08:00','system','2019-09-06 11:08:05',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809444035637252','sms_passage_group_detail','route_type',50,'路由类型，0默认路由，1验证码路由,2即时通知路由，3批量通知路由，4高风险投诉路由','tinyint(4)','String','routeType','','','1','1','1','','EQ','input','0','system','2019-09-06 11:08:00','system','2019-09-06 11:08:05',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809444073385985','sms_passage_group_detail','priority',60,'优先级','int(4)','String','priority','','','1','1','1','','EQ','input','0','system','2019-09-06 11:08:00','system','2019-09-06 11:08:05',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809444081774594','sms_passage_group_detail','cmcp',70,'运营商1-移动 2-联通 3-电信','int(4)','String','cmcp','','','1','1','1','','EQ','input','0','system','2019-09-06 11:08:00','system','2019-09-06 11:08:05',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809444098551810','sms_passage_group_detail','status',80,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:08:00','system','2019-09-06 11:08:05',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169809444098551811','sms_passage_group_detail','create_by',90,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:08:00','system','2019-09-06 11:08:05',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809444098551812','sms_passage_group_detail','create_time',100,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:08:00','system','2019-09-06 11:08:05',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809444098551813','sms_passage_group_detail','update_by',110,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:08:00','system','2019-09-06 11:08:05',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809444098551814','sms_passage_group_detail','update_time',120,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:08:00','system','2019-09-06 11:08:05',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809444098551815','sms_passage_group_detail','remarks',130,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:08:00','system','2019-09-06 11:08:05',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169809537220489218','sms_passage_message_template','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:08:22','system','2019-09-06 11:08:32',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809537224683521','sms_passage_message_template','template_id',20,'通道模板ID（通道方提供）','varchar(64)','String','templateId','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:08:22','system','2019-09-06 11:08:32',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809537237266434','sms_passage_message_template','template_content',30,'模板内容','varchar(256)','String','templateContent','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:08:22','system','2019-09-06 11:08:32',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809537237266435','sms_passage_message_template','regex_value',40,'模板表达式','varchar(256)','String','regexValue','','','1','1','1','','EQ','input','0','system','2019-09-06 11:08:22','system','2019-09-06 11:08:32',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809537262432258','sms_passage_message_template','param_names',50,'参数名称，多个以,分割(有序)','varchar(64)','String','paramNames','','','1','1','1','','EQ','input','0','system','2019-09-06 11:08:22','system','2019-09-06 11:08:32',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809537275015169','sms_passage_message_template','passage_id',60,'通道ID','int(11)','String','passageId','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:08:22','system','2019-09-06 11:08:32',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809537279209473','sms_passage_message_template','status',70,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:08:22','system','2019-09-06 11:08:32',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169809537287598082','sms_passage_message_template','create_by',80,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:08:22','system','2019-09-06 11:08:32',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809537392455681','sms_passage_message_template','create_time',90,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:08:22','system','2019-09-06 11:08:32',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809537400844289','sms_passage_message_template','update_by',100,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:08:22','system','2019-09-06 11:08:32',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809537484730370','sms_passage_message_template','update_time',110,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:08:22','system','2019-09-06 11:08:32',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809537497313281','sms_passage_message_template','remarks',120,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:08:22','system','2019-09-06 11:08:32',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169809639997714434','sms_passage_parameter','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:08:47','system','2019-09-06 11:08:52',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809640006103041','sms_passage_parameter','passage_id',20,'通道ID','int(11)','String','passageId','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:08:47','system','2019-09-06 11:08:52',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809640006103042','sms_passage_parameter','protocol',30,'协议类型','varchar(32)','String','protocol','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:08:47','system','2019-09-06 11:08:52',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809640006103043','sms_passage_parameter','call_type',40,'1-发送 2-状态回执推送 3-状态回执自取 4-上行推送 5-上行自取 6-余额查询','tinyint(4)','String','callType','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:08:47','system','2019-09-06 11:08:52',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809640039657473','sms_passage_parameter','url',50,'url','varchar(255)','String','url','','','1','1','1','','EQ','input','0','system','2019-09-06 11:08:47','system','2019-09-06 11:08:52',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809640052240386','sms_passage_parameter','params_definition',60,'定义，直接取模板里的值','varchar(1024)','String','paramsDefinition','','','1','1','1','','EQ','input','0','system','2019-09-06 11:08:47','system','2019-09-06 11:08:52',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809640060628993','sms_passage_parameter','params',70,'具体的参数值，取模板中的key作为KEY，如{＂username＂:＂test＂, ＂password＂:＂123456＂}','varchar(1024)','String','params','','','1','1','1','','EQ','input','0','system','2019-09-06 11:08:47','system','2019-09-06 11:08:52',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809640060628994','sms_passage_parameter','result_format',80,'result_format','varchar(255)','String','resultFormat','','','1','1','1','','EQ','input','0','system','2019-09-06 11:08:47','system','2019-09-06 11:08:52',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809640085794817','sms_passage_parameter','success_code',90,'success_code','varchar(100)','String','successCode','','','1','1','1','','EQ','input','0','system','2019-09-06 11:08:47','system','2019-09-06 11:08:52',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809640089989122','sms_passage_parameter','position',100,'返回值的具体位置，json存储','varchar(1024)','String','position','','','1','1','1','','EQ','input','0','system','2019-09-06 11:08:47','system','2019-09-06 11:08:52',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809640106766337','sms_passage_parameter','status',110,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:08:47','system','2019-09-06 11:08:52',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169809640115154946','sms_passage_parameter','create_by',120,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:08:47','system','2019-09-06 11:08:52',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809640123543554','sms_passage_parameter','create_time',130,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:08:47','system','2019-09-06 11:08:52',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809640127737857','sms_passage_parameter','update_by',140,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:08:47','system','2019-09-06 11:08:52',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809640127737858','sms_passage_parameter','update_time',150,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:08:47','system','2019-09-06 11:08:52',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809640152903682','sms_passage_parameter','remarks',160,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:08:47','system','2019-09-06 11:08:52',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169809728174567426','sms_passage_province','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:09:08','system','2019-09-06 11:09:12',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809728182956033','sms_passage_province','passage_id',20,'通道ID','int(11)','String','passageId','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:09:08','system','2019-09-06 11:09:12',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809728195538945','sms_passage_province','province_code',30,'省份代码','int(11)','String','provinceCode','','','1','1','1','1','EQ','input','0','system','2019-09-06 11:09:08','system','2019-09-06 11:09:12',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809826870734849','sms_passage_reachrate_settings','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:09:31','system','2019-09-06 11:09:38',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809826879123458','sms_passage_reachrate_settings','passage_id',20,'短信通道ID','bigint(20)','Long','passageId','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:09:31','system','2019-09-06 11:09:38',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809826879123459','sms_passage_reachrate_settings','interval',30,'轮询间隔（单位秒）','bigint(20)','Long','interval','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:09:31','system','2019-09-06 11:09:38',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809826879123460','sms_passage_reachrate_settings','start_time',40,'数据源时间（开始执行时间点，单位秒）','bigint(20)','Long','startTime','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:09:31','system','2019-09-06 11:09:38',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809826925260802','sms_passage_reachrate_settings','time_length',50,'数据源时长','bigint(20)','Long','timeLength','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:09:31','system','2019-09-06 11:09:38',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809826933649410','sms_passage_reachrate_settings','count_point',60,'计数阀值，起始点','int(11)','String','countPoint','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:09:31','system','2019-09-06 11:09:38',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809826950426626','sms_passage_reachrate_settings','rate_threshold',70,'到达率，整数，最大100','int(4)','String','rateThreshold','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:09:31','system','2019-09-06 11:09:38',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809826950426627','sms_passage_reachrate_settings','mobile',80,'通知手机号码','varchar(64)','String','mobile','','','1','1','1','','EQ','input','0','system','2019-09-06 11:09:31','system','2019-09-06 11:09:38',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809826979786754','sms_passage_reachrate_settings','status',90,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:09:31','system','2019-09-06 11:09:38',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169809826988175362','sms_passage_reachrate_settings','create_by',100,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:09:31','system','2019-09-06 11:09:38',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809827000758273','sms_passage_reachrate_settings','create_time',110,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:09:31','system','2019-09-06 11:09:38',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809827013341186','sms_passage_reachrate_settings','update_by',120,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:09:31','system','2019-09-06 11:09:38',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809827013341187','sms_passage_reachrate_settings','update_time',130,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:09:31','system','2019-09-06 11:09:38',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809827013341188','sms_passage_reachrate_settings','remarks',140,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:09:31','system','2019-09-06 11:09:38',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169809918163955714','sms_priority_words','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:09:53','system','2019-09-06 11:09:59',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809918176538626','sms_priority_words','user_code',20,'用户编码','varchar(64)','String','userCode','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:09:53','system','2019-09-06 11:09:59',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809918176538627','sms_priority_words','content',30,'内容','varchar(64)','String','content','','1','1','1','1','','EQ','textarea','0','system','2019-09-06 11:09:53','system','2019-09-06 11:09:59',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169809918176538628','sms_priority_words','priority',40,'优先级','int(4)','String','priority','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:09:53','system','2019-09-06 11:09:59',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809918176538629','sms_priority_words','status',50,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:09:53','system','2019-09-06 11:09:59',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169809918218481665','sms_priority_words','create_by',60,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:09:53','system','2019-09-06 11:09:59',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809918226870273','sms_priority_words','create_time',70,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:09:53','system','2019-09-06 11:09:59',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809918235258881','sms_priority_words','update_by',80,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:09:53','system','2019-09-06 11:09:59',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809918252036098','sms_priority_words','update_time',90,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:09:53','system','2019-09-06 11:09:59',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169809918252036099','sms_priority_words','remarks',100,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:09:53','system','2019-09-06 11:09:59',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169810003958444033','sms_provider','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:10:14','system','2019-09-06 11:10:19',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810003966832641','sms_provider','type',20,'提供商类型0:运营商1:第三方','tinyint(4)','String','type','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:10:14','system','2019-09-06 11:10:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810003975221249','sms_provider','name',30,'提供商名称','varchar(45)','String','name','','1','1','1','1','1','EQ','input','0','system','2019-09-06 11:10:14','system','2019-09-06 11:10:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810003975221250','sms_provider','code',40,'提供商编号','varchar(45)','String','code','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:10:14','system','2019-09-06 11:10:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810003975221251','sms_provider','is_applied',50,'是否启用(0:启用1:停用)','tinyint(4)','String','isApplied','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:10:14','system','2019-09-06 11:10:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810003975221252','sms_provider','priority',60,'优先级(相同产品调用优先级)','tinyint(4)','String','priority','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:10:14','system','2019-09-06 11:10:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810003975221253','sms_provider','contact',70,'contact','varchar(45)','String','contact','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:10:14','system','2019-09-06 11:10:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810003975221254','sms_provider','phone',80,'phone','varchar(45)','String','phone','','','1','1','1','','EQ','input','0','system','2019-09-06 11:10:14','system','2019-09-06 11:10:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810003975221255','sms_provider','mobile',90,'mobile','varchar(45)','String','mobile','','','1','1','1','','EQ','input','0','system','2019-09-06 11:10:14','system','2019-09-06 11:10:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810004038135810','sms_provider','fax',100,'fax','varchar(45)','String','fax','','','1','1','1','','EQ','input','0','system','2019-09-06 11:10:14','system','2019-09-06 11:10:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810004038135811','sms_provider','address',110,'address','varchar(45)','String','address','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:10:14','system','2019-09-06 11:10:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810004071690241','sms_provider','zip',120,'zip','varchar(45)','String','zip','','','1','1','1','','EQ','input','0','system','2019-09-06 11:10:14','system','2019-09-06 11:10:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810004533063682','sms_provider','status',130,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:10:14','system','2019-09-06 11:10:19',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169810004541452290','sms_provider','create_by',140,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:10:14','system','2019-09-06 11:10:19',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810004545646593','sms_provider','create_time',150,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:10:14','system','2019-09-06 11:10:19',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810004554035202','sms_provider','update_by',160,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:10:14','system','2019-09-06 11:10:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810004562423809','sms_provider','update_time',170,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:10:14','system','2019-09-06 11:10:19',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810004562423810','sms_provider','remarks',180,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:10:14','system','2019-09-06 11:10:19',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169810087769026562','sms_signature_extno','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:10:34','system','2019-09-06 11:10:39',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810087769026563','sms_signature_extno','user_code',20,'用户编码','varchar(64)','String','userCode','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:10:34','system','2019-09-06 11:10:39',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810087769026564','sms_signature_extno','signature',30,'签名','varchar(64)','String','signature','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:10:34','system','2019-09-06 11:10:39',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810087794192385','sms_signature_extno','ext_number',40,'扩展号码','varchar(16)','String','extNumber','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:10:34','system','2019-09-06 11:10:39',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810087794192386','sms_signature_extno','status',50,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:10:34','system','2019-09-06 11:10:39',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169810087794192387','sms_signature_extno','create_by',60,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:10:34','system','2019-09-06 11:10:39',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810087982936065','sms_signature_extno','create_time',70,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:10:34','system','2019-09-06 11:10:39',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810087995518978','sms_signature_extno','update_by',80,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:10:34','system','2019-09-06 11:10:39',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810087995518979','sms_signature_extno','update_time',90,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:10:34','system','2019-09-06 11:10:39',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810087995518980','sms_signature_extno','remarks',100,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:10:34','system','2019-09-06 11:10:39',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169810179578146817','sms_submit_hour_report','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:10:55','system','2019-09-06 11:11:02',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810179582341122','sms_submit_hour_report','user_code',20,'用户编码','varchar(64)','String','userCode','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:10:55','system','2019-09-06 11:11:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810179590729729','sms_submit_hour_report','passage_id',30,'通道ID','int(11)','String','passageId','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:10:55','system','2019-09-06 11:11:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810179590729730','sms_submit_hour_report','province_code',40,'省份代码','int(4)','String','provinceCode','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:10:55','system','2019-09-06 11:11:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810179590729731','sms_submit_hour_report','submit_count',50,'提交数量','int(11)','String','submitCount','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:10:55','system','2019-09-06 11:11:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810179590729732','sms_submit_hour_report','bill_count',60,'计费数','int(11)','String','billCount','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:10:56','system','2019-09-06 11:11:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810179632672769','sms_submit_hour_report','unknown_count',70,'未知数量','int(11)','String','unknownCount','','','1','1','1','','EQ','input','0','system','2019-09-06 11:10:56','system','2019-09-06 11:11:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810179636867074','sms_submit_hour_report','success_count',80,'成功数量','int(11)','String','successCount','','','1','1','1','','EQ','input','0','system','2019-09-06 11:10:56','system','2019-09-06 11:11:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810179645255681','sms_submit_hour_report','submit_failed_count',90,'发送失败数量','int(11)','String','submitFailedCount','','','1','1','1','','EQ','input','0','system','2019-09-06 11:10:56','system','2019-09-06 11:11:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810179649449986','sms_submit_hour_report','other_count',100,'其他数量','int(11)','String','otherCount','','','1','1','1','','EQ','input','0','system','2019-09-06 11:10:56','system','2019-09-06 11:11:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810179657838593','sms_submit_hour_report','born_hours',110,'落地小时阀值','int(11)','String','bornHours','','','1','1','1','','EQ','input','0','system','2019-09-06 11:10:56','system','2019-09-06 11:11:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810179666227201','sms_submit_hour_report','hour_time',120,'当前小时毫秒数','bigint(20)','Long','hourTime','','','1','1','1','','EQ','input','0','system','2019-09-06 11:10:56','system','2019-09-06 11:11:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810179678810114','sms_submit_hour_report','status',130,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:10:56','system','2019-09-06 11:11:02',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169810179678810115','sms_submit_hour_report','create_by',140,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:10:56','system','2019-09-06 11:11:02',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810179678810116','sms_submit_hour_report','create_time',150,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:10:56','system','2019-09-06 11:11:02',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810179699781633','sms_submit_hour_report','update_by',160,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:10:56','system','2019-09-06 11:11:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810179708170242','sms_submit_hour_report','update_time',170,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:10:56','system','2019-09-06 11:11:02',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810179716558850','sms_submit_hour_report','remarks',180,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:10:56','system','2019-09-06 11:11:02',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169810477709275137','paas_passage_template','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:12:07','system','2019-09-06 11:12:13',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810477734440962','paas_passage_template','name',20,'模板名称','varchar(100)','String','name','','1','1','1','1','1','EQ','input','0','system','2019-09-06 11:12:07','system','2019-09-06 11:12:13',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810477734440963','paas_passage_template','protocol',30,'协议','varchar(32)','String','protocol','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:12:07','system','2019-09-06 11:12:13',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810477734440964','paas_passage_template','passage_type',40,'1-短信通道模板 2-流量通道模板 3-语音通道模板','tinyint(2)','String','passageType','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:12:07','system','2019-09-06 11:12:13',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810477734440965','paas_passage_template','status',50,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:12:07','system','2019-09-06 11:12:13',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169810477776384001','paas_passage_template','create_by',60,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:12:07','system','2019-09-06 11:12:13',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810477784772609','paas_passage_template','create_time',70,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:12:07','system','2019-09-06 11:12:13',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810477793161218','paas_passage_template','update_by',80,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:12:07','system','2019-09-06 11:12:13',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810477805744130','paas_passage_template','update_time',90,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:12:07','system','2019-09-06 11:12:13',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810477814132738','paas_passage_template','remarks',100,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:12:07','system','2019-09-06 11:12:13',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169810574815801346','paas_passage_template_detail','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:12:30','system','2019-09-06 11:12:34',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810574828384258','paas_passage_template_detail','template_id',20,'template_id','int(11)','String','templateId','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:12:30','system','2019-09-06 11:12:34',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810574836772865','paas_passage_template_detail','call_type',30,'1-发送 2-状态回执推送 3-状态回执自取 4-上行推送 5-上行自取','tinyint(2)','String','callType','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:12:30','system','2019-09-06 11:12:34',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810574845161473','paas_passage_template_detail','url',40,'url','varchar(255)','String','url','','','1','1','1','','EQ','input','0','system','2019-09-06 11:12:30','system','2019-09-06 11:12:34',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810574845161474','paas_passage_template_detail','params',50,'参数','varchar(1024)','String','params','','','1','1','1','','EQ','input','0','system','2019-09-06 11:12:30','system','2019-09-06 11:12:34',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810574845161475','paas_passage_template_detail','position',60,'具体值的位置，json存储','varchar(1024)','String','position','','','1','1','1','','EQ','input','0','system','2019-09-06 11:12:30','system','2019-09-06 11:12:34',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810574845161476','paas_passage_template_detail','result_format',70,'结果格式','varchar(255)','String','resultFormat','','','1','1','1','','EQ','input','0','system','2019-09-06 11:12:30','system','2019-09-06 11:12:34',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810574887104514','paas_passage_template_detail','success_code',80,'成功码标记','varchar(100)','String','successCode','','','1','1','1','','EQ','input','0','system','2019-09-06 11:12:30','system','2019-09-06 11:12:34',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810574895493121','paas_passage_template_detail','status',90,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:12:30','system','2019-09-06 11:12:34',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169810574903881730','paas_passage_template_detail','create_by',100,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:12:30','system','2019-09-06 11:12:34',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810574912270337','paas_passage_template_detail','create_time',110,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:12:30','system','2019-09-06 11:12:34',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810574933241857','paas_passage_template_detail','update_by',120,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:12:30','system','2019-09-06 11:12:34',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810574941630465','paas_passage_template_detail','update_time',130,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:12:30','system','2019-09-06 11:12:34',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810574958407682','paas_passage_template_detail','remarks',140,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:12:30','system','2019-09-06 11:12:34',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169810692273090561','paas_user_balance_log','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:12:58','system','2019-09-06 11:13:03',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810692583469058','paas_user_balance_log','user_code',20,'用户ID','varchar(64)','String','userCode','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:12:58','system','2019-09-06 11:13:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810692591857666','paas_user_balance_log','platform_type',30,'平台类型：1-短信，2-流量，3-语音','int(4)','String','platformType','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:12:58','system','2019-09-06 11:13:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810692596051969','paas_user_balance_log','balance',40,'充值额度','double(10,2)','String','balance','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:12:58','system','2019-09-06 11:13:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810692608634882','paas_user_balance_log','pay_source',50,'充值源,1:订单充值，2：账号额度划拨,3:系统续充,4:消费','int(4)','String','paySource','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:12:58','system','2019-09-06 11:13:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810692625412097','paas_user_balance_log','pay_type',60,'支付方式，1：账户转账，2:线下转账，3：支付宝，4：微信支付','int(4)','String','payType','','','1','1','1','','EQ','input','0','system','2019-09-06 11:12:58','system','2019-09-06 11:13:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810692633800706','paas_user_balance_log','order_no',70,'订单号','varchar(32)','String','orderNo','','','1','1','1','','EQ','input','0','system','2019-09-06 11:12:58','system','2019-09-06 11:13:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810692646383618','paas_user_balance_log','from_user_id',80,'划拨人ID','int(11)','String','fromUserId','','','1','1','1','','EQ','input','0','system','2019-09-06 11:12:58','system','2019-09-06 11:13:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810692654772226','paas_user_balance_log','price',90,'单价','double(10,2)','String','price','','','1','1','1','','EQ','input','0','system','2019-09-06 11:12:58','system','2019-09-06 11:13:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810692717686785','paas_user_balance_log','total_price',100,'总价','double(10,2)','String','totalPrice','','','1','1','1','','EQ','input','0','system','2019-09-06 11:12:58','system','2019-09-06 11:13:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810692717686786','paas_user_balance_log','status',110,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:12:58','system','2019-09-06 11:13:03',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169810692717686787','paas_user_balance_log','create_by',120,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:12:58','system','2019-09-06 11:13:03',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810692717686788','paas_user_balance_log','create_time',130,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:12:58','system','2019-09-06 11:13:03',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810692717686789','paas_user_balance_log','update_by',140,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:12:58','system','2019-09-06 11:13:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810692763824129','paas_user_balance_log','update_time',150,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:12:58','system','2019-09-06 11:13:03',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810692776407041','paas_user_balance_log','remarks',160,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:12:58','system','2019-09-06 11:13:03',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169810833075875842','paas_user_passage','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:13:31','system','2019-09-06 11:13:36',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810833075875843','paas_user_passage','user_code',20,'用户编码','varchar(64)','String','userCode','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:13:31','system','2019-09-06 11:13:36',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810833105235970','paas_user_passage','type',30,'类型 1-短信，2-流量，3-语音','int(4)','String','type','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:13:31','system','2019-09-06 11:13:36',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810833109430274','paas_user_passage','passage_group_id',40,'业务通道组ID，如短信通道组ID，流量通道组ID','int(11)','String','passageGroupId','','1','1','1','1','','EQ','input','0','system','2019-09-06 11:13:31','system','2019-09-06 11:13:36',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810833117818881','paas_user_passage','status',50,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 11:13:31','system','2019-09-06 11:13:36',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169810833126207489','paas_user_passage','create_by',60,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 11:13:31','system','2019-09-06 11:13:36',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810833134596097','paas_user_passage','create_time',70,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 11:13:31','system','2019-09-06 11:13:36',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810833134596098','paas_user_passage','update_by',80,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 11:13:31','system','2019-09-06 11:13:36',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810833155567618','paas_user_passage','update_time',90,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 11:13:31','system','2019-09-06 11:13:36',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169810833159761921','paas_user_passage','remarks',100,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 11:13:31','system','2019-09-06 11:13:36',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169811287730040833','sms_message_deliver','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 11:15:20','system','2019-09-06 11:15:24',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169811287742623745','sms_message_deliver','deliverStatus',20,'deliverStatus','int(11)','String','deliverstatus','','','1','1','1','1','EQ','input','0','system','2019-09-06 11:15:20','system','2019-09-06 11:15:24',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169811287742623746','sms_message_deliver','statusDes',30,'statusDes','varchar(500)','String','statusdes','','','1','1','1','','EQ','input','0','system','2019-09-06 11:15:20','system','2019-09-06 11:15:24',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169811287751012354','sms_message_deliver','deliverTimeStart',40,'deliverTimeStart','bigint(20)','Long','delivertimestart','','','1','1','1','','EQ','input','0','system','2019-09-06 11:15:20','system','2019-09-06 11:15:24',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169811287759400962','sms_message_deliver','deliverTimeEnd',50,'deliverTimeEnd','bigint(20)','Long','delivertimeend','','','1','1','1','','EQ','input','0','system','2019-09-06 11:15:20','system','2019-09-06 11:15:24',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169811287767789570','sms_message_deliver','httpTryTimes',60,'httpTryTimes','int(11)','String','httptrytimes','','','1','1','1','','EQ','input','0','system','2019-09-06 11:15:20','system','2019-09-06 11:15:24',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169892533843787777','paas_push_config','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 16:38:10','system','2019-09-06 16:38:22',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169892533952839682','paas_push_config','user_code',20,'用户编码','varchar(64)','String','userCode','','1','1','1','1','','EQ','input','0','system','2019-09-06 16:38:10','system','2019-09-06 16:38:22',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169892534036725761','paas_push_config','url',30,'状态报告地址/上行地址','varchar(256)','String','url','','','1','1','1','','EQ','input','0','system','2019-09-06 16:38:10','system','2019-09-06 16:38:22',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169892534078668801','paas_push_config','type',40,'类型 1:短信状态报告,2:短信上行回执报告,3:流量充值报告,4:语音发送报告','int(4)','String','type','','','1','1','1','','EQ','input','0','system','2019-09-06 16:38:10','system','2019-09-06 16:38:22',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169892534129000450','paas_push_config','retry_times',50,'重推次数','int(4)','String','retryTimes','','','1','1','1','','EQ','input','0','system','2019-09-06 16:38:10','system','2019-09-06 16:38:22',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169892534175137793','paas_push_config','status',60,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 16:38:10','system','2019-09-06 16:38:22',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169892534175137794','paas_push_config','create_by',70,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 16:38:10','system','2019-09-06 16:38:22',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169892534498099201','paas_push_config','create_time',80,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 16:38:10','system','2019-09-06 16:38:22',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169892535102078978','paas_push_config','update_by',90,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 16:38:11','system','2019-09-06 16:38:22',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169892535160799234','paas_push_config','update_time',100,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 16:38:11','system','2019-09-06 16:38:22',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169892535211130882','paas_push_config','remarks',110,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 16:38:11','system','2019-09-06 16:38:22',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}'),('1169895812636127233','paas_area_local','id',10,'id','varchar(64)','String','id','1','1','1','1','','','EQ','input','0','system','2019-09-06 16:51:12','system','2019-09-06 16:51:18',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169895812715819009','paas_area_local','area_code',20,'归属地代码','varchar(64)','String','areaCode','','1','1','1','1','','EQ','input','0','system','2019-09-06 16:51:12','system','2019-09-06 16:51:18',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169895812745179137','paas_area_local','number_area',30,'号段','varchar(32)','String','numberArea','','1','1','1','1','','EQ','input','0','system','2019-09-06 16:51:12','system','2019-09-06 16:51:18',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169895812761956354','paas_area_local','cmcp',40,'运营商','int(4)','String','cmcp','','1','1','1','1','','EQ','input','0','system','2019-09-06 16:51:12','system','2019-09-06 16:51:18',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169895812778733570','paas_area_local','status',50,'状态（0正常 1删除 2停用）','char(1)','String','status','','1','1','','1','1','EQ','radio','0','system','2019-09-06 16:51:12','system','2019-09-06 16:51:18',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"sys_status\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"sys_status\"}'),('1169895812795510785','paas_area_local','create_by',60,'创建者','varchar(64)','String','createBy','','','1','','','','EQ','input','0','system','2019-09-06 16:51:12','system','2019-09-06 16:51:18',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169895812812288001','paas_area_local','create_time',70,'创建时间','datetime','java.util.Date','createTime','','1','1','','','','EQ','datetime','0','system','2019-09-06 16:51:12','system','2019-09-06 16:51:18',NULL,'','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169895812812288002','paas_area_local','update_by',80,'更新者','varchar(64)','String','updateBy','','','1','','','','EQ','input','0','system','2019-09-06 16:51:12','system','2019-09-06 16:51:18',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169895812887785473','paas_area_local','update_time',90,'更新时间','datetime','java.util.Date','updateTime','','1','1','','1','','EQ','datetime','0','system','2019-09-06 16:51:12','system','2019-09-06 16:51:18',NULL,'1','{\"isNewLine\":\"\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"6/4/8\",\"dictType\":\"\"}'),('1169895812896174081','paas_area_local','remarks',100,'备注信息','varchar(500)','String','remarks','','','1','1','','','EQ','textarea','0','system','2019-09-06 16:51:12','system','2019-09-06 16:51:18',NULL,'1','{\"isNewLine\":\"1\",\"fieldValid\":\"\",\"dictName\":\"\",\"gridRowCol\":\"12/2/10\",\"dictType\":\"\"}');
/*!40000 ALTER TABLE `gen_table_column` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobs_info`
--

DROP TABLE IF EXISTS `jobs_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobs_info` (
  `id` varchar(64) NOT NULL COMMENT '主键ID',
  `app` varchar(100) NOT NULL COMMENT '服务名',
  `cron` varchar(100) NOT NULL COMMENT '任务执行CRON',
  `handler` varchar(255) DEFAULT NULL COMMENT '执行器任务handler',
  `param` varchar(512) DEFAULT NULL COMMENT '执行器任务参数',
  `timeout` int(11) NOT NULL DEFAULT '0' COMMENT '任务执行超时时间，单位秒',
  `fail_retry_count` int(11) NOT NULL DEFAULT '0' COMMENT '失败重试次数',
  `last_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '上次调度时间',
  `next_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '下次调度时间',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  `author` varchar(100) DEFAULT NULL COMMENT '负责人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobs_info`
--

LOCK TABLES `jobs_info` WRITE;
/*!40000 ALTER TABLE `jobs_info` DISABLE KEYS */;
INSERT INTO `jobs_info` VALUES ('1044886602248481472','jobs-executor-sample','0/10 * * * * ? *','demoJobHandler',NULL,30,3,0,0,'2','system','2019-08-19 14:30:34','system','2019-08-19 14:30:31','测试用例','test');
/*!40000 ALTER TABLE `jobs_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobs_lock`
--

DROP TABLE IF EXISTS `jobs_lock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobs_lock` (
  `id` varchar(64) NOT NULL COMMENT '主键ID',
  `name` varchar(30) NOT NULL COMMENT '名称',
  `owner` varchar(100) NOT NULL COMMENT '持有者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uidx_name` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务锁';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobs_lock`
--

LOCK TABLES `jobs_lock` WRITE;
/*!40000 ALTER TABLE `jobs_lock` DISABLE KEYS */;
/*!40000 ALTER TABLE `jobs_lock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobs_log`
--

DROP TABLE IF EXISTS `jobs_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobs_log` (
  `id` varchar(64) NOT NULL COMMENT '主键ID',
  `job_id` varchar(64) NOT NULL COMMENT '任务ID',
  `address` varchar(255) DEFAULT NULL COMMENT '执行地址',
  `handler` varchar(255) NOT NULL COMMENT '任务 handler',
  `param` varchar(512) DEFAULT NULL COMMENT '任务参数',
  `fail_retry_count` int(11) NOT NULL DEFAULT '0' COMMENT '失败重试次数',
  `trigger_code` int(11) NOT NULL DEFAULT '0' COMMENT '触发器调度返回码',
  `trigger_type` varchar(30) NOT NULL COMMENT '触发器调度类型',
  `trigger_msg` text COMMENT '触发器调度返回信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务调度日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobs_log`
--

LOCK TABLES `jobs_log` WRITE;
/*!40000 ALTER TABLE `jobs_log` DISABLE KEYS */;
INSERT INTO `jobs_log` VALUES ('1165856340130930690','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,-1,'Cron触发','com.tangdao.jobs.exception.JobsRpcException: io.netty.channel.AbstractChannel$AnnotatedConnectException: Connection refused: no further information: /172.28.220.60:9999\r\n	at com.tangdao.jobs.rpc.remoting.invoker.reference.JobsRpcReferenceBean.lambda$getObject$0(JobsRpcReferenceBean.java:222)\r\n	at com.sun.proxy.$Proxy132.run(Unknown Source)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.runExecutor(JobsTrigger.java:145)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.processTrigger(JobsTrigger.java:84)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.trigger(JobsTrigger.java:49)\r\n	at com.tangdao.jobs.disruptor.JobsEventHandler.onEvent(JobsEventHandler.java:35)\r\n	at com.tangdao.jobs.disruptor.JobsEventHandler.onEvent(JobsEventHandler.java:18)\r\n	at com.lmax.disruptor.BatchEventProcessor.processEvents(BatchEventProcessor.java:168)\r\n	at com.lmax.disruptor.BatchEventProcessor.run(BatchEventProcessor.java:125)\r\n	at java.lang.Thread.run(Thread.java:748)\r\nCaused by: io.netty.channel.AbstractChannel$AnnotatedConnectException: Connection refused: no further information: /172.28.220.60:9999\r\n	at sun.nio.ch.SocketChannelImpl.checkConnect(Native Method)\r\n	at sun.nio.ch.SocketChannelImpl.finishConnect(SocketChannelImpl.java:717)\r\n	at io.netty.channel.socket.nio.NioSocketChannel.doFinishConnect(NioSocketChannel.java:327)\r\n	at io.netty.channel.nio.AbstractNioChannel$AbstractNioUnsafe.finishConnect(AbstractNioChannel.java:340)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:636)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:583)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:500)\r\n	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:462)\r\n	at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:897)\r\n	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)\r\n	... 1 more\r\nCaused by: java.net.ConnectException: Connection refused: no further information\r\n	... 11 more\r\n','2019-08-26 13:19:40'),('1165856371256860674','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,-1,'Cron触发','com.tangdao.jobs.exception.JobsRpcException: io.netty.channel.AbstractChannel$AnnotatedConnectException: Connection refused: no further information: /172.28.220.60:9999\r\n	at com.tangdao.jobs.rpc.remoting.invoker.reference.JobsRpcReferenceBean.lambda$getObject$0(JobsRpcReferenceBean.java:222)\r\n	at com.sun.proxy.$Proxy132.run(Unknown Source)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.runExecutor(JobsTrigger.java:145)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.processTrigger(JobsTrigger.java:84)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.trigger(JobsTrigger.java:49)\r\n	at com.tangdao.jobs.disruptor.JobsEventHandler.onEvent(JobsEventHandler.java:35)\r\n	at com.tangdao.jobs.disruptor.JobsEventHandler.onEvent(JobsEventHandler.java:18)\r\n	at com.lmax.disruptor.BatchEventProcessor.processEvents(BatchEventProcessor.java:168)\r\n	at com.lmax.disruptor.BatchEventProcessor.run(BatchEventProcessor.java:125)\r\n	at java.lang.Thread.run(Thread.java:748)\r\nCaused by: io.netty.channel.AbstractChannel$AnnotatedConnectException: Connection refused: no further information: /172.28.220.60:9999\r\n	at sun.nio.ch.SocketChannelImpl.checkConnect(Native Method)\r\n	at sun.nio.ch.SocketChannelImpl.finishConnect(SocketChannelImpl.java:717)\r\n	at io.netty.channel.socket.nio.NioSocketChannel.doFinishConnect(NioSocketChannel.java:327)\r\n	at io.netty.channel.nio.AbstractNioChannel$AbstractNioUnsafe.finishConnect(AbstractNioChannel.java:340)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:636)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:583)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:500)\r\n	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:462)\r\n	at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:897)\r\n	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)\r\n	... 1 more\r\nCaused by: java.net.ConnectException: Connection refused: no further information\r\n	... 11 more\r\n','2019-08-26 13:19:50'),('1165856413397032961','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,-1,'Cron触发','com.tangdao.jobs.exception.JobsRpcException: io.netty.channel.AbstractChannel$AnnotatedConnectException: Connection refused: no further information: /172.28.220.60:9999\r\n	at com.tangdao.jobs.rpc.remoting.invoker.reference.JobsRpcReferenceBean.lambda$getObject$0(JobsRpcReferenceBean.java:222)\r\n	at com.sun.proxy.$Proxy132.run(Unknown Source)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.runExecutor(JobsTrigger.java:145)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.processTrigger(JobsTrigger.java:84)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.trigger(JobsTrigger.java:49)\r\n	at com.tangdao.jobs.disruptor.JobsEventHandler.onEvent(JobsEventHandler.java:35)\r\n	at com.tangdao.jobs.disruptor.JobsEventHandler.onEvent(JobsEventHandler.java:18)\r\n	at com.lmax.disruptor.BatchEventProcessor.processEvents(BatchEventProcessor.java:168)\r\n	at com.lmax.disruptor.BatchEventProcessor.run(BatchEventProcessor.java:125)\r\n	at java.lang.Thread.run(Thread.java:748)\r\nCaused by: io.netty.channel.AbstractChannel$AnnotatedConnectException: Connection refused: no further information: /172.28.220.60:9999\r\n	at sun.nio.ch.SocketChannelImpl.checkConnect(Native Method)\r\n	at sun.nio.ch.SocketChannelImpl.finishConnect(SocketChannelImpl.java:717)\r\n	at io.netty.channel.socket.nio.NioSocketChannel.doFinishConnect(NioSocketChannel.java:327)\r\n	at io.netty.channel.nio.AbstractNioChannel$AbstractNioUnsafe.finishConnect(AbstractNioChannel.java:340)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:636)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:583)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:500)\r\n	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:462)\r\n	at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:897)\r\n	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)\r\n	... 1 more\r\nCaused by: java.net.ConnectException: Connection refused: no further information\r\n	... 11 more\r\n','2019-08-26 13:20:00'),('1165856455197466626','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,-1,'Cron触发','com.tangdao.jobs.exception.JobsRpcException: io.netty.channel.AbstractChannel$AnnotatedConnectException: Connection refused: no further information: /172.28.220.60:9999\r\n	at com.tangdao.jobs.rpc.remoting.invoker.reference.JobsRpcReferenceBean.lambda$getObject$0(JobsRpcReferenceBean.java:222)\r\n	at com.sun.proxy.$Proxy132.run(Unknown Source)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.runExecutor(JobsTrigger.java:145)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.processTrigger(JobsTrigger.java:84)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.trigger(JobsTrigger.java:49)\r\n	at com.tangdao.jobs.disruptor.JobsEventHandler.onEvent(JobsEventHandler.java:35)\r\n	at com.tangdao.jobs.disruptor.JobsEventHandler.onEvent(JobsEventHandler.java:18)\r\n	at com.lmax.disruptor.BatchEventProcessor.processEvents(BatchEventProcessor.java:168)\r\n	at com.lmax.disruptor.BatchEventProcessor.run(BatchEventProcessor.java:125)\r\n	at java.lang.Thread.run(Thread.java:748)\r\nCaused by: io.netty.channel.AbstractChannel$AnnotatedConnectException: Connection refused: no further information: /172.28.220.60:9999\r\n	at sun.nio.ch.SocketChannelImpl.checkConnect(Native Method)\r\n	at sun.nio.ch.SocketChannelImpl.finishConnect(SocketChannelImpl.java:717)\r\n	at io.netty.channel.socket.nio.NioSocketChannel.doFinishConnect(NioSocketChannel.java:327)\r\n	at io.netty.channel.nio.AbstractNioChannel$AbstractNioUnsafe.finishConnect(AbstractNioChannel.java:340)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:636)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:583)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:500)\r\n	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:462)\r\n	at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:897)\r\n	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)\r\n	... 1 more\r\nCaused by: java.net.ConnectException: Connection refused: no further information\r\n	... 11 more\r\n','2019-08-26 13:20:10'),('1165856497127923713','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,-1,'Cron触发','com.tangdao.jobs.exception.JobsRpcException: io.netty.channel.AbstractChannel$AnnotatedConnectException: Connection refused: no further information: /172.28.220.60:9999\r\n	at com.tangdao.jobs.rpc.remoting.invoker.reference.JobsRpcReferenceBean.lambda$getObject$0(JobsRpcReferenceBean.java:222)\r\n	at com.sun.proxy.$Proxy132.run(Unknown Source)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.runExecutor(JobsTrigger.java:145)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.processTrigger(JobsTrigger.java:84)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.trigger(JobsTrigger.java:49)\r\n	at com.tangdao.jobs.disruptor.JobsEventHandler.onEvent(JobsEventHandler.java:35)\r\n	at com.tangdao.jobs.disruptor.JobsEventHandler.onEvent(JobsEventHandler.java:18)\r\n	at com.lmax.disruptor.BatchEventProcessor.processEvents(BatchEventProcessor.java:168)\r\n	at com.lmax.disruptor.BatchEventProcessor.run(BatchEventProcessor.java:125)\r\n	at java.lang.Thread.run(Thread.java:748)\r\nCaused by: io.netty.channel.AbstractChannel$AnnotatedConnectException: Connection refused: no further information: /172.28.220.60:9999\r\n	at sun.nio.ch.SocketChannelImpl.checkConnect(Native Method)\r\n	at sun.nio.ch.SocketChannelImpl.finishConnect(SocketChannelImpl.java:717)\r\n	at io.netty.channel.socket.nio.NioSocketChannel.doFinishConnect(NioSocketChannel.java:327)\r\n	at io.netty.channel.nio.AbstractNioChannel$AbstractNioUnsafe.finishConnect(AbstractNioChannel.java:340)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:636)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:583)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:500)\r\n	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:462)\r\n	at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:897)\r\n	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)\r\n	... 1 more\r\nCaused by: java.net.ConnectException: Connection refused: no further information\r\n	... 11 more\r\n','2019-08-26 13:20:20'),('1165856533299601410','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-26 13:20:30'),('1165856563909632002','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-26 13:20:40'),('1165856606091747330','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-26 13:20:50'),('1165856647720214530','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-26 13:21:00'),('1165856689650671618','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-26 13:21:10'),('1165856731648237570','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-26 13:21:20'),('1165856773763244033','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-26 13:21:30'),('1165856815521734658','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-26 13:21:40'),('1165856857749987330','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-26 13:21:50'),('1165856899634307074','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-26 13:22:00'),('1166245479670132738','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,-1,'Cron触发','com.tangdao.jobs.exception.JobsRpcException: io.netty.channel.AbstractChannel$AnnotatedConnectException: Connection refused: no further information: /172.28.220.60:9999\r\n	at com.tangdao.jobs.rpc.remoting.invoker.reference.JobsRpcReferenceBean.lambda$0(JobsRpcReferenceBean.java:222)\r\n	at com.sun.proxy.$Proxy133.run(Unknown Source)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.runExecutor(JobsTrigger.java:145)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.processTrigger(JobsTrigger.java:84)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.trigger(JobsTrigger.java:49)\r\n	at com.tangdao.jobs.disruptor.JobsEventHandler.onEvent(JobsEventHandler.java:35)\r\n	at com.tangdao.jobs.disruptor.JobsEventHandler.onEvent(JobsEventHandler.java:1)\r\n	at com.lmax.disruptor.BatchEventProcessor.processEvents(BatchEventProcessor.java:168)\r\n	at com.lmax.disruptor.BatchEventProcessor.run(BatchEventProcessor.java:125)\r\n	at java.lang.Thread.run(Thread.java:748)\r\nCaused by: io.netty.channel.AbstractChannel$AnnotatedConnectException: Connection refused: no further information: /172.28.220.60:9999\r\n	at sun.nio.ch.SocketChannelImpl.checkConnect(Native Method)\r\n	at sun.nio.ch.SocketChannelImpl.finishConnect(SocketChannelImpl.java:717)\r\n	at io.netty.channel.socket.nio.NioSocketChannel.doFinishConnect(NioSocketChannel.java:327)\r\n	at io.netty.channel.nio.AbstractNioChannel$AbstractNioUnsafe.finishConnect(AbstractNioChannel.java:340)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:636)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:583)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:500)\r\n	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:462)\r\n	at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:897)\r\n	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)\r\n	... 1 more\r\nCaused by: java.net.ConnectException: Connection refused: no further information\r\n	... 11 more\r\n','2019-08-27 15:06:01'),('1166245520942084098','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,-1,'Cron触发','com.tangdao.jobs.exception.JobsRpcException: io.netty.channel.AbstractChannel$AnnotatedConnectException: Connection refused: no further information: /172.28.220.60:9999\r\n	at com.tangdao.jobs.rpc.remoting.invoker.reference.JobsRpcReferenceBean.lambda$0(JobsRpcReferenceBean.java:222)\r\n	at com.sun.proxy.$Proxy133.run(Unknown Source)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.runExecutor(JobsTrigger.java:145)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.processTrigger(JobsTrigger.java:84)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.trigger(JobsTrigger.java:49)\r\n	at com.tangdao.jobs.disruptor.JobsEventHandler.onEvent(JobsEventHandler.java:35)\r\n	at com.tangdao.jobs.disruptor.JobsEventHandler.onEvent(JobsEventHandler.java:1)\r\n	at com.lmax.disruptor.BatchEventProcessor.processEvents(BatchEventProcessor.java:168)\r\n	at com.lmax.disruptor.BatchEventProcessor.run(BatchEventProcessor.java:125)\r\n	at java.lang.Thread.run(Thread.java:748)\r\nCaused by: io.netty.channel.AbstractChannel$AnnotatedConnectException: Connection refused: no further information: /172.28.220.60:9999\r\n	at sun.nio.ch.SocketChannelImpl.checkConnect(Native Method)\r\n	at sun.nio.ch.SocketChannelImpl.finishConnect(SocketChannelImpl.java:717)\r\n	at io.netty.channel.socket.nio.NioSocketChannel.doFinishConnect(NioSocketChannel.java:327)\r\n	at io.netty.channel.nio.AbstractNioChannel$AbstractNioUnsafe.finishConnect(AbstractNioChannel.java:340)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:636)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:583)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:500)\r\n	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:462)\r\n	at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:897)\r\n	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)\r\n	... 1 more\r\nCaused by: java.net.ConnectException: Connection refused: no further information\r\n	... 11 more\r\n','2019-08-27 15:06:11'),('1166245562780266498','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,-1,'Cron触发','com.tangdao.jobs.exception.JobsRpcException: io.netty.channel.AbstractChannel$AnnotatedConnectException: Connection refused: no further information: /172.28.220.60:9999\r\n	at com.tangdao.jobs.rpc.remoting.invoker.reference.JobsRpcReferenceBean.lambda$0(JobsRpcReferenceBean.java:222)\r\n	at com.sun.proxy.$Proxy133.run(Unknown Source)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.runExecutor(JobsTrigger.java:145)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.processTrigger(JobsTrigger.java:84)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.trigger(JobsTrigger.java:49)\r\n	at com.tangdao.jobs.disruptor.JobsEventHandler.onEvent(JobsEventHandler.java:35)\r\n	at com.tangdao.jobs.disruptor.JobsEventHandler.onEvent(JobsEventHandler.java:1)\r\n	at com.lmax.disruptor.BatchEventProcessor.processEvents(BatchEventProcessor.java:168)\r\n	at com.lmax.disruptor.BatchEventProcessor.run(BatchEventProcessor.java:125)\r\n	at java.lang.Thread.run(Thread.java:748)\r\nCaused by: io.netty.channel.AbstractChannel$AnnotatedConnectException: Connection refused: no further information: /172.28.220.60:9999\r\n	at sun.nio.ch.SocketChannelImpl.checkConnect(Native Method)\r\n	at sun.nio.ch.SocketChannelImpl.finishConnect(SocketChannelImpl.java:717)\r\n	at io.netty.channel.socket.nio.NioSocketChannel.doFinishConnect(NioSocketChannel.java:327)\r\n	at io.netty.channel.nio.AbstractNioChannel$AbstractNioUnsafe.finishConnect(AbstractNioChannel.java:340)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:636)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:583)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:500)\r\n	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:462)\r\n	at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:897)\r\n	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)\r\n	... 1 more\r\nCaused by: java.net.ConnectException: Connection refused: no further information\r\n	... 11 more\r\n','2019-08-27 15:06:20'),('1166245605239205889','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,-1,'Cron触发','com.tangdao.jobs.exception.JobsRpcException: io.netty.channel.AbstractChannel$AnnotatedConnectException: Connection refused: no further information: /172.28.220.60:9999\r\n	at com.tangdao.jobs.rpc.remoting.invoker.reference.JobsRpcReferenceBean.lambda$0(JobsRpcReferenceBean.java:222)\r\n	at com.sun.proxy.$Proxy133.run(Unknown Source)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.runExecutor(JobsTrigger.java:145)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.processTrigger(JobsTrigger.java:84)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.trigger(JobsTrigger.java:49)\r\n	at com.tangdao.jobs.disruptor.JobsEventHandler.onEvent(JobsEventHandler.java:35)\r\n	at com.tangdao.jobs.disruptor.JobsEventHandler.onEvent(JobsEventHandler.java:1)\r\n	at com.lmax.disruptor.BatchEventProcessor.processEvents(BatchEventProcessor.java:168)\r\n	at com.lmax.disruptor.BatchEventProcessor.run(BatchEventProcessor.java:125)\r\n	at java.lang.Thread.run(Thread.java:748)\r\nCaused by: io.netty.channel.AbstractChannel$AnnotatedConnectException: Connection refused: no further information: /172.28.220.60:9999\r\n	at sun.nio.ch.SocketChannelImpl.checkConnect(Native Method)\r\n	at sun.nio.ch.SocketChannelImpl.finishConnect(SocketChannelImpl.java:717)\r\n	at io.netty.channel.socket.nio.NioSocketChannel.doFinishConnect(NioSocketChannel.java:327)\r\n	at io.netty.channel.nio.AbstractNioChannel$AbstractNioUnsafe.finishConnect(AbstractNioChannel.java:340)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:636)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:583)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:500)\r\n	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:462)\r\n	at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:897)\r\n	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)\r\n	... 1 more\r\nCaused by: java.net.ConnectException: Connection refused: no further information\r\n	... 11 more\r\n','2019-08-27 15:06:31'),('1166245646641180674','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,-1,'Cron触发','com.tangdao.jobs.exception.JobsRpcException: io.netty.channel.AbstractChannel$AnnotatedConnectException: Connection refused: no further information: /172.28.220.60:9999\r\n	at com.tangdao.jobs.rpc.remoting.invoker.reference.JobsRpcReferenceBean.lambda$0(JobsRpcReferenceBean.java:222)\r\n	at com.sun.proxy.$Proxy133.run(Unknown Source)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.runExecutor(JobsTrigger.java:145)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.processTrigger(JobsTrigger.java:84)\r\n	at com.tangdao.jobs.trigger.JobsTrigger.trigger(JobsTrigger.java:49)\r\n	at com.tangdao.jobs.disruptor.JobsEventHandler.onEvent(JobsEventHandler.java:35)\r\n	at com.tangdao.jobs.disruptor.JobsEventHandler.onEvent(JobsEventHandler.java:1)\r\n	at com.lmax.disruptor.BatchEventProcessor.processEvents(BatchEventProcessor.java:168)\r\n	at com.lmax.disruptor.BatchEventProcessor.run(BatchEventProcessor.java:125)\r\n	at java.lang.Thread.run(Thread.java:748)\r\nCaused by: io.netty.channel.AbstractChannel$AnnotatedConnectException: Connection refused: no further information: /172.28.220.60:9999\r\n	at sun.nio.ch.SocketChannelImpl.checkConnect(Native Method)\r\n	at sun.nio.ch.SocketChannelImpl.finishConnect(SocketChannelImpl.java:717)\r\n	at io.netty.channel.socket.nio.NioSocketChannel.doFinishConnect(NioSocketChannel.java:327)\r\n	at io.netty.channel.nio.AbstractNioChannel$AbstractNioUnsafe.finishConnect(AbstractNioChannel.java:340)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:636)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:583)\r\n	at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:500)\r\n	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:462)\r\n	at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:897)\r\n	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)\r\n	... 1 more\r\nCaused by: java.net.ConnectException: Connection refused: no further information\r\n	... 11 more\r\n','2019-08-27 15:06:41'),('1166245673669275649','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-27 15:06:50'),('1166245713250922498','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-27 15:07:00'),('1166245755223322625','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-27 15:07:11'),('1166245797757759489','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-27 15:07:21'),('1166245922890625025','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-27 15:07:50'),('1166245965014020097','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-27 15:08:01'),('1166246006835425282','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-27 15:08:10'),('1166246048807825409','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-27 15:08:20'),('1166246090755059714','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-27 15:08:30'),('1166246132626796546','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-27 15:08:40'),('1166246174779551746','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-27 15:08:51'),('1166246216550625282','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-27 15:09:00'),('1166246258854375425','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-27 15:09:11'),('1166246300667392002','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-27 15:09:21'),('1166246342413299714','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-27 15:09:30'),('1166246384897404930','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-27 15:09:41'),('1166246426240659458','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-27 15:09:50'),('1166246468204670977','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-27 15:10:00'),('1166246510147710977','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-27 15:10:10'),('1166246552237551617','1044886602248481472','172.28.220.60:9999','demoJobHandler',NULL,0,0,'Cron触发','执行成功','2019-08-27 15:10:21');
/*!40000 ALTER TABLE `jobs_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobs_registry`
--

DROP TABLE IF EXISTS `jobs_registry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobs_registry` (
  `id` varchar(64) NOT NULL COMMENT '主键 ID',
  `app` varchar(100) NOT NULL COMMENT '服务名',
  `address` varchar(100) NOT NULL COMMENT 'IP 地址',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态',
  `update_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务注册信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobs_registry`
--

LOCK TABLES `jobs_registry` WRITE;
/*!40000 ALTER TABLE `jobs_registry` DISABLE KEYS */;
INSERT INTO `jobs_registry` VALUES ('1163374485230125057','jobs-executor-sample','172.28.220.60:9999','0','2019-08-29 09:10:17');
/*!40000 ALTER TABLE `jobs_registry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paas_area_local`
--

DROP TABLE IF EXISTS `paas_area_local`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paas_area_local` (
  `id` varchar(64) NOT NULL,
  `area_code` varchar(64) NOT NULL COMMENT '归属地代码',
  `number_area` varchar(32) NOT NULL COMMENT '号段',
  `cmcp` int(4) NOT NULL COMMENT '运营商',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='号码归属地';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paas_area_local`
--

LOCK TABLES `paas_area_local` WRITE;
/*!40000 ALTER TABLE `paas_area_local` DISABLE KEYS */;
/*!40000 ALTER TABLE `paas_area_local` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paas_host_whitelist`
--

DROP TABLE IF EXISTS `paas_host_whitelist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paas_host_whitelist` (
  `id` varchar(64) NOT NULL DEFAULT '',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态 默认0',
  `ip` varchar(16) CHARACTER SET utf8 NOT NULL,
  `user_code` varchar(64) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(100) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='白名单信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paas_host_whitelist`
--

LOCK TABLES `paas_host_whitelist` WRITE;
/*!40000 ALTER TABLE `paas_host_whitelist` DISABLE KEYS */;
/*!40000 ALTER TABLE `paas_host_whitelist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paas_passage_template`
--

DROP TABLE IF EXISTS `paas_passage_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paas_passage_template` (
  `id` varchar(64) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT '模板名称',
  `protocol` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '协议',
  `passage_type` tinyint(2) NOT NULL COMMENT '1-短信通道模板 2-流量通道模板 3-语音通道模板',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='通道模板';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paas_passage_template`
--

LOCK TABLES `paas_passage_template` WRITE;
/*!40000 ALTER TABLE `paas_passage_template` DISABLE KEYS */;
/*!40000 ALTER TABLE `paas_passage_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paas_passage_template_detail`
--

DROP TABLE IF EXISTS `paas_passage_template_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paas_passage_template_detail` (
  `id` varchar(64) NOT NULL,
  `template_id` int(11) NOT NULL,
  `call_type` tinyint(2) NOT NULL COMMENT '1-发送 2-状态回执推送 3-状态回执自取 4-上行推送 5-上行自取',
  `url` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT 'url',
  `params` varchar(1024) CHARACTER SET utf8 DEFAULT NULL COMMENT '参数',
  `position` varchar(1024) CHARACTER SET utf8 DEFAULT NULL COMMENT '具体值的位置，json存储',
  `result_format` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '结果格式',
  `success_code` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '成功码标记',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='通道模板内容';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paas_passage_template_detail`
--

LOCK TABLES `paas_passage_template_detail` WRITE;
/*!40000 ALTER TABLE `paas_passage_template_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `paas_passage_template_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paas_push_config`
--

DROP TABLE IF EXISTS `paas_push_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paas_push_config` (
  `id` varchar(64) NOT NULL,
  `user_code` varchar(64) NOT NULL COMMENT '用户编码',
  `url` varchar(256) CHARACTER SET utf8 DEFAULT NULL COMMENT '状态报告地址/上行地址',
  `type` int(4) DEFAULT NULL COMMENT '类型 1:短信状态报告,2:短信上行回执报告,3:流量充值报告,4:语音发送报告',
  `retry_times` int(4) DEFAULT '3' COMMENT '重推次数',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `idx_push_config_1` (`user_code`,`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='推送配置信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paas_push_config`
--

LOCK TABLES `paas_push_config` WRITE;
/*!40000 ALTER TABLE `paas_push_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `paas_push_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paas_user_balance`
--

DROP TABLE IF EXISTS `paas_user_balance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paas_user_balance` (
  `id` varchar(64) NOT NULL,
  `user_code` varchar(64) NOT NULL COMMENT '用户id',
  `type` int(4) NOT NULL COMMENT '类型 默认0：1短信，2:流量，3语音',
  `balance` double(10,2) NOT NULL COMMENT '金额或者条数',
  `pay_type` int(4) DEFAULT '1' COMMENT '1：预付费， 2：后付费',
  `threshold` int(10) DEFAULT NULL COMMENT '告警阀值（小于等于此值告警）',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '告警状态,0:正常，1：告警',
  `mobile` varchar(64) DEFAULT NULL COMMENT '告警手机号码',
  `remarks` varchar(555) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(100) DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `indx_user_balance_usercode` (`user_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户余额信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paas_user_balance`
--

LOCK TABLES `paas_user_balance` WRITE;
/*!40000 ALTER TABLE `paas_user_balance` DISABLE KEYS */;
INSERT INTO `paas_user_balance` VALUES ('1','admin',1,990.00,1,1,'0',NULL,'developer call','2019-09-05 16:18:40','2019-09-05 16:43:42',NULL,NULL);
/*!40000 ALTER TABLE `paas_user_balance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paas_user_balance_log`
--

DROP TABLE IF EXISTS `paas_user_balance_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paas_user_balance_log` (
  `id` varchar(64) NOT NULL,
  `user_code` varchar(64) NOT NULL COMMENT '用户ID',
  `platform_type` int(4) NOT NULL COMMENT '平台类型：1-短信，2-流量，3-语音',
  `balance` double(10,2) NOT NULL COMMENT '充值额度',
  `pay_source` int(4) NOT NULL COMMENT '充值源,1:订单充值，2：账号额度划拨,3:系统续充,4:消费',
  `pay_type` int(4) DEFAULT NULL COMMENT '支付方式，1：账户转账，2:线下转账，3：支付宝，4：微信支付',
  `order_no` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '订单号',
  `from_user_id` int(11) DEFAULT NULL COMMENT '划拨人ID',
  `price` double(10,2) DEFAULT NULL COMMENT '单价',
  `total_price` double(10,2) DEFAULT NULL COMMENT '总价',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户余额日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paas_user_balance_log`
--

LOCK TABLES `paas_user_balance_log` WRITE;
/*!40000 ALTER TABLE `paas_user_balance_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `paas_user_balance_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paas_user_developer`
--

DROP TABLE IF EXISTS `paas_user_developer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paas_user_developer` (
  `id` varchar(64) NOT NULL,
  `user_code` varchar(64) NOT NULL COMMENT '用户编号',
  `app_key` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT 'app_key',
  `app_secret` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT 'app_secret',
  `salt` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '随机盐',
  `status` varchar(1) DEFAULT '0' COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `remarks` varchar(500) DEFAULT NULL,
  `create_by` varchar(100) DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_developer_appkey` (`app_key`),
  KEY `idx_developer_userid_status` (`user_code`,`status`),
  KEY `idx_developer_appkey_status` (`app_key`,`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户开发者授权';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paas_user_developer`
--

LOCK TABLES `paas_user_developer` WRITE;
/*!40000 ALTER TABLE `paas_user_developer` DISABLE KEYS */;
INSERT INTO `paas_user_developer` VALUES ('1','admin','abcd','1234','1','0','2019-09-05 14:01:42','2019-09-05 14:01:46',NULL,NULL,NULL);
/*!40000 ALTER TABLE `paas_user_developer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paas_user_passage`
--

DROP TABLE IF EXISTS `paas_user_passage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paas_user_passage` (
  `id` varchar(64) NOT NULL,
  `user_code` varchar(64) NOT NULL COMMENT '用户编码',
  `type` int(4) NOT NULL COMMENT '类型 1-短信，2-流量，3-语音',
  `passage_group_id` int(11) NOT NULL COMMENT '业务通道组ID，如短信通道组ID，流量通道组ID',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `idx_user_passage_1` (`user_code`,`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户通道配置';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paas_user_passage`
--

LOCK TABLES `paas_user_passage` WRITE;
/*!40000 ALTER TABLE `paas_user_passage` DISABLE KEYS */;
/*!40000 ALTER TABLE `paas_user_passage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paas_user_sms_config`
--

DROP TABLE IF EXISTS `paas_user_sms_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paas_user_sms_config` (
  `id` varchar(64) NOT NULL,
  `user_code` varchar(64) NOT NULL COMMENT '用户ID',
  `sms_words` int(4) NOT NULL DEFAULT '70' COMMENT '每条计费字数',
  `sms_return_rule` int(4) DEFAULT '0' COMMENT '短信返还规则，0:不返还，1：失败自动返还，2：超时未回执返还；',
  `sms_timeout` bigint(20) DEFAULT NULL COMMENT '短信超时时间（毫秒）',
  `message_pass` tinyint(1) DEFAULT '1' COMMENT '短信内容免审核，1：需要审核，0：不需要',
  `need_template` tinyint(1) DEFAULT '1' COMMENT '是否需要报备模板，1：需要，0：不需要',
  `auto_template` tinyint(1) DEFAULT '0' COMMENT '自动提取短信模板,0-不提取，1-提取',
  `signature_source` int(4) NOT NULL DEFAULT '0' COMMENT '签名途径，0：自维护，1：系统强制',
  `signature_content` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '签名内容',
  `ext_number` varchar(32) DEFAULT NULL COMMENT '扩展号码',
  `submit_interval` int(8) DEFAULT '30' COMMENT '短信提交时间间隔（同一号码）',
  `limit_times` int(8) DEFAULT '10' COMMENT '短信每天提交次数上限（同一号码）',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  `user_developer_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_sms_config_usercode` (`user_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户短信配置';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paas_user_sms_config`
--

LOCK TABLES `paas_user_sms_config` WRITE;
/*!40000 ALTER TABLE `paas_user_sms_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `paas_user_sms_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_api_failed_record`
--

DROP TABLE IF EXISTS `sms_api_failed_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_api_failed_record` (
  `id` varchar(64) NOT NULL,
  `user_code` varchar(64) NOT NULL COMMENT '用户编码',
  `app_type` tinyint(2) unsigned DEFAULT '2' COMMENT '调用类型 1:融合WEB平台,2:开发者平台,3:运营支撑系统',
  `submit_type` tinyint(2) DEFAULT '1' COMMENT '请求类型 1 短信发送 2 余额查询 3 通道测试',
  `app_key` varchar(45) CHARACTER SET utf8 DEFAULT NULL COMMENT '接口账号',
  `app_secret` varchar(45) CHARACTER SET utf8 DEFAULT NULL COMMENT '接口密码',
  `mobile` varchar(6144) CHARACTER SET utf8 DEFAULT NULL COMMENT '手机号',
  `timestamps` varchar(45) CHARACTER SET utf8 DEFAULT NULL COMMENT '提交时间戳',
  `content` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ext_number` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '拓展号码',
  `attach` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '自定义内容',
  `callback` varchar(256) CHARACTER SET utf8 DEFAULT NULL COMMENT '回调URL（选填）',
  `submit_url` varchar(256) CHARACTER SET utf8 NOT NULL COMMENT '程序调用URL',
  `ip` varchar(45) CHARACTER SET utf8 DEFAULT NULL COMMENT '提交IP',
  `resp_code` varchar(2048) CHARACTER SET utf8 NOT NULL COMMENT '错误码',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `idx_dst_mobile` (`mobile`(255)),
  KEY `idx_create_time` (`create_time`),
  KEY `idx_ip` (`ip`),
  KEY `idx_app_key` (`app_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='mt下行失败短信';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_api_failed_record`
--

LOCK TABLES `sms_api_failed_record` WRITE;
/*!40000 ALTER TABLE `sms_api_failed_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_api_failed_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_forbidden_words`
--

DROP TABLE IF EXISTS `sms_forbidden_words`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_forbidden_words` (
  `id` varchar(64) NOT NULL,
  `word` varchar(64) NOT NULL COMMENT '敏感词',
  `level` int(2) DEFAULT NULL COMMENT '告警级别，区分颜色',
  `label` varchar(32) DEFAULT NULL COMMENT '标签',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_sms_forbidden_words` (`word`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='关键字';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_forbidden_words`
--

LOCK TABLES `sms_forbidden_words` WRITE;
/*!40000 ALTER TABLE `sms_forbidden_words` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_forbidden_words` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_message_deliver`
--

DROP TABLE IF EXISTS `sms_message_deliver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_message_deliver` (
  `id` varchar(64) NOT NULL,
  `deliverStatus` int(11) DEFAULT NULL,
  `statusDes` varchar(500) DEFAULT NULL,
  `deliverTimeStart` bigint(20) DEFAULT NULL,
  `deliverTimeEnd` bigint(20) DEFAULT NULL,
  `httpTryTimes` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='回执推送信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_message_deliver`
--

LOCK TABLES `sms_message_deliver` WRITE;
/*!40000 ALTER TABLE `sms_message_deliver` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_message_deliver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_message_deliver_log`
--

DROP TABLE IF EXISTS `sms_message_deliver_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_message_deliver_log` (
  `id` varchar(64) NOT NULL,
  `passage_code` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '通道简码',
  `msg_id` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '消息ID',
  `status_code` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '状态码',
  `deliver_time` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '短信提供商回复的时间，可为空',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `idx_receive_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='mt下行短信回执';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_message_deliver_log`
--

LOCK TABLES `sms_message_deliver_log` WRITE;
/*!40000 ALTER TABLE `sms_message_deliver_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_message_deliver_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_message_template`
--

DROP TABLE IF EXISTS `sms_message_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_message_template` (
  `id` varchar(64) NOT NULL COMMENT '作为用户在系统中的唯一标识',
  `user_code` varchar(64) NOT NULL COMMENT '归属用户，如果为0，则表示为系统模板（使用所有人）',
  `content` varchar(1024) CHARACTER SET utf8 NOT NULL COMMENT '模板内容',
  `app_type` int(4) DEFAULT '1' COMMENT '操作方式，1:融合WEB平台,2:开发者平台,3:运营支撑系统',
  `approve_time` datetime DEFAULT NULL COMMENT '审批时间',
  `approve_user` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '审批账号',
  `notice_mode` int(4) DEFAULT '0' COMMENT '审核后短信通知类型,0:不需要通知，1：需要通知',
  `mobile` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '审核后通知的手机号码',
  `regex_value` varchar(1024) CHARACTER SET utf8 DEFAULT NULL COMMENT '匹配正则表达式，后台自动生成',
  `submit_interval` int(8) NOT NULL DEFAULT '30' COMMENT '短信提交时间间隔（同一号码）',
  `limit_times` int(8) DEFAULT '10' COMMENT '短信每天提交次数上限（同一号码）',
  `white_word` varchar(512) CHARACTER SET utf8 DEFAULT NULL COMMENT '敏感词白名单 |符号隔开',
  `route_type` int(4) NOT NULL DEFAULT '0' COMMENT '模板路由类型',
  `priority` int(4) NOT NULL DEFAULT '5' COMMENT '优先级（越大越优先）',
  `ext_number` varchar(32) DEFAULT NULL COMMENT '扩展号',
  `ignore_blacklist` int(4) DEFAULT '0' COMMENT '忽略手机号码黑名单',
  `ignore_forbidden_words` int(4) DEFAULT '0' COMMENT '忽略短信中敏感词信息，强制放行',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '0：待审核，1：审核成功，2：审核失败',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `index_sms_message_template_user_code_status` (`user_code`,`status`,`priority`),
  KEY `idx_sms_template_status` (`status`),
  KEY `indx_sms_template_status_routetype` (`user_code`,`status`,`route_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_message_template`
--

LOCK TABLES `sms_message_template` WRITE;
/*!40000 ALTER TABLE `sms_message_template` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_message_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_mo_message_push`
--

DROP TABLE IF EXISTS `sms_mo_message_push`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_mo_message_push` (
  `id` varchar(64) NOT NULL,
  `msg_id` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '消息ID',
  `mobile` varchar(6000) CHARACTER SET utf8 NOT NULL COMMENT '手机号码',
  `content` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '推送内容',
  `retry_times` int(4) DEFAULT '1' COMMENT '重试次数',
  `response_milliseconds` bigint(20) DEFAULT NULL COMMENT '推送相应时间',
  `response_content` varchar(1024) CHARACTER SET utf8 DEFAULT NULL COMMENT '响应内容',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '0：待审核，1：审核成功，2：审核失败',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='上行消息推送';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_mo_message_push`
--

LOCK TABLES `sms_mo_message_push` WRITE;
/*!40000 ALTER TABLE `sms_mo_message_push` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_mo_message_push` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_mo_message_receive`
--

DROP TABLE IF EXISTS `sms_mo_message_receive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_mo_message_receive` (
  `id` varchar(64) NOT NULL,
  `user_code` varchar(64) NOT NULL COMMENT '用户编码',
  `passage_id` int(11) DEFAULT '0' COMMENT '通道标识',
  `msg_id` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '短信标识',
  `mobile` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户手机号',
  `content` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '短信内容',
  `destnation_no` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '服务号长号码',
  `need_push` tinyint(1) DEFAULT '0' COMMENT '是否需要推送，0：不需要，1：需要',
  `push_url` varchar(128) DEFAULT NULL COMMENT '推送地址',
  `receive_time` varchar(64) DEFAULT NULL COMMENT '收到信息的时间',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `idx_mo_msgid` (`msg_id`,`mobile`),
  KEY `idx_mo_msgid_pass` (`passage_id`,`msg_id`,`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='上行消息回复';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_mo_message_receive`
--

LOCK TABLES `sms_mo_message_receive` WRITE;
/*!40000 ALTER TABLE `sms_mo_message_receive` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_mo_message_receive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_mobile_blacklist`
--

DROP TABLE IF EXISTS `sms_mobile_blacklist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_mobile_blacklist` (
  `id` varchar(64) NOT NULL,
  `mobile` varchar(16) CHARACTER SET utf8 NOT NULL COMMENT '手机号码',
  `type` int(4) NOT NULL DEFAULT '0' COMMENT '类型',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `idx_sms_mobile_blacklist_m` (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='手机黑名单信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_mobile_blacklist`
--

LOCK TABLES `sms_mobile_blacklist` WRITE;
/*!40000 ALTER TABLE `sms_mobile_blacklist` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_mobile_blacklist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_mobile_whitelist`
--

DROP TABLE IF EXISTS `sms_mobile_whitelist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_mobile_whitelist` (
  `id` varchar(64) NOT NULL,
  `mobile` varchar(16) CHARACTER SET utf8 NOT NULL,
  `user_code` varchar(64) NOT NULL COMMENT '用户编码',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `indx_smsmobile_whlist_mobile` (`user_code`,`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='手机白名单信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_mobile_whitelist`
--

LOCK TABLES `sms_mobile_whitelist` WRITE;
/*!40000 ALTER TABLE `sms_mobile_whitelist` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_mobile_whitelist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_mt_manual_handling`
--

DROP TABLE IF EXISTS `sms_mt_manual_handling`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_mt_manual_handling` (
  `id` varchar(64) NOT NULL,
  `sid` bigint(20) DEFAULT NULL,
  `app_type` tinyint(2) NOT NULL DEFAULT '2' COMMENT '调用类型 1:融合WEB平台,2:开发者平台,3:运营支撑系统',
  `ip` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '发送IP',
  `user_code` varchar(64) NOT NULL COMMENT '用户编码',
  `mobile` varchar(1024) CHARACTER SET utf8 NOT NULL COMMENT '手机号',
  `cmcp` int(4) NOT NULL DEFAULT '4' COMMENT '运营商，参见cmcp枚举',
  `template_id` int(10) DEFAULT NULL COMMENT '模板编号',
  `content` varchar(1024) CHARACTER SET utf8 NOT NULL COMMENT '短信内容',
  `fee` int(4) NOT NULL COMMENT '计费条数',
  `ext_number` varchar(20) DEFAULT NULL COMMENT '拓展号码',
  `attach` varchar(64) DEFAULT NULL COMMENT '自定义内容',
  `callback` varchar(256) DEFAULT NULL COMMENT '回调URL（选填）',
  `lastest_status` int(4) DEFAULT NULL COMMENT '初始状态，刚开始与status一致',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `idx_customerid` (`user_code`),
  KEY `idx_dst_mobile` (`mobile`(255)),
  KEY `idx_templet_id` (`template_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='下行短信创建';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_mt_manual_handling`
--

LOCK TABLES `sms_mt_manual_handling` WRITE;
/*!40000 ALTER TABLE `sms_mt_manual_handling` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_mt_manual_handling` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_mt_message_deliver`
--

DROP TABLE IF EXISTS `sms_mt_message_deliver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_mt_message_deliver` (
  `id` varchar(64) NOT NULL,
  `msg_id` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '消息ID',
  `cmcp` int(4) NOT NULL COMMENT '运营商',
  `mobile` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '用户手机号',
  `status_code` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '状态码',
  `deliver_time` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '短信提供商回复的时间，可为空',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_message_deliver_unique` (`msg_id`,`mobile`),
  KEY `idx_deliver_status` (`status`),
  KEY `idx_receive_time` (`create_time`),
  KEY `idx_message_deliver_only_msgid` (`msg_id`),
  KEY `idx_message_deliver_only_mobile` (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='下行短信回执状态';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_mt_message_deliver`
--

LOCK TABLES `sms_mt_message_deliver` WRITE;
/*!40000 ALTER TABLE `sms_mt_message_deliver` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_mt_message_deliver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_mt_message_deliver_log`
--

DROP TABLE IF EXISTS `sms_mt_message_deliver_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_mt_message_deliver_log` (
  `id` varchar(64) NOT NULL,
  `passage_code` varchar(32) DEFAULT NULL COMMENT '通道简码',
  `msg_id` varchar(64) DEFAULT NULL COMMENT '消息ID',
  `deliver_time` varchar(32) DEFAULT NULL COMMENT '短信提供商回复的时间，可为空',
  `create_time` datetime NOT NULL COMMENT '插入数据时间',
  `report` longtext COMMENT '报文数据',
  PRIMARY KEY (`id`),
  KEY `idx_receive_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='下行短信回执状态日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_mt_message_deliver_log`
--

LOCK TABLES `sms_mt_message_deliver_log` WRITE;
/*!40000 ALTER TABLE `sms_mt_message_deliver_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_mt_message_deliver_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_mt_message_push`
--

DROP TABLE IF EXISTS `sms_mt_message_push`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_mt_message_push` (
  `id` varchar(64) NOT NULL,
  `msg_id` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '消息ID',
  `mobile` varchar(6000) CHARACTER SET utf8 NOT NULL COMMENT '手机号码',
  `content` varchar(256) DEFAULT NULL COMMENT '推送内容',
  `retry_times` int(4) DEFAULT '1' COMMENT '重试次数',
  `response_milliseconds` bigint(20) DEFAULT NULL COMMENT '推送相应时间',
  `response_content` varchar(1024) CHARACTER SET utf8 DEFAULT NULL COMMENT '响应内容',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `idx_message_deliver_push_msgid` (`msg_id`),
  KEY `idx_message_push_only_mobile` (`mobile`(255))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='下行短信推送';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_mt_message_push`
--

LOCK TABLES `sms_mt_message_push` WRITE;
/*!40000 ALTER TABLE `sms_mt_message_push` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_mt_message_push` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_mt_message_submit`
--

DROP TABLE IF EXISTS `sms_mt_message_submit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_mt_message_submit` (
  `id` varchar(64) NOT NULL,
  `user_code` varchar(64) NOT NULL COMMENT '用户编码',
  `sid` bigint(20) NOT NULL COMMENT '消息ID',
  `mobile` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '手机号码',
  `province_code` int(4) DEFAULT NULL COMMENT '省份代码',
  `cmcp` int(4) DEFAULT NULL COMMENT '运营商',
  `content` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '短信内容',
  `fee` int(4) NOT NULL DEFAULT '1' COMMENT '计费条数',
  `attach` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '自定义内容',
  `passage_id` int(11) unsigned NOT NULL COMMENT '通道ID',
  `need_push` tinyint(1) DEFAULT '0' COMMENT '是否需要推送，0：不需要，1：需要',
  `push_url` varchar(128) CHARACTER SET utf8 DEFAULT NULL COMMENT '推送地址',
  `destnation_no` varchar(32) DEFAULT NULL COMMENT '扩展号码',
  `msg_id` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '调用接口回执ID，默认与SID一致',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_message_submit_msgid` (`msg_id`,`mobile`),
  KEY `idx_passage_id` (`passage_id`),
  KEY `idx_message_submit_sid` (`sid`),
  KEY `idx_message_submit_only_mobile` (`mobile`),
  KEY `idx_message_submit_only_userid` (`user_code`),
  KEY `idx_message_submit_province_cmcp` (`province_code`,`cmcp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='下行短信提交';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_mt_message_submit`
--

LOCK TABLES `sms_mt_message_submit` WRITE;
/*!40000 ALTER TABLE `sms_mt_message_submit` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_mt_message_submit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_mt_process_failed`
--

DROP TABLE IF EXISTS `sms_mt_process_failed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_mt_process_failed` (
  `id` varchar(64) NOT NULL,
  `sid` bigint(20) DEFAULT NULL,
  `app_type` tinyint(2) NOT NULL DEFAULT '2' COMMENT '调用类型 1:融合WEB平台,2:开发者平台,3:运营支撑系统',
  `ip` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '发送IP',
  `user_code` varchar(64) NOT NULL COMMENT '用户编码',
  `mobile` varchar(1024) CHARACTER SET utf8 NOT NULL COMMENT '手机号',
  `cmcp` int(4) NOT NULL DEFAULT '4' COMMENT '运营商，参见cmcp枚举',
  `template_id` int(10) DEFAULT NULL COMMENT '模板编号',
  `content` varchar(1024) CHARACTER SET utf8 NOT NULL COMMENT '短信内容',
  `fee` int(4) NOT NULL COMMENT '计费条数',
  `ext_number` varchar(20) DEFAULT NULL COMMENT '拓展号码',
  `attach` varchar(64) DEFAULT NULL COMMENT '自定义内容',
  `callback` varchar(256) DEFAULT NULL COMMENT '回调URL（选填）',
  `lastest_status` int(4) DEFAULT NULL COMMENT '上一条状态',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `idx_customerid` (`user_code`),
  KEY `idx_dst_mobile` (`mobile`(255)),
  KEY `idx_templet_id` (`template_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='下行短信处理失败';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_mt_process_failed`
--

LOCK TABLES `sms_mt_process_failed` WRITE;
/*!40000 ALTER TABLE `sms_mt_process_failed` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_mt_process_failed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_mt_task`
--

DROP TABLE IF EXISTS `sms_mt_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_mt_task` (
  `id` varchar(64) NOT NULL,
  `user_code` varchar(64) NOT NULL COMMENT '用户编码',
  `sid` bigint(20) NOT NULL COMMENT '消息ID',
  `app_type` tinyint(2) NOT NULL DEFAULT '2' COMMENT '调用类型 1:融合WEB平台,2:开发者平台,3:运营支撑系统',
  `mobile` longtext CHARACTER SET utf8 NOT NULL COMMENT '手机号',
  `content` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ext_number` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '拓展号码',
  `attach` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '自定义内容',
  `callback` varchar(256) CHARACTER SET utf8 DEFAULT NULL COMMENT '回调URL（选填）',
  `fee` int(8) NOT NULL COMMENT '计费条数',
  `return_fee` int(4) DEFAULT '0' COMMENT '返还条数',
  `submit_url` varchar(256) CHARACTER SET utf8 DEFAULT NULL COMMENT '程序调用URL',
  `ip` varchar(45) CHARACTER SET utf8 DEFAULT NULL COMMENT '提交IP',
  `submit_type` int(4) DEFAULT '0' COMMENT '提交类型：0：批量短信，1：普通点对点，2：模板点对点',
  `process_status` int(4) DEFAULT NULL COMMENT '分包状态,0:正在分包，1：分包完成，待发送，2:分包异常，待处理，3:分包失败，终止',
  `approve_status` int(4) DEFAULT NULL COMMENT '0：待审核，1：自动通过，2：手动通过，3：审核未通过',
  `error_mobiles` text CHARACTER SET utf8 COMMENT '错号手机号码',
  `repeat_mobiles` text COMMENT '重复手机号码',
  `black_mobiles` text COMMENT '黑名单手机号码',
  `final_content` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `process_time` datetime DEFAULT NULL COMMENT '分包完成时间',
  `force_actions` varchar(32) CHARACTER SET utf8 DEFAULT '000' COMMENT '异常分包情况下允许的操作，如000,010，第一位:未报备模板，第二位：敏感词，第三位：通道不可用',
  `message_template_id` bigint(20) DEFAULT NULL COMMENT '短信模板ID',
  `forbidden_words` varchar(64) DEFAULT NULL COMMENT '敏感词',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `idx_dst_sid_mobile` (`sid`,`mobile`(255)),
  KEY `idx_create_time` (`create_time`),
  KEY `idx_approve_status` (`approve_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='下行短信任务';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_mt_task`
--

LOCK TABLES `sms_mt_task` WRITE;
/*!40000 ALTER TABLE `sms_mt_task` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_mt_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_mt_task_packets`
--

DROP TABLE IF EXISTS `sms_mt_task_packets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_mt_task_packets` (
  `id` varchar(64) NOT NULL,
  `sid` bigint(20) NOT NULL COMMENT '消息ID',
  `mobile` longtext NOT NULL COMMENT '手机号码（批量时为多个）',
  `cmcp` int(4) DEFAULT NULL COMMENT '运营商',
  `content` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mobile_size` int(10) DEFAULT NULL COMMENT '号码总个数',
  `message_template_id` bigint(20) DEFAULT NULL COMMENT '短信模板ID',
  `passage_id` int(11) DEFAULT NULL COMMENT '通道ID',
  `final_passage_id` int(11) DEFAULT NULL COMMENT '最终使用的通道ID',
  `passage_protocol` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '协议类型',
  `passage_url` varchar(128) CHARACTER SET utf8 DEFAULT NULL COMMENT '通道URL',
  `passage_parameter` varchar(512) CHARACTER SET utf8 DEFAULT NULL COMMENT '参数信息',
  `result_format` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '结果模板',
  `success_code` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '成功码',
  `position` varchar(1024) CHARACTER SET utf8 DEFAULT NULL COMMENT '定位',
  `priority` int(10) DEFAULT '1' COMMENT '优先级',
  `force_actions` varchar(32) CHARACTER SET utf8 DEFAULT '000' COMMENT '异常分包情况下允许的操作，如000,010，第一位:未报备模板，第二位：敏感词，第三位：通道不可用',
  `retry_times` int(11) DEFAULT '0' COMMENT '调用上家重试次数',
  `province_code` int(4) DEFAULT NULL COMMENT '省份代码',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `idx_passage_id` (`passage_id`),
  KEY `idx_task_sid` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='下行短信任务分包';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_mt_task_packets`
--

LOCK TABLES `sms_mt_task_packets` WRITE;
/*!40000 ALTER TABLE `sms_mt_task_packets` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_mt_task_packets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_passage`
--

DROP TABLE IF EXISTS `sms_passage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_passage` (
  `id` varchar(64) NOT NULL,
  `name` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '通道名称',
  `code` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '通道字母编码',
  `cmcp` int(4) NOT NULL COMMENT '运营商',
  `word_number` tinyint(4) NOT NULL COMMENT '计费字数',
  `priority` tinyint(4) DEFAULT NULL COMMENT '优先级',
  `paas_template_id` int(11) NOT NULL COMMENT '通道模板',
  `type` tinyint(4) NOT NULL COMMENT '通道类型 0 公共通道 1 独立通道',
  `exclusive_user_id` int(11) DEFAULT NULL COMMENT '独立通道时绑定的用户',
  `sign_mode` tinyint(4) DEFAULT '0' COMMENT '签名模式 0:不处理，1：自动前置，2：自动后置，3：自动去除签名',
  `access_code` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '10690接入号，需与params表接入号一致',
  `account` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '接入账号(上家提供的用户账号)',
  `pay_type` tinyint(4) DEFAULT '1' COMMENT '付费方式(1预付2后付)',
  `balance` int(10) DEFAULT NULL COMMENT '剩余条数',
  `mobile_size` int(10) DEFAULT NULL COMMENT '手机号码分包数',
  `packets_size` int(10) DEFAULT NULL COMMENT '1秒钟允许提交的网络包数量',
  `connection_size` int(10) DEFAULT NULL COMMENT '最大连接数',
  `read_timeout` int(10) DEFAULT NULL COMMENT '超时时间（毫秒）',
  `ext_number` int(10) DEFAULT '0' COMMENT '拓展号长度,0表示不允许拓展',
  `born_term` int(10) DEFAULT '72' COMMENT '统计落地时限（小时）',
  `sms_template_param` int(4) DEFAULT '0' COMMENT '是否需要短信模板参数信息',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `idx_passage_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='通道管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_passage`
--

LOCK TABLES `sms_passage` WRITE;
/*!40000 ALTER TABLE `sms_passage` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_passage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_passage_access`
--

DROP TABLE IF EXISTS `sms_passage_access`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_passage_access` (
  `id` varchar(64) NOT NULL,
  `user_code` varchar(64) NOT NULL COMMENT '用户编码',
  `group_id` int(11) NOT NULL COMMENT '通道组id',
  `route_type` int(4) NOT NULL COMMENT '路由类型',
  `cmcp` int(2) NOT NULL COMMENT '运营商',
  `province_code` int(11) DEFAULT '0' COMMENT '省份',
  `passage_id` int(11) NOT NULL COMMENT '通道ID',
  `passage_code` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '通道代码',
  `protocol` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '协议类型',
  `call_type` tinyint(4) NOT NULL COMMENT '1-发送2-下行推送 3-下行自取 4-上行推送 5-上行自取',
  `url` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `params_definition` varchar(1024) CHARACTER SET utf8 DEFAULT NULL COMMENT '定义，直接取模板里的值',
  `params` varchar(1024) CHARACTER SET utf8 DEFAULT NULL COMMENT '具体的参数值，取模板中的key作为KEY，如{"username":"test", "password":"123456"}',
  `result_format` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `success_code` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '成功码',
  `position` varchar(1024) CHARACTER SET utf8 DEFAULT NULL COMMENT '返回值的具体位置，json存储',
  `mobile_size` int(10) DEFAULT NULL COMMENT '手机号码分包数',
  `packets_size` int(10) DEFAULT NULL COMMENT '1秒钟允许提交的网络包数量',
  `connection_size` int(10) DEFAULT NULL COMMENT '最大连接数',
  `read_timeout` int(10) DEFAULT NULL COMMENT '超时时间（毫秒）',
  `access_code` varchar(32) DEFAULT NULL COMMENT '接入号码（10690...）',
  `ext_number` int(10) DEFAULT '0' COMMENT '拓展号长度,0表示不允许拓展',
  `sign_mode` tinyint(4) DEFAULT '0' COMMENT '签名模式 0:不处理，1：自动前置，2：自动后置，3：自动去除签名',
  `sms_template_param` int(4) DEFAULT '0' COMMENT '是否需要短信模板参数信息',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `idx_sms_passage_access_url` (`call_type`,`url`),
  KEY `idx_sms_passage_access_userid` (`user_code`,`route_type`,`province_code`,`cmcp`),
  KEY `idx_sms_passage_access_passageid` (`passage_id`),
  KEY `idx_sms_passage_access_userid_calltype` (`user_code`,`call_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='通道资产';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_passage_access`
--

LOCK TABLES `sms_passage_access` WRITE;
/*!40000 ALTER TABLE `sms_passage_access` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_passage_access` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_passage_change_log`
--

DROP TABLE IF EXISTS `sms_passage_change_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_passage_change_log` (
  `id` varchar(64) NOT NULL,
  `passage_id` int(11) NOT NULL COMMENT '通道ID',
  `old_passage_id` int(11) NOT NULL COMMENT '原通道ID',
  `group_id` int(11) NOT NULL COMMENT '通道组id',
  `user_code` varchar(64) NOT NULL COMMENT '用户编码',
  `route_type` int(4) NOT NULL COMMENT '路由类型',
  `cmcp` int(2) NOT NULL COMMENT '运营商',
  `operate_mode` int(2) NOT NULL COMMENT '操作方式',
  `operate_user` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '操作人 工号',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='通道变更日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_passage_change_log`
--

LOCK TABLES `sms_passage_change_log` WRITE;
/*!40000 ALTER TABLE `sms_passage_change_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_passage_change_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_passage_control`
--

DROP TABLE IF EXISTS `sms_passage_control`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_passage_control` (
  `id` varchar(64) NOT NULL,
  `passage_id` int(11) NOT NULL COMMENT '通道ID',
  `cron` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '轮训表达式',
  `parameter_id` int(11) DEFAULT NULL COMMENT '通道参数ID',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='通道控制';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_passage_control`
--

LOCK TABLES `sms_passage_control` WRITE;
/*!40000 ALTER TABLE `sms_passage_control` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_passage_control` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_passage_group`
--

DROP TABLE IF EXISTS `sms_passage_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_passage_group` (
  `id` varchar(64) NOT NULL,
  `passage_group_name` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '通道组名称',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='通道组';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_passage_group`
--

LOCK TABLES `sms_passage_group` WRITE;
/*!40000 ALTER TABLE `sms_passage_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_passage_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_passage_group_detail`
--

DROP TABLE IF EXISTS `sms_passage_group_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_passage_group_detail` (
  `id` varchar(64) NOT NULL,
  `group_id` int(11) NOT NULL COMMENT '通道组id',
  `passage_id` int(11) NOT NULL COMMENT '通道id',
  `province_code` int(11) DEFAULT '0' COMMENT '通道代码',
  `route_type` tinyint(4) DEFAULT NULL COMMENT '路由类型，0默认路由，1验证码路由,2即时通知路由，3批量通知路由，4高风险投诉路由',
  `priority` int(4) DEFAULT NULL COMMENT '优先级',
  `cmcp` int(4) DEFAULT NULL COMMENT '运营商1-移动 2-联通 3-电信',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='通道组内容';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_passage_group_detail`
--

LOCK TABLES `sms_passage_group_detail` WRITE;
/*!40000 ALTER TABLE `sms_passage_group_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_passage_group_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_passage_message_template`
--

DROP TABLE IF EXISTS `sms_passage_message_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_passage_message_template` (
  `id` varchar(64) NOT NULL,
  `template_id` varchar(64) NOT NULL COMMENT '通道模板ID（通道方提供）',
  `template_content` varchar(256) NOT NULL COMMENT '模板内容',
  `regex_value` varchar(256) DEFAULT NULL COMMENT '模板表达式',
  `param_names` varchar(64) DEFAULT NULL COMMENT '参数名称，多个以,分割(有序)',
  `passage_id` int(11) NOT NULL COMMENT '通道ID',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `indx_passage_message_template_id` (`template_id`),
  KEY `indx_passage_message_passage_id` (`passage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='通道消息模板';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_passage_message_template`
--

LOCK TABLES `sms_passage_message_template` WRITE;
/*!40000 ALTER TABLE `sms_passage_message_template` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_passage_message_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_passage_parameter`
--

DROP TABLE IF EXISTS `sms_passage_parameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_passage_parameter` (
  `id` varchar(64) NOT NULL,
  `passage_id` int(11) NOT NULL COMMENT '通道ID',
  `protocol` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '协议类型',
  `call_type` tinyint(4) NOT NULL COMMENT '1-发送 2-状态回执推送 3-状态回执自取 4-上行推送 5-上行自取 6-余额查询',
  `url` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `params_definition` varchar(1024) CHARACTER SET utf8 DEFAULT NULL COMMENT '定义，直接取模板里的值',
  `params` varchar(1024) CHARACTER SET utf8 DEFAULT NULL COMMENT '具体的参数值，取模板中的key作为KEY，如{"username":"test", "password":"123456"}',
  `result_format` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `success_code` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `position` varchar(1024) CHARACTER SET utf8 DEFAULT NULL COMMENT '返回值的具体位置，json存储',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `inx_passage_parameter_pid` (`passage_id`,`url`),
  KEY `inx_passage_parameter_url` (`url`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='通道消息模板参数';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_passage_parameter`
--

LOCK TABLES `sms_passage_parameter` WRITE;
/*!40000 ALTER TABLE `sms_passage_parameter` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_passage_parameter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_passage_province`
--

DROP TABLE IF EXISTS `sms_passage_province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_passage_province` (
  `id` varchar(64) NOT NULL,
  `passage_id` int(11) NOT NULL COMMENT '通道ID',
  `province_code` int(11) DEFAULT NULL COMMENT '省份代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='通道支持省份';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_passage_province`
--

LOCK TABLES `sms_passage_province` WRITE;
/*!40000 ALTER TABLE `sms_passage_province` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_passage_province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_passage_reachrate_settings`
--

DROP TABLE IF EXISTS `sms_passage_reachrate_settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_passage_reachrate_settings` (
  `id` varchar(64) NOT NULL,
  `passage_id` bigint(20) NOT NULL COMMENT '短信通道ID',
  `interval` bigint(20) NOT NULL COMMENT '轮询间隔（单位秒）',
  `start_time` bigint(20) NOT NULL COMMENT '数据源时间（开始执行时间点，单位秒）',
  `time_length` bigint(20) NOT NULL COMMENT '数据源时长',
  `count_point` int(11) NOT NULL COMMENT '计数阀值，起始点',
  `rate_threshold` int(4) NOT NULL COMMENT '到达率，整数，最大100',
  `mobile` varchar(64) DEFAULT NULL COMMENT '通知手机号码',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='通道重连配置';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_passage_reachrate_settings`
--

LOCK TABLES `sms_passage_reachrate_settings` WRITE;
/*!40000 ALTER TABLE `sms_passage_reachrate_settings` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_passage_reachrate_settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_priority_words`
--

DROP TABLE IF EXISTS `sms_priority_words`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_priority_words` (
  `id` varchar(64) NOT NULL,
  `user_code` varchar(64) NOT NULL COMMENT '用户编码',
  `content` varchar(64) NOT NULL COMMENT '内容',
  `priority` int(4) NOT NULL DEFAULT '1' COMMENT '优先级',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `indx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='优先级词库配置';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_priority_words`
--

LOCK TABLES `sms_priority_words` WRITE;
/*!40000 ALTER TABLE `sms_priority_words` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_priority_words` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_provider`
--

DROP TABLE IF EXISTS `sms_provider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_provider` (
  `id` varchar(64) NOT NULL,
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '提供商类型0:运营商1:第三方',
  `name` varchar(45) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '提供商名称',
  `code` varchar(45) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '提供商编号',
  `is_applied` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否启用(0:启用1:停用)',
  `priority` tinyint(4) NOT NULL DEFAULT '0' COMMENT '优先级(相同产品调用优先级)',
  `contact` varchar(45) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `phone` varchar(45) CHARACTER SET utf8 DEFAULT '',
  `mobile` varchar(45) CHARACTER SET utf8 DEFAULT '',
  `fax` varchar(45) CHARACTER SET utf8 DEFAULT '',
  `address` varchar(45) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `zip` varchar(45) CHARACTER SET utf8 DEFAULT '',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `fk_provider_type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='短信接口提供商';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_provider`
--

LOCK TABLES `sms_provider` WRITE;
/*!40000 ALTER TABLE `sms_provider` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_provider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_signature_extno`
--

DROP TABLE IF EXISTS `sms_signature_extno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_signature_extno` (
  `id` varchar(64) NOT NULL,
  `user_code` varchar(64) NOT NULL COMMENT '用户编码',
  `signature` varchar(64) NOT NULL COMMENT '签名',
  `ext_number` varchar(16) NOT NULL COMMENT '扩展号码',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `idx_sms_signature_extno_userid` (`user_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='签名扩展';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_signature_extno`
--

LOCK TABLES `sms_signature_extno` WRITE;
/*!40000 ALTER TABLE `sms_signature_extno` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_signature_extno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_submit_hour_report`
--

DROP TABLE IF EXISTS `sms_submit_hour_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sms_submit_hour_report` (
  `id` varchar(64) NOT NULL,
  `user_code` varchar(64) NOT NULL COMMENT '用户编码',
  `passage_id` int(11) NOT NULL COMMENT '通道ID',
  `province_code` int(4) NOT NULL COMMENT '省份代码',
  `submit_count` int(11) NOT NULL COMMENT '提交数量',
  `bill_count` int(11) NOT NULL COMMENT '计费数',
  `unknown_count` int(11) DEFAULT NULL COMMENT '未知数量',
  `success_count` int(11) DEFAULT NULL COMMENT '成功数量',
  `submit_failed_count` int(11) DEFAULT NULL COMMENT '发送失败数量',
  `other_count` int(11) DEFAULT NULL COMMENT '其他数量',
  `born_hours` int(11) DEFAULT '72' COMMENT '落地小时阀值',
  `hour_time` bigint(20) DEFAULT NULL COMMENT '当前小时毫秒数',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `indx_report_user_provice` (`user_code`,`passage_id`,`province_code`,`hour_time`),
  KEY `indx_report_user_code_stat` (`user_code`,`passage_id`,`hour_time`),
  KEY `indx_report_passage` (`passage_id`,`hour_time`),
  KEY `indx_report_provice` (`province_code`,`hour_time`),
  KEY `indx_sms_report_hour` (`hour_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='提交报告（小时）';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_submit_hour_report`
--

LOCK TABLES `sms_submit_hour_report` WRITE;
/*!40000 ALTER TABLE `sms_submit_hour_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_submit_hour_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_area`
--

DROP TABLE IF EXISTS `sys_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_area` (
  `area_code` varchar(100) NOT NULL COMMENT '区域编码',
  `parent_code` varchar(64) NOT NULL COMMENT '父级编号',
  `parent_codes` varchar(1000) NOT NULL COMMENT '所有父级编号',
  `tree_sort` decimal(10,0) NOT NULL COMMENT '本级排序号（升序）',
  `tree_names` varchar(1000) NOT NULL COMMENT '全节点名',
  `tree_leaf` char(1) DEFAULT NULL COMMENT '是否最末级',
  `tree_level` char(1) DEFAULT NULL COMMENT '层次级别',
  `area_name` varchar(100) NOT NULL COMMENT '区域名称',
  `area_type` char(1) DEFAULT NULL COMMENT '区域类型',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`area_code`),
  KEY `idx_sys_area_pc` (`area_code`),
  KEY `idx_sys_area_ts` (`tree_sort`),
  KEY `idx_sys_area_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='行政区划';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_area`
--

LOCK TABLES `sys_area` WRITE;
/*!40000 ALTER TABLE `sys_area` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_company`
--

DROP TABLE IF EXISTS `sys_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_company` (
  `company_code` varchar(64) NOT NULL COMMENT '公司编码',
  `parent_code` varchar(64) NOT NULL COMMENT '父级编号',
  `parent_codes` varchar(1000) NOT NULL COMMENT '所有父级编号',
  `tree_sort` decimal(10,0) NOT NULL COMMENT '本级排序号（升序）',
  `tree_names` varchar(1000) NOT NULL COMMENT '全节点名',
  `tree_leaf` char(1) DEFAULT NULL COMMENT '是否最末级',
  `tree_level` char(1) DEFAULT NULL COMMENT '层次级别',
  `view_code` varchar(100) DEFAULT NULL COMMENT '公司代码',
  `company_name` varchar(200) NOT NULL COMMENT '公司名称',
  `full_name` varchar(200) DEFAULT NULL COMMENT '公司全称',
  `area_code` varchar(100) DEFAULT NULL COMMENT '区域编码',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`company_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_company`
--

LOCK TABLES `sys_company` WRITE;
/*!40000 ALTER TABLE `sys_company` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_company_office`
--

DROP TABLE IF EXISTS `sys_company_office`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_company_office` (
  `company_code` varchar(64) NOT NULL COMMENT '公司编码',
  `office_code` varchar(64) NOT NULL COMMENT '机构编码',
  PRIMARY KEY (`company_code`,`office_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司部门关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_company_office`
--

LOCK TABLES `sys_company_office` WRITE;
/*!40000 ALTER TABLE `sys_company_office` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_company_office` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_config`
--

DROP TABLE IF EXISTS `sys_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_config` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `config_name` varchar(100) NOT NULL COMMENT '名称',
  `config_key` varchar(100) NOT NULL COMMENT '参数键',
  `config_value` varchar(1000) DEFAULT NULL COMMENT '参数值',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='参数配置表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_config`
--

LOCK TABLES `sys_config` WRITE;
/*!40000 ALTER TABLE `sys_config` DISABLE KEYS */;
INSERT INTO `sys_config` VALUES ('1044886589073006592','研发工具-代码生成默认包名','gen.defaultPackageName','org.tangdao.modules','system','2018-09-26 17:49:11','system','2019-08-13 15:47:59','新建项目后，修改该键值，在生成代码的时候就不要再修改了','2'),('1044886591556034560','主框架页-桌面仪表盘首页地址','sys.index.desktopUrl','/desktop','system','2018-09-26 17:49:11','system','2019-08-16 14:38:33','主页面的第一个页签首页桌面地址','0'),('1044886594290720768','主框架页-默认皮肤样式名称','sys.index.skinName','default','system','2018-09-26 17:49:12','system','2019-08-16 09:43:40','default，charcoal','2'),('1044886594357829632','用户登录-登录失败多少次数后显示验证码','sys.login.failedNumAfterValidCode','3','system','2018-09-26 17:49:12','system','2019-03-06 16:38:07','设置为0强制使用验证码登录','2'),('1044886594420744192','用户登录-登录失败多少次数后锁定账号','sys.login.failedNumAfterLockAccount','200','system','2018-09-26 17:49:12','system','2019-01-29 17:04:22','登录失败多少次数后锁定账号','2'),('1044886594559156224','账号自助-是否开启用户注册功能','sys.account.registerUser','true','system','2018-09-26 17:49:12','system','2019-08-13 17:33:49','是否开启注册用户功能','2'),('1044886594626265088','账号自助-允许自助注册的用户类型','sys.account.registerUser.userTypes','-1','system','2018-09-26 17:49:12','system','2019-03-06 16:27:09','允许注册的用户类型（多个用逗号隔开，如果注册时不选择用户类型，则第一个为默认类型）','0'),('1044886594684985344','账号自助-验证码有效时间（分钟）','sys.account.validCodeTimeout','10','system','2018-09-26 17:49:12','system','2019-01-29 17:04:30','找回密码时，短信/邮件验证码有效时间（单位：分钟，0表示不限制）','2'),('1044886594739511296','用户管理-账号默认角色-员工类型','sys.user.defaultRoleCodes.employee','default','system','2018-09-26 17:49:12','system','2019-03-06 16:42:21','所有员工用户都拥有的角色权限（适用于菜单授权查询）','0'),('1044886594798231552','用户管理-账号初始密码','sys.user.initPassword','123456','system','2018-09-26 17:49:12','system','2019-03-06 16:42:18','创建用户和重置密码的时候用户的密码','0'),('1044886594848563200','用户管理-初始密码修改策略','sys.user.initPasswordModify','1','system','2018-09-26 17:49:12','system','2019-01-29 17:05:13','0：初始密码修改策略关闭，没有任何提示；1：提醒用户，如果未修改初始密码，则在登录时和点击菜单就会提醒修改密码对话框；2：强制实行初始密码修改，登录后若不修改密码则不能进行系统操作','2');
/*!40000 ALTER TABLE `sys_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict_data`
--

DROP TABLE IF EXISTS `sys_dict_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dict_data` (
  `id` varchar(64) NOT NULL COMMENT '字典编码',
  `dict_label` varchar(100) NOT NULL COMMENT '字典标签',
  `dict_value` varchar(100) NOT NULL COMMENT '字典键值',
  `dict_type` varchar(100) NOT NULL COMMENT '字典类型',
  `dict_sort` decimal(10,0) NOT NULL COMMENT '本级排序号（升序）',
  `description` varchar(500) DEFAULT NULL COMMENT '字典描述',
  `css_style` varchar(500) DEFAULT NULL COMMENT 'css样式（如：color:red)',
  `css_class` varchar(500) DEFAULT NULL COMMENT 'css类名（如：red）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典数据表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_data`
--

LOCK TABLES `sys_dict_data` WRITE;
/*!40000 ALTER TABLE `sys_dict_data` DISABLE KEYS */;
INSERT INTO `sys_dict_data` VALUES ('1044886605825056768','是','1','sys_yes_no',30,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886606118658048','否','0','sys_yes_no',40,'','color:#aaa;','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886606181572608','正常','0','sys_status',20,'','color:#449D44;','','0','system','2018-09-26 17:49:15','system','2019-06-28 14:59:44',''),('1044886606248681472','删除','1','sys_status',30,'','color:#f00;','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886606366121984','停用','2','sys_status',40,'','color:#f00;','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886606429036544','冻结','3','sys_status',50,'','color:#fa0;','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886606496145408','待审','4','sys_status',60,'','color:#01AAED;','','0','system','2018-09-26 17:49:15','system','2019-03-18 14:49:10',NULL),('1044886606563254272','驳回','5','sys_status',70,'','color:#FF5722;','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886606668111872','草稿','9','sys_status',80,'','color:#aaa;','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886606747803648','显示','1','sys_show_hide',30,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886606810718208','隐藏','0','sys_show_hide',40,'','color:#aaa;','','0','system','2018-09-26 17:49:15','system','2019-08-14 15:59:22',''),('1044886606877827072','简体中文','zh_CN','sys_lang_type',30,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886606949130240','英语','en','sys_lang_type',40,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886607016239104','PC电脑','pc','sys_device_type',30,'','','','2','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886607091736576','手机APP','mobileApp','sys_device_type',40,'','','','2','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886607142068224','手机Web','mobileWeb','sys_device_type',50,'','','','2','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886607217565696','微信设备','weixin','sys_device_type',60,'','','','2','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886607284674560','管理组','1','sys_user_mgr_type',30,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886607343394816','菜单','1','sys_menu_type',30,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886607406309376','权限','2','sys_menu_type',40,'','color:#c243d6;','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886607456641024','默认权重','20','sys_menu_weight',30,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886607515361280','二级管理员','40','sys_menu_weight',40,'','','','0','system','2018-09-26 17:49:15','system','2019-08-15 09:29:23',''),('1044886607569887232','系统管理员','60','sys_menu_weight',50,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886607628607488','超级管理员','80','sys_menu_weight',60,'','color:#c243d6;','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886607683133440','国家','0','sys_area_type',30,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886607733465088','省份直辖市','1','sys_area_type',40,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886607792185344','地市','2','sys_area_type',50,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886607850905600','区县','3','sys_area_type',60,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886607918014464','省级公司','1','sys_office_type',30,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886607972540416','市级公司','2','sys_office_type',40,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886608035454976','部门','3','sys_office_type',50,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886608098369536','正常','0','sys_search_status',30,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886608161284096','停用','2','sys_search_status',40,'','color:#f00;','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886608224198656','男','1','sys_user_sex',30,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886608295501824','女','2','sys_user_sex',40,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886608358416384','正常','0','sys_user_status',30,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886608421330944','停用','2','sys_user_status',40,'','color:#f00;','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886608475856896','冻结','3','sys_user_status',50,'','color:#fa0;','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886608534577152','员工','employee','sys_user_type',30,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886608610074624','会员','member','sys_user_type',40,'','color:#6f42c1;','','0','system','2018-09-26 17:49:15','system','2019-09-03 16:06:33',''),('1044886608987561984','高管','1','sys_role_type',30,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886609033699328','中层','2','sys_role_type',40,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886609084030976','基层','3','sys_role_type',50,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886609134362624','其它','4','sys_role_type',60,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886609201471488','未设置','0','sys_role_data_scope',30,'','','','0','system','2018-09-26 17:49:15','system','2019-06-28 14:26:40',''),('1044886609247608832','全部数据权限','1','sys_role_data_scope',40,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886609293746176','自定数据权限','2','sys_role_data_scope',50,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886609348272128','高管','1','sys_post_type',30,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886609402798080','中层','2','sys_post_type',40,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886609461518336','基层','3','sys_post_type',50,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886609537015808','其它','4','sys_post_type',60,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886609583153152','接入日志','access','sys_log_type',30,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886609633484800','修改日志','update','sys_log_type',40,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886609675427840','查询日志','select','sys_log_type',50,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886609725759488','登录登出','loginLogout','sys_log_type',60,'','','','0','system','2018-09-26 17:49:15','system','2018-09-26 17:49:15',NULL),('1044886609788674048','默认','DEFAULT','job_group',30,'','','','0','system','2018-09-26 17:49:15','system','2019-05-31 10:20:03',NULL),('1044886609834811392','系统','SYSTEM','job_group',40,'','','','0','system','2018-09-26 17:49:15','system','2019-05-31 10:20:03',NULL),('1044886609880948736','错过计划等待本次计划完成后立即执行一次','1','job_misfire_instruction',30,'','','','0','system','2018-09-26 17:49:16','system','2019-05-31 10:19:01',NULL),('1044886609931280384','本次执行时间根据上次结束时间重新计算（时间间隔方式）','2','job_misfire_instruction',40,'','','','0','system','2018-09-26 17:49:16','system','2019-05-31 10:19:01',NULL),('1044886609981612032','正常','0','job_status',30,'','','','0','system','2018-09-26 17:49:16','system','2019-08-28 08:36:07',''),('1044886610132606976','暂停','2','job_status',50,'','color:#f00;','','0','system','2018-09-26 17:49:16','system','2019-08-28 08:36:14',''),('1044886610338127872','计划日志','scheduler','job_type',30,'','','','0','system','2018-09-26 17:49:16','system','2019-05-31 10:20:29',NULL),('1044886610409431040','任务日志','job','job_type',40,'','','','0','system','2018-09-26 17:49:16','system','2019-05-31 10:20:29',NULL),('1044886610468151296','触发日志','trigger','job_type',50,'','','','0','system','2018-09-26 17:49:16','system','2019-05-31 10:20:29',NULL),('1082935122621489152','用户组','0','sys_user_mgr_type',30,'',NULL,NULL,'0',NULL,NULL,NULL,NULL,NULL),('1139358413533732864','中国移动','1','isp_type',30,NULL,'','','0','system','2019-06-14 10:26:29','system','2019-06-14 10:26:29',''),('1139358449084653568','中国联通','2','isp_type',30,NULL,'','','0','system','2019-06-14 10:26:37','system','2019-06-14 10:26:37',''),('1139358489278668800','中国电信','3','isp_type',30,NULL,'','','0','system','2019-06-14 10:26:47','system','2019-06-14 10:26:47',''),('1139358546333786112','中国广电','4','isp_type',30,NULL,'','','2','system','2019-06-14 10:27:00','system','2019-06-14 10:27:26','');
/*!40000 ALTER TABLE `sys_dict_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict_type`
--

DROP TABLE IF EXISTS `sys_dict_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dict_type` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `dict_name` varchar(100) NOT NULL COMMENT '字典名称',
  `dict_type` varchar(100) NOT NULL COMMENT '字典类型',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典类型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_type`
--

LOCK TABLES `sys_dict_type` WRITE;
/*!40000 ALTER TABLE `sys_dict_type` DISABLE KEYS */;
INSERT INTO `sys_dict_type` VALUES ('1044886602020823040','是否','sys_yes_no','0','system','2018-09-26 17:49:14','system','2019-08-14 14:54:32',''),('1044886602117292032','状态','sys_status','0','system','2018-09-26 17:49:14','system','2018-09-26 17:49:14',NULL),('1044886602142457856','显示隐藏','sys_show_hide','0','system','2018-09-26 17:49:14','system','2018-09-26 17:49:14',NULL),('1044886602213761024','用户管理类型','sys_user_mgr_type','0','system','2018-09-26 17:49:14','system','2018-09-26 17:49:14',''),('1044886602238926848','菜单类型','sys_menu_type','0','system','2018-09-26 17:49:14','system','2018-09-26 17:49:14',NULL),('1044886602264092672','菜单权重','sys_menu_weight','0','system','2018-09-26 17:49:14','system','2018-09-26 17:49:14',NULL),('1044886602289258496','区域类型','sys_area_type','0','system','2018-09-26 17:49:14','system','2018-09-26 17:49:14',NULL),('1044886602310230016','机构类型','sys_office_type','0','system','2018-09-26 17:49:14','system','2018-09-26 17:49:14',NULL),('1044886602335395840','查询状态','sys_search_status','0','system','2018-09-26 17:49:14','system','2018-09-26 17:49:14',''),('1044886602356367360','用户性别','sys_user_sex','0','system','2018-09-26 17:49:14','system','2018-09-26 17:49:14',NULL),('1044886602377338880','用户状态','sys_user_status','0','system','2018-09-26 17:49:14','system','2018-09-26 17:49:14',NULL),('1044886602402504704','用户类型','sys_user_type','0','system','2018-09-26 17:49:14','system','2018-09-26 17:49:14',NULL),('1044886602423476224','角色分类','sys_role_type','0','system','2018-09-26 17:49:14','system','2018-09-26 17:49:14',NULL),('1044886602452836352','角色数据范围','sys_role_data_scope','0','system','2018-09-26 17:49:14','system','2018-09-26 17:49:14',NULL),('1044886602478002176','岗位分类','sys_post_type','0','system','2018-09-26 17:49:14','system','2018-09-26 17:49:14',NULL),('1044886602503168000','日志类型','sys_log_type','0','system','2018-09-26 17:49:14','system','2018-09-26 17:49:14',NULL),('1044886602591248384','作业状态','job_status','0','system','2018-09-26 17:49:14','system','2019-05-31 10:20:21',''),('1139358337306451968','运营商','isp_type','2','system','2019-06-14 10:26:11','system','2019-08-14 14:57:14','');
/*!40000 ALTER TABLE `sys_dict_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_log`
--

DROP TABLE IF EXISTS `sys_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_log` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `log_type` varchar(50) NOT NULL COMMENT '日志类型',
  `log_title` varchar(500) NOT NULL COMMENT '日志标题',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_by_name` varchar(100) NOT NULL COMMENT '用户名称',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `request_uri` varchar(500) DEFAULT NULL COMMENT '请求URI',
  `request_method` varchar(10) DEFAULT NULL COMMENT '操作方式',
  `request_params` longtext COMMENT '操作提交的数据',
  `diff_modify_data` text COMMENT '新旧数据比较结果',
  `biz_key` varchar(64) DEFAULT NULL COMMENT '业务主键',
  `biz_type` varchar(64) DEFAULT NULL COMMENT '业务类型',
  `remote_addr` varchar(255) NOT NULL COMMENT '操作IP地址',
  `server_addr` varchar(255) NOT NULL COMMENT '请求服务器地址',
  `is_exception` char(1) DEFAULT NULL COMMENT '是否异常',
  `exception_info` text COMMENT '异常信息',
  `user_agent` varchar(500) DEFAULT NULL COMMENT '用户代理',
  `device_name` varchar(100) DEFAULT NULL COMMENT '设备名称/操作系统',
  `browser_name` varchar(100) DEFAULT NULL COMMENT '浏览器名称',
  `execute_time` decimal(19,0) DEFAULT NULL COMMENT '执行时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_log`
--

LOCK TABLES `sys_log` WRITE;
/*!40000 ALTER TABLE `sys_log` DISABLE KEYS */;
INSERT INTO `sys_log` VALUES ('1169516749153112065','loginLogout','系统登录','system','超级管理员','2019-09-05 15:44:56','/abs/login','POST','username=system&password=*&validCode=1',NULL,NULL,NULL,'127.0.0.1','http://127.0.0.1:8000','0','','Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:68.0) Gecko/20100101 Firefox/68.0','Windows 10','Firefox',0),('1169803615584661505','loginLogout','系统登录','system','超级管理员','2019-09-06 10:44:50','/abs/login','POST','username=system&password=*&validCode=1',NULL,NULL,NULL,'127.0.0.1','http://127.0.0.1:8000','0','','Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:68.0) Gecko/20100101 Firefox/68.0','Windows 10','Firefox',0),('1169892421310611458','loginLogout','系统登录','system','超级管理员','2019-09-06 16:37:43','/abs/login','POST','username=system&password=*&validCode=1',NULL,NULL,NULL,'127.0.0.1','http://127.0.0.1:8000','0','','Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:68.0) Gecko/20100101 Firefox/68.0','Windows 10','Firefox',0);
/*!40000 ALTER TABLE `sys_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `menu_code` varchar(64) NOT NULL COMMENT '菜单编码',
  `parent_code` varchar(64) NOT NULL COMMENT '父级编号',
  `parent_codes` varchar(1000) NOT NULL COMMENT '所有父级编号',
  `tree_sort` decimal(10,0) NOT NULL COMMENT '本级排序号（升序）',
  `tree_names` varchar(1000) NOT NULL COMMENT '全节点名',
  `menu_name` varchar(100) NOT NULL COMMENT '菜单名称',
  `menu_type` char(1) NOT NULL COMMENT '菜单类型（1菜单 2权限 3开发）',
  `menu_href` varchar(1000) DEFAULT NULL COMMENT '链接',
  `menu_target` varchar(20) DEFAULT NULL COMMENT '目标',
  `menu_icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `permission` varchar(1000) DEFAULT NULL COMMENT '权限标识',
  `weight` decimal(4,0) DEFAULT NULL COMMENT '菜单权重',
  `is_show` char(1) NOT NULL COMMENT '是否显示（1显示 0隐藏）',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  `tree_leaf` char(1) DEFAULT NULL COMMENT '是否最末级',
  `tree_level` char(1) DEFAULT NULL COMMENT '层次级别',
  PRIMARY KEY (`menu_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES ('1044886626813353984','1159363081439408129','0,1159363081439408129,',40,'系统应用/组织管理','组织管理','1','','','la la-shekel','',40,'1','0','system','2018-09-26 17:49:20','system','2019-08-20 15:57:26','','0','1'),('1044886627991953408','1044886626813353984','0,1159363081439408129,1044886626813353984,',10,'系统应用/组织管理/用户管理','用户管理','1','/sys/user/list','','','',40,'1','0','system','2018-09-26 17:49:20','system','2019-09-02 10:54:06','','0','2'),('1044886628075839488','1044886627991953408','0,1159363081439408129,1044886626813353984,1044886627991953408,',30,'系统应用/组织管理/用户管理/查看','查看','2','','','','sys:user:view',40,'1','0','system','2018-09-26 17:49:20','system','2019-09-02 10:54:06','','1','3'),('1044886628151336960','1044886627991953408','0,1159363081439408129,1044886626813353984,1044886627991953408,',40,'系统应用/组织管理/用户管理/编辑','编辑','2','','','','sys:user:edit',40,'1','0','system','2018-09-26 17:49:20','system','2019-09-02 10:54:06','','1','3'),('1044886628239417344','1044886627991953408','0,1159363081439408129,1044886626813353984,1044886627991953408,',60,'系统应用/组织管理/用户管理/分配角色','分配角色','2','','','','sys:user:authRole',40,'1','0','system','2018-09-26 17:49:20','system','2019-09-02 10:54:06','','1','3'),('1044886628323303424','1044886627991953408','0,1159363081439408129,1044886626813353984,1044886627991953408,',50,'系统应用/组织管理/用户管理/分配数据','分配数据','2','','','','sys:user:authDataScope',40,'1','0','system','2018-09-26 17:49:20','system','2019-09-02 10:54:06','','1','3'),('1044886628407189504','1044886627991953408','0,1159363081439408129,1044886626813353984,1044886627991953408,',60,'系统应用/组织管理/用户管理/停用启用','停用启用','2','','','','sys:user:updateStatus',40,'1','0','system','2018-09-26 17:49:20','system','2019-09-02 10:54:06','','1','3'),('1044886628507852800','1044886627991953408','0,1159363081439408129,1044886626813353984,1044886627991953408,',70,'系统应用/组织管理/用户管理/重置密码','重置密码','2','','','','sys:user:resetpwd',40,'1','0','system','2018-09-26 17:49:20','system','2019-09-02 10:54:06','','1','3'),('1044886628616904704','1044886626813353984','0,1159363081439408129,1044886626813353984,',50,'系统应用/组织管理/机构管理','机构管理','1','/sys/office/index','','','',60,'1','0','system','2018-09-26 17:49:20','system','2019-08-20 15:57:26','','0','2'),('1044886628709179392','1044886628616904704','0,1159363081439408129,1044886626813353984,1044886628616904704,',30,'系统应用/组织管理/机构管理/查看','查看','2','','','','sys:office:view',60,'1','0','system','2018-09-26 17:49:20','system','2019-08-20 15:57:26',NULL,'1','3'),('1044886628801454080','1044886628616904704','0,1159363081439408129,1044886626813353984,1044886628616904704,',40,'系统应用/组织管理/机构管理/编辑','编辑','2','','','','sys:office:edit',60,'1','0','system','2018-09-26 17:49:20','system','2019-08-20 15:57:26',NULL,'1','3'),('1044886628893728768','1044886626813353984','0,1159363081439408129,1044886626813353984,',70,'系统应用/组织管理/公司管理','公司管理','1','/sys/company/list','','','',60,'1','0','system','2018-09-26 17:49:20','system','2019-08-20 15:57:26','','0','2'),('1044886628990197760','1044886628893728768','0,1159363081439408129,1044886626813353984,1044886628893728768,',30,'系统应用/组织管理/公司管理/查看','查看','2','','','','sys:company:view',60,'1','0','system','2018-09-26 17:49:20','system','2019-08-20 15:57:26',NULL,'1','3'),('1044886629086666752','1044886628893728768','0,1159363081439408129,1044886626813353984,1044886628893728768,',40,'系统应用/组织管理/公司管理/编辑','编辑','2','','','','sys:company:edit',60,'1','0','system','2018-09-26 17:49:20','system','2019-08-20 15:57:26',NULL,'1','3'),('1044886629195718656','1044886626813353984','0,1159363081439408129,1044886626813353984,',70,'系统应用/组织管理/岗位管理','岗位管理','1','/sys/post/list','','','',60,'1','0','system','2018-09-26 17:49:20','system','2019-08-20 15:57:26','','0','2'),('1044886629313159168','1044886629195718656','0,1159363081439408129,1044886626813353984,1044886629195718656,',30,'系统应用/组织管理/岗位管理/查看','查看','2','','','','sys:post:view',60,'1','0','system','2018-09-26 17:49:20','system','2019-08-20 15:57:26',NULL,'1','3'),('1044886629443182592','1044886629195718656','0,1159363081439408129,1044886626813353984,1044886629195718656,',40,'系统应用/组织管理/岗位管理/编辑','编辑','2','','','','sys:post:edit',60,'1','0','system','2018-09-26 17:49:20','system','2019-08-20 15:57:26',NULL,'1','3'),('1044886629623537664','1159364927004471298','0,1159363081439408129,1159364927004471298,',30,'系统应用/系统设置/角色管理','角色管理','1','/sys/role/list','','','sys:role:edit',60,'1','0','system','2018-09-26 17:49:20','system','2019-09-02 10:53:54','','1','2'),('1044886630026190848','1159364927004471298','0,1159363081439408129,1159364927004471298,',30,'系统应用/系统设置/菜单管理','菜单管理','1','/sys/menu/list','','','sys:menu,sys:menu:view,sys:menu:edit',80,'1','0','system','2018-09-26 17:49:20','system','2019-08-08 16:08:18','','1','2'),('1044886630252683264','1159364927004471298','0,1159363081439408129,1159364927004471298,',50,'系统应用/系统设置/参数设置','参数设置','1','/sys/config/list','','icon-wrench','sys:config,sys:config:edit',60,'1','0','system','2018-09-26 17:49:20','system','2019-08-13 15:29:39','','1','2'),('1044886630344957952','1159364927004471298','0,1159363081439408129,1159364927004471298,',60,'系统应用/系统设置/字典管理','字典管理','1','/sys/dictType/list','','','',60,'1','0','system','2018-09-26 17:49:20','system','2019-08-08 16:08:09','','0','2'),('1044886630454009856','1044886630344957952','0,1159363081439408129,1159364927004471298,1044886630344957952,',30,'系统应用/系统设置/字典管理/类型查看','类型查看','2','','','','sys:dictType:view',60,'1','0','system','2018-09-26 17:49:20','system','2019-08-08 16:08:09',NULL,'1','3'),('1044886630550478848','1044886630344957952','0,1159363081439408129,1159364927004471298,1044886630344957952,',40,'系统应用/系统设置/字典管理/类型编辑','类型编辑','2','','','','sys:dictType:edit',80,'1','0','system','2018-09-26 17:49:20','system','2019-08-08 16:08:10',NULL,'1','3'),('1044886630646947840','1044886630344957952','0,1159363081439408129,1159364927004471298,1044886630344957952,',50,'系统应用/系统设置/字典管理/数据查看','数据查看','2','','','','sys:dictData:view',60,'1','0','system','2018-09-26 17:49:20','system','2019-08-08 16:08:10',NULL,'1','3'),('1044886630747611136','1044886630344957952','0,1159363081439408129,1159364927004471298,1044886630344957952,',60,'系统应用/系统设置/字典管理/数据编辑','数据编辑','2','','','','sys:dictData:edit',60,'1','0','system','2018-09-26 17:49:20','system','2019-08-08 16:08:10',NULL,'1','3'),('1044886630856663040','1159364927004471298','0,1159363081439408129,1159364927004471298,',70,'系统应用/系统设置/行政区划','行政区划','1','area','','icon-map','sys:area',60,'0','0','system','2018-09-26 17:49:21','system','2019-08-08 16:08:10','','1','2'),('1044886631477420032','1159365012094316545','0,1159363081439408129,1159365012094316545,',40,'系统应用/系统监控/访问日志','访问日志','1','/sys/log/list','','','sys:log',60,'1','0','system','2018-09-26 17:49:21','system','2019-08-08 16:07:54','','1','2'),('1044886631703912448','1159365012094316545','0,1159363081439408129,1159365012094316545,',60,'系统应用/系统监控/缓存监控','缓存监控','1','/state/cache/index','','','sys:stste:cache',80,'1','0','system','2018-09-26 17:49:21','system','2019-08-08 16:07:54','','1','2'),('1044886631812964352','1159365012094316545','0,1159363081439408129,1159365012094316545,',70,'系统应用/系统监控/服务器监控','服务器监控','1','/stateServer/index','','la la-area-chart','sys:state:server',80,'1','0','system','2018-09-26 17:49:21','system','2019-08-26 09:53:49','','1','2'),('1159361830123335682','0','0,',1000,'控制台','控制台','1','','','','',60,'1','0','system','2019-08-08 15:12:55','system','2019-08-13 13:30:58','','0','0'),('1159363081439408129','0','0,',2000,'系统应用','系统应用','1',NULL,NULL,NULL,NULL,60,'1','0','system','2019-08-08 15:17:53','system','2019-08-08 15:17:53',NULL,'0','0'),('1159363213941665793','0','0,',3000,'作业调度中心','作业调度中心','1','','','','',60,'1','0','system','2019-08-08 15:18:25','system','2019-08-19 14:05:39','','0','0'),('1159364927004471298','1159363081439408129','0,1159363081439408129,',60,'系统应用/系统设置','系统设置','1','','','la la-gear','',60,'1','0','system','2019-08-08 15:25:13','system','2019-08-08 16:08:09','','0','1'),('1159365012094316545','1159363081439408129','0,1159363081439408129,',70,'系统应用/系统监控','系统监控','1','','','la la-simplybuilt','',60,'1','0','system','2019-08-08 15:25:34','system','2019-08-08 16:07:54','','0','1'),('1159376154225045505','1159361830123335682','0,1159361830123335682,',10,'控制台/运营管控分析','运营管控分析','1','/dddd','','la la-paw','',60,'1','0','system','2019-08-08 16:09:50','system','2019-09-02 10:59:16','','1','1'),('1159376256150827010','1159361830123335682','0,1159361830123335682,',20,'控制台/数据包分析','数据包分析','1','/cccc','','la la-trademark','',60,'1','0','system','2019-08-08 16:10:14','system','2019-09-02 11:00:00','','1','1'),('1159376871719464962','1159363213941665793','0,1159363213941665793,',10,'作业调度中心/任务管理','任务管理','1','/jobsInfo/list','','la  la-repeat','',80,'1','0','system','2019-08-08 16:12:41','system','2019-08-19 14:05:39','','1','1'),('1159377074107215874','1159363213941665793','0,1159363213941665793,',20,'作业调度中心/执行器管理','执行器管理','1','/jobsRegistry/list','','la  la-puzzle-piece','',80,'1','0','system','2019-08-08 16:13:29','system','2019-08-19 14:05:39','','1','1'),('1163331106723094530','1159363213941665793','0,1159363213941665793,',30,'作业调度中心/调度日志','调度日志','1','/jobsLog/list','','la  la-sticky-note','',60,'1','0','system','2019-08-19 14:05:24','system','2019-08-19 14:05:39','','1','1'),('1163391416070868994','1159365012094316545','0,1159363081439408129,1159365012094316545,',80,'系统应用/系统监控/在线用户','在线用户','1','/sys/online/list','','','',60,'1','0','system','2019-08-19 18:05:03','system','2019-08-19 18:05:03','','1','2'),('1163704530989568002','0','0,',9001,'开发者','开发者','1','','','','',80,'1','0','system','2019-08-20 14:49:15','system','2019-08-20 14:49:15','','0','0'),('1163704668399161345','1163704530989568002','0,1163704530989568002,',10,'开发者/图标仓库','图标仓库','1','//tags/iconselect','','la la-dropbox','',80,'1','0','system','2019-08-20 14:49:48','system','2019-08-22 17:34:04','','1','1'),('1163730557321129986','1163704530989568002','0,1163704530989568002,',20,'开发者/生成代码','生成代码','1','/genTable/list','','la la-binoculars','',80,'1','0','system','2019-08-20 16:32:41','system','2019-08-21 09:39:38','','1','1');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_office`
--

DROP TABLE IF EXISTS `sys_office`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_office` (
  `office_code` varchar(64) NOT NULL COMMENT '机构编码',
  `parent_code` varchar(64) NOT NULL COMMENT '父级编号',
  `parent_codes` varchar(1000) NOT NULL COMMENT '所有父级编号',
  `tree_sort` decimal(10,0) NOT NULL COMMENT '本级排序号（升序）',
  `tree_names` varchar(1000) NOT NULL COMMENT '全节点名',
  `tree_leaf` char(1) DEFAULT NULL COMMENT '是否最末级',
  `tree_level` char(1) DEFAULT NULL COMMENT '层次级别',
  `view_code` varchar(100) NOT NULL COMMENT '机构代码',
  `office_name` varchar(100) NOT NULL COMMENT '机构名称',
  `full_name` varchar(200) NOT NULL COMMENT '机构全称',
  `office_type` char(1) NOT NULL COMMENT '机构类型',
  `leader` varchar(100) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(100) DEFAULT NULL COMMENT '办公电话',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `zip_code` varchar(100) DEFAULT NULL COMMENT '邮政编码',
  `email` varchar(300) DEFAULT NULL COMMENT '电子邮箱',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`office_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织机构表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_office`
--

LOCK TABLES `sys_office` WRITE;
/*!40000 ALTER TABLE `sys_office` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_office` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_post`
--

DROP TABLE IF EXISTS `sys_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_post` (
  `post_code` varchar(64) NOT NULL COMMENT '岗位编码',
  `post_name` varchar(100) NOT NULL COMMENT '岗位名称',
  `post_type` char(1) DEFAULT NULL COMMENT '岗位分类（高管、中层、基层）',
  `post_sort` decimal(10,0) DEFAULT NULL COMMENT '岗位排序（升序）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`post_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工岗位表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_post`
--

LOCK TABLES `sys_post` WRITE;
/*!40000 ALTER TABLE `sys_post` DISABLE KEYS */;
INSERT INTO `sys_post` VALUES ('1001DDS','项目经理','1',10,'0','system','2019-08-26 09:36:38','system','2019-08-28 08:49:46','fabcd');
/*!40000 ALTER TABLE `sys_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `role_code` varchar(64) NOT NULL COMMENT '角色编码',
  `role_name` varchar(100) NOT NULL COMMENT '角色名称',
  `role_sort` decimal(10,0) DEFAULT NULL COMMENT '角色排序（升序）',
  `data_scope` char(1) DEFAULT NULL COMMENT '数据范围设置（0未设置  1全部数据 2自定义数据）',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  `user_type` varchar(64) DEFAULT NULL COMMENT '用户类型',
  PRIMARY KEY (`role_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES ('APP','应用访问角色',20,NULL,'0','system','2019-09-02 09:57:47','system','2019-09-03 15:43:26','接口请求','member'),('corpAdmin','系统管理员',200,'0','0','system','2018-09-26 17:49:18','admin','2019-07-22 18:17:22','客户方使用的管理员角色，客户方管理员，集团管理员',NULL),('default','默认角色',100,'0','0','system','2018-09-26 17:49:18','system','2019-01-29 17:06:11','非管理员用户，共有的默认角色，在参数配置里指定',NULL),('dept','部门经理',40,'0','0','system','2018-09-26 17:49:18','system','2019-09-03 15:27:37','部门经理','employee'),('test','测试',10,NULL,'0','admin','2019-07-23 12:32:45','system','2019-09-03 15:27:42','','member'),('user','普通员工',30,'0','0','system','2018-09-26 17:49:18','system','2019-09-03 15:27:47','','employee');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_menu` (
  `role_code` varchar(64) NOT NULL COMMENT '角色编码',
  `menu_code` varchar(64) NOT NULL COMMENT '菜单编码',
  PRIMARY KEY (`role_code`,`menu_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` VALUES ('corpAdmin','1044886626813353984'),('corpAdmin','1044886627991953408'),('corpAdmin','1044886628075839488'),('corpAdmin','1044886628151336960'),('corpAdmin','1044886628239417344'),('corpAdmin','1044886628323303424'),('corpAdmin','1044886628407189504'),('corpAdmin','1044886628507852800'),('corpAdmin','1044886628616904704'),('corpAdmin','1044886628709179392'),('corpAdmin','1044886628801454080'),('corpAdmin','1044886628893728768'),('corpAdmin','1044886628990197760'),('corpAdmin','1044886629086666752'),('corpAdmin','1044886629195718656'),('corpAdmin','1044886629313159168'),('corpAdmin','1044886629443182592'),('corpAdmin','1044886629623537664'),('corpAdmin','1044886630252683264'),('corpAdmin','1044886630344957952'),('corpAdmin','1044886630454009856'),('corpAdmin','1044886630646947840'),('corpAdmin','1044886630747611136'),('corpAdmin','1044886630856663040'),('corpAdmin','1044886631477420032'),('corpAdmin','1159361830123335682'),('corpAdmin','1159363081439408129'),('corpAdmin','1159363213941665793'),('corpAdmin','1159364746838142977'),('corpAdmin','1159364927004471298'),('corpAdmin','1159365012094316545'),('corpAdmin','1159376154225045505'),('corpAdmin','1159376256150827010'),('corpAdmin','1163331106723094530'),('default','1044886626813353984'),('default','1044886627991953408'),('default','1044886628075839488'),('default','1044886628407189504'),('default','1044886628507852800'),('test','1044886629623537664'),('test','1159363081439408129'),('test','1159364746838142977'),('user','1044886626813353984'),('user','1044886627991953408'),('user','1044886628075839488');
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `user_code` varchar(100) NOT NULL COMMENT '用户编码',
  `username` varchar(100) NOT NULL COMMENT '登录账号',
  `password` varchar(100) NOT NULL COMMENT '登录密码',
  `nickname` varchar(100) NOT NULL COMMENT '用户昵称',
  `email` varchar(300) DEFAULT NULL COMMENT '电子邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号码',
  `phone` varchar(100) DEFAULT NULL COMMENT '办公电话',
  `sex` char(1) DEFAULT NULL COMMENT '用户性别',
  `avatar` varchar(1000) DEFAULT NULL COMMENT '头像路径',
  `sign` varchar(200) DEFAULT NULL COMMENT '个性签名',
  `user_type` varchar(16) NOT NULL COMMENT '用户类型',
  `mgr_type` char(1) NOT NULL COMMENT '管理员类型（0非管理员 1系统管理员）',
  `last_login_ip` varchar(100) DEFAULT NULL COMMENT '最后登陆IP',
  `last_login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `freeze_date` datetime DEFAULT NULL COMMENT '冻结时间',
  `freeze_cause` varchar(200) DEFAULT NULL COMMENT '冻结原因',
  `user_weight` decimal(8,0) DEFAULT '0' COMMENT '用户权重（降序）',
  `status` char(1) NOT NULL COMMENT '状态（0正常 1删除 2停用 3冻结）',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`user_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES ('1105305559767789568','demo','696b88143b4384907e9ce81540a547ac15d7d3a076863a9f33404825','示例1','service@alibaba.com','188','188',NULL,NULL,'','member','0','172.28.220.60','2019-05-30 13:33:26',NULL,NULL,0,'0','system','2019-03-12 11:12:42','system','2019-06-28 14:52:04','这是一个会员'),('1106506595807027200','test','cf88c985b019702407840e9986554aa88f068afd2dda87e5fccfa853','测试账号','test@alibaba.com','9','11','2',NULL,'10','member','0','192.168.82.219','2019-03-15 18:45:18',NULL,NULL,0,'2','system','2019-03-15 18:45:05','system','2019-06-28 15:07:14','5'),('1115161529677676544','test001','2ccef6d3308b5ccf01a15aa9f4180198838f651652fb3ab79d9a253a','test001','','','','2',NULL,'','member','0','10.10.0.137','2019-04-08 15:56:52',NULL,NULL,0,'2','system','2019-04-08 15:56:42','system','2019-06-28 15:06:53',''),('admin','admin','696b88143b4384907e9ce81540a547ac15d7d3a076863a9f33404825','系统管理员','ruyangit@163.com','15888888888','',NULL,'/images/default.jpg',NULL,'none','1','172.28.220.60','2019-05-29 17:56:23',NULL,NULL,0,'0','system','2018-09-26 17:49:23','system','2019-02-28 19:34:25','客户方使用的系统管理员，用于一些常用的基础数据配置。'),('system','system','66bb0152d2f77e77319cae1da426797163ed747605b0485f099a55f9','超级管理员','admin@aliyeye.com','13800000000',NULL,NULL,NULL,NULL,'none','0','172.28.220.60','2019-06-28 15:06:40',NULL,NULL,0,'0','system','2018-09-26 17:49:23','system','2018-09-26 17:49:23','开发者使用的最高级别管理员，主要用于开发和调试。'),('user10_clu3','user10','a16e958e8e159650b2f23ceb45bb85844a162ac530adb1383a5453f7','用户10','user@test.com','18555555555','053188888888',NULL,NULL,NULL,'employee','0',NULL,NULL,NULL,NULL,0,'0','system','2018-09-26 17:49:29','system','2018-09-26 17:49:29',NULL),('user11_txir','user11','d7cc86d07dceb569eff0c45ac308c7162a0e2fd1dd33ad6f40d6de43','用户11','user@test.com','18555555555','053188888888',NULL,NULL,NULL,'employee','0',NULL,NULL,NULL,NULL,0,'0','system','2018-09-26 17:49:29','system','2018-09-26 17:49:29',NULL),('user12_tnck','user12','2942b1fbe4e644bcc6c105a0f7c3f6c7e051be6a5724e95522af770d','用户12','user@test.com','18555555555','053188888888',NULL,NULL,NULL,'employee','0',NULL,NULL,NULL,NULL,0,'0','system','2018-09-26 17:49:29','system','2018-09-26 17:49:29',NULL),('user13_rlpt','user13','d0060fd25260ed3ade3b78053fac43fdb0327a557d1d65b4a19386d3','用户13','user@test.com','18555555555','053188888888',NULL,NULL,NULL,'employee','0',NULL,NULL,NULL,NULL,0,'2','system','2018-09-26 17:49:29','system','2018-09-26 17:49:29',NULL),('user14_lnb8','user14','cf38d72d87f69e819f936788639dc61927a7dd09449f79edb461df0e','用户14','user@test.com','18555555555','053188888888',NULL,NULL,NULL,'employee','0',NULL,NULL,NULL,NULL,0,'0','system','2018-09-26 17:49:29','system','2018-09-26 17:49:29',NULL),('user15_uf6s','user15','6dd01bf5df7268e2f658a7fc92a9e2fe4471c95246c71bd05319e693','用户15','user@test.com','18555555555','053188888888',NULL,NULL,NULL,'employee','0',NULL,NULL,NULL,NULL,0,'0','system','2018-09-26 17:49:29','system','2018-09-26 17:49:29',NULL),('user16_wug4','user16','d19b2bc2a6928c69831fcdb3a3067edd46024c0bd4127b54f0a28493','用户16','user@test.com','18555555555','053188888888',NULL,NULL,NULL,'employee','0',NULL,NULL,NULL,NULL,0,'0','system','2018-09-26 17:49:29','system','2018-09-26 17:49:29',NULL),('user17_av1l','user17','222d18e062d7480603bf74d29bdc1b9ab3744556c1645492ed5513a0','用户17','user@test.com','18555555555','053188888888',NULL,NULL,NULL,'employee','0',NULL,NULL,NULL,NULL,0,'0','system','2018-09-26 17:49:29','system','2018-09-26 17:49:29',NULL),('user18_hm5f','user18','40fbad0b2e8c298cc795aace1a15efefadc81ba71dee8b95118c9758','用户18','user@test.com','18555555555','053188888888',NULL,NULL,NULL,'employee','0',NULL,NULL,NULL,NULL,0,'0','system','2018-09-26 17:49:29','system','2018-09-26 17:49:29',NULL),('user19_ih6s','user19','aa2fe107257c5efab462511a946d00d0c125208a1af367421ca48a4e','用户19','user@test.com','18555555555','053188888888',NULL,NULL,NULL,'employee','0',NULL,NULL,NULL,NULL,0,'2','system','2018-09-26 17:49:29','system','2018-09-26 17:49:29',NULL),('user1_1m54','user1','$2a$08$z/0FrR5Zhu02AkQT4AUzi.u24HTn3sOxAC1J1Av9lG08maVDho5qO','用户01','user@test.com','18555555555','053188888888',NULL,NULL,NULL,'employee','0',NULL,NULL,NULL,NULL,0,'0','system','2018-09-26 17:49:28','system','2018-09-26 17:49:28',NULL),('user20_yegb','user20','b1777ce964d693834595652050db7ab22d20cec7dc848792b3f1cec8','用户20','user@test.com','18555555555','053188888888',NULL,NULL,NULL,'employee','0',NULL,NULL,NULL,NULL,0,'0','system','2018-09-26 17:49:29','system','2018-09-26 17:49:29',NULL),('user21_szgh','user21','9df34fdc28c484f92020fb20190305e8fa729d403d7a10e214972a68','用户21','user@test.com','18555555555','053188888888',NULL,NULL,NULL,'employee','0',NULL,NULL,NULL,NULL,0,'0','system','2018-09-26 17:49:29','system','2018-09-26 17:49:29',NULL),('user22_rx15','user22','a27e5ffdf924e2f4bf41ba60f6a7da3072d7fe0248164f37db6d234e','用户22','user@test.com','18555555555','053188888888',NULL,NULL,NULL,'employee','0',NULL,NULL,NULL,NULL,0,'0','system','2018-09-26 17:49:29','system','2018-09-26 17:49:29',NULL),('user23_iugi','user23','f203800bb330bcd253f44e156afe02647a19da95e0964768fae46811','用户23','user@test.com','18555555555','053188888888',NULL,NULL,NULL,'employee','0',NULL,NULL,NULL,NULL,0,'2','system','2018-09-26 17:49:29','system','2018-09-26 17:49:29',NULL),('user2_zxlx','user2','8dd3d9c3fda01fcc581416d44ab8603fd4a1c83dbb15e1cffe158ee7','用户02','user@test.com','18555555555','053188888888',NULL,NULL,NULL,'employee','0',NULL,NULL,NULL,NULL,0,'0','system','2018-09-26 17:49:29','system','2018-09-26 17:49:29',NULL),('user3_cj63','user3','75be78a17d343f40e361ff792e08877622f1500db9fe4972dcb64584','用户03','user@test.com','18555555555','053188888888',NULL,NULL,NULL,'employee','0',NULL,NULL,NULL,NULL,0,'0','system','2018-09-26 17:49:29','system','2018-09-26 17:49:29',NULL),('user4_nuef','user4','7bb34ca74bf462f01894afb8e7b6088af7c03bbb8292e2e549782f83','用户04','user@test.com','18555555555','053188888888',NULL,NULL,NULL,'employee','0',NULL,NULL,NULL,NULL,0,'0','system','2018-09-26 17:49:29','system','2018-09-26 17:49:29',NULL),('user5_iq5n','user5','434552b650676d564fc75d419bba078538fad203d4098e9dc7406826','用户05','user@test.com','18555555555','053188888888',NULL,NULL,NULL,'employee','0',NULL,NULL,NULL,NULL,0,'0','system','2018-09-26 17:49:29','system','2018-09-26 17:49:29',NULL),('user6_szow','user6','934e0948bd9a8997d74b75af039a649f3c327501c9eea7c155b5c650','用户06','user@test.com','18555555555','053188888888',NULL,NULL,NULL,'employee','0',NULL,NULL,NULL,NULL,0,'0','system','2018-09-26 17:49:29','system','2018-09-26 17:49:29',NULL),('user7_n6he','user7','555ca388945c274a0ee63fdccce0f33dcb3cd17d0ffa36f131012bb8','用户07','user@test.com','18555555555','053188888888',NULL,NULL,NULL,'employee','0',NULL,NULL,NULL,NULL,0,'0','system','2018-09-26 17:49:29','system','2018-09-26 17:49:29',NULL),('user8_ldj7','user8','a622f96e011cd166f95b316b452a0c6fc54308cae1c49ee0a90b4352','用户08','user@test.com','18555555555','053188888888',NULL,NULL,NULL,'employee','0',NULL,NULL,NULL,NULL,0,'0','system','2018-09-26 17:49:29','system','2018-09-26 17:49:29',NULL),('user9_y4ut','user9','33af878ee63b4066a51fefa92125d45d8936fb235dc68ca8f892342f','用户09','user@test.com','18555555555','053188888888',NULL,NULL,NULL,'employee','0',NULL,NULL,NULL,NULL,0,'0','system','2018-09-26 17:49:29','system','2018-09-26 17:49:29',NULL);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_post`
--

DROP TABLE IF EXISTS `sys_user_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_post` (
  `user_code` varchar(64) NOT NULL COMMENT '用户编码',
  `post_code` varchar(64) NOT NULL COMMENT '岗位编码',
  PRIMARY KEY (`user_code`,`post_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与岗位关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_post`
--

LOCK TABLES `sys_user_post` WRITE;
/*!40000 ALTER TABLE `sys_user_post` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_user_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_role` (
  `user_code` varchar(100) NOT NULL COMMENT '用户编码',
  `role_code` varchar(64) NOT NULL COMMENT '角色编码',
  PRIMARY KEY (`user_code`,`role_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES ('','PP'),('1105305559767789568','APP'),('user10_clu3','user'),('user11_txir','user'),('user12_tnck','user'),('user13_rlpt','user'),('user14_lnb8','dept'),('user15_uf6s','dept'),('user16_wug4','user'),('user17_av1l','user'),('user18_hm5f','dept'),('user19_ih6s','user'),('user1_1m54','dept'),('user20_yegb','user'),('user21_szgh','dept'),('user22_rx15','user'),('user23_iugi','user'),('user2_zxlx','user'),('user3_cj63','user'),('user4_nuef','dept'),('user5_iq5n','user'),('user6_szow','user'),('user7_n6he','dept'),('user8_ldj7','user'),('user9_y4ut','user');
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'springcareful'
--
