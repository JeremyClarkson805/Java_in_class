package ClassroomDemo.jieKou_inclass;

public class Saller {
    public static void main(String[] args) {
        Express e = new SFExpress();//接口不能直接new对象，必须是实现这个接口的类才可以
        System.out.println(e.calculateFee(4,55));
        e = new YunDaExpress();
        System.out.println(e.calculateFee(4,55));
    }
}
