package BookDemo;

import java.text.SimpleDateFormat;  //导入专用于日期格式的类
import java.util.Date;              //导入日期类
public class P16 {
    public static void main(String[] args) {
        Date date = new Date();   //无参数的date会返回当前的系统时间
        System.out.println(date);

        SimpleDateFormat sdf_1 = new SimpleDateFormat("yyyyMMdd");//新建一种格式实例sdf_1
        String dateformat_1 = sdf_1.format(date);   //用格式sdf_1来转换结果(转换上面的date)
        System.out.println(dateformat_1);

        SimpleDateFormat sdf_2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String dateformat_2 = sdf_2.format(date);
        System.out.println(dateformat_2);
    }
}