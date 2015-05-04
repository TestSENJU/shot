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
        double[] nums1=new double[8];
        double[] nums2=new double[8];
        for(int j=0;j<nums1.length;j++){
        	nums1[j]=0.0;
        	nums2[j]=0.0;
        }
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
		    	//	if(checkData(str)){
		    			if(team2!=""){
							list2.add(str);
						}else{
							list1.add(str);
						}				
		    		}
				}
		    }		
		//}
        
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
	int error[]=new int[15];
	int rightNum[]=new int[15];
	for(int i=0;i<error.length;i++){
		error[i]=0;
		rightNum[i]=0;
	}
	for(int j=0;j<list.size();j++){
		String strs[]=list.get(j);
		CheckDataTool tool=new CheckDataTool();
		double result[]=tool.getDoubleData(strs);
		for(int i=0;i<result.length;i++){
			if(result[i]<0){
				error[i]++;			
			}else{
				rightNum[i]++;
				nums[i]+=result[i];
			}
		}
	}
	//如果有错误数据，直接先不加这个数字，然后取整个队伍的平均值
	for(int i=0;i<nums.length;i++){
		nums[i]+=error[i]*(nums[i]/rightNum[i]);
	}
	return nums;
}
private static double[] getOpponentDataByStrs(ArrayList<String[]>list){
	CheckDataTool tool=new CheckDataTool();
	double[] nums=new double[]{0,0,0};
	int error[]=new int[3];
	int rightNum[]=new int[3];
	for(int i=0;i<error.length;i++){
		error[i]=0;
		rightNum[i]=0;
	}
	for(int i=0;i<list.size();i++){
		double result[]=tool.getDoubleOpponentData(list.get(i));
		for(int j=0;j<result.length;j++){
			if(result[j]<0){
				error[j]++;
			}else{
				rightNum[j]++;
				nums[j]+=result[j];
			}
		}
	}
	for(int i=0;i<nums.length;i++){
		nums[i]+=error[i]*(nums[i]/rightNum[i]);
	}
	return nums;
}
private static double[] getTeamDataByStr(ArrayList<String[]> list){
	   double[] nums=new double[]{0,0,0,0,0,0,0,0};
	   int error[]=new int[8];
	   int rightNum[]=new int[8];
	   for(int i=0;i<error.length;i++){
		   error[i]=0;
		   rightNum[i]=0;
	   }
	   CheckDataTool tool=new CheckDataTool();
	for(int j=0;j<list.size();j++){
		double result[]=tool.getTeamData(list.get(j));
		for(int i=0;i<result.length;i++){
			if(result[i]<0){
				error[i]++;
			}else{
				rightNum[i]++;
				nums[i]+=result[i];
			}
		}
	}	
	for(int i=0;i<nums.length;i++){
		nums[i]+=error[i]*(nums[i]/rightNum[i]);
	}
	return nums;
}
}
