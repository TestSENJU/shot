package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import vo.TeamAverageVO;

public class SortTeamAverage {
	//升序排列
	public ArrayList<TeamAverageVO> ascendTeam(int key, ArrayList<TeamAverageVO> ascendTeamList){
		switch(key){
		case 0: 
			Collections.sort(ascendTeamList, new TeamASortByName());
			break;
		case 1:
			Collections.sort(ascendTeamList, new TeamASortByMatchSum());
			break;
		case 2:
			Collections.sort(ascendTeamList, new TeamASortByHitSum());
			break;
		case 3:
			Collections.sort(ascendTeamList, new TeamASortByShootSum());
			break;
		case 4:
			Collections.sort(ascendTeamList, new TeamASortByThreePointHitSum());
			break;
		case 5:
			Collections.sort(ascendTeamList, new TeamASortByThreePointSum());
			break;
		case 6:
			Collections.sort(ascendTeamList, new TeamASortByFreeThrowHitSum());
			break;
		case 7:
			Collections.sort(ascendTeamList, new TeamASortByFreeThrowSum());
			break;
		case 8:
			Collections.sort(ascendTeamList, new TeamASortByOffensiveReboundSum());
			break;
		case 9:
			Collections.sort(ascendTeamList, new TeamASortByDefensiveReboundSum());
			break;
		case 10:
			Collections.sort(ascendTeamList, new TeamASortByReboundSum());
			break;
		case 11:
			Collections.sort(ascendTeamList, new TeamASortByAssistingSum());
			break;
		case 12:
			Collections.sort(ascendTeamList, new TeamASortByStealSum());
			break;
		case 13:
			Collections.sort(ascendTeamList, new TeamASortByBlockShotSum());
			break;
		case 14:
			Collections.sort(ascendTeamList, new TeamASortByMuffSum());
			break;
		case 15:
			Collections.sort(ascendTeamList, new TeamASortByFoulSum());
			break;
		case 16:
			Collections.sort(ascendTeamList, new TeamASortByScore());
			break;
		case 17:
			Collections.sort(ascendTeamList, new TeamASortByHitRate());
			break;
		case 18:
			Collections.sort(ascendTeamList, new TeamASortByThreePointHitRate());
			break;
		case 19:
			Collections.sort(ascendTeamList, new TeamASortByFreeThrowHitRate());
			break;
		case 20:
			Collections.sort(ascendTeamList, new TeamASortByWinRate());
			break;
		case 21:
			Collections.sort(ascendTeamList, new TeamASortByOffensiveRound());
			break;
		case 22:
			Collections.sort(ascendTeamList, new TeamASortByOffensiveEfficiency());
			break;
		case 23:
			Collections.sort(ascendTeamList, new TeamASortByDefensiveEfficiency());
			break;
		case 24:
			Collections.sort(ascendTeamList, new TeamASortByOfReboundRate());
			break;
		case 25:
			Collections.sort(ascendTeamList, new TeamASortByDeReboundRate());
		case 26:
			Collections.sort(ascendTeamList, new TeamASortByStealRate());
			break;
		case 27:
			Collections.sort(ascendTeamList, new TeamASortByAssistingRate());
			break;
		default:
				System.out.println("invalid");
				break;
		}
		return ascendTeamList;
	}
	//降序排列
	public ArrayList<TeamAverageVO> descendTeam(int key, ArrayList<TeamAverageVO> descendTeamList){
		ArrayList<TeamAverageVO> ascendTemp = new ArrayList<TeamAverageVO>();
		ascendTemp = ascendTeam(key, descendTeamList);
		ArrayList<TeamAverageVO> reDeTeamList = new ArrayList<TeamAverageVO>();
		for(int i=0;i < descendTeamList.size();i++){
			reDeTeamList.add(ascendTemp.get(descendTeamList.size()-i-1));
		}
		return reDeTeamList;
	}
}

class TeamASortByName implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getName().compareTo(t2.getName());
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class TeamASortByMatchSum implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getMatchSum() - t2.getMatchSum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class TeamASortByHitSum implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getHitSum() - t2.getHitSum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class TeamASortByShootSum implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getShootSum() - t2.getShootSum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class TeamASortByThreePointHitSum implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getThreePointHitSum() - t2.getThreePointHitSum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class TeamASortByThreePointSum implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getThreePointSum() - t2.getThreePointSum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class TeamASortByFreeThrowHitSum implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getFreeThrowHitSum() - t2.getFreeThrowHitSum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class TeamASortByFreeThrowSum implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getFreeThrowSum() - t2.getFreeThrowSum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class TeamASortByOffensiveReboundSum implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getOffensiveReboundSum() - t2.getOffensiveReboundSum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class TeamASortByDefensiveReboundSum implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getDefensiveReboundSum() - t2.getDefensiveReboundSum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class TeamASortByReboundSum implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getReboundSum() - t2.getReboundSum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class TeamASortByAssistingSum implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getAssistingSum() - t2.getAssistingSum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class TeamASortByStealSum implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getStealSum() - t2.getStealSum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class TeamASortByBlockShotSum implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getBlockShotSum() - t2.getBlockShotSum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class TeamASortByMuffSum implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getMuffSum() - t2.getMuffSum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class TeamASortByFoulSum implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getFoulSum() - t2.getFoulSum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class TeamASortByScore implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getScore() - t2.getScore();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
class TeamASortByHitRate implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getHitRate() - t2.getHitRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
class TeamASortByThreePointHitRate implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getThreePointHitRate() - t2.getThreePointHitRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
class TeamASortByFreeThrowHitRate implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getFreeThrowHitRate() - t2.getFreeThrowHitRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
class TeamASortByWinRate implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getWinRate() - t2.getWinRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
class TeamASortByOffensiveRound implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2){
		double temp = t1.getOffensiveRound() - t2.getOffensiveRound();
		return temp > 0 ? 1 : (temp < 0 ? -1 : 0);
	}
}
class TeamASortByOffensiveEfficiency implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getOffensiveEfficiency() - t2.getOffensiveEfficiency();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
class TeamASortByDefensiveEfficiency implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getDefensiveEfficiency() - t2.getDefensiveEfficiency();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
class TeamASortByOfReboundRate implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getOffensiveReboundRate() - t2.getOffensiveReboundRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
class TeamASortByDeReboundRate implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getDefensiveReboundRate() - t2.getDefensiveReboundRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
class TeamASortByStealRate implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getStealRate() - t2.getStealRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
class TeamASortByAssistingRate implements Comparator<TeamAverageVO> {
	public int compare(TeamAverageVO t1, TeamAverageVO t2) {
		double temp = t1.getAssistingRate() - t2.getAssistingRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
