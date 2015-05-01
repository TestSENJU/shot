package Data;

public class CheckDataTool {
//在场时间 48:00
//投篮命中数20
//投篮出手数50
//三分命中数20
//三分出手数30
//罚球命中数30
//罚球出手数30
//进攻篮板数30
//防守篮板数30
//总篮板数60
//助攻数30
//抢断数10
//盖帽数10
//失误数15
//犯规数6
//个人得分100
	private double[] upperNum=new double[]{20,50,20,30,30,30,30,30,60,30,10,10,15,6,100};
	public CheckDataTool(){
		
	}
	public double[] getDoubleData(String [] strs){
		double result[]=new double[15];
		for(int i=3;i<strs.length-1;i++){
			try{
				double num=Double.parseDouble(strs[i]);
				if(num>upperNum[i]||num<0){
					result[i]=-1;
				}else{
					result[i]=num;
				}
			}catch(NumberFormatException e){
				result[i]=-1;
			}
		}
		return result;
	}
}
