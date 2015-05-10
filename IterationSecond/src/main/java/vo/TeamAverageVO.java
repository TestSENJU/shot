package vo;

import java.util.ArrayList;

import po.TeamAveragePlusRatePO;

public class TeamAverageVO {
	String teamName;//球队缩写名
	private String teamNameLong;//球队的全名
	private int matchNum;//球队参加比赛的数量
	private String league;
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
 *  25进攻
 *  26防守
	 */
	private double[] teamData=new double[25];
	private String usedName;//球队曾经用过的缩写名
	private String usedLongName;//球队的曾经使用过的全名
	private int winNum;//球队比赛胜利的数量
	//球队的球员名字
	private ArrayList<String> playerList=new ArrayList<String>();
	public TeamAverageVO(String name){
		this.teamName=name;
	}
	public TeamAverageVO(TeamAveragePlusRatePO po){
		for(int i=0;i<this.teamData.length;i++){
			this.teamData[i]=(double)Math.round(po.getTeamData()[i]*10)/10;
		}
		this.matchNum=po.getMatchNum();
		this.playerList=po.getPlayerList();
		this.teamName=po.teamName;
		this.teamNameLong=po.getTeamNameLong();
		this.usedLongName=po.getUsedLongName();
		this.usedName=po.getUsedName();
		this.winNum=po.getWinNum();
		this.league=po.getLeague();
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
	public String getTeamName() {
		return teamName;
	}
	public void setMatchNum(int matchNum) {
		this.matchNum = matchNum;
	}
	public double[] getTeamData() {
		return teamData;
	}
	
	public String getLeague() {
		return league;
	}
	public void setLeague(String league) {
		this.league = league;
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
	public int getWinNum() {
		return winNum;
	}
	public void setWinNum(int winNum) {
		this.winNum = winNum;
	}
	public ArrayList<String> getPlayerList() {
		return playerList;
	}
	public void setPlayerList(ArrayList<String> playerList) {
		this.playerList = playerList;
	}
	
}
