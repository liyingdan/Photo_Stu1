/*
Navicat MySQL Data Transfer

Source Server         : hhh
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : photo_db

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-09-03 10:49:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '李应丹', '1234');

-- ----------------------------
-- Table structure for clothes
-- ----------------------------
DROP TABLE IF EXISTS `clothes`;
CREATE TABLE `clothes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` varchar(50) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clothes
-- ----------------------------
INSERT INTO `clothes` VALUES ('1', '小裙子', '500', 'c1.jpg');
INSERT INTO `clothes` VALUES ('2', '小裙子', '600', 'c2.jpg');
INSERT INTO `clothes` VALUES ('3', '小裙子', '500', 'c3.jpg');
INSERT INTO `clothes` VALUES ('4', '小裙子', '300', 'c4.jpg');
INSERT INTO `clothes` VALUES ('5', '小裙子', '500', 'c5.jpg');
INSERT INTO `clothes` VALUES ('6', '小裙子', '500', 'c6.jpg');
INSERT INTO `clothes` VALUES ('7', '小裙子', '800', 'c7.jpg');
INSERT INTO `clothes` VALUES ('8', '小裙子', '900', 'c8.jpg');

-- ----------------------------
-- Table structure for clothesorder
-- ----------------------------
DROP TABLE IF EXISTS `clothesorder`;
CREATE TABLE `clothesorder` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `clothesname` varchar(255) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clothesorder
-- ----------------------------

-- ----------------------------
-- Table structure for combo
-- ----------------------------
DROP TABLE IF EXISTS `combo`;
CREATE TABLE `combo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `camerist` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of combo
-- ----------------------------
INSERT INTO `combo` VALUES ('1', '我们结婚吧', '30000', '4d.jpg', '1号摄影师', '婚纱摄影');
INSERT INTO `combo` VALUES ('2', '花前.月下', '30000', '12.jpg', '1号摄影师', '婚纱摄影');
INSERT INTO `combo` VALUES ('3', '我们结婚吧', '30000', '4d.jpg', '1号摄影师', '婚纱摄影');

-- ----------------------------
-- Table structure for comboorder
-- ----------------------------
DROP TABLE IF EXISTS `comboorder`;
CREATE TABLE `comboorder` (
  `cid` int(11) NOT NULL,
  `cname` varchar(255) DEFAULT NULL,
  `cphone` varchar(255) DEFAULT NULL,
  `ctime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comboorder
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `ccom` varchar(255) DEFAULT NULL,
  `cdate` date DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '苗', '有一个夜晚我烧掉了所有记忆，从此我的梦就透明了。有一个清晨我扔掉了所有的昨天，从此我的脚步就轻盈 。', '2010-03-01');
INSERT INTO `comment` VALUES ('2', '丹', '人生只似风前絮，欢也零星，悲也零星。都做连江点点萍。', '2010-05-01');
INSERT INTO `comment` VALUES ('3', '丹', '狐狸用尾巴扫干净蘑菇上的灰尘 刺猬们也把肚子露了出来 蜗牛也害羞的钻进自己的壳里 长颈鹿不停地吃掉颜色不好的叶子 因为你到我的森林里来了。', '2011-03-01');
INSERT INTO `comment` VALUES ('4', '丹', '孟婆汤是否分六口，一口出世甜、二口叛逆辣、三口珍惜酸、四口情责苦、五口身心麻，最后一口却为白水，淡了口中味，忘了前尘事，泯了爱恩仇，舒了川字眉', '2011-05-01');
INSERT INTO `comment` VALUES ('5', '单', '所有流浪的旅人都归去 ，绵长岁月空余琴声呜咽。他们的发也长了，胡渣可以放进牧羊群，白色的衬衫有了泛黄的渍迹。在多年前居住过的地方，鱼缸长出了一片荒芜的草原，金鱼已背着流畅的骨骼远走。大提琴的残影留在过去的时光里，惟有琴弓伫立在破碎的玻璃窗前，沐浴在昏沉的霭光里。\r\n', null);

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pdate` varchar(50) DEFAULT NULL,
  `ppic1` varchar(255) DEFAULT NULL,
  `ppic2` varchar(255) DEFAULT NULL,
  `ppic3` varchar(255) DEFAULT NULL,
  `ppic4` varchar(255) DEFAULT NULL,
  `ppic5` varchar(255) DEFAULT NULL,
  `ppic6` varchar(255) DEFAULT NULL,
  `ppic7` varchar(255) DEFAULT NULL,
  `ppic8` varchar(255) DEFAULT NULL,
  `ppic9` varchar(255) DEFAULT NULL,
  `ppic10` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of picture
-- ----------------------------
INSERT INTO `picture` VALUES ('1', '2019第二季度第三期', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `picture` VALUES ('2', '2019第二季度第二期', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `picture` VALUES ('3', '2019第二季度第一期', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `picture` VALUES ('4', '2019第一季度第四期', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `picture` VALUES ('5', '2019第一季度第三期', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `picture` VALUES ('6', '2019第一季度第二期', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `picture` VALUES ('7', '2019第一季度第一期', null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for picturefile
-- ----------------------------
DROP TABLE IF EXISTS `picturefile`;
CREATE TABLE `picturefile` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `file_add` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of picturefile
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int(11) NOT NULL,
  `ptype` varchar(255) DEFAULT NULL,
  `pimage` varchar(255) DEFAULT NULL,
  `pdesc1` varchar(255) DEFAULT NULL,
  `pdesc2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '古装摄影', '9590777.jpg', '自古美人如名将', '不许人间见白头');
INSERT INTO `product` VALUES ('2', '婚纱摄影', 'hunsha.jpg', '世间安得双全法', '不负如来不负卿');
INSERT INTO `product` VALUES ('3', '个人写真', '13 (12).JPG', '鲜花怒马少年时', '一日看尽长安花');
INSERT INTO `product` VALUES ('4', '情侣写真', '917241.jpg', '愿我如星君如月', '夜夜流光相皎洁');
INSERT INTO `product` VALUES ('5', '儿童留念', '95128.jpg', '春日杏花落满头', '谁家少年足风流');
INSERT INTO `product` VALUES ('6', '闺蜜合照', '5744.jpg', '何时杖尔看南雪', '我与梅花两白头');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('李应丹', '1234', '15254129572');
