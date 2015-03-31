package po;

import java.io.Serializable;

/**
 * 
 * @author wyt
 * 
 * @param timeAll
 *   总上场时间
 *   
 *   @param numOfFirstMatches
 *   总先发场数
 *   
 *  @param   numOfMatches
 *  总参赛场数
 *  @param team ,teamArea
 *  队伍，联盟
 *  @param scoresAll
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
 *
 */

public class Player_AllScorePO implements Serializable{


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//总数据
	String playerName;
	private String team;
	private String teamArea;
	private String timeAll;//上场时间
	private int numOfFirstMatches;//先发场数
	private int numOfMatches;//参赛场数
	private double scoresAll[]=new double[15];
	
	public Player_AllScorePO(String playername){
		this.playerName=playername;
		this.team=null;
		this.timeAll="0:0";
		this.teamArea="0";
		this.numOfFirstMatches=0;
		this.numOfMatches=0;
		for(int i=0;i<scoresAll.length;i++){
			this.scoresAll[i]=0;
		}
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	
	public String getTeamArea() {
		return teamArea;
	}
	public void setTeamArea(String teamArea) {
		this.teamArea = teamArea;
	}
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public void addnumOfMatches(int num){
		this.numOfMatches+=num;
	}
	public void addnumOfFirstMatches(int num){
		this.numOfFirstMatches+=num;
	}
	public int getNumOfFirstMatches() {
		return numOfFirstMatches;
	}

	public void setNumOfFirstMatches(int numOfFirstMatches) {
		this.numOfFirstMatches = numOfFirstMatches;
	}

	public int getNumOfMatches() {
		return numOfMatches;
	}

	public void setNumOfMatches(int numOfMatches) {
		this.numOfMatches = numOfMatches;
	}
	public String getTimeAll() {
		return timeAll;
	}
	public void setTimeAll(String timeAll) {
		this.timeAll = timeAll;
	}
	//TODO
	public void addTimeAll(String timeAllAdd){
		String strs[]=timeAllAdd.split(":");
		String ss[]=this.timeAll.split(":");

		int seconds=Integer.parseInt(ss[1])+Integer.parseInt(strs[1]);
		if(seconds<60){
			this.timeAll=(Integer.parseInt(ss[0])+Integer.parseInt(strs[0])+"")
					+":"	+(seconds+"");	
		}else{
			this.timeAll=(Integer.parseInt(ss[0])+Integer.parseInt(strs[0])+1+"")
					+":"	+(seconds-60+"");	
		}
	}

	public void addAllScore(double[] s){
		
			for(int i=0;i<s.length;i++){
				this.scoresAll[i]+=s[i];
			}
		}

	public double[] getScoresAll() {
		return scoresAll;
	}
	public void setScoresAll(double[] scoresAll) {
		this.scoresAll = scoresAll;
	}
}
