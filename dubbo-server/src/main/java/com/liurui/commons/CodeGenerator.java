package com.liurui.commons;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
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
    private static final String TABLE_NAME = "sys_role";

    //模块名(非文件名)
    private static final String MODEL_NAME = "user.additionalInfo";
    //包路径
    private static final String PACKAGE_PATH = "com.liurui.sys.user";


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
        //代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
        String projectPath = PROJECT_PATH + "/" + "codeGenerator " + "/";
        //文件输出位置
//        gc.setOutputDir(projectPath + "src/main/java")
        gc.setOutputDir(projectPath + "src/main/java")
                .setAuthor(AUTHOR_NAME)
                .setOpen(false);
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
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("com.liurui.base.BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setSuperControllerClass("com.liurui.base.BaseController");
        strategy.setInclude(TABLE_NAME);
        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setSuperServiceClass("com.baomidou.mybatisplus.extension.servic.IService");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();

    }

}
