package com.liurui.commons;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName CodeGenerator
 * @Description 代码生成器
 * 多表生成时，表名之间用逗号隔开（模块名有待优化）。
 * @Author liurui
 * @Date 2018/10/11 上午10:10
 **/
public class CodeGenerator {

    //文件输出位置
    private static final String PROJECT_PATH = "/Users/liurui/Downloads";
    //表名
    private static final String TABLE_NAME_LIST = "sys_user";

    //文件去掉的前缀
    private static final String PREFIX = "sys_";

    //模块名(非文件名)
    private static final String MODEL_NAME = "user";
    //包路径
    private static final String PACKAGE_PATH = "com.liurui.sys";


    //数据库地址
    private static final String DATA_URL = "jdbc:mysql://127.0.0.1:3306/snack?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&useSSL=false";
    //数据库Driver name
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    //数据库user name
    private static final String USER_NAME = "root";
    //数据库密码
    private static final String PASSWORD = "liurui";


    //作者
    private static final String AUTHOR_NAME = "liurui";

    public static void main(String[] args) {
        String[] tables = TABLE_NAME_LIST.split(",");
        generator(tables);
    }


    public static void generator(String... tableNames) {
        for (String tableName : tableNames) {
            //代码生成器
            AutoGenerator mpg = new AutoGenerator();

            //全局配置
            GlobalConfig gc = new GlobalConfig();
            String projectPath = PROJECT_PATH + "/" + "codeGenerator " + "/";
            //文件输出位置
            gc.setOutputDir(projectPath + "src/main/java")
                    .setAuthor(AUTHOR_NAME)
                    .setOpen(false)
                    .setBaseResultMap(true)
                    .setBaseColumnList(true);
            mpg.setGlobalConfig(gc);

            //数据源配置
            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setUrl(DATA_URL)
                    .setDriverName(DRIVER_NAME)
                    .setUsername(USER_NAME)
                    .setPassword(PASSWORD);
            mpg.setDataSource(dsc);

            //包配置
            PackageConfig pc = new PackageConfig();
            //模块名
            pc.setModuleName(MODEL_NAME)
                    .setParent(PACKAGE_PATH);
            mpg.setPackageInfo(pc);

            //自定义配置
            InjectionConfig cfg = new InjectionConfig() {
                @Override
                public void initMap() {
                    //to do nothing
                }
            };

            // 如果模版引擎是  freemarker
            String templatePath = "/templates/mapper.xml.ftl";
            // 如果模版引擎是  velocity
//            String templatePath = "/templates/mapper.xml.vm";

            List<FileOutConfig> focList = new ArrayList<>();
            // 自定义配置会被优先输出
            focList.add(new FileOutConfig(templatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    //自定义输入文件名称
                    return projectPath + "src/main/resources/mapper/" + pc.getParent().replace(".", "/") + pc.getModuleName()
                            + "/" + tableInfo.getEntityName().replaceFirst("Sys", "") + "Mapper" + StringPool.DOT_XML;
                }
            });

            cfg.setFileOutConfigList(focList);
            mpg.setCfg(cfg);

            //  配置模版
            TemplateConfig templateConfig = new TemplateConfig();
            //  配置自定义输出模版
            //  指定自定义模版路径，注意不要带上.ftl/.vm，会根据使用的模版引擎自动识别
            //  以下任何一个模块如果设置 空 OR Null 将不生成该模块。
            //  自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
//            templateConfig.setEntity("templates/entity2.java");
//            templateConfig.setService("...");
//            templateConfig.setController("...");
//            templateConfig.setServiceImpl("...");
//            templateConfig.setXml("...");
//            templateConfig.setMapper("...");
//            templateConfig.setXml("...");
            mpg.setTemplate(templateConfig);

            //策略配置
            StrategyConfig strategy = new StrategyConfig()
                    .setNaming(NamingStrategy.underline_to_camel)
                    .setColumnNaming(NamingStrategy.underline_to_camel)
                    .setSuperEntityClass("com.liurui.base.BaseEntity")
                    .setEntityLombokModel(true)
                    .setRestControllerStyle(true)
                    .setSuperControllerClass("com.liurui.base.BaseController")
                    .setInclude(tableName)
                    .setControllerMappingHyphenStyle(true)
                    .setSuperEntityColumns("create_by", "create_time", "update_by", "update_time", "del_flag")
//                    .setSuperEntityColumns(new String[]{})
                    .setTablePrefix(PREFIX)
                    .setSuperServiceClass("com.baomidou.mybatisplus.extension.servic.IService");
            mpg.setStrategy(strategy);
            mpg.setTemplateEngine(new FreemarkerTemplateEngine());

            mpg.execute();
        }
    }

}
