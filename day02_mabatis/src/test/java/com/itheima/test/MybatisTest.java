package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.QureyVo;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder =new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(in);
        sqlSession = sqlSessionFactory.openSession(true);
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll() throws IOException {
        List<User> user=userDao.findAll();
        for (User user1 : user) {
            System.out.println(user1);
        }
    }

    @Test
    public void testSave() throws IOException {
        User user = new User();
        user.setName("zhang");
        user.setAddress("wuxi");
        user.setSex("nan");
        user.setBirthday("2010");

        userDao.saveUser(user);
    }

    @Test
    public void testUpdate() throws IOException {
        User user = new User();
        user.setId(55);
        user.setName("zhang");
        user.setAddress("wuxi");
        user.setSex("nan");
        user.setBirthday("2010");

        userDao.updateUser(user);
    }

    @Test
    public void testFindByCondition() throws IOException {
        User u =new User();
        u.setName("老王");
        List<User> user=userDao.findUserByCondition(u);
        for (User user1 : user) {
            System.out.println(user1);
        }
    }

    @Test
    public void testFindInIds() throws IOException {
        QureyVo vo =new QureyVo();
        List<Integer> list=new ArrayList<Integer>();
        list.add(41);
        list.add(42);
        vo.setIds(list);

        List<User> user=userDao.findUserInIds(vo);
        for (User user1 : user) {
            System.out.println(user1);
        }
    }

}
