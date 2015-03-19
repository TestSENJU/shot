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
 *            score 比赛总得分
 * @param ***Average the average number of the above data 以上数据后加Average即为场均数据
 */
public class TeamPO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String teamName;
	private int matchNum;
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

	// TODO

	public int getShotRightNumAverage() {
		if (matchNum != 0)
			return shotRightNum / matchNum;
		else
			return 0;
	}

	public int getShotNumAverage() {
		if (matchNum != 0)
			return shotNum / matchNum;
		else
			return 0;
	}

	public int getThreePointShotRightNumAverage() {
		if (matchNum != 0)
			return threePointShotRightNum / matchNum;
		else
			return 0;
	}

	public int getThreePointShotNumAverage() {
		if (matchNum != 0)
			return threePointShotNum / matchNum;
		else
			return 0;
	}

	public int getPenaltyShotRightNumAverage() {
		if (matchNum != 0)
			return penaltyShotRightNum / matchNum;
		else
			return 0;
	}

	public int getPenaltyShotNumAverage() {
		if (matchNum != 0)
			return penaltyShotNum / matchNum;
		else
			return 0;
	}

	public int getOffensiveReboundNumAverage() {
		if (matchNum != 0)
			return offensiveReboundNum / matchNum;
		else
			return 0;
	}

	public int getDefensiveReboundNumAverage() {
		if (matchNum != 0)
			return defensiveReboundNum / matchNum;
		else
			return 0;
	}

	public int getReboundNumAverage() {
		if (matchNum != 0)
			return reboundNum / matchNum;
		else
			return 0;
	}

	public int getAssistNumAverage() {
		if (matchNum != 0)
			return assistNum / matchNum;
		else
			return 0;
	}

	public int getStealNumAverage() {
		if (matchNum != 0)
			return stealNum / matchNum;
		else
			return 0;
	}

	public int getBlockShotNumAverage() {
		if (matchNum != 0)
			return blockShotNum / matchNum;
		else
			return 0;
	}

	public int getFaultyNumAverage() {
		if (matchNum != 0)
			return faultyNum / matchNum;
		else
			return 0;
	}

	public int getFoulNumAverage() {
		if (matchNum != 0)
			return foulNum / matchNum;
		else
			return 0;
	}

	public int getScoreAverage() {
		if (matchNum != 0)
			return score / matchNum;
		else
			return 0;
	}

}
