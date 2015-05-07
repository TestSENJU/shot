package Data;

import java.io.File;
import java.util.ArrayList;

import po.MatchPO;
import po.MatchShortPO;
import po.PlayerAllPlusRatePO;
import po.PlayerAveragePlusRatePO;
import po.PlayerBasicPO;
import po.PlayerShortPO;
import po.TeamAllPlusRatePO;
import po.TeamAveragePlusRatePO;
import po.TeamBasicPO;
import vo.MatchVO;

public class PlayerData_Drive {
public static void main(String args[]){
	ReadFileThread rft=new ReadFileThread("D://newData");
//	String filenames[]=new File("E://matches").list();
//	for(int i=0;i<filenames.length;i++){
//		System.out.println(filenames[i]);
//	}

	rft.start();rft.run();
//	rft.run();
	PlayerDataService playerData=new PlayerData_Impl();
//	ArrayList<PlayerShortPO> list=playerData.getShortPlayerByNum(1);
//	ArrayList<PlayerShortPO> list1=playerData.getShortPlayerToday(1);
//	for(int i=0;i<list1.size();i++){
//		System.out.println(list1.get(i).getNum());
//	}
//	for(int i=0;i<list.size();i++){
//		System.out.println(list.get(i).getNum());
//	}
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
	
	PlayerAllPlusRatePO player=playerData.getPlayerAllByName("	Joel Freeland");
	System.out.println(player.getPlayerData()[24]);
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
//	ArrayList<MatchShortPO> list=matchData.getShortMatchByPeriod("13-14_01-01","13-14_02-01");
//	for(int i=0;i<list.size();i++){
//		System.out.println(list.get(i).getName());
//	}
//	ArrayList<MatchShortPO> match=matchData.getAllMatch();
//	for(int i=0;i<match.size();i++){
//		System.out.println(match.get(i).getName());
//		System.out.println(match.get(i).getTeam1());
//	}
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
	
//	ArrayList<MatchPO> list=matchData.getMatchByTeam("ATL");
//	for(int i=0;i<list.size();i++){
//		MatchPO match=list.get(i);
//		System.out.println(match.getName());
//		System.out.println(match.getTeam1());
//		System.out.println(match.getTeam2());
//		System.out.println(match.getPointer());
//		ArrayList<String>list2=match.getPointerPart();
//		for(int j=0;j<list2.size();j++){
//			System.out.println(list2.get(j));
//		}
//		ArrayList<String[]>list1=match.getList2();
//		for(int j=0;j<list1.size();j++){
//			String strs[]=list1.get(j);
//			for(int k=0;k<strs.length;k++){
//				System.out.print(strs[k]);
//				System.out.print(";");
//			}
//			System.out.println();
//	}
//	}
	
	// 赢得比赛的数量
	TeamDataService team=new TeamData_Impl();
//	ArrayList<String>list=team.getAllTeamNames();
//	for(int i=0;i<list.size();i++){
//		System.out.println(list.get(i));
//	}
//	String name=team.getTeamName("CHA");
//	System.out.print(name);
	
//	TeamAllPlusRatePO po=team.getTeamAllByName("CHA");
//	System.out.println(po.getTeamName());
//	System.out.println(po.getMatchNum());
//	System.out.println(po.getTeamNameLong());
//	System.out.println(po.getWinNum());
//	ArrayList<String> list=po.getPlayerList();
//	System.out.println(list.size());
//	for(int i=0;i<list.size();i++){
//		System.out.println(list.get(i));
//	}
//    double[] nums=po.getTeamData();
//    for(int i=0;i<nums.length;i++){
//    	System.out.println(nums[i]);
//    }
//
//	TeamBasicPO po=team.getTeamBasicByName("CHA");
//	String strs[]=po.getTeamInfo();
//	for(int i=0;i<strs.length;i++){
//		System.out.println(strs[i]);
//	}
	
//	ArrayList<TeamBasicPO>list=team.getTeamBasic();
//	for(int i=0;i<list.size();i++){
//		TeamBasicPO po=list.get(i);
//        System.out.println(po.getTeamName());
//        System.out.println(po.getLongName());
//		String strs[]=po.getTeamInfo();
//		for(int j=0;j<strs.length;j++){
//			System.out.println(strs[j]);
//	}
//	
//}
//	ArrayList<String> list=team.getPlayerNamesOfTeam("CHA");
//	for(int i=0;i<list.size();i++){
//		System.out.println(list.get(i));
//	}
//	System.out.println(team.getTeamName("CHA"));
	
//    ArrayList<TeamAveragePlusRatePO>list=team.getTeamAverage();
//    for(int i=0;i<list.size();i++){
//    	TeamAveragePlusRatePO po=list.get(i);
//    	System.out.println(po.getTeamNameLong());
//    	System.out.println(po.getMatchNum());
//    	System.out.println(po.getWinNum());
//    	double nums[]=po.getTeamData();
//    	ArrayList<String> playernames=po.getPlayerList();
//    	for(int j=0;j<nums.length;j++){
//    		System.out.println(nums[j]);
//    	}
//    	for(int j=0;j<playernames.size();j++){
//    		System.out.println(playernames.get(j));
//    	}
//    	
//    }
//	TeamAveragePlusRatePO  po=team.getTeamAverageByName("CHA");
//	System.out.println(po.getTeamNameLong());
//	System.out.println(po.getMatchNum());
//	System.out.println(po.getWinNum());
//	double nums[]=po.getTeamData();
//	ArrayList<String> playernames=po.getPlayerList();
//	for(int j=0;j<nums.length;j++){
//		System.out.println(nums[j]);
//	}
//	for(int j=0;j<playernames.size();j++){
//		System.out.println(playernames.get(j));
//	}
}
}
//
