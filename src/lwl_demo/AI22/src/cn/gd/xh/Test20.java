package lwl_demo.AI22.src.cn.gd.xh;

import java.util.ArrayList;
import java.util.Arrays;

public class Test20 {

	public static void main(String[] args) {
		//数组的浅拷贝和深拷贝
		//类型[] 数组名=new 类型[个数]；
		int[] a={1,4,5,2};//相当于Integer[]a=new Integer[4];a[0]=1,a[1]=4;....
		String[] b={"aaa","bbb","ccc"};
		System.out.println(a);//输出是它的地址，即首元素的地址
		System.out.println(b);
		System.out.println(Arrays.asList(a));//先把这个数组转成列表，再输出
		System.out.println(Arrays.asList(b));
		//for(int i=0;i<a.length;i++){System.out.println(a[i]);}//这是传统写法
		for(int x:a){System.out.println(x);}//jdk1.5后，增强型for循环
		Arrays.asList(a).forEach(x->{System.out.println(x);});//当前流行的循环方式

	}

}
