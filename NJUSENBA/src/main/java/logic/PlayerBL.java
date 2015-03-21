package logic;

import java.util.ArrayList;

import vo.PlayerPersonalInfoVO;
import vo.PlayerVO;

public class PlayerBL implements PlayerService {
	//TODO 所有队员的所有原始总赛季数据
	public ArrayList<PlayerVO> allPlayerSeasonData(){
		ArrayList<PlayerVO> playerList = new ArrayList<PlayerVO>();
		
		return playerList;
	}
	//TODO 所有队员的所有原始场均数据
	public ArrayList<PlayerVO> allPlayerAverageData(){
		ArrayList<PlayerVO> playerList = new ArrayList<PlayerVO>();
		
		return playerList;
	}
	// 所有球员按照某一项元素的升序排列
	public ArrayList<PlayerVO> sort_Ascend(int key, ArrayList<PlayerVO> playerList){
		SortAllPlayer sp = new SortAllPlayer();
		ArrayList<PlayerVO> rePlayerList = new ArrayList<PlayerVO>();
		rePlayerList = sp.ascendPlayer(key, playerList);
		return rePlayerList;
	}
	// 所有球员按照某一项元素的降序排列
	public ArrayList<PlayerVO> sort_Descend(int key, ArrayList<PlayerVO> playerList){
		SortAllPlayer sp = new SortAllPlayer();
		ArrayList<PlayerVO> rePlayerList = new ArrayList<PlayerVO>();
		rePlayerList = sp.descendPlayer(key, playerList);
		return rePlayerList;
	}
	//TODO 筛选部分
	public ArrayList<PlayerVO> filter(String filterInfo){
		ArrayList<PlayerVO> playerList = new ArrayList<PlayerVO>();
		
		return playerList;		
	}
	//TODO 球员个人信息
	public ArrayList<PlayerPersonalInfoVO> playerPersonalInfo(){
		ArrayList<PlayerPersonalInfoVO> playerInfoList = new ArrayList<PlayerPersonalInfoVO>();
		return playerInfoList;
	}
	//TODO 某一球员的具体personal信息
	public PlayerPersonalInfoVO selectedPlayerInfo(String playerName){
		PlayerPersonalInfoVO p = new PlayerPersonalInfoVO();
		return p;
	}
}
