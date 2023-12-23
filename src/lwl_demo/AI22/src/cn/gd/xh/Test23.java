package lwl_demo.AI22.src.cn.gd.xh;

public class Test23 {

	public static void main(String[] args) {
		// 写程序：求整数500的低8位的异或校验码
		int x=500;
		String str=Integer.toBinaryString(x & 0xFF);//取下它的低8位
		int check=str.charAt(0)-48;//取下当前字符转为数字以方便异或运算
		for(int i=1;i<str.length();i++){
			check=check^(str.charAt(i)-48);
		}
		System.out.println(check);
	}

}
