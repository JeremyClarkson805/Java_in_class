package jieKou;
//电商平台
public class EB {
    String name;
    JK exp;
    public EB(String name,JK exp)//传入了快递公司的名字和一个 接口类型的变量(计费规则)
    {
        this.name = name;
        this.exp = exp;
    }
    void pay(String pn,double price,double w,double v)
    {
        double e = exp.calFee(w,v);//调用计费方法
        System.out.println("商品名称"+pn+",价格:"+price+"元,运费:"+e+"元,总计:"+(price+e)+"元");
    }
    void confirm(String addr,String receiver,String mobile)
    {
        int dh = exp.sendP(addr,receiver,mobile);//根据接口的约定调用发货方法
        System.out.println(name+"公司的快递发送成功,发货单号:"+dh);
        System.out.println("----------------");
    }
}
