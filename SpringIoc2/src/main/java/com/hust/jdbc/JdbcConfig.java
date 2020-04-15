package com.hust.jdbc;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

public class JdbcConfig {

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.passWord}")
    private String passWord;

    @Value("${jdbc.driverClass}")
    private String driverClass;

    @Value("${jdbc.jdbcUrl}")
    private String jdbcUrl;



    /*
    * Bean 创建一个id为 name参数值的 bean对象放入到容器中
    * */
    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass(driverClass);
            ds.setJdbcUrl(jdbcUrl);
            ds.setUser(username);
            ds.setPassword(passWord);
            return ds;
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean(name = "runner")
    @Scope(value = "prototype")
    public QueryRunner createQueryRunner(@Qualifier("dataSource") DataSource dataSource){
        return new QueryRunner(dataSource);
    }
}
