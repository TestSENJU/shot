package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import vo.PlayerVO;

public class SortAllPlayer {
	//写的很冗长。。给每个属性写了个sort类。。降序就是先升序再反过来放进arrayList
	public ArrayList<PlayerVO> ascendPlayer(int key, ArrayList<PlayerVO> ascendPlayerList){
		//ArrayList<PlayerVO> ascendPlayerList = new ArrayList<PlayerVO>();
		switch(key){
		case 0:
			Collections.sort(ascendPlayerList, new SortByName());
			break;
		case 1:
			Collections.sort(ascendPlayerList, new SortByPlayTime());
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
		case 29:
			Collections.sort(ascendPlayerList, new SortBySRA());
			break;
		default:
				System.out.println("invalid input");
				break;
		}
		//Collections.sort(ascendPlayerList, new SortByName());
		return ascendPlayerList;
	}
	//降序排列
	public ArrayList<PlayerVO> descendPlayer(int key, ArrayList<PlayerVO> descendPlayerList){
		//
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
class SortByPlayTime implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
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
		double temp = p1.getReboundNum() - p2.getReboundNum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class SortByAssistingNum implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		double temp = p1.getAssistingNum() - p2.getAssistingNum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
//
class SortByHitRate implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		double temp = p1.getHitRate() - p2.getHitRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortByThreePointHitRate implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		double temp = p1.getThreePointHitRate() - p2.getThreePointHitRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortByFreeThrowHitRate implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		double temp = p1.getFreeThrowHitRate() - p2.getFreeThrowHitRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
class SortByOffensiveReboundNum implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		double temp = p1.getOffensiveReboundNum() - p2.getOffensiveReboundNum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class SortByDefensiveReboundNum implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		double temp = p1.getDefensiveReboundNum() - p2.getDefensiveReboundNum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class SortByStealNum implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		double temp = p1.getStealNum() - p2.getStealNum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class SortByBlockShotNum implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		double temp = p1.getBlockShotNum() - p2.getBlockShotNum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class SortByMuffNum implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		double temp = p1.getMuffNum() - p2.getMuffNum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class SortByFoulNum implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		double temp = p1.getFoulNum() - p2.getFoulNum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0);
	}
}
class SortByScore implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		double temp = p1.getScore() - p2.getScore();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortByEfficiency implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		double temp = p1.getEfficiency() - p2.getEfficiency();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortByGmScEfficiency implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		double temp = p1.getGmScEfficiency() - p2.getGmScEfficiency();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortByTrueHitRate implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		double temp = p1.getTrueHitRate() - p2.getTrueHitRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortByShootEfficiency implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		double temp = p1.getShootEfficiency() - p2.getShootEfficiency();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortByReboundRate implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		double temp = p1.getReboundRate() - p2.getReboundRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortByOffensiveReboundRate implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		double temp = p1.getOffensiveReboundRate() - p2.getOffensiveReboundRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortByDefensiveReboundRate implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		double temp = p1.getDefensiveReboundRate() - p2.getDefensiveReboundRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortByAssistingRate implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		double temp = p1.getAssistingRate() - p2.getAssistingRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortByStealRate implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		double temp = p1.getStealRate() - p2.getStealRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortByBlockShotRate implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		double temp = p1.getBlockShotRate() - p2.getBlockShotRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortByMuffRate implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		double temp = p1.getMuffRate() - p2.getMuffRate();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortByUsage implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		double temp = p1.getUsage() - p2.getUsage();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}
//
class SortBySRA implements Comparator<PlayerVO>{
	public int compare(PlayerVO p1, PlayerVO p2) {
		double temp = p1.getScore()+p1.getReboundNum()+p1.getAssistingNum()
				-p2.getScore()-p2.getReboundNum()-p2.getAssistingNum();
		return temp > 0 ? 1:(temp < 0 ? -1 : 0); 
	}
}