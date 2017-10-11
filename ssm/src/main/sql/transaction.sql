/*
MySQL Data Transfer
Source Host: localhost
Source Database: ssm
Target Host: localhost
Target Database: ssm
Date: 2017/10/10 19:59:09
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for transaction
-- ----------------------------
DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `oid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `ttime` time,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records 
-- ----------------------------
