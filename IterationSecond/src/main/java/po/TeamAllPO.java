package po;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * 
 * @author wyt
 * 这个类对于BL来说是不可见的
 * 
 */
public class TeamAllPO {
String teamName;
private ArrayList<String> playerList=new ArrayList<String>();
private HashMap<String,double[]>teamDataList=new HashMap<String,double[]>();
private HashMap<String,double[]>opponentDataList=new HashMap<String,double[]>();
private ArrayList<String> winMatchList=new ArrayList<String>();

public TeamAllPO(String name){
	this.teamName=name;
}
public void addPlayer(String playername){
	if(!this.playerList.contains(playername))
	this.playerList.add(playername);
}
public void addTeamData(String matchName,double[]teamData){
	this.teamDataList.put(matchName, teamData);
}
public void addOpponentData(String matchName,double[]opponentData){
	this.opponentDataList.put(matchName, opponentData);
}
public void addWinMatchNum(String matchName){
	this.winMatchList.add(matchName);
}
public TeamAllPlusRatePO makeDetailedAllPO(){
	TeamAllPlusRatePO allData=new TeamAllPlusRatePO(this.teamName);
	allData.setPlayerList(this.playerList);
	allData.setMatchNum(teamDataList.size());
	if(this.teamName=="NOP"){
		allData.setUsedName("NOH");
	}
	allData.addWinNum(winMatchList.size());
    double[] data=new double[25];
    double [] oppData=new double[3];
    Set<String>keys=teamDataList.keySet();
    for(String key:keys){
    	double[] teamData=teamDataList.get(key);
    	double[] opponentData=opponentDataList.get(key);
    	for(int i=0;i<15;i++){
    		data[i]+=teamData[i];
    	}
    	for(int i=0;i<3;i++){
            oppData[i]+=opponentData[i];
    	}
    }
    //投篮命中率
	data[15]=data[0]/data[1];
	//三分命中率
	data[16]=data[2]/data[3];
	//罚球命中率
	data[17]=data[4]/data[5];
	//胜率
	data[18]=(double)winMatchList.size()/teamDataList.size();
	//进攻回合
	data[19]=data[1]+0.4*data[5]-1.07*(data[6]/(data[6]+data[7])*(data[1]-data[0]))+1.07*data[12];
	//进攻效率
	data[20]=data[14]/data[19]*100;
	//防守效率
	data[21]=oppData[2]/data[19]*100;
	//篮板效率
	data[22]=(data[6]+data[7])/(data[6]+oppData[1]+data[7]+oppData[0]);
	//抢断效率
	data[23]=data[10]/data[19]*100;
	//助攻率
	data[24]=data[9]/data[19]*100;
	//进攻篮板效率
	data[25]=data[6]/(data[6]+oppData[0]);
	//防守篮板效率
	data[26]=data[7]/(data[7]+oppData[1]);
	allData.setTeamData(data);
	return allData;
}
public TeamAveragePlusRatePO makeAveragePO(){
	TeamAllPlusRatePO allData=makeDetailedAllPO();
	if(allData!=null){
		return new TeamAveragePlusRatePO(allData);
	}else{
		System.out.println("TeamAllPO makeAveragePO");
		return null;
	}
}
}
