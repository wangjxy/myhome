import java.util.*;
/**
 * 簇
 * @author wangjxy
 * */
public class Cluster{
	/*类标号初始化为0*/
	private static Integer sid = 1;
	/*类标号，由sid递增而来*/
	private Integer id;
	/*簇中对象集合*/
    private Set<Point> points = new HashSet<Point>();
    /*簇中心*/
 //   private double[] meanPlace = null;
    
    public Cluster(){
    	id=sid++;
//    	this.meanPlace = new double[dim];
    }
    public Cluster(Point point){
    	id=sid++;
//    	this.meanPlace = new double[dim];
    	points.add(point);
    }
    /**
     * 计算中心点
     * */
    /*public void calculateMean(){
    	int dim = this.meanPlace.length;
    	int numOfPoints = points.size();
    	求出各个维度上的数据和，以每个数据点的中心点为单位
    	for(int j=0;j<numOfPoints;j++){
    		double[] pMean = points.get(j).getMean();
    		for(int i=0;i<dim;i++){
    			meanPlace[i]+= pMean[i];
    		}
		}
    	各维度上的数据和除以数据数量，取平均值
    	for(int i=0;i<dim;i++){
    		meanPlace[i] = meanPlace[i]/numOfPoints;
    	}    	
    }
    public double[] getMeanPlace(){
    	return meanPlace;
    }*/
    public void addPoint(Point point){
    	System.out.println("c"+this.id+" adding a point...");
    	this.points.add(point);
    }
    public Set<Point> getPoint(){
    	return this.points;
    }
    public Integer getId(){
    	return this.id;
    }
    public void showPoints(){
    	Iterator<Point> itor = this.points.iterator();
    	while(itor.hasNext()){
    		int id = Integer.valueOf(itor.next().getId());
    		char ch = (char)('A'+(id-1));
    		System.out.print(ch+" ");
//    		System.out.print(" "+id);
    	}
    }
    public Point[] getArrPoints(){
    	Point[] arrPoints = new Point[points.size()];
    	Iterator<Point> itr = points.iterator();
    	int cur = 0;
    	while(itr.hasNext()){
    		arrPoints[cur++] = itr.next();
    	}
    	return arrPoints;
    }
    
    @Override
    public boolean equals(Object o){
    	if(o instanceof Cluster && this==o && this.id==((Cluster)o).id)
    		return true;
    	else
    		return false;
    }
    @Override
    public int hashCode(){
    	return super.hashCode();
    }
}