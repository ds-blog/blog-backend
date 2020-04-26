/*
 Navicat Premium Data Transfer

 Source Server         : blog
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 25/04/2020 14:15:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '标题',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '内容',
  `user_id` bigint(20) NOT NULL COMMENT '发表者ID',
  `banner` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '横幅banner',
  `views` bigint(20) DEFAULT NULL COMMENT '浏览量',
  `status` int(2) NOT NULL DEFAULT '0' COMMENT '博客状态(0: 发布 1: 草稿 2: 回收)',
  `likenum` bigint(20) DEFAULT NULL COMMENT '点赞量',
  `appreciation` int(1) NOT NULL DEFAULT '0' COMMENT '是否开启赞赏(0: 关闭 1: 开启)',
  `commentAble` int(1) NOT NULL DEFAULT '0' COMMENT '是否开启评论(0: 关闭 1: 开启)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
