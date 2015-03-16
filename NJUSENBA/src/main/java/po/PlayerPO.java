package po;


import java.util.ArrayList;

public class PlayerPO {

	String name;//球员名称
	private String team;//当前球员所属队伍
	private ArrayList<String> teams;//球员曾经所属的队伍
	private String area;//所属联盟	
	private String[] basicInfo=new String[8];//球员基本信息，可以从player文件夹中读取的内容
	private Player_AllScorePO scoresInAll;//赛季总数据
	private Player_AverageScorePO scoresAverage;//平均数据
    
	public ArrayList<String> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<String> teams) {
		this.teams = teams;
	}

	public String[] getBasicInfo() {
		return basicInfo;
	}

	public void setBasicInfo(String[] basicInfo) {
		this.basicInfo = basicInfo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Player_AllScorePO getScoresInAll() {
		return scoresInAll;
	}

	public void setScoresInAll(Player_AllScorePO scoresInAll) {
		this.scoresInAll = scoresInAll;
	}


	public Player_AverageScorePO getScoresAverage() {
		return scoresAverage;
	}

	public void setScoresAverage(Player_AverageScorePO scoresAverage) {
		this.scoresAverage = scoresAverage;
	}
    
}
