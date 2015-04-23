package BL;

import Data.ReadFileThread;

public class InitBL_Impl implements InitBL{
	private String root;
    ReadFileThread rft;
    private MatchBL matchService;
    private PlayerBL playerService;
    private TeamBL teamService;
    public InitBL_Impl(String rootname){
    	this.root=rootname;
    	rft=new ReadFileThread(this.root);
    	rft.start();rft.run();
    	matchService=new MatchBL_Impl();
    	playerService=new PlayerBL_Impl();
    	teamService=new TeamBL_Impl();
    }
    
	public MatchBL getMatchLogic() {
		// TODO Auto-generated method stub
		return this.matchService;
	}

	public PlayerBL getPlayerLogic() {
		// TODO Auto-generated method stub
		return this.playerService;
	}

	public TeamBL getTeamLogic() {
		// TODO Auto-generated method stub
		return this.teamService;
	}

}
