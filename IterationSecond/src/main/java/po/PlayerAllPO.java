package po;

import java.util.ArrayList;
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
	Set<String>keys=playerDataList.keySet();
	ArrayList<Integer>errorNumList=new ArrayList<Integer>();
	for(String key:keys){
		String strs[]=playerDataList.get(key);
		double [] nums=new double[]
		char c[]=strs[1].toCharArray();
		if(c[0]<='Z'&&c[0]>='A') allData.addOffensiveNum(1);
		
			for(int i=0;i<strs.length;i++){
				try{
					double
				}
				catch(NumberFormatException e){
			
			    }
		}
	}
	return allData;
}
public PlayerAveragePlusRatePO makeAveragePO(){
	PlayerAveragePlusRatePO averageData=new PlayerAveragePlusRatePO(this.name);
//    averageData.
	return averageData;
}

}
