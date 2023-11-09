import java.math.BigDecimal;
import java.math.RoundingMode;

public class test_BigDecimal {
    public static void main(String[] args) {
        BigDecimal a =new BigDecimal(0.1);
        System.out.println("a values is:"+a);
        System.out.println("=====================");
        BigDecimal b =new BigDecimal("0.1");
        System.out.println("b values is:"+b);
        System.out.println("=====================");

        BigDecimal sum =new BigDecimal(0);
        System.out.println(sum);

        for (long n = 1;n <= 500000000;n++){
            BigDecimal num_1 = BigDecimal.valueOf(Math.pow(-1, n - 1));
            BigDecimal num_2 = BigDecimal.valueOf(2 * n - 1);
            BigDecimal num_3 = num_1.divide(num_2, 100, RoundingMode.HALF_UP);
            num_3 = num_3.multiply(BigDecimal.valueOf(4));
//            System.out.println(num_3);
            sum = sum.add(num_3);
        }
        System.out.println(sum);

    }
}

//3.14159263358979323846264538327950288419616939937510582219494459230781 36362862089986381390253421161784
//3.14159265358979323846264338327950288419716939937510582097494459230781 640628620899862803482534211 70679821480865132823
//3.14159265158979323846264338527950288419716938937510582097494471430781 640628620622862803482534221 52160