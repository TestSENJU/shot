package logic;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import po.TeamPO;
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
			//teamList.add(new TeamVO(polist.get(key)));
		}
		return teamList;
	}

	// TODO 所有球队的原始场均数据
	public ArrayList<TeamVO> allTeamAverageData() {
		ArrayList<TeamVO> teamList = new ArrayList<TeamVO>();
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
