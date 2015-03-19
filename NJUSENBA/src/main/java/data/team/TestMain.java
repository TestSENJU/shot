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
			System.out.println(key + ":" + table.get(key).getScore());
		}
	}

}
