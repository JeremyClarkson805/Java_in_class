package ClassroomDemo;

public class BuilderAndBuffer {
    static StringBuilder sb1 = new StringBuilder();
    static StringBuffer sb2 = new StringBuffer();

    public static void main(String[] args) {

    }
}

class MyThread extends Thread{
    String t = null;
    public MyThread(String t){
        this.t = t;
    }
    @Override
    public void run() {
        super.run();
        for (int i = 0;i<t.length();i++){
//            BuilderAndBuffer.sb1.append();
        }
    }
}
