## spring-boot-impala
**项目架构：`springboot2` + `mybatis` + `knife4j` + `impala`**

1. 通过`mybatis`的方式操作`impala`数据库，去掉冗杂的jdbc代码
2. 集成了通用`mapper`，`pagehelper`分页插件
2. 采用Druid连接池管理对impala数据库的连接，配置对空闲连接的剔除管理(此配置解决了，当impala服务重启后，web项目再次访问查询，获取不到连接的问题。)
2. 接口文档地址：http://localhost:9090/crash/doc.html (采用knife4j的文档风格)

|依赖            |版本         |
|:------------- |:------------|
|[Spring Boot](http://mvnrepository.com/artifact/org.springframework.boot/spring-boot)    |2.1.8.RELEASE|
|[Spring Web MVC](http://mvnrepository.com/artifact/org.springframework/spring-webmvc)     |5.1.9.RELEASE|
|[MyBatis](http://mvnrepository.com/artifact/org.mybatis/mybatis)        |4.1.5|
|[通用mapper](https://mvnrepository.com/artifact/tk.mybatis/mapper-spring-boot-starter)      |2.1.5|
|[Druid](http://mvnrepository.com/artifact/com.alibaba/druid-spring-boot-starter)          |1.1.21|

### 启动步骤
> 1. 执行web模块下resources/db/crash.sql文件,创建impala数据表crash，并插入数据
> 2. 使用postman测试接口 

### 温馨提示
1. 可根据项目需要自定义 `backend/src/test/resources/generator/template/**` 目录下的模板文件
2. 定义好表结构后，配置 `backend/src/test/java/CodeGenerator.java` 这个文件，运行即可生成项目的基础代码

### 相关的连接异常
- [已解决] Caused by: com.cloudera.impala.jdbc41.internal.apache.thrift.transport.TTransportException
- [已解决] Caused by: java.net.SocketException: Software caused connection abort: socket write error

