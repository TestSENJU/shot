package logic;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import po.TeamAveragePO;
import po.TeamPO;
import vo.TeamAverageVO;
import vo.TeamInfoVO;
import vo.TeamVO;
import data.team.TeamData;
import data.team.TeamDataService;

public class TeamBL {
	// TODO 所有球队的原始总赛季数据
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

	// TODO 所有球队的原始场均数据
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

	// TODO 球队具体信息比如球队全名等
	public ArrayList<TeamInfoVO> teamDetailInfo() {
		ArrayList<TeamInfoVO> teamInfoList = new ArrayList<TeamInfoVO>();
		return teamInfoList;
	}
}
