package lwl_demo.AI22.src.cn.gd.xh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class SuperServer {
	public static HashMap<Integer,Socket> map=new HashMap<Integer,Socket>();//声明房间
	public static void sendAll(String msg){//群发消息
		for(int i=0;i<map.size();i++){
			if(map.get(i)!=null){//如果这个房间不为空，说明有客人，需要发
				try {
					OutputStreamWriter osw=new OutputStreamWriter(map.get(i).getOutputStream());
					osw.write(msg+"\n");
					osw.flush();
				} catch (IOException e) {
					map.put(i, null);//说明这个房间的客人已经掉线了，删掉。
					//e.printStackTrace();
				}
			}
		}	
	}
	//以上声明一个键值对集合，键是整数代表房间编号，Socket代表客人
	public static void main(String[] args) throws IOException {
		ServerSocket server=new ServerSocket(8888);
		System.out.println("超级服务器启动在端口："+server.getLocalPort());
		while(true){
			Socket socket=server.accept();//阻塞在这里，等待有客人来才往下执行
			int i=-1,j=0;
			for(;j<map.size();j++){
				if(map.get(j)==null){
					i=j;
					break;
				}
			}
			if(j==map.size())i=j;//如果原来map没有空的房间，则以j最后的值为编号作新房间
			map.put(i, socket);//把新来的客户socket请入第i个房间
			new Waiter(i,socket).start();//交给新的服务员为客人服务
		}
	}
}
class Waiter extends Thread{
	Integer i;
	String name;
	Socket socket=null;
	public Waiter(Integer i,Socket socket){
		this.i=i;
		this.socket=socket;
		this.name=(i+1)+"服务员";
	}
	//要做的两件事儿：一是收客人的消息，二是把消息发给所有客人
	@Override
	public void run() {
		super.run();
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg=null;
			while((msg=br.readLine())!=null){//收内容，如果不为空，则：
				System.out.println("收到客户："+socket.getRemoteSocketAddress()+"发来的消息："+msg);
				//把消息群发出去
				SuperServer.sendAll(name+"发出来自"+socket.getRemoteSocketAddress()+"的消息:"+msg);//调用服务器群发消息
			}
		} catch (IOException e) {
			SuperServer.map.put(i, null);//一旦出错，则把这个房间置空，说明原来的客人已经离线了！
			//e.printStackTrace();
		}
	}	
}





