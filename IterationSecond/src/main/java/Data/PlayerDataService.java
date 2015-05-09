package Data;

import java.util.ArrayList;

import po.PlayerAllPlusRatePO;
import po.PlayerAveragePlusRatePO;
import po.PlayerBasicPO;
import po.PlayerShortPO;
/**
 * 
 * @author wyt
 */
public interface PlayerDataService {
    //根据球员姓名返回球员的总赛季数据
	public PlayerAllPlusRatePO getPlayerAllByName(String playerName);
	//根据球员姓名返回球员的场均数据
	public PlayerAveragePlusRatePO getPlayerAverageByName(String playerName);
	//根据球员姓名返回球员的基本信息
	public PlayerBasicPO getPlayerBasicByName(String playerName);
	//返回所有球员的总赛季数据
	public ArrayList<PlayerAllPlusRatePO> getPlayerAll();
	//返回所有球员的场均数据
	public ArrayList<PlayerAveragePlusRatePO> getPlayerAverage();
	//返回所有球员的基本信息
	public ArrayList<PlayerBasicPO> getPlayerBasic();
	//返回所有球员的姓名
	public ArrayList<String> getAllPlayerNames();
	//根据字符串返回相近的球员姓名
	public ArrayList<String> getPlayerNameByStr(String str);
	//根据球员姓名返回他参加过的比赛
	public ArrayList<String> getMatchNamesByPlayerName(String playerName);
	//根据基本信息的文件夹返回所有球员的名字
	public ArrayList<String> getPlayerNamesByBasic(String path);
	//根据筛选的项返回所有的球员
	public ArrayList<PlayerShortPO> getShortPlayerByNum(int num);
	//根据当天的比赛返回当天所有参加过比赛的球员的shortpo
	public ArrayList<PlayerShortPO> getShortPlayerToday(int num);
	//根据联盟返回球员名
	public ArrayList<String> getPlayerByLeague(String league);
	//根据位置返回球员名
	public ArrayList<String> getPlayerByPosition(String position);
	//根据年龄返回球员名字
	public ArrayList<String> getPlayerByAge(String age);

}
