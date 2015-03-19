package data.team;

import java.io.EOFException;
import java.util.Hashtable;

import po.TeamPO;
import data.FileReadAndWriteBuffer;
import data.FileSerialization;

public class TeamData {
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

}
