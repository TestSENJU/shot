package vo;

import java.util.ArrayList;

import po.TeamAllPlusRatePO;


public class TeamAllVO {
	String teamName;//球队缩写名
	private String usedName;//球队曾经用过的缩写名
	private String teamNameLong;//球队的全名
	private String usedLongName;//球队的曾经使用过的全名
	int matchNum;//球队参加比赛的数量
	/*
	 *  *  0投篮命中数
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
	 */
	private int winNum;//球队比赛胜利的数量
	
	private double[] teamData=new double[25];
	//球队的球员名字
	private ArrayList<String> playerList=new ArrayList<String>();
	public TeamAllVO(String name){
		this.teamName=name;
	}
	public TeamAllVO(TeamAllPlusRatePO po){
		this.teamName=po.getTeamName();
		this.usedName=po.getUsedName();
		this.usedLongName=po.getUsedLongName();
		this.teamNameLong=po.getTeamNameLong();
		this.matchNum=po.getMatchNum();
		this.winNum=po.getWinNum();
		for(int i=0;i<this.teamData.length;i++){
			this.teamData[i]=(double)Math.round(po.getTeamData()[i]*10)/10;
		}
		this.playerList=po.getPlayerList();
	}
	public String getUsedName() {
		return usedName;
	}
	public String getTeamName() {
		return teamName;
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
	public String getUsedLongName() {
		return usedLongName;
	}
	public void setUsedLongName(String usedLongName) {
		this.usedLongName = usedLongName;
	}
	public int getMatchNum() {
		return matchNum;
	}
	public void setMatchNum(int matchNum) {
		this.matchNum = matchNum;
	}
	public int getWinNum() {
		return winNum;
	}
	public void setWinNum(int winNum) {
		this.winNum = winNum;
	}
	public double[] getTeamData() {
		return teamData;
	}
	public void setTeamData(double[] teamData) {
		this.teamData = teamData;
	}
	public ArrayList<String> getPlayerList() {
		return playerList;
	}
	public void setPlayerList(ArrayList<String> playerList) {
		this.playerList = playerList;
	}
	
}
