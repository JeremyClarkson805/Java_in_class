package lwl_demo.AI22.src.cn.gd.xh;

public class Test {

	public static void main(String[] args) {
		//double r=5;
		double r;
		r=5;
		System.out.println(Math.PI*r*r);
		//求sin(25度）
		double x=Math.sin(30/180.0*Math.PI);
		System.out.println(x);
		Person p1=new Person();//用类实例化一个对象p1
		p1.name="Zhansan";//给对象的成员变量name赋值
		p1.walk();//调用对象的成员函数walk()
		
		Long t=98888888888L;//因为整数默认是int类型，表示的范围小，所以在数字后加字母l表示为long类型
		Float f=3.14F;//小数默认是double类型，直接赋值给float类会丢失精度，所以要声明为float类型
		char k1='A';//这是单字符
		String k2="A";//这是字符串
		System.out.println(k1);
		System.out.println((int)k1);
		//System.out.println((int)k2);
		//System.out.println(k1==k2);
		
		
	}

}




