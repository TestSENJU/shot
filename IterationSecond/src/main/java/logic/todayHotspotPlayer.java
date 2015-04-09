package logic;
//当天热点球员
import java.util.ArrayList;
import java.util.Collections;

import VO.playerInformationVO;
import VO.playerMatchDataVO;

public class todayHotspotPlayer {
//篮板
	public playerInformationVO getHotspotPlayer(String condition){
		if(condition.equals("得分")){
			ArrayList<playerMatchDataVO> list=new ArrayList<playerMatchDataVO>();
			Collections.sort(list,new sortByScore);
			
		}
	}
}
