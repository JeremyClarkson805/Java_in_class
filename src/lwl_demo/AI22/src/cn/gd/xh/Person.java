package lwl_demo.AI22.src.cn.gd.xh;

public class Person {
	int age;//成员变量
	String name;//成员变量
	Integer grade;//成员变量
	//函数的声明套路
	//修饰符 返回值 函数名(参数列表){函数体}
	public void walk(){ //成员方法
		int n;//内部变量，没有默认的初始值,不能直接使用
		
		System.out.println(name+" can walk.");
		System.out.println(name +" is " + age + " years old.");
		//System.out.println(n);
		n=0;
		System.out.println(n); 
	}
}
