package jdbc;

import java.sql.*;

public class jdbcdemo1 {


    public static void main(String[] args) {
        Statement state = null;
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //String sql="insert into account values(null,'王五',3000)";
            //String sql = "select * from account";
            String sql = "select * from account where username= ? and password = ?";
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
            //state = connection.createStatement();
            //int count=state.executeUpdate(sql);
            pstmt = connection.prepareStatement(sql);// 解决SQL注入问题
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            resultSet = pstmt.executeQuery();

            //resultSet =state.executeQuery(sql);
            while (resultSet.next()) ;
            {
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                double balance = resultSet.getDouble(3);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
