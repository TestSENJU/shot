package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
		boolean haveTeam=false;
		String team1="";
		String team2="";
		String teamTime1="0:0";
		String teamTime2="0:0";
        int i=0;
        ArrayList<String> list1=new ArrayList<String>();
        ArrayList<String>list2=new ArrayList<String>();
        double[] nums1=new double[]{0,0,0,0,0,0,0,0};
        double[] nums2=new double[]{0,0,0,0,0,0,0,0};
		while((str=br.readLine())!=null){
			if(str.length()==3){
				if(i==0){
					team1=str;
					haveTeam=true;
					i++;
				}else{
					team2=str;
				}			
		    }else{
		    	if(haveTeam){
					if(checkData(str)){
						if(team2!=""){
							list1.add(str);
						}else{
							list2.add(str);
						}
					}	
				}
		    }		
		}
		ArrayList<String[]>strlist1=new ArrayList<String[]>();
		ArrayList<String[]>strlist2=new ArrayList<String[]>();
		
		for(int j=0;j<list1.size();j++){
			String strs[]=list1.get(j).split(";");
			
			String s[]=teamTime1.split(":");
			String ss[]=strs[2].split(":");

			int seconds=Integer.parseInt(ss[1])+Integer.parseInt(s[1]);
			if(seconds<60){
				teamTime1=(Integer.parseInt(ss[0])+Integer.parseInt(s[0])+"")
						+":"	+(seconds+"");	
			}else{
				teamTime1=(Integer.parseInt(ss[0])+Integer.parseInt(s[0])+1+"")
						+":"	+(seconds-60+"");	
			}			
			nums1[0]+=Double.parseDouble(strs[3]);
			nums1[1]+=Double.parseDouble(strs[4]);
			nums1[2]+=Double.parseDouble(strs[6]);
			nums1[3]+=Double.parseDouble(strs[8]);
			nums1[4]+=Double.parseDouble(strs[9]);
			nums1[5]+=Double.parseDouble(strs[10]);
			nums1[6]+=Double.parseDouble(strs[11]);
			nums1[7]=Double.parseDouble(strs[15]);
			
			strlist1.add(strs);
			
		}			
		for(int j=0;j<list2.size();j++){
			String strs[]=list2.get(j).split(";");
			String s[]=teamTime2.split(":");
			String ss[]=strs[2].split(":");

			int seconds=Integer.parseInt(ss[1])+Integer.parseInt(s[1]);
			if(seconds<60){
				teamTime2=(Integer.parseInt(ss[0])+Integer.parseInt(s[0])+"")
						+":"	+(seconds+"");	
			}else{
				teamTime2=(Integer.parseInt(ss[0])+Integer.parseInt(s[0])+1+"")
						+":"	+(seconds-60+"");	
			}
			
			nums2[0]+=Double.parseDouble(strs[3]);
			nums2[1]+=Double.parseDouble(strs[4]);
			nums2[2]+=Double.parseDouble(strs[6]);
			nums2[3]+=Double.parseDouble(strs[8]);
			nums2[4]+=Double.parseDouble(strs[9]);
			nums2[5]+=Double.parseDouble(strs[10]);
			nums2[6]+=Double.parseDouble(strs[11]);
			nums2[7]=Double.parseDouble(strs[15]);
			
			strlist2.add(strs);
		}
		for(int j=0;j<strlist1.size();j++){
			String strs[]=strlist1.get(j);
			double nums[]=new double[15];
			for(int n=0;n<nums.length;n++){
				nums[n]=Double.parseDouble(strs[n+3]);
			}							
				if(allScoreTable.containsKey(strs[0])){
					allScoreTable.get(strs[0]).addAllScore(nums);
					allScoreTable.get(strs[0]).addTimeAll(strs[2]);
					char c[]=strs[1].toCharArray();
					if(c.length!=0){
						if(c[0]<='Z'&&c[0]>='A'){				
							allScoreTable.get(strs[0]).addnumOfFirstMatches(1);
						}
					}								
					allScoreTable.get(strs[0]).addnumOfMatches(1);
					allScoreTable.get(strs[0]).setTeam(team1);
					allScoreTable.get(strs[0]).addTeamAll(nums1);
					allScoreTable.get(strs[0]).addCompeteAll(nums2);
					allScoreTable.get(strs[0]).addTimeTeam(teamTime1);
				}else{
					Player_AllScorePO allScore_new=new Player_AllScorePO(strs[0]);
					allScore_new.setScoresAll(nums);
					allScore_new.addnumOfMatches(1);
					allScore_new.addTimeAll(strs[2]);
					allScore_new.setTeam(team1);
					allScore_new.addTeamAll(nums1);
					allScore_new.addCompeteAll(nums2);
					allScore_new.addTimeTeam(teamTime1);
					if(strs[1]!=null){	
						allScore_new.addnumOfFirstMatches(1);
					}	
					if(basicinfoTable.containsKey(strs[0])){
						allScoreTable.put(strs[0], allScore_new);
					}
				}
		}
		for(int j=0;j<strlist2.size();j++){
			String strs[]=strlist2.get(j);
			double nums[]=new double[15];
			for(int n=0;n<nums.length;n++){
				nums[n]=Double.parseDouble(strs[n+3]);
			}							
				if(allScoreTable.containsKey(strs[0])){
					allScoreTable.get(strs[0]).addAllScore(nums);
					allScoreTable.get(strs[0]).addTimeAll(strs[2]);
					char c[]=strs[1].toCharArray();
					if(c.length!=0){
						if(c[0]<='Z'&&c[0]>='A'){				
							allScoreTable.get(strs[0]).addnumOfFirstMatches(1);
						}
					}								
					allScoreTable.get(strs[0]).addnumOfMatches(1);
					allScoreTable.get(strs[0]).setTeam(team2);
					allScoreTable.get(strs[0]).addTeamAll(nums2);
					allScoreTable.get(strs[0]).addCompeteAll(nums1);
					allScoreTable.get(strs[0]).addTimeTeam(teamTime2);
				}else{
					Player_AllScorePO allScore_new=new Player_AllScorePO(strs[0]);
					allScore_new.setScoresAll(nums);
					allScore_new.addnumOfMatches(1);
					allScore_new.addTimeAll(strs[2]);
					allScore_new.setTeam(team2);
					allScore_new.addTeamAll(nums2);
					allScore_new.addCompeteAll(nums1);
					allScore_new.addTimeTeam(teamTime2);
					if(strs[1]!=null){	
						allScore_new.addnumOfFirstMatches(1);
					}	
					if(basicinfoTable.containsKey(strs[0])){
						allScoreTable.put(strs[0], allScore_new);
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
 * @param s
 * 错误检查是不是每个都可以变成整型  错误逻辑检测时间，检查是不是符合格式
 * @return
 */
private static boolean checkData(String s){
	boolean right=true;
	String strs[]=s.split(";");
	String ss[]=strs[2].split(":");
	if(ss.length!=2)right=false;
	 double nums[]=new double[15];
	for(int i=0;i<nums.length;i++){
		double num;
		try {
			num = Double.parseDouble(strs[i+3]);
			nums[i]=num;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			right=false;
		}
      }
	 if((nums[0]>nums[1]||nums[2]>nums[3]||
			 nums[4]>nums[5]||nums[6]+nums[7]!=nums[8])){
		 right=false;
	 }
	return right;
}
}
