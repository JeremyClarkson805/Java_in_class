package jieKou;

public class test {
    public static void main(String[] args) {
        JK ec = new EC();//新建快递公司收费规则类ec  如果要调整快递费的计算方式，只需要按规则重建一个JK接口的类即可
        EB eb = new EB("京东",ec);
        eb.pay("手机", 1000, 1, 5);
        eb.confirm("北京市海淀区", "张三", "13888888888");
    }
}
