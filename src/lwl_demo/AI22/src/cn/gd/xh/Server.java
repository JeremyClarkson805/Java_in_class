package lwl_demo.AI22.src.cn.gd.xh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket ss=new ServerSocket(8888);
			System.out.println("服务器开始工作于8888端口");
			System.out.println(ss.getLocalSocketAddress());
			while(true){
			Socket socket=ss.accept();//阻塞语句，没人来连接就一直停在这一句
			System.out.println("收到连接请求");
			InputStream is=socket.getInputStream();//字节流
			OutputStream os=socket.getOutputStream();
			//如何把输入流内的字节转换成字符串并按UTF-8编码
			InputStreamReader isr=new InputStreamReader(is);//包在字符流中
			BufferedReader br=new BufferedReader(isr);//字符串缓存流
			//String msg=br.readLine();
			String msg="";
			StringBuilder sb=new StringBuilder();
			while((msg=br.readLine())!=null&&msg.length()>0){
				sb.append(msg);
			}
			msg=sb.toString();
			//---------------------------------
			System.out.println("收到消息："+msg+"，来自"+socket.getRemoteSocketAddress());
			String response="你发来的消息我已经收到了！\n";
			PrintWriter out=new PrintWriter(os);
			out.println(response);//把要发送的消息转成字节数组装入输出流
			out.flush();//推出这个消息
			os.close();//关闭输出流
			out.close();
			br.close();isr.close();is.close();//关闭输入流
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}


