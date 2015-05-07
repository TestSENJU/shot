import java.io.PrintStream;

import test.data.PlayerHotInfo;
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
		if (args[0].equals("-player")) {
			if (player.isHot) {
				// TODO
				// This is an demo
				getMostImprovedPlayer(player.hotField, player.getTopnumber());
			} else if (player.isKing) {
				if (player.isDaily) {
					// TODO
				} else {
					// TODO
				}
			} else {
				if (player.isFilter && !player.isSort) {
					// TODO
				} else if (player.isSort && !player.isFilter) {
					// TODO
				} else if (player.isFilter && player.isSort) {
					// TODO
				} else if (!player.isFilter && !player.isSort) {
					// TODO
				}
			}
		} else {
			if (team.isHot) {
				// TODO
			} else {
				if (team.isSort) {
					// TODO
				} else if (!team.isSort) {
					if (team.isHigh) {
						// TODO
					} else {
						// TODO
					}
				}
			}
		}
	}

	void getMostImprovedPlayer(String hotField, int topNumber) {
		// This is an demo
		PlayerHotInfo thePlayer = new PlayerHotInfo();
		// TODO
		out.print(thePlayer);
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
		private boolean isHigh;
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
	}
}
