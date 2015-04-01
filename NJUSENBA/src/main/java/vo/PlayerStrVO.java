package vo;

public class PlayerStrVO {
	String name; // 球员名称
	String teams;// 所属球队
	String competeNum;// 参赛场数
	String offensiveNum;// 先发场数
	String reboundNum;// 篮板数
	String assistingNum;// 助攻数
	String playingTime;// 在场时间
	String hitRate;// 投篮命中率
	String threePointHitRate;// 三分命中率
	String freeThrowHitRate;// 罚球命中率
	String offensiveReboundNum;// 进攻篮板数
	String defensiveReboundNum;// 防守篮板数
	String stealNum;// 抢断数
	String blockShotNum;// 盖帽数
	String muffNum;// 失误数
	String foulNum;// 犯规数
	String score;// 得分
	String efficiency;// 效率
	String GmScEfficiency;// GmSc效率值
	String trueHitRate;// 真实命中率
	String shootEfficiency;// 投篮效率
	String reboundRate;// 篮板率
	String offensiveReboundRate;// 进攻篮板率
	String defensiveReboundRate;// 防守篮板率
	String assistingRate;// 助攻率
	String stealRate;// 抢断率
	String blockShotRate;// 盖帽率
	String muffRate;// 失误率
	String usage;// 使用率

	public PlayerStrVO(String name, String teams, String competeNum,
			String offensiveNum, String reboundNum, String assistingNum,
			String playingTime, String hitRate, String threePointHitRate,
			String freeThrowHitRate, String offensiveReboundNum,
			String defensiveReboundNum, String stealNum, String blockShotNum,
			String muffNum, String foulNum, String score, String efficiency,
			String GmScEfficiency, String trueHitRate, String shootEfficiency,
			String reboundRate, String offensiveReboundRate,
			String defensiveReboundRate, String assistingRate,
			String stealRate, String blockShotRate, String muffRate,
			String usage) {
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

	public PlayerStrVO() {
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

	public String getCompeteNum() {
		return competeNum;
	}

	public void setCompeteNum(String competeNum) {
		this.competeNum = competeNum;
	}

	public String getOffensiveNum() {
		return offensiveNum;
	}

	public void setOffensiveNum(String offensiveNum) {
		this.offensiveNum = offensiveNum;
	}

	public String getReboundNum() {
		return reboundNum;
	}

	public void setReboundNum(String reboundNum) {
		this.reboundNum = reboundNum;
	}

	public String getAssistingNum() {
		return assistingNum;
	}

	public void setAssistingNum(String assistingNum) {
		this.assistingNum = assistingNum;
	}

	public String getPlayingTime() {
		return playingTime;
	}

	public void setPlayingTime(String playingTime) {
		this.playingTime = playingTime;
	}

	public String getHitRate() {
		return hitRate;
	}

	public void setHitRate(String hitRate) {
		this.hitRate = hitRate;
	}

	public String getThreePointHitRate() {
		return threePointHitRate;
	}

	public void setThreePointHitRate(String threePointHitRate) {
		this.threePointHitRate = threePointHitRate;
	}

	public String getFreeThrowHitRate() {
		return freeThrowHitRate;
	}

	public void setFreeThrowHitRate(String freeThrowHitRate) {
		this.freeThrowHitRate = freeThrowHitRate;
	}

	public String getOffensiveReboundNum() {
		return offensiveReboundNum;
	}

	public void setOffensiveReboundNum(String offensiveReboundNum) {
		this.offensiveReboundNum = offensiveReboundNum;
	}

	public String getDefensiveReboundNum() {
		return defensiveReboundNum;
	}

	public void setDefensiveReboundNum(String defensiveReboundNum) {
		this.defensiveReboundNum = defensiveReboundNum;
	}

	public String getStealNum() {
		return stealNum;
	}

	public void setStealNum(String stealNum) {
		this.stealNum = stealNum;
	}

	public String getBlockShotNum() {
		return blockShotNum;
	}

	public void setBlockShotNum(String blockShotNum) {
		this.blockShotNum = blockShotNum;
	}

	public String getMuffNum() {
		return muffNum;
	}

	public void setMuffNum(String muffNum) {
		this.muffNum = muffNum;
	}

	public String getFoulNum() {
		return foulNum;
	}

	public void setFoulNum(String foulNum) {
		this.foulNum = foulNum;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(String efficiency) {
		this.efficiency = efficiency;
	}

	public String getGmScEfficiency() {
		return GmScEfficiency;
	}

	public void setGmScEfficiency(String gmScEfficiency) {
		GmScEfficiency = gmScEfficiency;
	}

	public String getTrueHitRate() {
		return trueHitRate;
	}

	public void setTrueHitRate(String trueHitRate) {
		this.trueHitRate = trueHitRate;
	}

	public String getShootEfficiency() {
		return shootEfficiency;
	}

	public void setShootEfficiency(String shootEfficiency) {
		this.shootEfficiency = shootEfficiency;
	}

	public String getReboundRate() {
		return reboundRate;
	}

	public void setReboundRate(String reboundRate) {
		this.reboundRate = reboundRate;
	}

	public String getOffensiveReboundRate() {
		return offensiveReboundRate;
	}

	public void setOffensiveReboundRate(String offensiveReboundRate) {
		this.offensiveReboundRate = offensiveReboundRate;
	}

	public String getDefensiveReboundRate() {
		return defensiveReboundRate;
	}

	public void setDefensiveReboundRate(String defensiveReboundRate) {
		this.defensiveReboundRate = defensiveReboundRate;
	}

	public String getAssistingRate() {
		return assistingRate;
	}

	public void setAssistingRate(String assistingRate) {
		this.assistingRate = assistingRate;
	}

	public String getStealRate() {
		return stealRate;
	}

	public void setStealRate(String stealRate) {
		this.stealRate = stealRate;
	}

	public String getBlockShotRate() {
		return blockShotRate;
	}

	public void setBlockShotRate(String blockShotRate) {
		this.blockShotRate = blockShotRate;
	}

	public String getMuffRate() {
		return muffRate;
	}

	public void setMuffRate(String muffRate) {
		this.muffRate = muffRate;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	
}
