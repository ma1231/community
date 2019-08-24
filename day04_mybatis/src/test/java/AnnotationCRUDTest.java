import com.itheima.dao.IUserDao;
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
import java.util.Date;

public class AnnotationCRUDTest {
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IUserDao userDao;
    private InputStream in;

    @Before
    public void init() throws IOException {
        in =Resources.getResourceAsStream("SqlMapConfig.xml");
        factory=new SqlSessionFactoryBuilder().build(in);
        sqlSession=factory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

 /*   @Test
    public void testSave(){
        User user=new User();
        user.setUsername("老马");
        user.setAddress("北京");
        userDao.saveUser(user);
    }*/

    @Test
    public void testUpdate(){
        User user=new User();
        user.setUsername("老马");
        user.setAddress("北京");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setId(57);
        userDao.updateUser(user);
    }
}
