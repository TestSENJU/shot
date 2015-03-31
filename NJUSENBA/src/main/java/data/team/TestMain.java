package data.team;

import java.util.Hashtable;
import java.util.Set;

import po.TeamPO;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TeamData td = TeamData.getInstance();
		Hashtable<String, TeamPO> table = td.getTeamData();
		Set<String> keys = table.keySet();
		for (String key : keys) {
			System.out.println(key);
			System.out.println("-----getMatchNum-----"
					+ table.get(key).getMatchNum());
			System.out.println("-----getShotRightNum-----"
					+ table.get(key).getShotRightNum());
			System.out.println("-----getShotNum-----"
					+ table.get(key).getShotNum());
			System.out.println("-----getThreePointShotRightNum-----"
					+ table.get(key).getThreePointShotRightNum());
			System.out.println("-----getThreePointShotNum-----"
					+ table.get(key).getThreePointShotNum());
			System.out.println("-----getPenaltyShotRightNum-----"
					+ table.get(key).getPenaltyShotRightNum());
			System.out.println("-----getPenaltyShotNum-----"
					+ table.get(key).getPenaltyShotNum());
			System.out.println("-----getOffensiveReboundNum-----"
					+ table.get(key).getOffensiveReboundNum());
			System.out.println("-----getDefensiveReboundNum-----"
					+ table.get(key).getDefensiveReboundNum());
			System.out.println("-----getReboundNum-----"
					+ table.get(key).getReboundNum());
			System.out.println("-----getAssistNum-----"
					+ table.get(key).getAssistNum());
			System.out.println("-----getBlockShotNum-----"
					+ table.get(key).getBlockShotNum());
			System.out.println("-----getStealNum-----"
					+ table.get(key).getStealNum());
			System.out.println("-----getBlockShotNum-----"
					+ table.get(key).getBlockShotNum());
			System.out.println("-----getFaultyNum-----"
					+ table.get(key).getFaultyNum());
			System.out.println("-----getFoulNum-----"
					+ table.get(key).getFoulNum());
			System.out
					.println("-----getScore-----" + table.get(key).getScore());
			System.out.println("-----getHitRate-----"
					+ table.get(key).getHitRate());
			System.out.println("-----getThreeHitRate-----"
					+ table.get(key).getThreeHitRate());
			System.out.println("-----getPenaltyRate-----"
					+ table.get(key).getPenaltyRate());
			System.out.println("-----getWinRate-----"
					+ table.get(key).getWinRate());
			System.out.println("-----getAttackRound-----"
					+ table.get(key).getAttackRound());
			System.out.println("-----getAttackEfficiency-----"
					+ table.get(key).getAttackEfficiency());
			System.out.println("-----getDefensiveEfficiency-----"
					+ table.get(key).getDefensiveEfficiency());
			System.out.println("-----getAttackReboundRate-----"
					+ table.get(key).getAttackReboundRate());
			System.out.println("-----getDefensiveReboundRate-----"
					+ table.get(key).getDefensiveReboundRate());
			System.out.println("-----getStealRate-----"
					+ table.get(key).getStealRate());
			System.out.println("-----getAssistingRate-----"
					+ table.get(key).getAssistingRate());
		}
	}

}
