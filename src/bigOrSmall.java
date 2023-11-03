import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class bigOrSmall {
    public static void main(String[] args) throws InterruptedException {
        int num = new Random().nextInt(201);//生成a~b(包含b)之间的随机数，可使用 .nextInt(b-a+1)+a
//        System.out.println(num);
        System.out.println("让我们来玩个游戏吧\n猜一个(0,200]之间的数，你只有五次机会噢~");
        for (int i = 0; i < 5; i++) {
            int input_num = getNum();
            if (isEqual(num, input_num)) {//猜对了
                System.out.println("超！你个叼毛运气这么好");
            }
            if (!isEqual(num, input_num)) {//猜错了
                if (input_num > num) {
                    System.out.println("大啦! 傻b~~~ 你他妈只有" + (4 - i) + "次机会啦\n");
                }
                if (input_num < num && input_num != -1) {
                    System.out.println("小啦! 傻b~~~ 你他妈只有" + (4 - i) + "次机会啦\n");
                }
                if (input_num == -1) {
                    System.out.println("傻b~~~ 你他妈只有" + (4 - i) + "次机会啦\n");
                }
            }
            if (i == 4) {
                System.out.println("哈哈哈哈 再见啦 滚去开机把！！！");
                for (int j = 0; j < 5; j++) {
                    System.out.println("还有" + (5 - j) + "秒关机");
                    Thread.sleep(1000);
                }
                System.out.println("哈哈哈哈哈哈哈！");
                shutdown();
            }
        }
    }

    public static boolean isEqual(int raw_num, int input_num) {
        return raw_num == input_num;
    }

    public static int getNum() {
        Scanner sc = new Scanner(System.in);
        int input_num = 909;
        System.out.print("请输入一个数字:");
        try {
            input_num = sc.nextInt();
        }
        catch (Exception e) {
            System.out.println("超！你个吊毛还不好好输入 你少了一次机会啦");
        }
        return (input_num != 909 ? input_num : -1);
    }

    public static void shutdown() {
        try {
            Runtime.getRuntime().exec("shutdown /s /t  2");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

