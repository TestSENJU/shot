package BL;

import java.util.ArrayList;

import Data.ReadFileThread;

public class playerBL_Drive {
public static void main(String args[]){	
	ReadFileThread rft=new ReadFileThread("D://newData//matches");
	rft.start();
//TeamBL teambl=new TeamBL_Impl();
ArrayList<Integer>nums=new ArrayList<Integer>();
nums.add(0);
nums.add(25);

//ArrayList<TeamAverageVO> list=teambl.getHotTeamByNum(nums, 20);
//System.out.println(list.get(0).getTeamName());

//ArrayList<TeamAverageVO>list=teambl.getTeamAverageRankingByNum(nums, 20);
//System.out.println(list.get(0).getLeague());
//ArrayList<TeamAllVO>list=teambl.getTeamAllRankingByNumDeclining(nums, 20);

//ArrayList<TeamAverageVO>list=teambl.getTeamAverageRankingByNum(nums, 20);
//	PlayerBL playerbl=new PlayerBL_Impl();
//	ArrayList<Integer> nums=new ArrayList<Integer>();
//	nums.add(11);
//	nums.add(1);
//	ArrayList<PlayerAllVO>list=playerbl.getPlayerAllByMultipleConRaising("F", "E", "22",nums , 50);
//    System.out.println(list.get(0).getPlayerName());
//	ArrayList<PlayerAverageVO>list=playerbl.getPlayerAverageByMultipleConRaising("F", "E", "22",nums , 50);
//	System.out.println(list.get(0).getName());
	
//	ArrayList<PlayerAverageVO>list=playerbl.getImprovedPlayerByNum(24, 5);
//	System.out.println(list.get(0).getName());
	
//	ArrayList<PlayerShortVO> list=playerbl.getHotPlayerByNum(0, 20);
//	System.out.println(list.get(0).getPlayerName());
	
//	ArrayList<PlayerShortVO>list=playerbl.getTodayHotPlayerByNum(0, 20);
//	System.out.println(list.get(0).getPlayerName());
	
//		ArrayList<PlayerShortVO> polist1=playerbl.getHotPlayerByNum(0, 10);
//	ArrayList<PlayerShortVO> polist2=playerbl.getTodayHotPlayerByNum(0);
//	for(int i=0;i<polist1.size();i++){
//		System.out.println(polist1.get(i).getPlayerName()+polist1.get(i).getNum());
//	}
//	for(int i=0;i<polist2.size();i++){
	//	System.out.println(polist2.get(i).getPlayerName()+polist2.get(i).getNum());
//	}
//	for(int i=0;i<polist1.size();i++){
//		System.out.println(polist1.get(i).getNum());
//	}
//	for(int i=0;i<polist2.size();i++){
//		System.out.println(polist2.get(i).getNum());
//	}
}
}