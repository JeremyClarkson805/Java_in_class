package lwl_demo.AI22.src.cn.gd.xh;

public class Test2 {

	public static void main(String[] args) {
		int a1=10;
		int a2=10;
		System.out.println(a1==a2);
		Integer b1=new Integer(20);
		Integer b2=new Integer(20);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b1==b2);//b1和b2都是对象类型，对象类型用==比较的不是值，而是对象的地址
		System.out.println(b1.equals(b2));//对象内的值是否相等的判断，用要其equals函数
		double x=new Integer(a1).doubleValue()/50;
		System.out.println(x);
	}

}
