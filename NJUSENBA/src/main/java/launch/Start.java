package launch;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import data.player.PlayerData;
import data.player.PlayerData_Impl;
import po.Player_AllScorePO;
import logic.PlayerBL;
import logic.PlayerService;
import vo.PlayerPersonalInfoVO;
import vo.PlayerStrVO;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlayerService ps = new PlayerBL();
		ArrayList<PlayerStrVO> playerList = new ArrayList<PlayerStrVO>();
		playerList = ps.filterAll("C,W-Southwest,score");
		for(int i=0;i < playerList.size();i++){
			System.out.println(playerList.get(i).getName());
		}
		/*playerList = ps.filterAll("G,E-Southest,score");
		for(int i=0;i < playerList.size();i++){
			System.out.println(playerList.get(i).getName());
		}*/
/*		ArrayList<PlayerPersonalInfoVO> playPerson = new ArrayList<PlayerPersonalInfoVO>();
		playPerson = ps.playerPersonalInfo();
		playerList = ps.playerAll();
		PlayerData pd = new PlayerData_Impl();
		Hashtable<String, Player_AllScorePO> playAllList = pd.getPlayerAll();
		Set<String> keys = playAllList.keySet();
		for (String key : keys) {
			System.out.println(playAllList.get(key).getPlayerName() + ";;;;" + playAllList.get(key).getTeamArea());
		}
		for (int i=0;i < playPerson.size();i++) {
			System.out.println(playPerson.get(i).getName() + "====" + playPerson.get(i).getPosition());
		}
*/
		/*ArrayList<TeamStrVO> teamList = new ArrayList<TeamStrVO>();
		teamList = ts.allTeamAverStr();
		for (int i=0;i < teamList.size();i++) {
			System.out.println(teamList.get(i).getAssistingRate());
		}
		PlayerService ps = new PlayerBL();
		ArrayList<PlayerStrVO> playerList = new ArrayList<PlayerStrVO>();
		//playerList = ps.playerAll();
		playerList = ps.playerAverage();
		for (int i=0;i < playerList.size();i++) {
			//System.out.println(playerList.get(i).getName());
		}
		System.out.println("--------------------------------bilibili------------------------------");
		ArrayList<PlayerStrVO> afterPlayer = new ArrayList<PlayerStrVO>();
		afterPlayer = ps.ascendPlayerAStr(0, playerList);
		for (int i=0;i < afterPlayer.size();i++) {
			System.out.println(afterPlayer.get(i).getName());
		}*/
	}

}
