package logic;

import java.util.ArrayList;

import vo.TeamAverageVO;
import vo.TeamInfoVO;
import vo.TeamStrVO;
import vo.TeamVO;

public interface TeamService {
	// 所有球队的原始总赛季数据
	public ArrayList<TeamStrVO> allTeamStr();
	// 所有球队的原始场均数据
	public ArrayList<TeamStrVO> allTeamAverStr();
	//所有队伍信息-升序排列
	public ArrayList<TeamStrVO> ascendTeamStr(int key, ArrayList<TeamVO> teamOrigin);
	//所有队伍信息-降序排列
	public ArrayList<TeamStrVO> descendTeamStr(int key, ArrayList<TeamVO> teamOrigin);
	//队伍场均信息-升序排列
	public ArrayList<TeamStrVO> ascendTeamAStr(int key, ArrayList<TeamAverageVO> teamOrigin);
	//队伍场均信息-降序排列
	public ArrayList<TeamStrVO> descendTeamAStr(int key, ArrayList<TeamAverageVO> teamOrigin);
	//TODO 球队具体信息比如球队全名等
	public ArrayList<TeamInfoVO> teamDetailInfo();
	//TODO 某只球队的总赛季数据
	public ArrayList<TeamStrVO> teamAllInfo(String name);
	//TODO 某支球队的场均数据
	public ArrayList<TeamStrVO> teamAverageInfo(String name);
}
