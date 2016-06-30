import java.util.*;
/**
 * ��
 * @author wangjxy
 * */
public class Cluster{
	/*���ų�ʼ��Ϊ0*/
	private static Integer sid = 1;
	/*���ţ���sid��������*/
	private Integer id;
	/*���ж��󼯺�*/
    private Set<Point> points = new HashSet<Point>();
    /*������*/
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
     * �������ĵ�
     * */
    /*public void calculateMean(){
    	int dim = this.meanPlace.length;
    	int numOfPoints = points.size();
    	�������ά���ϵ����ݺͣ���ÿ�����ݵ�����ĵ�Ϊ��λ
    	for(int j=0;j<numOfPoints;j++){
    		double[] pMean = points.get(j).getMean();
    		for(int i=0;i<dim;i++){
    			meanPlace[i]+= pMean[i];
    		}
		}
    	��ά���ϵ����ݺͳ�������������ȡƽ��ֵ
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