import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

public class RedisTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application.xml");
        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);
        Role role=new Role();
        role.setId(1);
        role.setRoleName("role1");
        role.setNote("note1");
        redisTemplate.opsForValue().set("role1",role);
        Role role1= (Role) redisTemplate.opsForValue().get("role1");
        System.out.println(role1.getRoleName());
        SessionCallback sessionCallback=new SessionCallback() {
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                return null;
            }
        };
        redisTemplate.execute(sessionCallback);
    }
}
