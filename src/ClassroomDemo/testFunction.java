package ClassroomDemo;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testFunction {
    //数字的转换
    static void test_1()
    {
        double a = 3.14,b = -1.34;
        System.out.println(Math.floor(b)); //a->得到3.0，b->-2.0   floor得到这个数取整时小的数
        System.out.println(Math.ceil(b));  //a->得到4.0，b->-1.0   ceil得到这个数取整时大的数
        System.out.println(Math.round(b));  //a->得到3，b->-1      5舍6入
    }

    //字符的匹配
    static void test_2()
    {
        String email = "lwl.sysu@gmail.com.cn";  //从其中取出gmail
        int at = email.indexOf("@");
        int dot = email.indexOf(".",at);
        String result = email.substring(at+1,dot);
        System.out.println(result);
        /*
        substring(a,b) 代表取出字符串第a至b之间的子串，[a,b),返回子串
        indexOf(a)求出字符a在字符串中的位置，默认从头开始找，返回整数
        chatAt(a)求出第a个位置上的字符是什么，并返回字符
        split(a)按a字符作为分隔符，将字符串切割成字符串数组，返回字符串数组
        toLowerCase()、toUpperCase()转换小写/大写
        equals(a)判断字符串与a是否一样，返回boolean
         */
    }

    //字符串与数值之间的转换
    static void test_3()
    {
        String a = "123";
        int b =123;
        System.out.println(Integer.parseInt(a)+b);
    }

    //正则表达式 和 StringBuilder 和 StringBuffer
    static void test_4()
    {
        Pattern p = Pattern.compile("\\d+");
        String ab = "a9091hao67idh1";
        Matcher m = p.matcher(ab);
        StringBuilder str = new StringBuilder();//StringBuilder->字符串构造器->单线程下用，多线程下用StringBuffer->缓存，多线程用，是自带锁的，可以防止数据的丢失
        while (m.find())
        {
            String t = m.group();
            str.append(t);//如果是String str = ""的话，str += t这一操作每次都会给他找一个新地方来存放数据,
        }
        System.out.println(str);
    }

    //ctrl+alt+T  ->自动生成try catch代码块
    //ctrl + alt + L  格式化代碼
    static void test_5()
    {

        try
        {
            int a = 1;
            System.out.println(a);
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    static void test_6() throws IOException  //从网络读取流
    {
        URL url = new URL("https://www.xhsysu.edu.cn/");
        url.openConnection();//联网
        InputStream is = url.openStream();//打开网络流
        byte b []= new byte[4096];
        int n = is.read(b);
        System.out.println(new String(b,"utf-8"));
        is.close();
    }

    public static void main(String[] args)
    {
//        try { test_6(); }
//        catch (IOException e) { throw new RuntimeException(e); }
        System.out.println("7a8D8WQ9NTwYaw==".length());
    }


}
