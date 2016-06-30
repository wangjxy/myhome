import java.util.Iterator;
import java.util.Set;
public class PToCluster {
    private Point point;
    private Cluster cluster;
    private double b;
//    private Double minDis;
//    private Double maxDis;
    private double shi;
    public PToCluster(Point p,Cluster cluster){
    	this.point = p;
    	this.cluster = cluster;  
    	this.setShi();
    }
	public Point getPoint() {
		return point;
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
		double sum = 0;
		while(itor.hasNext()){
			Point denP = itor.next();
			if(this.point!=denP){
				PToP pToP = this.point.getPtpMap().get(denP);
				sum+=pToP.getShi();
			}
		}
		this.shi = sum/points.size();
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
