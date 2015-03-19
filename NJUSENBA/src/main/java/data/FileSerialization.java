package data;

import java.io.File;
import java.io.IOException;

public class FileSerialization {
	private static String team_serialization_path = "serialization/team";
	private static String player_serialization_path = "serialization/player";
	private static FileSerialization fs;

	public static synchronized FileSerialization getInstance() {
		if (fs == null)
			fs = new FileSerialization();
		return fs;
	}

	public FileSerialization() {
		File team_file = new File(team_serialization_path);
		if (!team_file.exists()) {
			try {
				team_file.createNewFile();
				new TeamSerialization();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {

		}
		// File player_file = new File(player_serialization_path);
		// if (!player_file.exists()) {
		// try {
		// player_file.createNewFile();
		// new PlayerSerialization();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// } else {
		//
		// }
	}
}
