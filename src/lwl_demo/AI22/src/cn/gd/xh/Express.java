package lwl_demo.AI22.src.cn.gd.xh;
public interface Express {//接口，里面没有完整的方法体，只有方法头
	String name="";
	//根据货品的重量和距离计算费用的功能
	public double calculateFee(double weight,double distance);//接口函数，没有方法体，只能出现在接口中
}