package Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import po.PlayerAllPO;
import po.PlayerAllPlusRatePO;
import po.PlayerAveragePlusRatePO;
import po.PlayerBasicPO;
/**
 * 
 * @author wyt
 *
 */
public class PlayerData_Impl implements PlayerDataService{
    private static Hashtable<String,PlayerAllPO> playerTable=new Hashtable<String,PlayerAllPO>();
	private String path="players/info";
    public PlayerAllPlusRatePO getPlayerAllByName(String playerName) {
		// TODO Auto-generated method stub
		if(playerTable.containsKey(playerName)){
			return playerTable.get(playerName).makeDetailedAllPO();
		}else{
			System.out.println("getPlayerAllByName");
			return null;
		}		
	}

	public PlayerAveragePlusRatePO getPlayerAverageByName(String playerName) {
		// TODO Auto-generated method stub
		if(playerTable.containsKey(playerName)){
			return playerTable.get(playerName).makeAveragePO();
		}else{
			System.out.println("getPlayerAverageByName");
			return null;
		}
	}

	public PlayerBasicPO getPlayerBasicByName(String playerName) {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("resource")
			BufferedReader br=new BufferedReader(new FileReader(path+"/"+playerName));
		    String str="";
		    int n=0;
			String s[]=new String[9];
			String ss[]=new String[8];
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
			PlayerBasicPO basic=new PlayerBasicPO(playerName);
			return basic;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("playerdataImpl getbasicbyname filenotfound");
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("playerdataImpl getbasicbyname io");
			return null;
		}
	}

	public ArrayList<PlayerAllPlusRatePO> getPlayerAll() {
		// TODO Auto-generated method stub
		Set<String> keys=playerTable.keySet();
		ArrayList<PlayerAllPlusRatePO>list=new ArrayList<PlayerAllPlusRatePO>();
		
		for(String key:keys){
			list.add(getPlayerAllByName(key));
		}
		if(list.size()!=0){
			return list;
		}else{
			System.out.println("playerdataImpl getPlayerAll arraylist null");
			return null;
			
		}
	}

	public ArrayList<PlayerAveragePlusRatePO> getPlayerAverage() {
		// TODO Auto-generated method stub
		Set<String> keys=playerTable.keySet();
		ArrayList<PlayerAveragePlusRatePO>list=new ArrayList<PlayerAveragePlusRatePO>();
		
		for(String key:keys){
			list.add(getPlayerAverageByName(key));
		}
		if(list.size()!=0){
			return list;
		}else{
			System.out.println("playerdataImpl getPlayerAverage arraylist null");
			return null;
		}
	}

	public ArrayList<PlayerBasicPO> getPlayerBasic() {
		// TODO Auto-generated method stub
		ArrayList<PlayerBasicPO>list=new ArrayList<PlayerBasicPO>();
		ArrayList<String> names=getPlayerNamesByBasic(path);
		for(int i=0;i<names.size();i++){
			list.add(getPlayerBasicByName(names.get(i)));
		}
		if(list.size()!=0){
			return list;
		}else{
			System.out.println("playerdataImpl getPlayerBasic arraylist null");
			return null;
		}
	}

	public ArrayList<String> getAllPlayerNames() {
		// TODO Auto-generated method stub
		ArrayList<String> list1=getPlayerNamesByBasic(path);
		Set<String> keys=playerTable.keySet();
		for(String key:keys){
			if(!list1.contains(key)){
				list1.add(key);
			}
		}
		if(list1.size()!=0){
			return list1;
		}else{
			System.out.println("playerData-Impl getAllPlayerNames");
			return null;
		}
		
	}

	public ArrayList<String> getPlayerNameByStr(String str) {
		// TODO Auto-generated method stub
		return null;
	}
	private ArrayList<String> getPlayerNamesByBasic(String path){
		ArrayList<String> playerNames=new ArrayList<String>();
		String names[]=new File(path).list();
		for(int i=0;i<names.length;i++){
			playerNames.add(names[i]);
		}
		return playerNames;
	}

    public static void addToTable(ArrayList<String[]>list,String filename,String team,
    	double[]nums1,String teamTime,double[]nums2){
    	for(int j=0;j<list.size();j++){
			String strs[]=list.get(j);
			if(playerTable.containsKey(strs[0])){
				playerTable.get(strs[0]).addPlayerData(filename, strs);
				playerTable.get(strs[0]).addCompeteData(filename, nums2);
				playerTable.get(strs[0]).addTeamData(filename, nums1);
				playerTable.get(strs[0]).addTeamTime(filename, teamTime);
				playerTable.get(strs[0]).addTeam(team);
			}else{
				PlayerAllPO playerAll=new PlayerAllPO(strs[0]);
				
				playerAll.addPlayerData(filename, strs);
				playerAll.addCompeteData(filename, nums2);
				playerAll.addTeamData(filename, nums1);
				playerAll.addTeamTime(filename, teamTime);
				playerAll.addTeam(team);
				
				playerTable.put(strs[0], playerAll);
			}
			
		}
    }

	public ArrayList<String> getMatchNamesByPlayerName(String playerName) {
		// TODO Auto-generated method stub
		PlayerAllPO player=playerTable.get(playerName);
		if(player!=null){
			ArrayList<String> namelist=player.getMatchNames();
			if(namelist!=null){
				return namelist;
			}else{
				System.out.println("getMatchNamesByPlayerName1");
				return null;
			}
			
		}else{
			System.out.println("getMatchNamesByPlayerName2");
			return null;
		}

	}
   
}
