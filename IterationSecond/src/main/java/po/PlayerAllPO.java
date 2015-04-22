package po;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
/**
 * 
 * @author wyt
 * 这个类对于BL是不可见的
 *
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

public PlayerAllPlusRatePO makeDetailedAllPO(){
	PlayerAllPlusRatePO allData=new PlayerAllPlusRatePO(this.name);
	allData.addCompeteNum(playerDataList.size());
	for(int i=0;i<teamList.size();i++){
		allData.addTeam(teamList.get(i));
	}
	Set<String>keys=playerDataList.keySet();
	//ArrayList<Integer>errorNumList=new ArrayList<Integer>();
	double [] nums=new double[15];
	double[] teamNums=new double[7];
	double[] opponentNums=new double[7];
	String time="0:0";
	String teamTime="0:0";
	double data[]=new double[27];
	ArrayList<String>filenamelist=getRecentFiveMatches();
	double raiseNumUsed[]=new double[3];
	double raiseNum[]=new double[3];
	for(String key:keys){
		String strs[]=playerDataList.get(key);
		double dnums1[]=teamDataList.get(key);
		double dnums2[]=competeDataList.get(key);
		
		if(strs[1]!="") allData.addOffensiveNum(1);
		
			for(int i=0;i<nums.length;i++){
				nums[i]+=Double.parseDouble(strs[i+3]);
		   }
			for(int i=0;i<teamNums.length;i++){
				teamNums[i]+=dnums1[i];
				opponentNums[i]+=dnums2[i];
			}
			time=refreshTime(time,strs[2]);
			allData.addPlayingTime(strs[2]);
			teamTime=refreshTime(teamTime,teamTimeList.get(key));
			if(filenamelist.contains(key)){
				raiseNum[0]+=Double.parseDouble(strs[14]);
				raiseNum[1]+=Double.parseDouble(strs[8]);
				raiseNum[2]+=Double.parseDouble(strs[9]);
			}else{
				raiseNumUsed[0]+=Double.parseDouble(strs[14]);
				raiseNumUsed[1]+=Double.parseDouble(strs[8]);
				raiseNumUsed[2]+=Double.parseDouble(strs[9]);
			}
	}
	String times1[]=time.split(":");
	String times2[]=teamTime.split(":");
	double playerTime=Integer.parseInt(times1[0])*60+Integer.parseInt(times1[1]);
	double teamtimeAll=Integer.parseInt(times2[0])*60+Integer.parseInt(times2[1]);
	double timeRate=teamtimeAll/5/playerTime;
	data[0]=nums[8];
	data[1]=nums[9];
	data[2]=nums[0]/nums[1];
	data[3]=nums[2]/nums[3];
	data[4]=nums[4]/nums[5];
	data[5]=nums[6];
	data[6]=nums[7];
	data[7]=nums[10];
	data[8]=nums[11];
	data[9]=nums[12];
	data[10]=nums[13];
	data[11]=nums[14];
	data[12]=nums[14]+nums[8]+nums[10]+nums[11]
			-(nums[1]-nums[0])-(nums[5]-nums[4])-nums[12];
	data[13]=nums[14]+nums[0]*0.4-nums[1]*0.7-
			0.4*(nums[5]-nums[4])+0.7*nums[6]+0.3*nums[7]+
			nums[10]+nums[9]*0.7+0.7*nums[11]-0.4*nums[13]-nums[12];
	data[14]=nums[14]/(2*nums[1]+0.44*nums[5]);
	data[15]=(nums[0]+0.5*nums[2])/nums[1];
	data[16]=nums[8]*timeRate/(teamNums[6]+opponentNums[6]);
	data[17]=nums[6]*timeRate/(teamNums[4]+opponentNums[4]);
	data[18]=nums[7]*timeRate/(teamNums[5]+opponentNums[5]);
	data[19]=nums[9]/timeRate*(teamNums[1]-nums[0]);
	//对手进攻回合=对手投篮数+0.4*对手球队罚球数
	//            -1.07*(对手进攻篮板/(对手进攻篮板+我方防守篮板)*对手投失球数)
	//             +1.07*对手失误数
	double offensiveTime=opponentNums[0]+opponentNums[3]*0.4-
			1.07*(opponentNums[3]/(opponentNums[4]+teamNums[5])*opponentNums[6]);
	data[20]=nums[10]*timeRate/offensiveTime;
	data[21]=nums[11]*timeRate/(opponentNums[0]-opponentNums[2]);
	data[22]=nums[12]/(nums[1]-nums[3]+0.44*nums[5]+nums[12]);
	data[23]=(nums[1]+0.44*nums[5]+nums[12])*timeRate/(teamNums[0]+0.44*teamNums[3]+teamNums[6]);
	

	data[24]=(raiseNum[0]/5-raiseNumUsed[0]/(playerDataList.size()-5))/(raiseNumUsed[0]/(playerDataList.size()-5));
	data[25]=(raiseNum[1]/5-raiseNumUsed[1]/(playerDataList.size()-5))/(raiseNumUsed[1]/(playerDataList.size()-5));
	data[26]=(raiseNum[2]/5-raiseNumUsed[2]/(playerDataList.size()-5))/(raiseNumUsed[2]/(playerDataList.size()-5));
	
	allData.setPlayerData(data);
	return allData;
}
//获取最近五场比赛的名字
private ArrayList<String> getRecentFiveMatches(){
	Set<String>keys=playerDataList.keySet();
	String matchnames[]=new String[keys.size()];
	int i=0;
	for(String key:keys){
		matchnames[i]=key;
		i++;
	}
	Arrays.sort(matchnames);
	ArrayList<String>names=new ArrayList<String>();
	for(int j=matchnames.length-1;j>matchnames.length-6;j--){
		names.add(matchnames[j]);
	}
	return names;
}
private String refreshTime(String teamTime1,String timeAdd){
	String s[]=teamTime1.split(":");
		String ss[]=timeAdd.split(":");

		int seconds=Integer.parseInt(ss[1])+Integer.parseInt(s[1]);
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
