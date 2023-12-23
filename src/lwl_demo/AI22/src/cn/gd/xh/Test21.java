package lwl_demo.AI22.src.cn.gd.xh;

import java.util.Arrays;

public class Test21 {

	public static void main(String[] args) {
		Integer[] a={1,4,5,2};
		Integer[] b=new Integer[a.length+3];
		System.arraycopy(a, 0, b, 3, a.length);;
		System.out.println(Arrays.asList(a));
		System.out.println(Arrays.asList(b));
		
	}

}
