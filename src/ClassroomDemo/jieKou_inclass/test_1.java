package ClassroomDemo.jieKou_inclass;

class ab_c extends abstract_class{

    @Override
    void task1() {
        System.out.println("task1");
    }

    @Override
    void task2() {
        System.out.println("task2");
    }
}

public class test_1 {
//    abstract_class ac = new abstract_class();//抽象类不能直接new对象，其里面的所有抽象方法必须实现后，才能new出对象来
public static void main(String[] args) {
    abstract_class aaa = new ab_c();
    aaa.common();
    aaa.task1();
    aaa.task2();
}

}
