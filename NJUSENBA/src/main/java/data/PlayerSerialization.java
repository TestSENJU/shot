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
import java.util.Set;

import po.Player_AllScorePO;
import po.Player_AverageScorePO;
import po.Player_BasicInfoPO;


public class PlayerSerialization {
static Hashtable<String,Player_AverageScorePO> averScoreTable=new Hashtable<String,Player_AverageScorePO>();
static Hashtable<String,Player_AllScorePO> allScoreTable=new Hashtable<String,Player_AllScorePO>();  
static Hashtable<String,Player_BasicInfoPO> basicinfoTable=new Hashtable<String,Player_BasicInfoPO>(); 
private static String teampath="teams/teams";
private static String playerpath="players/info";
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

private static void readPlayerFiles(String path){
	String list[] = new File(path).list();
	for (int i = 0; i < list.length; i++) {
		
			String spl = list[i];
			if (!basicinfoTable.containsKey(spl)){
				Player_BasicInfoPO playerInfo=new Player_BasicInfoPO(spl);
				String s[]=new String[9];
				String ss[]=new String[8];
				
				BufferedReader br;
				try {
					br = new BufferedReader(
							new InputStreamReader(new FileInputStream(path+"/"+list[i]),"UTF-8"));
					String str;
					int n=0;
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
	}
	
}
private static void readTeamFiles(String path){
	for(Iterator<String>  it=allScoreTable.keySet().iterator(); it.hasNext();){   
	     String key=(String)it.next();   
	     String teamName=allScoreTable.get(key).getTeam();    
	     allScoreTable.get(key).setTeamArea(getTeamArea(teamName,path));
	  }  

}
private static void readMatchFiles(String path){
	File list[] = new File(path).listFiles();
	for (int i = 0; i < list.length; i++) {
		readOneMatch(list[i]);
	}
}
@SuppressWarnings("resource")
private static String getTeamArea(String teamName,String path){
	if(teamName!=null){
		String result="";
		BufferedReader br;
			try {
				br = new BufferedReader(
							new InputStreamReader(new FileInputStream(path)));
				 String str;
				try {
					while((str=br.readLine())!=null){
						  if(str.contains(teamName)){
							  String strs[]=str.split("│");
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
	}else{
		return null;
	}
	
}
private static void setAverage(){
	Set<String>keys=allScoreTable.keySet();
	for(String key:keys){
		Player_AverageScorePO averScore=new Player_AverageScorePO(key);
		averScore.setAllScore(allScoreTable.get(key));
		averScoreTable.put(key, averScore);
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
				if(str.length()!=3){
					String strs[]=str.split(";");	
						if(checkData(strs[2], strs)){
							double s[]=new double[14];
							for(int i=0;i<s.length;i++){
								s[i]=Double.parseDouble(strs[i+3]);
							}							
								if(allScoreTable.containsKey(strs[0])){
									allScoreTable.get(strs[0]).addAllScore(s);
									allScoreTable.get(strs[0]).addTimeAll(strs[2]);
									char c[]=strs[1].toCharArray();
									if(c.length!=0){
										if(c[0]<='Z'&&c[0]>='A'){				
											allScoreTable.get(strs[0]).addnumOfFirstMatches(1);
										}
									}								
									allScoreTable.get(strs[0]).addnumOfMatches(1);
									allScoreTable.get(strs[0]).setTeam(team);
								}else{
									Player_AllScorePO allScore_new=new Player_AllScorePO(strs[0]);
									allScore_new.setScoresAll(s);
									allScore_new.addnumOfMatches(1);
									allScore_new.addTimeAll(strs[2]);
									if(strs[1]!=null){	
										allScore_new.addnumOfFirstMatches(1);
									}	
									if(basicinfoTable.containsKey(strs[0])){
										allScoreTable.put(strs[0], allScore_new);
									}
								}
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
/**
 * 
 * @param time
 * 错误逻辑检测时间，检查是不是符合格式
 * @param s
 * 错误检查是不是每个都可以变成整型
 * @return
 */
private static boolean checkData(String time,String[] s){
	boolean right=true;
	String ss[]=time.split(":");
	if(ss.length!=2)right=false;
	 double nums[]=new double[14];
	for(int i=0;i<nums.length;i++){
		double num;
		try {
			num = Double.parseDouble(s[i+3]);
			nums[i]=num;
	        i++;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			right=false;
		}
        
//要是格式不对了直接就返回不加这次比赛里的这一行了
      }

	 if(!(nums[0]>nums[1]||nums[2]>nums[3]||
			 nums[4]>nums[5]||nums[6]+nums[7]!=nums[8])){
		 right=false;
	 }
	return right;
}
}
