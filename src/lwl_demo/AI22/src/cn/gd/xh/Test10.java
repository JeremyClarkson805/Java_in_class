package lwl_demo.AI22.src.cn.gd.xh;

public class Test10 {

	int k=1;
	static int j=2;
	
	
	public static void main(String[] args) {//静态方法内，只能用静态成员变量，如果要用非静态成员变量，则要先生成对象，通过对象访问非静态成员变量
		Test10 t=new Test10();
		t.k=20;
		j=3;
		M m=new M();
		M m2=new M();
		System.out.println(m.x);//成员变量，无法通过类名访问，只能通过类生成的对象访问
		System.out.println(m2.x);
		m2.x=30;
		System.out.println(m.x);//10
		m.y=50;
		System.out.println(m2.y);//???
		System.out.println(M.y);//静态变量，通过类名就可以访问访问
		m.a();//成员方法，用对象名引用
		M.b();//静态方法，用类名引用
	}
	
}

class M{
	int x=10;//成员变量，随类生成的对象而生，每个对象都有自己的这个变量，互不干扰
	static int y=20;//静态变量，随类而生，所有由此类生成的对象共用的变量
	void a(){
		System.out.println("aaaa");
	}
	static void b(){
		System.out.println("bbbb");
	}
	
}