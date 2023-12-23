package lwl_demo.AI22.src.cn.gd.xh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SuperClient {

	public static void main(String[] args) {
		try {
			Socket socket=new Socket("127.0.0.1",8888);//连接服务器
			//收和发分开处理
			new Receiver(socket.getInputStream()).start();//把收的事情交给其他线程
			//接下来我只负责发：
			OutputStream os=socket.getOutputStream();
			PrintWriter out=new PrintWriter(os);
			Scanner sc=new Scanner(System.in);
			while(true){
				System.out.println("请输入要发送的内容：");
				String msg=sc.nextLine();
				if(msg.equals("000")){//设定如果输入000则退出程序
					socket.close();
					break;
				}
				out.println(msg);
				out.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class Receiver extends Thread{//这个拿来做接收用
	InputStream is=null;
	public Receiver(InputStream is){
		this.is=is;
	}
	@Override
	public void run() {
		super.run();
		String msg=null;
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(is,"GBK"));
			while((msg=br.readLine())!=null){
				System.out.println("收到消息："+msg);
			}
		} catch (IOException e) {
			System.out.println("客户端下线啦！！");
			//e.printStackTrace();
		}
	}
}