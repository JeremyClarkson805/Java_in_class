package BookDemo;

public class P47 {
}


class Person{
    String name;
    int age;
    private double weight;
    static int n;
    void walk(){

    }
    void sleep(){

    }
    public Person(){
        super();
        n++;
    }
    static int getCount(){return n;}
    void say(){
        String name = "ABC";
        System.out.println(age + "岁的" + this.name + "会说" + name +".");
    }

}