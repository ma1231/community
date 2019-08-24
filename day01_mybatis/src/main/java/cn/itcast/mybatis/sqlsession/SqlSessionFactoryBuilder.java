package cn.itcast.mybatis.sqlsession;

import cn.itcast.mybatis.cfg.Configuration;
import cn.itcast.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {
    

    public SqlSessionFactory build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlsessionFactory(cfg);
    }
}
