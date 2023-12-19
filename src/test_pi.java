public class test_pi {
    static void single(long num){
        double sum = 0;
        long start = System.currentTimeMillis();
        for (long n = 1;n <= num;n++){
            sum += Math.pow(-1,n-1)/(2*n-1);
        }
        System.out.println(sum*4);
        long end = System.currentTimeMillis();
        System.out.println("单线程消耗时间:" + (end-start) + "毫秒");
    }

    static void threading_1(long num){
        try {
            long start = System.currentTimeMillis();
            Worker w1 = new Worker(1,num/2);
            Worker w2 = new Worker((num/2)+1,num);
            double sum = 0;
            w1.start();
            w2.start();
            w1.join();
            w2.join();
            sum = w1.sum+ w2.sum;
            System.out.println(sum*4);
            long end = System.currentTimeMillis();
            System.out.println("多线程消耗时间:"+(end-start));
        } catch (InterruptedException e) {
            System.out.println("出错了...");
        }
    }

    static void threading_2(long num){
        int N = 20;//N为线程数
        double sum = 0;
        long start = System.currentTimeMillis();
        Worker []workers = new Worker[N];
        for (int i = 0; i < N; i++) {
            workers[i] = new Worker(i*(num/N)+1,(i+1)*(num/N));
            workers[i].start();
        }
        try {
            for (int i = 0; i < N; i++) {
                workers[i].join();
                sum += workers[i].sum;
            }
            System.out.println(sum*4);
        } catch (InterruptedException e) {
            System.out.println("计算出错");
        }finally {
            long end = System.currentTimeMillis();
            System.out.println(N+"线程消耗时间:"+(end-start));
        }

    }
    public static void main(String[] args) {
        long num = 50000000;
        single(num);
        threading_1(num);
        threading_2(num);
    }
}

class Worker extends Thread{
    long start,end;
    double sum = 0;
    Worker(long start,long end){
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        super.run();
        for (long n = start;n <= end;n++){
            sum += Math.pow(-1,n-1)/(2*n-1);
        }
    }
}
