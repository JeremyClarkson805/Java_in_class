import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class test_mysql {
    public static void main(String[] args) {
        Conn c = new Conn();
        c.getConnection();
    }
}

class Conn{
    Connection con;
    private static String username;
    private static String password;
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库驱动加载成功");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        username = "root";
        password = "123456";
        try {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?useUnicode = true & characterEncoding = utf-8",username,password);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}


