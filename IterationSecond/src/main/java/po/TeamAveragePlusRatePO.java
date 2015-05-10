package po;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
private String league;
private double[] teamData=new double[27];
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
	for(int i=15;i<27;i++){
		this.teamData[i]=nums[i];
	}
	this.league=getTeamLeague(this.teamName);
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
@SuppressWarnings("resource")
private String getTeamLeague(String teamname){
	BufferedReader br;
	try {
		br = new BufferedReader(new FileReader("teams"));
	    String str="";
	    if(teamname.equals("NOH"))teamname="NOP";
	    while((str=br.readLine())!=null){
	    	if(str.contains(teamname)){
					String mass[]=str.split("║");
					String strs[]=mass[1].split("│");
	    		return strs[3];
	    	}
}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
return null;
}
public String getLeague() {
	return league;
}
public void setLeague(String league) {
	this.league = league;
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
