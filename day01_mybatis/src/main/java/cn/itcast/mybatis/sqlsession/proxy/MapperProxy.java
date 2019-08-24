package cn.itcast.mybatis.sqlsession.proxy;

import cn.itcast.mybatis.cfg.Mapper;
import cn.itcast.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {

    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String,Mapper> mappers,Connection conn){
        this.mappers=mappers;
        this.conn=conn;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String namespace= method.getDeclaringClass().getName();
        String methodName=method.getName();
        String key=namespace+"."+methodName;
        Mapper mapper = mappers.get(key);
        if(mapper ==null){
            throw new IllegalArgumentException();
        }
        return new Executor().selectList(mapper,conn);

    }
}
