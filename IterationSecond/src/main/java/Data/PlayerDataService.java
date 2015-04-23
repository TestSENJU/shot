package Data;

import java.util.ArrayList;

import po.PlayerAllPlusRatePO;
import po.PlayerAveragePlusRatePO;
import po.PlayerBasicPO;
/**
 * 
 * @author wyt
 * @category
 * getPlayerAllByName根据球员姓名返回球员的总赛季数据
 * @category
 * getPlayerAverageByName根据球员姓名返回球员的场均数据
 * @category
 * getPlayerBasicByName根据球员姓名返回球员的基本信息
 * @category
 * getPlayerAll返回所有球员的总赛季数据
 * @category
 * getPlayerAverage返回所有球员的场均数据
 * @category
 * getPlayerBasic返回所有球员的基本信息
 * @category
 * getAllPlayerNames返回所有球员的姓名
 * @category
 * getPlayerNameByStr根据字符串返回相近的球员姓名
 *@category
 *getMatchNamesByPlayerName 根据球员姓名返回他参加过的比赛
 */
public interface PlayerDataService {

	public PlayerAllPlusRatePO getPlayerAllByName(String playerName);
	
	public PlayerAveragePlusRatePO getPlayerAverageByName(String playerName);
	
	public PlayerBasicPO getPlayerBasicByName(String playerName);
	
	public ArrayList<PlayerAllPlusRatePO> getPlayerAll();
	
	public ArrayList<PlayerAveragePlusRatePO> getPlayerAverage();
	
	public ArrayList<PlayerBasicPO> getPlayerBasic();
	
	public ArrayList<String> getAllPlayerNames();
	
	public ArrayList<String> getPlayerNameByStr(String str);
	
	public ArrayList<String> getMatchNamesByPlayerName(String playerName);
	
	public ArrayList<String> getPlayerNamesByBasic(String path);
	
}
