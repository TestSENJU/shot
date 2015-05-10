import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Hashtable;

import test.data.PlayerHotInfo;
import test.data.TeamHighInfo;
import test.data.TeamHotInfo;
import test.data.TeamNormalInfo;
import vo.PlayerAllVO;
import vo.PlayerAverageVO;
import vo.PlayerShortVO;
import vo.TeamAllVO;
import vo.TeamAverageVO;
import BL.InitBL;
import BL.InitBL_Impl;
import BL.MatchBL;
import BL.PlayerBL;
import BL.TeamBL;
import de.tototec.cmdoption.CmdCommand;
import de.tototec.cmdoption.CmdOption;
import de.tototec.cmdoption.CmdlineParser;
import de.tototec.cmdoption.CmdlineParserException;

public class Console {
	PrintStream out;
	InitBL i;
	MatchBL m;
	PlayerBL p;
	TeamBL t;

	public void execute(PrintStream out, String[] args) {
		this.out = out;
		System.setOut(out);
		m = i.getMatchLogic();
		p = i.getPlayerLogic();
		t = i.getTeamLogic();
		if (args[0].contains("datasource")) {
			i = new InitBL_Impl(args[1]);
			m = i.getMatchLogic();
			p = i.getPlayerLogic();
			t = i.getTeamLogic();
			return;
		}

		TestConfig config = new TestConfig();
		Player player = new Player();
		Team team = new Team();

		CmdlineParser cp = new CmdlineParser(new Object[] { config, player,
				team });
		try {
			cp.parse(args);
		} catch (CmdlineParserException e) {
			e.printStackTrace();
		}
		if (args[0].contains("player")) {
			// TODO 记住有个数量要求 number
			VOMakeInfoTool tool = new VOMakeInfoTool();
			Hashtable<String, ?> vo;
			if (team.isTotal) {
				vo = new Hashtable<String, PlayerAllVO>();
			} else {
				vo = new Hashtable<String, PlayerAverageVO>();
			}
			if (player.isHot) {
				int hotNum = 11;
				if (player.hotField.contains("score")) {
					hotNum = 11;
				} else if (player.hotField.contains("rebound")) {
					hotNum = 0;
				} else if (player.hotField.contains("assit")) {
					hotNum = 1;
				}
				if (player.isSeason) {
					ArrayList<PlayerShortVO> svo = p.getHotPlayerByNum(hotNum,
							player.num);
					for (PlayerShortVO pvo : svo) {
						// TODO
					}
				} else {

				}
			} else if (player.isKing) {
				if (player.isSeason) {
					// TODO
				} else {
					// TODO
				}
			} else {
				if (player.isFilter && !player.isSort) {
					String[] spl = player.filterField.split(",");
					ArrayList<Integer> nums = new ArrayList<Integer>();
					for (String s : spl) {
						if (s.contains("F")) {
							// TODO
						} else if (s.contains("G")) {
							// TODO
						} else if (s.contains("C")) {
							// TODO
						} else if (s.contains("A")) {
							// TODO
						} else if (s.contains("WEST")) {
							// TODO
						} else if (s.contains("EAST")) {
							// TODO
						} else if (s.contains("ALL")) {
							// TODO
						}
					}
				} else if (player.isSort && !player.isFilter) {
					String[] spl = player.sortField.split(",");
					ArrayList<Integer> nums = new ArrayList<Integer>();
					int i = 0;
					String field = "";
					for (String s : spl) {
						if (team.hotField.contains("score")) {
							nums.set(0, 11);
							i = 11;
							field = "score";
						} else if (team.hotField.contains("rebound")) {
							nums.set(0, 0);
							i = 0;
							field = "rebound";
						} else if (team.hotField.contains("assit")) {
							nums.set(0, 1);
							i = 1;
							field = "assit";
						} else if (team.hotField.contains("blockShot")) {
							nums.set(0, 8);
							i = 8;
							field = "blockShot";
						} else if (team.hotField.contains("steal")) {
							nums.set(0, 7);
							i = 7;
							field = "steal";
						} else if (team.hotField.contains("foul")) {
							nums.set(0, 10);
							i = 10;
							field = "foul";
						} else if (team.hotField.contains("fault")) {
							nums.set(0, 9);
							i = 9;
							field = "fault";
						} else if (s.contains("minute")) {
							nums.set(0, 27);
							i = 27;
							field = "minute";
						} else if (s.contains("efficient")) {
							nums.set(0, 12);
							i = 12;
							field = "efficient";
						} else if (s.contains("shot")) {
							nums.set(0, 2);
							i = 2;
							field = "shot";
						} else if (s.contains("three")) {
							nums.set(0, 3);
							i = 3;
							field = "three";
						} else if (s.contains("penalty")) {
							nums.set(0, 4);
							i = 4;
							field = "penalty";
						} else if (s.contains("doubleTwo")) {
							nums.set(0, 29);
							i = 29;
							field = "doubleTwo";
						} else if (s.contains("realShot")) {

						} else if (s.contains("GmSc")) {

						} else if (s.contains("shotEfficient")) {

						} else if (s.contains("reboundEfficient")) {

						} else if (s.contains("offendReboundEfficient")) {

						} else if (s.contains("defendReboundEfficient")) {

						} else if (s.contains("assitEfficient")) {

						} else if (s.contains("stealEfficient")) {

						} else if (s.contains("blockShotEfficient")) {

						} else if (s.contains("faultEfficient")) {

						} else if (s.contains("frequency")) {

						}
					}
					if (player.sortField.contains("asc")) {

					} else if (player.sortField.contains("desc")) {

					}
				} else if (player.isFilter && player.isSort) {
					String[] spl = player.filterField.split(",");
					for (String s : spl) {
						if (s.contains("F")) {
							// TODO
						} else if (s.contains("G")) {
							// TODO
						} else if (s.contains("C")) {
							// TODO
						} else if (s.contains("A")) {
							// TODO
						} else if (s.contains("WEST")) {
							// TODO
						} else if (s.contains("EAST")) {
							// TODO
						} else if (s.contains("ALL")) {
							// TODO
						}
					}
					String[] spl2 = player.sortField.split(",");
					for (String s : spl2) {
						if (s.contains("point")) {

						} else if (s.contains("rebound")) {

						} else if (s.contains("assit")) {

						} else if (s.contains("blockShot")) {

						} else if (s.contains("steal")) {

						} else if (s.contains("foul")) {

						} else if (s.contains("fault")) {

						} else if (s.contains("minute")) {

						} else if (s.contains("efficient")) {

						} else if (s.contains("shot")) {

						} else if (s.contains("three")) {

						} else if (s.contains("penalty")) {

						} else if (s.contains("doubleTwo")) {

						} else if (s.contains("realShot")) {

						} else if (s.contains("GmSc")) {

						} else if (s.contains("shotEfficient")) {

						} else if (s.contains("reboundEfficient")) {

						} else if (s.contains("offendReboundEfficient")) {

						} else if (s.contains("defendReboundEfficient")) {

						} else if (s.contains("assitEfficient")) {

						} else if (s.contains("stealEfficient")) {

						} else if (s.contains("blockShotEfficient")) {

						} else if (s.contains("faultEfficient")) {

						} else if (s.contains("frequency")) {

						}
					}
					if (player.sortField.contains("asc")) {

					} else if (player.sortField.contains("desc")) {

					}

				} else if (!player.isFilter && !player.isSort) {
					String[] spl = player.filterField.split(",");
					for (String s : spl) {
						if (s.contains("F")) {
							// TODO
						} else if (s.contains("G")) {
							// TODO
						} else if (s.contains("C")) {
							// TODO
						} else if (s.contains("A")) {
							// TODO
						} else if (s.contains("WEST")) {
							// TODO
						} else if (s.contains("EAST")) {
							// TODO
						} else if (s.contains("ALL")) {
							// TODO
						}
					}
				}
			}
		}
		// --------------team-----------------------
		else {
			VOMakeInfoTool tool = new VOMakeInfoTool();
			// TODO 记住有个数量要求 number
			if (team.isHot) {
				ArrayList<Integer> nums = new ArrayList<Integer>();
				String field = "";
				int i = 0;
				if (team.hotField.contains("score")) {
					nums.set(0, 14);
					i = 14;
					field = "score";
				} else if (team.hotField.contains("rebound")) {
					nums.set(0, 8);
					i = 8;
					field = "rebound";
				} else if (team.hotField.contains("assit")) {
					nums.set(0, 9);
					i = 9;
					field = "assit";
				} else if (team.hotField.contains("blockShot")) {
					nums.set(0, 11);
					i = 11;
					field = "blockShot";
				} else if (team.hotField.contains("steal")) {
					nums.set(0, 10);
					i = 10;
					field = "steal";
				} else if (team.hotField.contains("foul")) {
					nums.set(0, 13);
					i = 13;
					field = "foul";
				} else if (team.hotField.contains("fault")) {
					nums.set(0, 12);
					i = 12;
					field = "fault";
				} else if (team.hotField.contains("shot")) {
					nums.set(0, 15);
					i = 15;
					field = "shot";
				} else if (team.hotField.contains("three")) {
					nums.set(0, 16);
					i = 16;
					field = "three";
				} else if (team.hotField.contains("penalty")) {
					nums.set(0, 17);
					i = 17;
					field = "penalty";
				} else if (team.hotField.contains("defendRebound")) {
					nums.set(0, 7);
					i = 7;
					field = "defendRebound";
				} else if (team.hotField.contains("offendRebound")) {
					nums.set(0, 6);
					i = 6;
					field = "offendRebound";
				}
				ArrayList<TeamAverageVO> vo = t.getHotTeamByNum(nums, team.num);

				for (int k = 0; k < vo.size(); k++) {
					TeamHotInfo tio = tool.getTeamHot(vo.get(k), i, vo.get(k)
							.getLeague(), field);
					out.print(tio);
				}
			} else {
				ArrayList<TeamAllVO> vo = new ArrayList<TeamAllVO>();
				ArrayList<TeamAverageVO> avo = new ArrayList<TeamAverageVO>();
				if (team.isSort) {
					String[] spl = team.sortField.split(",");
					ArrayList<Integer> nums = new ArrayList<Integer>();
					for (String s : spl) {
						if (s.contains("point")) {
							nums.add(14);
						} else if (s.contains("rebound")) {
							nums.add(8);
						} else if (s.contains("assit")) {
							nums.add(9);
						} else if (s.contains("blockShot")) {
							nums.add(11);
						} else if (s.contains("steal")) {
							nums.add(10);
						} else if (s.contains("foul")) {
							nums.add(13);
						} else if (s.contains("fault")) {
							nums.add(12);
						} else if (s.contains("shot")) {
							nums.add(15);
						} else if (s.contains("three")) {
							nums.add(16);
						} else if (s.contains("penalty")) {
							nums.add(17);
						} else if (s.contains("defendRebound")) {
							nums.add(7);
						} else if (s.contains("offendRebound")) {
							nums.add(6);
						} else if (s.contains("winRate")) {
							nums.add(18);
						} else if (s.contains("offendRebound")) {
							nums.add(19);
						} else if (s.contains("offendEfficient")) {
							nums.add(20);
						} else if (s.contains("defendEfficient")) {
							nums.add(21);
						} else if (s.contains("offendReboundEfficient")) {
							nums.add(25);
						} else if (s.contains("defendReboundEfficient")) {
							nums.add(26);
						} else if (s.contains("stealEfficient")) {
							nums.add(23);
						} else if (s.contains("assitEfficient")) {
							nums.add(24);
						}
					}

					if (team.isAll) {
						if (team.ifAscSort) {
							vo = t.getTeamAllRankingByNumRaising(nums, team.num);
						} else {
							vo = t.getTeamAllRankingByNumDeclining(nums,
									team.num);
						}
					} else {
						if (team.ifAscSort) {
							avo = t.getTeamAverageRankingByNum(nums, team.num);
						} else {
							avo = t.getTeamAverageRankingByNum(nums, team.num);
						}
					}
					if (team.isHigh) {
						if (team.isAll) {
							for (int k = 0; k < vo.size(); k++) {
								TeamHighInfo tio = tool.getTeamHigh(avo.get(k));
								out.print(tio);
							}
						} else {
							for (int k = 0; k < vo.size(); k++) {
								TeamHighInfo tio = tool.getTeamHigh(avo.get(k));
								out.print(tio);
							}
						}
					} else {
						if (team.isAll) {
							for (int k = 0; k < vo.size(); k++) {
								TeamNormalInfo tio = tool.getTeamAllNormal(vo
										.get(k));
								out.print(tio);
							}
						} else {
							for (int k = 0; k < vo.size(); k++) {
								TeamNormalInfo tio = tool
										.getTeamAverageNormal(avo.get(k));
								out.print(tio);
							}
						}
					}
				} else if (!team.isSort) {
					if (team.isHigh) {
						if (team.isAll) {
							vo = t.getTeamAll();
							for (int k = 0; k < vo.size(); k++) {
								TeamNormalInfo tio = tool.getTeamAllNormal(vo
										.get(k));
								out.print(tio);
							}
						} else {
							avo = t.getTeamAverage();
							for (int k = 0; k < vo.size(); k++) {
								TeamNormalInfo tio = tool
										.getTeamAverageNormal(avo.get(k));
								out.print(tio);
							}
						}
					} else {
						if (team.isAll) {
							vo = t.getTeamAll();
							for (int k = 0; k < vo.size(); k++) {
								TeamNormalInfo tio = tool.getTeamAllNormal(vo
										.get(k));
								out.print(tio);
							}
						} else {
							avo = t.getTeamAverage();
							for (int k = 0; k < vo.size(); k++) {
								TeamNormalInfo tio = tool
										.getTeamAverageNormal(avo.get(k));
								out.print(tio);
							}
						}
					}
				}

			}
		}
	}

	class TestConfig {
		@CmdOption(names = { "--help", "-h", "-?" }, description = "show help", isHelp = true)
		public boolean help;
	}

	@SuppressWarnings("unused")
	@CmdCommand(names = { "-player", "-p" }, description = "Show Player information")
	class Player {
		private boolean showTotal = false;
		private int num = 50;
		private int topNumber = 5;
		private boolean isHigh = false;
		private boolean isAll = true;
		private boolean isHot = false;
		private String hotField = "";
		private boolean isKing = false;
		private String kingField = "";
		private boolean isSeason;
		private boolean isDaily;
		private boolean isAsc = false;
		private boolean isFilter = false;
		private String filterField = "";
		private boolean isSort = false;
		private String sortField = "";

		@CmdOption(names = { "-high" }, description = "show high info", conflictsWith = {
				"-avg", "-total", "-hot", "-filter", "-king" })
		public void isHigh() {
			this.isHigh = true;
		}

		@CmdOption(names = { "-avg" }, description = "show avg", maxCount = 1, minCount = 0, conflictsWith = { "-total" })
		public void isAvg() {
			showTotal = false;
		}

		@CmdOption(names = { "-hot" }, args = { "field" }, description = "show hot", maxCount = 1, minCount = 0, conflictsWith = {
				"-all", "-king", "-total", "-avg", "-filter", "-sort" })
		public void setIsHot(String field) {
			isHot = true;
			isAll = false;
			isKing = false;
			this.hotField = field;
		}

		public String getHotField() {
			return hotField;
		}

		@CmdOption(names = { "-king" }, args = { "field" }, description = "show king", maxCount = 1, minCount = 0, conflictsWith = {
				"-avg", "-total", "-all", "-hot", "-filter", "-sort" })
		public void setIsKing(String field) {
			isKing = true;
			isHot = false;
			isAll = false;
			kingField = field;
		}

		@CmdOption(names = { "-season" }, description = "show season info", conflictsWith = { "-daily" }, requires = { "-king" })
		public void setIsSeason() {
			isSeason = true;
			isDaily = false;
		}

		@CmdOption(names = { "-daily" }, description = "show daily info", conflictsWith = { "-season" }, requires = { "-king" })
		public void setIsDaily() {
			isSeason = false;
			isDaily = true;
		}

		@CmdOption(names = { "-all" }, description = "show all information", maxCount = 1, minCount = 0, conflictsWith = {
				"-hot", "-king" })
		public void setIsAll() {
			this.isHot = false;
			this.isAll = true;
			this.isKing = false;
		}

		@CmdOption(names = { "-total" }, description = "show total", maxCount = 1, minCount = 0, conflictsWith = { "-avg" })
		public void setShowTotal() {
			this.showTotal = true;
		}

		public boolean isShowTotal() {
			return showTotal;
		}

		@CmdOption(names = { "-n" }, args = { "number" }, maxCount = 1, minCount = 0)
		public void setNum(String number) {
			this.num = Integer.parseInt(number);
		}

		public int getNum() {
			return num;
		}

		public int getTopnumber() {
			return topNumber;
		}

		@CmdOption(names = { "-filter" }, args = { "field.value" }, description = "show filter info", conflictsWith = {
				"-sort", "-king", "-hot", "-high" })
		public void isFilter(String field) {
			isFilter = true;
			filterField = field;
			isHigh = false;
		}

		@CmdOption(names = { "-sort" }, args = { "filed.sortOrder" }, description = "show sort info", conflictsWith = {
				"-filter", "-king", "-hot" })
		public void isSort(String field) {
			isSort = true;
			sortField = field;
		}
	}

	@SuppressWarnings("unused")
	@CmdCommand(names = { "-team", "-t" }, description = "Show Team information")
	class Team {
		private boolean isTotal;
		private boolean isAll = true;
		private boolean isHot;
		private String hotField;
		private boolean isHigh = false;
		private int num = 30;
		private boolean isSort;
		private String sortField;
		private boolean ifAscSort;

		@CmdOption(names = { "-avg" }, maxCount = 1, minCount = 0, conflictsWith = {
				"-total", "-hot" })
		private void setAvg() {
			isTotal = false;
		}

		@CmdOption(names = { "-total" }, maxCount = 1, minCount = 0, conflictsWith = {
				"-avg", "-hot" })
		private void setTotal() {
			isTotal = true;
		}

		@CmdOption(names = { "-n" }, args = { "number" }, maxCount = 1, minCount = 0)
		public void setNum(String number) {
			num = Integer.parseInt(number);
		}

		@CmdOption(names = { "-all" }, maxCount = 1, minCount = 0, conflictsWith = { "-hot" })
		private void setAll() {
			isAll = true;
		}

		@CmdOption(names = { "-hot" }, args = { "field" }, maxCount = 1, minCount = 0, conflictsWith = {
				"-all", "-avg", "-total", "-sort" })
		private void setHot(String field) {
			isHot = true;
			hotField = field;
			isAll = false;
		}

		@CmdOption(names = { "-sort" }, args = { "field" }, maxCount = 1, minCount = 0)
		private void setSort(String field) {
			isSort = true;
			String[] tmpStr = field.split("\\.");
			sortField = tmpStr[0];
			if (tmpStr[1].equals("asc"))
				ifAscSort = true;
		}

		@CmdOption(names = { "-high" }, args = { "field" }, maxCount = 1, minCount = 0)
		private void setHigh() {
			isHigh = true;
		}
	}
}
