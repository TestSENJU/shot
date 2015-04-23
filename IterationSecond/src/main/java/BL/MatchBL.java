package BL;

import java.util.ArrayList;

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
	
	
}
