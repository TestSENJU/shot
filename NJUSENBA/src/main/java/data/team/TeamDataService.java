package data.team;

import java.util.Hashtable;

import po.TeamPO;

public interface TeamDataService {
	public Hashtable<String, TeamPO> getTeamData();
}
