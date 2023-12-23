package lwl_demo.AI22.src.cn.gd.xh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;

import com.mysql.cj.util.StringUtils;

public class Test51 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		addData();
		return;
		//请参考下面的内容，自行变形严重用户名和密码的功能
		//提示ResultSet rs=con.executeQuery("select * from auth where username='' and password='' ");
	}
private static void addData() throws ClassNotFoundException, SQLException{
	//弹出确认的窗口 JOptionPane.showConfirmDialog(null,"你确定要这么做吗？");//0是，1否，2取消
	//String msg=JOptionPane.showInputDialog("请输入授权码:");
	//System.out.println(msg);
	while(true){
		String un=JOptionPane.showInputDialog("请输入用户名：");
		if(StringUtils.isNullOrEmpty(un))return;//如果按取消就退出
		//上句相当于if(un==null || un.equals("")) return；
		String pwd=JOptionPane.showInputDialog("请输入密码：");
		if(StringUtils.isNullOrEmpty(pwd))return;
		String rn=JOptionPane.showInputDialog("请输入真实姓名：");
		if(StringUtils.isNullOrEmpty(rn))return;
		int age=0;
		try{
		 age=Integer.parseInt(JOptionPane.showInputDialog("请输入年龄："));
		 if(age>150||age <0){
			 JOptionPane.showMessageDialog(null, "年龄大小不对，将弹出");
			 continue;
		 }
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "年龄格式不对，将弹出");
			continue;
		}
		int n=saveData(un,pwd,rn,age);
		int r=JOptionPane.showConfirmDialog(null, "添加"+(n>0?"成功":"失败")+",是否继续呢?");
		System.out.println(r);
		if(r==0){
			continue;//代表继续
		}else{
			System.out.println(111);
			return;//代表结束
		}
	}
}
	
private static int saveData(String un,String pwd,String rn,int age) throws ClassNotFoundException, SQLException{
	String sql="insert into auth(username,password,realname,age) values(?,?,?,?)";
	// 1.加载驱动程序（driver/adapter），jar		  
	Class.forName("com.mysql.cj.jdbc.Driver");
	//Class.forName(xxx.xx.xx)的作用是要求JVM查找并加载指定的类，也就是说JVM会执行该类的静态代码段。
	 //2.获取数据对象
	String url="jdbc:mysql://localhost:3306/22ai";//标示数据库在哪 //localhost:3306为服务器地址
	//localhost-数据库服务器在哪  连接时用户名字和密码要相同
	String user="test";//用户名字
	String password="123456";//密码
	Connection con =DriverManager.getConnection(url,user,password);//连接数据库
	PreparedStatement ps=con.prepareStatement(sql);
	//填充的具体类型视情况而定
	ps.setString(1,un);//填充第一个问号里面的字符串
	ps.setString(2,pwd);//填充第二个问号里面的字符串
	ps.setString(3,rn);//填充第三个问号里面的字符串
	ps.setInt(4,age);//填充第四个问号里面的整数
	int n=ps.executeUpdate();
	ps.close();
	con.close();
	return n;
}
}
