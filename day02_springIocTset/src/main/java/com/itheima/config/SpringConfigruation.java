package com.itheima.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import javax.sql.DataSource;


@Configuration
@ComponentScan("com.itheima")
public class SpringConfigruation {

    @Bean(name = "runner")
    @Scope()
    public QueryRunner createRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    @Bean(name = "datasource")
    public DataSource createDatasource(){
        ComboPooledDataSource dataSource =new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/day24");
            dataSource.setUser("root");
            dataSource.setPassword("root");
            return dataSource;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
