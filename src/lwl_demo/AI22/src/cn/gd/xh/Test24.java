package lwl_demo.AI22.src.cn.gd.xh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test24 {

	public static void main(String[] args) {
		//集合对象，唯一性、有序性,Set、Map、List，这三个都是接口，不是类，所以不能直接用它们来建立对象
		Set<String> s=new HashSet<String>(); //用接口变量指向一个实现类建立的对象
		s.add("abc");
		s.add("cde");
		s.add("abb");
		s.add("abc");
		System.out.println(s);
		ArrayList<String> list=new ArrayList<String>();//LinkedList
		list.add("abc");
		list.add("cde");
		list.add("abc");
		System.out.println(list);
		list.remove("cde");
		System.out.println(list);
		
		LinkedList<Integer> list2=new LinkedList<Integer>();
		list2.add(2);list2.add(3);list2.add(0);list2.add(1);list2.add(10);
		System.out.println(list2);
		list2.remove(0);//既可以删除指定序号的元素，也可以指定值的元素，但如果是整数，默认是按序号删除的
		System.out.println(list2);
		
		HashMap<Integer,String> map=new HashMap<Integer,String>(); //TreeMap，保存的是    键值对 key:value
		map.put(123, "张三");
		map.put(456, "李四");
		map.put(123, "李老师");
		map.put(567, "李老师");
		System.out.println(map);

	}

}
