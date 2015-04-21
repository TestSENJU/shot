package BL;

import java.util.ArrayList;

import vo.MatchVO;

public interface MatchBL {

	public ArrayList<MatchVO> getMatchByPlayer(String player);
	
	public ArrayList<MatchVO> getMatchByTeam(String team);
	
	public ArrayList<MatchVO> getMatchByTime(String time);
	
}
