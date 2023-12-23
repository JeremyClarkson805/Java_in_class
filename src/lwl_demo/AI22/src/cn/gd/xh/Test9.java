package lwl_demo.AI22.src.cn.gd.xh;

public class Test9 {
	static int x=1;//类内全局变量，即成员变量
	static void a(){
		x=2;//局部变量
		System.out.println(x);
	}
	static void b(){
		System.out.println(x);
	}
	
	
	
	public static void main(String[] args) {
		a();//2
		b();
	}

}
class Test9_2{
	public static void main(String[] args) {
		System.out.println(Test9.x);
	}
	
}
