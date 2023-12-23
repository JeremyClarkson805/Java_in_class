package ClassroomDemo.ChattingGen2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test_check {
    public static boolean userCheck(String un,String pwd,String rn) throws SQLException {
        Connection con = login.getConnection();
        String sql = "select * from auth where username=? and password=? and realname=?";
        PreparedStatement ps = con.prepareCall(sql);
        ps.setString(1,un);
        ps.setString(2,pwd);
        ps.setString(3,rn);
        boolean result = ps.executeQuery().next();
        ps.close();
        con.close();
//        System.out.println(result);
        return (result);
    }
    public static void main(String[] args){
//        System.out.println(checkUser("ICE","Bing71110","耿恺婧"));

        String msg =  "check:gth,123456+gth";
        String username = msg.substring(msg.indexOf(":")+1,msg.indexOf(","));
        String pwd = msg.substring(msg.indexOf(",")+1,msg.indexOf("+"));
        String rn = msg.substring(msg.indexOf("+")+1);
        System.out.println(username+"   "+pwd+"   "+rn);
        System.out.println(msg);
    }
}
