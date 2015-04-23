package vo;

import java.util.ArrayList;

import po.PlayerAllPlusRatePO;

public class PlayerAllVO {
	//球员名
String playerName;
//球员所在过的球队名
private ArrayList<String>teamList=new ArrayList<String>();
//球员所在的球队所属的联盟
private ArrayList<String> teamAreaList=new ArrayList<String>();
private String playingTime;// 在场时间
private int competeNum;// 参赛场数
private int offensiveNum;// 先发场数
/*0篮板数
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
private double [] playerData=new double[27];
public PlayerAllVO(String name){
	this.playerName=name;
}
public PlayerAllVO(PlayerAllPlusRatePO po){
	this.playerName=po.getName();
	this.teamList=po.getTeamList();
	this.teamAreaList=po.getTeamAreaList();
	this.playingTime=po.getPlayingTime();
	this.competeNum=po.getCompeteNum();
	this.offensiveNum=po.getOffensiveNum();
	this.playerData=po.getPlayerData();

}

public String getPlayerName() {
	return playerName;
}
public ArrayList<String> getTeamList() {
	return teamList;
}
public void setTeamList(ArrayList<String> teamList) {
	this.teamList = teamList;
}
public ArrayList<String> getTeamAreaList() {
	return teamAreaList;
}
public void setTeamAreaList(ArrayList<String> teamAreaList) {
	this.teamAreaList = teamAreaList;
}
public String getPlayingTime() {
	return playingTime;
}
public void setPlayingTime(String playingTime) {
	this.playingTime = playingTime;
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
