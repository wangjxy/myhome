import java.util.*;
import java.io.*;
import java.lang.*;
public class RelativeKmeans {
	private double absMax = 0;
	private static int i1 = 1;
	private static int i2 = 17;
	private static int i3 = 14;
	private static int i4 = 18;
//	private static int i4 = 163;
//	private static int i5 = 176;
//	private static int i6 = 185;
	private static int dim = 2;
	private static int oNum = 20;
	private static int k = 4;
    public static void main(String args[]) throws Exception{
    	/*样本点数组*/
//    	double[][][] oList = new double[20][][];
    	/*区间数数组，后转换为联系数数组*/
    	Double[][][] oRange = new Double[20][2][2];
    	Point[] points = new Point[20];
    	
//    	oList[0] = new double[][]{{154,160},{156,170},{243,170},{163,138},{276,172},{250,165},{317,147},{234,128},{327,167},{274,188},{278,164},{161,172},{143,187},{305,141},{167,183}};
//    	oList[1] = new double[][]{{512,507},{555,493},{549,450},{537,440},{610,422},{594,371},{503,375},{515,498},{480,436},{608,512},{557,543},{617,547},{609,469},{566,521},{506,495}};
//    	oList[2] = new double[][]{{376,678},{396,617},{390,689},{354,598},{414,618},{339,710},{479,611},{403,632},{428,667},{481,646},{369,671},{479,613},{443,578},{455,569},{394,651}};
//    	oList[3] = new double[][]{{317,816},{308,744},{401,812},{423,816},{370,854},{407,813},{312,841},{410,838},{284,810},{337,855},{405,797},{432,762},{309,788},{320,752},{283,843}};
//    	oList[4] = new double[][]{{669,299},{630,243},{667,273},{597,200},{651,262},{674,216},{641,201},{619,274},{594,262},{609,219},{602,284},{682,212},{649,236},{685,174},{664,260}};
//    	oList[5] = new double[][]{{346,619},{312,631},{411,622},{478,630},{424,616},{425,643},{323,619},{424,629},{426,641},{420,631},{368,642},{397,622},{469,642},{476,605},{308,653}};
//    	oList[6] = new double[][]{{564,242},{548,246},{558,223},{526,231},{499,214},{492,225},{485,264},{511,253},{581,263},{566,240},{571,215},{588,230},{533,245},{561,241},{513,240}};
//    	oList[7] = new double[][]{{311,790},{286,763},{282,788},{264,760},{267,798},{308,783},{352,788},{343,735},{287,783},{311,754},{296,759},{314,752},{354,735},{309,723},{348,779}};
//    	oList[8] = new double[][]{{225,244},{284,186},{234,210},{290,195},{207,248},{209,236},{254,250},{325,224},{299,263},{272,275},{323,241},{226,206},{299,257},{205,179},{287,169}};
//    	oList[9] = new double[][]{{333,491},{371,451},{353,467},{326,477},{341,453},{313,506},{327,465},{353,514},{360,485},{359,462},{341,497},{329,487},{355,504},{338,478},{357,499}};
//    	oList[10] = new double[][]{{315,51},{282,177},{400,188},{323,154},{385,156},{298,108},{369,208},{375,157},{245,138},{250,147},{266,156},{373,153},{402,145},{326,173},{268,187}};
//    	oList[11] = new double[][]{{644,597},{654,494},{659,567},{677,532},{637,631},{686,518},{628,533},{660,495},{633,483},{668,573},{648,486},{657,545},{632,601},{692,631},{684,611}};
//    	oList[12] = new double[][]{{758,765},{811,743},{793,683},{797,755},{796,760},{775,724},{819,680},{802,743},{805,774},{766,671},{773,759},{813,726},{808,731},{825,658},{768,665}};
//    	oList[13] = new double[][]{{689,825},{662,820},{722,702},{721,808},{712,799},{693,736},{685,846},{655,708},{659,806},{691,788},{671,721},{702,774},{647,775},{661,714},{728,860}};
//    	oList[14] = new double[][]{{513,761},{521,738},{477,739},{478,685},{507,841},{484,851},{480,773},{523,790},{480,706},{499,664},{522,708},{504,802},{494,697},{498,789},{524,687}};
//    	oList[15] = new double[][]{{470,691},{520,673},{529,737},{492,633},{471,663},{536,639},{496,744},{489,648},{514,637},{454,610},{519,622},{508,608},{471,624},{506,760},{466,638}};
//    	oList[16] = new double[][]{{277,89},{389,205},{271,216},{270,112},{370,249},{283,77},{311,122},{278,216},{366,210},{375,85},{333,207},{378,216},{299,90},{310,244},{316,244}};
//    	oList[17] = new double[][]{{419,602},{357,597},{412,594},{468,619},{447,588},{421,567},{438,609},{423,565},{386,591},{465,549},{366,598},{472,644},{443,573},{401,647},{467,573}};
//    	oList[18] = new double[][]{{773,262},{794,279},{781,233},{780,321},{779,256},{735,239},{783,307},{793,235},{729,327},{787,226},{790,252},{793,203},{783,292},{765,273},{798,311}};
//    	oList[19] = new double[][]{{81,386},{129,384},{72,378},{117,367},{145,355},{155,354},{149,366},{98,402},{88,384},{76,396},{81,395},{143,385},{101,399},{152,359},{88,399}};
//    	oList[0] = new double[][]{};
    	
//	    double[][] o1 = {{1,5},{3,8},{5,10},{6,2},{7,6},{8,2},{10,13}};
//	    double[][] o2 = {{15,12},{14,19},{16,24},{18,10},{11,8},{9,15},{16,17},{18,20},{25,14}};
//	    double[][] o3 = {{25,38},{29,45},{30,35},{35,37},{28,42},{21,49},{27,45},{23,41},{22,38}};
//	    double[][] o4 = {{10,90},{18,86},{23,87},{13,95},{6,92},{14,91},{8,90},{22,88},{10,85}};
//	    double[][] o5 = {{30,70},{36,75},{35,78},{38,77},{40,68},{28,67},{29,63},{34,82},{32,79}};
//	    double[][] o6 = {{90,45},{87,59},{80,44},{98,41},{95,48},{91,50},{89,46},{97,42},{85,53}};
//	    double[][] o7 = {{80,70},{85,78},{89,75},{75,65},{79,68},{84,75},{81,71},{77,74},{85,70}};   	
	    
//	    oRange[0] = new Double[][]{{1.0,10.0},{2.0,13.0}};
//	    oRange[1] = new Double[][]{{9.0,25.0},{8.0,24.0}};
//	    oRange[2] = new Double[][]{{21.0,35.0},{35.0,49.0}};
//	    oRange[3] = new Double[][]{{6.0,23.0},{86.0,95.0}};
//	    oRange[4] = new Double[][]{{28.0,40.0},{63.0,82.0}};
//	    oRange[5] = new Double[][]{{85.0,98.0},{41.0,59.0}};
//	    oRange[6] = new Double[][]{{75.0,89.0},{65.0,78.0}};
//	    Point[] points = new Point[7];
//	    points[0] = new Point(2,7);
//	    points[1] = new Point(2,9);
//	    points[2] = new Point(2,9);
//	    points[3] = new Point(2,9);
//	    points[4] = new Point(2,9);
//	    points[5] = new Point(2,9);
//	    points[6] = new Point(2,9);
//	    points[0].setPlace(o1);
//	    points[1].setPlace(o2);
//	    points[2].setPlace(o3);
//	    points[3].setPlace(o4);
//	    points[4].setPlace(o5);
//	    points[5].setPlace(o6);
//	    points[6].setPlace(o7);
//    	oList[0] = new double[][]{{327,849},{385,821},{363,809},{378,829},{416,849},{394,851},{366,848},{381,807},{424,810},{315,855},{359,847},{344,867},{436,855},{409,816},{439,864}};
//    	oList[1] = new double[][]{{769,22},{715,10},{682,59},{704,47},{759,53},{683,25},{700,17},{720,46},{736,59},{719,37},{770,15},{689,17},{681,9},{704,53},{664,27}};
//    	oList[2] = new double[][]{{241,84},{304,31},{260,67},{277,68},{301,60},{276,59},{242,35},{262,100},{299,72},{265,95},{251,52},{308,47},{313,51},{295,109},{262,63}};
//    	oList[3] = new double[][]{{781,689},{717,662},{731,777},{720,759},{750,721},{687,690},{699,748},{694,752},{734,634},{761,680},{666,819},{730,718},{698,719},{718,776},{680,692}};
//    	oList[4] = new double[][]{{473,157},{401,198},{377,159},{393,197},{315,179},{468,187},{419,183},{475,197},{460,169},{332,172},{353,195},{478,183},{422,173},{335,161},{395,189}};
//    	oList[5] = new double[][]{{747,405},{775,419},{794,401},{758,430},{744,463},{782,456},{744,440},{774,422},{803,425},{762,423},{735,435},{742,456},{809,439},{768,392},{783,398}};
//    	oList[6] = new double[][]{{798,728},{731,817},{706,863},{752,873},{728,743},{688,801},{766,900},{789,783},{786,900},{807,885},{729,892},{813,826},{798,876},{736,807},{762,721}};
//    	oList[7] = new double[][]{{185,377},{151,323},{189,406},{191,328},{195,328},{144,423},{173,401},{146,377},{149,316},{185,333},{145,335},{141,412},{150,331},{151,395},{164,358}};
//    	oList[8] = new double[][]{{381,832},{467,701},{400,697},{407,738},{363,716},{393,707},{371,736},{434,756},{353,828},{459,844},{458,741},{425,723},{431,700},{407,700},{367,718}};
//    	oList[9] = new double[][]{{714,181},{748,170},{710,178},{707,214},{706,197},{754,219},{753,189},{742,206},{734,181},{770,189},{744,167},{716,214},{709,215},{719,210},{766,212}};
//    	oList[10] = new double[][]{{655,608},{682,593},{664,731},{705,663},{740,623},{644,698},{673,727},{702,564},{710,670},{638,718},{626,701},{683,593},{661,679},{677,672},{610,745}};
//    	oList[11] = new double[][]{{229,561},{195,618},{229,611},{169,626},{193,558},{172,625},{221,584},{244,587},{176,632},{244,576},{233,550},{202,630},{223,571},{202,550},{205,628}};
//    	oList[12] = new double[][]{{704,405},{656,368},{661,397},{674,357},{649,410},{686,383},{633,410},{641,390},{635,350},{682,359},{643,351},{699,403},{701,342},{648,411},{693,365}};
//    	oList[13] = new double[][]{{212,181},{287,192},{287,196},{211,191},{195,203},{227,155},{313,180},{292,216},{197,213},{253,246},{194,219},{276,200},{256,161},{291,247},{312,217}};
//    	oList[14] = new double[][]{{240,188},{189,195},{283,189},{246,98},{219,112},{215,172},{281,131},{266,199},{253,146},{232,113},{245,71},{179,86},{272,154},{218,109},{292,113}};
//    	oList[15] = new double[][]{{726,125},{767,158},{720,135},{735,74},{681,104},{761,127},{693,89},{701,31},{753,150},{718,85},{771,164},{711,80},{692,82},{774,53},{724,82}};
//    	oList[16] = new double[][]{{849,707},{880,568},{930,723},{801,684},{840,724},{846,640},{937,672},{816,678},{797,564},{870,567},{857,644},{893,606},{842,664},{937,683},{883,622}};
//    	oList[17] = new double[][]{{656,890},{532,856},{542,869},{629,925},{657,815},{520,880},{654,924},{568,860},{600,804},{654,903},{634,934},{630,890},{615,922},{601,877},{657,815}};
//    	oList[18] = new double[][]{{747,852},{685,816},{745,779},{696,807},{730,683},{789,775},{750,710},{743,856},{757,785},{708,702},{749,664},{748,664},{698,767},{740,786},{723,835}};
//    	oList[19] = new double[][]{{726,781},{614,758},{742,773},{615,746},{730,783},{630,779},{618,707},{705,780},{649,797},{640,734},{716,716},{701,768},{734,713},{642,736},{710,798}};
        
    	
    	double[][][] oList = new double[20][15][2];
    	oList[0] = new double[][]{{629,308},{647,258},{639,206},{679,224},{674,326},{639,264},{644,210},{635,293},{666,289},{637,221},{664,276},{650,331},{679,219},{655,277},{635,248}};
    	oList[1] = new double[][]{{448,708},{332,643},{446,743},{447,779},{382,707},{363,650},{321,724},{378,669},{419,666},{359,769},{407,739},{320,656},{355,785},{379,723},{323,728}};
    	oList[2] = new double[][]{{689,756},{655,728},{644,742},{677,824},{723,773},{659,791},{705,780},{654,734},{689,769},{655,784},{654,731},{664,754},{687,775},{663,823},{646,801}};
    	oList[3] = new double[][]{{767,556},{776,536},{782,552},{732,496},{756,598},{744,524},{711,605},{743,564},{739,559},{726,505},{749,568},{755,594},{770,489},{716,595},{737,522}};
    	oList[4] = new double[][]{{126,248},{114,280},{132,311},{147,239},{116,317},{140,277},{122,344},{116,336},{124,305},{117,296},{145,251},{120,338},{141,277},{162,262},{130,359}};
    	oList[5] = new double[][]{{611,428},{730,455},{642,478},{702,463},{649,488},{694,477},{724,425},{716,505},{705,470},{614,460},{660,499},{679,480},{628,494},{693,429},{656,487}};
    	oList[6] = new double[][]{{541,271},{544,374},{574,363},{554,379},{520,244},{524,325},{570,241},{548,230},{584,308},{575,219},{502,298},{513,235},{597,371},{533,259},{567,284}};
    	oList[7] = new double[][]{{556,527},{630,511},{631,488},{548,516},{586,516},{652,477},{544,493},{557,487},{560,473},{683,523},{592,499},{629,493},{628,500},{613,516},{693,465}};
    	oList[8] = new double[][]{{120,113},{140,70},{187,94},{167,91},{210,63},{211,60},{141,111},{167,64},{143,73},{153,65},{133,82},{116,106},{136,105},{203,88},{142,65}};
    	oList[9] = new double[][]{{232,434},{232,347},{269,307},{321,398},{312,345},{384,440},{235,340},{288,340},{231,307},{243,314},{374,405},{239,413},{230,343},{353,348},{331,418}};
    	oList[10] = new double[][]{{127,604},{105,685},{102,618},{102,696},{85,658},{196,565},{117,616},{79,676},{176,715},{103,607},{167,719},{193,681},{100,586},{79,590},{186,611}};
    	oList[11] = new double[][]{{105,217},{102,205},{86,253},{112,226},{93,239},{115,246},{74,216},{118,257},{63,234},{91,237},{75,239},{82,203},{133,221},{77,210},{96,208}};
    	oList[12] = new double[][]{{608,216},{622,251},{575,185},{632,202},{613,182},{568,180},{553,180},{568,226},{549,217},{595,274},{639,187},{597,196},{591,182},{549,219},{606,177}};
    	oList[13] = new double[][]{{205,788},{279,776},{291,791},{202,861},{260,826},{166,895},{166,814},{225,872},{295,832},{321,803},{230,880},{258,903},{259,931},{221,785},{296,813}};
    	oList[14] = new double[][]{{654,434},{613,565},{709,527},{687,495},{638,548},{719,432},{682,481},{660,500},{651,411},{624,557},{682,432},{618,445},{699,468},{617,567},{626,540}};
    	oList[15] = new double[][]{{803,589},{768,640},{730,610},{806,653},{812,604},{835,631},{783,587},{858,604},{743,573},{770,592},{800,559},{765,642},{769,637},{745,560},{766,558}};
    	oList[16] = new double[][]{{176,161},{163,175},{312,105},{171,126},{256,202},{276,149},{335,192},{335,205},{166,213},{290,128},{286,190},{158,178},{210,141},{242,172},{329,188}};
    	oList[17] = new double[][]{{510,576},{526,549},{576,553},{588,509},{618,543},{614,603},{593,506},{572,641},{505,589},{587,531},{576,660},{528,622},{499,680},{498,559},{621,586}};
    	oList[18] = new double[][]{{827,556},{837,566},{843,506},{820,511},{753,483},{799,550},{799,486},{799,509},{757,491},{845,562},{838,549},{822,516},{807,485},{857,564},{757,510}};
    	oList[19] = new double[][]{{696,232},{765,307},{754,310},{700,283},{740,256},{740,237},{734,253},{798,217},{787,287},{723,230},{758,288},{792,299},{772,273},{803,284},{749,222}};
    	
	    /*start样本点转区间数*/
	    for(int i=0;i<oList.length;i++){
	    	double xMin = oList[i][0][0];
	    	double xMax = oList[i][0][0];
	    	double yMin = oList[i][0][1];
	    	double yMax = oList[i][0][1];
	    	for(int j=0;j<oList[i].length;j++){
                xMin = oList[i][j][0]<xMin?oList[i][j][0]:xMin;
                xMax = oList[i][j][0]>xMax?oList[i][j][0]:xMax;
                yMin = oList[i][j][1]<yMin?oList[i][j][1]:yMin;
                yMax = oList[i][j][1]>yMax?oList[i][j][1]:yMax;
	    	}
	    	oRange[i][0] = new Double[]{xMin,xMax};
	    	oRange[i][1] = new Double[]{yMin,yMax};
	    }
	    /*end样本点转区间数*/
	    
    	
	    
	    /*start区间数转联系数*/
//	    for(int i=0;i<oRange.length;i++){
//	    	for(int j=0;j<oRange[i].length;j++){
//	    		double a = (oRange[i][j][0]+oRange[i][j][1])/2;
//	    		double b = (oRange[i][j][1]-oRange[i][j][0])/2;
//	    		oRange[i][j][0] = a;
//	    		oRange[i][j][1] = b;
//	    	}
//	    }
	    /*end区间数转联系数*/
    	
    	RelativeKmeans obj = new RelativeKmeans();
    	/*start读取数据内容并转换为联系数*/
/*    	File file = new File("D:"+File.separator+"dataset"+File.separator+"iris.txt");
    	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    	String msg = "";
    	int count = 0;
    	while((msg=br.readLine())!=null){
    		String[] strData = msg.split(",");
    		for(int q=0;q<strData.length-1;q++){
//    			oRange[count][q][0] = Double.valueOf(strData[q]);
    			double value = Double.valueOf(strData[q]);
    			oRange[count][q][0] = obj.getA(value);
    			oRange[count][q][1] = obj.getB(value);
    			double[] temp = obj.getStandard(oRange[count][q][0]-oRange[count][q][1],oRange[count][q][0]+oRange[count][q][1]);
    			oRange[count][q][0] = temp[0];
    			oRange[count][q][1] = temp[1];
    		}*/
//    		/*维度1联系数赋值*/
//    		oRange[count][0][0] = Double.valueOf(strData[0]);
//    		//oRange[count][0][1] = Double.valueOf(strData[1]);
//    		oRange[count][0][1] = Double.valueOf(rData[0]);
//    		/*维度2联系数赋值*/
//    		oRange[count][1][0] = Double.valueOf(strData[2]);
//    		oRange[count][1][1] = Double.valueOf(strData[3]);
////    		oRange[count][1][1] = Double.valueOf(rData[1]);
//    		/*维度3联系数赋值*/
//    		oRange[count][2][0] = Double.valueOf(strData[4]);
//    		oRange[count][2][1] = Double.valueOf(strData[5]);
////    		oRange[count][2][1] = Double.valueOf(rData[2]);
//    		/*维度4联系数赋值*/
//    		oRange[count][3][0] = Double.valueOf(strData[6]);
//    		oRange[count][3][1] = Double.valueOf(strData[7]);
////    		oRange[count][3][1] = Double.valueOf(rData[3]);
//    		System.out.println(strData[7]);
    	/*	count++;
    	}*/
    	/*end读取数据内容并转换为联系数*/
//    	br.close();
    	
    	for(int i=0;i<points.length;i++){
    		points[i] = new Point(dim);
    		points[i].setRange(oRange[i]);
    	}
	    //簇数量
	    Cluster[] clusters = new Cluster[k];
		/*start 簇初始化*/
    	for(int i=0;i<clusters.length;i++){
    		clusters[i] = new Cluster();
    	}
    	clusters[0].addPoint(points[i1]);
    	clusters[1].addPoint(points[i2]);
    	clusters[2].addPoint(points[i3]);
    	clusters[3].addPoint(points[i4]);
//    	clusters[3].addPoint(points[i4]);
//    	clusters[4].addPoint(points[i5]);
//    	clusters[5].addPoint(points[i6]);
   // 	clusters[3].addPoint(points[19]);
    	//clusters[3].addPoint(points[12]);
    	//clusters[4].addPoint(points[16]);
    	/*end 簇初始化*/
	    	    
	    obj.start(points,k, clusters);
        obj.clusterItr(clusters, points);
        obj.clusterItr(clusters, points);
        obj.clusterItr(clusters, points);
        obj.clusterItr(clusters, points);
        obj.clusterItr(clusters, points);
        obj.clusterItr(clusters, points);
        obj.clusterItr(clusters, points);
        obj.clusterItr(clusters, points);
        obj.clusterItr(clusters, points);
        obj.clusterItr(clusters, points);
        obj.clusterItr(clusters, points);
	    /*输出结果*/
	    for(int i=0;i<clusters.length;i++){
	    	System.out.print("c"+(i+1)+":");
	    	clusters[i].showPoints();
	    	System.out.println();
	    }
//	    System.out.println("F-Measure:"+obj.showEveResult(clusters,new int[]{49,99,149}));
//	    for(int i=0;i<points.length;i++){
////	    	System.out.print(points[i].getPtcMap().size()+"-");
////	    	System.out.print(points[i].getPtpMap().size()+"-");
////	    	System.out.println(points[i].getShiMap().size());
//	    	char ch = (char)('A'+i);
//	    	if(i!=11)
//	    	 System.out.println(ch+"::"+points[11].getPtpMap().get(points[i]).getShi());
//	    }

//	    obj.preProcess(points);
//	    for(int i=0;i<points.length;i++){
//	    	for(int j=0;j<points.length;j++){
//	    		if(j!=i){
//	    			System.out.println((i+1)+"-"+(j+1));
//	    			System.out.println(points[i].getShiMap().get(points[j]));
//	    		}
//	    	}
//	    }
	  //  PToP pt1 = new PToP(points[11],points[1]);//B
//	    points[11].addPToPDis(points[12]);
//	    points[11].addPToPDis(points[1]);
//	    points[1].addPToPDis(points[11]);
//	    points[12].addPToPDis(points[11]);
//	    PToP pt1 = (PToP)points[11].getPtpMap().get(points[1]);
//	    PToP pt2 = (PToP)points[11].getPtpMap().get(points[12]);
//	    double ms = points[11].getCurAbsMax()>points[12].getCurAbsMax()?points[11].getCurAbsMax():points[12].getCurAbsMax();
//	    ms = points[1].getCurAbsMax()>ms?points[1].getCurAbsMax():ms;
//	    pt1.setShi(ms+ms*0.3);
//	    pt2.setShi(ms+ms*0.3);
//	    System.out.println("ms"+ms+"a"+pt2.getA()+"b"+pt2.getB());
//	    System.out.println(pt1.getShi()+":"+pt1.getB());
//	    System.out.println(pt2.getShi()+":"+pt2.getB());
//	   // System.out.println(oRange[1][0][0]+"-"+oRange[1][0][1]+"-"+oRange[1][1][0]+"-"+oRange[1][1][1]+"-");
//	    System.out.println(oRange[11][0][0]+"-"+oRange[11][0][1]+"-"+oRange[11][1][0]+"-"+oRange[11][1][1]+"-");
//	    System.out.println(oRange[12][0][0]+"-"+oRange[12][0][1]+"-"+oRange[12][1][0]+"-"+oRange[12][1][1]+"-");
    }
    
    /*根据中心点随机决定中心范围*/
    public double getA(double value){
		return getRandom(value-0.2*value,value+0.2*value);
    }
    
    /*根据中心点随机决定半径范围*/
    public double getB(double value){
    	return getRandom(0.2*value,0.3*value);
    }
    /*获取min与max之间的随机double值*/
    private double getRandom(double min,double max){
    	Random rd = new Random();
    	int tempMin = (int)(min*100);
    	int tempMax = (int)(max*100);
    	if((tempMax - tempMin)==0)
    		return 0;
    	int num = rd.nextInt(tempMax - tempMin);
    	return min + (double)num/100.0;
    }
    /*在一个区间数内返回该区间的均值和标准差*/
    public double[] getStandard(double min,double max){
    	double result[] = new double[2];
    	double sum = 0;
    	double[] nums = new double[30];
    	for(int i=0;i<30;i++){
    		nums[i] = this.getRandom(min, max);
    		sum+=nums[i];
    	}
    	double avg = sum/30;    	
    	sum = 0;
    	for(int i=0;i<30;i++){
    		sum+=(nums[i]-avg)*(nums[i]-avg);
    	}
    	sum = sum/30;
    	result[0] = avg;
    	result[1] = Math.sqrt(sum); 
    	return result;
    }
    /*初始8化对象的一些参数，以及对象间的一些参数*/
    public void preProcess(Point[] points,Cluster[] clusters){
    	/*start把对象间的最大最小距离记录在Point对象中*/
//    	for(int i=0;i<points.length;i++){
//    		for(int j=i+1;j<points.length;j++){
//                points[i].addPToPDis(points[j]);
//                points[j].addPToPDis(points[i]);
//    		}
//    	}
    	/*end把对象间的最大最小距离记录在Point对象中*/
    	
    	/*start把对象间的关系与对象与簇之间的关系记录在Point对象中*/
    	for(int i=0;i<points.length;i++){
    		for(int j=i+1;j<points.length;j++){
                points[i].addPToPDis(points[j]);
                points[j].addPToPDis(points[i]);
    		}
    		for(int l=0;l<clusters.length;l++){
    			points[i].addPToCDis(clusters[l]);
    		}
    	}
    	/*end把对象间的最大最小距离记录在Point对象中*/
    	
    	/*start初始化对象里面的CShiMap*/
    	this.reSetClusterShi(points);
    	/*end初始化对象里面的CShiMap*/
    }
    /**
     * 第一次聚类，把数据聚类到预选出的K个类中
     * @param points 数据对象数组
     * @param k 初始K个簇
     * */
    public void start(Point[] points,int k,Cluster[] clusters){
    	/*初始化对象内参数*/
    	this.preProcess(points,clusters);
    	/*start 选取K个初始簇中心*/
    	int length = points.length;
    	/*K个簇中心存放类集*/
//    	Set<Point> pSet = new HashSet<Point>();
//    	int count = 0;
//    	while(count<k){
//    		Random rd = new Random();
//    		int index = rd.nextInt(length-1);
//    		Point tempP = points[index];
//    		if(!pSet.contains(tempP)){
//    			pSet.add(tempP);
//    			count++;
//    		}
//    	}
    	/*end 选取K个初始簇中心*/
    	
    	/*start遍历所有数据点，把数据点放入初始化的K个簇中*/
//    	for(int i=0;i<points.length;i++){
//    		Point tp = points[i];
//    		if(!pSet.contains(tp)){
//    			this.accOnePoint(tp, pSet);
//    		}
//    	}
    	/*end遍历所有数据点，把数据点放入初始化的K个簇中*/
    	
    	/*start分配各点到簇*/
        for(int i=0;i<length;i++){
        	int curClu = -1;
        	/*i不等于各个初始化的簇中心索引*/
        	if(i!=i1&&i!=i2&&i!=i3&&i!=i4){
        		curClu = 0;
        		Double shi = null;
        		for(int j=0;j<clusters.length;j++){
        			PToCluster ptc = points[i].getPtcMap().get(clusters[j]);
        			if(shi==null){
        				shi = ptc.getShi();
        			}else{
        				if(ptc.getShi()<shi){
        					curClu = j;
        					shi = ptc.getShi();        			
        				}
        			}
        		}
        		clusters[curClu].getPoint().add(points[i]);
        		points[i].setCluster(clusters[curClu]);
        	}
        }
        /*end 分配各点到簇*/
    }
    
    /**
     * 根据已经聚好的类，进行下一次聚类
     * */
    public void clusterItr(Cluster[] clusters,Point[] points){
    	/*start重新计算对象到簇的势*/
    	this.reSetClusterShi(points);
    	/*end重新计算对象到簇的势*/
    	
    	/*用于暂时记录各个对象与簇的对应关系，等到最后清除原先簇内点后，再进行重新分配*/
    	Map<Point,Cluster> pc = new HashMap<Point,Cluster>();
    	for(int i=0;i<points.length;i++){
    		Double shi = null;
    		int curC = 0;
    		for(int j=0;j<clusters.length;j++){
    		//	PToCluster ptc = points[i].getPtcMap().get(clusters[j]);
			//	ptc.setPoint(points[i]);
			//	ptc.setCluster(clusters[j]);
			//	ptc.setShi();
    			PToCluster ptc = points[i].getPtcMap().get(clusters[j]);
				if(shi==null){
					shi = ptc.getShi();
				}else if(shi>ptc.getShi()){
					shi = ptc.getShi();
					curC = j;
				}
    		}
    		pc.put(points[i], clusters[curC]);
    	}
    	/*start清楚掉原先的簇内点*/
    	this.refreshCluster(clusters);
    	/*end清楚掉原先的簇内点*/
    	
    	/*start重新分配点到各个簇*/
    	for(int k=0;k<points.length;k++){
    		Cluster clu = pc.get(points[k]);
    		clu.addPoint(points[k]);
    		points[k].setCluster(clu);
    	}
    	/*end重新分配点到各个簇*/
    }
    /*删除簇内点*/
    public void refreshCluster(Cluster[] clusters){
    	for(int i=0;i<clusters.length;i++){
    		clusters[i].getPoint().clear();
    	}
    }
    /*重新计算簇与对象的势*/
    public void reSetClusterShi(Point[] points){
    	for(int i=0;i<points.length;i++){
            points[i].initCShiMap();
    	}
    }
//    /**
//     * 根据已经聚好的类，进行下一次聚类
//     * */
//    public void clusterItr(Cluster[] clusters,Point[] points){
//    	Map<Point,Cluster> pc = new HashMap<Point,Cluster>();
//    	for(int i=0;i<points.length;i++){
//    		Double shi = null;
//    		int curC = -1;
//    		for(int j=0;j<clusters.length;j++){
//    			if(!(clusters[j].getPoint().size()==1 && clusters[j].getPoint().contains(points[i]))){
//    				PToCluster pToC = new PToCluster(null,null);
//    				pToC.setPoint(points[i]);
//    				pToC.setCluster(clusters[j]);
//    				pToC.setShi();
//    				if(shi==null){
//    					shi = pToC.getShi();
//    					curC = j;
//    				}else if(shi>pToC.getShi()){
//    					shi = pToC.getShi();
//    					curC = j;
//    				}
//    			}else{
//    				curC = j;
//    				break;
//    			}
//    			
//    		}
//    		pc.put(points[i], clusters[curC]);
//    	}
//    	this.refreshCluster(clusters);
//    	for(int k=0;k<points.length;k++){
//    		Cluster clu = pc.get(points[k]);
//    		clu.addPoint(points[k]);
//    		points[k].setCluster(clu);
//    	}
//    }
//    public void refreshCluster(Cluster[] clusters){
//    	for(int i=0;i<clusters.length;i++){
//    		clusters[i].getPoint().clear();
//    	}
//    }
    public double showEveResult(Cluster[] clusters,int[] cmax){
    	double[][] N = new double[clusters.length][3];//ni,nj,nij
    	N[0][0] = 50.0;//ni
    	N[1][0] = 50.0;//ni
    	N[2][0] = 50.0;//ni
//    	N[3][0] = 13.0;//ni
//    	N[4][0] = 9.0;//ni
//    	N[5][0] = 29.0;//ni
    	for(int i=0;i<clusters.length;i++){
    		Point[] points = clusters[i].getArrPoints();
    		N[i][1] = points.length;//nj
    		double nij = 0.0;
    		System.out.println(points.length);
    		for(int j=0;j<points.length;j++){
    			if((i==0&&Integer.valueOf(points[j].getId())<=cmax[i])||(i>0&&Integer.valueOf(points[j].getId())<=cmax[i]&&Integer.valueOf(points[j].getId())>cmax[i-1])){
    				nij++;
    			}
    		}
    		N[i][2] = nij;//nij
    	}
    	return getF(N);
    }
    public double getF(double[][] N){
    	double p1 = N[0][2]/N[0][0];//ni/nij
		double r1 = N[0][2]/N[0][1];//nj/nij
		double p2 = N[1][2]/N[1][0];
		double r2 = N[1][2]/N[1][1];
		double p3 = N[2][2]/N[2][0];
		double r3 = N[2][2]/N[2][1];
//		double p4 = N[3][2]/N[3][0];
//		double r4 = N[3][2]/N[3][1];
//		double p5 = N[4][2]/N[4][0];
//		double r5 = N[4][2]/N[4][1];
//		double p6 = N[5][2]/N[5][0];
//		double r6 = N[5][2]/N[5][1];
		double f1 = (p1+r1)==0?0:2.0*p1*r1/(p1+r1);
		double f2 = (p2+r2)==0?0:2.0*p2*r2/(p2+r2);
		double f3 = (p3+r3)==0?0:2.0*p3*r3/(p3+r3);
//		double f4 = (p4+r4)==0?0:2.0*p4*r4/(p4+r4);
//		double f5 = (p5+r5)==0?0:2.0*p5*r5/(p5+r5);
//		double f6 = (p6+r6)==0?0:2.0*p6*r6/(p6+r6);
		double F = (N[0][0]*f1+N[1][0]*f2+N[2][0]*f3)/150.0;
		return F;
    }
}