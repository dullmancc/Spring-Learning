package com.hust;

import com.hust.jdbc.JdbcConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/*
*  该类是一个配置类 作用和Bean.xml一样
*  Configuration
*       作用：指定当前类为一个配置类
*       当配置类作为AnnotationConfigApplicationContext对象创建的参数时，可以不写
*   ComponentScan
*       作用指定通过spring在创建容器时需要扫描的包
*       value 和 base-package一样
*       等同  <context:component-scan base-package="com.hus">
    Import
        用于导入其他的配置类
        *   value 指定其他配置类的字节码
        *    当我们使用Import的注解之后，有Import注解的类就父配置类，而导入的都是子配置类
        *
    PropertySource:
        作用指定properties文件的位置
        * value：指定位置
        *   关键字：classpath，表示类路径下
*
* */
@Configuration
@ComponentScan("com.hust")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbc.properties")
public class SpringConfiguration {

}
