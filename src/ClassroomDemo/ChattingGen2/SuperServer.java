package ClassroomDemo.ChattingGen2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class SuperServer {
    //声明了一个键值对集合，键是代表房间编号，值是Socket类型，代表客人
    public static HashMap<Integer, Socket> map = new HashMap<Integer, Socket>();//声明了一个房间

    public static void sendAll(String msg) {
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i) != null)//如果不为空，则说明是有人在线的，是需要给他发消息的
            {
                try {
                    OutputStreamWriter osw = new OutputStreamWriter(map.get(i).getOutputStream());
                    osw.write(msg + "\n");
                    osw.flush();
                } catch (IOException e) {
                    map.put(i, null);//说明这个人已经掉线，要把他踢掉
//                    throw new RuntimeException(e);
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("超级服务器已启动");
        ServerSocket server = new ServerSocket(8888);
        while (true) {
            Socket socket = server.accept();//阻塞语句，等有客人了才会往下走
            int i = -1, j = 0;
            for (; j < map.size(); j++) {
                if (map.get(j) == null) {
                    i = j;
                    break;
                }
            }
            if (j == map.size()) i = j;//如果原来的map没有空房间，则以j最后的值为编号作为新房间
            map.put(i, socket);//把新来的客人请入第i个房间
            new Waiter(i, socket).start();//启动新线程负责接收消息
        }
    }
}

class Waiter extends Thread {
    Socket socket = null;
    Integer i;
    String name;

    public Waiter(Integer i, Socket socket) {
        this.i = i;
        this.socket = socket;
        this.name = (i + 1) + "号服务员";
    }
    //要做的两件事:1.收客人的消息2.把消息发给所有客人

    @Override
    public void run() {
        super.run();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = null;
            while ((msg = br.readLine()) != null)//收到的内容不为空，则
            {
                System.out.println("收到客户:" + socket.getRemoteSocketAddress() + "发来的消息:" + msg);
                SuperServer.sendAll(name + "发出来自" + socket.getRemoteSocketAddress() + "的消息:" + msg);//调用服务器的方法群发消息
            }
        } catch (IOException e) {
            SuperServer.map.put(i, null);//一旦出错就说明原来的客人已经掉线，那就把这个房间置空
//            e.printStackTrace();
        }
    }
}
