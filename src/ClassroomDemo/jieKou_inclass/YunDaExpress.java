package ClassroomDemo.jieKou_inclass;

public class YunDaExpress implements Express{

    @Override
    public double calculateFee(double weight, double distance) {
        return weight*9+distance*0.6;
    }
}
