package logic;

import java.util.ArrayList;

import vo.PlayerPersonalInfoVO;
import vo.PlayerVO;

public class FliterPlayer {
	
	public ArrayList<PlayerVO> filterSortBy(String position, String league, String sortBy){
		ArrayList<PlayerVO> playerList = new ArrayList<PlayerVO>();
		ArrayList<PlayerPersonalInfoVO> playerInfoList = new ArrayList<PlayerPersonalInfoVO>();
		PlayerBL player = new PlayerBL();
		playerList = player.allPlayerSeasonData();
		/*球员的球队会有很多也许，
		所在球队不在同一个区的话，暂时按照只要包含筛选条件的分区就可以
		position as above*/
		/**
		 * 可以通过球员位置（前锋中锋后卫），
		 * 球员联盟（东部西部以及各自分区），
		 * 排序依据（得分，篮板，助攻，得分/篮板/助攻（加权比1：1：1），
		 * 			盖帽，抢断，犯规，失误，分钟，效率，投篮，三分，罚球，
		 * 			两双（特指得分，篮板，助攻，抢断，盖帽中任何两项））
		 * 进行筛选，筛选出前五十名球员信息
		 * */
		//TODO 筛选position
		playerInfoList = player.playerPersonalInfo();
		int length = playerList.size();
		for (int i=0;i < length;i++){
			String originalP = playerInfoList.get(i).getPosition();
			boolean sortP = false;
			if (originalP.length()>1){
				String temp[] = originalP.split("-");
				for (int j=0;j < temp.length;j++){
					if(temp[j].equals(position)){
						sortP = true;
						break;
					}
				}
				if(!sortP){
					playerList.remove(i);
				}
			} else if (originalP.length() == 1){
				if(!position.equals(playerInfoList.get(i).getPosition())){
					playerList.remove(i);
				}
			} else {
				System.out.println("no original position.");
				playerList.remove(i);
			}
		}
		//TODO 筛选分区
		//TODO 筛选排序条件-暂时都按照num不是rate-shoot shi efficiency
		int key = -1;
		switch (sortBy){
		case "score": key = 16;
		case "rebound": key = 4;
		case "assisting": key = 5;
		case "S_R_A": 
		case "blockShot": key = 13;
		case "steal": key = 12;
		case "foul": key = 15;
		case "muff": key = 14;
		case "playTime": 
		case "efficiency": key = 17;
		case "shoot": key = 20;
		case "threePoint": key = 8;  
		case "freeThrow": key = 9;
		case "D_D": 
		default: 
			System.out.println("invalid sortBy.");
			break;
		}
		player.sort_Ascend(0, playerList);
		return playerList;
	}
	
	public boolean sortPosition(String originalP, String position ){
		return true;
	}
	public boolean sortLeague(){
		return true;
	}
}
