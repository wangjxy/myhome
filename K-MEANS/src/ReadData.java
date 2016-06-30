import java.io.*;
import java.lang.*;
import java.util.*;
public class ReadData {
    public static void main(String args[]) throws Exception{
    	File file = new File("D:"+File.separator+"iris.txt");
    	File outFile = new File("D:"+File.separator+"result.txt");
    	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    	PrintWriter pw = new PrintWriter(outFile);
    	String msg = "";
    	ArrayList<double[]> al = new ArrayList<double[]>();
    	int count = 0;
    	System.out.println("plot(0,0,xlim=c(0,10),ylim=c(0,10))");
    	while((msg=br.readLine())!=null){
//    		count++;
    		String[] strData = msg.split(",");
    		double num = Double.valueOf(strData[0]);
    		Random rd = new Random();
    		int max = (int)(num*0.2*100);
    		int temp = rd.nextInt(max)+1;
    		double b = (double)temp/100;
    		pw.print(num+",");
    		pw.print(0+",");
    		num = Double.valueOf(strData[1]);
    		max = (int)(num*0.2*100);
    		temp = rd.nextInt(max)+1;
    		b = (double)temp/100;
    		pw.print(num+",");
    		pw.print(0+",");
    		num = Double.valueOf(strData[2]);
    		max = (int)(num*0.2*100);
    		temp = rd.nextInt(max)+1;
    		b = (double)temp/100;
    		pw.print(num+",");
    		pw.print(0+",");
    		num = Double.valueOf(strData[3]);
    		max = (int)(num*0.2*100);
    		temp = rd.nextInt(max)+1;
    		b = (double)temp/100;
    		pw.print(num+",");
    		pw.println(0);
    		pw.flush();
//    		System.out.print("points(c(");
//    		System.out.print(strData[0]);
//    		System.out.print("),c(");
//    		System.out.print(strData[3]);
//    		System.out.print("),col=\"");
//    		if(count<=50)
//    			System.out.print("red\",pch=1)");
//    		else if(count<=100)
//    			System.out.print("green\",pch=1)");
//    		else
//    			System.out.print("blue\",pch=1)");
//    		System.out.println();
    	}
    	pw.close();
    	
    	
    
    }
}
