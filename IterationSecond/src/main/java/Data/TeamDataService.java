package Data;

import java.util.ArrayList;

import po.TeamAllPlusRatePO;
import po.TeamAveragePlusRatePO;
import po.TeamBasicPO;
/**
 * 
 * @author wyt
 * @category
 * 以下球队名称都指球队的缩写
 * @category
 * getTeamAll 获得所有球队总赛季的PO
 * @category
 * getTeamAllByName 根据球队名称得到球队的总赛季数据
 * @category
 * getTeamAverageByName 根据球队名称得到球队的场均数据
 * @category
 * getTeamAverage获得所有球队的场均PO
 * @category
 * getAllTeamNames 获得所有球队的名称 以”缩写-全称“的格式
 * @category
 * getTeamNameByStr 根据字符串返回接近的球队缩写
 *@category
 *getTeamName 根据球队名称全称返回球队缩写
 *@category
 *getTeamBasic
 *@category
 *getTeamBasicByName
 */
public interface TeamDataService {
 
public ArrayList<TeamAllPlusRatePO>getTeamAll();

public TeamAllPlusRatePO getTeamAllByName(String teamName);

public TeamAveragePlusRatePO getTeamAverageByName(String teamName);

public ArrayList<TeamAveragePlusRatePO> getTeamAverage();

public ArrayList<String> getAllTeamNames();

public ArrayList<String> getTeamNameByStr(String str);

public String getTeamName(String str);

public ArrayList<TeamBasicPO> getTeamBasic();

public TeamBasicPO getTeamBasicByName(String teamName);

}
