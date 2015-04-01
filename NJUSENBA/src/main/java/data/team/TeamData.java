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
	static Hashtable<String, TeamAveragePO> teamAverageTable = new Hashtable<String, TeamAveragePO>();
	private static String team_serialization_path = "serialization/team";
	private static String teamAverage_serialization_path = "serialization/teamAverage";
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

	@SuppressWarnings("unchecked")
	public Hashtable<String, TeamAveragePO> getTeamAverageData() {
		try {
			teamAverageTable = (Hashtable<String, TeamAveragePO>) FileReadAndWriteBuffer
					.read_from_file(teamAverage_serialization_path);
		} catch (EOFException e) {
			e.printStackTrace();
		}
		return teamAverageTable;
	}

}
