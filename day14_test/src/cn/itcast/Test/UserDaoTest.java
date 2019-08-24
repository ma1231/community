package cn.itcast.Test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testLogin(){
        User user=new User();
        user.setUsername("superbaby");
        user.setPassword("123");

        UserDao dao=new UserDao();
        dao.login(user);
        System.out.println(user);
    }
}
