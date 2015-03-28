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
 *  @param team 
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
 *  10盖帽数
 *  11失误数
 *  12犯规数
 *  13个人得分
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
	private double scoresAll[]=new double[14];
	
	public Player_AllScorePO(String playername){
		this.playerName=playername;
		this.team="0";
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
	/**
	 * 
	 * @param time
	 * 错误逻辑检测时间，检查是不是符合格式
	 * @param s
	 * 错误检查是不是每个都可以变成整型
	 * @return
	 */
	public boolean checkData(String time,String[] s){
		boolean right=true;
		String ss[]=time.split(":");
		if(ss.length!=2)right=false;
		 int nums[]=new int[14];
		for(int i=0;i<s.length;i++){
			int num;
			try {
				num = Integer.parseInt(s[i]);
				nums[i]=num;
		        i++;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				right=false;
			}
	        
//要是格式不对了直接就返回不加这次比赛里的这一行了
 }

		 if(nums[0]>nums[1]||nums[2]>nums[3]||
				 nums[4]>nums[5]||nums[6]+nums[7]!=nums[8]){
			 right=false;
		 }
		return right;
	}
	public void addAllScore(String strs[]){
		 int nums[]=new int[14];
		 int j=0;
		 
		 for(int i=0;i<scoresAll.length;i++){
				int num=Integer.parseInt(strs[i]);
		        nums[j]=num;
		        j++;
//要是格式不对了直接就返回不加这次比赛里的这一行了
	 }
			for(int i=0;i<nums.length;i++){
				scoresAll[i]+=nums[i];
			}
		}

	public double[] getScoresAll() {
		return scoresAll;
	}
	public void setScoresAll(double[] scoresAll) {
		this.scoresAll = scoresAll;
	}
}
