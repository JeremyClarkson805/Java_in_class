package ClassroomDemo.ChattingGen2;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class ClientGUI {
    static JTextField jtf = null;
    static JTextArea jta = null;
    static JFrame jf = null;
    static ActionListener l = new MyActionListener();
    static KeyListener l2 = new MyKeyListener();
    static OutputStream os = null;
    static PrintWriter out = null;
    static Socket socket = null;
    public static void main(String[] args) {
        jf = new JFrame("群聊窗口");
        jf.setSize(500,400);
        jf.setResizable(false);//锁定窗口大小
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口即退出程序
        jta = new JTextArea();//聊天框，文本框
        jta.setEditable(false);//让聊天记录框不能被编辑
        jta.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(jta);//滚动条 把文本框加到一个滚动面板上
        jf.add(jsp);//再把面板加入窗口
        JPanel jp = new JPanel();//底部的面板，用来放输入框和按钮
        jtf = new JTextField(25);//输入框
        jtf.addKeyListener(l2);
        JButton jb = new JButton("发送");//发送按钮
        jb.addActionListener(l);//添加一个行为监听器
        jp.add(jtf);jp.add(jb);
        jf.add(jp, BorderLayout.SOUTH);
        jf.setVisible(true);//让窗口出现

        try {
            socket = new Socket("127.0.0.1", 8888);
            //收和发分开处理
            new Receiver_2(socket.getInputStream()).start();//把收消息交给其他线程处理
            //发消息
            os = socket.getOutputStream();
            out = new PrintWriter(os);
        } catch (IOException e) {
            System.out.println("无法连接到服务器");
        }

    }
    static void action(){
        String msg = ClientGUI.jtf.getText();//通过类名访问静态变量
        msg = msg.trim();
        if (msg.isEmpty()){
            JOptionPane.showMessageDialog(ClientGUI.jf,"请不要发送空消息");//通过弹窗的方式展示消息
            return;
        }
        ClientGUI.out.println(msg);
        ClientGUI.out.flush();
        ClientGUI.jtf.setText("");
    }
}

class MyActionListener implements ActionListener{//实现监听器接口的类
    @Override
    public void actionPerformed(ActionEvent e) {
        ClientGUI.action();
    }
}

class MyKeyListener implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER){
            ClientGUI.action();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

class Receiver_2 extends Thread {//专门拿来接收消息的线程
    InputStream is = null;
    public Receiver_2(InputStream is) throws IOException {
        this.is = is;
    }

    @Override
    public void run() {
        super.run();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String msg = null;
        try {
            while ((msg = br.readLine()) != null) {
                System.out.println("收到消息:" + msg);
                String old = ClientGUI.jta.getText();
                ClientGUI.jta.setText(old + "\n" + msg);
                ClientGUI.jta.select(Integer.MAX_VALUE,1);
            }
        } catch (IOException e) {
            System.out.println("服务器已关闭");
        }
    }
}