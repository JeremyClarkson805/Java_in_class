package lwl_demo.AI22.src.cn.gd.xh;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGUI {
	static JTextField jtf=null;
	static JTextArea jta=null;
	static JFrame jf=null;
	static OutputStream os=null;
	static PrintWriter out=null;
	static Socket socket=null;
	static ActionListener l=new MyActionListener();
	static KeyListener l2=new MyKeyListener();
	public static void main(String[] args) {
		jf=new JFrame("新华群聊窗口");
		jf.setSize(500, 400);
		jf.setResizable(false);//锁定窗口大小
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口即退出程序
		jta=new JTextArea();//文本框
		jta.setEditable(false);//聊天记录框不给编辑用
		jta.setLineWrap(true);
		JScrollPane jsp=new JScrollPane(jta);//把文本框加到一个滚动面板上去
		jf.add(jsp);//把面板加入窗口
		JPanel jp=new JPanel();//底部的面板，用来放输入框和按扭
		jtf=new JTextField(37);//输入框
		jtf.addKeyListener(l2);
		JButton jb=new JButton("发送");//发送按扭
		jb.addActionListener(l);//添加一个行为监听器
		jp.add(jtf);jp.add(jb);
		jf.add(jp,BorderLayout.SOUTH);
		jf.setVisible(true);

		
		
		
		
		try {
			socket=new Socket("127.0.0.1",8888);//连接服务器
			new Receiver2(socket.getInputStream()).start();//把收的事情交给其他线程
			os=socket.getOutputStream();
			out=new PrintWriter(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static void baby(){
		String msg=ClientGUI.jtf.getText();
		msg=msg.trim();
		if(msg.equals("")){
		JOptionPane.showMessageDialog(ClientGUI.jf,"请不要发送空消息");//弹消息窗，第一个参数是窗口归属于谁，第二个参数是弹出来的消息
		return;
		}
		ClientGUI.out.println(msg);//发送！
		ClientGUI.out.flush();
		ClientGUI.jtf.setText("");
	}
}
class MyActionListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		ClientGUI.baby();
	}
}
class MyKeyListener implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar()==KeyEvent.VK_ENTER){//
			ClientGUI.baby();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
class Receiver2 extends Thread{//这个拿来做接收用
	InputStream is=null;
	public Receiver2(InputStream is){
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
				String old=ClientGUI.jta.getText();
				ClientGUI.jta.setText(old+"\n"+msg);
				ClientGUI.jta.select(Integer.MAX_VALUE,1);
			}
		} catch (IOException e) {
			System.out.println("客户端下线啦！！");
			//e.printStackTrace();
		}
	}
}
