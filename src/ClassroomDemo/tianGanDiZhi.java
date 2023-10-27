package ClassroomDemo;

public class tianGanDiZhi {
    public static void main(String[] args) {
        String [] tianGan = {"甲","乙","丙","丁","戊","己","庚","辛","壬","癸"};
        String [] diZhi = {"子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥"};
        for (int i = 0;i<60;i++){
//            String t = "<div style = \"font-size: 35pt;color:rgba(255,140,92);position:absolute;left: 200px;top: 300px\"> \"你好\"</div>";
            int r,g,b,top,size,left;
            r = (int)(Math.random()*256);
            g = (int)(Math.random()*256);
            b = (int)(Math.random()*256);
            top = (int)(Math.random()*600);
            left = (int)(Math.random()*1600);
            size = (int)(Math.random()*(72-9)+8);
            String s = tianGan[i%10] + diZhi[i%12];
            String t = "<div style = \"font-size: " + size +"pt;color:rgba(" + r + ","+ g + "," + b + ",1 );position:absolute;left: " + left +"px;top: " + top +"px\"> " + s +"</div>";
            System.out.println(t);
//            if (i%6==0 && i!= 0) {System.out.println("");}
//            System.out.print(tianGan[i%10] + diZhi[i%12] + " ");
        }
    }
}
