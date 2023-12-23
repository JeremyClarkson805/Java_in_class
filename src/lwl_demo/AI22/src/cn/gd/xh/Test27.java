package lwl_demo.AI22.src.cn.gd.xh;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test27 {

	public static void main(String[] args) throws ParseException {
		// 系统的当前时间，格式
//		Date d=new Date();
//		System.out.println(d);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
//		System.out.println(sdf.format(d));
//		System.out.println(d.getTime());//时间戳，从1970-1-1 0：0：0开始计起的毫秒数
//		System.out.println(d.getDay());
//		System.out.println(d.toLocaleString());
//		d.setYear(2022-1900);d.setMonth(11);d.setDate(1);
//		System.out.println(d);
		
		Calendar c=Calendar.getInstance();//是一个日历对象，不是一个日期对象
		Date d=c.getTime();
		System.out.println(d);
		System.out.println(sdf.format(d));
		String t="2022年12月01日 12:18:38";
		d=sdf.parse(t);//parse是format的逆向操作
		System.out.println(d.toLocaleString()+"\t"+d.getDay());
		System.out.println(c.get(Calendar.DAY_OF_YEAR));
		System.out.println(c.getTime().getTime());
		

	}

}
