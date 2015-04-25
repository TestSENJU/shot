package BL;

import java.util.ArrayList;

import vo.MatchShortVO;
import vo.MatchVO;

public interface MatchBL {
    //根据球员名字返回比赛VO的ArrayList
	public ArrayList<MatchVO> getMatchByPlayer(String player);
	//根据球队缩写名字返回比赛Vo的ArrayList
	public ArrayList<MatchVO> getMatchByTeam(String team);
	//根据比赛时间返回比赛VO的list time的格式应该是12-13_01-01这样的
	public ArrayList<MatchVO> getMatchByTime(String time);
	//根据球员名返回球员最近的五场比赛
	public ArrayList<MatchVO> getRecentMatchByPlayer(String playerName);
	//根据球队名返回球队最近的五场比赛
	public ArrayList<MatchVO> getRecentMatchByTeam(String teamName);
	//根据球队名返回简略信息的最近五场比赛
	public ArrayList<MatchShortVO> getRecentShortMatchByTeam(String teamName);
	//根据球员名返回简略信息的最近五场比赛
	public ArrayList<MatchShortVO> getRecentShortMatchByPlayer(String playerName);
    //根据时间段返回简略信息的比赛
	public ArrayList<MatchShortVO> getShortMatchByPeriod(String beginTime,String endTime);
	//返回所有比赛的简略信息
	public ArrayList<MatchShortVO> getAllMatch();
	//根据比赛名返回比赛的详细VO
	public MatchVO getMatchByName(String name);
	
}
