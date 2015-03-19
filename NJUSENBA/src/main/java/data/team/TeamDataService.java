package data.team;

import java.util.Hashtable;

import po.TeamAveragePO;
import po.TeamPO;

public interface TeamDataService {
	public Hashtable<String, TeamPO> getTeamData();

	public Hashtable<String, TeamAveragePO> getTeamAverageData();
}
