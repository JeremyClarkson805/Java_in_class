package ClassroomDemo.jieKou_inclass;

public interface Express {//接口，里面没有完整的方法体，只有方法头
    String name = "";
    //根据货物的重量和距离计算费用
    public double calculateFee(double weight,double distance);//接口函数，没有方法体，只能出现在接口中

}
