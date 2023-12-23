package lwl_demo.AI22.src.cn.gd.xh;
public class SFExpress implements Express{
	@Override
	public double calculateFee(double weight, double distance) {
		return weight*11+distance*0.4;
	}
}
