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
			String strs[]=list1.get(i);
			if(playerTable.containsKey(strs[0])){
				playerTable.get(strs[0]).add(filename);
			}else{
				ArrayList<String> matchNames=new ArrayList<String>();
				matchNames.add(filename);
				playerTable.put(strs[0], matchNames);
			}
		}
	}
	
//	public static void addMatchPO(MatchPO newMatch) throws FileNotFoundException{
//			BufferedReader br=new BufferedReader(new FileReader(filename));
//			
//			try {		
//				String allInfo=br.readLine();
//				String strs1[]=allInfo.split(";");
//				newMatch.setPointer(strs1[2]);
//				String every=br.readLine();
//				String strs2[]=every.split(";");
//				for(int i=0;i<strs2.length;i++){
//					newMatch.addPointerPart(strs2[i]);
//				}
//				String str="";
//				int i=0;
//				while((str=br.readLine())!=null){
//					if(str.length()!=3){
//						String strs[]=str.split(";");
//						if(i==1){
//							newMatch.addTeam1List(strs);
//						}else if(i==2){
//							newMatch.addTeam2List(strs);
//						}
//						
//						if(playerTable.containsKey(strs[0])){
//							playerTable.get(strs[0]).add(filename);
//						}else{
//							ArrayList<String> matchNames=new ArrayList<String>();
//							matchNames.add(filename);
//							playerTable.put(strs[0], matchNames);
//						}
//						
//					}else{
//						i++;
//					}
//				}
//				matchTable.put(filename, newMatch);
//				
//				
//				String ss[]=filename.split("_");
//				if(timeTable.containsKey(ss[0]+"_"+ss[1])){
//					timeTable.get(ss[0]+"_"+ss[1]).add(filename);
//				}else{
//					ArrayList<String> matchNames=new ArrayList<String>();
//					matchNames.add(filename);
//					timeTable.put(ss[0]+"_"+ss[1], matchNames);
//				}
//				
//				
//				String sss[]=ss[2].split("-");
//				if(teamTable.containsKey(sss[0])){
//					teamTable.get(sss[0]).add(filename);
//				}else{
//					ArrayList<String> matchNames=new ArrayList<String>();
//					matchNames.add(filename);
//					teamTable.put(sss[0], matchNames);
//				}
//				if(teamTable.containsKey(sss[1])){
//					teamTable.get(sss[1]).add(filename);
//				}else{
//					ArrayList<String> matchNames=new ArrayList<String>();
//					matchNames.add(filename);
//					teamTable.put(sss[1], matchNames);
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				System.out.print("matchData_Impl addMacthPO ioexception");
//			}
//		}
}
