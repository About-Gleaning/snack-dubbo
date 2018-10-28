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
 * @Author liurui
 * @Date 2018/10/11 上午10:10
 **/
public class CodeGenerator {

    //文件输出位置
    private static final String PROJECT_PATH = "/Users/liurui/Downloads";
    //表名
    private static final String TABLE_NAME_LIST = "sys_user_role,sys_user,sys_role,sys_permission,sys_role_permission";

    //模块名(非文件名)
    private static final String MODEL_NAME = "base.sys";
    //包路径
    private static final String PACKAGE_PATH = "com.liurui";


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
//        String projectPath = System.getProperty("user.dir");
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
            List<FileOutConfig> focList = new ArrayList<>();
            focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    //自定义输入文件名称
                    return projectPath + "src/main/resources/mapper/" + pc.getModuleName()
                            + "/" + tableInfo.getEntityName().replaceFirst("t_", "") + "Mapper" + StringPool.DOT_XML;
                }
            });
            cfg.setFileOutConfigList(focList);
            mpg.setCfg(cfg);
            mpg.setTemplate(new TemplateConfig().setXml(null));

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
                    .setTablePrefix(pc.getModuleName() + "_")
                    .setSuperServiceClass("com.baomidou.mybatisplus.extension.servic.IService");
            mpg.setStrategy(strategy);
            mpg.setTemplateEngine(new FreemarkerTemplateEngine());

            // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
//            String templatePath = System.getProperty("user.dir") + "/dubbo-server/src/main/resources/template/";
//            TemplateConfig tc = new TemplateConfig();
//            tc.setController("/template/controller.java.ftl");
            // tc.setEntity("...");
            // tc.setMapper("...");
            // tc.setXml("...");
            // tc.setService("...");
            // tc.setServiceImpl("...");
            // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
//            mpg.setTemplate(tc);

            mpg.execute();
        }
    }

}
