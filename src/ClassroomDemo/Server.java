package ClassroomDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);//网络流都要进行异常捕捉
            System.out.println(ss.getLocalSocketAddress());
            while (true) {
                Socket socket = ss.accept();//ss.accept()阻塞语句，没人来连接的话就一直停在这一行
                System.out.println("收到连接请求");
                InputStream is = socket.getInputStream();//人家给我发的消息就相当于是输入，所以用的输入流 字节流
                OutputStream os = socket.getOutputStream();
                //--------把输入流的字节转换成字符串并按UTF-8解码-----------
                InputStreamReader isr = new InputStreamReader(is);//InputStreamReader--->字符流
                BufferedReader br = new BufferedReader(isr);//字符串缓存流
                String msg = "";
                StringBuilder sb = new StringBuilder();
                while ((msg = br.readLine()) != null && msg.length() > 0) {
                    sb.append(msg);
                }
                msg = sb.toString();
//                str.append(s);
//                String msg = str.toString();
                //------------------------------------------------
                System.out.println("收到客户端消息:" + msg + "\t--->来自:" + socket.getLocalSocketAddress());
                String response = "已收到你发来的消息!\n";
                os.write(response.getBytes("UTF-8"));//把要发送的消息转成字节数组装入输出流
                os.flush();//推出这个消息
                os.close();//关闭输出流
                br.close();
                isr.close();
                is.close();//关闭输入流
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Waiter extends Thread {
    Socket socket = null;

    public Waiter(Socket socket) {
        this.socket = socket;
    }
}
