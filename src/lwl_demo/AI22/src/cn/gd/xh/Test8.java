package lwl_demo.AI22.src.cn.gd.xh;

public class Test8 {

	public static void main(String[] args) {
		//MyClass m=new MyClass();//抽象类不能直接用来new对象，其里面的所有抽象方法必须实现后，才可以new出对象来
		MyClass m=new MyClass2();//MyClass2已经实现了里面的抽象方法，所以可以new出对象来了
		m.common();
		m.task1();
		m.task2();
	}

}
class MyClass2 extends MyClass{//类继承抽象类后，要实现里面的所有抽象方法

	@Override
	void task1() {
		System.out.println("task1...");
		
	}

	@Override
	void task2() {
		System.out.println("task2...");
		
	}
	
}