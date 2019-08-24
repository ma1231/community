package utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class jdbcUtils {

    //静态变量才能被静态方法，静态代码块访问
    private static String url;
    private static String root;
    private static String password;
    private static String driver;

    static {
        try {
            Properties pro = new Properties();

            ClassLoader classLoader = jdbcUtils.class.getClassLoader();
            URL resource = classLoader.getResource("jdbc.properties");
            String path=resource.getPath();

            pro.load(new FileReader(path));
            url = pro.getProperty(url);
            root = pro.getProperty(root);
            password = pro.getProperty(password);
            driver = pro.getProperty(driver);
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     *
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, root, password);
    }

    public static void close(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs,Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(stmt,conn);
    }

}
