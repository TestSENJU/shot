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
 *  *@param teamData
 *  0投篮命中数
 *  1投篮出手数
 *  2三分命中数
 *  3三分出手数
 *  4罚球命中数
 *  5罚球出手数
 *  6进攻前场篮板数
 *  7进攻后场篮板数
 *  8总篮板数
 *  9助攻数
 *  10抢断数
 *  11盖帽数
 *  12失误数
 *  13犯规数
 *  14个人得分
 *  15投篮命中率
 *  16三分命中率
 *  17罚球命中率
 *  18胜率
 *  19进攻回合
 *  20进攻效率
 *  21防守效率
 *  22篮板效率
 *  23抢断效率
 *  24助攻率
 *@param matchNum
 *@param usedName
 *@param usedLongName
 *@param playerList
 *
 */
public class TeamAllPlusRatePO {
String teamName;
private String usedName;
private String teamNameLong;
private String usedLongName;
private int matchNum;
private int winNum;
private double[] teamData=new double[25];
private ArrayList<String> playerList=new ArrayList<String>();
public TeamAllPlusRatePO(String name){
	this.teamName=name;
	this.teamNameLong=getLongName(name);
	this.matchNum=0;
	this.winNum=0;
	for(int i=0;i<teamData.length;i++){
		teamData[i]=0;
	}
}
public void addWinNum(int i){
	this.winNum+=i;
}
public int getWinNum() {
	return winNum;
}

public void setWinNum(int winNum) {
	this.winNum = winNum;
}
private String getLongName(String shortName){
	try {
		@SuppressWarnings("resource")
		BufferedReader br=new BufferedReader(new FileReader("teams"));
	    String str="";
	    while((str=br.readLine())!=null){
	    	String strs[]=str.split("|");
	    	if(strs[1].equals(shortName)){
	    		return strs[0];
	    	}
	    }
	    if(shortName.equals("NOH")){return "Pelicans";}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("teamDataImpl getTeamName filenotfound");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("teamDataImpl getTeamName ioexception");
	}
	
	return null;
}
public ArrayList<String> getPlayerList(){
	return this.playerList;
}
public void setPlayerList(ArrayList<String>namelist){
	this.playerList=namelist;
}

public int getMatchNum() {
	return matchNum;
}
public void setMatchNum(int matchNum) {
	this.matchNum = matchNum;
}
public String getTeamName() {
	return teamName;
}
public void setTeamName(String teamName) {
	this.teamName = teamName;
}
public String getUsedName() {
	return usedName;
}
public void setUsedName(String usedName) {
	this.usedName = usedName;
}
public String getTeamNameLong() {
	return teamNameLong;
}
public void setTeamNameLong(String teamNameLong) {
	this.teamNameLong = teamNameLong;
}
public double[] getTeamData() {
	return teamData;
}
public void setTeamData(double[] teamData) {
	this.teamData = teamData;
}
public String getUsedLongName() {
	return usedLongName;
}
public void setUsedLongName(String usedLongName) {
	this.usedLongName = usedLongName;
}

}
