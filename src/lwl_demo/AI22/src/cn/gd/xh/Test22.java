package lwl_demo.AI22.src.cn.gd.xh;

public class Test22 {

	public static void main(String[] args) {
		// &&和&，&&是一种逻辑运算，即左右两侧都是true或false的逻辑值，&是位运算，是左右两侧的二进制逐位与运行
		int a=6,b=20;
		boolean c=true,d=false;
		System.out.println(c&&d);//逻辑与，只有两边都是true结果才是true,其他情况都是false
		System.out.println(Integer.toBinaryString(20));
		System.out.println(Integer.toHexString(20));
		System.out.println(Integer.toOctalString(20));
		System.out.println("***************************");
		int x=500;
		System.out.println(Integer.toBinaryString(x));
		byte y=(byte)x;//byte的第一位是符号位，1代表负，0代表正
		System.out.println(y);
		System.out.println(x & 0xFF);
		
		

	}

}
