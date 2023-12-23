package lwl_demo.AI22.src.cn.gd.xh;

public class Seller {

	public static void main(String[] args) {
		//Express e=new Express();//接口不能真被new出对象，必须是实现这个接口的类才可以
		Express e=new SFExpress();//用接口定义的变量e可以指向实现了这个接口的类new出来的对象
		System.out.println(e.calculateFee(4, 55));
		e=new YunDaExpress();
		System.out.println(e.calculateFee(4, 55));
	}
}
