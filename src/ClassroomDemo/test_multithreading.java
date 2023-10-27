package ClassroomDemo;

public class test_multithreading {
    static void test_1()
    {
        double s = 0;
        long start = System.currentTimeMillis();
        for (long n = 1;n <= 50000000;n++){
            s += Math.pow(-1,n-1)/(2*n-1);
        }
        long end = System.currentTimeMillis();
        System.out.println(s*4);
        System.out.println(end-start);
    }

    static void test_2() throws InterruptedException {//五个线程
        double s = 0;
        long start = System.currentTimeMillis();
        Worker w1 = new Worker(1,10000000);
        Worker w2 = new Worker(10000001,20000000);
        Worker w3 = new Worker(20000001,30000000);
        Worker w4 = new Worker(30000001,40000000);
        Worker w5 = new Worker(40000001,50000000);
        w1.start();w2.start();w3.start();w4.start();w5.start();//开始干活
        w1.join();w2.join();w3.join();w4.join();w5.join();//等大家都干完
        s = w1.sum+w2.sum+w3.sum+w4.sum+w5.sum;
        long end = System.currentTimeMillis();
        System.out.println(s*4);
        System.out.println(end-start);
    }

    static void test_3() throws InterruptedException {
        double s = 0;
        long start = System.currentTimeMillis();
        final int N = 20;//线程数
        long tasks = 500000000;//总量
        long num = tasks/N;//每个线程要完成的数量
        Worker [] workers = new Worker[N];
        for (int i = 0;i<N;i++){
            workers[i] = new Worker(num*i+1,num*(i+1));
        }
        for (int i = 0;i<N;i++)workers[i].start();
        for (int i = 0;i<N;i++)workers[i].join();
        for (int i = 0;i<N;i++)s += workers[i].sum;
        long end = System.currentTimeMillis();
        System.out.println(s*4);
        System.out.println(end-start);
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println("单线程:");
        test_1();
        System.out.println("分五个线程完成:");
        test_2();
        System.out.println("二十个线程计算五亿项:");
        test_3();
    }
}


class Worker extends Thread{//Thread线程类，凡是继承了他的类，其中的run方法都是独立可运行的
    long from,to;
    double sum;
    public Worker(long from,long to){
        this.from = from;
        this.to = to;
    }

    //是自动生成的run方法
    @Override
    public void run() {
        super.run();
        for (long n = from;n<=to;n++){
            sum += Math.pow(-1,n-1)/(2*n-1);
        }
    }
}