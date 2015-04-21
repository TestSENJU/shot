package vo;

import java.util.ArrayList;

import po.TeamAveragePlusRatePO;

public class TeamAverageVO {
	String teamName;
	private String teamNameLong;
	private int matchNum;
	private double[] teamData=new double[25];
	private String usedName;
	private String usedLongName;
	private int winNum;
	private ArrayList<String> playerList=new ArrayList<String>();
	public TeamAverageVO(String name){
		this.teamName=name;
	}
	public TeamAverageVO(TeamAveragePlusRatePO po){
		this.teamData=po.getTeamData();
		this.matchNum=po.getMatchNum();
		this.playerList=po.getPlayerList();
		this.teamName=po.teamName;
		this.teamNameLong=po.getTeamNameLong();
		this.usedLongName=po.getUsedLongName();
		this.usedName=po.getUsedName();
		this.winNum=po.getWinNum();
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
