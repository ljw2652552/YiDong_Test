package javaSpec;

import java.sql.*;

public class JDBC {
    public static void main(String[] args) {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://xxxxxxxx/db?xxxx";
        String userName = "xxx";
        String passWord = "xxx";
        String sql = "xxxx";
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet res = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,userName,passWord);
            stat = conn.prepareStatement(sql);
            res = stat.executeQuery();
            while (res.next()){
                res.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (res != null)res.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
/*
 问题：谈一谈ssh、mvc，在web层的设计，java如何在没有这些框架下实现web服务。
*/