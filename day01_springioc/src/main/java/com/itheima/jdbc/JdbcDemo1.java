package com.itheima.jdbc;


import java.sql.*;

public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //解耦思路：
        //1.使用反射创建对象，避免使用new
        //2.读取配置文件来获取要创建的对象的全限定类名
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/day24","root","root");
        PreparedStatement pstm =conn.prepareStatement("select * from accout");
        ResultSet rs =pstm.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        rs.close();
        pstm.close();
        conn.close();

    }
}
