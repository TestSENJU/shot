package Data;

public class CheckDataTool {
//在场时间 48:00
	
	
//0投篮命中数50
//1投篮出手数100
//2三分命中数30
//3三分出手数50
//4罚球命中数50
//5罚球出手数100
//6进攻篮板数60
//7防守篮板数60
//8总篮板数60
//9助攻数40
//10抢断数20
//11盖帽数20
//12失误数20
//13犯规数10
//14个人得分100
	private double[] upperNum=new double[]{50,100,30,50,50,100,60,60,60,40,20,20,20,10,100};
	public CheckDataTool(){
		
	}
	public double[] getDoubleOpponentData(String[]strs){
		double result[]=new double[3];
		try{
			result[0]=Double.parseDouble(strs[6]);
			if(result[0]<0||result[0]>upperNum[0]){
				result[0]=-1;
			}
		}catch(NumberFormatException e){
			result[0]=-1;
		}
		try{
			result[1]=Double.parseDouble(strs[7]);
			if(result[1]<0||result[1]>upperNum[1]){
				result[1]=-1;
			}
		}catch(NumberFormatException e){
			result[1]=-1;
		}
		try{
			result[2]=Double.parseDouble(strs[14]);
			if(result[2]<0||result[2]>upperNum[2]){
				result[2]=-1;
			}
		}catch(NumberFormatException e){
			result[2]=-1;
		}
		return result;
	}
	public double[] getTeamData(String strs[]){
		double result[]=new double[8];
		try{
			result[0]=Double.parseDouble(strs[3]);
			if(result[0]<0||result[0]>upperNum[0]){
				result[0]=-1;
			}
		}catch(NumberFormatException e){
			result[0]=-1;
		}
        try{
			result[1]=Double.parseDouble(strs[4]);
			if(result[1]<0||result[1]>upperNum[1]){
				result[1]=-1;
			}
		}catch(NumberFormatException e){
			result[1]=-1;
		}
        try{
        	result[2]=Double.parseDouble(strs[6]);
        	if(result[2]<0||result[2]>upperNum[2]){
				result[2]=-1;
			}
        }catch(NumberFormatException e){
        	result[2]=-1;
        }
        try{
        	result[3]+=Double.parseDouble(strs[8]);
        	if(result[3]<0||result[3]>upperNum[3]){
				result[3]=-1;
			}
        }catch(NumberFormatException e){
        	result[3]=-1;
        }
        try{
        	result[4]+=Double.parseDouble(strs[9]);
        	if(result[4]<0||result[4]>upperNum[4]){
				result[4]=-1;
			}
        }catch(NumberFormatException e){
        	result[4]=-1;
        }
        try{
        	result[5]+=Double.parseDouble(strs[10]);
        	if(result[5]<0||result[5]>upperNum[5]){
				result[5]=-1;
			}
        }catch(NumberFormatException e){
        	result[5]=-1;
         }
         try{
        	 result[6]+=Double.parseDouble(strs[11]);
        		if(result[6]<0||result[6]>upperNum[6]){
    				result[6]=-1;
    			}
         }catch(NumberFormatException e){
        	 result[6]=-1;
         }
         try{
	          result[7]=Double.parseDouble(strs[15]);
	      	if(result[7]<0||result[7]>upperNum[7]){
				result[7]=-1;
			}
         }catch(NumberFormatException e){
	          result[7]=-1;
         }
         return result;
	}
	public double[] getDoubleData(String [] strs){
		double result[]=new double[15];
		for(int i=3;i<strs.length;i++){
			try{
				double num=Double.parseDouble(strs[i]);
				if(num>upperNum[i-3]||num<0){
					result[i-3]=-1;
				}else{
					result[i-3]=num;
				}
			}catch(NumberFormatException e){
				result[i-3]=-1;
			}
		}
		if(result[0]>result[1]&&(!(result[0]==-1))&&(!(result[1]==-1))){
			result[0]=-1;
			result[1]=-1;
		}
		if(result[2]>result[3]&&(!(result[2]==-1))&&(!(result[3]==-1))){
			result[2]=-1;
			result[3]=-1;
		}
		if(result[4]>result[5]&&(!(result[5]==-1))&&(!(result[6]==-1))){
			result[4]=-1;
			result[5]=-1;
		}
		if(result[6]+result[7]!=result[8]&&(!(result[6]==-1))&&(!(result[7]==-1))&&(!(result[8]==-1))){
			result[6]=-1;
			result[7]=-1;
			result[8]=-1;
		}
		return result;
	}
}