package BL;

public class BaseBL {
	private MatchBL matchService;

	public BaseBL() {
		matchService = new MatchBL_Impl();
	}

	public MatchBL getMatchLogic(int i) {
		if (i == 1)
			return this.matchService;
		else
			return null;
	}
}
