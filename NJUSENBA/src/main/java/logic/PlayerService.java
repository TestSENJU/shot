package logic;

import java.util.ArrayList;

import vo.PlayerPersonalInfoVO;
import vo.PlayerVO;

public interface PlayerService {
	//TODO 所有队员的所有原始总赛季数据
	public ArrayList<PlayerVO> allPlayerSeasonData();
	//TODO 所有队员的所有原始场均数据
	public ArrayList<PlayerVO> allPlayerAverageData();
	// 所有球员按照某一项元素的升序排列
	public ArrayList<PlayerVO> sort_Ascend(int key, ArrayList<PlayerVO> playerList);
	// 所有球员按照某一项元素的降序排列
	public ArrayList<PlayerVO> sort_Descend(int key, ArrayList<PlayerVO> playerList);
	//TODO 筛选部分
	public ArrayList<PlayerVO> filter(String filterInfo);
	//TODO 球员个人信息
	public ArrayList<PlayerPersonalInfoVO> playerPersonalInfo();
	//TODO 某一球员的具体personal信息
	public PlayerPersonalInfoVO selectedPlayerInfo(String playerName);
}
