package vo;

public class PlayerVO {
	String name; // 球员名称
	String teams;// 所属球队
	int competeNum;// 参赛场数
	int offensiveNum;// 先发场数
	int reboundNum;// 篮板数
	int assistingNum;// 助攻数
	String playingTime;// 在场时间
	double hitRate;// 投篮命中率
	double threePointHitRate;// 三分命中率
	double freeThrowHitRate;// 罚球命中率
	int offensiveReboundNum;// 进攻篮板数
	int defensiveReboundNum;// 防守篮板数
	int stealNum;// 抢断数
	int blockShotNum;// 盖帽数
	int muffNum;// 失误数
	int foulNum;// 犯规数
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

	public PlayerVO(String name, String teams, int competeNum,
			int offensiveNum, int reboundNum, int assistingNum,
			String playingTime, double hitRate, double threePointHitRate,
			double freeThrowHitRate, int offensiveReboundNum,
			int defensiveReboundNum, int stealNum, int blockShotNum,
			int muffNum, int foulNum, double score, double efficiency,
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

	public PlayerVO() {
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

	public int getCompeteNum() {
		return competeNum;
	}

	public void setCompeteNum(int competeNum) {
		this.competeNum = competeNum;
	}

	public int getOffensiveNum() {
		return offensiveNum;
	}

	public void setOffensiveNum(int offensiveNum) {
		this.offensiveNum = offensiveNum;
	}

	public int getReboundNum() {
		return reboundNum;
	}

	public void setReboundNum(int reboundNum) {
		this.reboundNum = reboundNum;
	}

	public int getAssistingNum() {
		return assistingNum;
	}

	public void setAssistingNum(int assistingNum) {
		this.assistingNum = assistingNum;
	}

	public String getPlayingTime() {
		return playingTime;
	}

	public void setPlayingTime(String playingTime) {
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

	public int getOffensiveReboundNum() {
		return offensiveReboundNum;
	}

	public void setOffensiveReboundNum(int offensiveReboundNum) {
		this.offensiveReboundNum = offensiveReboundNum;
	}

	public int getDefensiveReboundNum() {
		return defensiveReboundNum;
	}

	public void setDefensiveReboundNum(int defensiveReboundNum) {
		this.defensiveReboundNum = defensiveReboundNum;
	}

	public int getStealNum() {
		return stealNum;
	}

	public void setStealNum(int stealNum) {
		this.stealNum = stealNum;
	}

	public int getBlockShotNum() {
		return blockShotNum;
	}

	public void setBlockShotNum(int blockShotNum) {
		this.blockShotNum = blockShotNum;
	}

	public int getMuffNum() {
		return muffNum;
	}

	public void setMuffNum(int muffNum) {
		this.muffNum = muffNum;
	}

	public int getFoulNum() {
		return foulNum;
	}

	public void setFoulNum(int foulNum) {
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
