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
//	String filenames[]=new File("E://matches").list();
//	for(int i=0;i<filenames.length;i++){
//		System.out.println(filenames[i]);
//	}
	rft.start();
//	rft.run();
	PlayerDataService playerData=new PlayerData_Impl();
//	PlayerBasicPO basic=playerData.getPlayerBasicByName("Aaron Brooks");
//	System.out.println(basic.getPlayerName());
//	String[] strs=basic.getBasicInfo();
//	for(int i=0;i<strs.length;i++){
//		System.out.println(strs[i]);
//	}
//	PlayerAveragePlusRatePO player=playerData.getPlayerAverageByName("Aaron Brooks");
//	System.out.println(player.getName());
//	System.out.println(player.getCompeteNum());
//	System.out.println(player.getOffensiveNum());
//	System.out.println(player.getPlayingTime());
//	double[] data=player.getPlayerData();
//	for(int i=0;i<data.length;i++){
//		System.out.println(data[i]);
//	}
//  ArrayList<String>list=player.getTeamList();
//  ArrayList<String>list1=player.getTeamAreaList();
//	for(int i=0;i<list.size();i++){
//		System.out.println(list.get(i));
//		System.out.println(list1.get(i));
//	}
	//球员所属球队，提升率,average
//	ArrayList<PlayerAveragePlusRatePO> list=playerData.getPlayerAverage();
//	for(int i=0;i<list.size();i++){
//		PlayerAveragePlusRatePO player=list.get(i);
//		System.out.println(player.getName());
//		System.out.println(player.getCompeteNum());
//		System.out.println(player.getOffensiveNum());
//		System.out.println(player.getPlayingTime());
//		double[] data=player.getPlayerData();
//		for(int j=0;j<data.length;j++){
//			System.out.println(data[j]);
//	}
//	}
	
//	PlayerAveragePlusRatePO po=playerData.getPlayerAverageByName("Aaron Brooks");
//	System.out.println(po.getPlayingTime());
	
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
	
	
	
	
	MatchDataService matchData=new MatchData_Impl();
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
	
	ArrayList<MatchPO> list=matchData.getMatchByTeam("ATL");
	for(int i=0;i<list.size();i++){
		MatchPO match=list.get(i);
		System.out.println(match.getName());
		System.out.println(match.getTeam1());
		System.out.println(match.getTeam2());
		System.out.println(match.getPointer());
		ArrayList<String>list2=match.getPointerPart();
		for(int j=0;j<list2.size();j++){
			System.out.println(list2.get(j));
		}
		ArrayList<String[]>list1=match.getList2();
		for(int j=0;j<list1.size();j++){
			String strs[]=list1.get(j);
			for(int k=0;k<strs.length;k++){
				System.out.print(strs[k]);
				System.out.print(";");
			}
			System.out.println();
	}
	}
	
//	TeamDataService team=new TeamData_Impl();
	
}
}
//
