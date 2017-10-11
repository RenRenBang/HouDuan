/*
MySQL Data Transfer
Source Host: localhost
Source Database: ssm
Target Host: localhost
Target Database: ssm
Date: 2017/10/10 19:58:59
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for details
-- ----------------------------
DROP TABLE IF EXISTS `details`;
CREATE TABLE `details` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) COLLATE utf8_bin NOT NULL,
  `trade` varchar(255) COLLATE utf8_bin NOT NULL,
  `uid` int(11) NOT NULL,
  `stime` time NOT NULL,
  `title` varchar(255) COLLATE utf8_bin NOT NULL,
  `isvalid` int(11) NOT NULL,
  `money` double,
  `describe` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `dphone` blob,
  `address` varchar(255) COLLATE utf8_bin,
  `count` int(11),
  `endtime` time,
  `isfinish` int(11),
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records 
-- ----------------------------
