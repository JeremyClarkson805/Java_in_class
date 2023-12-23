package lwl_demo.AI22.src.cn.gd.xh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test5 {

	public static void main(String[] args) {
		// 把一个邮箱的服务器名称取出来，例如5681492@qq.com中取出qq
		String email="lwl.sysu@gmail.com.cn";//要取出的是gmail，如何取？
		int at=email.indexOf("@");
		int dot=email.indexOf(".",at);
		String result=email.substring(at+1,dot);
		System.out.println(result);
		//---
		String id="440106200505091234";//判断性别
		char c=id.charAt(16);//'3'不是3，对应的数值是51，即'0'->48,'1'->49,'2'->50,'3'->51...
		int g=c-48;//3
		System.out.println(g);
		String gender=g%2==0?"女":"男";
		System.out.println(gender);
		//substring(a,b)代表取出字符串第a至b之间的子串,注[a,b)，返回子串
		//indexOf(a)求出字符a在字符串中的位置，默认从头开始找，返回整数
		//chatAt(a)求出第a个位置上的字符是什么，返回字符
		//split(a)按a字符作分隔符，将字符串切割成字符串数组，返回字符串数组
		//toLowerCase()、toUpperCase()转换小写、大写
		//equals(a)判断字符串与a是否一样，返回boolean
		//length()求字符串的长度，即字符个数，返回整数
		//字符串与数值之间的转换。。。
		String a="123";
		int b=123;
		System.out.println(a+b);
		System.out.println(Integer.parseInt(a)+b);
		int a2=1,b2=1;
		System.out.println(a2+""+b2);//如果我想输出11，即拼接两个1而非相加呢？数值+字符串=字符串，字符串+数值=字符串
		//-----------
		String passport="sysu@gmail.com.cn";//取出数字部分拼成一个新的字符串
		StringBuilder str=new StringBuilder();
		for(int i=0;i<=passport.length()-1;i++){
			char ch=passport.charAt(i);
			if(Character.isDigit(ch)){
				str=str.append(ch);//追加到StringBuilder后
			}
		}
		System.out.println(str);
		str=new StringBuilder();
		Pattern p=Pattern.compile("@\\w+\\.");//模式
		Matcher m=p.matcher(passport);//匹配
		System.out.println(Pattern.matches("\\d{17}[0-9Xx]$", "44010520050509123x"));
		while(m.find()){ //所有匹配的组都会被遍历一次
			String t=m.group();//找到的组
			str=str.append(t);
		}
		System.out.println(str);
		//后续可以考虑使用正则表达式取
	}

}
