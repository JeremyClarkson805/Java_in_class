/*
一个实体类，先声明成员变量，接下来做三件事：
    1.自动生成setters和getters方法
    2.自动生成全参数和无参数构造方法
    3.自定义方法

构造方法三特点：
    1.名字与类名相同
    2.无返回值
    3。在被new出来时执行，无需手动调用
 */

import java.util.LinkedList;

//下面这些方法都是定义了两个私有变量以后让他自动生成的，不用手写
public class Node {
    private String num;
    private float score;

    public Node(String num, float score) {
        this.num = num;
        this.score = score;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void print(){
        System.out.println(this.num + " " + this.score);
    }

}

class test_1{
    public static void main(String[] args) {
        //创建一个动态链表，有三个节点，循环输出
        LinkedList<Node> list = new LinkedList<Node>();  //<Node>代表这个链表只能放Node类型的对象，这是指定泛型
        list.add(new Node("001",70));
        list.add(new Node("002",75));
        list.add(new Node("003",80));
        list.forEach(e->{e.print();});     //each循环专门用在集合类型中
    }
}
