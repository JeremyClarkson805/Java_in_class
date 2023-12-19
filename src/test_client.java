import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class test_client {
    private static Socket getSocket(String url, int port) {
        Socket socket;
        try {
            socket = new Socket(url, port);
            return socket;
        } catch (IOException e) {
            System.out.println("无法连接到服务器");
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入用户名:");
        String un = sc.nextLine();//输入用户名
        System.out.print("请输入密码：");
        String pwd = sc.nextLine();
        System.out.print("请输入真实姓名:");
        String rn = sc.nextLine();

        Socket socket = getSocket("127.0.0.1", 8888);
        if (socket == null){
            System.out.println("连接服务器失败！");
        }
        //收和发分开处理
        new Receiver_test(socket.getInputStream()).start();//把收消息交给其他线程处理
        //发消息
        OutputStream os = socket.getOutputStream();
        PrintWriter out = new PrintWriter(os);
        String check = "check:" + un + "," + pwd + "+" + rn;
        out.println(check);
        out.flush();
        while (true) {
            System.out.print("请输入要发送的消息:");
            String msg = sc.nextLine();
            out.println(un + ":" + msg);
            out.flush();
        }
    }
}

class Receiver_test extends Thread {//专门拿来接收消息的线程
    InputStream is = null;

    public Receiver_test(InputStream is) throws IOException {
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
                    System.out.println(msg);
                }
            } catch (IOException e) {
                System.out.println("服务器已关闭");
                break;
//                e.printStackTrace();
            }
        }
    }
}
