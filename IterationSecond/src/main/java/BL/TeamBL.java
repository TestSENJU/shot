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
	public TeamAllVO getTeamAllByName(String name);
	//根据排序依据的数字返回升序的所有的赛季总数据
	/**
	 * 
	 * @param num
	 * 0-24数组里的那堆
	 * 25比赛场数
	 * @return
	 */
	public ArrayList<TeamAllVO> getTeamAllRankingByNumRaising(ArrayList<Integer>nums,int many);
	//根据排序的依据返回升序的球队的所有的场均数据 raising
	public ArrayList<TeamAverageVO> getTeamAverageRankingByNum(ArrayList<Integer>nums,int many);
	///根据排序依据返回热点球队的五个球队的场均数据
	/*
	 *  *  0投篮命中数
 *  1投篮出手数
 *  2三分命中数
 *  3三分出手数
 *  4罚球命中数
 *  5罚球出手数
 *  6进攻前场篮板数
 *  7进攻后场篮板数
 *  8总篮板数
 *  9助攻数
 *  10抢断数
 *  11盖帽数
 *  12失误数
 *  13犯规数
 *  14个人得分
 *  15投篮命中率
 *  16三分命中率
 *  17罚球命中率
 *  18胜率
 *  19进攻回合
 *  20进攻效率
 *  21防守效率
 *  22篮板效率
 *  23抢断效率
 *  24助攻率
	 */
	public ArrayList<TeamAverageVO> getHotTeamByNum(ArrayList<Integer>nums,int many);
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
	
	public ArrayList<TeamAllVO> getTeamAllRankingByNumDeclining(ArrayList<Integer>nums,int many);
	
	public ArrayList<TeamAverageVO> getTeamAverageRankingByNumDeclining(ArrayList<Integer>nums,int many);

	public String getShortName(String longName);
	
	public String getLleague(String shortName);
}
