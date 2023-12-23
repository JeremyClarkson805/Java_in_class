package lwl_demo.AI22.src.cn.gd.xh;

public class Test11 {

	static StringBuilder sb1=new StringBuilder();
	static StringBuffer sb2=new StringBuffer();
	public static void main(String[] args) throws InterruptedException {
		MyThread m1=new MyThread("aaaa");
		MyThread m2=new MyThread("bbbb");
		MyThread m3=new MyThread("cccc");
		MyThread m4=new MyThread("dddd");
		m1.start();m2.start();m3.start();m4.start();
		m1.join();m2.join();m3.join();m4.join();
		System.out.println(sb1.toString());
	}
	
}

//多线程编程的套路：1。新建线程类，2。实现线程体中的run方法（即线程要做的事），3新建线程对象并start启动它
class MyThread extends Thread{
	String t=null;
	public MyThread(String t){
		this.t=t;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;i<t.length();i++){
		Test11.sb1.append(t.charAt(i));
		}
		
		
	}
	
	
}