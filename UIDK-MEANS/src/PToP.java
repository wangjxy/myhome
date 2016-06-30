import java.lang.*;
import java.util.*;
public class PToP implements Comparable<PToP>{
    private Point p1 = null;
    private Point p2 = null;
    private Double min;
    private Double max;
    private double shi;
    public PToP(Point p1,Point p2){
    	this.p1 = p1;
    	this.p2 = p2;
    	/*start����������������������С����*/
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
    	/*end����������������������С����*/
    	    	
    	/*start�������䷶Χ������������ϵ��*/
    	Double[][] range1 = p1.getRange();
    	Double[][] range2 = p2.getRange();
    	double resultMin=0;
    	double resultMax=0;
    	for(int i=0;i<range1.length;i++){
		   double tempMin = 0;
		   double tempMax = 0;
		   if(this.betweenRange(range2[i][0]-range2[i][1], range2[i][0]+range2[i][1], range1[i][0]-range1[i][1])||this.betweenRange(range1[i][0]-range1[i][1], range1[i][0]+range1[i][1], range2[i][0]-range2[i][1])){
		       tempMin = 0;	   
		   }else{
			   tempMin = Math.min(Math.abs(range1[i][0]-range2[i][1]),Math.abs(range2[i][0]-range1[i][1]));
		   }
		   tempMax = Math.max(Math.abs(range1[i][0]-range2[i][1]),Math.abs(range2[i][0]-range1[i][1]));
		   resultMin+=tempMin*tempMin;
		   resultMax+=tempMax*tempMax;		
    	}
    	this.min = Math.sqrt(resultMin);
    	this.max = Math.sqrt(resultMax);
    	//System.out.println("min==:"+min);
    	//System.out.println("max==:"+max);
//    	if((this.p1.getId().equals("12")&&this.p2.getId().equals("2"))||(this.p1.getId().equals("12")&&this.p2.getId().equals("13"))){
//		   	System.out.println("a+b:"+a+"-"+b);
//    	}
    		
    	/*end�������䷶Χ������������ϵ��*/
    	
    	/*��0-1�����׼��*/
    	//double factor = this.getFactor(maxDis);
  //  	System.out.println("min:"+minDis+";max:"+maxDis+";factor:"+factor);//test.............
    //	minDis = minDis*factor;
    //	maxDis = maxDis*factor;
    	/*����a,b,c*/
    	
    }
    public Double getMin(){
    	return this.min;
    }
    public Double getMax(){
    	return this.max;
    }
    public void setShi(double absMax){
    	this.shi = 0.5*(this.min+this.max);
//    	if((this.p1.getId().equals("12")&&this.p2.getId().equals("2"))||(this.p1.getId().equals("12")&&this.p2.getId().equals("13"))){
//    		System.out.println("absMax:"+absMax+"  shi:"+this.shi);
//    	}
    }
    public boolean betweenRange(double min,double max,double value){
    	if(value>=min&&value<=max)
    		return true;
    	else
    	    return false;
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