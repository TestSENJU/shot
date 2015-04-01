package logic;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import po.Player_AllScorePO;
import po.Player_BasicInfoPO;
import vo.PlayerAverageVO;
import vo.PlayerPersonalInfoVO;
import vo.PlayerStrVO;
import vo.PlayerVO;
import vo.TeamAverageVO;
import vo.TeamStrVO;
import vo.TeamVO;
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
	public ArrayList<PlayerAverageVO> allPlayerAverageData(){
		ArrayList<PlayerAverageVO> playerList = new ArrayList<PlayerAverageVO>();
	
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
	public ArrayList<PlayerAverageVO> sortA_Ascend(int key, ArrayList<PlayerAverageVO> playerList){
		SortPlayerAverage sap = new SortPlayerAverage();
		ArrayList<PlayerAverageVO> rePlayerList = new ArrayList<PlayerAverageVO>();
		rePlayerList = sap.ascendPlayer(key, playerList);
		return rePlayerList;
	}
	public ArrayList<PlayerAverageVO> sortA_Descend(int key, ArrayList<PlayerAverageVO> playerList){
		SortPlayerAverage sap = new SortPlayerAverage();
		ArrayList<PlayerAverageVO> rePlayerList = new ArrayList<PlayerAverageVO>();
		rePlayerList = sap.descendPlayer(key, playerList);
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
		PlayerPersonalInfoVO ppiv = new PlayerPersonalInfoVO();
		PlayerData pd = new PlayerData_Impl();
		Hashtable<String, Player_BasicInfoPO> playPersonalInfo = pd.getPlayerBasic();
		Set<String> keys = playPersonalInfo.keySet();
		for(String key : keys){
			if(playerName.equals(playPersonalInfo.get(key).getPlayerName())){
				String[] info = playPersonalInfo.get(key).getBasicInfo();
				ppiv.setName(playerName);
				ppiv.setJerseyNum(info[0]);
				ppiv.setPosition(info[1]);
				ppiv.setHeight(info[2]);
				ppiv.setWeight(info[3]);
				ppiv.setBirthday(info[4]);
				ppiv.setAge(info[5]);
				ppiv.setLengthOfPlayer(info[6]);
				ppiv.setGraduateSchool(info[7]);
				break;
			}
		}
		return ppiv;
	}
	//TODO to string
	public ArrayList<PlayerStrVO> playerToString(ArrayList<PlayerVO> playerList){
		ArrayList<PlayerStrVO> player = new ArrayList<PlayerStrVO>();
		for(int i=0;i < playerList.size();i++){
			player.add(new PlayerStrVO(playerList.get(i).getName(),
					playerList.get(i).getTeams(),
					Integer.toString(playerList.get(i).getCompeteNum()),
					Integer.toString(playerList.get(i).getOffensiveNum()),
					Double.toString(playerList.get(i).getReboundNum()),
					Double.toString(playerList.get(i).getAssistingNum()),
					playerList.get(i).getPlayingTime(),
					Double.toString(playerList.get(i).getHitRate()),
					Double.toString(playerList.get(i).getThreePointHitRate()),
					Double.toString(playerList.get(i).getFreeThrowHitRate()),
					Double.toString(playerList.get(i).getOffensiveReboundNum()),
					Double.toString(playerList.get(i).getDefensiveReboundNum()),
					Double.toString(playerList.get(i).getStealNum()),
					Double.toString(playerList.get(i).getBlockShotNum()),
					Double.toString(playerList.get(i).getMuffNum()),
					Double.toString(playerList.get(i).getFoulNum()),
					Double.toString(playerList.get(i).getScore()),
					Double.toString(playerList.get(i).getEfficiency()),
					Double.toString(playerList.get(i).getGmScEfficiency()),
					Double.toString(playerList.get(i).getTrueHitRate()),
					Double.toString(playerList.get(i).getShootEfficiency()),
					Double.toString(playerList.get(i).getReboundRate()),
					Double.toString(playerList.get(i).getOffensiveReboundRate()),
					Double.toString(playerList.get(i).getDefensiveReboundRate()),
					Double.toString(playerList.get(i).getAssistingRate()),
					Double.toString(playerList.get(i).getStealRate()),
					Double.toString(playerList.get(i).getBlockShotRate()),
					Double.toString(playerList.get(i).getMuffRate()),
					Double.toString(playerList.get(i).getUsage()))
					);
		}
		return player;
	}
	public ArrayList<PlayerStrVO> playerAverageToString(ArrayList<PlayerAverageVO> playerList){
		ArrayList<PlayerStrVO> player = new ArrayList<PlayerStrVO>();
		for(int i=0;i < playerList.size();i++){
			player.add(new PlayerStrVO(playerList.get(i).getName(),
					playerList.get(i).getTeams(),
					Double.toString(playerList.get(i).getCompeteNum()),
					Double.toString(playerList.get(i).getOffensiveNum()),
					Double.toString(playerList.get(i).getReboundNum()),
					Double.toString(playerList.get(i).getAssistingNum()),
					playerList.get(i).getPlayingTime(),
					Double.toString(playerList.get(i).getHitRate()),
					Double.toString(playerList.get(i).getThreePointHitRate()),
					Double.toString(playerList.get(i).getFreeThrowHitRate()),
					Double.toString(playerList.get(i).getOffensiveReboundNum()),
					Double.toString(playerList.get(i).getDefensiveReboundNum()),
					Double.toString(playerList.get(i).getStealNum()),
					Double.toString(playerList.get(i).getBlockShotNum()),
					Double.toString(playerList.get(i).getMuffNum()),
					Double.toString(playerList.get(i).getFoulNum()),
					Double.toString(playerList.get(i).getScore()),
					Double.toString(playerList.get(i).getEfficiency()),
					Double.toString(playerList.get(i).getGmScEfficiency()),
					Double.toString(playerList.get(i).getTrueHitRate()),
					Double.toString(playerList.get(i).getShootEfficiency()),
					Double.toString(playerList.get(i).getReboundRate()),
					Double.toString(playerList.get(i).getOffensiveReboundRate()),
					Double.toString(playerList.get(i).getDefensiveReboundRate()),
					Double.toString(playerList.get(i).getAssistingRate()),
					Double.toString(playerList.get(i).getStealRate()),
					Double.toString(playerList.get(i).getBlockShotRate()),
					Double.toString(playerList.get(i).getMuffRate()),
					Double.toString(playerList.get(i).getUsage()))
					);
		}
		return player;
	}
	public ArrayList<PlayerStrVO> playerAll(){
		ArrayList<PlayerVO> playerList = new ArrayList<PlayerVO>();
		playerList = allPlayerSeasonData();
		return playerToString(playerList);
	}
	public ArrayList<PlayerStrVO> playerAverage(){
		ArrayList<PlayerAverageVO> playerList = new ArrayList<PlayerAverageVO>();
		playerList = allPlayerAverageData();
		return playerAverageToString(playerList);
	}
	public ArrayList<PlayerStrVO> ascendPlayerStr(int key, ArrayList<PlayerVO> playerOrigin){
		ArrayList<PlayerVO> playerList = new ArrayList<PlayerVO>();
		playerList = sort_Ascend(key, playerOrigin);
		return playerToString(playerList);
	}
	public ArrayList<PlayerStrVO> descendPlayerStr(int key, ArrayList<PlayerVO> playerOrigin){
		ArrayList<PlayerVO> playerList = new ArrayList<PlayerVO>();
		playerList = sort_Descend(key, playerOrigin);
		return playerToString(playerList);
	}
	public ArrayList<PlayerStrVO> ascendPlayerAStr(int key, ArrayList<PlayerAverageVO> playerOrigin){
		ArrayList<PlayerAverageVO> playerList = new ArrayList<PlayerAverageVO>();
		playerList = sortA_Ascend(key, playerOrigin);
		return playerAverageToString(playerList);
	}
	public ArrayList<PlayerStrVO> descendPlayerAStr(int key, ArrayList<PlayerAverageVO> playerOrigin){
		ArrayList<PlayerAverageVO> playerList = new ArrayList<PlayerAverageVO>();
		playerList = sortA_Descend(key, playerOrigin);
		return playerAverageToString(playerList);
	}
}
