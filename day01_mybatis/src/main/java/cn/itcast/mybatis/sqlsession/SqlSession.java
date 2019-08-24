package cn.itcast.mybatis.sqlsession;

public interface SqlSession {

    <T> T getMapper(Class<T> daoInterfaceDao);
    void close();

}
