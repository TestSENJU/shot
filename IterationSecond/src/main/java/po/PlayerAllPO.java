package po;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import Data.CheckDataTool;
/**
 * 
 * @author wyt
 * 这个类对于BL是不可见的
 *然而我觉得我需要把错误逻辑检测我写的东西在这里写一下不然我之后又要不记得了
 *playerDataList里面的东西如果有哪一个不对了，就根据周围的四场比赛求平均值，如果这四场比赛中间有哪一个也有错就直接去掉
 *如果真的倒霉到这四次比赛都错的是一个，就调用另一个方法获取更远一点的两场比赛，如果再错.....然而我不想写这个了
 *teamDataList和competeDataList都是在相加的时候判断，如果有错误值，取队伍的平均值算进去
 *啊好烦
 */
public class PlayerAllPO{
	
	private HashMap<String,String[]> playerDataList=new HashMap<String,String[]>();
	private HashMap<String,double[]> teamDataList=new HashMap<String,double[]>();
	private HashMap<String,double[]> competeDataList=new HashMap<String,double[]>();
	private HashMap<String,String> teamTimeList=new HashMap<String,String>();
	String name;
	private ArrayList<String> teamList=new ArrayList<String>();
	
public PlayerAllPO(String playerName){
	this.name=playerName;
}
public ArrayList<String> getMatchNames(){
	Set<String> keys=playerDataList.keySet();
	ArrayList<String>list=new ArrayList<String>();
	
	for(String key:keys){
		list.add(key);
	}
	return list;
}
public void addPlayerData(String matchName,String[] playerData){
	this.playerDataList.put(matchName, playerData);
}
public void addTeamData(String matchName,double[] teamData){
	this.teamDataList.put(matchName, teamData);
}
public void addCompeteData(String matchName,double[] competeData){
	this.competeDataList.put(matchName, competeData);
}
public void addTeamTime(String matchName,String time){
	this.teamTimeList.put(matchName, time);
}
public void addTeam(String str){
	if(!teamList.contains(str)){
		teamList.add(str);
	}
}
public String getTeam(){
	if(teamList.size()==0){
		return null;
	}else{
		return teamList.get(teamList.size()-1);
	}
}
public PlayerAllPlusRatePO makeDetailedAllPO(){
	CheckDataTool tool=new CheckDataTool();
	PlayerAllPlusRatePO allData=new PlayerAllPlusRatePO(this.name);
	//参赛场数设置
	allData.addCompeteNum(playerDataList.size());
	for(int i=0;i<teamList.size();i++){
		//所属队伍设置
		allData.addTeam(teamList.get(i));
	}
	Set<String>keys=playerDataList.keySet();
	double result[]=new double[15];
	double [] nums=new double[15];
	double[] teamNums=new double[8];
	double[] opponentNums=new double[8];
	String time="0:0";
	String teamTime="0:0";
	double data[]=new double[27];
	double raiseNumUsed[]=new double[3];
	double raiseNum[]=new double[3];
	ArrayList<String>filenamelist=getRecentFiveMatches();
	for(String key:keys){
		String strs[]=playerDataList.get(key);
		
		double dnums1[]=teamDataList.get(key);
		double dnums2[]=competeDataList.get(key);
		//先发场数
		if(strs[1].equals("F")||strs[1].equals("C")||strs[2].equals("G")) allData.addOffensiveNum(1);
		
			nums=tool.getDoubleData(strs);
			for(int i=0;i<nums.length;i++){
				if(nums[i]<0){
					double number=0.0;
				
					ArrayList<String> filenames=getAroundMatches(key);
					int size=filenames.size();
					for(int j=0;j<filenames.size();j++){
						double reNums=tool.getDoubleData(playerDataList.get(filenames.get(j)))[i];
						if(!(reNums<0)){
							number+=reNums;
						}else{
							size--;
						}
					}
					if(size==0){
						double numb=0.0;
						ArrayList<String>filenamesAnother=getAnotherMatches(key);
						int sizeAnother=filenamesAnother.size();
						for(int j=0;j<filenamesAnother.size();j++){
							double reNums=tool.getDoubleData(playerDataList.get(filenamesAnother.get(j)))[i];
							if(!(reNums<0)){
								numb+=reNums;
							}else{
								sizeAnother--;
							}
						}
						nums[i]=numb/sizeAnother;
					}else{
						nums[i]=number/size;
					}
				}
				result[i]+=nums[i];
			}
			for(int i=0;i<teamNums.length;i++){
				//计算球队的总值
				teamNums[i]+=dnums1[i];
				opponentNums[i]+=dnums2[i];
			}
			time=refreshTime(time,strs[2]);
			//球员的比赛时间
			allData.addPlayingTime(strs[2]);
			teamTime=refreshTime(teamTime,teamTimeList.get(key));
			//这一场比赛在最近五场比赛时加到raiseNum上，否则加到之前的那个数组里
			if(filenamelist.size()>=5){
				if(filenamelist.contains(key)){
				raiseNum[0]+=nums[14];
				raiseNum[1]+=nums[8];
				raiseNum[2]+=nums[9];
				
				}else{
					raiseNumUsed[0]+=nums[14];
					raiseNumUsed[1]+=nums[8];
					raiseNumUsed[2]+=nums[9];

				}
			}
	}
	if(filenamelist.size()>=5){
		//计算提升率，如果有五场比赛以上才有这个数字，要是没有五场比赛就是零
		data[24]=(raiseNum[0]/5-raiseNumUsed[0]/(playerDataList.size()-5))/(raiseNumUsed[0]/(playerDataList.size()-5));
		data[25]=(raiseNum[1]/5-raiseNumUsed[1]/(playerDataList.size()-5))/(raiseNumUsed[1]/(playerDataList.size()-5));
		data[26]=(raiseNum[2]/5-raiseNumUsed[2]/(playerDataList.size()-5))/(raiseNumUsed[2]/(playerDataList.size()-5));
	
	}else{		
		data[24]=0;
		data[25]=0;
		data[26]=0;
	}
	
	String times1[]=time.split(":");
	String times2[]=teamTime.split(":");
	double playerTime=Integer.parseInt(times1[0])*60+Integer.parseInt(times1[1]);
	double teamtimeAll=Integer.parseInt(times2[0])*60+Integer.parseInt(times2[1]);
	//球队所有球员上场时间/5/球员上场时间
	double timeRate=teamtimeAll/5/playerTime;
	//篮板数
	data[0]=result[8];
	//助攻数
	data[1]=result[9];
	//投篮命中率
	data[2]=result[0]/result[1];
	//三分命中率
	data[3]=result[2]/result[3];
	//罚球命中率
	data[4]=result[4]/result[5];
	//进攻篮板数
	data[5]=result[6];
	//防守篮板数
	data[6]=result[7];
	//抢断数
	data[7]=result[10];
	//盖帽数
	data[8]=result[11];
	//失误数
	data[9]=result[12];
	//犯规数
	data[10]=result[13];
	//个人得分
	data[11]=result[14];
	//效率
	data[12]=result[14]+result[8]+result[10]+result[11]+result[9]
			-(result[1]-result[0])-(result[5]-result[4])-result[12];
	//GmSc效率
	data[13]=result[14]+result[0]*0.4-result[1]*0.7-
			0.4*(result[5]-result[4])+0.7*result[6]+0.3*result[7]+
			result[10]+result[9]*0.7+0.7*result[11]-0.4*result[13]-result[12];
	//真实命中率
	data[14]=result[14]/(2*(result[1]+0.44*result[5]));
	//投篮效率
	data[15]=(result[0]+0.5*result[2])/result[1];
	/**teamNums opponentNums
	 *0所有球员总出手次数 即投篮出手数之和
	 *1总进球数 即投篮命中数之和
	 *2总三分球出手次数
	 *3罚球次数 即罚球出手次数之和
	 *4总进攻篮板数
	 *5总防守篮板数
	 *6总篮板数 即3和4之和
	 *7失误次数
	 **/
	//篮板率
	data[16]=result[8]*timeRate/(teamNums[6]+opponentNums[6]);
	//进攻篮板率
	data[17]=result[6]*timeRate/(teamNums[4]+opponentNums[4]);
	//防守篮板率
	data[18]=result[7]*timeRate/(teamNums[5]+opponentNums[5]);
	//助攻率
	data[19]=result[9]/((1/timeRate)*teamNums[1]-result[0]);
	//对手进攻回合=对手投篮数+0.4*对手球队罚球数
	//            -1.07*(对手进攻篮板/(对手进攻篮板+我方防守篮板)*对手投失球数)
	//             +1.07*对手失误数
	double offensiveTime=opponentNums[0]+opponentNums[3]*0.4-
			1.07*(opponentNums[4]/(opponentNums[4]+teamNums[5])*opponentNums[7]);
	//抢断
	data[20]=result[10]*timeRate/offensiveTime;
	//盖帽
	data[21]=result[11]*timeRate/(opponentNums[0]-opponentNums[2]);
	//失误
	data[22]=result[12]/(result[1]-result[3]+0.44*result[5]+result[12]);
	//使用率
	data[23]=(result[1]+0.44*result[5]+result[12])*timeRate/(teamNums[0]+0.44*teamNums[3]+teamNums[7]);
		
	allData.setPlayerData(data);
	return allData;
}
//获取最近五场比赛的名字
private ArrayList<String> getRecentFiveMatches(){
	    String matchnames[]=getMatchNamesAll();
		ArrayList<String>names=new ArrayList<String>();
		if(matchnames.length<5){
			for(int j=matchnames.length-1;j>=0;j--){
				names.add(matchnames[j]);
			}
		}else{
					for(int j=matchnames.length-1;j>matchnames.length-6;j--){
			names.add(matchnames[j]);
		}
		}

		return names;
	
}
private String[] getMatchNamesAll(){
	Set<String>keys=playerDataList.keySet();
		String matchnames[]=new String[keys.size()];
		int i=0;
		for(String key:keys){
			matchnames[i]=key;
			i++;
		}
		Arrays.sort(matchnames);
		return matchnames;
}
private ArrayList<String> getAroundMatches(String key){
	ArrayList<String>list=new ArrayList<String>();
	String names[]=getMatchNamesAll();
	if(names.length<5){
		for(int i=0;i<names.length;i++){
			if(!names[i].equals(key)){
				list.add(names[i]);
			}
		}
		return list;
	}else{
		for(int i=0;i<names.length;i++){
			if(names[i].equals(key)){
				if(i==0){
					for(int j=1;j<5;j++){
						list.add(names[j]);
					}
				}else if(i==1){
					list.add(names[0]);
					for(int j=2;j<5;j++){
						list.add(names[j]);
					}
				}else if(i==names.length-1){
					for(int j=names.length-5;j<names.length-1;j++){
						list.add(names[j]);
					}
				}else if(i==names.length-2){
					list.add(names[names.length-1]);
					for(int j=names.length-5;j<names.length-1;j++){
						list.add(names[j]);
					}
				}else {
				list.add(names[i-2]);
				list.add(names[i-1]);
				list.add(names[i+1]);
				list.add(names[i+2]);
				}
			
				
			}
		}
		return list;
	}

}
private ArrayList<String> getAnotherMatches(String key){
	ArrayList<String> list=new ArrayList<String>();
	String names[]=getMatchNamesAll();
	if(names.length<5){
		return null;
	}else{
		for(int i=0;i<names.length;i++){
			if(names[i].equals(key)){
				if(i<=2){
					list.add(names[i+3]);
					list.add(names[i+4]);
				}else if(i>=names.length-3){
					list.add(names[i-3]);
					list.add(names[i-4]);
				}else{
					list.add(names[i-3]);
					list.add(names[i+3]);
				}
			}
		}	
		return list;	
	}
}
private String refreshTime(String teamTime1,String timeAdd){
	String ss[]=new String[2];
	String s[]=new String[2];
	if(timeAdd==null){
		ss[0]=0+"";
		ss[1]=0+"";
		
	}else{
		if(timeAdd.charAt(0)<='9'&&timeAdd.charAt(0)>='0'){
			ss=timeAdd.split(":");			
		}else{			
				ss[0]=0+"";
			ss[1]=0+"";
		}
	}
	  s=teamTime1.split(":");		
		int seconds=0;
		seconds=Integer.parseInt(ss[1])+Integer.parseInt(s[1]);
		if(seconds<60){
			teamTime1=(Integer.parseInt(ss[0])+Integer.parseInt(s[0])+"")
					+":"	+(seconds+"");	
		}else{
			teamTime1=(Integer.parseInt(ss[0])+Integer.parseInt(s[0])+1+"")
					+":"	+(seconds-60+"");	
		}	
		return teamTime1;
}
public PlayerAveragePlusRatePO makeAveragePO(){
	PlayerAllPlusRatePO allData=new PlayerAllPlusRatePO(this.name);
	allData=makeDetailedAllPO();
	PlayerAveragePlusRatePO averageData=new PlayerAveragePlusRatePO(allData);
	return averageData;
}

}
