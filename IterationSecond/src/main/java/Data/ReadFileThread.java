package Data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class ReadFileThread extends Thread{
	String path;
	private String filenames[];
	final int timePeriod=5000;
public ReadFileThread(String pathname){
	this.path=pathname;
	this.filenames=new File(path).list();
}
@Override
public void run(){
	while(true){
		try {
			sleep(timePeriod);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("readFileThread sleep");
		}
		String[] fileNames=new File(path).list();

		if(filenames!=null){
			if(fileNames!=null){
				
				if(fileNames.length>filenames.length){			
					try {
						BufferedWriter bw=new BufferedWriter(new FileWriter(new File("newFile.txt")));
						bw.write("1");
						bw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				ArrayList<String> list=new ArrayList<String>();
				Arrays.sort(filenames);
				Arrays.sort(fileNames);
				for(int i=filenames.length;i<fileNames.length;i++){
					list.add(fileNames[i]);
				}
				    for(int i=0;i<list.size();i++){
                        readFile(this.path+"//"+list.get(i));
				     }	
				    this.filenames=fileNames;
				}	
			}			
		}else{
			this.filenames=fileNames;
		}
		
	}
	
}

public void start(){
		for(int i=0;i<filenames.length;i++){
			readFile(this.path+"//"+filenames[i]);
}	
}

private void readFile(String filename){
	try {
		@SuppressWarnings("resource")
		BufferedReader br=new BufferedReader(new FileReader(filename));
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
        String str1=br.readLine();
        String str1sp[]=str1.split(";");
        String pointer=str1sp[2];
        String str2=br.readLine();
        String str2sp[]=str2.split(";");
        ArrayList<String>pointerpart=new ArrayList<String>();
        for(int j=0;j<str2sp.length;j++){
        	pointerpart.add(str2sp[j]);
        }
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
		    		//TODO
		    		if(checkData(str)){
		    			if(team2!=""){
							list2.add(str);
						}else{
							list1.add(str);
						}				
		    		}
				}
		    }		
		}
        
		ArrayList<String[]>strlist1=new ArrayList<String[]>();
		ArrayList<String[]>strlist2=new ArrayList<String[]>();
		ArrayList<String> playerList1=new ArrayList<String>();
		ArrayList<String>playerList2=new ArrayList<String>();
		for(int j=0;j<list1.size();j++){
			String[] strs=list1.get(j).split(";");
			strlist1.add(strs);
			teamTime1=refreshTime(teamTime1,strs[2]);
			playerList1.add(strs[0]);
		}
		System.out.println(playerList1.size()+"ewfq5hy45g34brtfgr");
		for(int j=0;j<list2.size();j++){
			String[] strs=list2.get(j).split(";");
			strlist2.add(strs);
			teamTime2=refreshTime(teamTime2,strs[2]);
			playerList2.add(strs[0]);
		}
		nums1=getTeamDataByStr(strlist1);
		nums2=getTeamDataByStr(strlist2);
		double TeamNum1[]=getTeamAllDataByStrs(strlist1);
		double TeamNum2[]=getTeamAllDataByStrs(strlist2);
		double opponentNum1[]=getOpponentDataByStrs(strlist1);
		double opponentNum2[]=getOpponentDataByStrs(strlist2);
		int i1=0;int i2=0;
		if(TeamNum1[14]>TeamNum2[14]){i1=1;i2=0;}else{i1=0;i2=1;}
		String filestrs[]=filename.split("//");
		
		TeamData_Impl.addToTable(TeamNum1, opponentNum2, filestrs[2], team1, playerList1,i1);
		TeamData_Impl.addToTable(TeamNum2,opponentNum1,filestrs[2],team2, playerList2,i2);
		

		MatchData_Impl.addToTable(filestrs[2], team1, teamTime1, strlist1, team2, strlist2, pointer, pointerpart);
		for(int k=0;k<list1.size();k++){
			PlayerData_Impl.addToToday(filestrs[2], list1.get(k));
			PlayerData_Impl.addToTable(strlist1.get(k),filestrs[2],team1,nums1,teamTime1,nums2);
		}
		for(int k=0;k<list2.size();k++){
			PlayerData_Impl.addToToday(filestrs[2], list2.get(k));
			
			PlayerData_Impl.addToTable(strlist2.get(k),filestrs[2],team2,nums2,teamTime2,nums1);
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
        System.out.println("read file file notfound");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		 System.out.println("read file io");
	}
}
private static String refreshTime(String teamTime1,String timeAdd){
	String s[]=teamTime1.split(":");
		String ss[]=timeAdd.split(":");

		int seconds=Integer.parseInt(ss[1])+Integer.parseInt(s[1]);
		if(seconds<60){
			teamTime1=(Integer.parseInt(ss[0])+Integer.parseInt(s[0])+"")
					+":"	+(seconds+"");	
		}else{
			teamTime1=(Integer.parseInt(ss[0])+Integer.parseInt(s[0])+1+"")
					+":"	+(seconds-60+"");	
		}	
		return teamTime1;
}
private static double[] getTeamAllDataByStrs(ArrayList<String[]>list){
	double[] nums=new double[15];
	for(int i=0;i<nums.length;i++)nums[i]=0;
	for(int j=0;j<list.size();j++){
		String strs[]=list.get(j);
		nums[0]+=Double.parseDouble(strs[3]);
		nums[1]+=Double.parseDouble(strs[4]);
		nums[2]+=Double.parseDouble(strs[5]);
		nums[3]+=Double.parseDouble(strs[6]);
		nums[4]+=Double.parseDouble(strs[7]);
		nums[5]+=Double.parseDouble(strs[8]);
		nums[6]+=Double.parseDouble(strs[9]);
		nums[7]+=Double.parseDouble(strs[10]);
		nums[8]+=Double.parseDouble(strs[11]);
		nums[9]+=Double.parseDouble(strs[12]);
		nums[10]+=Double.parseDouble(strs[13]);
		nums[11]+=Double.parseDouble(strs[14]);
		nums[12]+=Double.parseDouble(strs[15]);
		nums[13]+=Double.parseDouble(strs[16]);
		nums[14]+=Double.parseDouble(strs[17]);
	}
	return nums;
}
private static double[] getOpponentDataByStrs(ArrayList<String[]>list){
	double[] nums=new double[]{0,0,0};
	for(int i=0;i<list.size();i++){
		String strs[]=list.get(i);
		nums[0]+=Double.parseDouble(strs[6]);
		nums[1]+=Double.parseDouble(strs[7]);
		nums[2]+=Double.parseDouble(strs[14]);
	}
	return nums;
}
private static double[] getTeamDataByStr(ArrayList<String[]> list){
	   double[] nums1=new double[]{0,0,0,0,0,0,0,0};
	for(int j=0;j<list.size();j++){
		String strs[]=list.get(j);
							
		nums1[0]+=Double.parseDouble(strs[3]);
		nums1[1]+=Double.parseDouble(strs[4]);
		nums1[2]+=Double.parseDouble(strs[6]);
		nums1[3]+=Double.parseDouble(strs[8]);
		nums1[4]+=Double.parseDouble(strs[9]);
		nums1[5]+=Double.parseDouble(strs[10]);
		nums1[6]+=Double.parseDouble(strs[11]);
		nums1[7]=Double.parseDouble(strs[15]);
			
	}			
	return nums1;
}
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
