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

 Date: 25/04/2020 14:17:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `blog_id` bigint(20) NOT NULL COMMENT '博客ID',
  `user_id` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '评论者ID',
  `avatar` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '评论者头像',
  `content` text COLLATE utf8mb4_bin COMMENT '评论内容',
  `likenum` bigint(20) DEFAULT NULL COMMENT '点赞数',
  `parent_id` bigint(20) NOT NULL COMMENT '父评论ID',
  `create_time` datetime DEFAULT NULL COMMENT '评论日期',
  `update_time` datetime DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

SET FOREIGN_KEY_CHECKS = 1;
