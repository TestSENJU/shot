package Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Set;

import po.PlayerAllPO;
import po.PlayerAllPlusRatePO;
import po.PlayerAveragePlusRatePO;
import po.PlayerBasicPO;
import po.PlayerShortPO;
/**
 * 
 * @author wyt
 * 先发场数 队伍信息
 */
public class PlayerData_Impl implements PlayerDataService{
	private static String today="12-13_01-01";
	private static Hashtable<String,ArrayList<String>>todayData=new Hashtable<String,ArrayList<String>>();
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
			
			basic.setBasicInfo(ss);
			
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
	public ArrayList<String> getPlayerNamesByBasic(String path){
		ArrayList<String> playerNames=new ArrayList<String>();
		String names[]=new File(path).list();
		for(int i=0;i<names.length;i++){
			playerNames.add(names[i]);
		}
		return playerNames;
	}

    public static void addToTable(String[] strs,String filename,String team,
    	double[]nums1,String teamTime,double[]nums2){
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

    public static void addToToday(String matchName,String playerData){
    	String strs[]=matchName.split("_");
    	if((strs[0]+"_"+strs[1]).equals(today)){
    		String player[]=playerData.split(";");
    		if(todayData.contains(player[0])){
    			todayData.get(player[0]).add(playerData);
    		}else{
    			ArrayList<String>list=new ArrayList<String>();
    			list.add(playerData);
    			todayData.put(player[0], list);
    		}
    	}else{
    		String ss[]=new String[2];
    		ss[0]=strs[0]+"_"+strs[1];
    		ss[1]=today;
    		Arrays.sort(ss);
    		if(ss[0].equals(today)){
    			today=ss[1];
    			todayData.clear();
    			
    			ArrayList<String>list=new ArrayList<String>();
    			list.add(playerData);
    			String player[]=playerData.split(";");
    			todayData.put(player[0], list);
    		}
    	}
    	
    }
	public ArrayList<PlayerShortPO> getShortPlayerByNum(int num) {
		// TODO Auto-generated method stub
		ArrayList<PlayerShortPO>list=new ArrayList<PlayerShortPO>();
		Set<String>keys=todayData.keySet();
		for(String key:keys){
		
			PlayerAllPO po=playerTable.get(key);
			PlayerAllPlusRatePO allpo=po.makeDetailedAllPO();
			PlayerShortPO shortpo=new PlayerShortPO(key);
			double data[]=allpo.getPlayerData();
			shortpo.setNum(data[num]);
			shortpo.setTeam(po.getTeam());
			shortpo.setLocation(getPosition("players/info/"+key));
			list.add(shortpo);
		}
		if(list.size()==0){
			return null;
		}else {
			return list;
		}
	}
    private PlayerShortPO getShortPlayerByArrayList(String key,ArrayList<String>list,int num){
    	PlayerShortPO po=new PlayerShortPO(key);
    	String filename="players/info/"+key;
    	po.setLocation(getPosition(filename));
    	double result=0;
    	for(int i=0;i<list.size();i++){
    		String data[]=list.get(i).split(";");
    		result+=Double.parseDouble(data[num+3]);
    		
    	}
    	po.setNum(result);
    	po.setTeam(playerTable.get(key).getTeam());
    	
    	return po;
    }
	public ArrayList<PlayerShortPO> getShortPlayerToday(int num) {
		// TODO Auto-generated method stub
		ArrayList<PlayerShortPO> list=new ArrayList<PlayerShortPO>();
		Set<String>keys=todayData.keySet();
		switch(num){
		case 0:{
			for(String key:keys){
				list.add(getShortPlayerByArrayList(key,todayData.get(key),11));
			}
		}
		case 1:{
			for(String key:keys){
				list.add(getShortPlayerByArrayList(key,todayData.get(key),0));
			}
		}
		case 2:{
			for(String key:keys){
				list.add(getShortPlayerByArrayList(key,todayData.get(key),1));
			}
		}
		case 3:{
			for(String key:keys){
				list.add(getShortPlayerByArrayList(key,todayData.get(key),8));
			}
		}
		case 4:{
			for(String key:keys){
				list.add(getShortPlayerByArrayList(key,todayData.get(key),7));
			}
		}
		}
		if(list.size()==0){
			System.out.println("playerdataimpl getShortPlayerByNum");
			return null;
		}else{
			return list;
		}
	}

	public ArrayList<String> getPlayerByLeague(String league) {
		// TODO Auto-generated method stub
		ArrayList<String>list=new ArrayList<String>();
		Set<String>keys=playerTable.keySet();
		ArrayList<String> teamNames=getTeamNamesByLeague(league);
		for(String key:keys){
			if(teamNames.contains(playerTable.get(key).getTeam())){
				list.add(key);
			}
		}
		if(list.size()!=0){
			return list;
		}
		return null;
	}
    private ArrayList<String> getTeamNamesByLeague(String league){
    		ArrayList<String>list=new ArrayList<String>();
    		try {
				@SuppressWarnings("resource")
				BufferedReader br=new BufferedReader(new FileReader(new File("teams")));
				String str="";
				while((str=br.readLine())!=null){
					if(str.startsWith("║")){
						String mass[]=str.split("║");
						String contents[]=mass[1].split("│");
						if((contents[3]+"-"+contents[4]).equals(league+"\t"))
						list.add(contents[1]);
					}
				
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("getTeamNamesByLeague");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("getTeamNamesByLeague2");
				e.printStackTrace();
			}
    		if(list.size()!=0){
    			return list;
    		}else{
    			System.out.println("getTeamNamesByLeague3");
    			return null;
    		}
    }
	public ArrayList<String> getPlayerByPosition(String position) {
		// TODO Auto-generated method stub
		ArrayList<String>list=new ArrayList<String>();
		String filenames[]=new File("players/info").list();
		for(int i=0;i<filenames.length;i++){
			String position1=getPosition("players/info/"+filenames[i]);
			if(position1.equals(position)){
				 list.add(filenames[i]);	
			}

		}
		if(list.size()!=0)
		return list;
		else{
			System.out.println(" playerdataimpl getplayerposition");
			return null;
		}
	}
   @SuppressWarnings("resource")
private String getPosition(String filename){
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(new File(filename)));
			String str=""; 
			while((str=br.readLine())!=null){
					if(str.contains("│")&&str.contains("Position")){
						String strs[]=str.split("│");

						return strs[1].substring(0, 1);
					}
				}
		
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("getpostion1");
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("getpostion2");
			return null;
		}
	
	   return null;
   }
}
