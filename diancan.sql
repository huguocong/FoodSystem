/*
 Navicat Premium Data Transfer

 Source Server         : first
 Source Server Type    : MySQL
 Source Server Version : 50544
 Source Host           : localhost:3306
 Source Schema         : diancan

 Target Server Type    : MySQL
 Target Server Version : 50544
 File Encoding         : 65001

 Date: 01/12/2019 22:19:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dinnertable
-- ----------------------------
DROP TABLE IF EXISTS `dinnertable`;
CREATE TABLE `dinnertable`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tableName` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `tableStatus` int(11) NULL DEFAULT 0,
  `orderDate` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `table1`(`tableName`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dinnertable
-- ----------------------------
INSERT INTO `dinnertable` VALUES (1, 'x1', 1, '2019-12-12 18:37:19');
INSERT INTO `dinnertable` VALUES (2, 'x2', 1, '2019-12-01 18:45:29');
INSERT INTO `dinnertable` VALUES (3, 'x3', 0, NULL);
INSERT INTO `dinnertable` VALUES (5, 'x21', 1, '2019-12-01 18:47:14');
INSERT INTO `dinnertable` VALUES (6, 'y1', 1, '2019-12-01 19:00:47');
INSERT INTO `dinnertable` VALUES (7, 'y2', 0, NULL);
INSERT INTO `dinnertable` VALUES (9, 'qwe', 0, NULL);

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `foodName` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `foodType_id1` int(11) NULL DEFAULT NULL COMMENT '一级',
  `foodType_id2` int(25) NULL DEFAULT NULL COMMENT '二级',
  `price` double NULL DEFAULT NULL,
  `mprice` double NULL DEFAULT NULL,
  `remark` varchar(200) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `img` varchar(100) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `istuijian` int(25) NULL DEFAULT NULL COMMENT '0:推荐菜  1：非推荐',
  `isnew` int(25) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES (23, '白灼虾', 1, 10, 23, 20, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f01KAYubRAAB8jkf5UJs947.jpg', 0, NULL);
INSERT INTO `food` VALUES (24, '白切鸡', 1, 9, 23, 20, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f04GADxGrAAIxXhjAU0A659.png', 0, NULL);
INSERT INTO `food` VALUES (25, '宫爆鸡丁', 1, 7, 12, 9, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f06KAHoLfAAKuDMAYrQw285.png', 0, NULL);
INSERT INTO `food` VALUES (26, '牛肉面', 4, 18, 10, 9, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f09KAA3dHAAPw4WAZIRk316.png', 0, NULL);
INSERT INTO `food` VALUES (27, '剁椒鱼头', 1, 9, 12, 9, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f0_OACz44AAL-PDJGqvs351.png', 0, NULL);
INSERT INTO `food` VALUES (28, '水煮鸡蛋', 2, 12, 12, 9, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f1AqAds8XAAKX_CP5ebo572.png', 1, NULL);
INSERT INTO `food` VALUES (29, '小洋人酸奶', 2, 13, 12, 9, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f1D-AJZKqAAD1UpDcpcI753.png', 0, NULL);
INSERT INTO `food` VALUES (30, '炸薯条', 6, 24, 10, 9, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f1UGAOeEZAAGy5clr414955.png', 1, NULL);
INSERT INTO `food` VALUES (31, '鸡杂', 1, 7, 12, 9, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f1WOAIBL3AANstq9uFsg690.png', 0, NULL);
INSERT INTO `food` VALUES (32, '冰激凌', 5, 21, 10, 7, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f1YGAVzVOAAKpmq44v_g110.png', 1, NULL);
INSERT INTO `food` VALUES (33, '红枣牛奶', 2, 13, 12, 9, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f1aCATcZcAADAsxCwmm8176.png', 1, NULL);
INSERT INTO `food` VALUES (34, '清炒藕片', 3, 15, 12, 9, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f1cuARgo-AAIv3M8AEBs282.png', 1, NULL);
INSERT INTO `food` VALUES (35, '燕麦牛奶', 2, 13, 12, 9, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f1fKAaiYXAAFWWCYPTMg260.png', 1, NULL);
INSERT INTO `food` VALUES (36, '小炒胡萝卜', 3, 16, 12, 9, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f2AmAYQC9AACS980RHWE784.png', 0, NULL);
INSERT INTO `food` VALUES (37, '榨菜丝海鲜菇', 3, 15, 12, 9, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f2auAbQ8lAAEiQeXTIgE423.png', 1, NULL);
INSERT INTO `food` VALUES (38, '高压锅盐水毛豆', 3, 15, 12, 9, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f2caAGjMvAAFpr50N4X0482.png', 0, NULL);
INSERT INTO `food` VALUES (39, '荆芥叶拌菜瓜', 3, 16, 12, 9, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f2d-AcLpoAAGiTLQYl4k732.png', 1, NULL);
INSERT INTO `food` VALUES (40, '养生红烧豆腐', 3, 16, 12, 9, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f2fWAFmOsAAGC9VU3-M8415.png', 0, NULL);
INSERT INTO `food` VALUES (41, '油焖茭白', 3, 15, 12, 9, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f2g-ARuYeAAFU-SM9ukY075.png', 0, NULL);
INSERT INTO `food` VALUES (42, '冰镇芥末秋葵', 3, 15, 12, 9, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f2iOAFCMwAAFBcxniZyE799.png', 1, NULL);
INSERT INTO `food` VALUES (43, '凉拌芦笋', 3, 16, 12, 9, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f2jaAXsm-AAFpWy-x0wI594.png', 1, NULL);
INSERT INTO `food` VALUES (44, '凉拌海带', 3, 15, 12, 9, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f2lOACwmIAAFTcptTS0w279.png', 0, NULL);
INSERT INTO `food` VALUES (45, '香椿苗拌豆腐皮', 3, 15, 12, 9, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f2muAAtqIAAF5MOmyClY400.png', 0, NULL);
INSERT INTO `food` VALUES (46, '油条', 6, 22, 12, 9, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f2v2AfogQAARz0rmzljg757.png', 0, NULL);
INSERT INTO `food` VALUES (47, '月饼', 6, 24, 12, 1, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f2xaAfZ8QAAa8BO42CLo972.png', 0, NULL);
INSERT INTO `food` VALUES (48, '饺子', 6, 22, 12, 9, '', 'http://192.168.25.133/group1/M00/00/00/wKgZhV3f2zGAFdkfAAWrtqtYTUg537.png', 0, NULL);

-- ----------------------------
-- Table structure for foodcat
-- ----------------------------
DROP TABLE IF EXISTS `foodcat`;
CREATE TABLE `foodcat`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of foodcat
-- ----------------------------
INSERT INTO `foodcat` VALUES (1, 0, '荤菜');
INSERT INTO `foodcat` VALUES (2, 0, '蛋、奶及豆制品');
INSERT INTO `foodcat` VALUES (3, 0, '家常小菜');
INSERT INTO `foodcat` VALUES (4, 0, '谷薯杂粮');
INSERT INTO `foodcat` VALUES (5, 0, '水、茶和特饮');
INSERT INTO `foodcat` VALUES (6, 0, '特色零食小吃、水果');
INSERT INTO `foodcat` VALUES (7, 1, '家禽类');
INSERT INTO `foodcat` VALUES (8, 1, '牛羊肉');
INSERT INTO `foodcat` VALUES (9, 1, '鱼类');
INSERT INTO `foodcat` VALUES (10, 1, '虾');
INSERT INTO `foodcat` VALUES (11, 1, '其他水产');
INSERT INTO `foodcat` VALUES (12, 2, '蛋');
INSERT INTO `foodcat` VALUES (13, 2, '奶、奶制品');
INSERT INTO `foodcat` VALUES (14, 2, '豆制品');
INSERT INTO `foodcat` VALUES (15, 3, '清淡素食');
INSERT INTO `foodcat` VALUES (16, 3, '小炒青菜');
INSERT INTO `foodcat` VALUES (17, 4, '米饭，锅巴');
INSERT INTO `foodcat` VALUES (18, 4, '面食');
INSERT INTO `foodcat` VALUES (19, 4, '薯类');
INSERT INTO `foodcat` VALUES (20, 5, '水，饮料');
INSERT INTO `foodcat` VALUES (21, 5, '甜品');
INSERT INTO `foodcat` VALUES (22, 6, '传统小吃');
INSERT INTO `foodcat` VALUES (24, 6, '零食');

-- ----------------------------
-- Table structure for orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` int(11) NULL DEFAULT NULL COMMENT '订单主键',
  `food_id` int(11) NULL DEFAULT NULL COMMENT '食物主键',
  `foodCount` int(11) NULL DEFAULT NULL COMMENT '数量',
  `count` double(11, 3) NULL DEFAULT NULL COMMENT '小计',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
INSERT INTO `orderdetail` VALUES (1, 1, 23, 1, 12.000);
INSERT INTO `orderdetail` VALUES (2, 1, 24, 1, 23.000);
INSERT INTO `orderdetail` VALUES (3, 1, 26, 1, 23.000);
INSERT INTO `orderdetail` VALUES (4, 2, 27, 3, 12.000);
INSERT INTO `orderdetail` VALUES (5, 2, 28, 2, 23.000);
INSERT INTO `orderdetail` VALUES (6, 3, 40, 1, 43.000);
INSERT INTO `orderdetail` VALUES (7, 4, 50, 4, 21.000);
INSERT INTO `orderdetail` VALUES (8, 5, 45, 1, 243.000);
INSERT INTO `orderdetail` VALUES (9, 6, 46, 1, 24.000);
INSERT INTO `orderdetail` VALUES (10, 1, 48, 1, 12.000);
INSERT INTO `orderdetail` VALUES (11, 2, 26, 1, 10.000);
INSERT INTO `orderdetail` VALUES (12, 3, 48, 2, 24.000);
INSERT INTO `orderdetail` VALUES (13, 3, 24, 2, 46.000);
INSERT INTO `orderdetail` VALUES (14, 4, 48, 1, 12.000);
INSERT INTO `orderdetail` VALUES (15, 5, 25, 1, 12.000);
INSERT INTO `orderdetail` VALUES (16, 6, 47, 1, 12.000);
INSERT INTO `orderdetail` VALUES (17, 38, 24, 2, 46.000);
INSERT INTO `orderdetail` VALUES (18, 38, 42, 1, 12.000);
INSERT INTO `orderdetail` VALUES (19, 39, 48, 1, 12.000);
INSERT INTO `orderdetail` VALUES (20, 40, 24, 1, 23.000);
INSERT INTO `orderdetail` VALUES (21, 41, 48, 1, 12.000);
INSERT INTO `orderdetail` VALUES (22, 42, 46, 2, 24.000);
INSERT INTO `orderdetail` VALUES (23, 43, 42, 1, 12.000);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_id` varchar(252) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL COMMENT '订单编号',
  `table_id` int(11) NULL DEFAULT NULL COMMENT '餐桌id主键',
  `orderDate` datetime NULL DEFAULT NULL COMMENT '下单日期',
  `totalPrice` double(11, 3) NULL DEFAULT NULL COMMENT '订单总金额',
  `orderStatus` int(11) NULL DEFAULT 0 COMMENT '订单状态： 0,未结账； 1,已结账2：结束',
  `people` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL COMMENT '预订人',
  `tele` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL COMMENT '预留电话',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '关联用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, 'B93F18831C414D8484D58BCC94C75114', 1, '2019-11-24 18:37:45', 45.300, 1, '张三', '1231', 3);
INSERT INTO `orders` VALUES (2, '2500F639ED324D8D8E74DE58E87EC004', 2, '2019-11-24 18:38:21', 56.800, 1, '李四', '123', 3);
INSERT INTO `orders` VALUES (3, '6D3077BF15064699AE850CEA644D06C3', 3, '2019-11-25 08:48:36', 45.300, 0, '王五', '3213', 3);
INSERT INTO `orders` VALUES (4, '82D38C429A044AD2BF2881D70AB26C35', 5, '2019-11-07 08:49:03', 45.300, 0, '着六', '4324', 3);
INSERT INTO `orders` VALUES (5, 'D17D55F78F7543C1A93864FC4E3190A9', 7, '2019-11-25 08:49:14', 89.300, 2, '马七', '2342', 3);
INSERT INTO `orders` VALUES (6, 'D38C790C2C214639A5FF217A1956D3C7', 9, '2019-11-28 08:49:27', 56.000, 1, '依依', '2234', 3);
INSERT INTO `orders` VALUES (38, 'AA830A66A7BF445687F52AF0C88F92C2', 2, '2019-12-01 16:49:01', 58.000, 1, '213', '2131313', 5);
INSERT INTO `orders` VALUES (40, '7E2CF60FE6614FC6BF3A16D40C18C655', 1, '2019-12-01 17:36:27', 23.000, 1, '我', '21313', 5);
INSERT INTO `orders` VALUES (41, '0FBCCD3F26344B938A5A0C442AEEF1F7', 5, '2019-12-01 18:46:23', 12.000, 1, '卢超', '2131313', 5);
INSERT INTO `orders` VALUES (42, '79DC5B80970749F498477129A1AF0BC1', 7, '2019-12-01 18:58:18', 24.000, 2, '卢超', '21313', 8);
INSERT INTO `orders` VALUES (43, '5E5C3B4AD57F42339A42606078DE4F40', 6, '2019-12-01 19:00:37', 12.000, 1, '卢超', '21313', 8);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `tele` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `groupid` int(25) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username_i`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '111', '管理员', '123456789', 0);
INSERT INTO `user` VALUES (3, '123', '123', '张三', '2131', 1);
INSERT INTO `user` VALUES (5, '11', '11', '李四', '2131313', 1);
INSERT INTO `user` VALUES (6, 'zz', '12', '胡郭聪', '00', 1);
INSERT INTO `user` VALUES (7, '444', '1', '44', '545', 1);
INSERT INTO `user` VALUES (8, 'luchao', '123', '卢超', '2131313', 1);

SET FOREIGN_KEY_CHECKS = 1;
