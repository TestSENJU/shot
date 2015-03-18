package data.player;

import java.io.File;

import java.util.ArrayList;

import po.PlayerPO;
import po.Player_AllScorePO;
import po.Player_AverageScorePO;

public class getPlayerData_Impl implements getPlayerData{
	private  String filename="E://matches";
	private String playerFile="E://players//info//";
	private String teamFile=	"E://teams//teams";
	private MyFileFilterForMatches filter;
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
	    filter=new MyFileFilterForMatches(playerName);
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
        	
        }
        String teamName=teams.get(teamNum);
    	
    	player.setTeam(teamName);
    	player.setArea(getArea(teamName));
        return player;
	}
//根据球队名字返回所在的联盟

private String getArea(String teamName){
FileReaderForTeams frT=new FileReaderForTeams(teamFile);

	return frT.getTeamArea(teamName);
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
			scoresAver[i]=(double)(Math.round(scoresAll[i]/AllScore.getNumOfMatches())/100.0);;
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
	private String[] getPlayerBasis(String playerName){
    	FileReaderForPlayers frP=new FileReaderForPlayers(playerFile);
    	return frP.getPlayerInfo(playerName);
    }
//以行为单位，筛选该球员每场比赛的信息
public ArrayList<String> getDetailedData(String playerName) {
	// TODO Auto-generated method stub
	filter=new MyFileFilterForMatches(playerName);
	File root=new File("E:\\matches");
	File files[]=root.listFiles(filter);
    ArrayList<String> list=new ArrayList<String>();
         	list=	filter.getPlayerDatas();	
    if(list.size()!=0){
    	return list;
    }else{
    	return null;
    }
	
}
}