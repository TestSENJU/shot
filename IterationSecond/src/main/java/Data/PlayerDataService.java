package Data;

import java.util.ArrayList;

import po.PlayerAllPlusRatePO;
import po.PlayerAveragePlusRatePO;
import po.PlayerBasicPO;
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
	//
}
