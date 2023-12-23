package lwl_demo.AI22.src.cn.gd.xh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			while(true){
			System.out.print("请输入发送内容：");
			String s=sc.nextLine();
			s=s+"\n";//给拟发送的内容一个换行作为结束标记
			Socket socket=new Socket("172.16.57.73",8888);
			InputStream is=socket.getInputStream();
			OutputStream os=socket.getOutputStream();
			PrintWriter out=new PrintWriter(os);
			out.println(s); //把要发送的内容放于输出流
			out.flush();
			//如何把输入流内的字节转换成字符串并按UTF-8编码
			InputStreamReader isr=new InputStreamReader(is);//包在字符流中
			BufferedReader br=new BufferedReader(isr);//字符串缓存流
			//String msg=br.readLine();
			String msg="";
			StringBuilder sb=new StringBuilder();
			while((msg=br.readLine())!=null&&msg.length()>0){sb.append(msg);}
			msg=sb.toString();
			//---------------------------------
			System.out.println("服务器返回消息："+msg);
			os.close();//关闭输出流
			out.close();
			br.close();isr.close();is.close();//关闭输入流
			socket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
