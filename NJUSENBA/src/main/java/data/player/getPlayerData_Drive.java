package data.player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import data.player.getPlayerData_Impl;
import po.PlayerPO;
import po.Player_AllScorePO;
import po.Player_AverageScorePO;

public class getPlayerData_Drive {
public static void main(String args[]) throws IOException{
	getPlayerData getters=new getPlayerData_Impl();
	PlayerPO newPlayer=getters.getPlayer("Ramon Sessions");
	
	ArrayList<String> list=newPlayer.getTeams();
//	for(int i=0;i<list.size();i++){System.out.print(list.get(i));}
//	System.out.println(newPlayer.getTeam());
//	FileReaderForTeams frT=new FileReaderForTeams("E:\\teams\\teams");
//	System.out.print(frT.getTeamArea("CHA"));
//	System.out.println(newPlayer.getArea());
    String[] info=newPlayer.getBasicInfo();
//    for(int i=0;i<info.length;i++){
//    	System.out.print(info[i]);
//    }
    Player_AllScorePO all=new Player_AllScorePO();
    all=newPlayer.getScoresInAll();
    System.out.println(all.getNumOfMatches());
    System.out.println(all.getNumOfFirstMatches());
    double dataAll[]=all.getScoresAll();
    for(int i=0;i<dataAll.length;i++){
    	System.out.print(dataAll[i]+" ");
    }
    System.out.println();
    Player_AverageScorePO aver=new Player_AverageScorePO();
    double dataAver[]=aver.getScoresAverage();
    for(int j=0;j<dataAver.length;j++){
    	System.out.print(dataAver[j]+" ");
    }
    System.out.print(aver.getTimeAver());
//	System.out.print(list.size());
//	System.out.print(list.size());
	
//	MyFileFilter filter=new MyFileFilter("Aaron Brooks");
//	File root=new File("E:\\matches");
//	File files[]=root.listFiles(filter);
//	ArrayList<String> list=filter.getPlayerDatas();
//	for(int i=0;i<list.size();i++){
//		System.out.println(list.get(i));
//	}
	
//	BufferedReader br=new BufferedReader(new FileReader("E:\\teams\\teams"));
//	String str;
//	while((str=br.readLine())!=null){
//		System.out.println(str);
//	}
}
}
