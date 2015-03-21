package logic;

import po.TeamPO;
import vo.TeamVO;

public class TeamPoToVo {
	public TeamVO transform(TeamPO tpo){
		TeamVO team = new TeamVO();
		team.setName(tpo.getTeamName());
		team.setMatchSum(tpo.getMatchNum());
		team.setHitSum(tpo.getShotRightNum());
		team.setShootSum(tpo.getShotNum());
		team.setThreePointHitSum(tpo.getThreePointShotRightNum());
		team.setThreePointSum(tpo.getThreePointShotNum());
		team.setFreeThrowHitSum(tpo.getPenaltyShotRightNum());
		team.setFreeThrowSum(tpo.getPenaltyShotNum());
		team.setOffensiveReboundSum(tpo.getOffensiveReboundNum());
		team.setDefensiveReboundSum(tpo.getDefensiveReboundNum());
		team.setReboundSum(tpo.getReboundNum());
		team.setAssistingSum(tpo.getAssistNum());
		team.setStealSum(tpo.getStealNum());
		team.setBlockShotSum(tpo.getBlockShotNum());
		team.setMuffSum(tpo.getFaultyNum());
		team.setFoulSum(tpo.getFoulNum());
		team.setScore(tpo.getScore());
		//各种率
		
		return team;
	}
}
