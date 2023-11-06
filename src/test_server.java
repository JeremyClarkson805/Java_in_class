import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class test_server {
    public static void main(String[] args){
        try {
            ServerSocket serversocket = new ServerSocket(8888);
            System.out.println("服务器已上线");
            while(true)
            {
                Socket socket = serversocket.accept();
                System.out.println("收到连接请求");
                System.out.println("上线通知"+socket.getRemoteSocketAddress());
                //BufferedReader->读取的是字符，它从缓冲区中读取内容，所有的输入的字节数据都将放在缓冲区中，直到输入流结束或者缓冲区已满
                //字节流->字符流->缓冲流
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));//将接收到的数据全都存到缓冲流里面，然后下面再从缓冲流里面读取数据，拼出中文
                String msg = "";
                while ((msg = br.readLine())!=null)//readLine()方法是以行为单位读取的，返回值是这行的内容，不包含换行符，如果已到达流末尾，则返回null
                {
                    System.out.println(msg);
                }
            }
        } catch (IOException e) {
            System.out.println("客户端掉线了");
        }
    }
}
