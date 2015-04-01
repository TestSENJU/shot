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
			//TODO teamAll competeAll
			double[] teamAll = playAllList.get(key).getTeamAll();
			double[] competeAll = playAllList.get(key).getCompeteAll();
			//篮板率=球员篮板数*(球队所有球员上场时间/5)/球员上场时间/(球队总篮板+对手总篮板)
			String[] timeTeam = playAllList.get(key).getTimeTeam().split(":");
			double minT = Double.valueOf(timeTeam[0]);
			double secondT = Double.valueOf(timeTeam[1]);
			String[] ptime = playAllList.get(key).getTimeAll().split(":");
			double min = Double.valueOf(ptime[0]);
			double second = Double.valueOf(ptime[1]);
			double reboundRate = scoresAll[8]*((minT*60+secondT)/5)/(min*60+second)/(teamAll[6]+competeAll[6]);
			double offensiveReboundRate = scoresAll[6]*((minT*60+secondT)/5)/(min*60+second)/(teamAll[4]+competeAll[4]);
			double defensiveReboundRate = scoresAll[7]*((minT*60+secondT)/5)/(min*60+second)/(teamAll[5]+competeAll[5]);
			//助攻率=球员助攻数/(球员上场时间/(球队所有球员上场时间/5)*球队总进球数-球员进球数)
			double assistingRate = scoresAll[9]/((min*60+second)/((minT*60+secondT)/5)*teamAll[1]-scoresAll[0]);
			//抢断率 = 球员抢断数*(球队所有球员上场时间/5)/球员上场时间/对手进攻次数
			//对手进攻次数=对手进攻回合
			//对手进攻回合=对手投篮数+0.4*对手球队罚球数
			//            -1.07*(对手进攻篮板/(对手进攻篮板+我方防守篮板)*对手投失球数)
			//             +1.07*对手失误数
			double competeRound = competeAll[0]+0.4*competeAll[3]-1.07*(competeAll[4]/(competeAll[4]+teamAll[5])*(competeAll[0]-competeAll[1]))+competeAll[7];
			double stealRate = scoresAll[10]*((minT*60+second)/5)/(min*60+second)/competeRound;
			//盖帽率=球员盖帽数*(球队所有球员上场时间/5)/球员上场时间/对手两分球出手次数
			double blockShotRate = scoresAll[11]*((minT*60+second)/5)/(min*60+second)/(scoresAll[1]-scoresAll[3]);
			//失误率 = 球员失误数/(球员两分球出手次数+0.44*球员罚球次数+球员失误数)
			double muffRate = scoresAll[12]/(scoresAll[1]-scoresAll[3]+0.44*scoresAll[5]+scoresAll[12]);
			//使用率 = (球员出手次数+0.44*球员罚球次数+球员失误次数)
			//        *(球队所有球员上场时间/5)/球员上场时间
			//         /(球队所有球员总出手次数+0.44*球队所有球员罚球次数+球队所有球员失误次数)
			double usage = (scoresAll[1]+0.44*scoresAll[5]+scoresAll[12])*((minT*60+second)/5)/(min*60+second)/(teamAll[0]+0.44*teamAll[3]+teamAll[7]);			
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
		//all season data for average calculation
		ArrayList<PlayerVO> pAllList = allPlayerSeasonData();
		ArrayList<PlayerAverageVO> playerList = new ArrayList<PlayerAverageVO>();
		for (int i=0;i < pAllList.size();i++) {
			String[] time = pAllList.get(i).getPlayingTime().split(":");
			double min = Double.valueOf(time[0]);
			double second = Double.valueOf(time[1]);
			double competeN = pAllList.get(i).getCompeteNum();
			playerList.add(new PlayerAverageVO(pAllList.get(i).getName(),
					pAllList.get(i).getTeams(),
					pAllList.get(i).getCompeteNum()/competeN,
				    (pAllList.get(i).getOffensiveNum()+0.0)/competeN,
					pAllList.get(i).getReboundNum()/competeN,
					pAllList.get(i).getAssistingNum()/competeN,
					Double.toString((min*60+second)/competeN),
					pAllList.get(i).getHitRate()/competeN,
					pAllList.get(i).getThreePointHitRate()/competeN,
					pAllList.get(i).getFreeThrowHitRate()/competeN,
					pAllList.get(i).getOffensiveReboundNum()/competeN,
					pAllList.get(i).getDefensiveReboundNum()/competeN,
					pAllList.get(i).getStealNum()/competeN,
					pAllList.get(i).getBlockShotNum()/competeN,
					pAllList.get(i).getMuffNum()/competeN,
					pAllList.get(i).getFoulNum()/competeN,
					pAllList.get(i).getScore()/competeN,
					pAllList.get(i).getEfficiency()/competeN,
					pAllList.get(i).getGmScEfficiency()/competeN,
					pAllList.get(i).getTrueHitRate()/competeN,
					pAllList.get(i).getShootEfficiency()/competeN,
					pAllList.get(i).getReboundRate()/competeN,
					pAllList.get(i).getOffensiveReboundRate()/competeN,
					pAllList.get(i).getDefensiveReboundRate()/competeN,
					pAllList.get(i).getAssistingRate()/competeN,
					pAllList.get(i).getStealRate()/competeN,
					pAllList.get(i).getBlockShotRate()/competeN,
					pAllList.get(i).getMuffRate()/competeN,
					pAllList.get(i).getUsage()/competeN));
		}
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
	public ArrayList<PlayerStrVO> filterAll(String filterInfo){
		ArrayList<PlayerVO> playerList = new ArrayList<PlayerVO>();
		String[] info = filterInfo.split(",");
		FliterPlayerAll fp = new FliterPlayerAll();
		playerList = fp.filterSortBy(info[0],info[1],info[2]);
		return playerToString(playerList);		
	}

	// 球员个人信息
	public ArrayList<PlayerStrVO> filterAverage(String filterInfo){
		ArrayList<PlayerAverageVO> playerList = new ArrayList<PlayerAverageVO>();
		String[] info = filterInfo.split(",");
		FliterPlayerAverage fp = new FliterPlayerAverage();
		playerList = fp.filterSortBy(info[0],info[1],info[2]);
		return playerAverageToString(playerList);	
	}
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
	public ArrayList<PlayerStrVO> ascendPlayerStr(int key, ArrayList<PlayerStrVO> playerOrigin){
		ArrayList<PlayerVO> playerList = new ArrayList<PlayerVO>();
		for(int i=0;i < playerOrigin.size();i++){
			playerList.add(new PlayerVO(playerOrigin.get(i).getName(),
					playerOrigin.get(i).getTeams(),
					Integer.parseInt(playerOrigin.get(i).getCompeteNum()),
					Integer.parseInt(playerOrigin.get(i).getOffensiveNum()),
					Double.valueOf(playerOrigin.get(i).getReboundNum()),
					Double.valueOf(playerOrigin.get(i).getAssistingNum()),
					playerOrigin.get(i).getPlayingTime(),
					Double.valueOf(playerOrigin.get(i).getHitRate()),
					Double.valueOf(playerOrigin.get(i).getThreePointHitRate()),
					Double.valueOf(playerOrigin.get(i).getFreeThrowHitRate()),
					Double.valueOf(playerOrigin.get(i).getOffensiveReboundNum()),
					Double.valueOf(playerOrigin.get(i).getDefensiveReboundNum()),
					Double.valueOf(playerOrigin.get(i).getStealNum()),
					Double.valueOf(playerOrigin.get(i).getBlockShotNum()),
					Double.valueOf(playerOrigin.get(i).getMuffNum()),
					Double.valueOf(playerOrigin.get(i).getFoulNum()),
					Double.valueOf(playerOrigin.get(i).getScore()),
					Double.valueOf(playerOrigin.get(i).getEfficiency()),
					Double.valueOf(playerOrigin.get(i).getGmScEfficiency()),
					Double.valueOf(playerOrigin.get(i).getTrueHitRate()),
					Double.valueOf(playerOrigin.get(i).getShootEfficiency()),
					Double.valueOf(playerOrigin.get(i).getReboundRate()),
					Double.valueOf(playerOrigin.get(i).getOffensiveReboundRate()),
					Double.valueOf(playerOrigin.get(i).getDefensiveReboundRate()),
					Double.valueOf(playerOrigin.get(i).getAssistingRate()),
					Double.valueOf(playerOrigin.get(i).getStealRate()),
					Double.valueOf(playerOrigin.get(i).getBlockShotRate()),
					Double.valueOf(playerOrigin.get(i).getMuffRate()),
					Double.valueOf(playerOrigin.get(i).getUsage()))
					);
		}
		return playerToString(sort_Ascend(key, playerList));
	}
	public ArrayList<PlayerStrVO> descendPlayerStr(int key, ArrayList<PlayerStrVO> playerOrigin){
		ArrayList<PlayerVO> playerList = new ArrayList<PlayerVO>();
		for(int i=0;i < playerOrigin.size();i++){
			playerList.add(new PlayerVO(playerOrigin.get(i).getName(),
					playerOrigin.get(i).getTeams(),
					Integer.parseInt(playerOrigin.get(i).getCompeteNum()),
					Integer.parseInt(playerOrigin.get(i).getOffensiveNum()),
					Double.valueOf(playerOrigin.get(i).getReboundNum()),
					Double.valueOf(playerOrigin.get(i).getAssistingNum()),
					playerOrigin.get(i).getPlayingTime(),
					Double.valueOf(playerOrigin.get(i).getHitRate()),
					Double.valueOf(playerOrigin.get(i).getThreePointHitRate()),
					Double.valueOf(playerOrigin.get(i).getFreeThrowHitRate()),
					Double.valueOf(playerOrigin.get(i).getOffensiveReboundNum()),
					Double.valueOf(playerOrigin.get(i).getDefensiveReboundNum()),
					Double.valueOf(playerOrigin.get(i).getStealNum()),
					Double.valueOf(playerOrigin.get(i).getBlockShotNum()),
					Double.valueOf(playerOrigin.get(i).getMuffNum()),
					Double.valueOf(playerOrigin.get(i).getFoulNum()),
					Double.valueOf(playerOrigin.get(i).getScore()),
					Double.valueOf(playerOrigin.get(i).getEfficiency()),
					Double.valueOf(playerOrigin.get(i).getGmScEfficiency()),
					Double.valueOf(playerOrigin.get(i).getTrueHitRate()),
					Double.valueOf(playerOrigin.get(i).getShootEfficiency()),
					Double.valueOf(playerOrigin.get(i).getReboundRate()),
					Double.valueOf(playerOrigin.get(i).getOffensiveReboundRate()),
					Double.valueOf(playerOrigin.get(i).getDefensiveReboundRate()),
					Double.valueOf(playerOrigin.get(i).getAssistingRate()),
					Double.valueOf(playerOrigin.get(i).getStealRate()),
					Double.valueOf(playerOrigin.get(i).getBlockShotRate()),
					Double.valueOf(playerOrigin.get(i).getMuffRate()),
					Double.valueOf(playerOrigin.get(i).getUsage()))
					);
		}
		return playerToString(sort_Descend(key, playerList));
	}
/*	public ArrayList<PlayerStrVO> ascendPlayerAStr(int key, ArrayList<PlayerAverageVO> playerOrigin){
		ArrayList<PlayerAverageVO> playerList = new ArrayList<PlayerAverageVO>();
		playerList = sortA_Ascend(key, playerOrigin);
		return playerAverageToString(playerList);
	}*/
	public ArrayList<PlayerStrVO> ascendPlayerAStr(int key, ArrayList<PlayerStrVO> playerOrigin){
		ArrayList<PlayerAverageVO> playerList = new ArrayList<PlayerAverageVO>();
		for(int i=0;i < playerOrigin.size();i++){
			playerList.add(new PlayerAverageVO(playerOrigin.get(i).getName(),
					playerOrigin.get(i).getTeams(),
					Double.valueOf(playerOrigin.get(i).getCompeteNum()),
					Double.valueOf(playerOrigin.get(i).getOffensiveNum()),
					Double.valueOf(playerOrigin.get(i).getReboundNum()),
					Double.valueOf(playerOrigin.get(i).getAssistingNum()),
					playerOrigin.get(i).getPlayingTime(),
					Double.valueOf(playerOrigin.get(i).getHitRate()),
					Double.valueOf(playerOrigin.get(i).getThreePointHitRate()),
					Double.valueOf(playerOrigin.get(i).getFreeThrowHitRate()),
					Double.valueOf(playerOrigin.get(i).getOffensiveReboundNum()),
					Double.valueOf(playerOrigin.get(i).getDefensiveReboundNum()),
					Double.valueOf(playerOrigin.get(i).getStealNum()),
					Double.valueOf(playerOrigin.get(i).getBlockShotNum()),
					Double.valueOf(playerOrigin.get(i).getMuffNum()),
					Double.valueOf(playerOrigin.get(i).getFoulNum()),
					Double.valueOf(playerOrigin.get(i).getScore()),
					Double.valueOf(playerOrigin.get(i).getEfficiency()),
					Double.valueOf(playerOrigin.get(i).getGmScEfficiency()),
					Double.valueOf(playerOrigin.get(i).getTrueHitRate()),
					Double.valueOf(playerOrigin.get(i).getShootEfficiency()),
					Double.valueOf(playerOrigin.get(i).getReboundRate()),
					Double.valueOf(playerOrigin.get(i).getOffensiveReboundRate()),
					Double.valueOf(playerOrigin.get(i).getDefensiveReboundRate()),
					Double.valueOf(playerOrigin.get(i).getAssistingRate()),
					Double.valueOf(playerOrigin.get(i).getStealRate()),
					Double.valueOf(playerOrigin.get(i).getBlockShotRate()),
					Double.valueOf(playerOrigin.get(i).getMuffRate()),
					Double.valueOf(playerOrigin.get(i).getUsage()))
					);
		}
		ArrayList<PlayerAverageVO> rePlayerList = new ArrayList<PlayerAverageVO>();
		rePlayerList = sortA_Ascend(key, playerList);
		return playerAverageToString(rePlayerList);
	}
	public ArrayList<PlayerStrVO> descendPlayerAStr(int key, ArrayList<PlayerStrVO> playerOrigin){
		ArrayList<PlayerAverageVO> playerList = new ArrayList<PlayerAverageVO>();
		for(int i=0;i < playerOrigin.size();i++){
			playerList.add(new PlayerAverageVO(playerOrigin.get(i).getName(),
					playerOrigin.get(i).getTeams(),
					Double.valueOf(playerOrigin.get(i).getCompeteNum()),
					Double.valueOf(playerOrigin.get(i).getOffensiveNum()),
					Double.valueOf(playerOrigin.get(i).getReboundNum()),
					Double.valueOf(playerOrigin.get(i).getAssistingNum()),
					playerOrigin.get(i).getPlayingTime(),
					Double.valueOf(playerOrigin.get(i).getHitRate()),
					Double.valueOf(playerOrigin.get(i).getThreePointHitRate()),
					Double.valueOf(playerOrigin.get(i).getFreeThrowHitRate()),
					Double.valueOf(playerOrigin.get(i).getOffensiveReboundNum()),
					Double.valueOf(playerOrigin.get(i).getDefensiveReboundNum()),
					Double.valueOf(playerOrigin.get(i).getStealNum()),
					Double.valueOf(playerOrigin.get(i).getBlockShotNum()),
					Double.valueOf(playerOrigin.get(i).getMuffNum()),
					Double.valueOf(playerOrigin.get(i).getFoulNum()),
					Double.valueOf(playerOrigin.get(i).getScore()),
					Double.valueOf(playerOrigin.get(i).getEfficiency()),
					Double.valueOf(playerOrigin.get(i).getGmScEfficiency()),
					Double.valueOf(playerOrigin.get(i).getTrueHitRate()),
					Double.valueOf(playerOrigin.get(i).getShootEfficiency()),
					Double.valueOf(playerOrigin.get(i).getReboundRate()),
					Double.valueOf(playerOrigin.get(i).getOffensiveReboundRate()),
					Double.valueOf(playerOrigin.get(i).getDefensiveReboundRate()),
					Double.valueOf(playerOrigin.get(i).getAssistingRate()),
					Double.valueOf(playerOrigin.get(i).getStealRate()),
					Double.valueOf(playerOrigin.get(i).getBlockShotRate()),
					Double.valueOf(playerOrigin.get(i).getMuffRate()),
					Double.valueOf(playerOrigin.get(i).getUsage()))
					);
		}
		return playerAverageToString(sortA_Descend(key, playerList));
	}
}
