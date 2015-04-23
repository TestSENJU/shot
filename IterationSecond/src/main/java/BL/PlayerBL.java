package BL;

import java.util.ArrayList;

import vo.PlayerAllVO;
import vo.PlayerAverageVO;
import vo.PlayerBasicVO;

public interface PlayerBL {
    //返回所有球员的名字，包括有基本信息的，还有在比赛中出现过的
	public ArrayList<String> getPlayerNames();
	//根据一个字符串返回球员的可能的名字
	public ArrayList<String> getPlayerNamesByStr(String str);
	//根据排序的依据数字返回球员场均数据VO的list
	public ArrayList<PlayerAverageVO>getTodayHotPlayerRankingByNum(int num);
	//根据排序的依据返回球员场均数据VO的list
	public ArrayList<PlayerAverageVO> getHotPlayerRankingByNum(int num);
	//根据排序的依据返回进步最快的球员VO的list
	public ArrayList<PlayerAverageVO>getMostImprovedPlayerByNum(int num);
	//返回所有球员的赛季总数居
	public ArrayList<PlayerAllVO> getPlayerAll();
	//返回所有球员赛季平均数据的list
	public ArrayList<PlayerAverageVO> getPlayerAverage();
	//返回所有球员的基本信息的VO
	public ArrayList<PlayerBasicVO> getPlayerBasic();
	//根据球员的名字返回球员的基本信息的VO 如果没有就返回null
	public PlayerBasicVO getPlayerBasicByName(String name);
	//根据球员的名字返回球员的赛季总数据
	public PlayerAllVO getPlayerAllByName(String name);
	//根据球员的名字返回球员的场均数据
	public PlayerAverageVO getPlayerAverageByName(String name);
	//根据排序依据的数字返回所有球员的总数据
	public ArrayList<PlayerAllVO> getPlayerAllRankingByNumRaising(int num);
	//根据排序依据的数字返回所有球员的平均数据
	public ArrayList<PlayerAverageVO> getPlayerAvergaeRankingByNumRaising(int num);
	
	public ArrayList<PlayerAllVO> getPlayerAllRankingByNumDeclining(int num);
	
	public ArrayList<PlayerAverageVO> getPlayerAvergaeRankingByNumDeclining(int num);
	
	public ArrayList<PlayerAllVO> getPlayerAllByLeague(String str);
	
	public ArrayList<PlayerAverageVO> getPlayerAverageByLeague(String str);
	
	public ArrayList<String> getPlayerNamesByBasic();
}
