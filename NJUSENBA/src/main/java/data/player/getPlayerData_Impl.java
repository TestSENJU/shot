package data.player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import po.PlayerPO;
import po.Player_AllScorePO;
import po.Player_AverageScorePO;

public class getPlayerData_Impl implements getPlayerData{
	private  String filename="C://Users//Administrator//Desktop//matches";
	private String name="C://Users//Administrator//Desktop//players//info//";
	private MyFileFilter filter;
	//返回所有player文件夹中有名字的球员PO
	public ArrayList<PlayerPO> getAllPlayer() {
		// TODO Auto-generated method stub
		String list[]=new File(filename).list();
		ArrayList<PlayerPO> playerList=new ArrayList<PlayerPO>();
		for(int i=0;i<list.length;i++){
			playerList.add(this.getPlayer(list[i]));
		}
		return playerList;
	}
	//根据名字返回球员的PO
public PlayerPO getPlayer(String playerName) {
		// TODO Auto-generated method stub
	    filter=new MyFileFilter(playerName);
		PlayerPO player=new PlayerPO();
		player.setName(playerName);
		//调用getAllScores方法来设定playerPO里的Player_AllScorePO scoresInAll
		player.setScoresInAll(getAllScores(playerName));
		//设置基本信息
        player.setBasicInfo(getPlayerBasis(playerName));
        //设置平均数据
        player.setScoresAverage(getAverageScore(getAllScores(playerName)));
	    //球员曾经所属队伍设置
        ArrayList<String> teams=filter.getTeams();
        player.setTeams(teams);
        //球员当前队伍及联盟设置
        ArrayList<String>teamTime=filter.getTeamTime();
        String timeOri[]=teamTime.get(0).split("-");
        int teamNum=0;
        for(int i=1;i<teamTime.size();i++){
        	String time[]=teamTime.get(i).split("-");
        	if(Integer.parseInt(time[0])>Integer.parseInt(timeOri[0])){
        		teamNum=i;
        		timeOri=time;
        	}else{
        		if(Integer.parseInt(time[1])>Integer.parseInt(timeOri[1])){
        			teamNum=i;
        		}
        	}
        	String teamName=teams.get(teamNum);
        	player.setTeam(teamName);
        	player.setArea(getArea(teamName));
        }
        return player;
	}
//根据球队名字返回所在的联盟
@SuppressWarnings("resource")
private String getArea(String teamName){
	 BufferedReader br;
	try {
		br = new BufferedReader(
					new InputStreamReader(new FileInputStream("E://计算与软件工程3//迭代一数据//teams//teams"),"UTF-8"));
		 String str;
		try {
			while((str=br.readLine())!=null){
				  if(str.contains("LAC")){
					  String strs[]=str.split("│");
					 return strs[3]+"-"+strs[4];
				  }
			   }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	  
	return null;
}
	//返回playerPO里的Player_AllScorePO scoresInAll;//赛季总数据
	private Player_AllScorePO getAllScores(String playerName){
		Player_AllScorePO allScore=new Player_AllScorePO();
		ArrayList<String> list=getDetailedData(playerName);
		if(list!=null){
			//参赛场数
			allScore.setNumOfMatches(list.size());
			for(int i=0;i<list.size();i++){
				String ss[]=list.get(i).split(";");
				//上场时间
				allScore.addTimeAll(ss[2]);
				String[] strs=new String[14];
			
				if(ss[1]!=null){
					allScore.addFirstMatch();
				//先发场数
				}
				
				for(int j=0;j<strs.length;j++){
				strs[j]=ss[j+3];	//其余数据存放在一个数组里
				}
				allScore.addAllScore(strs);
			}
		}else{
			return null;
		}
		return allScore;
	}
	private Player_AverageScorePO getAverageScore(Player_AllScorePO AllScore){
		Player_AverageScorePO averageScore=new Player_AverageScorePO();
		double scoresAver[]=new double[14];
		double scoresAll[]=AllScore.getScoresAll();
		for(int i=0;i<14;i++){
			//数组里取平均
			scoresAver[i]=scoresAll[i]/AllScore.getNumOfMatches();
		}
		averageScore.setScoresAverage(scoresAver);
		//妈妈！这个时间一直好烦啊！！都不想管他了
		String timeAll=AllScore.getTimeAll();
		int matches=AllScore.getNumOfMatches();
		String times[]=timeAll.split(":");
		int hour=(int)Double.parseDouble(times[0])/matches;
		double minutes=Double.parseDouble(times[1])/matches
				+(Double.parseDouble(times[0])/matches-hour)*60;
		averageScore.setTimeAver(hour+""+":"+minutes);
		return averageScore;
	}
	//根据player文件夹中的info获取球员的一些基本信息
    @SuppressWarnings({ "resource" })
	private String[] getPlayerBasis(String playerName){
    	String info[]=new String[9];
    	int i=0;
    	BufferedReader br;
		try {
			br = new BufferedReader(
					new InputStreamReader(new FileInputStream(name+playerName),"UTF-8"));
			String str;
	    	try {
				while((str=br.readLine())!=null){
					if(str.contains("│")){
						String strs[]=str.split("│");
						info[i]=(strs[1].substring(0, strs[1].length()-1));
						i++;
					}
				}
				String basicInfo[]=new String[8];
				for(int j=0;j<8;j++){
					basicInfo[j]=info[j+1];
				}
				return basicInfo;
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
    	

    	return null;
    }
//以行为单位，筛选该球员每场比赛的信息
public ArrayList<String> getDetailedData(String playerName) {
	// TODO Auto-generated method stub
	filter=new MyFileFilter(playerName);
    ArrayList<String> list=filter.getPlayerDatas();	
    if(list.size()!=0){
    	return list;
    }else{
    	return null;
    }
	
}
}