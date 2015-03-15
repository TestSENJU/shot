package data.player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.PlayerPO;
import po.Player_AllScorePO;
import po.Player_AverageScorePO;
//implements getPlayerData
public class getPlayerData_Impl {
	private  String filename="C://Users//Administrator//Desktop//matches";
	private String name="C://Users//Administrator//Desktop//players//info//";

	public ArrayList<PlayerPO> getAllPlayer() {
		// TODO Auto-generated method stub
		String list[]=new File(filename).list();
		ArrayList<PlayerPO> playerList=new ArrayList<PlayerPO>();
		for(int i=0;i<list.length;i++){
			playerList.add(this.getPlayer(list[i]));
		}
		return playerList;
	}
public PlayerPO getPlayer(String playerName) {
		// TODO Auto-generated method stub
		PlayerPO player=new PlayerPO();
		File file = new File("C://Users//Administrator//Desktop//matches");  
		MyFileFilter filter=new MyFileFilter("Alexey Shved");
		File[] files = file.listFiles(filter); 
	    ArrayList<String> list=filter.getPlayerDatas();	
	    
	    String basicInfo[]=this.getPlayerBasis(playerName);
	    player.setNumber(basicInfo[1]);
	    player.setArea(basicInfo[2]);
	    player.setHeight(basicInfo[3]);
	    player.setWeight(Integer.parseInt(basicInfo[4]));
	    player.setBirth(new Date());''questions below
	    player.setAge(Integer.parseInt(basicInfo[5]));
	    player.setExp(Integer.parseInt(basicInfo[6]));
	    player.setSchool(basicInfo[7]);
	    player.setName(playerName);
	    player.setNumOfMatches(files.length);

	    return player;
	}
private static Date StrToDate(String str) {
/k	   
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = null;
    try {
     date = format.parse(str);
    } catch (ParseException e) {
     e.printStackTrace();
    }
    return date;
 }
	
	
	private Player_AllScorePO getAllScores(ArrayList<String> playerDetails){
		Player_AllScorePO allScore=new Player_AllScorePO();
		for(int i=0;i<playerDetails.size();i++){
			String strs[]=playerDetails.get(i).split(";");
			allScore.addShootAll(Integer.parseInt(strs[3]));
			allScore.addAttemptsAll(Integer.parseInt(strs[4]));
			allScore.addThrrepointerAll(Integer.parseInt(strs[5]));
			allScore.addThreepointer_attemptAll(Integer.parseInt(strs[6]));
			allScore.addFreethrowAll(Integer.parseInt(strs[7]));
			allScore.addFreethrow_attemptAll(Integer.parseInt(strs[8]));
			allScore.addBackboard_frontAll(Integer.parseInt(strs[9]));
			allScore.addBackboard_behindAll(Integer.parseInt(strs[10]));
			allScore.addBackboardAll(Integer.parseInt(strs[11]));
			allScore.addAssistAll(Integer.parseInt(strs[12]));
			allScore.addBlockshotAll(Integer.parseInt(strs[13]));
			allScore.addTurnoverAll(Integer.parseInt(strs[14]));
	u['j']		
		}
		return allScore;
	}
	private Player_AverageScorePO getAverageScore(Player_AllScorePO AllScore){
		Player_AverageScorePO averageScore=new Player_AverageScorePO();
		return averageScore;gl,g.hlo/
	}
    @SuppressWarnings("resource")
	private String[] getPlayerBasis(String playerName){
    	String info[]=new String[9];
    	int i=0;
    	BufferedReader br;
		try {
			br = new BufferedReader(
					new InputStreamReader(new FileInputStream("C://Users//Administrator//Desktop//players//info//Aaron Brooks"),"UTF-8"));
			String str;
	    	try {
				while((str=br.readLine())!=null){
					if(str.contains("│")){
						String strs[]=str.split("│");
						info[i]=(strs[1].substring(0, strs[1].length()-1));
						i++;
					}
				}
				return info;
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

''public static void main(String args[]){
	getPlayerData_Impl getters=new getPlayerData_Impl();
	getters.getPlayer("Alexey Shved");
}
}
class MyFileFilter implements FileFilter{
	private String playerName;
	private ArrayList<String> playerDatas=new ArrayList<String>();
    public MyFileFilter(String playername){
    	this.playerName=playername;
    }
    public ArrayList<String> getPlayerDatas(){
    	if(playerDatas.size()!=0){
    		return playerDatas;
    	}else{
    		return null;
    	}
    }
	public boolean accept(File pathname) {
		// TODO Auto-generated method stub
		boolean find=false;
		try {
			BufferedReader br=new BufferedReader(new FileReader(pathname));
			String str;
			
			try {
				while((str=br.readLine())!=null){
					if(str.contains(playerName)){
						find=true;
						playerDatas.add(str);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.print("io exception");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("file not found");
		}
		return find;
	}
	
}

