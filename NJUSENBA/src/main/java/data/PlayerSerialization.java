package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Iterator;

import po.Player_AllScorePO;
import po.Player_AverageScorePO;
import po.Player_BasicInfoPO;


public class PlayerSerialization {
static Hashtable<String,Player_AverageScorePO> averScoreTable=new Hashtable<String,Player_AverageScorePO>();
static Hashtable<String,Player_AllScorePO> allScoreTable=new Hashtable<String,Player_AllScorePO>();  
static Hashtable<String,Player_BasicInfoPO> basicinfoTable=new Hashtable<String,Player_BasicInfoPO>(); 
private static String teampath="teams/teams";
private static String playerpath="players";
private static String matchpath="matches";
private static String playerAll_serialpath="serialization/playerAllScore";
private static String playerAver_serialpath="serialization/playerAverageScore";
private static String playerBasic_serialpath="serialization/playerBasicInfo";


public PlayerSerialization(){
	readPlayerFiles(playerpath);
	readMatchFiles(matchpath);
	setAverage();
	readTeamFiles(teampath);
	writeFileAllScore(playerAll_serialpath);
	writeFileAverScore(playerAver_serialpath);
	writeFileBasicInfo(playerBasic_serialpath);
}
private static void readMatchFiles(String path){
	File list[] = new File(path).listFiles();
	for (int i = 0; i < list.length; i++) {
		readOneMatch(list[i]);
	}
}
private static void readPlayerFiles(String path){
	String list[] = new File(playerpath).list();
	for (int i = 0; i < list.length; i++) {
		
			String spl = list[i].toString();;
			if (!basicinfoTable.containsKey(spl)){
				Player_BasicInfoPO playerInfo=new Player_BasicInfoPO(spl);
				String s[]=new String[9];
				String ss[]=new String[8];
				int n=0;
				BufferedReader br;
				try {
					br = new BufferedReader(
							new InputStreamReader(new FileInputStream(list[i]),"UTF-8"));
					String str;
			    	try {
						while((str=br.readLine())!=null){
							if(str.contains("│")){
								String strs[]=str.split("│");
								s[n]=(strs[1].substring(0, strs[1].length()-1));
								n++;
							}
						}
						
						for(int j=0;j<8;j++){
							ss[j]=s[j+1];
						}
						playerInfo.setBasicInfo(ss);
						basicinfoTable.put(spl, playerInfo);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.print("ioexception");
					}
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
				System.out.print("unspportedencoding");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.print("filenotfound");
				} 			
			}			
			if (!allScoreTable.containsKey(spl))
				allScoreTable.put(spl, new Player_AllScorePO(spl));
			if (!averScoreTable.containsKey(spl)){
				averScoreTable.put(spl, new Player_AverageScorePO(spl));	
			}
	}
	
}
private static void readTeamFiles(String path){
	for(Iterator<String>  it=allScoreTable.keySet().iterator(); it.hasNext();){   
	     String key=(String)it.next();   
	     String teamName=allScoreTable.get(key).getTeam();    
	     allScoreTable.get(key).setTeamArea(getTeamArea(teamName,path));
	  }  

}
@SuppressWarnings("resource")
private static String getTeamArea(String teamName,String path){
	String result="";
	BufferedReader br;
		try {
			br = new BufferedReader(
						new InputStreamReader(new FileInputStream(path)));
			 String str;
			try {
				while((str=br.readLine())!=null){
					  if(str.contains(teamName)){
						  String strs[]=str.split(";");
						  result= strs[3]+"-"+strs[4];
						 
					  }
				   }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.print("io");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("filenotfound");
		}
		return result;
}
private static void setAverage(){
	for(Iterator<String>  it=allScoreTable.keySet().iterator(); it.hasNext();){   
        String key=(String)it.next();   
        Player_AllScorePO value=allScoreTable.get(key);   
        averScoreTable.get(key).setAllScore(value);;                   
    }  
}
private static void readOneMatch(File file){
	FileReader fr;
	try {
		fr=new FileReader(file);
		@SuppressWarnings("resource")
		BufferedReader br=new BufferedReader(fr);
		String str="";
		String team="";
		boolean haveTeam=false;
		while((str=br.readLine())!=null){
			if(str.length()==3){
				team=str;
				haveTeam=true;
			}
			if(haveTeam){
				String strs[]=str.split(";");
				//包含错误逻辑检测，如果在球员的文件夹里没有这个球员，而比赛里面直接不会把这个球员的数据加进去
				if(basicinfoTable.contains(strs[0])){
					String s[]=new String[14];
					for(int i=0;i<s.length;i++){
						s[i]=strs[i+3];
					}
					if(allScoreTable.get(strs[0]).checkData(strs[2], s)){
						allScoreTable.get(strs[0]).addAllScore(s);
						allScoreTable.get(strs[0]).addTimeAll(strs[2]);
						if(strs[1]!=""){				
							allScoreTable.get(strs[0]).addnumOfFirstMatches(1);
							}
							
							allScoreTable.get(strs[0]).addnumOfMatches(1);
							allScoreTable.get(strs[0]).setTeam(team);
					}				
				}
			}
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("file not found read one match");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("ioexception readonematch");
	}
}
public void writeFileAllScore(String path){
	FileReadAndWriteBuffer.write_to_file(playerAll_serialpath, allScoreTable);
}
public void writeFileAverScore(String path){
	FileReadAndWriteBuffer.write_to_file(playerAver_serialpath, averScoreTable);

}
public void writeFileBasicInfo(String path){
	FileReadAndWriteBuffer.write_to_file(playerBasic_serialpath, basicinfoTable);

}
}
