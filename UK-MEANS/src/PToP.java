import java.lang.*;
import java.util.*;
public class PToP implements Comparable<PToP>{
    private Point p1 = null;
    private Point p2 = null;
    private Double a;
    private Double b;
    private double shi;
    public PToP(Point p1,Point p2){
    	this.p1 = p1;
    	this.p2 = p2;
    	/*start根据样本点计算对象间最大最小距离*/
    	/*double[][] place1 = p1.getPlace();
    	double[][] place2 = p2.getPlace();
    	for(int i=0;i<place1.length;i++){
    		for(int j=0;j<place2.length;j++){
    			double tempD = this.getDis(place1[i], place2[j]);
    			if(minDis==null || minDis>tempD)
    				minDis = tempD;
    			if(maxDis==null || maxDis<tempD)
    				maxDis = tempD;
    		}
    	}*/
    	/*end根据样本点计算对象间最大最小距离*/
    	
    	
    	
    	/*start根据区间范围来计算对象间联系数*/
    	Double[][] range1 = p1.getRange();
    	Double[][] range2 = p2.getRange();
    	double resultA=0;
    	double resultB=0;
    	for(int i=0;i<range1.length;i++){
    	   double tempA = Math.abs(range1[i][0]-range2[i][0]);
  //  	   System.out.println(range1[i][0]+"-"+range2[i][0]+":"+tempA);
    	   double tempB = range1[i][1]+range2[i][1];
 //   	   System.out.println(range1[i][1]+"+"+range2[i][1]+":"+tempB);
    	   resultA += tempA*tempA;
    	   //resultB1 += tempA*tempB;
    	   resultB += tempB*tempB;
    	}
    	this.a = Math.sqrt(resultA);
    	this.b = Math.sqrt(resultB);
//    	if((this.p1.getId().equals("12")&&this.p2.getId().equals("2"))||(this.p1.getId().equals("12")&&this.p2.getId().equals("13"))){
//		   	System.out.println("a+b:"+a+"-"+b);
//    	}
    		
    	/*end根据区间范围来计算对象间联系数*/
    	
    	/*向0-1区间标准化*/
    	//double factor = this.getFactor(maxDis);
  //  	System.out.println("min:"+minDis+";max:"+maxDis+";factor:"+factor);//test.............
    //	minDis = minDis*factor;
    //	maxDis = maxDis*factor;
    	/*计算a,b,c*/
    	
    }
    public Double getA(){
    	return this.a;
    }
    public Double getB(){
    	return this.b;
    }
    public void setShi(double absMax){
    	double c = absMax-(this.a+this.b);
    	this.shi = a/c;
//    	if((this.p1.getId().equals("12")&&this.p2.getId().equals("2"))||(this.p1.getId().equals("12")&&this.p2.getId().equals("13"))){
//    		System.out.println("absMax:"+absMax+"  shi:"+this.shi);
//    	}
    }
    public double getShi(){
    	return this.shi;
    }
//    private double getDis(double[] pl1,double[] pl2){
//    	double tempSum = 0;
//    	for(int d=0;d<pl1.length;d++){
//    		tempSum += (pl1[d]-pl2[d])*(pl1[d]-pl2[d]);
//    	}
//    	return Math.sqrt(tempSum);
//    }
//    private double getFactor(double maxDis){
//    	int Int = (int)maxDis;
//    	String maxStr = String.valueOf(Int);
//    	int length = maxStr.length();
//    	return Math.pow(0.1, length);
//    }
	public Point getP1() {
		return p1;
	}
	public Point getP2() {
		return p2;
	}
	
//	public Double getMinDis() {
//		return minDis;
//	}
//	public Double getMaxDis() {
//		return maxDis;
//	}
	@Override
	public int compareTo(PToP op) {
		if(this.shi>op.getShi())
			return 1;
		else if(this.shi==op.getShi())
			return 0;
		else
		    return -1;
	}
}