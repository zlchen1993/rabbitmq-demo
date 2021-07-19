# 工程简介
springboot使用redis
1.引入依赖
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-pool2</artifactId>
</dependency>
    spring-boot-starter-data-redis默认使用lettuce，Lettuce 是一个可伸缩线程安全的 Redis 客户端，多个线程可以共享同一个 RedisConnection，
它利用优秀 netty NIO 框架来高效地管理多个连接。，1.0的时候使用jedis。

# 延伸阅读

