package BookDemo;

class Seller
{
    String CompanyName;
    void sell(Buyer b) {System.out.println(this.CompanyName+"向"+b.CompanyName+"出售了商品");}
}

class Buyer
{
    String CompanyName;
    void buy(Seller s) {System.out.println(this.CompanyName+"向"+s.CompanyName+"采购了商品");}
}

public class P10
{
    public static void main(String[] args)
    {
        Seller s1 = new Seller();
        s1.CompanyName = "A公司";
        Buyer b1 = new Buyer();
        b1.CompanyName = "B公司";
        s1.sell(b1);
        b1.buy(s1);
    }
}
