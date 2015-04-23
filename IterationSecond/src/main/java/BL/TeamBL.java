package BL;

import java.util.ArrayList;

import vo.TeamAllVO;
import vo.TeamAverageVO;
import vo.TeamBasicVO;

public interface TeamBL {
    //返回所有球队的赛季总数据
	public ArrayList<TeamAllVO> getTeamAll();
	//返回所有球队的场均数据
	public ArrayList<TeamAverageVO> getTeamAverage();
	//返回所有球队的基本信息
	public ArrayList<TeamBasicVO>getTeamBasic();
	//根据球队的缩写名返回球队的基本信息
	public TeamBasicVO getTeamBasicByName(String name);
	//根据球队的缩写名返回球队的场均数据
	public TeamAverageVO getTeamAverageByName(String name);
	//根据球队的缩写名返回球队的总数居
	public TeamAllVO getTeamAllByNameRaising(String name);
	//根据排序依据的数字返回升序的所有的赛季总数据
	public ArrayList<TeamAllVO> getTeamAllRankingByNumRaising(int num);
	//根据排序的依据返回升序的球队的所有的场均数据
	public ArrayList<TeamAverageVO> getTeamAverageRankingByNum(int num);
	///根据排序依据返回热点球队的五个球队的场均数据
	public ArrayList<TeamAverageVO> getHotTeamByNum(int num);
	//根据缩写名返回全名
	public String getLongNameByShortName(String shortName);
	//根据字符串返回接近的球队缩写名
	public ArrayList<String> getTeamNamesByStr(String str);
	//返回所有球队的全名
	public ArrayList<String> getLongTeamNames();
	//返回所有球队的缩写名
	public ArrayList<String> getTeamNames();
	//根据球队名返回这个球队的球员名字
	public ArrayList<String> getPlayerNamesOfTeam(String teamName);
	
	public ArrayList<TeamAllVO> getTeamAllRankingByNumDeclining(int num);
	
	public ArrayList<TeamAverageVO> getTeamAverageRankingByNumDeclining(int num);
}
