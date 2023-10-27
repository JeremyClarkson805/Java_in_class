package BookDemo;

import java.util.InputMismatchException;
import java.util.Scanner;

class test_2
{
    void way_1(){                                  //带异常捕获的
        Scanner sc = new Scanner(System.in);
        float a = 10,b;
        try {
            System.out.print("请输入除数b = ");
            b = sc.nextInt();
            System.out.println("a/b的值是:" + a/b);
            System.out.println("程序正常结束");
        } catch (ArithmeticException e) {                //算术条件异常，如整数除0等
            System.out.println("程序出现异常，变量b不能为零");
        } catch (InputMismatchException e){              //
            System.out.println("程序出现异常，数据输入格式不对");
        } finally {
            System.out.println("无论是否异常都执行的部分");
        }
    }

    void way_2(){                                 //不带异常捕获的
        Scanner sc = new Scanner(System.in);
        float a = 10,b;
        System.out.print("请输入除数b = ");
        b = sc.nextInt();
        System.out.println("a/b的值是:" + a/b);
    }
}

public class P45 {
    public static void main(String[] args) {
        test_2 t_1 = new test_2();
        System.out.println("带异常捕获的");
        t_1.way_1();
        System.out.println("不带异常捕获的");
        t_1.way_2();
    }
}