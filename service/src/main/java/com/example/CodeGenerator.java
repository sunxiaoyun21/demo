package com.example;


import com.fanglin.tkmapper.generator.AutoGenerator;
import com.fanglin.tkmapper.generator.config.DataSourceConfig;
import com.fanglin.tkmapper.generator.config.GlobalConfig;
import com.fanglin.tkmapper.generator.config.PackageConfig;
import com.fanglin.tkmapper.generator.config.StrategyConfig;
import com.fanglin.tkmapper.generator.config.rules.DateType;

/**
 * @author sunxiaoyun
 * @version 1.0
 * @date 2019/5/7 15:28
 **/
public class CodeGenerator {
    public static void main(String[] args) {
                // 代码生成器
        AutoGenerator generator = new AutoGenerator();
        // 策略配置
        StrategyConfig strategy = new StrategyConfig()
            .setInclude("bes_industry_category");
        generator.setStrategy(strategy);
        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig()
            .setFileOverride(true)
            .setAuthor("sxy")
            .setSwagger2(true)
            .setDateType(DateType.ONLY_DATE);
        generator.setGlobalConfig(globalConfig);
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.example.test");
        generator.setPackageConfig(packageConfig);
        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig()
            .setUrl("jdbc:postgresql://10.110.2.80:5432/test")
            .setDriverName("org.postgresql.Driver")
            .setUsername("root")
            .setPassword("123456");
        generator.setDataSource(dataSourceConfig);
        generator.execute();
    }
}
