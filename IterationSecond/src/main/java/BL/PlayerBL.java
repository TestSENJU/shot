package BL;

import java.util.ArrayList;

import vo.PlayerAllVO;
import vo.PlayerAverageVO;
import vo.PlayerBasicVO;
import vo.PlayerShortVO;

public interface PlayerBL {
	/**
	 * 根据球员位置、球员联盟、排序依据总赛季数据50人升序
	 * @param location
	 * @param league
	 * @param num
	 * 0得分
	 * 1篮板
	 * 2助攻
	 * 3得分篮板助攻1：1:1
	 * 4盖帽
	 * 5抢断
	 * 6犯规
	 * 7失误
	 * 8分钟
	 * 9效率
	 * 10投篮
	 * 11三分
	 * 12罚球
	 * 13两双
	 * @return
	 */
	public ArrayList<PlayerAllVO> getPlayerAllByMultipleConRaising(String location,String league,int num);
	/**
	 * 根据球员位置、球员联盟、排序依据场均数据50人升序
	 * @param location
	 * @param league
	 * @param num
	 * @return
	 */
	public ArrayList<PlayerAverageVO> getPlayerAverageByMultipleConRaising(String location,String league,int num);
	/**
	 * 根据球员位置、球员联盟、排序依据总赛季数据50人降序
	 * @param location
	 * @param league
	 * @param num
	 * @return
	 */
	public ArrayList<PlayerAllVO> getPlayerAllByMultipleConDeclining(String location,String league,int num);
	/**
	 * 根据球员位置、球员联盟、排序依据场均数据50人降序
	 * @param location
	 * @param league
	 * @param num
	 * @return
	 */
	public ArrayList<PlayerAverageVO> getPlayerAverageByMultipleConDeclining(String location,String league,int num);

	/**
	 * 返回降序排列的前五名进步最快球员
	 * @param num
	 * 0场均得分
	 * 1场均篮板
	 * 2场均助攻
	 * @return
	 */
	public ArrayList<PlayerShortVO> getImprovedPlayerByNum(int num);
	
	/**
	 * 降序排列的当天热点球员前五名
	 * @param num
	 * 0得分
	 * 1篮板
	 * 2助攻
	 * 3盖帽
	 * 4抢断
	 * @return
	 */
	public ArrayList<PlayerShortVO> getTodayHotPlayerByNum(int num);
	
	/**
	 * 返回降序排列的前五名赛季热点球员
	 * @param num
	 * 0场均得分
	 * 1场均篮板
	 * 2场均助攻
	 * 3场均盖帽
	 * 4场均抢断
	 * 5三分命中率
	 * 6投篮命中率
	 * 7罚球命中率
	 * @return
	 */
	public ArrayList<PlayerShortVO>getHotPlayerByNum(int num);
	
    //返回所有球员的名字，包括有基本信息的，还有在比赛中出现过的
	public ArrayList<String> getPlayerNames();
	
	//根据一个字符串返回球员的可能的名字
	public ArrayList<String> getPlayerNamesByStr(String str);
	
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
	
	//根据排序依据的数字返回所有球员的总数据升序
	public ArrayList<PlayerAllVO> getPlayerAllRankingByNumRaising(int num);
	
	//根据排序依据的数字返回所有球员的平均数据升序
	public ArrayList<PlayerAverageVO> getPlayerAvergaeRankingByNumRaising(int num);
	
	//根据排序依据的数字返回所有球员的总数据降序
	public ArrayList<PlayerAllVO> getPlayerAllRankingByNumDeclining(int num);
	
	//根据排序依据的数字返回所有球员的平均数据降序
	public ArrayList<PlayerAverageVO> getPlayerAvergaeRankingByNumDeclining(int num);
	
	//根据基本信息的文件夹返回球员姓名
	public ArrayList<String> getPlayerNamesByBasic();
}
