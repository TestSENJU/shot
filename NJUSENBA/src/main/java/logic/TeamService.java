package logic;

import java.util.ArrayList;

import vo.TeamInfoVO;
import vo.TeamVO;

public interface TeamService {
	//TODO 所有球队的原始总赛季数据
	public ArrayList<TeamVO> allTeamSeasonData();
	//TODO 所有球队的原始场均数据
	public ArrayList<TeamVO> allTeamAverageData();
	//所有队伍信息-升序排列
	public ArrayList<TeamVO> sort_Ascend(int key, ArrayList<TeamVO> teamList);
	//所有队伍信息-降序排列
	public ArrayList<TeamVO> sort_Descend(int key, ArrayList<TeamVO> teamList);
	//TODO 球队具体信息比如球队全名等
	public ArrayList<TeamInfoVO> teamDetailInfo();
}
