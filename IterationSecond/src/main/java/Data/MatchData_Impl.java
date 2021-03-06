package Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Set;

import po.MatchPO;
import po.MatchShortPO;

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
		ArrayList<String>teamList=teamTable.get(teamName);
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

	public ArrayList<MatchShortPO> getShortMatchByPeriod(String beigin,
			String end) {
		// TODO Auto-generated method stub
		Set<String> keys=matchTable.keySet();
		ArrayList<MatchShortPO> list=new ArrayList<MatchShortPO>();
		for(String key:keys){
			String[] times=new String[3];
			String []strs=key.split("_");
			times[0]=beigin;
			times[1]=end;
			times[2]=strs[0]+"_"+strs[1];
			Arrays.sort(times);
			if(times[1].equals(strs[0]+"_"+strs[1])){
				list.add(getMatchShortPOByMatchPO(matchTable.get(key)));
			}
		}
		System.out.println("Csbgnhtrmt");
		return list;
	}

	public ArrayList<MatchShortPO> getAllMatch() {
		// TODO Auto-generated method stub
		Set<String> keys=matchTable.keySet();
		ArrayList<MatchShortPO>list=new ArrayList<MatchShortPO>();
		for(String key:keys){
			MatchPO po=matchTable.get(key);
			
			list.add(getMatchShortPOByMatchPO(po));
		}
		return list;
	}

	public ArrayList<MatchShortPO> getRecentShortMatchByPlayer(String playerName) {
		// TODO Auto-generated method stub
		if(playerTable.containsKey(playerName)){
			ArrayList<String> list=teamTable.get(playerName);
	ArrayList<MatchShortPO> result=new ArrayList<MatchShortPO>();
	if(list.size()>=5){
		Collections.sort(list);
		for(int i=list.size()-1;i>list.size()-6;i--){
			result.add(getMatchShortPOByMatchPO(matchTable.get(list.get(i))));
		}
	}else{
		for(int i=0;i<list.size();i++){
			result.add(getMatchShortPOByMatchPO(matchTable.get(list.get(i))));
		}
	}
	return result;
	}else
     return null;
	}

	public ArrayList<MatchShortPO> getRecentShortMatchByTeam(String teamName) {
		// TODO Auto-generated method stub
		if(teamTable.containsKey(teamName)){
				ArrayList<String> list=teamTable.get(teamName);
		ArrayList<MatchShortPO> result=new ArrayList<MatchShortPO>();
		if(list.size()>=5){
			Collections.sort(list);
			for(int i=list.size()-1;i>list.size()-6;i--){
				result.add(getMatchShortPOByMatchPO(matchTable.get(list.get(i))));
			}
		}else{
			for(int i=0;i<list.size();i++){
				result.add(getMatchShortPOByMatchPO(matchTable.get(list.get(i))));
			}
		}
		return result;
		}else
	     return null;
	}
	private MatchShortPO getMatchShortPOByMatchPO(MatchPO po){
		MatchShortPO shortPO=new MatchShortPO(po.getName());
		shortPO.setPointer(po.getPointer());
		shortPO.setTeam1(po.getTeam1());
		shortPO.setTeam2(po.getTeam2());
		String strs[]=po.getName().split("_");
		shortPO.setTime(strs[0]+"_"+strs[1]);
		return shortPO;
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
		String ss[]=filename.split("_");
		String timeMatch=ss[0]+"_"+ss[1];
		if(timeTable.contains(timeMatch)){
			timeTable.get(timeMatch).add(filename);
		}else{
			ArrayList<String> list=new ArrayList<String>();
			list.add(filename);
			timeTable.put(timeMatch,list );
		}
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
	
}
