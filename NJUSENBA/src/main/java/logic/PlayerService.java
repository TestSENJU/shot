package logic;

import java.util.ArrayList;

import vo.PlayerAverageVO;
import vo.PlayerPersonalInfoVO;
import vo.PlayerStrVO;
import vo.PlayerVO;

public interface PlayerService {
	//TODO 所有队员的所有原始总赛季数据
	public ArrayList<PlayerStrVO> playerAll();
	//TODO 所有队员的所有原始场均数据
	public ArrayList<PlayerStrVO> playerAverage();
	// 所有球员总赛季数据按照某一项元素的升序排列
	public ArrayList<PlayerStrVO> ascendPlayerStr(int key, ArrayList<PlayerVO> playerOrigin);
	// 所有球员总赛季按照某一项元素的降序排列
	public ArrayList<PlayerStrVO> descendPlayerStr(int key, ArrayList<PlayerVO> playerOrigin);
	//所有球员场均数据升序
	public ArrayList<PlayerStrVO> ascendPlayerAStr(int key, ArrayList<PlayerAverageVO> playerOrigin);
	//所有球员场均数据降序
	public ArrayList<PlayerStrVO> descendPlayerAStr(int key, ArrayList<PlayerAverageVO> playerOrigin);
	//TODO 筛选部分 - 筛选所有球员赛季总数据
	public ArrayList<PlayerStrVO> filterAll(String filterInfo);
	// 筛选球员场均数据
	public ArrayList<PlayerStrVO> filterAverage(String filterInfo);
	//TODO 所有球员个人信息
	public ArrayList<PlayerPersonalInfoVO> playerPersonalInfo();
	// 某一球员的具体personal信息
	public PlayerPersonalInfoVO selectedPlayerInfo(String playerName);
}
