import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class duridDemo {
    public static void main(String[] args) throws Exception {

        Properties ps=new Properties();
        InputStream is = duridDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        ps.load(is);
        DataSource ds= DruidDataSourceFactory.createDataSource(ps);
        ds.getConnection();


    }
}
