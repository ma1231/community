package JDBCtemplate;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.DuridUtils;

public class JDBCTemplateDemo {
    JdbcTemplate jdbcTemplate=new JdbcTemplate(DuridUtils.getDataSource());

    @Test
    public void test1(){
        String sql="Update emp set account=10000 where id=1001";
        int count=jdbcTemplate.update(sql);
    }

    @Test
    public void test2(){
        String sql="insert into emp(id,dept_id) values(?,?) ";
        int count=jdbcTemplate.update(sql,1,1);
    }

    @Test
    public void test3(){
        String sql="delete from emp where id=? ";
        jdbcTemplate.update(sql, 1);
    }
}
