package lwl_demo.AI22.src.cn.gd.xh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test26 {
	public static void main(String[] args) {
	 People p1=new People("张三",18,70);
	 People p2=new People();
	 p2.setName("李四");
	 p2.setAge(19);
	 p2.setWeight(60);
	 People p3=new People("王二",20,65);
	 People p4=new People("赵六",17,85);
	 ArrayList<People> list=new ArrayList<People>();
	 list.add(p4);list.add(p2);list.add(p3);list.add(p1);
	 System.out.println(list);
	 Collections.sort(list);//按默认排序
	 System.out.println(list);
	 Collections.sort(list, new PeopleComparator(3,1));//第一个参数代表比较字段，第二个代表升降序
	 System.out.println(list);
	 Collections.sort(list,new PeopleComparator(3,-1));//按体重排序
	 System.out.println(list);
	}
}
class PeopleComparator implements Comparator<People>{
    private int param,sort;
    public PeopleComparator(int p1,int p2){
    	this.param=p1;
    	this.sort=p2;
    }
	@Override
	public int compare(People o1, People o2) {
		if(param==1)return o1.getAge()>o2.getAge()?sort:-sort;
		else if(param==2)return o1.getWeight()>o2.getWeight()?sort:-sort;
		else return o1.getName().compareTo(o2.getName())>0?sort:-sort;
	}
}

class People implements Comparable<People>{
	private String name;
	private int age;
	private double weight;
	
	//实体类的构造方法和Getters及Setters方法，可以自动生成
	@Override
	public int compareTo(People o) {
		return this.age>o.age?1:-1;
	}
	
	
	
	
	public People(String name, int age, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
	}	

	@Override
	public String toString() {
		return name + "\t" + age + "\t" + weight;
	}

	public People() {
		super();
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}



	

	
}