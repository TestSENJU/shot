package VO;

public class teamMatchDataVO {
	double matchSum;// 比赛场数
	double hitSum;// 投篮命中数
	double shootSum;// 投篮出手次数
	double threePointHitSum;// 三分命中次数
	double threePointSum;// 三分出手数
	double freeThrowHitSum;// 罚球命中数
	double freeThrowSum;// 罚球出手数
	double offensiveReboundSum;// 进攻篮板数
	double defensiveReboundSum;// 防守篮板数
	double reboundSum;// 篮板数
	double assistingSum;// 助攻数
	double stealSum;// 抢断数
	double blockShotSum;// 盖帽数
	double muffSum;// 失误数
	double foulSum;// 犯规数
	double score;// 比赛得分
	double hitRate;// 投篮命中率
	double threePointHitRate;// 三分命中率
	double freeThrowHitRate;// 罚球命中率
	double winRate;// 胜率
	double offensiveRound;// 进攻回合
	double offensiveEfficiency;// 进攻效率
	double defensiveEfficiency;// 防守效率
	double offensiveReboundRate;// 进攻篮板效率
	double defensiveReboundRate;// 防守篮板效率
	double stealRate;// 抢断效率
	double assistingRate;// 助攻率

	public teamMatchDataVO(double hitSum, double shootSum,
			double threePointHitSum, double threePointSum, double freeThrowHitSum,
			double freeThrowSum, double offensiveReboundSum, double defensiveReboundSum,
			double reboundSum, double assistingSum, double stealSum, double blockShotSum,
			double muffSum, double foulSum, double score, double hitRate,
			double threePointHitRate, double freeThrowHitRate, double winRate,
			double offensiveRound, double offensiveEfficiency,
			double defensiveEfficiency, double offensiveReboundRate,
			double defensiveReboundRate, double stealRate,
			double assistingRate) {
		this.hitSum = hitSum;
		this.shootSum = shootSum;
		this.threePointHitSum = threePointHitSum;
		this.threePointSum = threePointSum;
		this.freeThrowHitSum = freeThrowHitSum;
		this.freeThrowSum = freeThrowSum;
		this.offensiveReboundSum = offensiveReboundSum;
		this.defensiveReboundSum = defensiveReboundSum;
		this.reboundSum = reboundSum;
		this.assistingSum = assistingSum;
		this.stealSum = stealSum;
		this.blockShotSum = blockShotSum;
		this.muffSum = muffSum;
		this.foulSum = foulSum;
		this.score = score;
		this.hitRate = hitRate;
		this.threePointHitRate = threePointHitRate;
		this.freeThrowHitRate = freeThrowHitRate;
		this.winRate = winRate;
		this.offensiveRound = offensiveRound;
		this.offensiveEfficiency = offensiveEfficiency;
		this.defensiveEfficiency = defensiveEfficiency;
		this.offensiveReboundRate = offensiveReboundRate;
		this.defensiveReboundRate = defensiveReboundRate;
		this.stealRate = stealRate;
		this.assistingRate = assistingRate;
	}

	public teamMatchDataVO(){
	}

	public double getHitSum() {
		return hitSum;
	}

	public void setHitSum(double hitSum) {
		this.hitSum = hitSum;
	}

	public double getShootSum() {
		return shootSum;
	}

	public void setShootSum(double shootSum) {
		this.shootSum = shootSum;
	}

	public double getThreePointHitSum() {
		return threePointHitSum;
	}

	public void setThreePointHitSum(double threePointHitSum) {
		this.threePointHitSum = threePointHitSum;
	}

	public double getThreePointSum() {
		return threePointSum;
	}

	public void setThreePointSum(double threePointSum) {
		this.threePointSum = threePointSum;
	}

	public double getFreeThrowHitSum() {
		return freeThrowHitSum;
	}

	public void setFreeThrowHitSum(double freeThrowHitSum) {
		this.freeThrowHitSum = freeThrowHitSum;
	}

	public double getFreeThrowSum() {
		return freeThrowSum;
	}

	public void setFreeThrowSum(double freeThrowSum) {
		this.freeThrowSum = freeThrowSum;
	}

	public double getOffensiveReboundSum() {
		return offensiveReboundSum;
	}

	public void setOffensiveReboundSum(double offensiveReboundSum) {
		this.offensiveReboundSum = offensiveReboundSum;
	}

	public double getDefensiveReboundSum() {
		return defensiveReboundSum;
	}

	public void setDefensiveReboundSum(double defensiveReboundSum) {
		this.defensiveReboundSum = defensiveReboundSum;
	}

	public double getReboundSum() {
		return reboundSum;
	}

	public void setReboundSum(double reboundSum) {
		this.reboundSum = reboundSum;
	}

	public double getAssistingSum() {
		return assistingSum;
	}

	public void setAssistingSum(double assistingSum) {
		this.assistingSum = assistingSum;
	}

	public double getStealSum() {
		return stealSum;
	}

	public void setStealSum(double stealSum) {
		this.stealSum = stealSum;
	}

	public double getBlockShotSum() {
		return blockShotSum;
	}

	public void setBlockShotSum(double blockShotSum) {
		this.blockShotSum = blockShotSum;
	}

	public double getMuffSum() {
		return muffSum;
	}

	public void setMuffSum(double muffSum) {
		this.muffSum = muffSum;
	}

	public double getFoulSum() {
		return foulSum;
	}

	public void setFoulSum(double foulSum) {
		this.foulSum = foulSum;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getHitRate() {
		return hitRate;
	}

	public void setHitRate(double hitRate) {
		this.hitRate = hitRate;
	}

	public double getThreePointHitRate() {
		return threePointHitRate;
	}

	public void setThreePointHitRate(double threePointHitRate) {
		this.threePointHitRate = threePointHitRate;
	}

	public double getFreeThrowHitRate() {
		return freeThrowHitRate;
	}

	public void setFreeThrowHitRate(double freeThrowHitRate) {
		this.freeThrowHitRate = freeThrowHitRate;
	}

	public double getWinRate() {
		return winRate;
	}

	public void setWinRate(double winRate) {
		this.winRate = winRate;
	}

	public double getOffensiveRound() {
		return offensiveRound;
	}

	public void setOffensiveRound(double offensiveRound) {
		this.offensiveRound = offensiveRound;
	}

	public double getOffensiveEfficiency() {
		return offensiveEfficiency;
	}

	public void setOffensiveEfficiency(double offensiveEfficiency) {
		this.offensiveEfficiency = offensiveEfficiency;
	}

	public double getDefensiveEfficiency() {
		return defensiveEfficiency;
	}

	public void setDefensiveEfficiency(double defensiveEfficiency) {
		this.defensiveEfficiency = defensiveEfficiency;
	}



	public double getOffensiveReboundRate() {
		return offensiveReboundRate;
	}

	public void setOffensiveReboundRate(double offensiveReboundRate) {
		this.offensiveReboundRate = offensiveReboundRate;
	}

	public double getDefensiveReboundRate() {
		return defensiveReboundRate;
	}

	public void setDefensiveReboundRate(double defensiveReboundRate) {
		this.defensiveReboundRate = defensiveReboundRate;
	}

	public double getStealRate() {
		return stealRate;
	}

	public void setStealRate(double stealRate) {
		this.stealRate = stealRate;
	}

	public double getAssistingRate() {
		return assistingRate;
	}

	public void setAssistingRate(double assistingRate) {
		this.assistingRate = assistingRate;
	}
}
