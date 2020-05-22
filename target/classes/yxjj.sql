/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.0.9_3306
 Source Server Type    : MySQL
 Source Server Version : 50624
 Source Host           : 192.168.0.9:3306
 Source Schema         : yxjj

 Target Server Type    : MySQL
 Target Server Version : 50624
 File Encoding         : 65001

 Date: 20/05/2020 20:50:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sign_record
-- ----------------------------
DROP TABLE IF EXISTS `sign_record`;
CREATE TABLE `sign_record`  (
   `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(1) NOT NULL COMMENT '用户id',
  `open_id` varchar(60) DEFAULT NULL COMMENT 'open_id',
  `sign_date` datetime NOT NULL COMMENT '签到日期',
  `three_count` int(11) NOT NULL COMMENT '连续三天签到数',
  `seven_count` int(11) NOT NULL COMMENT '连续七天签到数',
  `fourteen_count` int(11) NOT NULL COMMENT '连续十四天签到数',
  `total_count` int(11) NOT NULL COMMENT '总签到数',
  `createDate` datetime NOT NULL,
  `is_delete` int(1) DEFAULT NULL COMMENT '是否删除，1是，2否',
  `deleteUID` int(11) DEFAULT NULL,
  `deleteDate` datetime DEFAULT NULL,
  `updateUID` int(11) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '签到表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL COMMENT '主键id',
  `wxid` varchar(60) DEFAULT NULL COMMENT '微信账户号',
  `wx_photo_url` varchar(300) NOT NULL COMMENT '微信头像url',
  `login_name` varchar(60) NOT NULL COMMENT '用户名',
  `nick_name` varchar(60) NOT NULL COMMENT '昵称',
  `sum_score` int(11) NOT NULL COMMENT '总积分',
  `promote_number` int(11) NOT NULL COMMENT '推广人数',
  `login_pwd` varchar(30) NOT NULL COMMENT '登录密码',
  `salt` varchar(60) NOT NULL COMMENT '盐值',
  `last_login_date` datetime DEFAULT NULL COMMENT '最后登录日期',
  `idCardNo` varchar(30) NOT NULL COMMENT '身份证号',
  `contact` int(11) NOT NULL COMMENT '联系电话',
  `family_address` varchar(60) NOT NULL COMMENT '家庭住址',
  `current_address` varchar(60) NOT NULL COMMENT '现居住地址',
  `user_type` int(1) NOT NULL COMMENT '用户类型',
  `related_person` int(1) NOT NULL COMMENT '上级关联人',
  `create_uid` int(11) NOT NULL COMMENT '创建用户id',
  `create_date` datetime NOT NULL COMMENT '创建日期',
  `update_uid` int(11) DEFAULT NULL COMMENT '更新用户id',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `delete_uid` int(11) DEFAULT NULL COMMENT '删除用户id',
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  `is_delete` int(1) DEFAULT '2' COMMENT '1删除2不删除',
  `open_id` varchar(60) DEFAULT NULL COMMENT 'open_id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_user_related
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_related`;
CREATE TABLE `sys_user_related`  (
  `id` int(11) NOT NULL COMMENT '主键id',
  `wxid` varchar(60) DEFAULT NULL COMMENT '微信账户号',
  `parent_id` varchar(60) NOT NULL COMMENT '父id',
  `child_id` varchar(60) NOT NULL COMMENT '子id',
  `fx_level` varchar(60) NOT NULL COMMENT 'child_id属于parent_id的几级用户',
  `create_uid` int(11) NOT NULL COMMENT '创建用户id',
  `create_date` datetime NOT NULL COMMENT '创建日期',
  `update_uid` int(11) DEFAULT NULL COMMENT '更新用户id',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `delete_uid` int(11) DEFAULT NULL COMMENT '删除用户id',
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  `is_delete` int(1) DEFAULT '2' COMMENT '1删除2不删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for yxjj_apply
-- ----------------------------
DROP TABLE IF EXISTS `yxjj_apply`;
CREATE TABLE `yxjj_apply`  (
  `id` int(18) NOT NULL AUTO_INCREMENT,
  `org_name` varchar(100) DEFAULT NULL COMMENT '申请的机构或者院校名字',
  `applyer_name` varchar(255) DEFAULT NULL COMMENT '负责人名字',
  `applyer_phone` varchar(30) NOT NULL COMMENT '负责人电话',
  `apply_type` int(1) DEFAULT NULL COMMENT '申请类型 1机构 2院校 3个人',
  `approval_status` int(1) DEFAULT '0' COMMENT '审批状态 1通过 2不通过',
  `create_uid` int(18) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `approval_uid` int(18) DEFAULT NULL,
  `approval_date` datetime DEFAULT NULL,
  `is_delete` int(1) DEFAULT NULL,
  `delete_uid` int(18) DEFAULT NULL,
  `delete_date` datetime DEFAULT NULL,
  `delete_reason` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '入驻申请表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for yxjj_data_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `yxjj_data_dictionary`;
CREATE TABLE `yxjj_data_dictionary`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_code` int(1) NOT NULL COMMENT '1院校2专业3.提升层次4.上课类型5.学制6.科类',
  `data_name` varchar(100) NOT NULL COMMENT '名称',
  `createUID` int(11) NOT NULL,
  `createDate` datetime NOT NULL,
  `is_delete` int(1) DEFAULT NULL COMMENT '是否删除，1是，2否',
  `deleteUID` int(11) DEFAULT NULL,
  `deleteDate` datetime DEFAULT NULL,
  `updateUID` int(11) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '易学佳家数据字典表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for yxjj_edu_institution
-- ----------------------------
DROP TABLE IF EXISTS `yxjj_edu_institution`;
CREATE TABLE `yxjj_edu_institution`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `institution_name` varchar(100) NOT NULL COMMENT '机构名称',
  `cover_photo` varchar(100) DEFAULT NULL COMMENT '封面图片路径',
  `province` varchar(60) DEFAULT NULL COMMENT '省份',
  `city` varchar(60) DEFAULT NULL COMMENT '城市',
  `county` varchar(60) DEFAULT NULL COMMENT '县区',
  `institution_type` int(1) DEFAULT NULL COMMENT '机构类型1学历提升2成人教育3教师资格',
  `year_limit` varchar(30) DEFAULT NULL COMMENT '年限 1年 2年 3年 4年 5年',
  `sort` int(11) DEFAULT NULL COMMENT '排序号',
  `createDate` datetime NOT NULL,
  `updateUID` int(11) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `is_delete` int(1) NOT NULL COMMENT '是否删除，1是，2否',
  `deleteUID` int(11) DEFAULT NULL,
  `deleteDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 344 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '教育机构表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for yxjj_edu_institution_school
-- ----------------------------
DROP TABLE IF EXISTS `yxjj_edu_institution_school`;
CREATE TABLE `yxjj_edu_institution_school`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `institution_id` int(11) DEFAULT NULL COMMENT '机构id',
  `school_name` varchar(100) DEFAULT NULL COMMENT '学校名称',
  `cover_phpto` varchar(100) DEFAULT NULL COMMENT '学校封面图片路径',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注（如专升本 美术教育 考证等）',
  `sort` bigint(255) DEFAULT NULL COMMENT '排序号',
  `createUID` int(11) NOT NULL,
  `createDate` datetime NOT NULL,
  `updateUID` int(11) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `is_delete` int(1) NOT NULL COMMENT '是否删除，1是，2否',
  `deleteUID` int(11) DEFAULT NULL,
  `deleteDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 344 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '教育机构表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for yxjj_file
-- ----------------------------
DROP TABLE IF EXISTS `yxjj_file`;
CREATE TABLE `yxjj_file`  (
   `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_path` varchar(255) NOT NULL,
  `file_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '易学佳家文件表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for yxjj_goods
-- ----------------------------
DROP TABLE IF EXISTS `yxjj_goods`;
CREATE TABLE `yxjj_goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_title` varchar(100) DEFAULT NULL COMMENT '商品标题',
  `goods_name` varchar(100) NOT NULL COMMENT '商品名字',
  `goods_color` varchar(100) DEFAULT NULL COMMENT '商品颜色',
  `goods_weight` varchar(100) DEFAULT NULL COMMENT '商品重量',
  `goods_content` text COMMENT '商品详情',
  `goods_type` int(1) DEFAULT NULL COMMENT '1限时购2热门推荐3人气单品4新品',
  `activity_end_date` datetime DEFAULT NULL COMMENT '活动结束时间',
  `goods_sort` int(11) DEFAULT NULL COMMENT '商品顺序（可根据后管排序）',
  `goods_score` int(11) DEFAULT NULL COMMENT '单个商品积分',
  `goods_price` decimal(10,2) DEFAULT NULL COMMENT '单个商品价格',
  `goods_remark` varchar(300) DEFAULT NULL COMMENT '商品备注',
  `create_date` datetime NOT NULL,
  `create_uid` int(11) NOT NULL,
  `update_uid` int(11) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_delete` int(1) NOT NULL,
  `delete_reason` varchar(255) DEFAULT NULL COMMENT '删除原因',
  `delete_uid` int(11) DEFAULT NULL,
  `delete_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品详情表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for yxjj_information_text
-- ----------------------------
DROP TABLE IF EXISTS `yxjj_information_text`;
CREATE TABLE `yxjj_information_text`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cover_phpto` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面图片路径',
  `content` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '资讯内容',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序号',
  `readNum` int(11) NULL DEFAULT 0 COMMENT '阅读量',
  `createUID` int(11) NOT NULL,
  `createDate` datetime(0) NOT NULL,
  `updateUID` int(11) NULL DEFAULT NULL,
  `updateDate` datetime(0) NULL DEFAULT NULL,
  `is_delete` int(1) NOT NULL COMMENT '是否删除，1是，2否',
  `deleteUID` int(11) NULL DEFAULT NULL,
  `deleteDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 344 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '易学佳家资讯表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for yxjj_order
-- ----------------------------
DROP TABLE IF EXISTS `yxjj_order`;
CREATE TABLE `yxjj_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(60) DEFAULT NULL COMMENT 'open_id',
  `order_code` varchar(60) DEFAULT NULL COMMENT '订单号',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品id',
  `goods_number` int(11) DEFAULT NULL COMMENT '商品数量',
  `pay_type` int(1) DEFAULT NULL COMMENT '付款方式 1为现金购买 2积分购买',
  `order_theory_amount` decimal(10,2) DEFAULT NULL COMMENT '订单理论金额',
  `order_fact_amount` decimal(10,2) DEFAULT NULL COMMENT '订单实际金额',
  `consume_score` int(11) DEFAULT NULL COMMENT '消耗积分',
  `send_type` varchar(30) DEFAULT NULL COMMENT '配送方式（顺丰快递）',
  `order_address` varchar(300) DEFAULT NULL COMMENT '订单地址',
  `createDate` datetime NOT NULL,
  `is_delete` int(1) DEFAULT NULL COMMENT '是否删除，1是，2否',
  `deleteUID` int(11) DEFAULT NULL,
  `deleteDate` datetime DEFAULT NULL,
  `updateUID` int(11) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for yxjj_sign
-- ----------------------------
DROP TABLE IF EXISTS `yxjj_sign`;
CREATE TABLE `yxjj_sign`  (
  `id` int(11) NOT NULL COMMENT '主键id',
  `open_id` varchar(60) DEFAULT NULL COMMENT '微信账户号',
  `login_name` varchar(60) NOT NULL COMMENT '用户名',
  `gender` int(1) NOT NULL COMMENT '1男2女',
  `edu_background` varchar(60) DEFAULT NULL COMMENT '学历',
  `nation` varchar(60) DEFAULT NULL COMMENT '民族',
  `politics_status` varchar(60) DEFAULT NULL COMMENT '政治面貌',
  `idCardNo` varchar(30) DEFAULT NULL COMMENT '身份证',
  `email_address` varchar(60) DEFAULT NULL COMMENT '资料邮寄地址',
  `contact` int(11) NOT NULL COMMENT '手机号码',
  `remark_contact` int(11) NOT NULL COMMENT '备用电话',
  `family_address` varchar(60) NOT NULL COMMENT '户籍所在地',
  `current_address` varchar(60) NOT NULL COMMENT '现居住地址',
  `pos_certificate_url` varchar(300) NOT NULL COMMENT '身份证证件照正面',
  `neg_certificate_url` varchar(300) NOT NULL COMMENT '身份证证件照反面',
  `graduate_certificate_url` varchar(300) NOT NULL COMMENT '毕业证url',
  `create_uid` int(11) NOT NULL COMMENT '创建用户id',
  `create_date` datetime NOT NULL COMMENT '创建日期',
  `update_uid` int(11) DEFAULT NULL COMMENT '更新用户id',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `delete_uid` int(11) DEFAULT NULL COMMENT '删除用户id',
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  `is_delete` int(1) DEFAULT '2' COMMENT '1删除2不删除'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '报名信息表' ROW_FORMAT = Compact;

