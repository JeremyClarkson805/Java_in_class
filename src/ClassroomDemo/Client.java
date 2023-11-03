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
                Socket socket = new Socket("127.0.0.1", 8888);
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                PrintWriter out = new PrintWriter(os);
                out.println(s);
                out.flush();
                InputStreamReader isr = new InputStreamReader(is);//InputStreamReader--->字符流
                BufferedReader br = new BufferedReader(isr);//字符串缓存流
                String msg = "";
                StringBuilder sb = new StringBuilder();
                //通过循环逐行读取，每次读到的行都添加到字符串构造器StringBuilder里面，直到读完为止，最后将字符串构造器里的内容全部转为字符串输出
                while ((msg = br.readLine()) != null && msg.length() > 0) {
                    sb.append(msg);
                }
                msg = sb.toString();
                System.out.println("服务器返回消息:" + msg);
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
    //获取当前时间
    public static String getTime() {
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
    }
}


