package ClassroomDemo.ChattingGen2;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.zip.DataFormatException;

public class test_1 {
    public static Connection getConnection(){
        try {
            String url = "jdbc:mysql://localhost:3306/javaDatabase";
            String user = "root";
            String password = "Tian18922078980";
            Connection con = DriverManager.getConnection(url,user,password);
            System.out.println("成功链接到数据库！");
            return con;
        } catch (SQLException e) {
            System.out.println("链接到数据库异常");
            return null;
        }
    }

    public static void main(String[] args) throws SQLException {
        Connection con = getConnection();
        Statement st = con.createStatement();//创建sql语句
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //传统写法的sql语句
//        String sql_1 = "insert into log (IP,submitTime,content) values ('192.168.50.1','"+sdf.format(System.currentTimeMillis())+"','你好')";
//        st.execute(sql_1);//执行语句

        //新的写法
        String sql = "update log set IP=?,submitTime=?,content=? where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,"172.15.57.211");//将第一个？填充为指定的ip
        ps.setString(2, sdf.format(System.currentTimeMillis()));
        ps.setString(3,"这么操蛋的一天");
        ps.setString(4,"2");
        ps.execute();

        ResultSet rs = st.executeQuery("select * from log;");
        while (rs.next()) System.out.println(rs.getInt("id")+" "+rs.getString("IP")+" "+rs.getString("submitTime")+" "+rs.getString("content"));
        rs.close();
        st.close();
        con.close();

    }
}
