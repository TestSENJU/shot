package Data;

import java.util.ArrayList;

import po.MatchPO;

/**
 * 
 * @author wyt
 * @category
 * getMatchByTime 根据13-14_01-01这样格式的时间查找比赛 13-14是赛季，01-01是日期
 * @category
 * getMatchByPlayer 根据球员名称查找比赛
 * @category
 * getMatchByTeam 根据球队名称查找比赛，注意是缩写
 */
public interface MatchDataService{

	public ArrayList<MatchPO> getMatchByTime(String time);
	
	public ArrayList<MatchPO> getMatchByPlayer(String playerName);
	
	public ArrayList<MatchPO> getMatchByTeam(String teamName);
	
}
