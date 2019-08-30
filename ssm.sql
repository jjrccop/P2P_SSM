/*
 Navicat Premium Data Transfer

 Source Server         : SSM
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : ssm

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 30/08/2019 20:25:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` bigint(8) NOT NULL AUTO_INCREMENT,
  `tradePassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `usableAmount` decimal(18, 4) NOT NULL,
  `freezedAmount` decimal(18, 4) NOT NULL,
  `borrowLimit` decimal(18, 4) NOT NULL,
  `version` int(11) NOT NULL,
  `unReceiveInterest` decimal(18, 4) NOT NULL,
  `unReceivePrincipal` decimal(18, 4) NOT NULL,
  `unReturnAmount` decimal(18, 4) NOT NULL,
  `remainBorrowLimit` decimal(18, 4) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (56, NULL, 0.0000, 0.0000, 5000.0000, 0, 0.0000, 0.0000, 0.0000, 5000.0000);
INSERT INTO `account` VALUES (66, NULL, 0.0000, 0.0000, 5000.0000, 1, 0.0000, 0.0000, 0.0000, 5000.0000);

-- ----------------------------
-- Table structure for bidrequest
-- ----------------------------
DROP TABLE IF EXISTS `bidrequest`;
CREATE TABLE `bidrequest`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL,
  `bidRequestType` tinyint(4) NOT NULL,
  `bidRequestState` tinyint(4) NOT NULL,
  `bidRequestAmount` decimal(18, 4) NOT NULL,
  `currentRate` decimal(8, 4) NOT NULL,
  `monthes2Return` tinyint(4) NOT NULL,
  `bidCount` int(11) NOT NULL,
  `totalRewardAmount` decimal(18, 4) NOT NULL,
  `currentSum` decimal(18, 4) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `disableDate` datetime(0) NULL DEFAULT NULL,
  `createuser_id` bigint(20) NOT NULL,
  `disableDays` tinyint(4) NOT NULL,
  `minBidAmount` decimal(18, 4) NOT NULL,
  `applyTime` datetime(0) NOT NULL,
  `publishTime` datetime(0) NULL DEFAULT NULL,
  `returnType` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bidrequest
-- ----------------------------
INSERT INTO `bidrequest` VALUES (11, 1, 0, 1, 5000.0000, 5.0000, 1, 0, 20.8334, 0.0000, 'aaaa', 'aaaa', '', '2019-08-31 20:04:57', 56, 1, 100.0000, '2019-08-30 11:36:57', '2019-08-30 20:04:57', 0);
INSERT INTO `bidrequest` VALUES (12, 1, 0, 1, 5000.0000, 5.0000, 1, 0, 20.8334, 0.0000, 'aaaa', 'aaaa', '', '2019-08-31 20:05:14', 56, 1, 100.0000, '2019-08-30 11:51:17', '2019-08-30 20:05:14', 0);
INSERT INTO `bidrequest` VALUES (13, 0, 0, 0, 5000.0000, 5.0000, 1, 0, 20.8334, 0.0000, 'aaaa', 'aaaa', NULL, NULL, 56, 1, 100.0000, '2019-08-30 11:52:54', NULL, 0);
INSERT INTO `bidrequest` VALUES (14, 0, 0, 0, 5000.0000, 5.0000, 1, 0, 20.8334, 0.0000, 'aaaa', 'aaaa', NULL, NULL, 56, 1, 100.0000, '2019-08-30 17:01:20', NULL, 0);
INSERT INTO `bidrequest` VALUES (15, 0, 0, 0, 5000.0000, 5.0000, 1, 0, 20.8334, 0.0000, 'aaaa', 'aaaa', NULL, NULL, 56, 1, 100.0000, '2019-08-30 17:17:35', NULL, 0);
INSERT INTO `bidrequest` VALUES (16, 0, 0, 0, 5000.0000, 5.0000, 1, 0, 20.8334, 0.0000, 'aaaa', 'aaaa', NULL, NULL, 56, 1, 100.0000, '2019-08-30 17:40:25', NULL, 0);
INSERT INTO `bidrequest` VALUES (17, 0, 0, 0, 5000.0000, 5.0000, 1, 0, 20.8334, 0.0000, 'aaaa', 'aaaa', NULL, NULL, 56, 1, 100.0000, '2019-08-30 17:40:59', NULL, 0);
INSERT INTO `bidrequest` VALUES (18, 0, 0, 0, 5000.0000, 5.0000, 1, 0, 20.8334, 0.0000, 'aaaa', 'aaaa', NULL, NULL, 56, 1, 100.0000, '2019-08-30 17:46:45', NULL, 0);
INSERT INTO `bidrequest` VALUES (19, 0, 0, 0, 5000.0000, 5.0000, 1, 0, 20.8334, 0.0000, 'aaaa', 'aaaa', NULL, NULL, 56, 1, 100.0000, '2019-08-30 17:47:38', NULL, 0);
INSERT INTO `bidrequest` VALUES (20, 0, 0, 0, 5000.0000, 5.0000, 1, 0, 20.8334, 0.0000, 'aaaa', 'aaaa', NULL, NULL, 56, 1, 100.0000, '2019-08-30 17:50:40', NULL, 0);

-- ----------------------------
-- Table structure for bidrequestaudithistory
-- ----------------------------
DROP TABLE IF EXISTS `bidrequestaudithistory`;
CREATE TABLE `bidrequestaudithistory`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `state` tinyint(4) NOT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `auditTime` datetime(0) NULL DEFAULT NULL,
  `applyTime` datetime(0) NOT NULL,
  `auditor_id` bigint(20) NULL DEFAULT NULL,
  `applier_id` bigint(20) NOT NULL,
  `bidRequestId` bigint(20) NOT NULL,
  `auditType` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bidrequestaudithistory
-- ----------------------------
INSERT INTO `bidrequestaudithistory` VALUES (1, 2, '1111', '2019-12-17 15:47:52', '2019-12-17 14:52:46', 5, 4, 1, 0);
INSERT INTO `bidrequestaudithistory` VALUES (2, 1, '2222', '2019-12-17 15:49:39', '2019-12-17 15:49:24', 5, 4, 2, 0);
INSERT INTO `bidrequestaudithistory` VALUES (3, 1, '3333', '2019-12-24 10:03:31', '2019-12-17 15:49:24', 5, 4, 2, 1);
INSERT INTO `bidrequestaudithistory` VALUES (4, 1, '4444', '2019-12-24 10:06:18', '2019-12-17 15:49:24', 5, 4, 2, 1);
INSERT INTO `bidrequestaudithistory` VALUES (5, 1, '5555', '2019-12-24 15:59:07', '2019-12-17 15:49:24', 5, 4, 2, 2);
INSERT INTO `bidrequestaudithistory` VALUES (6, 1, 'aaaaaa', '2019-08-25 18:04:10', '2019-08-24 21:15:12', 5, 4, 8, 0);
INSERT INTO `bidrequestaudithistory` VALUES (7, 1, 'gsgsdfgfg', '2019-08-26 09:34:54', '2019-08-26 09:31:53', 5, 4, 9, 0);
INSERT INTO `bidrequestaudithistory` VALUES (8, 1, '666', '2019-08-27 09:27:20', '2019-08-27 09:23:09', 5, 4, 10, 0);
INSERT INTO `bidrequestaudithistory` VALUES (9, 1, '', NULL, '2019-08-30 11:36:57', 5, 56, 11, 0);
INSERT INTO `bidrequestaudithistory` VALUES (10, 1, '', NULL, '2019-08-30 11:51:17', 5, 56, 12, 0);

-- ----------------------------
-- Table structure for iplog
-- ----------------------------
DROP TABLE IF EXISTS `iplog`;
CREATE TABLE `iplog`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `logintime` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `usertype` tinyint(4) NULL DEFAULT NULL,
  `state` tinyint(4) NULL DEFAULT NULL,
  `loginInfoId` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 160 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of iplog
-- ----------------------------
INSERT INTO `iplog` VALUES (1, '0:0:0:0:0:0:0:1', 'stef', '2019-08-27 09:54:34', 1, 1, 4);
INSERT INTO `iplog` VALUES (2, '0:0:0:0:0:0:0:1', 'admin', '2019-08-27 10:04:42', 1, 1, 6);
INSERT INTO `iplog` VALUES (3, '0:0:0:0:0:0:0:1', 'stef', '2019-08-27 10:06:52', 1, 1, 4);
INSERT INTO `iplog` VALUES (4, '0:0:0:0:0:0:0:1', 'stef', '2019-08-27 10:14:56', 1, 1, 4);
INSERT INTO `iplog` VALUES (5, '0:0:0:0:0:0:0:1', 'stef', '2019-08-27 10:29:38', 1, 1, 4);
INSERT INTO `iplog` VALUES (6, '0:0:0:0:0:0:0:1', 'stef', '2019-08-27 10:31:06', 1, 1, 4);
INSERT INTO `iplog` VALUES (7, '0:0:0:0:0:0:0:1', 'stef', '2019-08-27 10:34:59', 1, 1, 4);
INSERT INTO `iplog` VALUES (8, '0:0:0:0:0:0:0:1', 'stef', '2019-08-27 10:35:02', 1, 1, 4);
INSERT INTO `iplog` VALUES (9, '0:0:0:0:0:0:0:1', 'stef', '2019-08-27 11:08:11', 1, 1, 4);
INSERT INTO `iplog` VALUES (10, '0:0:0:0:0:0:0:1', 'admin', '2019-08-27 11:56:11', 1, 1, 6);
INSERT INTO `iplog` VALUES (11, '0:0:0:0:0:0:0:1', 'admin', '2019-08-27 11:56:22', 1, 1, 6);
INSERT INTO `iplog` VALUES (12, '0:0:0:0:0:0:0:1', 'admin', '2019-08-27 11:59:31', 1, 1, 6);
INSERT INTO `iplog` VALUES (13, '0:0:0:0:0:0:0:1', 'admin', '2019-08-27 12:01:27', 1, 1, 6);
INSERT INTO `iplog` VALUES (14, '0:0:0:0:0:0:0:1', 'admin', '2019-08-27 14:33:08', 1, 1, 6);
INSERT INTO `iplog` VALUES (15, '0:0:0:0:0:0:0:1', 'admin', '2019-08-27 14:42:21', 1, 1, 6);
INSERT INTO `iplog` VALUES (16, '0:0:0:0:0:0:0:1', 'admin', '2019-08-27 14:44:24', 1, 1, 6);
INSERT INTO `iplog` VALUES (17, '0:0:0:0:0:0:0:1', 'admin', '2019-08-27 14:58:28', 1, 1, 6);
INSERT INTO `iplog` VALUES (18, '0:0:0:0:0:0:0:1', 'admin', '2019-08-27 16:15:49', NULL, 0, NULL);
INSERT INTO `iplog` VALUES (19, '0:0:0:0:0:0:0:1', 'admin', '2019-08-27 16:15:56', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (20, '0:0:0:0:0:0:0:1', 'stef', '2019-08-27 17:28:00', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (21, '0:0:0:0:0:0:0:1', 'stef', '2019-08-28 10:01:51', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (22, '0:0:0:0:0:0:0:1', 'stef', '2019-08-28 10:02:42', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (23, '0:0:0:0:0:0:0:1', 'stef', '2019-08-28 10:06:09', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (24, '0:0:0:0:0:0:0:1', 'stef', '2019-08-28 10:11:35', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (25, '0:0:0:0:0:0:0:1', 'admin', '2019-08-28 10:26:40', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (26, '0:0:0:0:0:0:0:1', 'jjrccop1', '2019-08-28 10:27:04', NULL, 0, NULL);
INSERT INTO `iplog` VALUES (27, '0:0:0:0:0:0:0:1', 'jjrccop1', '2019-08-28 10:27:09', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (28, '0:0:0:0:0:0:0:1', 'stef', '2019-08-28 15:06:56', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (29, '0:0:0:0:0:0:0:1', 'stef', '2019-08-28 15:08:03', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (30, '0:0:0:0:0:0:0:1', 'stef', '2019-08-28 15:12:32', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (31, '0:0:0:0:0:0:0:1', 'stef', '2019-08-28 15:33:29', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (32, '0:0:0:0:0:0:0:1', 'stef', '2019-08-28 15:41:56', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (33, '0:0:0:0:0:0:0:1', 'stef', '2019-08-28 15:46:34', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (34, '0:0:0:0:0:0:0:1', 'jjrccop1', '2019-08-28 16:01:31', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (35, '0:0:0:0:0:0:0:1', 'jjrccop1', '2019-08-28 16:01:31', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (36, '0:0:0:0:0:0:0:1', 'stef', '2019-08-28 16:24:19', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (37, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-28 16:28:20', NULL, 0, NULL);
INSERT INTO `iplog` VALUES (38, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-28 16:28:25', NULL, 0, NULL);
INSERT INTO `iplog` VALUES (39, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-28 16:29:01', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (40, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-28 16:30:43', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (41, '0:0:0:0:0:0:0:1', 'stef', '2019-08-28 16:54:03', NULL, 0, NULL);
INSERT INTO `iplog` VALUES (42, '0:0:0:0:0:0:0:1', 'stef', '2019-08-28 16:54:04', NULL, 0, NULL);
INSERT INTO `iplog` VALUES (43, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-28 16:54:21', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (44, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-28 16:58:47', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (45, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 09:31:22', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (46, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 09:37:18', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (47, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 09:38:57', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (48, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 09:38:57', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (49, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 09:43:37', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (50, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 09:43:38', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (51, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 09:46:08', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (52, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 09:48:16', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (53, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 10:02:54', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (54, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 10:08:58', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (55, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 10:13:40', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (56, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 10:13:41', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (57, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 10:28:02', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (58, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 10:33:10', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (59, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 10:36:58', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (60, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 10:43:25', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (61, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 10:43:25', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (62, '0:0:0:0:0:0:0:1', 'stef', '2019-08-29 11:12:48', NULL, 0, NULL);
INSERT INTO `iplog` VALUES (63, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 11:12:57', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (64, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 11:14:45', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (65, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 11:26:45', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (66, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 11:26:56', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (67, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 11:28:29', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (68, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 11:30:49', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (69, '0:0:0:0:0:0:0:1', 'stef', '2019-08-29 11:35:35', NULL, 0, NULL);
INSERT INTO `iplog` VALUES (70, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 11:35:42', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (71, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 11:37:01', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (72, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 11:51:28', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (73, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 12:42:41', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (74, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 12:42:41', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (75, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 13:03:31', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (76, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 13:08:50', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (77, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 13:10:45', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (78, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 13:13:41', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (79, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 13:13:44', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (80, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 13:22:14', 1, 0, NULL);
INSERT INTO `iplog` VALUES (81, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 13:22:14', 1, 0, NULL);
INSERT INTO `iplog` VALUES (82, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 13:22:20', 1, 0, NULL);
INSERT INTO `iplog` VALUES (83, '0:0:0:0:0:0:0:1', 'vnaso1', '2019-08-29 13:22:38', 1, 1, 66);
INSERT INTO `iplog` VALUES (84, '0:0:0:0:0:0:0:1', 'vnaso1', '2019-08-29 13:29:22', NULL, 0, NULL);
INSERT INTO `iplog` VALUES (85, '0:0:0:0:0:0:0:1', 'vnaso1', '2019-08-29 13:29:27', NULL, 0, NULL);
INSERT INTO `iplog` VALUES (86, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 13:29:32', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (87, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 13:34:03', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (88, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 14:26:17', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (89, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 14:41:55', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (90, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 14:41:55', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (91, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 14:46:38', NULL, 1, NULL);
INSERT INTO `iplog` VALUES (92, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 15:00:40', 1, 1, 56);
INSERT INTO `iplog` VALUES (93, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 15:00:40', 1, 1, 56);
INSERT INTO `iplog` VALUES (94, '0:0:0:0:0:0:0:1', NULL, NULL, NULL, 0, NULL);
INSERT INTO `iplog` VALUES (95, '0:0:0:0:0:0:0:1', 'admin', '2019-08-29 15:13:06', 0, 1, 5);
INSERT INTO `iplog` VALUES (96, '0:0:0:0:0:0:0:1', 'admin', '2019-08-29 15:16:24', 0, 1, 5);
INSERT INTO `iplog` VALUES (97, '0:0:0:0:0:0:0:1', 'admin', '2019-08-29 15:23:53', 0, 1, 5);
INSERT INTO `iplog` VALUES (98, '0:0:0:0:0:0:0:1', 'admin', '2019-08-29 15:28:46', 0, 1, 5);
INSERT INTO `iplog` VALUES (99, '0:0:0:0:0:0:0:1', 'admin', '2019-08-29 15:56:09', 0, 1, 5);
INSERT INTO `iplog` VALUES (100, '0:0:0:0:0:0:0:1', 'admin', '2019-08-29 16:01:01', 0, 1, 5);
INSERT INTO `iplog` VALUES (101, '0:0:0:0:0:0:0:1', 'admin', '2019-08-29 16:03:36', 0, 1, 5);
INSERT INTO `iplog` VALUES (102, '0:0:0:0:0:0:0:1', 'admin', '2019-08-29 16:06:38', 0, 1, 5);
INSERT INTO `iplog` VALUES (103, '0:0:0:0:0:0:0:1', 'admin', '2019-08-29 16:12:40', 0, 1, 5);
INSERT INTO `iplog` VALUES (104, '0:0:0:0:0:0:0:1', 'admin', '2019-08-29 16:15:25', 0, 1, 5);
INSERT INTO `iplog` VALUES (105, '0:0:0:0:0:0:0:1', 'admin', '2019-08-29 16:18:30', 0, 1, 5);
INSERT INTO `iplog` VALUES (106, '0:0:0:0:0:0:0:1', 'admin', '2019-08-29 16:23:21', 0, 1, 5);
INSERT INTO `iplog` VALUES (107, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 16:45:33', 1, 1, 56);
INSERT INTO `iplog` VALUES (108, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 16:45:33', 1, 1, 56);
INSERT INTO `iplog` VALUES (109, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 16:46:50', 1, 1, 56);
INSERT INTO `iplog` VALUES (110, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 17:13:48', 1, 1, 56);
INSERT INTO `iplog` VALUES (111, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 17:16:35', 1, 1, 56);
INSERT INTO `iplog` VALUES (112, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 17:21:24', 1, 1, 56);
INSERT INTO `iplog` VALUES (113, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 17:21:26', 1, 1, 56);
INSERT INTO `iplog` VALUES (114, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 17:57:19', 1, 1, 56);
INSERT INTO `iplog` VALUES (115, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 17:57:19', 1, 1, 56);
INSERT INTO `iplog` VALUES (116, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 18:03:56', 1, 1, 56);
INSERT INTO `iplog` VALUES (117, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 18:07:49', 1, 1, 56);
INSERT INTO `iplog` VALUES (118, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 18:07:49', 1, 1, 56);
INSERT INTO `iplog` VALUES (119, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 18:20:41', 1, 1, 56);
INSERT INTO `iplog` VALUES (120, '0:0:0:0:0:0:0:1', 'admin', '2019-08-29 19:11:57', 0, 1, 5);
INSERT INTO `iplog` VALUES (121, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 21:11:56', 1, 1, 56);
INSERT INTO `iplog` VALUES (122, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 21:11:57', 1, 1, 56);
INSERT INTO `iplog` VALUES (123, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 21:47:07', 1, 1, 56);
INSERT INTO `iplog` VALUES (124, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-29 21:47:07', 1, 1, 56);
INSERT INTO `iplog` VALUES (125, '0:0:0:0:0:0:0:1', NULL, NULL, NULL, 0, NULL);
INSERT INTO `iplog` VALUES (126, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-30 09:43:56', 1, 1, 56);
INSERT INTO `iplog` VALUES (127, '0:0:0:0:0:0:0:1', NULL, NULL, NULL, 0, NULL);
INSERT INTO `iplog` VALUES (128, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-30 10:36:51', 1, 1, 56);
INSERT INTO `iplog` VALUES (129, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-30 10:45:24', 1, 1, 56);
INSERT INTO `iplog` VALUES (130, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-30 10:45:24', 1, 1, 56);
INSERT INTO `iplog` VALUES (131, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-30 10:51:31', 1, 1, 56);
INSERT INTO `iplog` VALUES (132, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-30 10:51:31', 1, 1, 56);
INSERT INTO `iplog` VALUES (133, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-30 10:58:14', 1, 1, 56);
INSERT INTO `iplog` VALUES (134, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-30 10:58:16', 1, 1, 56);
INSERT INTO `iplog` VALUES (135, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-30 11:04:09', 1, 1, 56);
INSERT INTO `iplog` VALUES (136, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-30 11:09:47', 1, 1, 56);
INSERT INTO `iplog` VALUES (137, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-30 11:17:32', 1, 1, 56);
INSERT INTO `iplog` VALUES (138, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-30 11:36:42', 1, 1, 56);
INSERT INTO `iplog` VALUES (139, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-30 11:52:44', 1, 1, 56);
INSERT INTO `iplog` VALUES (140, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-30 17:00:28', 1, 1, 56);
INSERT INTO `iplog` VALUES (141, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-30 17:25:15', 1, 1, 56);
INSERT INTO `iplog` VALUES (142, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-30 17:46:36', 1, 1, 56);
INSERT INTO `iplog` VALUES (143, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-30 17:49:49', 1, 1, 56);
INSERT INTO `iplog` VALUES (144, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-30 17:51:59', 1, 1, 56);
INSERT INTO `iplog` VALUES (145, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-30 18:04:41', 1, 1, 56);
INSERT INTO `iplog` VALUES (146, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-30 18:57:57', 1, 1, 56);
INSERT INTO `iplog` VALUES (147, '0:0:0:0:0:0:0:1', NULL, NULL, NULL, 0, NULL);
INSERT INTO `iplog` VALUES (148, '0:0:0:0:0:0:0:1', 'admin', '2019-08-30 19:06:45', 0, 1, 5);
INSERT INTO `iplog` VALUES (149, '0:0:0:0:0:0:0:1', 'admin', '2019-08-30 19:24:05', 0, 1, 5);
INSERT INTO `iplog` VALUES (150, '0:0:0:0:0:0:0:1', 'admin', '2019-08-30 19:26:47', 0, 1, 5);
INSERT INTO `iplog` VALUES (151, '0:0:0:0:0:0:0:1', 'admin', '2019-08-30 19:30:54', 0, 1, 5);
INSERT INTO `iplog` VALUES (152, '0:0:0:0:0:0:0:1', 'admin', '2019-08-30 19:33:45', 0, 1, 5);
INSERT INTO `iplog` VALUES (153, '0:0:0:0:0:0:0:1', 'admin', '2019-08-30 19:36:07', 0, 1, 5);
INSERT INTO `iplog` VALUES (154, '0:0:0:0:0:0:0:1', 'admin', '2019-08-30 19:47:38', 0, 1, 5);
INSERT INTO `iplog` VALUES (155, '0:0:0:0:0:0:0:1', 'admin', '2019-08-30 20:01:47', 0, 1, 5);
INSERT INTO `iplog` VALUES (156, '0:0:0:0:0:0:0:1', 'admin', '2019-08-30 20:04:52', 0, 1, 5);
INSERT INTO `iplog` VALUES (157, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-30 20:06:56', 1, 1, 56);
INSERT INTO `iplog` VALUES (158, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-30 20:11:33', 1, 1, 56);
INSERT INTO `iplog` VALUES (159, '0:0:0:0:0:0:0:1', 'jjrccop', '2019-08-30 20:18:02', 1, 1, 56);

-- ----------------------------
-- Table structure for logininfo
-- ----------------------------
DROP TABLE IF EXISTS `logininfo`;
CREATE TABLE `logininfo`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` tinyint(4) NULL DEFAULT NULL,
  `usertype` tinyint(4) NULL DEFAULT NULL,
  `admin` bit(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of logininfo
-- ----------------------------
INSERT INTO `logininfo` VALUES (5, 'admin', '1234', 0, 0, b'1');
INSERT INTO `logininfo` VALUES (56, 'jjrccop', '6526423', 0, 1, b'0');
INSERT INTO `logininfo` VALUES (66, 'vnaso1', 'E10ADC3949BA59ABBE56E057F20F883E', 0, 1, b'0');

-- ----------------------------
-- Table structure for mailverify
-- ----------------------------
DROP TABLE IF EXISTS `mailverify`;
CREATE TABLE `mailverify`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `logininfo_id` bigint(20) NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sendTime` datetime(0) NOT NULL,
  `uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mailverify
-- ----------------------------
INSERT INTO `mailverify` VALUES (11, 56, 'jjrccop@163.com', '2019-08-28 16:29:46', 'b286d1c0151d441d837e6249ebf9fc44');
INSERT INTO `mailverify` VALUES (12, 56, 'jjrccop@163.com', '2019-08-29 18:29:21', '2c9da5c54d83458eaa8ded03e4ee8cb8');

-- ----------------------------
-- Table structure for systemdictionary
-- ----------------------------
DROP TABLE IF EXISTS `systemdictionary`;
CREATE TABLE `systemdictionary`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of systemdictionary
-- ----------------------------
INSERT INTO `systemdictionary` VALUES (1, 'incomeGrade', '月收入', NULL);
INSERT INTO `systemdictionary` VALUES (2, 'educationBackground', '学历', NULL);
INSERT INTO `systemdictionary` VALUES (3, 'marriage', '婚姻', NULL);
INSERT INTO `systemdictionary` VALUES (4, 'kidCount', '子女', NULL);
INSERT INTO `systemdictionary` VALUES (5, 'houseCondition', '住房条件', NULL);
INSERT INTO `systemdictionary` VALUES (6, 'userFileType', '风控资料类型', NULL);

-- ----------------------------
-- Table structure for systemdictionaryitem
-- ----------------------------
DROP TABLE IF EXISTS `systemdictionaryitem`;
CREATE TABLE `systemdictionaryitem`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parentId` bigint(20) NOT NULL,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tvalue` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sequence` tinyint(4) NOT NULL,
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of systemdictionaryitem
-- ----------------------------
INSERT INTO `systemdictionaryitem` VALUES (1, 1, '3000以下', NULL, 1, NULL);
INSERT INTO `systemdictionaryitem` VALUES (2, 1, '3000~5000', NULL, 2, NULL);
INSERT INTO `systemdictionaryitem` VALUES (3, 2, '大专以下', NULL, 1, NULL);
INSERT INTO `systemdictionaryitem` VALUES (4, 2, '大专', NULL, 2, NULL);
INSERT INTO `systemdictionaryitem` VALUES (5, 3, '已婚', NULL, 1, NULL);
INSERT INTO `systemdictionaryitem` VALUES (6, 3, '未婚', NULL, 2, NULL);
INSERT INTO `systemdictionaryitem` VALUES (7, 4, '有子女', NULL, 1, NULL);
INSERT INTO `systemdictionaryitem` VALUES (8, 4, '无子女', NULL, 2, NULL);
INSERT INTO `systemdictionaryitem` VALUES (9, 5, '有自有房', NULL, 1, NULL);
INSERT INTO `systemdictionaryitem` VALUES (10, 5, '无自有房', NULL, 2, NULL);
INSERT INTO `systemdictionaryitem` VALUES (11, 5, '租房', NULL, 3, NULL);
INSERT INTO `systemdictionaryitem` VALUES (12, 6, '房产证正面', NULL, 1, NULL);
INSERT INTO `systemdictionaryitem` VALUES (13, 6, '房产证反面', NULL, 2, NULL);
INSERT INTO `systemdictionaryitem` VALUES (14, 6, '户口本', NULL, 3, NULL);
INSERT INTO `systemdictionaryitem` VALUES (15, 6, '结婚证', NULL, 4, NULL);
INSERT INTO `systemdictionaryitem` VALUES (16, 6, '银行流水证明', NULL, 5, NULL);
INSERT INTO `systemdictionaryitem` VALUES (17, 6, '学位证', NULL, 6, NULL);
INSERT INTO `systemdictionaryitem` VALUES (18, 6, '毕业证', NULL, 7, NULL);
INSERT INTO `systemdictionaryitem` VALUES (19, 6, '电话记录', NULL, 7, NULL);

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `id` bigint(20) NOT NULL,
  `version` int(11) NOT NULL,
  `bitState` bigint(20) NOT NULL,
  `realName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `idNumber` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phoneNumber` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `incomeGrade_id` bigint(20) NULL DEFAULT NULL,
  `marriage_id` bigint(20) NULL DEFAULT NULL,
  `kidCount_id` bigint(20) NULL DEFAULT NULL,
  `educationBackground_id` bigint(20) NULL DEFAULT NULL,
  `authScore` int(11) NULL DEFAULT NULL,
  `houseCondition_id` bigint(20) NULL DEFAULT NULL,
  `realauthid` bigint(20) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (56, 0, 39, 'Jerry', '231004199803280713', '18512808634', 2, 6, 8, 3, 33, 9, 1, 'jjrccop@163.com');
INSERT INTO `userinfo` VALUES (66, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
