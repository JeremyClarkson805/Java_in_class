package ClassroomDemo;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.print("请输入发送内容:");
                String s = sc.nextLine();
                s += "\n";//给模拟发送的内容添加一个换行符作为结束标记
                //输入了内容以后再连接服务器，防止一直占用端口
                Socket socket = new Socket("0.0.0.0", 8888);
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                PrintWriter out = new PrintWriter(os);
                out.println(s);
//                System.out.println("已经连接服务器");
//                os.write(s.getBytes("UTF-8"));
                out.flush();
                InputStreamReader isr = new InputStreamReader(is);//InputStreamReader--->字符流
                BufferedReader br = new BufferedReader(isr);//字符串缓存流
                String msg = "";
                StringBuilder sb = new StringBuilder();
                while ((msg = br.readLine()) != null && msg.length() > 0) {
                    sb.append(msg);
                }
                msg = sb.toString();
                System.out.println("服务器返回消息" + msg);
                os.close();
                out.close();
                br.close();
                isr.close();
                is.close();
                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


