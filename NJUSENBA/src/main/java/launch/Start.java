package launch;

import java.util.ArrayList;

import logic.PlayerBL;
import logic.PlayerService;
import logic.TeamBL;
import logic.TeamService;
import vo.PlayerStrVO;
import vo.TeamStrVO;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlayerService ps = new PlayerBL();
		ArrayList<PlayerStrVO> playerList = new ArrayList<PlayerStrVO>();
		playerList = ps.filterAll("G,E-Southest,score");
		for(int i=0;i < playerList.size();i++){
			System.out.println(playerList.get(i).getName());
		}
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
