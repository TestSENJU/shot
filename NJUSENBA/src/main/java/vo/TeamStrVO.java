package vo;

public class TeamStrVO {
	String name;// 球队名称
	String matchSum;// 比赛场数
	String hitSum;// 投篮命中数
	String shootSum;// 投篮出手次数
	String threePointHitSum;// 三分命中次数
	String threePointSum;// 三分出手数
	String freeThrowHitSum;// 罚球命中数
	String freeThrowSum;// 罚球出手数
	String offensiveReboundSum;// 进攻篮板数
	String defensiveReboundSum;// 防守篮板数
	String reboundSum;// 篮板数
	String assistingSum;// 助攻数
	String stealSum;// 抢断数
	String blockShotSum;// 盖帽数
	String muffSum;// 失误数
	String foulSum;// 犯规数
	String score;// 比赛得分
	String hitRate;// 投篮命中率
	String threePointHitRate;// 三分命中率
	String freeThrowHitRate;// 罚球命中率
	String winRate;// 胜率
	String offensiveRound;// 进攻回合
	String offensiveEfficiency;// 进攻效率
	String defensiveEfficiency;// 防守效率
	String offensiveReboundRate;// 进攻篮板效率
	String defensiveReboundRate;// 防守篮板效率
	String stealRate;// 抢断效率
	String assistingRate;// 助攻率

	public TeamStrVO(String name, String matchSum, String hitSum, String shootSum,
			String threePointHitSum, String threePointSum, String freeThrowHitSum,
			String freeThrowSum, String offensiveReboundSum, String defensiveReboundSum,
			String reboundSum, String assistingSum, String stealSum, String blockShotSum,
			String muffSum, String foulSum, String score, String hitRate,
			String threePointHitRate, String freeThrowHitRate, String winRate,
			String offensiveRound, String offensiveEfficiency,
			String defensiveEfficiency, String offensiveReboundRate,
			String defensiveReboundRate, String stealRate,
			String assistingRate) {
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
		this.offensiveReboundRate = offensiveReboundRate;
		this.defensiveReboundRate = defensiveReboundRate;
		this.stealRate = stealRate;
		this.assistingRate = assistingRate;
	}

	public TeamStrVO() {
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public String getMatchSum() {
		return matchSum;
	}

	public void setMatchSum(String matchSum) {
		this.matchSum = matchSum;
	}

	public String getHitSum() {
		return hitSum;
	}

	public void setHitSum(String hitSum) {
		this.hitSum = hitSum;
	}

	public String getShootSum() {
		return shootSum;
	}

	public void setShootSum(String shootSum) {
		this.shootSum = shootSum;
	}

	public String getThreePointHitSum() {
		return threePointHitSum;
	}

	public void setThreePointHitSum(String threePointHitSum) {
		this.threePointHitSum = threePointHitSum;
	}

	public String getThreePointSum() {
		return threePointSum;
	}

	public void setThreePointSum(String threePointSum) {
		this.threePointSum = threePointSum;
	}

	public String getFreeThrowHitSum() {
		return freeThrowHitSum;
	}

	public void setFreeThrowHitSum(String freeThrowHitSum) {
		this.freeThrowHitSum = freeThrowHitSum;
	}

	public String getFreeThrowSum() {
		return freeThrowSum;
	}

	public void setFreeThrowSum(String freeThrowSum) {
		this.freeThrowSum = freeThrowSum;
	}

	public String getOffensiveReboundSum() {
		return offensiveReboundSum;
	}

	public void setOffensiveReboundSum(String offensiveReboundSum) {
		this.offensiveReboundSum = offensiveReboundSum;
	}

	public String getDefensiveReboundSum() {
		return defensiveReboundSum;
	}

	public void setDefensiveReboundSum(String defensiveReboundSum) {
		this.defensiveReboundSum = defensiveReboundSum;
	}

	public String getReboundSum() {
		return reboundSum;
	}

	public void setReboundSum(String reboundSum) {
		this.reboundSum = reboundSum;
	}

	public String getAssistingSum() {
		return assistingSum;
	}

	public void setAssistingSum(String assistingSum) {
		this.assistingSum = assistingSum;
	}

	public String getStealSum() {
		return stealSum;
	}

	public void setStealSum(String stealSum) {
		this.stealSum = stealSum;
	}

	public String getBlockShotSum() {
		return blockShotSum;
	}

	public void setBlockShotSum(String blockShotSum) {
		this.blockShotSum = blockShotSum;
	}

	public String getMuffSum() {
		return muffSum;
	}

	public void setMuffSum(String muffSum) {
		this.muffSum = muffSum;
	}

	public String getFoulSum() {
		return foulSum;
	}

	public void setFoulSum(String foulSum) {
		this.foulSum = foulSum;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
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

	public String getWinRate() {
		return winRate;
	}

	public void setWinRate(String winRate) {
		this.winRate = winRate;
	}

	public String getOffensiveRound() {
		return offensiveRound;
	}

	public void setOffensiveRound(String offensiveRound) {
		this.offensiveRound = offensiveRound;
	}

	public String getOffensiveEfficiency() {
		return offensiveEfficiency;
	}

	public void setOffensiveEfficiency(String offensiveEfficiency) {
		this.offensiveEfficiency = offensiveEfficiency;
	}

	public String getDefensiveEfficiency() {
		return defensiveEfficiency;
	}

	public void setDefensiveEfficiency(String defensiveEfficiency) {
		this.defensiveEfficiency = defensiveEfficiency;
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

	public String getStealRate() {
		return stealRate;
	}

	public void setStealRate(String stealRate) {
		this.stealRate = stealRate;
	}

	public String getAssistingRate() {
		return assistingRate;
	}

	public void setAssistingRate(String assistingRate) {
		this.assistingRate = assistingRate;
	}

}
