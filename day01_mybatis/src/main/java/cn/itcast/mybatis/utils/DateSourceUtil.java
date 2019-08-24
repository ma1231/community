package cn.itcast.mybatis.utils;

import cn.itcast.mybatis.cfg.Configuration;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DateSourceUtil {

    public static Connection getConnection(Configuration config){
        try {
            Class.forName(config.getDriver());
            return DriverManager.getConnection(config.getUrl(), config.getUrl(),
                    config.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
