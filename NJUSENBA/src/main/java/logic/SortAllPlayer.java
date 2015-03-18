package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import vo.PlayerVO;

public class SortAllPlayer {
	public static ArrayList<PlayerVO> playerList;
	//写的很冗长。。给每个属性写了个sort类。。降序就是先升序再反过来放进arrayList
	public ArrayList<PlayerVO> ascendPlayer(int key, ArrayList<PlayerVO> ascendPlayerList){
		//ArrayList<PlayerVO> ascendPlayerList = new ArrayList<PlayerVO>();
		switch(key){
		case 0:
			Collections.sort(ascendPlayerList, new SortByName());
			break;
		case 2:
			Collections.sort(ascendPlayerList, new SortByCompeteNum());
			break;
		case 3:
			Collections.sort(ascendPlayerList, new SortByOffensiveNum());
			break;
		case 4:
			Collections.sort(ascendPlayerList, new SortByReboundNum());
			break;
		case 5:
			Collections.sort(ascendPlayerList, new SortByAssistingNum());
			break;
		case 7:
			Collections.sort(ascendPlayerList, new SortByHitRate());
			break;
		case 8:
			Collections.sort(ascendPlayerList, new SortByThreePointHitRate());
			break;
		case 9:
			Collections.sort(ascendPlayerList, new SortByFreeThrowHitRate());
			break;
		case 10:
			Collections.sort(ascendPlayerList, new SortByOffensiveReboundNum());
			break;
		case 11:
			Collections.sort(ascendPlayerList, new SortByDefensiveReboundNum());
			break;
		case 12:
			Collections.sort(ascendPlayerList, new SortByStealNum());
			break;
		case 13:
			Collections.sort(ascendPlayerList, new SortByBlockShotNum());
			break;
		case 14:
			Collections.sort(ascendPlayerList, new SortByMuffNum());
			break;
		case 15:
			Collections.sort(ascendPlayerList, new SortByFoulNum());
			break;
		case 16:
			Collections.sort(ascendPlayerList, new SortByScore());
			break;
		case 17:
			Collections.sort(ascendPlayerList, new SortByEfficiency());
			break;
		case 18:
			Collections.sort(ascendPlayerList, new SortByGmScEfficiency());
			break;
		case 19:
			Collections.sort(ascendPlayerList, new SortByTrueHitRate());
			break;
		case 20:
			Collections.sort(ascendPlayerList, new SortByShootEfficiency());
			break;
		case 21:
			Collections.sort(ascendPlayerList, new SortByReboundRate());
			break;
		case 22:
			Collections.sort(ascendPlayerList, new SortByOffensiveReboundRate());
			break;
		case 23:
			Collections.sort(ascendPlayerList, new SortByDefensiveReboundRate());
			break;
		case 24:
			Collections.sort(ascendPlayerList, new SortByAssistingRate());
			break;
		case 25:
			Collections.sort(ascendPlayerList, new SortByStealRate());
			break;
		case 26:
			Collections.sort(ascendPlayerList, new SortByBlockShotRate());
			break;
		case 27:
			Collections.sort(ascendPlayerList, new SortByMuffRate());
			break;
		case 28:
			Collections.sort(ascendPlayerList, new SortByUsage());
			break;
		default:
				System.out.println("invalid input");
		}
		//Collections.sort(ascendPlayerList, new SortByName());
		return ascendPlayerList;
	}
	public ArrayList<PlayerVO> descendPlayer(int key, ArrayList<PlayerVO> descendPlayerList){
		//TODO 除了这个还有double的问题TAT
		ArrayList<PlayerVO> deTempPlayerList = new ArrayList<PlayerVO>();
		ArrayList<PlayerVO> deRePlayerList = new ArrayList<PlayerVO>();
		deTempPlayerList = ascendPlayer(key, descendPlayerList);
		for (int i=0;i < descendPlayerList.size();i++){
			deRePlayerList.add(deTempPlayerList.get(descendPlayerList.size()-i-1));
		}
		return deRePlayerList;
	}
}

class SortByName implements Comparator<PlayerVO> {
	public int compare(PlayerVO p1, PlayerVO p2) {
		return p1.getName().compareTo(p2.getName());
	}
}
class SortByCompeteNum implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		return p1.getCompeteNum() - p2.getCompeteNum();
	}
}
class SortByOffensiveNum implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		return p1.getOffensiveNum() - p2.getOffensiveNum();
	}
}
class SortByReboundNum implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		return p1.getReboundNum() - p2.getReboundNum();
	}
}
class SortByAssistingNum implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		return p1.getAssistingNum() - p2.getAssistingNum();
	}
}
//double
class SortByHitRate implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		if (p1.getHitRate() > p2.getHitRate()){
			return 1;
		} else {
			return 0;
		}
	}
}
//double
class SortByThreePointHitRate implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		if (p1.getThreePointHitRate() > p2.getThreePointHitRate()){
			return 1;
		} else {
			return 0;
		}
	}
}
//double
class SortByFreeThrowHitRate implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		if (p1.getFreeThrowHitRate() > p2.getFreeThrowHitRate()){
			return 1;
		} else {
			return 0;
		}
	}
}
class SortByOffensiveReboundNum implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		return p1.getOffensiveReboundNum() - p2.getOffensiveReboundNum();
	}
}
class SortByDefensiveReboundNum implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		return p1.getDefensiveReboundNum() - p2.getDefensiveReboundNum();
	}
}
class SortByStealNum implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		return p1.getStealNum() - p2.getStealNum();
	}
}
class SortByBlockShotNum implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		return p1.getBlockShotNum() - p2.getBlockShotNum();
	}
}
class SortByMuffNum implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		return p1.getMuffNum() - p2.getMuffNum();
	}
}
class SortByFoulNum implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		return p1.getFoulNum() - p2.getFoulNum();
	}
}
class SortByScore implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		if (p1.getScore() > p2.getScore()){
			return 1;
		} else {
			return 0;
		}
	}
}
//double
class SortByEfficiency implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		if (p1.getEfficiency() > p2.getEfficiency()){
			return 1;
		} else {
			return 0;
		}
	}
}
//double
class SortByGmScEfficiency implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		if (p1.getGmScEfficiency() > p2.getGmScEfficiency()){
			return 1;
		} else {
			return 0;
		}
	}
}
//double
class SortByTrueHitRate implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		if (p1.getTrueHitRate() > p2.getTrueHitRate()){
			return 1;
		} else {
			return 0;
		}
	}
}
//double
class SortByShootEfficiency implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		if (p1.getShootEfficiency() > p2.getShootEfficiency()){
			return 1;
		} else {
			return 0;
		}
	}
}
//double
class SortByReboundRate implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		if (p1.getReboundRate() > p2.getReboundRate()){
			return 1;
		} else {
			return 0;
		}
	}
}
//double
class SortByOffensiveReboundRate implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		if (p1.getOffensiveReboundRate() > p2.getOffensiveReboundRate()){
			return 1;
		} else {
			return 0;
		}
	}
}
//double
class SortByDefensiveReboundRate implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		if (p1.getDefensiveReboundRate() > p2.getDefensiveReboundRate()){
			return 1;
		} else {
			return 0;
		}
	}
}
//double
class SortByAssistingRate implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		if (p1.getAssistingRate() > p2.getAssistingRate()){
			return 1;
		} else {
			return 0;
		}
	}
}
//double
class SortByStealRate implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		if (p1.getStealRate() > p2.getStealRate()){
			return 1;
		} else {
			return 0;
		}
	}
}
//double
class SortByBlockShotRate implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		if (p1.getBlockShotRate() > p2.getBlockShotRate()){
			return 1;
		} else {
			return 0;
		}
	}
}
//double
class SortByMuffRate implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		if (p1.getMuffRate()> p2.getMuffRate()){
			return 1;
		} else {
			return 0;
		}
	}
}
//double
class SortByUsage implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		if (p1.getUsage() > p2.getUsage()){
			return 1;
		} else {
			return 0;
		}
	}
}