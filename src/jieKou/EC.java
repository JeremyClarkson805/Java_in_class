package jieKou;

public class EC implements JK{//实现接口的类
    int n = 0;//初始化单号

    @Override
    public double calFee(double w, double v) {
        if (w<1) return 8;
        else if (w<5) return 8+2*(w-1);
        return 16+(w-5)*3;
    }

    @Override
    public int sendP(String addr, String receiver, String mobile) {
        System.out.println("收件地址:"+addr);
        System.out.println("收件人:"+receiver);
        System.out.println("联系电话:"+mobile);
        return ++n;
    }
}
