# snack-dubbo
## 组件
|名称|备注|
|:---|:---|
|Spring boot||
|Dubbo|暂用xml配置接口，后期改@Refrence注解|
|Redis|单点集成，集群候着||
|Curator|没弄懂||
|Pagehelper|||
|Mybatis|||
|Mybatis Plus|初步集成。代码生成在CodeGenerator中。[ActiveRecord、逆向生成等待实现](https://www.jianshu.com/p/a4d5d310daf8)||
|Mybatis generator|(不用了)插件在provider模块下，父项目下运行会报错啊||
|Junit|还有一套测试组合拳待学习配置||
|Druid|还没配||
|Freemark|||
|Velocity|||
|Netty|||
|Shiro|||
|Solr|||
|Kafka|||
|mq|||

## 待续 ##
```$xslt
RedisTemplate封装，逆向生成模版，
动态代理，设计模式
单点登陆
消息中间件
配置中心 ，服务治理，
分布式事物，一致性，缓存分布式一致性，缓存和数据库的一致性，乐观锁，容灾
定时任务, 邮件(zookeeper),短信
```

## 搭建笔记
**1. 搭建maven项目**
```$xslt
一个父项目，三个子项目（api模块可以避免接口的重复代码）
|dubbo-parent (pom)
|-- dubbo-api (jar)
|-- dubbo-client (war)
|-- dubbo-server (war)
|-- dubbo-common (jar)
|-- dubbo-shiro (war)
```

**2. pom.xml大概配置**
```$xslt
spring boot:
    *starter
dubbo:
    dubbo
    zookeeper
mybatis:
    mybatis*
    pagehelper
    mapper
    druid
    mybatis-generator:
        lombok
    mybatis plus
```
**3. 注意事项**
```aidl
1. 代码生成用CodeGenerator类
```


