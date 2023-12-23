package lwl_demo.AI22.src.cn.gd.xh;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {
		//System.in  InputStream
		//从键盘输入两个数，计算和后输出
		String a="",b="";
		Scanner sc=new Scanner(System.in);
		
		try{System.out.print("请输入一个数：");a=sc.nextLine();}catch(Exception e){}//阻塞语句，会等待键输入，回车后结束
		try{System.out.print("请再输入一个数：");b=sc.nextLine();}catch(Exception e){}
		
		System.out.println(a+b);
	}

}
