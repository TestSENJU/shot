package vo;

import java.util.ArrayList;

import po.PlayerAveragePlusRatePO;

public class PlayerAverageVO {
	String name;	//球员名
	//球员所在过的球队名
	private ArrayList<String> teamList=new ArrayList<String>();
	//球员所在的球队所属的联盟
	private ArrayList<String> teamAreaList=new ArrayList<String>();
	// 在场时间
	private String playingTime;
	// 参赛场数
	private int competeNum;
	// 先发场数
	private int offensiveNum;
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
	* *24得分提升率
 *25篮板提升率
 *26助攻提升率
	*/
	private double[] playerData=new double[27];
	public PlayerAverageVO(String playerName){
		this.name=playerName;
	}
	public String getName() {
		return name;
	}
	public PlayerAverageVO(PlayerAveragePlusRatePO po){
		this.name=po.getName();
		this.teamAreaList=po.getTeamAreaList();
		this.teamList=po.getTeamList();
		this.playingTime=po.getPlayingTime();
		this.competeNum=po.getCompeteNum();
		this.offensiveNum=po.getOffensiveNum();
		for(int i=0;i<this.playerData.length;i++){
			this.playerData[i]=(double)Math.round(po.getPlayerData()[i]*10)/100;
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
