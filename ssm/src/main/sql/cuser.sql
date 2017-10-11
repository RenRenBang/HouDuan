/*
MySQL Data Transfer
Source Host: localhost
Source Database: ssm
Target Host: localhost
Target Database: ssm
Date: 2017/10/11 15:36:45
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for cuser
-- ----------------------------
DROP TABLE IF EXISTS `cuser`;
CREATE TABLE `cuser` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `upassword` varchar(255) COLLATE utf8_bin NOT NULL,
  `uphone` varchar(255) COLLATE utf8_bin NOT NULL,
  `unickname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `uidnumber` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `uimage` blob,
  `uphotopath` blob,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records 
-- ----------------------------
