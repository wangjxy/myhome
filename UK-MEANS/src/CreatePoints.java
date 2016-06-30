import java.util.*;
import java.util.concurrent.TimeUnit;
public class CreatePoints {
	private static int[][] xlist = new int[20][];
	private static int[][] ylist = new int[20][];
    public static void main(String args[]){
    	Random random = new Random();
    	System.out.println("plot(0,0,xlim=c(0,1000),ylim=c(0,1000))");
    	for(int i=0;i<20;i++){
    		int xs = random.nextInt(800);
    		int ys = random.nextInt(800);
    		int xDiff = random.nextInt(150)+50;
    		int yDiff= random.nextInt(150)+50;
    		cOnePoint(xs,xs+xDiff,ys,ys+yDiff,i+1);
    	}
    	//..............
    	System.out.println("=================================");
    	for(int i=0;i<xlist.length;i++){
    		System.out.print("oList["+i+"] = new double[][]{");
    		int[] x = xlist[i];
    		int[] y = ylist[i];
    		for(int j=0;j<x.length;j++){
    			System.out.print("{"+x[j]);
    			System.out.print(","+y[j]+"}");
    			if(j!=x.length-1)
    				System.out.print(",");
    		}
    		System.out.println("};");
    	}
    }
    //根据X,Y的范围生成样本点
    public static void cOnePoint(int xs,int xe,int ys,int ye,int id){
    	Random random = new Random();
    	int[] x = new int[15];
    	int[] y = new int[15];
    	for(int i=0;i<x.length;i++){
    		x[i] = random.nextInt(xe-xs)+xs;
    		try {
				TimeUnit.MILLISECONDS.sleep(35);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		y[i] = random.nextInt(ye-ys)+ys;  
    		try {
				TimeUnit.MILLISECONDS.sleep(35);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	xlist[id-1] = x;
    	ylist[id-1] = y;
    	System.out.print("points(c(");
    	for(int i=0;i<x.length;i++){
    		System.out.print(x[i]);
    		if(i!=x.length-1)
    			System.out.print(",");
    	}
    	System.out.print("),");
    	System.out.print("c(");
    	for(int i=0;i<y.length;i++){
    		System.out.print(y[i]);
    		if(i!=y.length-1)
    			System.out.print(",");
    	}
    	String hexStr = Integer.toHexString(random.nextInt(16777215));
    	if(hexStr.length()<6){
    		int diff = 6-hexStr.length();
    		for(int i=1;i<=diff;i++){
    			hexStr="0"+hexStr;
    		}
    	}
    	char ch = (char)(id+64);
    	System.out.println("),col=\"#"+hexStr+"\",pch=\""+ch+"\")");
    }
}
