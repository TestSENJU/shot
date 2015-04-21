package po;

import java.util.ArrayList;

/**
 * 
 * @author wyt
 * @param teamName
 * 球队名称缩写
 * @param teamNameLong
 * 球队全称
 * @param matchNum
 * 比赛场数
 * @param teamData
 * 那堆数据
 *
 */
public class TeamAveragePlusRatePO {
public String teamName;
private String teamNameLong;
private int matchNum;
private double[] teamData=new double[25];
private String usedName;
private String usedLongName;
private int winNum;
private ArrayList<String> playerList=new ArrayList<String>();
public TeamAveragePlusRatePO(String name){
	this.teamName=name;
	
}
public TeamAveragePlusRatePO(TeamAllPlusRatePO allData){
	this.teamName=allData.teamName;
	this.teamNameLong=allData.getTeamNameLong();
	this.usedLongName=allData.getUsedLongName();
	this.usedName=allData.getUsedName();
	this.playerList=allData.getPlayerList();
	this.matchNum=allData.getMatchNum();
	double nums[]=allData.getTeamData();
	this.winNum=0;
	for(int i=0;i<15;i++){
		this.teamData[i]=nums[i]/this.matchNum;
	}
	for(int i=15;i<25;i++){
		this.teamData[i]=nums[i];
	}
}
public void addWinNnum(int i){
	this.winNum+=i;
}
public int getWinNum() {
	return winNum;
}
public String getTeamNameLong() {
	return teamNameLong;
}
public void setTeamNameLong(String teamNameLong) {
	this.teamNameLong = teamNameLong;
}
public int getMatchNum() {
	return matchNum;
}
public void setMatchNum(int matchNum) {
	this.matchNum = matchNum;
}
public double[] getTeamData() {
	return teamData;
}
public void setTeamData(double[] teamData) {
	this.teamData = teamData;
}
public String getUsedName() {
	return usedName;
}
public void setUsedName(String usedName) {
	this.usedName = usedName;
}
public String getUsedLongName() {
	return usedLongName;
}
public void setUsedLongName(String usedLongName) {
	this.usedLongName = usedLongName;
}
public ArrayList<String> getPlayerList() {
	return playerList;
}
public void setPlayerList(ArrayList<String> playerList) {
	this.playerList = playerList;
}

}
