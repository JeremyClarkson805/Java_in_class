abstract class Graphic{
    String name;
    public Graphic(){
        super();
    }
    public Graphic(String name){
        super();
        this.name = name;
    }
    void showMe(){
        System.out.println("我是一个图形");
    }
    abstract double getArea();
}

class Rectangle extends Graphic {
    double w, l;

    public Rectangle() {
        super();
    }

    public Rectangle(double l, double w) {
        super();
        this.l = l;
        this.w = w;
    }

    @Override
    double getArea() {
        return l * w;
    }
}

public class test_abstract {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(2.4,3.9);
        System.out.println("矩形的面积是:"+r1.getArea());
    }
}
