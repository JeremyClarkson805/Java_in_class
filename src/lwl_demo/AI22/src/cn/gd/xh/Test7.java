package lwl_demo.AI22.src.cn.gd.xh;

public class Test7 {

	public static void main(String[] args) throws InterruptedException {
		double s=0;
		long start=System.currentTimeMillis();
		final int N=10;//线程数
		long tasks=500000000;//总量
		long num=tasks/N;//每个线程要完成的数量 
		Worker[] workers=new Worker[N];
		for(int i=0;i<N;i++){
			workers[i]=new Worker(num*i+1,num*(i+1));
		}
		for(int i=0;i<N;i++)workers[i].start();//开始干活
		for(int i=0;i<N;i++)workers[i].join();//等大家都干完活
		for(int i=0;i<N;i++)s+=workers[i].sum;
		long end=System.currentTimeMillis();
		System.out.println(s*4);
		System.out.println(end-start);

	}

}
class Worker extends Thread{//Thread线程类，凡是继续了它的类，其中的run方法都是独立可运行的
	long from,to;
	double sum=0d;
	public Worker(long from,long to){//通过构造方法
		this.from=from;
		this.to=to;
	}
	@Override
	public void run() {
		super.run();
		for(long n=from;n<=to;n++){
			sum=sum+Math.pow(-1, n-1)/(2.0*n-1);
		}
	}
	
}

