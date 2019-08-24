package com.heima;






import DAO.UsrDao;
import cn.itcast.domain.User;
import cn.itcast.mybatis.io.Resources;
import cn.itcast.mybatis.sqlsession.SqlSession;
import cn.itcast.mybatis.sqlsession.SqlSessionFactory;
import cn.itcast.mybatis.sqlsession.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //构造者模式
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //工厂模式,数据库连接池
        SqlSessionFactory sqlSessionFactory= builder.build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //代理对象，sqlSession数据库执行对象
        UsrDao usrDao = sqlSession.getMapper(UsrDao.class);
        List<User> users = usrDao.findall();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
        in.close();

    }
}
