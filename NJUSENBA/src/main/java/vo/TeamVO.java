package vo;

public class TeamVO {
	String name;// 球队名称
	int matchSum;// 比赛场数
	int hitSum;// 投篮命中数
	int shootSum;// 投篮出手次数
	int threePointHitSum;// 三分命中次数
	int threePointSum;// 三分出手数
	int freeThrowHitSum;// 罚球命中数
	int freeThrowSum;// 罚球出手数
	int offensiveReboundSum;// 进攻篮板数
	int defensiveReboundSum;// 防守篮板数
	int reboundSum;// 篮板数
	int assistingSum;// 助攻数
	int stealSum;// 抢断数
	int blockShotSum;// 盖帽数
	int muffSum;// 失误数
	int foulSum;// 犯规数
	double score;// 比赛得分
	double hitRate;// 投篮命中率
	double threePointHitRate;// 三分命中率
	double freeThrowHitRate;// 罚球命中率
	double winRate;// 胜率
	double offensiveRound;// 进攻回合
	double offensiveEfficiency;// 进攻效率
	double defensiveEfficiency;// 防守效率
	double reboundRate;// 篮板效率
	double stealRate;// 抢断效率
	double assistingRate;// 助攻率

	public TeamVO(String name, int matchSum, int hitSum, int shootSum,
			int threePointHitSum, int threePointSum, int freeThrowHitSum,
			int freeThrowSum, int offensiveReboundSum, int defensiveReboundSum,
			int reboundSum, int assistingSum, int stealSum, int blockShotSum,
			int muffSum, int foulSum, double score, double hitRate,
			double threePointHitRate, double freeThrowHitRate, double winRate,
			double offensiveRound, double offensiveEfficiency,
			double defensiveEfficiency, double reboundRate, double stealRate,
			double assistingRate) {
		this.name = name;
		this.matchSum = matchSum;
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
		this.reboundRate = reboundRate;
		this.stealRate = stealRate;
		this.assistingRate = assistingRate;
	}

	public TeamVO() {
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public int getMatchSum() {
		return matchSum;
	}

	public void setMatchSum(int matchSum) {
		this.matchSum = matchSum;
	}

	public int getHitSum() {
		return hitSum;
	}

	public void setHitSum(int hitSum) {
		this.hitSum = hitSum;
	}

	public int getShootSum() {
		return shootSum;
	}

	public void setShootSum(int shootSum) {
		this.shootSum = shootSum;
	}

	public int getThreePointHitSum() {
		return threePointHitSum;
	}

	public void setThreePointHitSum(int threePointHitSum) {
		this.threePointHitSum = threePointHitSum;
	}

	public int getThreePointSum() {
		return threePointSum;
	}

	public void setThreePointSum(int threePointSum) {
		this.threePointSum = threePointSum;
	}

	public int getFreeThrowHitSum() {
		return freeThrowHitSum;
	}

	public void setFreeThrowHitSum(int freeThrowHitSum) {
		this.freeThrowHitSum = freeThrowHitSum;
	}

	public int getFreeThrowSum() {
		return freeThrowSum;
	}

	public void setFreeThrowSum(int freeThrowSum) {
		this.freeThrowSum = freeThrowSum;
	}

	public int getOffensiveReboundSum() {
		return offensiveReboundSum;
	}

	public void setOffensiveReboundSum(int offensiveReboundSum) {
		this.offensiveReboundSum = offensiveReboundSum;
	}

	public int getDefensiveReboundSum() {
		return defensiveReboundSum;
	}

	public void setDefensiveReboundSum(int defensiveReboundSum) {
		this.defensiveReboundSum = defensiveReboundSum;
	}

	public int getReboundSum() {
		return reboundSum;
	}

	public void setReboundSum(int reboundSum) {
		this.reboundSum = reboundSum;
	}

	public int getAssistingSum() {
		return assistingSum;
	}

	public void setAssistingSum(int assistingSum) {
		this.assistingSum = assistingSum;
	}

	public int getStealSum() {
		return stealSum;
	}

	public void setStealSum(int stealSum) {
		this.stealSum = stealSum;
	}

	public int getBlockShotSum() {
		return blockShotSum;
	}

	public void setBlockShotSum(int blockShotSum) {
		this.blockShotSum = blockShotSum;
	}

	public int getMuffSum() {
		return muffSum;
	}

	public void setMuffSum(int muffSum) {
		this.muffSum = muffSum;
	}

	public int getFoulSum() {
		return foulSum;
	}

	public void setFoulSum(int foulSum) {
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

	public double getReboundRate() {
		return reboundRate;
	}

	public void setReboundRate(double reboundRate) {
		this.reboundRate = reboundRate;
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
