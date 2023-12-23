import ClassroomDemo.ChattingGen2.login;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class test_server {
    //声明了一个键值对集合，键是代表房间编号，值是Socket类型，代表客人
    public static HashMap<Integer, Socket> map = new HashMap<Integer, Socket>();//声明了一个房间

    public static void sendAll_test(String msg) {  //转发消息给所有用户
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i) != null)//如果不为空，则说明是有人在线的，是需要给他发消息的
            {
                try {
                    OutputStreamWriter osw = new OutputStreamWriter(map.get(i).getOutputStream());
                    osw.write(msg + "\n");
                    osw.flush();
                } catch (IOException e) {
                    map.put(i, null);//说明这个人已经掉线，要把他踢掉
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("超级服务器已启动");
        ServerSocket server = new ServerSocket(8888);
        while (true) {
            Socket socket = server.accept();//阻塞语句，等有人了才会往下走
            int i = -1, j = 0;
            for (; j < map.size(); j++) {
                if (map.get(j) == null) {
                    i = j;
                    break;
                }
            }
            if (j == map.size()) i = j;//如果原来的map没有空房间，则以j最后的值为编号作为新房间
            map.put(i, socket);//把新来的客人请入第i个房间
            new Waiter_test(i, socket).start();//启动新线程负责接收消息
        }
    }
}

class Waiter_test extends Thread {
    Socket socket;
    Integer i;
    String name, rn;

    public Waiter_test(Integer i, Socket socket) {
        this.i = i;
        this.socket = socket;
        this.name = (i + 1) + "号线程";
    }

    public static boolean writeToDataBase(String IP, String rn, String sTime, String content) throws SQLException {
        Connection con = login.getConnection();
        String sql = "insert into server_talk_log(IP,rn,submitTime,log) values (?,?,?,?)";//PreparedStatement是Statement的子接口,可以传入带占位符(?)的SQL语句，提供了补充占位符变量的方法
        PreparedStatement ps = con.prepareCall(sql);
        ps.setString(1, IP);
        ps.setString(2, rn);
        ps.setString(3, sTime);
        ps.setString(4, content);
        int n = ps.executeUpdate();
        con.close();
        ps.close();
        return (n > 0);
    }

    @Override
    public void run() {
        super.run();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = null;
            String un, pwd,content;
            int num = 0;
            while ((msg = br.readLine()) != null) {
                if (num == 0 && !msg.substring(0, msg.indexOf(":")).equals("check")) {//num==0->第一次发消息，!msg.substring(0,msg.indexOf(":")).equals("check")->不存在check
                    test_server.map.put(this.i, null);
                    super.stop();
                }
                if (num == 0) {
                    un = msg.substring(msg.indexOf(":") + 1, msg.indexOf(","));
                    pwd = msg.substring(msg.indexOf(",") + 1, msg.indexOf("+"));
                    this.rn = msg.substring(msg.indexOf("+") + 1);
                    if (!ClassroomDemo.ChattingGen2.test_check.userCheck(un, pwd, this.rn)) {
                        OutputStreamWriter osw = new OutputStreamWriter(test_server.map.get(this.i).getOutputStream());
                        osw.write("账号或密码输入有误，若未注册请先成为注册用户\n");
                        osw.flush();
                        test_server.map.put(this.i, null);
                        System.out.println(un + "非本系统用户，已将其踢出，线程" + this.i + "即将关闭");
                        super.stop();
                    }
                }
                un = msg.substring(0, msg.indexOf(":"));
                content = msg.substring(msg.indexOf(":") + 1);
                if (num > 0) {
                    System.out.println(un + ":" + content);
                    InetAddress addy = socket.getInetAddress();
                    String remoteIp = addy.getHostAddress();
                    writeToDataBase(remoteIp, this.rn, sdf.format(System.currentTimeMillis()), content);
                    test_server.sendAll_test(un + ":" + content);//调用服务器的方法群发除校验消息以外的消息
                }
                num += 1;
            }
        } catch (IOException e) {
            test_server.map.put(i, null);//一旦出错就说明原来的用户已经掉线，把它对应的socket赋值null
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}