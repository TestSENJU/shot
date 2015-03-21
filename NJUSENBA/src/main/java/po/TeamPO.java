package po;

import java.io.Serializable;

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
@SuppressWarnings("unused")
public class TeamPO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String teamName;
	private int matchNum;
	private int winNum;

	private int shotRightNum;
	private int shotNum;
	private int threePointShotRightNum;
	private int threePointShotNum;
	private int penaltyShotRightNum;
	private int penaltyShotNum;
	private int offensiveReboundNum;
	private int defensiveReboundNum;
	private int reboundNum;
	private int assistNum;
	private int stealNum;
	private int blockShotNum;
	private int faultyNum;
	private int foulNum;
	private int score;
//	private double hitRate;
//	private double winRate;
//	private double attackRound;
//	private double attackEfficiency;
//	private double defensiveEfficiency;
//	private double attackReboundRate;
//	private double defensiveReboundRate;
	// private double stealRate;
	// private double assistingRate;

	private int opponent_defensiveRebound;
	private int opponent_offensiveRebound;
	private double opponent_attackRound;
	private int opponent_score;

	public TeamPO(String teamName) {
		this.teamName = teamName;
		this.matchNum = 0;
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

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public void setMatchNum(int matchNum) {
		this.matchNum = matchNum;
	}

	public void setShotRightNum(int shotRightNum) {
		this.shotRightNum = shotRightNum;
	}

	public void setShotNum(int shotNum) {
		this.shotNum = shotNum;
	}

	public void setThreePointShotRightNum(int threePointShotRightNum) {
		this.threePointShotRightNum = threePointShotRightNum;
	}

	public void setThreePointShotNum(int threePointShotNum) {
		this.threePointShotNum = threePointShotNum;
	}

	public void setPenaltyShotRightNum(int penaltyShotRightNum) {
		this.penaltyShotRightNum = penaltyShotRightNum;
	}

	public void setPenaltyShotNum(int penaltyShotNum) {
		this.penaltyShotNum = penaltyShotNum;
	}

	public void setOffensiveReboundNum(int offensiveReboundNum) {
		this.offensiveReboundNum = offensiveReboundNum;
	}

	public void setDefensiveReboundNum(int defensiveReboundNum) {
		this.defensiveReboundNum = defensiveReboundNum;
	}

	public void setReboundNum(int reboundNum) {
		this.reboundNum = reboundNum;
	}

	public void setAssistNum(int assistNum) {
		this.assistNum = assistNum;
	}

	public void setStealNum(int stealNum) {
		this.stealNum = stealNum;
	}

	public void setBlockShotNum(int blockShotNum) {
		this.blockShotNum = blockShotNum;
	}

	public void setFaultyNum(int faultyNum) {
		this.faultyNum = faultyNum;
	}

	public void setFoulNum(int foulNum) {
		this.foulNum = foulNum;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getTeamName() {
		return teamName;
	}

	public int getMatchNum() {
		return matchNum;
	}

	public int getShotRightNum() {
		return shotRightNum;
	}

	public int getShotNum() {
		return shotNum;
	}

	public int getThreePointShotRightNum() {
		return threePointShotRightNum;
	}

	public int getThreePointShotNum() {
		return threePointShotNum;
	}

	public int getPenaltyShotRightNum() {
		return penaltyShotRightNum;
	}

	public int getPenaltyShotNum() {
		return penaltyShotNum;
	}

	public int getOffensiveReboundNum() {
		return offensiveReboundNum;
	}

	public int getDefensiveReboundNum() {
		return defensiveReboundNum;
	}

	public int getReboundNum() {
		return reboundNum;
	}

	public int getAssistNum() {
		return assistNum;
	}

	public int getStealNum() {
		return stealNum;
	}

	public int getBlockShotNum() {
		return blockShotNum;
	}

	public int getFaultyNum() {
		return faultyNum;
	}

	public int getFoulNum() {
		return foulNum;
	}

	public int getScore() {
		return score;
	}

	public double getWinRate() {
		if (matchNum != 0)
			return winNum / matchNum;
		else
			return 0;
	}

	public double getAttackEfficiency() {
		if (getAttackRound() != 0)
			return getScore() / getAttackRound();
		else
			return 0;
	}

	public double getDefensiveEfficiency() {
		if (getOpponent_attackRound() != 0)
			return getOpponent_score() / getOpponent_attackRound();
		else
			return 0;
	}

	public double getAttackReboundRate() {
		if (getOffensiveReboundNum() != 0
				&& getOpponent_defensiveRebound() != 0)
			return getOffensiveReboundNum()
					/ (getOffensiveReboundNum() + getOpponent_defensiveRebound());
		else
			return 0;
	}

	public double getDefensiveReboundRate() {
		if (getDefensiveReboundNum() != 0
				&& getOpponent_offensiveRebound() != 0)
			return getDefensiveReboundNum()
					/ (getDefensiveReboundNum() + getOpponent_offensiveRebound());
		else
			return 0;
	}

	public double getStealRate() {
		if (getOpponent_attackRound() != 0)
			return getStealNum() / getOpponent_attackRound();
		else
			return 0;
	}

	public double getAssistingRate() {
		if (getAttackRound() != 0)
			return getAssistNum() / getAttackRound();
		else
			return 0;
	}

	public double getHitRate() {
		if (getShotNum() != 0)
			return getShotRightNum() / getShotNum();
		else
			return 0;
	}

	public double getAttackRound() {
		if (offensiveReboundNum != 0 && opponent_defensiveRebound != 0) {
			return shotNum
					+ 0.4
					* penaltyShotNum
					- 1.07
					* (offensiveReboundNum
							/ (offensiveReboundNum + opponent_defensiveRebound) * (shotNum - shotRightNum))
					+ 1.07 * faultyNum;
		} else
			return 0;
	}

	public void setOpponent_defensiveRebound(int opponent_defensiveRebound) {
		this.opponent_defensiveRebound = opponent_defensiveRebound;
	}

	public void setOpponent_offensiveRebound(int opponent_offensiveRebound) {
		this.opponent_offensiveRebound = opponent_offensiveRebound;
	}

	public void setOpponent_attackRound(double opponent_attackRound) {
		this.opponent_attackRound = opponent_attackRound;
	}

	public void setOpponent_score(int opponent_score) {
		this.opponent_score = opponent_score;
	}

	public int getOpponent_defensiveRebound() {
		return opponent_defensiveRebound;
	}

	public int getOpponent_offensiveRebound() {
		return opponent_offensiveRebound;
	}

	public double getOpponent_attackRound() {
		return opponent_attackRound;
	}

	public int getOpponent_score() {
		return opponent_score;
	}

	public int getWinNum() {
		return winNum;
	}

	public void setWinNum(int winNum) {
		this.winNum = winNum;
	}

}
