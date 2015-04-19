package po;
/**
 * 
 * @author wyt
 * @param teamName
 * 球队名称缩写
 * @param teamNameLong
 * 球队全称
 * @param matchNum
 * 比赛场数
 *  *@param teamData
 *0投篮命中数
 *1投篮出手次数
 *2三分命中数
 *3三分出手数
 *4罚球命中数
 *5罚球出手数
 *6进攻篮板
 *7防守篮板
 *8篮板数
 *9助攻数
 *10抢断数
 *11盖帽数
 *12失误数
 *13犯规数
 *14比赛得分
 *@param opponentData
 *0对手进攻篮板数
 *1对手防守篮板数
 *2对手得分
 *@param matchNum
 *@param usedName
 *
 */
public class TeamAllPlusRatePO {
String teamName;
private String usedName;
private String teamNameLong;
private String usedLongName;
private int matchNum;
private double[] teamData=new double[25];
public TeamAllPlusRatePO(){
	
}
public String getTeamName() {
	return teamName;
}
public void setTeamName(String teamName) {
	this.teamName = teamName;
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
public String getUsedLongName() {
	return usedLongName;
}
public void setUsedLongName(String usedLongName) {
	this.usedLongName = usedLongName;
}

}
