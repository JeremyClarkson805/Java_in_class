package lwl_demo.AI22.src.cn.gd.xh;

import java.util.LinkedList;

public class Test4 {

	public static void main(String[] args) {
//		Node n1=new Node("01",90);//用Node类创建了一个对象n1
//		Node n2=new Node("20",95);
//		Node n3=new Node();
//		//...
//		n3.setNum("14");
//		n3.setScore(80);
//		n1.print();
//		n2.print();
//		n3.print();
		//创建一个动态链表，有三个节点，循环输出
		LinkedList<Node> list=new LinkedList<Node>();
		//<Node>代表这个链表只能放Node类型的对象，这是指定泛型
		list.add(new Node("001",70));
		list.add(new Node("002",80));
		list.add(new Node("003",90));
		
		list.forEach(e->{ //each循环专门用在集合类型中
			e.print();
			}
		);
		//也可以用传统的for循环
		for(int i=0;i<list.size();i++){
			list.get(i).print();
		}
	}
}
