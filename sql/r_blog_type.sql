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

 Date: 25/04/2020 14:17:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for r_blog_type
-- ----------------------------
DROP TABLE IF EXISTS `r_blog_type`;
CREATE TABLE `r_blog_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `blog_id` bigint(20) NOT NULL COMMENT '博客ID',
  `type_id` bigint(20) NOT NULL COMMENT '分类ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
