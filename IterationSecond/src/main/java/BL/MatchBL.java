package BL;

import java.util.ArrayList;

import vo.MatchVO;

public interface MatchBL {

	public ArrayList<String> getMatchByPlayer(String player);
	
	public ArrayList<String> getMatchByTeam(String team);
	
	public ArrayList<String> getMatchByTime(String time);
//	
//	public MatchVO getMatchByName(String name);
	
}
