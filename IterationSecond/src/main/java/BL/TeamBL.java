package BL;

import java.util.ArrayList;

import vo.TeamAllVO;
import vo.TeamAverageVO;
import vo.TeamBasicVO;

public interface TeamBL {

	public ArrayList<TeamAllVO> getTeamAll();
	
	public ArrayList<TeamAverageVO> getTeamAverage();
	
	public ArrayList<TeamBasicVO>getTeamBasic();
	
	public TeamBasicVO getTeamBasicByName(String name);
	
	public TeamAverageVO getTeamAverageByName(String name);
	
	public TeamAllVO getTeamAllByName(String name);
	
	public ArrayList<TeamAllVO> getTeamAllRankingByNum(int num);
	
	public ArrayList<TeamAverageVO> getTeamAverageRankingByNum(int num);
	
	public ArrayList<TeamAverageVO> getHotTeamByNum(int num);
	
	public String getLongNameByShortName(String shortName);
	
	public ArrayList<String> getTeamNamesByStr(String str);
	
	public ArrayList<String> getLongTeamNames();
	
	public ArrayList<String> getTeamNames();
	
	public ArrayList<String> getPlayerNamesOfTeam(String teamName);
	
}
