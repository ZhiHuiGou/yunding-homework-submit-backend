package com.yundingshuyuan.web;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Scanner;

/**
 * @Author cr
 * @Date 2023/7/5 21:15
 */
public class CodeGenerator {
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        // 数据源配置
        DataSourceConfig dataSource = new DataSourceConfig();
        dataSource.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/yunjiaoyunji?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        autoGenerator.setDataSource(dataSource);

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");//设置代码生成路径
        gc.setFileOverride(true);//是否覆盖以前文件
        gc.setOpen(false);//是否打开生成目录
        gc.setAuthor("xieyaoxuan");//设置项目作者名称
        gc.setMapperName("%sDao");//设置数据层接口名
//            gc.setBaseResultMap(true);//生成基本ResultMap
//            gc.setBaseColumnList(true);//生成基本ColumnList
//            gc.setDateType(DateType.ONLY_DATE);//设置时间类型
        autoGenerator.setGlobalConfig(gc);


        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.yundingshuyuan");//设置生成的包名，与代码所在文职不冲突，二者叠加组成完整路径
        pc.setMapper("dao");//设置数据层包名
        pc.setEntity("domain");//设置实体类包名
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setController("controller");
        autoGenerator.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
//            strategyConfig.setInclude("设置当前生成参与的表名");//设置当前生成参与的表名
        strategyConfig.setTablePrefix("tbl_");//设置数据库表的前缀名称 模块名 = 数据库表名-前缀名
        strategyConfig.setRestControllerStyle(false);//设置是否启用REST风格
        strategyConfig.setVersionFieldName("version");//设置乐观锁字段名
        strategyConfig.setLogicDeleteFieldName("deleted");//设置逻辑删除字段名
        strategyConfig.setEntityLombokModel(true);//是否启用lombok
        autoGenerator.setStrategy(strategyConfig);
        // 生成代码
        autoGenerator.execute();
    }
}
