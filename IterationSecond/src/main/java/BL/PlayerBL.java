package BL;

import java.util.ArrayList;

import vo.PlayerAllVO;
import vo.PlayerAverageVO;
import vo.PlayerBasicVO;
import vo.PlayerShortVO;

public interface PlayerBL {
	/**
	 *  *0篮板数
 *1助攻数
 *2投篮命中率
 *3三分命中率
 *4罚球命中率
 *5进攻数
 *6防守数
 *7抢断数
 *8盖帽数
 *9失误数
 *10犯规数
 *11得分
 *12效率
 *13GmSc效率值
 *14真实命中率
 *15投篮效率
 *16篮板率
 *17进攻篮板率
 *18防守篮板率
 *19助攻率
 *20抢断率
 *21盖帽率
 *22失误率
 *23使用率
 *24得分提升率
 *25篮板提升率
 *26助攻提升率
 * 27时间
 * 28得分篮板助攻
 * 29两双
 * 30比赛场数
 * 31先发场数
 *  32字典序
	 */
	public ArrayList<PlayerAllVO> getPlayerAllByMultipleConRaising(String location,String league,String age,ArrayList<Integer>nums,int many);
	//howmany是指筛选出多少个球员 raising接口返回的是最好的

	public ArrayList<PlayerAverageVO> getPlayerAverageByMultipleConRaising(String location,String league,String age,ArrayList<Integer>nums,int many);

	public ArrayList<PlayerAllVO> getPlayerAllByMultipleConDeclining(String location,String league,String age,ArrayList<Integer>nums,int many);

	//declining接口返回的是最差的
	public ArrayList<PlayerAverageVO> getPlayerAverageByMultipleConDeclining(String location,String league,String age,ArrayList<Integer>nums,int many);	
	/**
	 * 返回降序排列的前五名进步最快球员
	 * @param num
	 * 24场均得分提升率
	 * 25场均篮板提升率
	 * 26场均助攻提升率
	 * @return
	 */
	public ArrayList<PlayerAverageVO> getImprovedPlayerByNum(int num,int many);
	
	/**
	 * 降序排列的当天热点球员前五名
	 * @param num
     * 11场均得分
	 * 0场均篮板
	 * 1场均助攻
	 * @return
	 */
	public ArrayList<PlayerShortVO> getTodayHotPlayerByNum(int num,int many);
	
	/**
	 * 返回降序排列的前五名赛季热点球员
	 * @param num
	 * 11场均得分
	 * 0场均篮板
	 * 1场均助攻
	 * @return
	 */
	public ArrayList<PlayerShortVO>getHotPlayerByNum(int num,int many);
	
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
	/**
	 *  *0篮板数
 *1助攻数
 *2投篮命中率
 *3三分命中率
 *4罚球命中率
 *5进攻数
 *6防守数
 *7抢断数
 *8盖帽数
 *9失误数
 *10犯规数
 *11得分
 *12效率
 *13GmSc效率值
 *14真实命中率
 *15投篮效率
 *16篮板率
 *17进攻篮板率
 *18防守篮板率
 *19助攻率
 *20抢断率
 *21盖帽率
 *22失误率
 *23使用率
 *24得分提升率
 *25篮板提升率
 *26助攻提升率
 * 27时间
 * 28得分篮板助攻
 * 29两双
 * 30比赛场数
 * 31先发场数
 *  32字典序
	 */
	public ArrayList<PlayerAllVO> getPlayerAllRankingByNumRaising(ArrayList<Integer>nums);
	
	//根据排序依据的数字返回所有球员的平均数据升序
	public ArrayList<PlayerAverageVO> getPlayerAvergaeRankingByNumRaising(ArrayList<Integer>nums);
	
	//根据排序依据的数字返回所有球员的总数据降序
	public ArrayList<PlayerAllVO> getPlayerAllRankingByNumDeclining(ArrayList<Integer>nums);
	
	//根据排序依据的数字返回所有球员的平均数据降序
	public ArrayList<PlayerAverageVO> getPlayerAvergaeRankingByNumDeclining(ArrayList<Integer>nums);
	
	//根据基本信息的文件夹返回球员姓名
	public ArrayList<String> getPlayerNamesByBasic();
	//根据球员位置返回球员名字
	public ArrayList<String> getPlayerNamesByPosition(String position);
	//根据球员联盟返回球员名字
	public ArrayList<String> getPlayerNamesByLeague(String league);
	//根据年龄返回球员名字
	public ArrayList<String> getPlayerNamesByAge(String age);
	
}
