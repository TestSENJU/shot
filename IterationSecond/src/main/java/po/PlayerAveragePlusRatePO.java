package po;

import java.util.ArrayList;

public class PlayerAveragePlusRatePO {
	String name;
	private ArrayList<String> teamList=new ArrayList<String>();
	private ArrayList<String> teamAreaList=new ArrayList<String>();
	private String playingTime;
	private int competeNum;
	private int offensiveNum;
	private double[] playerData=new double[27];
	
public PlayerAveragePlusRatePO(String playerName){
	this.name=playerName;
	this.competeNum=0;
	this.offensiveNum=0;
	this.playingTime="0:0";
	for(int i=0;i<playerData.length;i++){
		this.playerData[i]=0;
	}
}
public PlayerAveragePlusRatePO(PlayerAllPlusRatePO allpo){
	this.teamList=allpo.getTeamAreaList();
	this.teamList=allpo.getTeamList();
	this.competeNum=allpo.getCompeteNum();
	this.offensiveNum=allpo.getOffensiveNum();
	String allTime=allpo.getPlayingTime();
	String strs[]=allTime.split(":");
	int hour=Integer.parseInt(strs[0])/competeNum;
	
	strs[1]=Integer.parseInt(strs[1])+Integer.parseInt(strs[0])%competeNum*60+"";
	strs[0]=hour+"";
	this.playingTime=strs[0]+":"+strs[1];
	double allData[]=allpo.getPlayerData();
	
	double[] averageData=new double[27];
	averageData[0]=allData[0]/this.competeNum;
	averageData[1]=allData[1]/this.competeNum;
	averageData[2]=allData[2];
	averageData[3]=allData[3];
	averageData[4]=allData[4];
	for(int i=5;i<=11;i++){
		averageData[i]=allData[i]/this.competeNum;
	}
	for(int i=12;i<27;i++){
		averageData[0]=allData[0];
	}	
	this.playerData=averageData;
}

public String getName() {
	return name;
}
public ArrayList<String> getTeamList() {
	return teamList;
}
public ArrayList<String> getTeamAreaList() {
	return teamAreaList;
}
public String getPlayingTime() {
	return playingTime;
}
public int getCompeteNum() {
	return competeNum;
}
public int getOffensiveNum() {
	return offensiveNum;
}
public double[] getPlayerData() {
	return playerData;
}

}
