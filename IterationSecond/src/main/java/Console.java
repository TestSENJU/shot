import java.io.PrintStream;

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

		}
	}

	class TestConfig {
		@CmdOption(names = { "--help", "-h", "-?" }, description = "show help", isHelp = true)
		public boolean help;
	}

	@CmdCommand(names = { "-player", "-p" }, description = "Show Player information")
	class Player {

	}

	@CmdCommand(names = { "-team", "-t" }, description = "Show Team information")
	class Team {

	}
}
