package data.team;

import java.io.EOFException;
import java.util.Hashtable;
import java.util.Set;

import po.TeamAveragePO;
import po.TeamPO;
import data.FileReadAndWriteBuffer;
import data.FileSerialization;
@SuppressWarnings("unused")
public class TeamData implements TeamDataService {
	static Hashtable<String, TeamPO> teamTable = new Hashtable<String, TeamPO>();
	private static String team_serialization_path = "serialization/team";
	public static TeamData td;

	public static synchronized TeamData getInstance() {
		if (td == null)
			td = new TeamData();
		return td;
	}

	public TeamData() {
		FileSerialization fs = FileSerialization.getInstance();
	}

	@SuppressWarnings("unchecked")
	public Hashtable<String, TeamPO> getTeamData() {
		try {
			teamTable = (Hashtable<String, TeamPO>) FileReadAndWriteBuffer
					.read_from_file(team_serialization_path);
		} catch (EOFException e) {
			e.printStackTrace();
		}
		return teamTable;
	}

	public Hashtable<String, TeamAveragePO> getTeamAverageData() {
		Hashtable<String, TeamAveragePO> polist = new Hashtable<String, TeamAveragePO>();
		Set<String> keys = teamTable.keySet();
		for (String key : keys) {
			polist.put(key, new TeamAveragePO(teamTable.get(key)));
		}
		return null;
	}

}
