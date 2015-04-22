package Data;

import java.io.File;
import java.util.ArrayList;

import po.MatchPO;
import po.PlayerAllPlusRatePO;
import po.PlayerAveragePlusRatePO;
import po.PlayerBasicPO;
import vo.MatchVO;

public class PlayerData_Drive {
public static void main(String args[]){
	ReadFileThread rft=new ReadFileThread("E://matches");
//	String filenames[]=new File("E://newData").list();
//	for(int i=0;i<filenames.length;i++){
//		System.out.println(filenames[i]);
//	}
	rft.start();
	PlayerDataService playerData=new PlayerData_Impl();
//	PlayerBasicPO basic=playerData.getPlayerBasicByName("Aaron Brooks");
//	System.out.println(basic.getPlayerName());
//	String[] strs=basic.getBasicInfo();
//	for(int i=0;i<strs.length;i++){
//		System.out.println(strs[i]);
//	}
	PlayerAveragePlusRatePO player=playerData.getPlayerAverageByName("Aaron Brooks");
	System.out.println(player.getName());
	System.out.println(player.getCompeteNum());
	System.out.println(player.getOffensiveNum());
	System.out.println(player.getPlayingTime());
	double[] data=player.getPlayerData();
	for(int i=0;i<data.length;i++){
		System.out.println(data[i]);
	}
  ArrayList<String>list=player.getTeamList();
  ArrayList<String>list1=player.getTeamAreaList();
  System.out.println(list1.size());
	for(int i=0;i<list.size();i++){
		System.out.println(list.get(i));
		System.out.println(list1.get(i));
	}
//	ArrayList<String>list=playerData.getAllPlayerNames();
//	for(int i=0;i<list.size();i++){
//		System.out.println(list.get(i));
//	}
//	ArrayList<String>list=new ArrayList<String>();
//	list=playerData.getMatchNamesByPlayerName("Aaron Brooks");
//	for(int i=0;i<list.size();i++){
//		System.out.println(list.get(i));
//	}
//	PlayerAllPlusRatePO player=playerData.getPlayerAllByName("Aaron Brooks");
//	System.out.println(player.getName());
//	System.out.println(player.getCompeteNum());
//	System.out.println(player.getOffensiveNum());
//	System.out.println(player.getPlayingTime());
//	double[] data=player.getPlayerData();
//	for(int i=0;i<data.length;i++){
//		System.out.println(data[i]);
//	}
//    ArrayList<String>list=player.getTeamList();
//    ArrayList<String>list1=player.getTeamAreaList();
//	for(int i=0;i<list.size();i++){
//		System.out.println(list.get(i));
//		System.out.println(list1.get(i));
//	}
	
	
	
	
//	MatchDataService matchData=new MatchData_Impl();
//	MatchPO match=matchData.getMatchByName("13-14_01-01_CHA-LAC");
//	System.out.println(match.getName());
//	System.out.println(match.getTeam1());
//	System.out.println(match.getTeam2());
//	System.out.println(match.getPointer());
//	ArrayList<String>list=match.getPointerPart();
//	for(int i=0;i<list.size();i++){
//		System.out.println(list.get(i));
//	}
//	ArrayList<String[]>list1=match.getList2();
//	for(int i=0;i<list1.size();i++){
//		String strs[]=list1.get(i);
//		for(int j=0;j<strs.length;j++){
//			System.out.print(strs[j]);
//			System.out.print(";");
//		}
//		System.out.println();
//	}
	
	
	
//	TeamDataService team=new TeamData_Impl();
	
}
}
