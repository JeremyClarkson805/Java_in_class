package ClassroomDemo.ChattingGen2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SuperClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            //收和发分开处理
            new Receiver(socket.getInputStream()).start();//把收消息交给其他线程处理
            //发消息
            OutputStream os = socket.getOutputStream();
            PrintWriter out = new PrintWriter(os);
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("请输入要发送的消息:");
                String msg = sc.nextLine();
                if (msg.equals("0000")) return;
                out.println(msg);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Receiver extends Thread {//专门拿来接收消息的线程
    InputStream is = null;

    public Receiver(InputStream is) throws IOException {
        this.is = is;
    }

    @Override
    public void run() {
        super.run();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while (true) {
            String msg = null;
            try {
                while ((msg = br.readLine()) != null) {
                    System.out.println("收到消息:" + msg);
                }
            } catch (IOException e) {
                System.out.println("服务器已关闭");
                break;
//                e.printStackTrace();
            }
        }
    }
}
