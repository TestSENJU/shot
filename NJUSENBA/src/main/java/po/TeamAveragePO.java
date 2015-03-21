package po;

/**
 * @author XY
 *
 * @param teamName
 *            the name of the team 球队名称
 * @param matchNuM
 *            the number of matches 比赛场数
 * @param shotRightNum
 *            hit right 投篮命中数
 * @param shotNum
 *            hit(right or not right) 投篮出手次数
 * @param threePointShotRightNum
 *            three point hit right 三分命中数
 * @param threePointShotNum
 *            three point hit(right or not right) 三分出手数
 * @param penaltyShotRightNum
 *            penalty shot right 罚球命中数
 * @param penaltyShotNum
 *            penalty shot(right or not right) 罚球出手数
 * @param offensiveReboundNum
 *            offensive rebound 进攻篮板
 * @param defensiveReboundNum
 *            defensive rebound 防守篮板
 * @param reboundNum
 *            rebound 篮板数
 * @param assistNum
 *            assist shot 助攻数
 * @param stealNum
 *            steal the ball 抢断数
 * @param blockShotNum
 *            block shot 盖帽数
 * @param faultyNum
 *            faulty 失误数
 * @param foulNum
 *            foul 犯规数
 * @param score
 *            score 比赛得分
 * @param hitRate
 *            命中率
 * @param winRate
 *            胜率
 * @param attackRound
 *            进攻回合
 * @param attackEfficiency
 *            进攻效率
 * @param defensiveEfficiency
 *            防守效率
 * @param attackReboundRate
 *            进攻篮板效率
 * @param defensiveReboundRate
 *            防守篮板效率
 * @param stealRate
 *            抢断效率
 * @param assistingRate
 *            助攻率
 */
public class TeamAveragePO {
	private String teamName;
	private int matchNum;
	private double shotRightNum;
	private double shotNum;
	private double threePointShotRightNum;
	private double threePointShotNum;
	private double penaltyShotRightNum;
	private double penaltyShotNum;
	private double offensiveReboundNum;
	private double defensiveReboundNum;
	private double reboundNum;
	private double assistNum;
	private double stealNum;
	private double blockShotNum;
	private double faultyNum;
	private double foulNum;
	private double score;
	private double hitRate;
	private double winRate;
	private double attackRound;
	private double attackEfficiency;
	private double defensiveEfficiency;
	private double attackReboundRate;
	private double defensiveReboundRate;
	private double stealRate;
	private double assistingRate;

	public TeamAveragePO(TeamPO po) {
		this.teamName = po.getTeamName();
		this.matchNum = po.getMatchNum();
		if (this.matchNum != 0) {
			this.shotRightNum = po.getShotRightNum() / this.matchNum;
			this.shotNum = po.getShotNum() / this.matchNum;
			this.threePointShotRightNum = po.getThreePointShotRightNum()
					/ this.matchNum;
			this.threePointShotNum = po.getThreePointShotNum() / this.matchNum;
			this.penaltyShotRightNum = po.getPenaltyShotRightNum()
					/ this.matchNum;
			this.penaltyShotNum = po.getPenaltyShotNum() / this.matchNum;
			this.offensiveReboundNum = po.getOffensiveReboundNum()
					/ this.matchNum;
			this.defensiveReboundNum = po.getDefensiveReboundNum()
					/ this.matchNum;
			this.reboundNum = po.getReboundNum() / this.matchNum;
			this.assistNum = po.getAssistNum() / this.matchNum;
			this.stealNum = po.getStealNum() / this.matchNum;
			this.blockShotNum = po.getBlockShotNum() / this.matchNum;
			this.faultyNum = po.getFaultyNum() / this.matchNum;
			this.foulNum = po.getFoulNum() / this.matchNum;
			this.score = po.getScore() / this.matchNum;
		} else {
			this.shotRightNum = 0;
			this.shotNum = 0;
			this.threePointShotRightNum = 0;
			this.threePointShotNum = 0;
			this.penaltyShotRightNum = 0;
			this.penaltyShotNum = 0;
			this.offensiveReboundNum = 0;
			this.defensiveReboundNum = 0;
			this.reboundNum = 0;
			this.assistNum = 0;
			this.stealNum = 0;
			this.blockShotNum = 0;
			this.faultyNum = 0;
			this.foulNum = 0;
			this.score = 0;
		}
		this.hitRate = po.getHitRate();
		this.winRate = po.getWinRate();
		this.attackRound = po.getAttackRound();
		this.attackEfficiency = po.getAttackEfficiency();
		this.defensiveEfficiency = po.getDefensiveEfficiency();
		this.attackReboundRate = po.getAttackReboundRate();
		this.defensiveReboundRate = po.getDefensiveReboundRate();
		this.stealRate = po.getStealRate();
		this.assistingRate = po.getAssistingRate();
	}

	public String getTeamName() {
		return teamName;
	}

	public int getMatchNum() {
		return matchNum;
	}

	public double getShotRightNum() {
		return shotRightNum;
	}

	public double getShotNum() {
		return shotNum;
	}

	public double getThreePointShotRightNum() {
		return threePointShotRightNum;
	}

	public double getThreePointShotNum() {
		return threePointShotNum;
	}

	public double getPenaltyShotRightNum() {
		return penaltyShotRightNum;
	}

	public double getPenaltyShotNum() {
		return penaltyShotNum;
	}

	public double getOffensiveReboundNum() {
		return offensiveReboundNum;
	}

	public double getDefensiveReboundNum() {
		return defensiveReboundNum;
	}

	public double getReboundNum() {
		return reboundNum;
	}

	public double getAssistNum() {
		return assistNum;
	}

	public double getStealNum() {
		return stealNum;
	}

	public double getBlockShotNum() {
		return blockShotNum;
	}

	public double getFaultyNum() {
		return faultyNum;
	}

	public double getFoulNum() {
		return foulNum;
	}

	public double getScore() {
		return score;
	}

	public double getHitRate() {
		return hitRate;
	}

	public double getWinRate() {
		return winRate;
	}

	public double getAttackRound() {
		return attackRound;
	}

	public double getAttackEfficiency() {
		return attackEfficiency;
	}

	public double getDefensiveEfficiency() {
		return defensiveEfficiency;
	}

	public double getAttackReboundRate() {
		return attackReboundRate;
	}

	public double getDefensiveReboundRate() {
		return defensiveReboundRate;
	}

	public double getStealRate() {
		return stealRate;
	}

	public double getAssistingRate() {
		return assistingRate;
	}

}
