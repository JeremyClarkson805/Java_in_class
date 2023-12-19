package ClassroomDemo.ChattingGen2;

import com.mysql.cj.util.StringUtils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test_addUser {
    public static Connection getConnection(){//链接到数据库
        try {
            String url = "jdbc:mysql://localhost:3306/javaDatabase";
            String user = "root";
            String password = "Tian18922078980";
            Connection con = DriverManager.getConnection(url,user,password);
//            System.out.println("系统成功链接到数据库！");
            return con;
        } catch (SQLException e) {
            System.out.println("系统链接到数据库异常");
            return null;
        }
    }

    public static int saveData(String un,String pwd,String rn,int age) throws SQLException {//保存数据
        while (true)
        {
            Connection con = getConnection();
            String sql = "insert into auth(username,password,realname,age) values (?,?,?,?)";//PreparedStatement是Statement的子接口,可以传入带占位符(?)的SQL语句，提供了补充占位符变量的方法
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1,un);
            ps.setString(2,pwd);
            ps.setString(3,rn);
            ps.setInt(4,age);
            int n = ps.executeUpdate();
            ps.close();
            con.close();
            return n;
        }
    }

    public static void addData() throws SQLException {//增加用户
        while (true)
        {
            String un = JOptionPane.showInputDialog("请输入用户名:");
            if (StringUtils.isNullOrEmpty(un)) return;//如果按了取消就退出
            String pwd = JOptionPane.showInputDialog("请输入密码:");
            String rn = JOptionPane.showInputDialog("请输入真实姓名:");
            int age;
            try {
                age = Integer.parseInt(JOptionPane.showInputDialog("请输入年龄:"));
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"年龄输入有误，即将退出！");
                continue;
            }
            int n = saveData(un,pwd,rn,age);
            int r = JOptionPane.showConfirmDialog(null,"添加"+(n>0?"成功":"失败")+",是否继续？");
            if (r!=0) return;
        }
    }
    public static void main(String[] args) throws SQLException {
        addData();
    }
}
