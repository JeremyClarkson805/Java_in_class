package lwl_demo.AI22.src.cn.gd.xh;

public class Test3 {

	public static String baby() {
		String result="";
		String[] tiangan={"甲","乙","丙","丁","戊","己","庚","辛","壬","癸"};
		String[] dizhi=new String[12];//12是总个数
		dizhi[0]="子";dizhi[1]="丑";dizhi[2]="寅";dizhi[3]="卯";dizhi[4]="辰";dizhi[5]="巳";
		dizhi[6]="午";dizhi[7]="未";dizhi[8]="申";dizhi[9]="酉";dizhi[10]="戌";dizhi[11]="亥";//11是最大下标
		for(int i=0;i<60;i++){
			int r,g,b,top,left,size;	
			r=(int)(Math.random()*256);//随机产生0-256之间的整数，代表红色
			g=(int)(Math.random()*256);	
			b=(int)(Math.random()*256);	
			top=(int)(Math.random()*700);//代表距顶位置
			left=(int)(Math.random()*1700);//代表距左位置
			String s=tiangan[i%10]+dizhi[i%12];//天干+地支
			size=(int)(Math.random()*(72-8+1)+8);
			String t="<div style=\"font-size:"+size+"pt;color:rgba("+r+","+g+","+b+",0.9);position:absolute;left:"+left+"px;top:"+top+"px;\">"+s+"</div>";
			result=result+t;
		}
		return result;
	}

}
