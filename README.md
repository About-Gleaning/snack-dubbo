# snack-dubbo
## 组件
|名称|备注|
|:---|:---|
|Dubbo|暂用xml配置接口，后期改@Refrence注解|
|Spring boot||
|Log4j|待集成||
|Logback|待集成||
|Curator|没弄懂||
|Jackson|||
|Pagehelper|||
|Mybatis|||
|Mybatis Plus|初步集成。代码生成在CodeGenerator中。[ActiveRecord、逆向生成等待实现](https://www.jianshu.com/p/a4d5d310daf8)||
|Mybatis generator|插件在provider模块下，父项目下运行会报错啊||
|Junit|还有一套测试组合拳待学习配置||
|Druid|还没配||
|Freemark|||
|Velocity|||

## 搭建笔记
**1. 搭建maven项目**
```$xslt
一个父项目，三个子项目（api模块可以避免接口的重复代码）
|dubbo-parent (pom)
|-- dubbo-api (jar)
|-- dubbo-client (war)
|-- dubbo-server (war)
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


