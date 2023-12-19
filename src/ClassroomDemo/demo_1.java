package ClassroomDemo;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class demo_1 {
    static void test_1(){
        //--------- 列表的操作
        Integer[] a = {1, 3, 5, 7, 9};
        String[] b = {"aaa", "bbb", "ccc"};
        System.out.println(a);//输出的是他的地址，即首元素的地址
        System.out.println(b);
        System.out.println(Arrays.asList(a));//先把这个东西转成列表，再输出
        System.out.println(Arrays.asList(b));
        for (int i = 0; i < a.length; i++) {System.out.print(a[i]);}//最传统的遍历的写法
        System.out.println("\n");
        for (int x : a) {System.out.print(x);}//jdk1.5以后的写法，增强型for循环
        System.out.println("\n");
        Arrays.asList(a).forEach(x->{
            System.out.print(x);
        });//当前流行的循环方式
        System.out.println("\n");
        //---------- 列表的复制
        Integer[] c = new Integer[a.length];
        System.arraycopy(a,0,c,0,a.length);//.arraycopy(a数组,a的起始位置,复制到的数组,复制到数组的下标)
        System.out.print(Arrays.asList(c));
    }
    static void test_2(){
        //---------- 数字运算
        //&&和&，&&是一种逻辑运算，即左右都是true或false的逻辑值，&是位运算，是左右两侧的二进制逐位运算
        int a=6,b=20;
        boolean c=true,d=false;
        System.out.println(c&&d);//逻辑与，两个都是true结果才是true，其他情况都是false
        System.out.println(Integer.toBinaryString(20));//该方法返回String类型用2进制表示的数字
        System.out.println(Integer.toHexString(20));//该方法返回String类型用16进制表示的数字
        System.out.println(Integer.toOctalString(20));//以String类型返回为以8为底的无符号整数
        System.out.println("--------------------");
        int x = 500;
        byte y = (byte)x;
        System.out.println(y);
    }
    static void test_3(){
        //-------------求整数500的低八位的异或校验码
        int x = 500;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(0xff));
        System.out.println(Integer.toBinaryString(x & 0xff));//取下这个数的低八位
        //0->48 a->97
        String str = Integer.toBinaryString(x & 0xFF);
        int check = str.charAt(0)-48;//取下当前字符转位数字以方便异或运算
        for (int i=1;i<str.length();i++){
            check = check^(str.charAt(i)-48);
        }
        System.out.println(check);
    }
    static void test_4(){
        //------------集合对象
        //唯一性，有序性
        // Set Map List 这三个都是接口，不是一个类，所以不能直接用他们来建立对象
        //Set对象，不可重复且无序 --->可以用来去重
        //无序HashSet是他的实现类
        Set<String> s = new HashSet<String>();//用接口变量指向一个实现类建立的对象
        s.add("abc");
        s.add("bbc");
        s.add("def");
        System.out.println(s);
        //List接口，可重复元素，有序ArrayList和LinkedList是他的实现类
        //ArrayList对象，可重复，且按添加的时间来排序
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("abc");
        list.add("cdf");
        System.out.println(list);
        list.remove("cdf");//remove既可以删除指定序号的元素（默认），也可以指定值的元素，如果是整数，默认是按序号删除的
        System.out.println(list);
        //Map对象
        HashMap<Integer,String> map = new HashMap<>();//TreeMap保存的是键值对，key:value,值可以重复，键不可以重复，如果重复了后面的会把前面的给替换掉
        map.put(123,"张三");
        map.put(456,"李四");
        map.put(789,"王五");
        System.out.println(map);
    }
    static void test_5(){
        People p1 = new People("张三",18,180);
        People p2 = new People("李四",10,120);
        People p3 = new People("王五",20,199);
        ArrayList<People> list = new ArrayList<>();
        list.add(p1);list.add(p2);list.add(p3);
        System.out.println(list);
        //列表排序
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list,new AgeComparator());
        System.out.println(list);
        Collections.sort(list,new WeightComparator());
        System.out.println(list);
        Collections.sort(list,new PeopleComparator(2,-1));//可以通过构造函数传参的方式来指定排序的数据和排序的方式
        System.out.println(list);
    }
    static void test_6() throws ParseException {
        //时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时:mm分:ss秒");//月份MM，mm是分钟。HH代表24小时制，hh代表12小时制
        System.out.println(sdf.format(System.currentTimeMillis()));

        Date d = new Date();
        System.out.println(d);
        System.out.println(sdf.format(d));
        System.out.println(d.getDay());
        System.out.println(d.getTime());//获取时间戳，从1970-1-1 0:0:0开始计算的时间秒数
        System.out.println(d.toLocaleString());
        System.out.println("---------------------");
        Calendar c = Calendar.getInstance();//这是个日历对象，不是一个日期对象
        Date d2 = c.getTime();
        System.out.println(sdf.format(d2.getTime()));
        String t = new String("2003年08月05日 12时:18分:36秒");
        System.out.println(sdf.parse(t));  //parse是format的逆向操作，可以把一个固定格式的日期转回时间戳
        System.out.println(sdf.parse(t).getDay());//getDay()可以获取该日期是星期几，这样可以获取某个日期是那一年的星期几
        System.out.println(c.get(Calendar.DAY_OF_YEAR));//获取今天是今年的第几天
        System.out.println(c.getTime().getTime());//两次getTime才能获取到时间戳，第一次是时间，第二次才是时间戳
    }
    static void test_7(){
        //数据格式的处理
        DecimalFormat df = new DecimalFormat("000");//格式化数字
        for (int i = 0; i < 101; i++) {
            System.out.println(df.format(i));
        }
    }
    static void test_8(){
        DecimalFormat df = new DecimalFormat("0.00");//格式化输出数字
        System.out.println(df.format(1));
    }
    public static void main(String[] args) {
        test_3();
    }
}

class People implements Comparable<People>{
    private String name;
    private int age;
    private double weight;

    public People(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name=" + name + '\t' +
                "age=" + age + '\t' +
                "weight=" + weight;
    }

    public People() {super();}

    @Override
    public int compareTo(People o) {
        return this.age>o.age?1:-1;
    }
}

class AgeComparator implements Comparator<People>{
    @Override
    public int compare(People o1, People o2) {
        return o1.getAge()<o2.getAge()?1:-1;
    }
}

class WeightComparator implements Comparator<People>{
    @Override
    public int compare(People o1, People o2) {
        return o1.getWeight()> o2.getWeight()?1:-1;
    }
}

class PeopleComparator implements Comparator<People>{
    private int param,sort;

    public PeopleComparator(int p1, int p2) {
        this.param = param;
        this.sort = sort;
    }

    @Override
    public int compare(People o1, People o2) {
        if (param==1) return o1.getAge()>o2.getAge()?sort:-sort;
        else if (param==2) return o1.getWeight()>o2.getWeight()?sort:-sort;
        else return o1.getName().compareTo(o2.getName())>0?sort:-sort;
    }
}