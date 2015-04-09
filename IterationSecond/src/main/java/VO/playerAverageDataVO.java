package VO;

public class playerAverageDataVO {
	String name; // 球员名称
	String teams;// 所属球队
	double competeNum;// 参赛场数
	double offensiveNum;// 先发场数
	double reboundNum;// 篮板数
	double assistingNum;// 助攻数
	double playingTime;// 在场时间
	double hitRate;// 投篮命中率
	double threePointHitRate;// 三分命中率
	double freeThrowHitRate;// 罚球命中率
	double offensiveReboundNum;// 进攻篮板数
	double defensiveReboundNum;// 防守篮板数
	double stealNum;// 抢断数
	double blockShotNum;// 盖帽数
	double muffNum;// 失误数
	double foulNum;// 犯规数
	double score;// 得分
	double efficiency;// 效率
	double GmScEfficiency;// GmSc效率值
	double trueHitRate;// 真实命中率
	double shootEfficiency;// 投篮效率
	double reboundRate;// 篮板率
	double offensiveReboundRate;// 进攻篮板率
	double defensiveReboundRate;// 防守篮板率
	double assistingRate;// 助攻率
	double stealRate;// 抢断率
	double blockShotRate;// 盖帽率
	double muffRate;// 失误率
	double usage;// 使用率

	public playerAverageDataVO(String name, String teams, double competeNum,
			double offensiveNum, double reboundNum, double assistingNum,
			double playingTime, double hitRate, double threePointHitRate,
			double freeThrowHitRate, double offensiveReboundNum,
			double defensiveReboundNum, double stealNum, double blockShotNum,
			double muffNum, double foulNum, double score, double efficiency,
			double GmScEfficiency, double trueHitRate, double shootEfficiency,
			double reboundRate, double offensiveReboundRate,
			double defensiveReboundRate, double assistingRate,
			double stealRate, double blockShotRate, double muffRate,
			double usage) {
		this.name = name;
		this.teams = teams;
		this.competeNum = competeNum;
		this.offensiveNum = offensiveNum;
		this.reboundNum = reboundNum;
		this.assistingNum = assistingNum;
		this.playingTime = playingTime;
		this.hitRate = hitRate;
		this.threePointHitRate = threePointHitRate;
		this.freeThrowHitRate = freeThrowHitRate;
		this.offensiveReboundNum = offensiveReboundNum;
		this.defensiveReboundNum = defensiveReboundNum;
		this.stealNum = stealNum;
		this.blockShotNum = blockShotNum;
		this.muffNum = muffNum;
		this.foulNum = foulNum;
		this.score = score;
		this.efficiency = efficiency;
		this.GmScEfficiency = GmScEfficiency;
		this.trueHitRate = trueHitRate;
		this.shootEfficiency = shootEfficiency;
		this.reboundRate = reboundRate;
		this.offensiveReboundRate = offensiveReboundRate;
		this.defensiveReboundRate = defensiveReboundRate;
		this.assistingRate = assistingRate;
		this.stealRate = stealRate;
		this.blockShotRate = blockShotRate;
		this.muffRate = muffRate;
		this.usage = usage;
	}

	public playerAverageDataVO() {
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTeams() {
		return teams;
	}

	public void setTeams(String teams) {
		this.teams = teams;
	}


	public double getCompeteNum() {
		return competeNum;
	}

	public void setCompeteNum(double competeNum) {
		this.competeNum = competeNum;
	}

	public double getOffensiveNum() {
		return offensiveNum;
	}

	public void setOffensiveNum(double offensiveNum) {
		this.offensiveNum = offensiveNum;
	}

	public double getReboundNum() {
		return reboundNum;
	}

	public void setReboundNum(double reboundNum) {
		this.reboundNum = reboundNum;
	}

	public double getAssistingNum() {
		return assistingNum;
	}

	public void setAssistingNum(double assistingNum) {
		this.assistingNum = assistingNum;
	}

	public double getPlayingTime() {
		return playingTime;
	}

	public void setPlayingTime(double playingTime) {
		this.playingTime = playingTime;
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

	public double getOffensiveReboundNum() {
		return offensiveReboundNum;
	}

	public void setOffensiveReboundNum(double offensiveReboundNum) {
		this.offensiveReboundNum = offensiveReboundNum;
	}

	public double getDefensiveReboundNum() {
		return defensiveReboundNum;
	}

	public void setDefensiveReboundNum(double defensiveReboundNum) {
		this.defensiveReboundNum = defensiveReboundNum;
	}

	public double getStealNum() {
		return stealNum;
	}

	public void setStealNum(double stealNum) {
		this.stealNum = stealNum;
	}

	public double getBlockShotNum() {
		return blockShotNum;
	}

	public void setBlockShotNum(double blockShotNum) {
		this.blockShotNum = blockShotNum;
	}

	public double getMuffNum() {
		return muffNum;
	}

	public void setMuffNum(double muffNum) {
		this.muffNum = muffNum;
	}

	public double getFoulNum() {
		return foulNum;
	}

	public void setFoulNum(double foulNum) {
		this.foulNum = foulNum;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
	}

	public double getGmScEfficiency() {
		return GmScEfficiency;
	}

	public void setGmScEfficiency(double gmScEfficiency) {
		GmScEfficiency = gmScEfficiency;
	}

	public double getTrueHitRate() {
		return trueHitRate;
	}

	public void setTrueHitRate(double trueHitRate) {
		this.trueHitRate = trueHitRate;
	}

	public double getShootEfficiency() {
		return shootEfficiency;
	}

	public void setShootEfficiency(double shootEfficiency) {
		this.shootEfficiency = shootEfficiency;
	}

	public double getReboundRate() {
		return reboundRate;
	}

	public void setReboundRate(double reboundRate) {
		this.reboundRate = reboundRate;
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

	public double getAssistingRate() {
		return assistingRate;
	}

	public void setAssistingRate(double assistingRate) {
		this.assistingRate = assistingRate;
	}

	public double getStealRate() {
		return stealRate;
	}

	public void setStealRate(double stealRate) {
		this.stealRate = stealRate;
	}

	public double getBlockShotRate() {
		return blockShotRate;
	}

	public void setBlockShotRate(double blockShotRate) {
		this.blockShotRate = blockShotRate;
	}

	public double getMuffRate() {
		return muffRate;
	}

	public void setMuffRate(double muffRate) {
		this.muffRate = muffRate;
	}

	public double getUsage() {
		return usage;
	}

	public void setUsage(double usage) {
		this.usage = usage;
	}
}
