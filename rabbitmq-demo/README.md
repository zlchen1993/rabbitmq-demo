# 工程简介
1.docker安装rabbitmq
 选择一个management结尾的版本，因为这种带有一个web管理端，方便我们管理操作。示例：docker pull rabbitmq:management
 采坑：安装的是最新的版本导致启动的容器会自动关闭，建议使用先前的稳定版本
2.启动
docker run -d --hostname my-rabbit --name rabbit -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin -p 15672:15672 -p 5672:5672  rabbitmq:management
-d 表示后台启动
--hostname 主机地址，不设置的话默认为localhost
--name 容器的名字
-e 设置账号或密码
-p 映射端口号
15672：控制台端口号
5672：应用访问端口号
3.查看rabbitmq运行状况
docker logs rabbit
# 延伸阅读

