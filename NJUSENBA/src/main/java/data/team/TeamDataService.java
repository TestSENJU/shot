package data.team;

import java.util.Hashtable;

import po.TeamAgeveraPO;
import po.TeamPO;

public interface TeamDataService {
	public Hashtable<String, TeamPO> getTeamData();

	public Hashtable<String, TeamAgeveraPO> getTeamAverageData();
}
