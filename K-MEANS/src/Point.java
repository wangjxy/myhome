//import java.util.*;
//import java.math.*;
///**
// * 对象类
// * @author wangjxy
// * */
//public class Point{
//	private static BigInteger sid = new BigInteger("0");
//	private BigInteger id = null;
//	/*对象的样本点集合*/
//    private double[][] place;
//    /*所属的簇*/
//    private Cluster cluster = null;
//    
//    /*当前对象到其他对象的所有距离中最大的距离*/
//    private double curAbsMax=0;
//    
//    /*当前对象与其他对象间的最大最小距离*/
//    private Map<Point,double[]> reMap = new HashMap<Point,double[]>();
//    /*当前对象与其他对象的点对点对象*/
//    private Map<Point,PToP> ptpMap = new HashMap<Point,PToP>();
//    /*当前对象到其他对象的势*/
//    private Map<Point,Double> ShiMap = new HashMap<Point,Double>();
//    
//    /*对象的中心点*/
////    private double[] mean = null;
//    
//    public String getId(){
//    	return this.id.toString();
//    }
//    public Point(int dim,int num){//维度和一个对象样本点数量
//    	this.place = new double[num][dim];
//    	id = sid.add(new BigInteger("1"));
//    	sid = id;
//    }
//    public Map<Point, PToP> getPtpMap() {
//		return ptpMap;
//	}
//	public void setPlace(double[][] data){
//    	this.place = data;
//    }
//    public double[][] getPlace(){
//    	return this.place;
//    }
//    public Cluster getCluster(){
//    	return this.cluster;
//    }
//    public void setCluster(Cluster cluster){
//    	this.cluster = cluster;
//    }
//    /*添加当前对象与参数对象间的最大最小距离信息入Map*/
//    public void addPToPDis(Point p){
//    	PToP tempO = new PToP(this,p);
//    	/*把点对点对象放入map中*/
//    	this.ptpMap.put(p, tempO);
//    	double min = tempO.getMinDis();
//    	double max = tempO.getMaxDis();
//    	this.reMap.put(p, new double[]{min,max});
//    	/*记录对象到其他对象的最大距离*/
//    	if(max>this.curAbsMax)
//    		this.curAbsMax = max;
//    }
//    public Map<Point,Double> getShiMap(){
//    	return this.ShiMap;
//    }
//    
//    /*初始化势Map*/
//    public void initShiMap(double absMax){
//    	Set<Point> pSet = ptpMap.keySet();
//    	Iterator<Point> itor = pSet.iterator();
//    	while(itor.hasNext()){
//    		Point toP = itor.next();
//    		PToP temp = this.ptpMap.get(toP);
//    		temp.setShi(absMax);
//    		double shi = temp.getShi();
//    		this.ShiMap.put(toP, shi);
//    	}
//    }
//    public double getCurAbsMax(){
//    	return this.curAbsMax;
//    }
//    
//    
//    @Override
//    public boolean equals(Object o){
//    	if(o instanceof Point && this==o)
//    		return true;
//    	else
//    		return false;
//    }
//    @Override
//    public int hashCode(){
//    	return super.hashCode();
//    }
//}

import java.util.*;
import java.math.*;
/**
 * 对象类
 * @author wangjxy
 * */
public class Point{
	private static BigInteger sid = new BigInteger("0");
	private BigInteger id = null;
	/*对象的区间范围:每个维度用一个联系数表示u=a+bi,a表示区域中点；range[][0]表示a,range[][1]表示b*/
    private Double[] range = null;
    /*所属的簇*/
    private Cluster cluster = null;
    
    /*当前对象到其他对象的所有距离中最大的距离*/
    
    /*当前对象与其他对象间的最大最小距离*/
//    private Map<Point,double[]> reMap = new HashMap<Point,double[]>();
    /*当前对象与其他对象的点对点对象*/
    private Map<Point,PToP> ptpMap = new HashMap<Point,PToP>();
    /*当前对象到其他对象的势*/
    private Map<Point,Double> ShiMap = new HashMap<Point,Double>();
    /*当前对象到其他簇的势*/
//    private Map<Cluster,Double> CShiMap = new HashMap<Cluster,Double>();
    /*当前对象到其他簇的点对簇对象*/
    private Map<Cluster,PToCluster> ptcMap = new HashMap<Cluster,PToCluster>();
    
    
    /*对象的中心点*/
//    private double[] mean = null;
    
    public String getId(){
    	return this.id.toString();
    }
    public Point(){
    	id = sid.add(new BigInteger("1"));
    	sid = id;
    }
    public Point(int dim){//维度和一个对象样本点数量
    	this.range = new Double[dim];
    	id = sid.add(new BigInteger("1"));
    	sid = id;
    }
    public Map<Point, PToP> getPtpMap() {
		return ptpMap;
	}
	public void setRange(Double[] range){
    	this.range = range;
    }
    public Double[] getRange(){
    	return this.range;
    }
    public Cluster getCluster(){
    	return this.cluster;
    }
    public void setCluster(Cluster cluster){
    	this.cluster = cluster;
    }
    /*添加当前对象与参数对象间的最大最小距离信息入Map*/
//    public void addPToPDis(Point p){
//    	PToP tempO = new PToP(this,p);
//    	/*把点对点对象放入map中*/
//    	this.ptpMap.put(p, tempO);
//    	double min = tempO.getMinDis();
//    	double max = tempO.getMaxDis();
//    	this.reMap.put(p, new double[]{min,max});
//    	/*记录对象到其他对象的最大距离*/
//    	if(max>this.curAbsMax)
//    		this.curAbsMax = max;
//    }
  
    /*添加当前对象与参数对象间的关系入Map*/
  public void addPToPDis(Point p){
  	PToP tempO = new PToP(this,p);
  	/*把点对点对象放入map中*/
  	this.ptpMap.put(p, tempO);
  	/*记录对象到其他对象的最大距离*/
  }
  
  /*添加当前对象与参簇象间的关系入Map*/
  public void addPToCDis(Cluster cluster){
	  PToCluster tempO = new PToCluster(this,cluster);
	  /*把点对点对象放入map中*/
	  this.ptcMap.put(cluster, tempO);
  }
  public void initCShiMap(){
  	Set<Cluster> cSet = ptcMap.keySet();
  	Iterator<Cluster> itorc = cSet.iterator();
  	while(itorc.hasNext()){
  		Cluster toc = itorc.next();
  		PToCluster temp = this.ptcMap.get(toc);
  		temp.setShi();
  	}
  }
  
  
    public Map<Point,Double> getShiMap(){
    	return this.ShiMap;
    }
    
    public static BigInteger getSid() {
		return sid;
	}
	public static void setSid(BigInteger sid) {
		Point.sid = sid;
	}
	public Map<Cluster, PToCluster> getPtcMap() {
		return ptcMap;
	}
	public void setPtcMap(Map<Cluster, PToCluster> ptcMap) {
		this.ptcMap = ptcMap;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public void setPtpMap(Map<Point, PToP> ptpMap) {
		this.ptpMap = ptpMap;
	}
	public void setShiMap(Map<Point, Double> shiMap) {
		ShiMap = shiMap;
	}
    
    
    @Override
    public boolean equals(Object o){
    	if(o instanceof Point && this==o && this.id.compareTo(((Point)o).id)==0)
    		return true;
    	else
    		return false;
    }
    @Override
    public int hashCode(){
    	return super.hashCode();
    }
}
