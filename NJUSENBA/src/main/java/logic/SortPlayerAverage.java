package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import vo.PlayerAverageVO;

public class SortPlayerAverage {
	public ArrayList<PlayerAverageVO> ascendPlayer(int key, ArrayList<PlayerAverageVO> ascendPlayerList){
		
		switch(key){
		case 0:
			Collections.sort(ascendPlayerList, new SortAByName());
			break;
		case 1:
			Collections.sort(ascendPlayerList, new SortAByPlayTime());
		case 2:
			Collections.sort(ascendPlayerList, new SortAByCompeteNum());
			break;
		case 3:
			Collections.sort(ascendPlayerList, new SortAByOffensiveNum());
			break;
		case 4:
			Collections.sort(ascendPlayerList, new SortAByReboundNum());
			break;
		case 5:
			Collections.sort(ascendPlayerList, new SortAByAssistingNum());
			break;
		case 7:
			Collections.sort(ascendPlayerList, new SortAByHitRate());
			break;
		case 8:
			Collections.sort(ascendPlayerList, new SortAByThreePointHitRate());
			break;
		case 9:
			Collections.sort(ascendPlayerList, new SortAByFreeThrowHitRate());
			break;
		case 10:
			Collections.sort(ascendPlayerList, new SortAByOffensiveReboundNum());
			break;
		case 11:
			Collections.sort(ascendPlayerList, new SortAByDefensiveReboundNum());
			break;
		case 12:
			Collections.sort(ascendPlayerList, new SortAByStealNum());
			break;
		case 13:
			Collections.sort(ascendPlayerList, new SortAByBlockShotNum());
			break;
		case 14:
			Collections.sort(ascendPlayerList, new SortAByMuffNum());
			break;
		case 15:
			Collections.sort(ascendPlayerList, new SortAByFoulNum());
			break;
		case 16:
			Collections.sort(ascendPlayerList, new SortAByScore());
			break;
		case 17:
			Collections.sort(ascendPlayerList, new SortAByEfficiency());
			break;
		case 18:
			Collections.sort(ascendPlayerList, new SortAByGmScEfficiency());
			break;
		case 19:
			Collections.sort(ascendPlayerList, new SortAByTrueHitRate());
			break;
		case 20:
			Collections.sort(ascendPlayerList, new SortAByShootEfficiency());
			break;
		case 21:
			Collections.sort(ascendPlayerList, new SortAByReboundRate());
			break;
		case 22:
			Collections.sort(ascendPlayerList, new SortAByOffensiveReboundRate());
			break;
		case 23:
			Collections.sort(ascendPlayerList, new SortAByDefensiveReboundRate());
			break;
		case 24:
			Collections.sort(ascendPlayerList, new SortAByAssistingRate());
			break;
		case 25:
			Collections.sort(ascendPlayerList, new SortAByStealRate());
			break;
		case 26:
			Collections.sort(ascendPlayerList, new SortAByBlockShotRate());
			break;
		case 27:
			Collections.sort(ascendPlayerList, new SortAByMuffRate());
			break;
		case 28:
			Collections.sort(ascendPlayerList, new SortAByUsage());
			break;
		case 29:
			Collections.sort(ascendPlayerList, new SortABySRA());
			break;
		default:
				System.out.println("invalid input");
				break;
		}
		//Collections.sort(ascendPlayerList, new SortByName());
		return ascendPlayerList;
	}
	//降序排列
	public ArrayList<PlayerAverageVO> descendPlayer(int key, ArrayList<PlayerAverageVO> descendPlayerList){
		//
		ArrayList<PlayerAverageVO> deTempPlayerList = new ArrayList<PlayerAverageVO>();
		ArrayList<PlayerAverageVO> deRePlayerList = new ArrayList<PlayerAverageVO>();
		deTempPlayerList = ascendPlayer(key, descendPlayerList);
		for (int i=0;i < descendPlayerList.size();i++){
			deRePlayerList.add(deTempPlayerList.get(descendPlayerList.size()-i-1));
		}
		return deRePlayerList;
	}
}

class SortAByName implements Comparator<PlayerAverageVO> {
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		return p1.getName().compareTo(p2.getName());
	}
}
class SortAByPlayTime implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		String time1 = p1.getPlayingTime();
		String time2 = p2.getPlayingTime();
		String[] temp1 = time1.split(":");
		String[] temp2 = time2.split(":");
		if(Integer.parseInt(temp1[0])>Integer.parseInt(temp2[0])){
			return 1;
		} else if (Integer.parseInt(temp1[0])<Integer.parseInt(temp2[0])){
			return 0;
		} else if (Integer.parseInt(temp1[0])==Integer.parseInt(temp2[0])){
			return Integer.parseInt(temp1[0])-Integer.parseInt(temp2[0]);
		} else {
			return 0;
		}
	}
}
class SortAByCompeteNum implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getCompeteNum() - p2.getCompeteNum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class SortAByOffensiveNum implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getOffensiveNum() - p2.getOffensiveNum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class SortAByReboundNum implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getReboundNum() - p2.getReboundNum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class SortAByAssistingNum implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getAssistingNum() - p2.getAssistingNum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
//
class SortAByHitRate implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getHitRate() - p2.getHitRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortAByThreePointHitRate implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getThreePointHitRate() - p2.getThreePointHitRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortAByFreeThrowHitRate implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getFreeThrowHitRate() - p2.getFreeThrowHitRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
class SortAByOffensiveReboundNum implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getOffensiveReboundNum() - p2.getOffensiveReboundNum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class SortAByDefensiveReboundNum implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getDefensiveReboundNum() - p2.getDefensiveReboundNum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class SortAByStealNum implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getStealNum() - p2.getStealNum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class SortAByBlockShotNum implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getBlockShotNum() - p2.getBlockShotNum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class SortAByMuffNum implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getMuffNum() - p2.getMuffNum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class SortAByFoulNum implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getFoulNum() - p2.getFoulNum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class SortAByScore implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getScore() - p2.getScore();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortAByEfficiency implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getEfficiency() - p2.getEfficiency();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortAByGmScEfficiency implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getGmScEfficiency() - p2.getGmScEfficiency();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortAByTrueHitRate implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getTrueHitRate() - p2.getTrueHitRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortAByShootEfficiency implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getShootEfficiency() - p2.getShootEfficiency();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortAByReboundRate implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getReboundRate() - p2.getReboundRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortAByOffensiveReboundRate implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getOffensiveReboundRate() - p2.getOffensiveReboundRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortAByDefensiveReboundRate implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getDefensiveReboundRate() - p2.getDefensiveReboundRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortAByAssistingRate implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getAssistingRate() - p2.getAssistingRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortAByStealRate implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getStealRate() - p2.getStealRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortAByBlockShotRate implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getBlockShotRate() - p2.getBlockShotRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortAByMuffRate implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getMuffRate() - p2.getMuffRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortAByUsage implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getUsage() - p2.getUsage();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortABySRA implements Comparator<PlayerAverageVO>{
	public int compare(PlayerAverageVO p1, PlayerAverageVO p2) {
		double temp = p1.getScore()+p1.getReboundNum()+p1.getAssistingNum()
				-p2.getScore()-p2.getReboundNum()-p2.getAssistingNum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
