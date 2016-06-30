//import java.util.*;
//import java.math.*;
///**
// * ������
// * @author wangjxy
// * */
//public class Point{
//	private static BigInteger sid = new BigInteger("0");
//	private BigInteger id = null;
//	/*����������㼯��*/
//    private double[][] place;
//    /*�����Ĵ�*/
//    private Cluster cluster = null;
//    
//    /*��ǰ����������������о��������ľ���*/
//    private double curAbsMax=0;
//    
//    /*��ǰ���������������������С����*/
//    private Map<Point,double[]> reMap = new HashMap<Point,double[]>();
//    /*��ǰ��������������ĵ�Ե����*/
//    private Map<Point,PToP> ptpMap = new HashMap<Point,PToP>();
//    /*��ǰ���������������*/
//    private Map<Point,Double> ShiMap = new HashMap<Point,Double>();
//    
//    /*��������ĵ�*/
////    private double[] mean = null;
//    
//    public String getId(){
//    	return this.id.toString();
//    }
//    public Point(int dim,int num){//ά�Ⱥ�һ����������������
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
//    /*��ӵ�ǰ��������������������С������Ϣ��Map*/
//    public void addPToPDis(Point p){
//    	PToP tempO = new PToP(this,p);
//    	/*�ѵ�Ե�������map��*/
//    	this.ptpMap.put(p, tempO);
//    	double min = tempO.getMinDis();
//    	double max = tempO.getMaxDis();
//    	this.reMap.put(p, new double[]{min,max});
//    	/*��¼�������������������*/
//    	if(max>this.curAbsMax)
//    		this.curAbsMax = max;
//    }
//    public Map<Point,Double> getShiMap(){
//    	return this.ShiMap;
//    }
//    
//    /*��ʼ����Map*/
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
 * ������
 * @author wangjxy
 * */
public class Point{
	private static BigInteger sid = new BigInteger("0");
	private BigInteger id = null;
	/*��������䷶Χ:ÿ��ά����һ����ϵ����ʾu=a+bi,a��ʾ�����е㣻range[][0]��ʾa,range[][1]��ʾb*/
    private Double[] range = null;
    /*�����Ĵ�*/
    private Cluster cluster = null;
    
    /*��ǰ����������������о��������ľ���*/
    
    /*��ǰ���������������������С����*/
//    private Map<Point,double[]> reMap = new HashMap<Point,double[]>();
    /*��ǰ��������������ĵ�Ե����*/
    private Map<Point,PToP> ptpMap = new HashMap<Point,PToP>();
    /*��ǰ���������������*/
    private Map<Point,Double> ShiMap = new HashMap<Point,Double>();
    /*��ǰ���������ص���*/
//    private Map<Cluster,Double> CShiMap = new HashMap<Cluster,Double>();
    /*��ǰ���������صĵ�Դض���*/
    private Map<Cluster,PToCluster> ptcMap = new HashMap<Cluster,PToCluster>();
    
    
    /*��������ĵ�*/
//    private double[] mean = null;
    
    public String getId(){
    	return this.id.toString();
    }
    public Point(){
    	id = sid.add(new BigInteger("1"));
    	sid = id;
    }
    public Point(int dim){//ά�Ⱥ�һ����������������
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
    /*��ӵ�ǰ��������������������С������Ϣ��Map*/
//    public void addPToPDis(Point p){
//    	PToP tempO = new PToP(this,p);
//    	/*�ѵ�Ե�������map��*/
//    	this.ptpMap.put(p, tempO);
//    	double min = tempO.getMinDis();
//    	double max = tempO.getMaxDis();
//    	this.reMap.put(p, new double[]{min,max});
//    	/*��¼�������������������*/
//    	if(max>this.curAbsMax)
//    		this.curAbsMax = max;
//    }
  
    /*��ӵ�ǰ��������������Ĺ�ϵ��Map*/
  public void addPToPDis(Point p){
  	PToP tempO = new PToP(this,p);
  	/*�ѵ�Ե�������map��*/
  	this.ptpMap.put(p, tempO);
  	/*��¼�������������������*/
  }
  
  /*��ӵ�ǰ������δ����Ĺ�ϵ��Map*/
  public void addPToCDis(Cluster cluster){
	  PToCluster tempO = new PToCluster(this,cluster);
	  /*�ѵ�Ե�������map��*/
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
