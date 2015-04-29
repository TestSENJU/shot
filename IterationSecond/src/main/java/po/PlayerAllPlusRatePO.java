package po;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 * 
 * @author wyt
 * @param name
 * 球员姓名
 * @param teamList
 * 所属队伍的数组
 * @param teamAreaList
 * 所属队伍的联盟的数组
 * @param playingTime
 * 在场时间
 * @param competeNum
 * 参赛场数
 * @param offensiveNum
 * 先发场数
 * @param playerData
 *0篮板数
 *1助攻数
 *2投篮命中率
 *3三分命中率
 *4罚球命中率
 *5进攻数
 *6防守数
 *7抢断数
 *8盖帽数
 *9失误数
 *10犯规数
 *11得分
 *12效率
 *13GmSc效率值
 *14真实命中率
 *15投篮效率
 *16篮板率
 *17进攻篮板率
 *18防守篮板率
 *19助攻率
 *20抢断率
 *21盖帽率
 *22失误率
 *23使用率
 *24得分提升率
 *25篮板提升率
 *26助攻提升率
 */
public class PlayerAllPlusRatePO {
	private final String filename="teams";
String name;
private ArrayList<String>teamList=new ArrayList<String>();
private ArrayList<String> teamAreaList=new ArrayList<String>();
private String playingTime;// 在场时间
private int competeNum;// 参赛场数
private int offensiveNum;// 先发场数
private double [] playerData=new double[27];

public PlayerAllPlusRatePO(String playerName){
	this.name=playerName;
	this.competeNum=0;
	this.offensiveNum=0;
	this.playingTime="0:0";
	for(int i=0;i<playerData.length;i++){
		this.playerData[i]=0;
	}
}
public void addPlayingTime(String time){
	String s[]=this.playingTime.split(":");
	String ss[]=time.split(":");

	int seconds=Integer.parseInt(ss[1])+Integer.parseInt(s[1]);
	if(seconds<60){
		this.playingTime=(Integer.parseInt(ss[0])+Integer.parseInt(s[0])+"")
				+":"	+(seconds+"");	
	}else{
		this.playingTime=(Integer.parseInt(ss[0])+Integer.parseInt(s[0])+1+"")
				+":"	+(seconds-60+"");	
	}	
}
public void addCompeteNum(int num){
	this.competeNum+=num;
}
public void addOffensiveNum(int num){
	this.offensiveNum+=num;
}
public void addTeam(String team){
	this.teamList.add(team);
	this.teamAreaList.add(getTeamArea(team,filename));
}

public void setTeamList(ArrayList<String> teamList) {
	this.teamList = teamList;
}
public void setTeamAreaList(ArrayList<String> teamAreaList) {
	this.teamAreaList = teamAreaList;
}
public void setPlayingTime(String playingTime) {
	this.playingTime = playingTime;
}
@SuppressWarnings("resource")
private static String getTeamArea(String teamName,String path){
	if(teamName!=null){
		String result="";
		BufferedReader br;
			try {
				br = new BufferedReader(
							new InputStreamReader(new FileInputStream(path)));
				 String str;
				try {
					while((str=br.readLine())!=null){
						  if(str.contains(teamName)){
							  String strs[]=str.split("│");
							  result= strs[2]+"-"+strs[3];
							 
						  }
					   }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.print("io");
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.print("filenotfound");
			}
			return result;
	}else{
		return null;
	}
	
}
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
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

public void setCompeteNum(int competeNum) {
	this.competeNum = competeNum;
}

public int getOffensiveNum() {
	return offensiveNum;
}

public void setOffensiveNum(int offensiveNum) {
	this.offensiveNum = offensiveNum;
}

public double[] getPlayerData() {
	return playerData;
}

public void setPlayerData(double[] playerData) {
	this.playerData = playerData;
}

}
