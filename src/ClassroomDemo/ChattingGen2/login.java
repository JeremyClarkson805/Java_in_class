package ClassroomDemo.ChattingGen2;

import com.mysql.cj.util.StringUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login {
    public static Auth user;
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

    private static Auth checkUser(String username, String pwd) throws SQLException {
        Connection con = getConnection();
//        System.out.println(username);
        username = username.replace("'","").replace(" ","").replace("/","").replace("\\","");
//        System.out.println(username);
        pwd = pwd.replace("'","").replace(" ","").replace("/","").replace("\\","");
        String sql = "select * from auth where username='" + username + "' and password='" + pwd + "'";
        ResultSet rs = con.createStatement().executeQuery(sql);//ResultSet->结果集
        Auth user = null;
        if (rs.next()){
            user = new Auth(rs.getInt("id"),rs.getInt("age"),rs.getString("username"),rs.getString("password"),rs.getString("realname"));
        }
        rs.close();
        con.close();
        return user;
    }
    public static void main(String[] args) throws SQLException {
//        addData();
        JFrame jf = new JFrame("我是一个窗口");
        JTextField un = new JTextField(20);
        JPasswordField pwd = new JPasswordField(20);
        jf.setLayout(null);
        jf.add(un);jf.add(pwd);
        un.setBounds(50,40,300,30);
        pwd.setBounds(50,80,300,30);
        JButton bt = new JButton("登陆");
        bt.addActionListener(new ActionListener() {//这是个实现了接口的无名类
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = un.getText();
                String password = pwd.getText();
//                System.out.println(username+password);
                if (username.equals("") || password.equals("")){//如果用户名或密码任意一个没输入
                    JOptionPane.showMessageDialog(jf,"用户名和密码不能为空！");
                    return;
                }
                try {
                    user = checkUser(username,password);
                } catch (SQLException ex) {
                    System.out.println("1");
                    throw new RuntimeException(ex);
                }
                if (user == null){
                    JOptionPane.showMessageDialog(jf,"用户名或密码错误！");
                }else {
                    JOptionPane.showMessageDialog(jf,"你好"+user.getRealname());
                }
            }
        });
        jf.add(bt);
        bt.setBounds(150,120,100,30);
        jf.setSize(400,300);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
