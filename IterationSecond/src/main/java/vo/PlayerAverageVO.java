package vo;

import java.util.ArrayList;

import po.PlayerAveragePlusRatePO;

public class PlayerAverageVO {
	String name;
	private ArrayList<String> teamList=new ArrayList<String>();
	private ArrayList<String> teamAreaList=new ArrayList<String>();
	private String playingTime;
	private int competeNum;
	private int offensiveNum;
	private double[] playerData=new double[24];
	public PlayerAverageVO(String playerName){
		this.name=playerName;
	}
	public PlayerAverageVO(PlayerAveragePlusRatePO po){
		this.name=po.getName();
		this.teamAreaList=po.getTeamAreaList();
		this.teamList=po.getTeamList();
		this.playingTime=po.getPlayingTime();
		this.competeNum=po.getCompeteNum();
		this.offensiveNum=po.getOffensiveNum();
		double []nums=po.getPlayerData();
		for(int i=0;i<this.playerData.length;i++){
			this.playerData[i]=nums[i];
		}
		
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
