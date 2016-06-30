import java.util.Iterator;
import java.util.Set;
public class PToCluster {
    private Point point;
    private Cluster cluster;
    private double a;
    private double b;
    private Double min;
    private Double max;
//    private Double minDis;
//    private Double maxDis;
    private double shi;
    public PToCluster(Point p,Cluster cluster){
    	this.point = p;
    	this.cluster = cluster;   
    	
    	
    }
	public Point getPoint() {
		return point;
	}
	public boolean betweenRange(double min,double max,double value){
    	if(value>=min&&value<=max)
    		return true;
    	else
    	    return false;
    }
	public void setPoint(Point point) {
		this.point = point;
	}
	public Cluster getCluster() {
		return cluster;
	}
	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
	}
//	public Double getMinDis() {
//		return minDis;
//	}
//	public void setMinDis(Double minDis) {
//		this.minDis = minDis;
//	}
//	public Double getMaxDis() {
//		return maxDis;
//	}
//	public void setMaxDis(Double maxDis) {
//		this.maxDis = maxDis;
//	}
	public double getB(){
		return this.b;
	}
	public double getShi() {
		return this.shi;
	}
	/*设置对象与簇之间的势，为簇内各个对象与该对象势的平均值*/
	public void setShi() {
		Set<Point> points = this.cluster.getPoint();
		Iterator<Point> itor = points.iterator();
		double[][] temp = new double[this.point.getRange().length][2];
		while(itor.hasNext()){
			Point denP = itor.next();
			Double[][] range = denP.getRange();
			for(int i=0;i<temp.length;i++){
				temp[i][0]+=range[i][0];
				temp[i][1]+=range[i][1];
			}
		}
		for(int i=0;i<temp.length;i++){
			temp[i][0]/=points.size();
			temp[i][1]/=points.size();
		}
    	
    	
    	double resultMin=0;
    	double resultMax=0;
    	Double range1[][] = this.point.getRange();
    	for(int i=0;i<range1.length;i++){
		   double tempMin = 0;
		   double tempMax = 0;
		   if(this.betweenRange(temp[i][0]-temp[i][1], temp[i][0]+temp[i][1], range1[i][0]-range1[i][1])||this.betweenRange(range1[i][0]-range1[i][1], range1[i][0]+range1[i][1], temp[i][0]-temp[i][1])){
		       tempMin = 0;	   
		   }else{
			   tempMin = Math.min(Math.abs(range1[i][0]-temp[i][1]),Math.abs(temp[i][0]-range1[i][1]));
		   }
		   tempMax = Math.max(Math.abs(range1[i][0]-temp[i][1]),Math.abs(temp[i][0]-range1[i][1]));
		   resultMin+=tempMin*tempMin;
		   resultMax+=tempMax*tempMax;		   
    	}
    	this.min = Math.sqrt(resultMin);
    	this.max = Math.sqrt(resultMax);
		this.shi = 0.5*(this.min+this.max);
		System.out.println(this.point.getId()+"-"+this.cluster.getId()+" shi==:"+shi);
	}
//	public void setShi(double absMax) {
//		Set<Point> points = this.cluster.getPoint();
//		Iterator<Point> itor = points.iterator();
//		Double min = null;
//		Double max = null;
//		while(itor.hasNext()){
//			Point denP = itor.next();
//			if(this.point!=denP){
//				PToP pToP = this.point.getPtpMap().get(denP);
//				if(min==null || min>pToP.getMinDis())
//					min = pToP.getMinDis();
//				if(max==null || max<pToP.getMaxDis())
//					max = pToP.getMaxDis();
//			}
//		}
//		double a = min;
//		double b = max - min;
//		double c = absMax - max;
//		this.shi = a/c;
//	}
}
