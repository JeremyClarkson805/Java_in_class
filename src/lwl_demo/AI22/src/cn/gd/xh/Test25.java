package lwl_demo.AI22.src.cn.gd.xh;

import java.util.HashSet;
import java.util.Scanner;

public class Test25 {

	public static void main(String[] args) {
		//从键盘输入100次数字，计算总共输入了几个数（不重复）
		HashSet<Integer> set=new HashSet<Integer>();//去重功能强大
		Scanner sc=new Scanner(System.in);
		for(int j=0;j<10;j++){
			int a=sc.nextInt();
			set.add(a);//会自动去重，无需遍历判断
		}
		System.out.println(set.size());

	}

}
