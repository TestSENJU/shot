package po;
/**
 * 
 * @author wyt
 * @param teamName
 * 缩写名称
 * @param teamInfo
 * 0球队全名
 * 1所在地
 * 2 赛区
 * 3分区
 * 4主场
 * 5建立时间
 *
 */
public class TeamBasicPO {
String teamName;
private String usedName;
private String teamInfo[]=new String[6];
public TeamBasicPO(String teamName){
	this.teamName=teamName;
	for(int i=0;i<teamInfo.length;i++){
		teamInfo[i]="0";
	}
	
}
public void setTeamName(String name){
	this.teamName=name;
}
public String getUsedName() {
	return usedName;
}
public void setUsedName(String usedName) {
	this.usedName = usedName;
}
public String[] getTeamInfo() {
	return teamInfo;
}
public void setTeamInfo(String[] teamInfo) {
	this.teamInfo = teamInfo;
}

}
