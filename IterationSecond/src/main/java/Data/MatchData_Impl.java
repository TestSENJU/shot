package Data;

import java.util.ArrayList;
import java.util.Hashtable;

import po.MatchPO;

public class MatchData_Impl implements MatchDataService{
    private static Hashtable<String,MatchPO>matchTable=new Hashtable<String,MatchPO>();
	private static Hashtable<String,ArrayList<String>>timeTable=new Hashtable<String,ArrayList<String>>();
    private static Hashtable<String,ArrayList<String>>playerTable=new Hashtable<String,ArrayList<String>>();
    private static Hashtable<String,ArrayList<String>>teamTable=new Hashtable<String,ArrayList<String>>();
	public ArrayList<MatchPO> getMatchByTime(String time) {
		// TODO Auto-generated method stub
		ArrayList<String>timeList=timeTable.get(time);
		if(timeList==null){
			return null;
		}else{
			ArrayList<MatchPO> matchPOList=new ArrayList<MatchPO>();
			for(int i=0;i<timeList.size();i++){
				matchPOList.add(matchTable.get(timeList.get(i)));
			}
			return matchPOList;
		}
		
	}

	public ArrayList<MatchPO> getMatchByPlayer(String playerName) {
		// TODO Auto-generated method stub
		ArrayList<String>playerList=playerTable.get(playerName);
		if(playerList==null){
			return null;
		}else{
			ArrayList<MatchPO> matchPOList=new ArrayList<MatchPO>();
			for(int i=0;i<playerList.size();i++){
				matchPOList.add(matchTable.get(playerList.get(i)));
			}
			return matchPOList;
		}
	}

	public ArrayList<MatchPO> getMatchByTeam(String teamName) {
		// TODO Auto-generated method stub
		ArrayList<String>teamList=playerTable.get(teamName);
		if(teamList==null){
			return null;
		}else{
			ArrayList<MatchPO> matchPOList=new ArrayList<MatchPO>();
			for(int i=0;i<teamList.size();i++){
				matchPOList.add(matchTable.get(teamList.get(i)));
			}
			return matchPOList;
		}
	}
	public static void addToTable(String filename,String team1,String time,ArrayList<String[]>list1
		,String team2,ArrayList<String[]>list2,String pointer,ArrayList<String>pointerpart){
		MatchPO newMatch=new MatchPO(filename);
		newMatch.setList1(list1);
		newMatch.setList2(list2);
		newMatch.setTime(time);
		newMatch.setPointer(pointer);
		newMatch.setPointerPart(pointerpart);
		matchTable.put(filename, newMatch);
		if(teamTable.containsKey(team1)){
			teamTable.get(team1).add(filename);
		}else{
			ArrayList<String>matchNames=new ArrayList<String>();
			matchNames.add(filename);
			teamTable.put(team1, matchNames);
		}
		if(teamTable.containsKey(team2)){
			teamTable.get(team2).add(filename);
		}else{
			ArrayList<String>matchNames=new ArrayList<String>();
			matchNames.add(filename);
			teamTable.put(team2, matchNames);
		}
		for(int i=0;i<list1.size();i++){
			String strs[]=list1.get(i);
			if(playerTable.containsKey(strs[0])){
				playerTable.get(strs[0]).add(filename);
			}else{
				ArrayList<String> matchNames=new ArrayList<String>();
				matchNames.add(filename);
				playerTable.put(strs[0], matchNames);
			}
		}
		for(int i=0;i<list2.size();i++){
			String strs[]=list2.get(i);
			if(playerTable.containsKey(strs[0])){
				playerTable.get(strs[0]).add(filename);
			}else{
				ArrayList<String> matchNames=new ArrayList<String>();
				matchNames.add(filename);
				playerTable.put(strs[0], matchNames);
			}
		}
	}

	public ArrayList<String> getMatchNamesByTime(String time) {
		// TODO Auto-generated method stub
		ArrayList<String> nameList=timeTable.get(time);
		if(nameList==null){
			System.out.println("macthdataImpl getMatchNamesByTime");
			return null;
		}else{
			return nameList;
		}
	
	}

	public ArrayList<String> getMatchNamesByPlayer(String name) {
		// TODO Auto-generated method stub
		ArrayList<String> nameList=playerTable.get(name);
		if(nameList==null){
			System.out.println(" matchdataImpl getMatchNamesByPlayer");
			return null;
		}else{
			return nameList;
		}		
	}

	public ArrayList<String> getMatchNamesByTeam(String name) {
		// TODO Auto-generated method stub
		ArrayList<String> nameList=teamTable.get(name);
		if(nameList==null){
			System.out.println(" matchdataImpl getMatchNamesByTeam");
			return null;
		}else{
			return nameList;
		}	
	}

	public MatchPO getMatchByName(String matchName) {
		// TODO Auto-generated method stub
		MatchPO po=matchTable.get(matchName);
		if(po!=null){
			return po;
		}else{
			System.out.println("getmatchbyname");
			return null;
		}

	}
	
}
