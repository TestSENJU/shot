package logic;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import po.Player_AllScorePO;
import po.Player_BasicInfoPO;
import vo.PlayerPersonalInfoVO;
import vo.PlayerVO;
import data.player.PlayerData;
import data.player.PlayerData_Impl;

public class PlayerBL implements PlayerService {
	//TODO 所有队员的所有原始总赛季数据
	public ArrayList<PlayerVO> allPlayerSeasonData(){
		ArrayList<PlayerVO> playerList = new ArrayList<PlayerVO>();
		PlayerData pd = new PlayerData_Impl();
		Hashtable<String, Player_AllScorePO> playAllList = pd.getPlayerAll();
		Set<String> keys = playAllList.keySet();
		Calculation cplay = new Calculation();
		for (String key : keys) {
			double[] scoresAll = playAllList.get(key).getScoresAll();
			double reboundNum = scoresAll[8];
			double assistingNum = scoresAll[9];
			String playingTime = playAllList.get(key).getTimeAll();
			double hitRate = scoresAll[0] / scoresAll[1];
			double threePointHitRate = scoresAll[2] / scoresAll[3];
			double freeThrowHitRate = scoresAll[4] / scoresAll[5];
			double offensiveReboundNum = scoresAll[6];
			double defensiveReboundNum = scoresAll[7];
			double stealNum = scoresAll[10];
			double blockShotNum = scoresAll[11];
			double muffNum = scoresAll[12];
			double foulNum = scoresAll[13];
			double score = scoresAll[14];
			double efficiency = cplay.rate(score, reboundNum, assistingNum, stealNum, blockShotNum, 
					scoresAll[1], scoresAll[0], scoresAll[5], scoresAll[4], muffNum);
			double GmScEfficiency = cplay.GmScEfficiency(score, scoresAll[0], scoresAll[1],
					scoresAll[5], scoresAll[4], 
					offensiveReboundNum, defensiveReboundNum, stealNum, 
					assistingNum, blockShotNum, foulNum, muffNum);
			double trueHitRate = cplay.trueHitRate(score, scoresAll[1], scoresAll[5]);
			double shootEfficiency = cplay.shootEfficiency(scoresAll[0], scoresAll[2], scoresAll[1]);
			double reboundRate = 0;//TODO
			double offensiveReboundRate = 0;
			double defensiveReboundRate = 0;
			double assistingRate = 0;
			double stealRate = 0;
			double blockShotRate = 0;
			double muffRate = 0;
			double usage = 0;			
			playerList.add(new PlayerVO(playAllList.get(key).getPlayerName(),
					playAllList.get(key).getTeam(),
					playAllList.get(key).getNumOfMatches(),
					playAllList.get(key).getNumOfFirstMatches(),
					reboundNum, assistingNum, playingTime, hitRate,
					threePointHitRate, freeThrowHitRate, offensiveReboundNum,
					defensiveReboundNum, stealNum, blockShotNum, muffNum,
					foulNum, score, efficiency, GmScEfficiency, trueHitRate,
					shootEfficiency, reboundRate, offensiveReboundRate,
					defensiveReboundRate, assistingRate, stealRate,
					blockShotRate, muffRate, usage
					));
		}

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
	// 筛选部分
	public ArrayList<PlayerVO> filter(String filterInfo){
		ArrayList<PlayerVO> playerList = new ArrayList<PlayerVO>();
		String[] info = filterInfo.split(",");
		FliterPlayer fp = new FliterPlayer();
		playerList = fp.filterSortBy(info[0],info[1],info[2]);
		return playerList;		
	}
	// 球员个人信息
	public ArrayList<PlayerPersonalInfoVO> playerPersonalInfo(){
		ArrayList<PlayerPersonalInfoVO> playerInfoList = new ArrayList<PlayerPersonalInfoVO>();
		PlayerData pd = new PlayerData_Impl();
		Hashtable<String,Player_BasicInfoPO> playPersonalInfo = pd.getPlayerBasic();
		Set<String> keys = playPersonalInfo.keySet();
		for (String key : keys){
			String[] info = playPersonalInfo.get(key).getBasicInfo();
			playerInfoList.add(new PlayerPersonalInfoVO(playPersonalInfo.get(key).getPlayerName(),
					info[0], info[1], info[2], info[3], 
					info[4],info[5],info[6], info[7]));
		}
		return playerInfoList;
	}
	//TODO 某一球员的具体personal信息
	public PlayerPersonalInfoVO selectedPlayerInfo(String playerName){
		PlayerPersonalInfoVO p = new PlayerPersonalInfoVO();
		return p;
	}
}
