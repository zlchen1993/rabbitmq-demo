CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '用户名称',
  `password` varchar(256) NOT NULL COMMENT '密码',
  `email` varchar(256)  NOT NULL unique COMMENT '邮箱',
  `nickname` varchar(256)  COMMENT '曾用名',
  'regname' varchar(256) COMMENT '其他',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;