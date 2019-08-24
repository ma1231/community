package cn.itcast.mybatis.sqlsession;

import cn.itcast.mybatis.cfg.Configuration;

public class DefaultSqlsessionFactory implements SqlSessionFactory{

    private Configuration config;

    public DefaultSqlsessionFactory(Configuration config) {
        this.config = config;
    }

    public SqlSession openSession() {
        return new DefaultSqlsession(config);
    }
}
