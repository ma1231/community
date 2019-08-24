package cn.itcast.mybatis.sqlsession;

import cn.itcast.mybatis.cfg.Configuration;
import cn.itcast.mybatis.sqlsession.proxy.MapperProxy;
import cn.itcast.mybatis.utils.DateSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class DefaultSqlsession implements SqlSession{

    Configuration config;
    Connection conn;

    public DefaultSqlsession(Configuration config) {
        this.config = config;
        conn= DateSourceUtil.getConnection(config);
    }

    public <T> T getMapper(Class<T> daoInterfaceDao) {
        Object o = Proxy.newProxyInstance(daoInterfaceDao.getClass().getClassLoader(),
                daoInterfaceDao.getClass().getInterfaces(),
                new MapperProxy(config.getMappers(), conn));
        return (T) o;

    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
