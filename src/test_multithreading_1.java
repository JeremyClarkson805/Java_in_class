class T1 extends Thread
{
    public void run()
    {
        System.out.println("T1");
    }
}

class R1 implements Runnable
{

    @Override
    public void run() {
        System.out.println("hello world");
    }
}
public class test_multithreading_1
{
    public static void main(String[] args) {
        Runnable r1 = new R1();
        Thread t1 = new Thread(r1);//通过Runnable接口创建线程


        t1.start();
    }
}
