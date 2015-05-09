package Data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import po.TeamAllPO;
import po.TeamAllPlusRatePO;
import po.TeamAveragePlusRatePO;
import po.TeamBasicPO;

public class TeamData_Impl implements TeamDataService{
	private  final   String filename="teams";
    private static Hashtable<String,TeamAllPO>teamTable=new Hashtable<String,TeamAllPO>();
	public ArrayList<TeamAllPlusRatePO> getTeamAll() {
		// TODO Auto-generated method stub
		Set<String> keys=teamTable.keySet();
		ArrayList<TeamAllPlusRatePO>teamList=new ArrayList<TeamAllPlusRatePO>();
		
		for(String key:keys){
			teamList.add(teamTable.get(key).makeDetailedAllPO());
		}
		if(teamList.size()!=0){
			return teamList;
		}else{
			System.out.println("teamDataImpl getTeamAll");
			return null;
		}
		
	}

	public TeamAllPlusRatePO getTeamAllByName(String teamName) {
		// TODO Auto-generated method stub
		if(teamTable.containsKey(teamName)){
			return teamTable.get(teamName).makeDetailedAllPO();
		}else if(teamName.equals("NOH")){
			if(teamTable.containsKey("NOP"))
				return teamTable.get(teamName).makeDetailedAllPO();
			else{
				System.out.println("teamDataImpl getTeamAllByName1");
				return null;}
		}else{
			System.out.println("teamDataImpl getTeamAllByName");
			return null;
		}
	
	}

	public TeamAveragePlusRatePO getTeamAverageByName(String teamName) {
		// TODO Auto-generated method stub
		if(teamTable.containsKey(teamName)){
			return teamTable.get(teamName).makeAveragePO();
		}else if(teamName.equals("NOH")){
			if(teamTable.containsKey("NOP"))
				return teamTable.get(teamName).makeAveragePO();
			else{
				System.out.println("teamDataImpl getTeamAverageByName1");
				return null;}
		}
		else{
			System.out.println("teamDataImpl getTeamAverageByName");
		return null;
		}
		
	}

	public ArrayList<TeamAveragePlusRatePO> getTeamAverage() {
		// TODO Auto-generated method stub
		Set<String> keys=teamTable.keySet();
		ArrayList<TeamAveragePlusRatePO>teamList=new ArrayList<TeamAveragePlusRatePO>();
		
		for(String key:keys){
			teamList.add(teamTable.get(key).makeAveragePO());
		}
		if(teamList.size()!=0){
			return teamList;
		}else{
			System.out.println("teamDataImpl getTeamAverage");
		return null;
		}
		
		}

	public ArrayList<String> getAllTeamNames() {
		// TODO Auto-generated method stub
		ArrayList<String>list1=getTeamNamesByBasic();
		Set<String> keys=teamTable.keySet();
		for(String key:keys){
			if(!list1.contains(key))list1.add(key);
		}
		if(list1.size()==0){
			System.out.println("teamData_Impl getAllTeamNames");
			return null;
		}else{
			return list1;
		}
	}
    private ArrayList<String> getTeamNamesByBasic(){
    	try {
			@SuppressWarnings("resource")
			BufferedReader br=new BufferedReader(
					new InputStreamReader(new FileInputStream(filename),"UTF-8"));
			String str="";
			ArrayList<String>list=new ArrayList<String>();
			while((str=br.readLine())!=null){
				if(str.startsWith("║")){
					String mass[]=str.split("║");
					String contents[]=mass[1].split("│");
					list.add(contents[1]);
				}
			
			}
			return list;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("teamDataImpl getAllteamnames file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("teamDataImpl getAllteamnames ioexcpetion");
		}
		
		return null;
    }
	public ArrayList<String> getTeamNameByStr(String str) {
		// TODO Auto-generated method stub
		Set<String>keys=teamTable.keySet();
//		ArrayList<String> list=new ArrayList<String>();
		for(String key:keys){
			if(key.contains(str)){
				
			}
		}
		return null;
	}
    public String getTeamShortName(String name){
    	// TODO Auto-generated method stub
    			try {
    				@SuppressWarnings("resource")
    				BufferedReader br=new BufferedReader(new FileReader(filename));
    			    String str="";
    			    while((str=br.readLine())!=null){
    			    	if(str.startsWith("║")){
    						String mass[]=str.split("║");
    						String contents[]=mass[1].split("│");
    						if(contents[0].equals(name)){
    				    		return contents[1];
    				    	}
    					}
    			    }
    			    if(name.equals("Pelicans")){return "NOH";}
    			} catch (FileNotFoundException e) {
    				// TODO Auto-generated catch block
    				System.out.println("teamDataImpl getTeamName filenotfound");
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				System.out.println("teamDataImpl getTeamName ioexception");
    			}
    			
    			return null;
    }
	public String getTeamName(String shortName) {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("resource")
			BufferedReader br=new BufferedReader(new FileReader(filename));
		    String str="";
		    while((str=br.readLine())!=null){
		    	if(str.startsWith("║")){
					String mass[]=str.split("║");
					String contents[]=mass[1].split("│");
					if(contents[1].equals(shortName)){
			    		return contents[0];
			    	}
				}
		    }
		    if(shortName.equals("NOH")){return "Pelicans";}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("teamDataImpl getTeamName filenotfound");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("teamDataImpl getTeamName ioexception");
		}
		
		return null;
	}
    public static void addToTable(double [] teamData,double opponentData[],
    		String filename,String teamName,ArrayList<String>nameList,int win){
    	if(teamName.equals("NOH")&&teamName.equals("NOP")){
    		if(teamTable.containsKey("NOP")){
        		teamTable.get("NOP").addOpponentData(filename, opponentData);
        		teamTable.get("NOP").addTeamData(filename, teamData);
        		for(int j=0;j<nameList.size();j++){
            		teamTable.get("NOP").addPlayer(nameList.get(j));
        		}

        		if(win==1)teamTable.get("NOP").addWinMatchNum(filename);
        	}else{
        		
        		TeamAllPO teamAll=new TeamAllPO("NOP");
        		for(int j=0;j<nameList.size();j++){
        			teamAll.addPlayer(nameList.get(j));
        		}
        		teamAll.addOpponentData(filename, opponentData);
        		teamAll.addTeamData(filename, teamData);
        		if(win==1)teamAll.addWinMatchNum(filename);
        		
        		teamTable.put("NOP", teamAll);
        	}
		}else{
			if(teamTable.containsKey(teamName)){
				for(int j=0;j<nameList.size();j++){
            		teamTable.get(teamName).addPlayer(nameList.get(j));
        		}
        		teamTable.get(teamName).addOpponentData(filename, opponentData);
        		teamTable.get(teamName).addTeamData(filename, teamData);
        		if(win==1)teamTable.get(teamName).addWinMatchNum(filename);
        	}else{
        		
        		TeamAllPO teamAll=new TeamAllPO(teamName);
        		for(int j=0;j<nameList.size();j++){
        			teamAll.addPlayer(nameList.get(j));
        		}
        		teamAll.addOpponentData(filename, opponentData);
        		teamAll.addTeamData(filename, teamData);
        		if(win==1)teamAll.addWinMatchNum(filename);
        		
        		teamTable.put(teamName, teamAll);
        	}
		}
    	
    }

	public ArrayList<TeamBasicPO> getTeamBasic() {
		// TODO Auto-generated method stub
		ArrayList<TeamBasicPO> basicList=new ArrayList<TeamBasicPO>();
		try {
			@SuppressWarnings("resource")
			BufferedReader br=new BufferedReader(new FileReader(filename));
			String str="";
			while((str=br.readLine())!=null){
				if(str.startsWith("║")){
					String mass[]=str.split("║");
					String strs[]=mass[1].split("│");
	    		String teamInfo[]=new String[6];
	    		teamInfo[0]=strs[0].trim();
				TeamBasicPO teamBasic=new TeamBasicPO(strs[1]);
	    		teamInfo[1]=strs[2].trim();
	    		teamInfo[2]=strs[3].trim();
	    		teamInfo[3]=strs[4].trim();
	    		teamInfo[4]=strs[5].trim();
	    		teamInfo[5]=strs[6].trim();
	    		teamBasic.setLongName(teamInfo[0]);
	    		teamBasic.setTeamInfo(teamInfo);
	    		if(strs[1].equals("NOH")){teamBasic.setUsedName("NOH");
	    		teamBasic.setUsedLongName("Hornets");
	    		teamBasic.setTeamName("NOP");
	    		teamBasic.setLongName("Pelicans");
	    		}
	    		basicList.add(teamBasic);
				}
				}
			return basicList;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("teamdataImpl getteambasic Filenotfound");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("teamdataImpl getteambasic ioexception");
		}
		
		return null;
	}

	public TeamBasicPO getTeamBasicByName(String teamName) {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("resource")
			BufferedReader br=new BufferedReader(new FileReader(filename));
		    String str="";
		    if(teamName.equals("NOH"))teamName="NOP";
		    while((str=br.readLine())!=null){
		    	if(str.contains(teamName)){
						String mass[]=str.split("║");
						String strs[]=mass[1].split("│");
		    		String teamInfo[]=new String[6];
		    		teamInfo[0]=strs[0].trim();
					TeamBasicPO teamBasic=new TeamBasicPO(strs[1]);
		    		teamInfo[1]=strs[2].trim();
		    		teamInfo[2]=strs[3].trim();
		    		teamInfo[3]=strs[4].trim();
		    		teamInfo[4]=strs[5].trim();
		    		teamInfo[5]=strs[6].trim();
		    		teamBasic.setTeamInfo(teamInfo);
		    		teamBasic.setLongName(teamInfo[0]);
		    		//TODO
		    		if(teamName.equals("NOH")){teamBasic.setUsedName("NOH");
		    		teamBasic.setUsedLongName("Hornets");
		    		teamBasic.setTeamName("NOP");
		    		teamBasic.setLongName("Pelicans");}
		    		return teamBasic;
		    	}
		    	
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("teamDataImpl getTeamBasicByName filenotfound");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("teamDataImpl getTeamBasicByName ioexception");
		}		
		return null;
	}

	public ArrayList<String> getPlayerNamesOfTeam(String teamName) {
		// TODO Auto-generated method stub
		TeamAllPlusRatePO po=getTeamAllByName(teamName);
		return po.getPlayerList();
	}

	@SuppressWarnings("resource")
	public String getLeague(String teamName) {
		// TODO Auto-generated method stub
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(filename));
			    String str="";
			    if(teamName.equals("NOH"))teamName="NOP";
			    while((str=br.readLine())!=null){
			    	if(str.contains(teamName)){
							String mass[]=str.split("║");
							String strs[]=mass[1].split("│");
			    		return strs[3];
			    	}
	}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      return null;
	}
}