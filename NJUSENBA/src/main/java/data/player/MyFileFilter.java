package data.player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MyFileFilter implements FileFilter{
	private String playerName;
	private ArrayList<String> playerDatas=new ArrayList<String>();
	private ArrayList<String> firstTeamDatas=new ArrayList<String>();
	private ArrayList<String> teamTime=new ArrayList<String>();
    public MyFileFilter(String playername){
    	this.playerName=playername;
    }
    public ArrayList<String> getPlayerDatas(){
    	if(playerDatas.size()!=0){
    		return playerDatas;
    	}else{
    		return null;
    	}
    }
    public ArrayList<String> getTeams(){
    	if(firstTeamDatas.size()!=0){	
    		return firstTeamDatas;
    		}
    	else{return null;}
    
    }
    public ArrayList<String> getTeamTime(){
    	if(teamTime.size()!=0){
    		return teamTime;
    	}else{
    		return null;
    	}
    }
	public boolean accept(File pathname) {
		// TODO Auto-generated method stub
		boolean find=false;
		try {
			BufferedReader br=new BufferedReader(new FileReader(pathname));
			String str;
			
			try {
				while((str=br.readLine())!=null){
					String team="";
					if(str.length()==3){team=str;}
					if(str.contains(playerName)){
						find=true;
						playerDatas.add(str);
						firstTeamDatas.add(team);
						String pathnameStrs[]=pathname.toString().split("_");
						teamTime.add(pathnameStrs[1]);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.print("io exception");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("file not found");
		}
		return find;
	}
	
}
