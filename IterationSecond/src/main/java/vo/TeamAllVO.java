package vo;

import java.util.ArrayList;

import po.TeamAllPlusRatePO;


public class TeamAllVO {
	String teamName;
	private String usedName;
	private String teamNameLong;
	private String usedLongName;
	private int matchNum;
	private int winNum;
	private double[] teamData=new double[25];
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
		this.teamData=po.getTeamData();
		this.playerList=po.getPlayerList();
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
