package logic;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import po.TeamAveragePO;
import po.TeamPO;
import vo.TeamAverageVO;
import vo.TeamInfoVO;
import vo.TeamStrVO;
import vo.TeamVO;
import data.team.TeamData;
import data.team.TeamDataService;

public class TeamBL implements TeamService {
	// TODO to string
	public ArrayList<TeamStrVO> teamToString(ArrayList<TeamVO> teamList){
		ArrayList<TeamStrVO> team = new ArrayList<TeamStrVO>();
		for(int i=0;i < teamList.size();i++){
			team.add(new TeamStrVO(teamList.get(i).getName(),
					Integer.toString(teamList.get(i).getMatchSum()),
					Integer.toString(teamList.get(i).getHitSum()),
					Integer.toString(teamList.get(i).getShootSum()),
					Integer.toString(teamList.get(i).getThreePointHitSum()),
					Integer.toString(teamList.get(i).getThreePointSum()),
					Integer.toString(teamList.get(i).getFreeThrowHitSum()),
					Integer.toString(teamList.get(i).getFreeThrowSum()),
					Integer.toString(teamList.get(i).getOffensiveReboundSum()),
					Integer.toString(teamList.get(i).getDefensiveReboundSum()),
					Integer.toString(teamList.get(i).getReboundSum()),
					Integer.toString(teamList.get(i).getAssistingSum()),
					Integer.toString(teamList.get(i).getStealSum()),
					Integer.toString(teamList.get(i).getBlockShotSum()),
					Integer.toString(teamList.get(i).getMuffSum()),
					Integer.toString(teamList.get(i).getFoulSum()),
					Double.toString(teamList.get(i).getScore()),
					Double.toString(teamList.get(i).getHitRate()),
					Double.toString(teamList.get(i).getThreePointHitRate()),
					Double.toString(teamList.get(i).getFreeThrowHitRate()),
					Double.toString(teamList.get(i).getWinRate()),
					Double.toString(teamList.get(i).getOffensiveRound()),
					Double.toString(teamList.get(i).getOffensiveEfficiency()),
					Double.toString(teamList.get(i).getDefensiveEfficiency()),
					Double.toString(teamList.get(i).getOffensiveReboundRate()),
					Double.toString(teamList.get(i).getDefensiveReboundRate()),
					Double.toString(teamList.get(i).getStealRate()),
					Double.toString(teamList.get(i).getAssistingRate()))
					);
		}
		return team;
	}
	public ArrayList<TeamStrVO> teamAverageToString(ArrayList<TeamAverageVO> teamList){
		ArrayList<TeamStrVO> team = new ArrayList<TeamStrVO>();
		for(int i=0;i < teamList.size();i++){
			team.add(new TeamStrVO(teamList.get(i).getName(),
					Double.toString(teamList.get(i).getMatchSum()),
					Double.toString(teamList.get(i).getHitSum()),
					Double.toString(teamList.get(i).getShootSum()),
					Double.toString(teamList.get(i).getThreePointHitSum()),
					Double.toString(teamList.get(i).getThreePointSum()),
					Double.toString(teamList.get(i).getFreeThrowHitSum()),
					Double.toString(teamList.get(i).getFreeThrowSum()),
					Double.toString(teamList.get(i).getOffensiveReboundSum()),
					Double.toString(teamList.get(i).getDefensiveReboundSum()),
					Double.toString(teamList.get(i).getReboundSum()),
					Double.toString(teamList.get(i).getAssistingSum()),
					Double.toString(teamList.get(i).getStealSum()),
					Double.toString(teamList.get(i).getBlockShotSum()),
					Double.toString(teamList.get(i).getMuffSum()),
					Double.toString(teamList.get(i).getFoulSum()),
					Double.toString(teamList.get(i).getScore()),
					Double.toString(teamList.get(i).getHitRate()),
					Double.toString(teamList.get(i).getThreePointHitRate()),
					Double.toString(teamList.get(i).getFreeThrowHitRate()),
					Double.toString(teamList.get(i).getWinRate()),
					Double.toString(teamList.get(i).getOffensiveRound()),
					Double.toString(teamList.get(i).getOffensiveEfficiency()),
					Double.toString(teamList.get(i).getDefensiveEfficiency()),
					Double.toString(teamList.get(i).getOffensiveReboundRate()),
					Double.toString(teamList.get(i).getDefensiveReboundRate()),
					Double.toString(teamList.get(i).getStealRate()),
					Double.toString(teamList.get(i).getAssistingRate()))
					);
		}
		return team;
	}
	// 所有球队的原始总赛季数据
	public ArrayList<TeamVO> allTeamSeasonData() {
		ArrayList<TeamVO> teamList = new ArrayList<TeamVO>();
		TeamDataService tds = new TeamData();
		Hashtable<String, TeamPO> polist = tds.getTeamData();
		Set<String> keys = polist.keySet();
		for (String key : keys) {
			teamList.add(new TeamVO(polist.get(key).getTeamName(),
					polist.get(key).getMatchNum(),
					polist.get(key).getShotRightNum(),
					polist.get(key).getShotNum(),
					polist.get(key).getThreePointShotRightNum(),
					polist.get(key).getThreePointShotNum(),
					polist.get(key).getPenaltyShotRightNum(),
					polist.get(key).getPenaltyShotNum(),
					polist.get(key).getOffensiveReboundNum(),
					polist.get(key).getDefensiveReboundNum(),
					polist.get(key).getReboundNum(),
					polist.get(key).getAssistNum(),
					polist.get(key).getStealNum(),
					polist.get(key).getBlockShotNum(),
					polist.get(key).getFaultyNum(),
					polist.get(key).getFoulNum(),
					(double)polist.get(key).getScore(),
					polist.get(key).getHitRate(),
					polist.get(key).getThreeHitRate(),
					polist.get(key).getPenaltyRate(),
					polist.get(key).getWinRate(),
					polist.get(key).getAttackRound(),
					polist.get(key).getAttackEfficiency(),
					polist.get(key).getDefensiveEfficiency(),
					polist.get(key).getAttackReboundRate(),
					polist.get(key).getDefensiveReboundRate(),
					polist.get(key).getStealRate(),
					polist.get(key).getAssistingRate()
					));
		}
		return teamList;
	}

	//TODO
	public ArrayList<TeamStrVO> allTeamStr(){
		ArrayList<TeamVO> teamList = new ArrayList<TeamVO>();
		teamList = allTeamSeasonData();
		return teamToString(teamList);
	}
	public ArrayList<TeamStrVO> allTeamAverStr(){
		ArrayList<TeamAverageVO> teamList = new ArrayList<TeamAverageVO>();
		teamList = allTeamAverageData();
		return teamAverageToString(teamList);
	}
	//TODO ascend descend
	public ArrayList<TeamStrVO> ascendTeamStr(int key, ArrayList<TeamStrVO> teamOrigin){
		ArrayList<TeamVO> teamList = new ArrayList<TeamVO>();
		for (int i=0;i < teamOrigin.size();i++) {
			teamList.add(new TeamVO(teamOrigin.get(i).getName(),
					Integer.parseInt(teamOrigin.get(i).getMatchSum()),
					Integer.parseInt(teamOrigin.get(i).getHitSum()),
					Integer.parseInt(teamOrigin.get(i).getShootSum()),
					Integer.parseInt(teamOrigin.get(i).getThreePointHitSum()),
					Integer.parseInt(teamOrigin.get(i).getThreePointSum()),
					Integer.parseInt(teamOrigin.get(i).getFreeThrowHitSum()),
					Integer.parseInt(teamOrigin.get(i).getFreeThrowSum()),
					Integer.parseInt(teamOrigin.get(i).getOffensiveReboundSum()),
					Integer.parseInt(teamOrigin.get(i).getDefensiveReboundSum()),
					Integer.parseInt(teamOrigin.get(i).getReboundSum()),
					Integer.parseInt(teamOrigin.get(i).getAssistingSum()),
					Integer.parseInt(teamOrigin.get(i).getStealSum()),
					Integer.parseInt(teamOrigin.get(i).getBlockShotSum()),
					Integer.parseInt(teamOrigin.get(i).getMuffSum()),
					Integer.parseInt(teamOrigin.get(i).getFoulSum()),
					Double.valueOf(teamOrigin.get(i).getScore()),
					Double.valueOf(teamOrigin.get(i).getHitRate()),
					Double.valueOf(teamOrigin.get(i).getThreePointHitRate()),
					Double.valueOf(teamOrigin.get(i).getFreeThrowHitRate()),
					Double.valueOf(teamOrigin.get(i).getWinRate()),
					Double.valueOf(teamOrigin.get(i).getOffensiveRound()),
					Double.valueOf(teamOrigin.get(i).getOffensiveEfficiency()),
					Double.valueOf(teamOrigin.get(i).getDefensiveEfficiency()),
					Double.valueOf(teamOrigin.get(i).getOffensiveReboundRate()),
					Double.valueOf(teamOrigin.get(i).getDefensiveReboundRate()),
					Double.valueOf(teamOrigin.get(i).getStealRate()),
					Double.valueOf(teamOrigin.get(i).getAssistingRate()))
					);
		}
		return teamToString(sort_Ascend(key, teamList));
	}
	public ArrayList<TeamStrVO> descendTeamStr(int key, ArrayList<TeamStrVO> teamOrigin){
		ArrayList<TeamVO> teamList = new ArrayList<TeamVO>();
		for (int i=0;i < teamOrigin.size();i++) {
			teamList.add(new TeamVO(teamOrigin.get(i).getName(),
					Integer.parseInt(teamOrigin.get(i).getMatchSum()),
					Integer.parseInt(teamOrigin.get(i).getHitSum()),
					Integer.parseInt(teamOrigin.get(i).getShootSum()),
					Integer.parseInt(teamOrigin.get(i).getThreePointHitSum()),
					Integer.parseInt(teamOrigin.get(i).getThreePointSum()),
					Integer.parseInt(teamOrigin.get(i).getFreeThrowHitSum()),
					Integer.parseInt(teamOrigin.get(i).getFreeThrowSum()),
					Integer.parseInt(teamOrigin.get(i).getOffensiveReboundSum()),
					Integer.parseInt(teamOrigin.get(i).getDefensiveReboundSum()),
					Integer.parseInt(teamOrigin.get(i).getReboundSum()),
					Integer.parseInt(teamOrigin.get(i).getAssistingSum()),
					Integer.parseInt(teamOrigin.get(i).getStealSum()),
					Integer.parseInt(teamOrigin.get(i).getBlockShotSum()),
					Integer.parseInt(teamOrigin.get(i).getMuffSum()),
					Integer.parseInt(teamOrigin.get(i).getFoulSum()),
					Double.valueOf(teamOrigin.get(i).getScore()),
					Double.valueOf(teamOrigin.get(i).getHitRate()),
					Double.valueOf(teamOrigin.get(i).getThreePointHitRate()),
					Double.valueOf(teamOrigin.get(i).getFreeThrowHitRate()),
					Double.valueOf(teamOrigin.get(i).getWinRate()),
					Double.valueOf(teamOrigin.get(i).getOffensiveRound()),
					Double.valueOf(teamOrigin.get(i).getOffensiveEfficiency()),
					Double.valueOf(teamOrigin.get(i).getDefensiveEfficiency()),
					Double.valueOf(teamOrigin.get(i).getOffensiveReboundRate()),
					Double.valueOf(teamOrigin.get(i).getDefensiveReboundRate()),
					Double.valueOf(teamOrigin.get(i).getStealRate()),
					Double.valueOf(teamOrigin.get(i).getAssistingRate()))
					);
		}
		return teamToString(sort_Descend(key, teamList));
	}
	public ArrayList<TeamStrVO> ascendTeamAStr(int key, ArrayList<TeamStrVO> teamOrigin){
		ArrayList<TeamAverageVO> teamList = new ArrayList<TeamAverageVO>();
		for (int i=0;i < teamOrigin.size();i++) {
			teamList.add(new TeamAverageVO(teamOrigin.get(i).getName(),
					Double.valueOf(teamOrigin.get(i).getMatchSum()),
					Double.valueOf(teamOrigin.get(i).getHitSum()),
					Double.valueOf(teamOrigin.get(i).getShootSum()),
					Double.valueOf(teamOrigin.get(i).getThreePointHitSum()),
					Double.valueOf(teamOrigin.get(i).getThreePointSum()),
					Double.valueOf(teamOrigin.get(i).getFreeThrowHitSum()),
					Double.valueOf(teamOrigin.get(i).getFreeThrowSum()),
					Double.valueOf(teamOrigin.get(i).getOffensiveReboundSum()),
					Double.valueOf(teamOrigin.get(i).getDefensiveReboundSum()),
					Double.valueOf(teamOrigin.get(i).getReboundSum()),
					Double.valueOf(teamOrigin.get(i).getAssistingSum()),
					Double.valueOf(teamOrigin.get(i).getStealSum()),
					Double.valueOf(teamOrigin.get(i).getBlockShotSum()),
					Double.valueOf(teamOrigin.get(i).getMuffSum()),
					Double.valueOf(teamOrigin.get(i).getFoulSum()),
					Double.valueOf(teamOrigin.get(i).getScore()),
					Double.valueOf(teamOrigin.get(i).getHitRate()),
					Double.valueOf(teamOrigin.get(i).getThreePointHitRate()),
					Double.valueOf(teamOrigin.get(i).getFreeThrowHitRate()),
					Double.valueOf(teamOrigin.get(i).getWinRate()),
					Double.valueOf(teamOrigin.get(i).getOffensiveRound()),
					Double.valueOf(teamOrigin.get(i).getOffensiveEfficiency()),
					Double.valueOf(teamOrigin.get(i).getDefensiveEfficiency()),
					Double.valueOf(teamOrigin.get(i).getOffensiveReboundRate()),
					Double.valueOf(teamOrigin.get(i).getDefensiveReboundRate()),
					Double.valueOf(teamOrigin.get(i).getStealRate()),
					Double.valueOf(teamOrigin.get(i).getAssistingRate()))
					);
		}
		return teamAverageToString(sortA_Ascend(key, teamList));
	}
	public ArrayList<TeamStrVO> descendTeamAStr(int key, ArrayList<TeamStrVO> teamOrigin){
		ArrayList<TeamAverageVO> teamList = new ArrayList<TeamAverageVO>();
		for (int i=0;i < teamOrigin.size();i++) {
			teamList.add(new TeamAverageVO(teamOrigin.get(i).getName(),
					Double.valueOf(teamOrigin.get(i).getMatchSum()),
					Double.valueOf(teamOrigin.get(i).getHitSum()),
					Double.valueOf(teamOrigin.get(i).getShootSum()),
					Double.valueOf(teamOrigin.get(i).getThreePointHitSum()),
					Double.valueOf(teamOrigin.get(i).getThreePointSum()),
					Double.valueOf(teamOrigin.get(i).getFreeThrowHitSum()),
					Double.valueOf(teamOrigin.get(i).getFreeThrowSum()),
					Double.valueOf(teamOrigin.get(i).getOffensiveReboundSum()),
					Double.valueOf(teamOrigin.get(i).getDefensiveReboundSum()),
					Double.valueOf(teamOrigin.get(i).getReboundSum()),
					Double.valueOf(teamOrigin.get(i).getAssistingSum()),
					Double.valueOf(teamOrigin.get(i).getStealSum()),
					Double.valueOf(teamOrigin.get(i).getBlockShotSum()),
					Double.valueOf(teamOrigin.get(i).getMuffSum()),
					Double.valueOf(teamOrigin.get(i).getFoulSum()),
					Double.valueOf(teamOrigin.get(i).getScore()),
					Double.valueOf(teamOrigin.get(i).getHitRate()),
					Double.valueOf(teamOrigin.get(i).getThreePointHitRate()),
					Double.valueOf(teamOrigin.get(i).getFreeThrowHitRate()),
					Double.valueOf(teamOrigin.get(i).getWinRate()),
					Double.valueOf(teamOrigin.get(i).getOffensiveRound()),
					Double.valueOf(teamOrigin.get(i).getOffensiveEfficiency()),
					Double.valueOf(teamOrigin.get(i).getDefensiveEfficiency()),
					Double.valueOf(teamOrigin.get(i).getOffensiveReboundRate()),
					Double.valueOf(teamOrigin.get(i).getDefensiveReboundRate()),
					Double.valueOf(teamOrigin.get(i).getStealRate()),
					Double.valueOf(teamOrigin.get(i).getAssistingRate()))
					);
		}
		return teamAverageToString(sortA_Descend(key, teamList));
	}
	//  所有球队的原始场均数据
	public ArrayList<TeamAverageVO> allTeamAverageData() {
		ArrayList<TeamAverageVO> teamList = new ArrayList<TeamAverageVO>();
		TeamDataService tds = new TeamData();
		Hashtable<String, TeamAveragePO> polist = tds.getTeamAverageData();
		Set<String> keys = polist.keySet();
		for (String key : keys) {
			teamList.add(new TeamAverageVO(polist.get(key).getTeamName(),
					polist.get(key).getMatchNum(),
					polist.get(key).getShotRightNum(),
					polist.get(key).getShotNum(),
					polist.get(key).getThreePointShotRightNum(),
					polist.get(key).getThreePointShotNum(),
					polist.get(key).getPenaltyShotRightNum(),
					polist.get(key).getPenaltyShotNum(),
					polist.get(key).getOffensiveReboundNum(),
					polist.get(key).getDefensiveReboundNum(),
					polist.get(key).getReboundNum(),
					polist.get(key).getAssistNum(),
					polist.get(key).getStealNum(),
					polist.get(key).getBlockShotNum(),
					polist.get(key).getFaultyNum(),
					polist.get(key).getFoulNum(),
					(double)polist.get(key).getScore(),
					polist.get(key).getHitRate(),
					polist.get(key).getThreeHitRate(),
					polist.get(key).getPenaltyRate(),
					polist.get(key).getWinRate(),
					polist.get(key).getAttackRound(),
					polist.get(key).getAttackEfficiency(),
					polist.get(key).getDefensiveEfficiency(),
					polist.get(key).getAttackReboundRate(),
					polist.get(key).getDefensiveReboundRate(),
					polist.get(key).getStealRate(),
					polist.get(key).getAssistingRate()
					));
		}
		return teamList;
	}

	// 所有队伍信息-升序排列
	public ArrayList<TeamVO> sort_Ascend(int key, ArrayList<TeamVO> teamList) {
		SortAllTeam st = new SortAllTeam();
		ArrayList<TeamVO> reTeamList = new ArrayList<TeamVO>();
		reTeamList = st.ascendTeam(key, teamList);
		return reTeamList;
	}

	// 所有队伍信息-降序排列
	public ArrayList<TeamVO> sort_Descend(int key, ArrayList<TeamVO> teamList) {
		SortAllTeam st = new SortAllTeam();
		ArrayList<TeamVO> reTeamList = new ArrayList<TeamVO>();
		reTeamList = st.descendTeam(key, teamList);
		return reTeamList;
	}
	// average ascend descend
	public ArrayList<TeamAverageVO> sortA_Ascend(int key, ArrayList<TeamAverageVO> teamList) {
		SortTeamAverage st = new SortTeamAverage();
		ArrayList<TeamAverageVO> reTeamList = new ArrayList<TeamAverageVO>();
		reTeamList = st.ascendTeam(key, teamList);
		return reTeamList;
	}
	public ArrayList<TeamAverageVO> sortA_Descend(int key, ArrayList<TeamAverageVO> teamList) {
		SortTeamAverage st = new SortTeamAverage();
		ArrayList<TeamAverageVO> reTeamList = new ArrayList<TeamAverageVO>();
		reTeamList = st.descendTeam(key, teamList);
		return reTeamList;
	}
	// to string 根据球队名得到球队赛季总数据
	public ArrayList<TeamStrVO> teamAllInfo(String name){
		ArrayList<TeamVO> teamList = new ArrayList<TeamVO>();
		TeamDataService tds = new TeamData();
		Hashtable<String, TeamPO> polist = tds.getTeamData();
		Set<String> keys = polist.keySet();
		for (String key : keys) {
			if(name.equals(polist.get(key).getTeamName())){
				teamList.add(new TeamVO(polist.get(key).getTeamName(),
						polist.get(key).getMatchNum(),
						polist.get(key).getShotRightNum(),
						polist.get(key).getShotNum(),
						polist.get(key).getThreePointShotRightNum(),
						polist.get(key).getThreePointShotNum(),
						polist.get(key).getPenaltyShotRightNum(),
						polist.get(key).getPenaltyShotNum(),
						polist.get(key).getOffensiveReboundNum(),
						polist.get(key).getDefensiveReboundNum(),
						polist.get(key).getReboundNum(),
						polist.get(key).getAssistNum(),
						polist.get(key).getStealNum(),
						polist.get(key).getBlockShotNum(),
						polist.get(key).getFaultyNum(),
						polist.get(key).getFoulNum(),
						(double)polist.get(key).getScore(),
						polist.get(key).getHitRate(),
						polist.get(key).getThreeHitRate(),
						polist.get(key).getPenaltyRate(),
						polist.get(key).getWinRate(),
						polist.get(key).getAttackRound(),
						polist.get(key).getAttackEfficiency(),
						polist.get(key).getDefensiveEfficiency(),
						polist.get(key).getAttackReboundRate(),
						polist.get(key).getDefensiveReboundRate(),
						polist.get(key).getStealRate(),
						polist.get(key).getAssistingRate()
						));
				break;
			};
		}
		return teamToString(teamList);
	}
	// 根据球队名得到球队场均数据
	public ArrayList<TeamStrVO> teamAverageInfo(String name){
		ArrayList<TeamAverageVO> teamList = new ArrayList<TeamAverageVO>();
		TeamDataService tds = new TeamData();
		Hashtable<String, TeamAveragePO> polist = tds.getTeamAverageData();
		Set<String> keys = polist.keySet();
		for (String key : keys) {
			if(name.equals(polist.get(key).getTeamName())){
				teamList.add(new TeamAverageVO(polist.get(key).getTeamName(),
						polist.get(key).getMatchNum(),
						polist.get(key).getShotRightNum(),
						polist.get(key).getShotNum(),
						polist.get(key).getThreePointShotRightNum(),
						polist.get(key).getThreePointShotNum(),
						polist.get(key).getPenaltyShotRightNum(),
						polist.get(key).getPenaltyShotNum(),
						polist.get(key).getOffensiveReboundNum(),
						polist.get(key).getDefensiveReboundNum(),
						polist.get(key).getReboundNum(),
						polist.get(key).getAssistNum(),
						polist.get(key).getStealNum(),
						polist.get(key).getBlockShotNum(),
						polist.get(key).getFaultyNum(),
						polist.get(key).getFoulNum(),
						(double)polist.get(key).getScore(),
						polist.get(key).getHitRate(),
						polist.get(key).getThreeHitRate(),
						polist.get(key).getPenaltyRate(),
						polist.get(key).getWinRate(),
						polist.get(key).getAttackRound(),
						polist.get(key).getAttackEfficiency(),
						polist.get(key).getDefensiveEfficiency(),
						polist.get(key).getAttackReboundRate(),
						polist.get(key).getDefensiveReboundRate(),
						polist.get(key).getStealRate(),
						polist.get(key).getAssistingRate()
						));
				break;
			};
		}
		return teamAverageToString(teamList);
	}
	// TODO 球队具体信息比如球队全名等
	public ArrayList<TeamInfoVO> teamDetailInfo() {
		ArrayList<TeamInfoVO> teamInfoList = new ArrayList<TeamInfoVO>();
		return teamInfoList;
	}
}
