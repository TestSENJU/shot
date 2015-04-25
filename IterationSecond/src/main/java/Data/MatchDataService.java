package Data;

import java.util.ArrayList;

import po.MatchPO;
import po.MatchShortPO;

/**
 * 
 * @author wyt
 * @category
 * getMatchByTime 根据13-14_01-01这样格式的时间查找比赛 13-14是赛季，01-01是日期
 * @category
 * getMatchByPlayer 根据球员名称查找比赛
 * @category
 * getMatchByTeam 根据球队名称查找比赛，注意是缩写
 * @category
 * getMatchNamesByTime 根据时间返回所有比赛的名字
 * @category
 * getMatchNamesByPlayer 根据球员返回所有比赛的名字
 * @category
 * getMatchNamesByTeam 根据球队返回所有比赛的名字
 * @category
 */
public interface MatchDataService{

	public ArrayList<MatchPO> getMatchByTime(String time);
	//根据球员名字返回比赛的ArrayList
	public ArrayList<MatchPO> getMatchByPlayer(String playerName);
	//根据球队缩写名字返回比赛的ArrayList
	public ArrayList<MatchPO> getMatchByTeam(String teamName);
	//根据比赛时间返回比赛
	public ArrayList<String> getMatchNamesByTime(String time);
	
	public ArrayList<String> getMatchNamesByPlayer(String name);
	
	public ArrayList<String> getMatchNamesByTeam(String name);
	//根据比赛名返回比赛的详细PO
	public MatchPO getMatchByName(String matchName);
	//根据时间段返回简略信息的比赛
	public ArrayList<MatchShortPO> getShortMatchByPeriod(String beigin,String end);
	//返回所有比赛的简略信息
	public ArrayList<MatchShortPO> getAllMatch();
	//根据球员名返回简略信息的最近五场比赛
	public ArrayList<MatchShortPO> getRecentShortMatchByPlayer(String playerName);
	//根据球队名返回简略信息的最近五场比赛
	public ArrayList<MatchShortPO> getRecentShortMatchByTeam(String teamName);

	
}
