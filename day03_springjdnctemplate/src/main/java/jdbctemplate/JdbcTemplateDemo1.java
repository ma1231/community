package jdbctemplate;

import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
       /* DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/day24");
        ds.setUsername("root");
        ds.setPassword("root");*/


        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate",JdbcTemplate.class);
       // jdbcTemplate.execute("insert into account(name,money) values('ccc',1000)");

       // jdbcTemplate.update("insert into account(name,money) values(?,?)","eee",3333);
       // jdbcTemplate.update("delete from account where id=?",1);
        List<Account> accounts=jdbcTemplate.query("select * from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),1);
        System.out.println(accounts.isEmpty()?"没有内容":accounts.get(0));

        Long aLong = jdbcTemplate.queryForObject("select count(*) from account where money>?", Long.class, 1000);
        System.out.println(aLong);
    }

}
