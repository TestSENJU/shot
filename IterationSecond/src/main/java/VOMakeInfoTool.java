import test.data.PlayerHighInfo;
import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;
import test.data.PlayerNormalInfo;
import test.data.TeamHighInfo;
import test.data.TeamHotInfo;
import test.data.TeamNormalInfo;
import vo.PlayerAllVO;
import vo.PlayerAverageVO;
import vo.PlayerBasicVO;
import vo.PlayerShortVO;
import vo.TeamAllVO;
import vo.TeamAverageVO;


public class VOMakeInfoTool {
	/**
	 * private double assistEfficient 
助攻率
private double blockShotEfficient 
盖帽率
private double defendReboundEfficient 
防守篮板率
private double faultEfficient 
失误率
private double frequency 
使用率
private double gmSc 
GmSc效率值
private java.lang.String league 
球员所属联盟
private java.lang.String name 
球员姓名（全称）
private double offendReboundEfficient 
进攻篮板率 
private java.lang.String position 
球员位置信息
private double realShot 
真实命中率
private double reboundEfficient 
篮板率
private static long serialVersionUID  
private double shotEfficient 
投篮效率 
private double stealEfficient 
抢断率 
private java.lang.String teamName 
球员所在球队名称 （缩写） 
	 */
public PlayerHighInfo getPlayerAllHigh(PlayerAllVO playerAll,PlayerBasicVO basic){
	PlayerHighInfo thePlayer = new PlayerHighInfo();
	double nums[]=playerAll.getPlayerData();
	thePlayer.setAssistEfficient(nums[19]);
	thePlayer.setBlockShotEfficient(nums[21]);
	thePlayer.setDefendReboundEfficient(nums[18]);
	thePlayer.setFaultEfficient(nums[22]);
	thePlayer.setFrequency(nums[23]);
	thePlayer.setGmSc(nums[13]);
	thePlayer.setLeague(playerAll.getTeamAreaList().get(playerAll.getTeamAreaList().size()-1));
	thePlayer.setName(playerAll.getPlayerName());
	thePlayer.setOffendReboundEfficient(nums[17]);
	thePlayer.setPosition(basic.getBasicInfo()[1]);
	thePlayer.setRealShot(nums[14]);
	thePlayer.setReboundEfficient(nums[16]);
	thePlayer.setShotEfficient(nums[15]);
	thePlayer.setStealEfficient(nums[20]);
	thePlayer.setTeamName(playerAll.getTeamList().get(playerAll.getTeamList().size()-1));
	return thePlayer;
}
public PlayerHighInfo getPlayerAverageHigh(PlayerAverageVO playerAverage,PlayerBasicVO basic){
	PlayerHighInfo thePlayer=new PlayerHighInfo();
	double nums[]=playerAverage.getPlayerData();
	thePlayer.setAssistEfficient(nums[19]);
	thePlayer.setBlockShotEfficient(nums[21]);
	thePlayer.setDefendReboundEfficient(nums[18]);
	thePlayer.setFaultEfficient(nums[22]);
	thePlayer.setFrequency(nums[23]);
	thePlayer.setGmSc(nums[13]);
	thePlayer.setLeague(playerAverage.getTeamAreaList().get(playerAverage.getTeamAreaList().size()-1));
	thePlayer.setName(playerAverage.getName());
	thePlayer.setOffendReboundEfficient(nums[17]);
	thePlayer.setPosition(basic.getBasicInfo()[1]);
	thePlayer.setRealShot(nums[14]);
	thePlayer.setReboundEfficient(nums[16]);
	thePlayer.setShotEfficient(nums[15]);
	thePlayer.setStealEfficient(nums[20]);
	thePlayer.setTeamName(playerAverage.getTeamList().get(playerAverage.getTeamList().size()-1));
	return thePlayer;
}
//TODO
public PlayerHotInfo getPlayerHot(PlayerAverageVO player){
	PlayerHotInfo thePlayer=new PlayerHotInfo();
	return thePlayer;
}
/**
 * private java.lang.String field 
数据王属性名
private java.lang.String name 
球员姓名（全名）
private java.lang.String position 
球员位置信息
private static long serialVersionUID  
private java.lang.String teamName 
球员所在球队名称（缩写）
private double value 
数据王属性对应的具体的值 

 */
public PlayerKingInfo getPlayerKingSeason(PlayerShortVO player,String field){
	PlayerKingInfo king=new PlayerKingInfo();
	king.setField(field);
	king.setName(player.getPlayerName());
	king.setPosition(player.getLocation());
	king.setTeamName(player.getTeam());
	king.setValue(player.getNum());
	return king;
}
public PlayerKingInfo getPlayerKingDay(PlayerShortVO player,String field){
	PlayerKingInfo king=new PlayerKingInfo();
	king.setField(field);
	king.setName(player.getPlayerName());
	king.setPosition(player.getLocation());
	king.setTeamName(player.getTeam());
	king.setValue(player.getNum());
	return king;
}
/**
 * private int age 
球员年龄 
private double assist 
助攻数
private double blockShot 
盖帽数 
private double defend 
防守数
private double efficiency 
效率
private double fault 
失误数 
private double foul 
犯规数 
private double minute 
上场时间数（单位：分钟） 
private java.lang.String name 
球员姓名（全名） 
private int numOfGame 
上场次数 
private double offend 
进攻数 
private double penalty 
投篮命中率
private double point 
得分 
private double rebound 
篮板数 
private static long serialVersionUID  
private double shot 
投篮命中率
private int start 
首发次数 
private double steal 
抢断数 
private java.lang.String teamName 
球队名称（缩写） 
private double three 
三分命中率 
 */
public PlayerNormalInfo getPlayerAllNormal(PlayerAllVO player,PlayerBasicVO basic){
	PlayerNormalInfo info=new PlayerNormalInfo();
	double [] nums=player.getPlayerData();
	info.setAge(Integer.parseInt(basic.getBasicInfo()[5]));
	info.setAssist(nums[1]);
	info.setBlockShot(nums[8]);
	info.setDefend(nums[6]);
	info.setEfficiency(nums[12]);
	info.setFault(nums[22]);
	info.setFoul(nums[10]);
	String time=player.getPlayingTime();
	String strs[]=time.split(":");
	info.setMinute(Double.parseDouble(strs[0])*60+Double.parseDouble(strs[1]));
	info.setName(player.getPlayerName());
	info.setNumOfGame(player.getCompeteNum());
	info.setOffend(nums[5]);
	info.setPenalty(nums[4]);
	info.setPoint(nums[11]);
	info.setRebound(nums[0]);
	info.setShot(nums[2]);
	info.setStart(player.getOffensiveNum());
	info.setSteal(nums[7]);
	info.setTeamName(player.getTeamList().get(player.getTeamList().size()-1));
	info.setThree(nums[3]);
	return info;
}
public PlayerNormalInfo getPlayerAverageNormal(PlayerAverageVO player,PlayerBasicVO basic){
	PlayerNormalInfo info=new PlayerNormalInfo();
	double [] nums=player.getPlayerData();
	info.setAge(Integer.parseInt(basic.getBasicInfo()[5]));
	info.setAssist(nums[1]);
	info.setBlockShot(nums[8]);
	info.setDefend(nums[6]);
	info.setEfficiency(nums[12]);
	info.setFault(nums[22]);
	info.setFoul(nums[10]);
	String time=player.getPlayingTime();
	String strs[]=time.split(":");
	info.setMinute(Double.parseDouble(strs[0])*60+Double.parseDouble(strs[1]));
	info.setName(player.getName());
	info.setNumOfGame(player.getCompeteNum());
	info.setOffend(nums[5]);
	info.setPenalty(nums[4]);
	info.setPoint(nums[11]);
	info.setRebound(nums[0]);
	info.setShot(nums[2]);
	info.setStart(player.getOffensiveNum());
	info.setSteal(nums[7]);
	info.setTeamName(player.getTeamList().get(player.getTeamList().size()-1));
	info.setThree(nums[3]);
	return info;
}
/**
 * private double assistEfficient 
助攻效率 
private double defendEfficient 
防守效率
private double defendReboundEfficient 
防守篮板效率
private double offendEfficient 
进攻效率
private double offendReboundEfficient 
进攻篮板效率
private double offendRound 
进攻回合数 
private static long serialVersionUID  
private double stealEfficient 
抢断效率 
private java.lang.String teamName 
球队名称（缩写） 
private double winRate 
胜率 
 */
public TeamHighInfo getTeamHigh(TeamAverageVO average){
	TeamHighInfo info=new TeamHighInfo();
	double nums[]=average.getTeamData();
	info.setAssistEfficient(nums[24]);
	info.setDefendEfficient(nums[21]);
	info.setDefendReboundEfficient(nums[25]);
	info.setOffendEfficient(nums[20]);
	info.setOffendReboundEfficient(nums[26]);
	info.setOffendRound(nums[19]);
	info.setStealEfficient(nums[23]);
	info.setTeamName(average.getTeamName());
	info.setWinRate(nums[18]);
	return info;
}
public TeamHighInfo geTeamHighByAll(TeamAllVO all){
	TeamHighInfo info=new TeamHighInfo();
	double nums[]=all.getTeamData();
	info.setAssistEfficient(nums[24]);
	info.setDefendEfficient(nums[21]);
	info.setDefendReboundEfficient(nums[25]);
	info.setOffendEfficient(nums[20]);
	info.setOffendReboundEfficient(nums[26]);
	info.setOffendRound(nums[19]);
	info.setStealEfficient(nums[23]);
	info.setTeamName(all.getTeamName());
	info.setWinRate(nums[18]);
	return info;
}
/**
 * private java.lang.String field 
热门球队的热门属性
private java.lang.String league 
球队所在联盟 
private static long serialVersionUID  
private java.lang.String teamName 
球队名称（缩写）
private double value 
热门属性具体的值 
 */
public TeamHotInfo getTeamHot(TeamAverageVO average,int i,String league,String field){
	TeamHotInfo team=new TeamHotInfo();
	team.setField(field);
	team.setLeague(league);
	team.setTeamName(average.getTeamName());
	team.setValue(average.getTeamData()[i]);
	return team;
}
/**
 * private double assist 
助攻数 
private double blockShot 
盖帽数
private double defendRebound 
防守篮板数
private double fault 
失误数
private double foul 
犯规数 
private int numOfGame 
比赛场数 
private double offendRebound 
进攻篮板数 
private double penalty 
罚球命中率
private double point 
得分 
private double rebound 
篮板数
private static long serialVersionUID  
private double shot 
投篮命中率
private double steal 
抢断数
private java.lang.String teamName 
球队名称
private double three 
三分命中率 
 */
public TeamNormalInfo getTeamAllNormal(TeamAllVO all){
	TeamNormalInfo team=new TeamNormalInfo();
	double [] nums=all.getTeamData();
	team.setAssist(nums[9]);
	team.setBlockShot(nums[11]);
	team.setDefendRebound(nums[7]);
	team.setFault(nums[12]);
	team.setFoul(nums[13]);
	team.setNumOfGame(all.getMatchNum());
	team.setOffendRebound(nums[6]);
	team.setPenalty(nums[17]);
	team.setPoint(nums[14]);
	team.setRebound(nums[8]);
	team.setShot(nums[15]);
	team.setSteal(nums[10]);
	team.setTeamName(all.getTeamName());
	team.setThree(nums[16]);
	return team;
}
public TeamNormalInfo getTeamAverageNormal(TeamAverageVO average){
	TeamNormalInfo team=new TeamNormalInfo();
	double [] nums=average.getTeamData();
	team.setAssist(nums[9]);
	team.setBlockShot(nums[11]);
	team.setDefendRebound(nums[7]);
	team.setFault(nums[12]);
	team.setFoul(nums[13]);
	team.setNumOfGame(average.getMatchNum());
	team.setOffendRebound(nums[6]);
	team.setPenalty(nums[17]);
	team.setPoint(nums[14]);
	team.setRebound(nums[8]);
	team.setShot(nums[15]);
	team.setSteal(nums[10]);
	team.setTeamName(average.getTeamName());
	team.setThree(nums[16]);
	return team;
}
}
