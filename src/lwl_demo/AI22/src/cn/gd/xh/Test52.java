package lwl_demo.AI22.src.cn.gd.xh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.cj.util.StringUtils;

public class Test52 {
	public static Auth user=null;
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//addData();
		//请参考下面的内容，自行编写验证用户名和密码的功能代码
		JFrame jf=new JFrame("我是一个窗口");
		JTextField un=new JTextField(20);
		JPasswordField pwd=new JPasswordField(20);
		jf.setLayout(null);
		jf.add(un);jf.add(pwd); 
		un.setBounds(50, 40, 300, 30);
		pwd.setBounds(50, 80, 300, 30);
		JButton bt=new JButton("登录");
		bt.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String username=un.getText();
				String password=pwd.getText();
//				System.out.println(username);
//				System.out.println(password);
				if(username.equals("")||password.equals("")){
					JOptionPane.showMessageDialog(jf, "用户名和密码均不能为空！");
					return;
				}
				//接下来去数据库验证用户名和密码，返回匹配的用户Auth对象，或null(即验证不通过）
				try {
					user=checkUser(username,password);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(user==null){
					JOptionPane.showMessageDialog(jf, "用户名或密码错误！");
				}else{
					JOptionPane.showMessageDialog(jf, "你好"+user.getRealname());
				}
			}	
		});
		jf.add(bt);
		bt.setBounds(150, 120, 100, 30);
		jf.setSize(400, 300);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//提示：ResultSet rs=con.executeQuery("select * from auth where username='' and password=''");
		//下节课验证一下！！！

	}
protected static Auth checkUser(String username, String pwd) throws SQLException, ClassNotFoundException {
	username=username.replace("'", "").replace(" ","").replace("/", "").replace("\\", "");
	pwd=pwd.replace("'", "").replace(" ","").replace("/", "").replace("\\", "");
	String sql="select * from auth where username='"+username+"' and password='"+pwd+"'";
//	一、加载驱动程序（driver/adapter),jar
	Class.forName("com.mysql.cj.jdbc.Driver");
//	二、获取数据库连接对象
	String url="jdbc:mysql://localhost:3306/22ai";//数据库在哪里
	String user="test";//据实
	String password="123456";//据实
	Connection con=DriverManager.getConnection(url, user, password);
	ResultSet rs=con.createStatement().executeQuery(sql);//查询将返回一个结果集
	Auth u=null;
	if(rs.next()){
		u=new Auth();
		u.setUsername(rs.getString("username"));
		u.setPassword(rs.getString("password"));
		u.setRealname(rs.getString("realname"));
		u.setAge(rs.getInt("age"));
		u.setId(rs.getInt("id"));
	}
	rs.close();
	con.close();
	return u;
	}
private static void addData() throws ClassNotFoundException, SQLException{
	while(true){
		String un=JOptionPane.showInputDialog(null,"请输入用户名：");
		if(StringUtils.isNullOrEmpty(un))return;//如果按了“取消”就退出，下周
		String pwd=JOptionPane.showInputDialog("请输入密码：");
		if(StringUtils.isNullOrEmpty(pwd))return;
		String rn=JOptionPane.showInputDialog("请输入真实姓名：");
		if(StringUtils.isNullOrEmpty(rn))return;
		int age=0;
		try{age=Integer.parseInt(JOptionPane.showInputDialog("请输入年龄："));
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "年龄格式不对，将重新来过！");
			continue;
		}
		int n=saveData(un,pwd,rn,age);
		int r=JOptionPane.showConfirmDialog(null, "添加"+(n>0?"成功":"失败")+",是否继续？");
		if(r==0)continue;//代表继续
		else return;//代表不继续
	}
}
private static int saveData(String un,String pwd,String rn,int age) throws ClassNotFoundException, SQLException{
	String sql="insert into auth(username,password,realname,age) values(?,?,?,?)";
//	一、加载驱动程序（driver/adapter),jar
	Class.forName("com.mysql.cj.jdbc.Driver");
//	二、获取数据库连接对象
	String url="jdbc:mysql://localhost:3306/22ai";//数据库在哪里
	String user="root";//据实
	String password="Tian18922078980";//据实
	Connection con=DriverManager.getConnection(url, user, password);
	PreparedStatement ps=con.prepareCall(sql);
	ps.setString(1, un);ps.setString(2, pwd);ps.setString(3, rn);ps.setInt(4, age);
	int n=ps.executeUpdate();
	ps.close();
	con.close();
	return n;
}
}
