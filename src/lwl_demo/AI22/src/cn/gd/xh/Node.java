package lwl_demo.AI22.src.cn.gd.xh;

public class Node {//定义一个节点类
	private String num;//学号
	private float score;//成绩

	public Node(String num, float score) {//全参数构造方法
		super();
		this.num = num;
		this.score = score;
	}

	public Node() {//无参数构造方法
		super();
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	
	
	public void print(){
		System.out.println(this.num+"："+this.score);
	}
}
