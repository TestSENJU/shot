package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

import po.TeamPO;

public class TeamSerialization {
	static Hashtable<String, TeamPO> teamTable = new Hashtable<String, TeamPO>();
	private static String team_path = "teams";
	private static String match_path = "matches";
	private static String team_serialization_path = "serialization/team";

	private static TeamSerialization ts;

	public static synchronized TeamSerialization getInstance() {
		if (ts == null)
			ts = new TeamSerialization();
		return ts;
	}

	public TeamSerialization() {
		readTeamFile(team_path);
		readMatchFile(match_path);
		writeFile(team_serialization_path);
	}

	private static void readTeamFile(String path) {
		String list[] = new File(team_path).list();
		for (int i = 0; i < list.length; i++) {
			if (list[i].toString().endsWith(".svg")) {
				String[] spl = list[i].toString().split(".svg");
				if (!teamTable.containsKey(spl[0]))
					teamTable.put(spl[0], new TeamPO(spl[0]));
			}
		}
	}

	private static void readMatchFile(String path) {
		File list[] = new File(path).listFiles();
		for (int i = 0; i < list.length; i++) {
			readOneMatchFile(list[i]);
		}
	}

	private static void readOneMatchFile(File file) {
		FileReader fr;
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			try {
				String temp = null;
				boolean isfirst = false;
				TeamPO team1 = null;
				TeamPO team2 = null;
				double team1_attackRound = 0.0;
				double team2_attackRound = 0.0;
				int team1_offensiveRebound = 0;
				int team2_offensiveRebound = 0;
				int team1_defensiveRebound = 0;
				int team2_defensiveRebound = 0;
				while ((temp = br.readLine()) != null) {
					String[] strspl = temp.split(";");
					if (strspl.length == 3) {
						String[] strsplname = strspl[1].split("-");
						if (teamTable.containsKey(strsplname[0])) {
							team1 = teamTable.get(strsplname[0]);
							team1_attackRound = team1.getAttackRound();
							team1_offensiveRebound = team1
									.getOffensiveReboundNum();
							team1_defensiveRebound = team1
									.getDefensiveReboundNum();
						} else {
							break;
						}
						if (teamTable.containsKey(strsplname[1])) {
							team2 = teamTable.get(strsplname[1]);
							team2_attackRound = team2.getAttackRound();
							team2_offensiveRebound = team2
									.getOffensiveReboundNum();
							team2_defensiveRebound = team2
									.getDefensiveReboundNum();
						} else {
							break;
						}
						team1.setMatchNum(team1.getMatchNum() + 1);
						team2.setMatchNum(team2.getMatchNum() + 1);

						String[] strsplscore = strspl[2].split("-");
						team1.setScore(team1.getScore()
								+ Integer.parseInt(strsplscore[0]));
						team1.setOpponent_score(team1.getOpponent_score()
								+ Integer.parseInt(strsplscore[1]));
						team2.setScore(team2.getScore()
								+ Integer.parseInt(strsplscore[1]));
						team2.setOpponent_score(team2.getOpponent_score()
								+ Integer.parseInt(strsplscore[0]));
						if (Integer.parseInt(strsplscore[0]) > Integer
								.parseInt(strsplscore[1])) {
							team1.setWinNum(team1.getWinNum() + 1);
						} else {
							team2.setWinNum(team2.getWinNum() + 1);
						}
					}
					if (strspl.length == 1) {
						isfirst = !isfirst;
					}
					if (isfirst == true && strspl.length == 18) {
						team1.setShotRightNum(team1.getShotRightNum()
								+ Integer.parseInt(strspl[3]));
						team1.setShotNum(team1.getShotNum()
								+ Integer.parseInt(strspl[4]));
						team1.setThreePointShotRightNum(team1
								.getThreePointShotRightNum()
								+ Integer.parseInt(strspl[5]));
						team1.setThreePointShotNum(team1.getThreePointShotNum()
								+ Integer.parseInt(strspl[6]));
						team1.setPenaltyShotRightNum(team1
								.getPenaltyShotRightNum()
								+ Integer.parseInt(strspl[7]));
						team1.setPenaltyShotNum(team1.getPenaltyShotNum()
								+ Integer.parseInt(strspl[8]));
						team1.setOffensiveReboundNum(team1
								.getOffensiveReboundNum()
								+ Integer.parseInt(strspl[9]));
						team1.setDefensiveReboundNum(team1
								.getOffensiveReboundNum()
								+ Integer.parseInt(strspl[10]));
						team1.setReboundNum(team1.getReboundNum()
								+ Integer.parseInt(strspl[11]));
						team1.setAssistNum(team1.getAssistNum()
								+ Integer.parseInt(strspl[12]));
						team1.setStealNum(team1.getStealNum()
								+ Integer.parseInt(strspl[13]));
						team1.setBlockShotNum(team1.getBlockShotNum()
								+ Integer.parseInt(strspl[14]));
						team1.setFaultyNum(team1.getFaultyNum()
								+ Integer.parseInt(strspl[15]));
						team1.setFoulNum(team1.getFoulNum()
								+ Integer.parseInt(strspl[16]));
					}
					if (isfirst == false && strspl.length == 18) {
						team2.setShotRightNum(team2.getShotRightNum()
								+ Integer.parseInt(strspl[3]));
						team2.setShotNum(team2.getShotNum()
								+ Integer.parseInt(strspl[4]));
						team2.setThreePointShotRightNum(team2
								.getThreePointShotRightNum()
								+ Integer.parseInt(strspl[5]));
						team2.setThreePointShotNum(team2.getThreePointShotNum()
								+ Integer.parseInt(strspl[6]));
						team2.setPenaltyShotRightNum(team2
								.getPenaltyShotRightNum()
								+ Integer.parseInt(strspl[7]));
						team2.setPenaltyShotNum(team2.getPenaltyShotNum()
								+ Integer.parseInt(strspl[8]));
						team2.setOffensiveReboundNum(team2
								.getOffensiveReboundNum()
								+ Integer.parseInt(strspl[9]));
						team2.setDefensiveReboundNum(team2
								.getOffensiveReboundNum()
								+ Integer.parseInt(strspl[10]));
						team2.setReboundNum(team2.getReboundNum()
								+ Integer.parseInt(strspl[11]));
						team2.setAssistNum(team2.getAssistNum()
								+ Integer.parseInt(strspl[12]));
						team2.setStealNum(team2.getStealNum()
								+ Integer.parseInt(strspl[13]));
						team2.setBlockShotNum(team2.getBlockShotNum()
								+ Integer.parseInt(strspl[14]));
						team2.setFaultyNum(team2.getFaultyNum()
								+ Integer.parseInt(strspl[15]));
						team2.setFoulNum(team2.getFoulNum()
								+ Integer.parseInt(strspl[16]));
					}
				}
				team1.setOpponent_attackRound(team1.getOpponent_attackRound()
						+ team2.getAttackRound() - team2_attackRound);
				team1.setOpponent_defensiveRebound(team1
						.getOpponent_defensiveRebound()
						+ team2.getDefensiveReboundNum()
						- team2_defensiveRebound);
				team1.setOpponent_offensiveRebound(team1
						.getOpponent_offensiveRebound()
						+ team2.getOffensiveReboundNum()
						- team2_offensiveRebound);
				team2.setOpponent_attackRound(team2.getOpponent_attackRound()
						+ team1.getAttackRound() - team1_attackRound);
				team2.setOpponent_defensiveRebound(team2
						.getOpponent_defensiveRebound()
						+ team1.getDefensiveReboundNum()
						- team1_defensiveRebound);
				team2.setOpponent_offensiveRebound(team2
						.getOpponent_offensiveRebound()
						+ team1.getOffensiveReboundNum()
						- team1_offensiveRebound);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					br.close();// close the stream
					fr.close();// close the stream
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

	}

	public void writeFile(String path) {
		FileReadAndWriteBuffer
				.write_to_file(team_serialization_path, teamTable);
	}
}
