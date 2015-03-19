package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import vo.TeamVO;

public class SortAllTeam {
	//升序排列
	public ArrayList<TeamVO> ascendTeam(int key, ArrayList<TeamVO> ascendTeamList){
		switch(key){
		case 0: 
			Collections.sort(ascendTeamList, new TeamSortByName());
			break;
		case 1:
			Collections.sort(ascendTeamList, new TeamSortByMatchSum());
			break;
		case 2:
			Collections.sort(ascendTeamList, new TeamSortByHitSum());
			break;
		case 3:
			Collections.sort(ascendTeamList, new TeamSortByShootSum());
			break;
		case 4:
			Collections.sort(ascendTeamList, new TeamSortByThreePointHitSum());
			break;
		case 5:
			Collections.sort(ascendTeamList, new TeamSortByThreePointSum());
			break;
		case 6:
			Collections.sort(ascendTeamList, new TeamSortByFreeThrowHitSum());
			break;
		case 7:
			Collections.sort(ascendTeamList, new TeamSortByFreeThrowSum());
			break;
		case 8:
			Collections.sort(ascendTeamList, new TeamSortByOffensiveReboundSum());
			break;
		case 9:
			Collections.sort(ascendTeamList, new TeamSortByDefensiveReboundSum());
			break;
		case 10:
			Collections.sort(ascendTeamList, new TeamSortByReboundSum());
			break;
		case 11:
			Collections.sort(ascendTeamList, new TeamSortByAssistingSum());
			break;
		case 12:
			Collections.sort(ascendTeamList, new TeamSortByStealSum());
			break;
		case 13:
			Collections.sort(ascendTeamList, new TeamSortByBlockShotSum());
			break;
		case 14:
			Collections.sort(ascendTeamList, new TeamSortByMuffSum());
			break;
		case 15:
			Collections.sort(ascendTeamList, new TeamSortByFoulSum());
			break;
		case 16:
			Collections.sort(ascendTeamList, new TeamSortByScore());
			break;
		case 17:
			Collections.sort(ascendTeamList, new TeamSortByHitRate());
			break;
		case 18:
			Collections.sort(ascendTeamList, new TeamSortByThreePointHitRate());
			break;
		case 19:
			Collections.sort(ascendTeamList, new TeamSortByFreeThrowHitRate());
			break;
		case 20:
			Collections.sort(ascendTeamList, new TeamSortByWinRate());
			break;
		case 21:
			Collections.sort(ascendTeamList, new TeamSortByOffensiveRound());
			break;
		case 22:
			Collections.sort(ascendTeamList, new TeamSortByOffensiveEfficiency());
			break;
		case 23:
			Collections.sort(ascendTeamList, new TeamSortByDefensiveEfficiency());
			break;
		case 24:
			Collections.sort(ascendTeamList, new TeamSortByReboundRate());
			break;
		case 25:
			Collections.sort(ascendTeamList, new TeamSortByStealRate());
			break;
		case 26:
			Collections.sort(ascendTeamList, new TeamSortByAssistingRate());
			break;
		default:
				System.out.println("invalid");
				break;
		}
		return ascendTeamList;
	}
	//降序排列
	public ArrayList<TeamVO> descendTeam(int key, ArrayList<TeamVO> descendTeamList){
		ArrayList<TeamVO> ascendTemp = new ArrayList<TeamVO>();
		ascendTemp = ascendTeam(key, descendTeamList);
		ArrayList<TeamVO> reDeTeamList = new ArrayList<TeamVO>();
		for(int i=0;i < descendTeamList.size();i++){
			reDeTeamList.add(ascendTemp.get(descendTeamList.size()-i-1));
		}
		return reDeTeamList;
	}
}

class TeamSortByName implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		return t1.getName().compareTo(t2.getName());
	}
}
class TeamSortByMatchSum implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		return t1.getMatchSum() - t2.getMatchSum();
	}
}
class TeamSortByHitSum implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		return t1.getHitSum() - t2.getHitSum();
	}
}
class TeamSortByShootSum implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		return t1.getShootSum() - t2.getShootSum();
	}
}
class TeamSortByThreePointHitSum implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		return t1.getThreePointHitSum() - t2.getThreePointHitSum();
	}
}
class TeamSortByThreePointSum implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		return t1.getThreePointSum() - t2.getThreePointSum();
	}
}
class TeamSortByFreeThrowHitSum implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		return t1.getFreeThrowHitSum() - t2.getFreeThrowHitSum();
	}
}
class TeamSortByFreeThrowSum implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		return t1.getFreeThrowSum() - t2.getFreeThrowSum();
	}
}
class TeamSortByOffensiveReboundSum implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		return t1.getOffensiveReboundSum() - t2.getOffensiveReboundSum();
	}
}
class TeamSortByDefensiveReboundSum implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		return t1.getDefensiveReboundSum() - t2.getDefensiveReboundSum();
	}
}
class TeamSortByReboundSum implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		return t1.getReboundSum() - t2.getReboundSum();
	}
}
class TeamSortByAssistingSum implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		return t1.getAssistingSum() - t2.getAssistingSum();
	}
}
class TeamSortByStealSum implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		return t1.getStealSum() - t2.getStealSum();
	}
}
class TeamSortByBlockShotSum implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		return t1.getBlockShotSum() - t2.getBlockShotSum();
	}
}
class TeamSortByMuffSum implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		return t1.getMuffSum() - t2.getMuffSum();
	}
}
class TeamSortByFoulSum implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		return t1.getFoulSum() - t2.getFoulSum();
	}
}
class TeamSortByScore implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		double temp = t1.getScore() - t2.getScore();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
class TeamSortByHitRate implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		double temp = t1.getHitRate() - t2.getHitRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
class TeamSortByThreePointHitRate implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		double temp = t1.getThreePointHitRate() - t2.getThreePointHitRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
class TeamSortByFreeThrowHitRate implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		double temp = t1.getFreeThrowHitRate() - t2.getFreeThrowHitRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
class TeamSortByWinRate implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		double temp = t1.getWinRate() - t2.getWinRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
class TeamSortByOffensiveRound implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2){
		double temp = t1.getOffensiveRound() - t2.getOffensiveRound();
		return temp > 0 ? 1 : (temp < 0 ? -1 : 0);
	}
}
class TeamSortByOffensiveEfficiency implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		double temp = t1.getOffensiveEfficiency() - t2.getOffensiveEfficiency();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
class TeamSortByDefensiveEfficiency implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		double temp = t1.getDefensiveEfficiency() - t2.getDefensiveEfficiency();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
class TeamSortByReboundRate implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		double temp = t1.getReboundRate() - t2.getReboundRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
class TeamSortByStealRate implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		double temp = t1.getStealRate() - t2.getStealRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
class TeamSortByAssistingRate implements Comparator<TeamVO> {
	public int compare(TeamVO t1, TeamVO t2) {
		double temp = t1.getAssistingRate() - t2.getAssistingRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
