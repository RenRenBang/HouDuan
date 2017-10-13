/*
MySQL Data Transfer
Source Host: localhost
Source Database: ssm
Target Host: localhost
Target Database: ssm
Date: 2017/10/12 20:11:13
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `cid` int(11) NOT NULL,
  `uid` int(11) DEFAULT NULL,
  `oid` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records 
-- ----------------------------
