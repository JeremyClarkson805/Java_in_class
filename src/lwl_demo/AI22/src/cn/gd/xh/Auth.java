package lwl_demo.AI22.src.cn.gd.xh;

public class Auth {//实体类或叫模型类
	private int id;
	private int age;
	private String username;
	private String password;
	private String realname;
	//接下来的getters和setters方法，还有全参数和无参数的构造方法，全部自动生成
	//右击source-generate getters and setters...全选
	//右击source-generate constructor using fields..全选
	//右击source-generate constructor using fields..全不选
	
	public int getId() {
		return id;
	}
	public Auth() {
		super();
	}
	public Auth(int id, int age, String username, String password, String realname) {
		super();
		this.id = id;
		this.age = age;
		this.username = username;
		this.password = password;
		this.realname = realname;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	
	
}
