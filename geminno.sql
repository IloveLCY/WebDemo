/*
Navicat MySQL Data Transfer

Source Server         : sql_a
Source Server Version : 50534
Source Host           : localhost:3306
Source Database       : geminno

Target Server Type    : MYSQL
Target Server Version : 50534
File Encoding         : 65001

Date: 2019-12-05 19:12:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptId` int(11) NOT NULL AUTO_INCREMENT,
  `deptName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`deptId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '开发部');
INSERT INTO `dept` VALUES ('2', '测试部');
INSERT INTO `dept` VALUES ('3', '人事部');
INSERT INTO `dept` VALUES ('4', '投资部');
INSERT INTO `dept` VALUES ('5', '公关部');

-- ----------------------------
-- Table structure for `emp`
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `empId` varchar(36) NOT NULL DEFAULT '',
  `empNo` varchar(20) DEFAULT NULL,
  `empName` varchar(30) DEFAULT NULL,
  `sex` bit(1) DEFAULT NULL,
  `salary` decimal(7,2) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `deptId` int(11) DEFAULT NULL,
  PRIMARY KEY (`empId`),
  KEY `fk_emp_deptId` (`deptId`),
  CONSTRAINT `fk_emp_deptId` FOREIGN KEY (`deptId`) REFERENCES `dept` (`deptId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('024be19d-6638-1035-a2ef-853060517864', 'e001', '张强', '', '6700.00', '1990-01-01 00:00:00', '1');
INSERT INTO `emp` VALUES ('0254321e-6638-1035-a2ef-853060517864', 'e002', '小丽', '', '9700.00', '1992-01-01 00:00:00', '2');
INSERT INTO `emp` VALUES ('025b0229-6638-1035-a2ef-853060517864', 'e003', 'jack', '', '6700.00', '1990-01-01 00:00:00', '1');
INSERT INTO `emp` VALUES ('02609638-6638-1035-a2ef-853060517864', 'e004', 'lily', '', '6700.00', '1990-01-01 00:00:00', '2');
INSERT INTO `emp` VALUES ('3f9ae454-3181-11e7-a947-3417eb6bc2c7', 'e343', 'jobs', '', '2346.00', '1991-01-01 00:00:00', '3');
INSERT INTO `emp` VALUES ('47c442ef-21a9-11e7-bb66-3417eb6bc2c7', 'e009', 'jobs', '', '2346.00', '1991-01-01 00:00:00', '1');
INSERT INTO `emp` VALUES ('5167156c-21a4-11e7-bb66-3417eb6bc2c7', 'e009', 'jobs', '', '2346.00', '1991-01-01 00:00:00', '3');
INSERT INTO `emp` VALUES ('7101eefc-231c-11e7-bb66-3417eb6bc2c7', 'e009', 'jobs', '', '2346.00', '1991-01-01 00:00:00', '5');
INSERT INTO `emp` VALUES ('9d1b9560-3180-11e7-a947-3417eb6bc2c7', 'e032', 'lucy', '', '7000.00', '1991-02-22 00:00:00', '1');
INSERT INTO `emp` VALUES ('a5654dd3-231d-11e7-bb66-3417eb6bc2c7', 'e009', 'jobs', '', '2346.00', '1991-01-01 00:00:00', '3');
INSERT INTO `emp` VALUES ('d072ef11-3253-11e7-a947-3417eb6bc2c7', 'e220', 'jack', '', '6000.00', '1992-05-03 00:00:00', '4');
INSERT INTO `emp` VALUES ('ece19e14-1ddb-11e7-bb66-3417eb6bc2c7', 'e008', 'lily', '', '2365.00', '1991-01-20 00:00:00', '5');
