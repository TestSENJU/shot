package data;

import java.io.File;
import java.io.IOException;

public class FileSerialization {
	private static String team_serialization_path = "serialization/team";
	private static String playerAll_serialization_path = "serialization/playerAllScore";
	private static String playerAver_serialization_path = "serialization/playerAverageScore";
	private static String playerBasic_serialization_path = "serialization/playerBasicInfo";
	
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
		 File playerAll_file = new File(playerAll_serialization_path);
		 File playerAver_file = new File(playerAver_serialization_path);
		 File playerBasic_file = new File(playerBasic_serialization_path);
		 if (!playerAll_file.exists()&&(!playerAver_file.exists())&&(!playerBasic_file.exists())) {
		 try {
			 playerAll_file.createNewFile();
			 playerAver_file.createNewFile();
			 playerBasic_file.createNewFile();
		 new PlayerSerialization();
		 } catch (IOException e) {
		 e.printStackTrace();
		 }
		 } else {
		
		 }
		
	}
}
