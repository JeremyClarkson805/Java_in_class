package lwl_demo.AI22.src.cn.gd.xh;

public class Human {
	//一个类里，包括两大部分，即属性（特征，成员）和方法（函数，功能）
	private double tall;//private仅在类内可用，不可被继承
	public int age;//类内类外均可使用
	protected String name;//同包内的类内类外可用，但包外的类不可用
	//------------
	//修饰符 返回值类型 函数名(参数列表){函数体}
	public void talk(){
		System.out.println(name+" is "+ age + "years old.");
	}
	
}
