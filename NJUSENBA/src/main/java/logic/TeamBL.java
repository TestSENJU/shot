package logic;

import java.util.ArrayList;

import vo.TeamInfoVO;
import vo.TeamVO;

public class TeamBL {
	//TODO 所有球队的原始总赛季数据
	public ArrayList<TeamVO> allTeamSeasonData(){
		ArrayList<TeamVO> teamList = new ArrayList<TeamVO>();
		return teamList;
	}
	//TODO 所有球队的原始场均数据
	public ArrayList<TeamVO> allTeamAverageData(){
		ArrayList<TeamVO> teamList = new ArrayList<TeamVO>();
		return teamList;
	}
	//所有队伍信息-升序排列
	public ArrayList<TeamVO> sort_Ascend(int key, ArrayList<TeamVO> teamList){
		SortAllTeam st = new SortAllTeam();
		ArrayList<TeamVO> reTeamList = new ArrayList<TeamVO>();
		reTeamList = st.ascendTeam(key, teamList);
		return reTeamList;
	}
	//所有队伍信息-降序排列
	public ArrayList<TeamVO> sort_Descend(int key, ArrayList<TeamVO> teamList){
		SortAllTeam st = new SortAllTeam();
		ArrayList<TeamVO> reTeamList = new ArrayList<TeamVO>();
		reTeamList = st.descendTeam(key, teamList);
		return reTeamList;
	}
	//TODO 球队具体信息比如球队全名等
	public ArrayList<TeamInfoVO> teamDetailInfo(){
		ArrayList<TeamInfoVO> teamInfoList = new ArrayList<TeamInfoVO>();
		return teamInfoList;
	}
}
