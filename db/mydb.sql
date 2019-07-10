/*
 Navicat Premium Data Transfer

 Source Server         : mySQL
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : mydb

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 10/07/2019 15:57:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goodsId` int(11) NOT NULL,
  `index` int(11) NOT NULL,
  `value` int(11) NOT NULL,
  `pickupLocationX` double(10, 0) NOT NULL,
  `pickupLocationY` double(10, 0) NOT NULL,
  `deliveryLocationX` double(10, 0) NOT NULL,
  `deliveryLocationY` double(10, 0) NOT NULL,
  PRIMARY KEY (`goodsId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (201, 0, 1, 5, 7, 6, 9);
INSERT INTO `goods` VALUES (202, 0, 1, 5, 13, 6, 11);
INSERT INTO `goods` VALUES (203, 0, 1, 15, 7, 14, 9);
INSERT INTO `goods` VALUES (204, 0, 1, 15, 13, 14, 11);

-- ----------------------------
-- Table structure for solutions
-- ----------------------------
DROP TABLE IF EXISTS `solutions`;
CREATE TABLE `solutions`  (
  `solutionId` int(8) NOT NULL,
  `vehicleId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cost` double(16, 6) NOT NULL,
  PRIMARY KEY (`solutionId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for vehicle
-- ----------------------------
DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE `vehicle`  (
  `vehicleId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `vehicleType` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `index` int(11) NOT NULL,
  `capacity` int(11) NOT NULL,
  `start` double(10, 0) NOT NULL,
  `end` double(10, 0) NOT NULL,
  PRIMARY KEY (`vehicleId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vehicle
-- ----------------------------
INSERT INTO `vehicle` VALUES ('101', 'typeA', 0, 2, 10, 10);

SET FOREIGN_KEY_CHECKS = 1;
