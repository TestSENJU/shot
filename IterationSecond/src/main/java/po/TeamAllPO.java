package po;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author wyt
 * 这个类对于BL来说是不可见的

 */
public class TeamAllPO {
String teamName;

private HashMap<String,double[]>teamDataList=new HashMap<String,double[]>();
private HashMap<String,double[]>opponentDataList=new HashMap<String,double[]>();
private ArrayList<String> winMatchNum=new ArrayList<String>();

public TeamAllPO(String name){
	this.teamName=name;
}
public void addTeamData(String matchName,double[]teamData){
	this.teamDataList.put(matchName, teamData);
}
public void addOpponentData(String matchName,double[]opponentData){
	this.opponentDataList.put(matchName, opponentData);
}
public void addWinMatchNum(String matchName){
	this.winMatchNum.add(matchName);
}
public TeamAllPlusRatePO makeDetailedAllPO(){
	TeamAllPlusRatePO allData=new TeamAllPlusRatePO();
	
	return allData;
}
public TeamAveragePlusRatePO makeAveragePO(){
	TeamAveragePlusRatePO averageData=new TeamAveragePlusRatePO();
	
	return averageData;
}
}
