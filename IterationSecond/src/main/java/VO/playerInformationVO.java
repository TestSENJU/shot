package VO;

public class playerInformationVO {
    String playerName;//姓名
    String playerNumber;//球衣号码
    String playerPosition;//位置
    String playerHeight;//身高
    String playerWeight;//体重
    String playerBirth;//生日
    String playerAge;//年龄
    String playerExp;//球龄
    String playerSchool;//毕业院校
    String teams;// 所属球队
	int competeNum;// 参赛场数
	int offensiveNum;// 先发场数
    double reboundNum;// 篮板数
	double assistingNum;// 助攻数
	String playingTime;// 在场时间
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
    public playerInformationVO(String playerName,String playerNumber,String playerPosition,String playerHeight,String playerWeight,String 
    		playerBirth,String playerAge,String playerExp,String playerSchool,String teams, int competeNum,
			int offensiveNum,double reboundNum, double assistingNum,
			String playingTime, double hitRate, double threePointHitRate,
			double freeThrowHitRate, double offensiveReboundNum,
			double defensiveReboundNum, double stealNum, double blockShotNum,
			double muffNum, double foulNum, double score, double efficiency,
			double GmScEfficiency, double trueHitRate, double shootEfficiency,
			double reboundRate, double offensiveReboundRate,
			double defensiveReboundRate, double assistingRate,
			double stealRate, double blockShotRate, double muffRate,
			double usage){
    	
    	this.playerName=playerName;
    	this.playerNumber=playerNumber;
    	this.playerPosition=playerPosition;
    	this.playerHeight=playerHeight;
    	this.playerWeight=playerWeight;
    	this.playerBirth=playerBirth;
    	this.playerAge=playerAge;
    	this.playerExp=playerExp;
    	this.playerSchool=playerSchool;
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
    public playerInformationVO(){
    	
    }
    public String getPlayerName(){
    	return playerName;
    }
    public void setPlayerName(String playerName){
    	this.playerName=playerName;
    }
    public String getPlayerNumber(){
    	return playerNumber;
    }
    public void setPlayerNumber(String playerNumber){
    	this.playerNumber=playerNumber;
    }
    public String getPlayerPosition(){
    	return playerPosition;
    }
    public void setPlayerPosition(String playerPosition){
    	this.playerPosition=playerPosition;
    }
    public String getPlayerHeight(){
    	return playerHeight;
    }
    public void setPlayerHeight(String playerHeight){
    	this.playerHeight=playerHeight;
    }
    public String getPlayerWeight(){
    	return playerWeight;
    }
    public void setPlayerWeight(String playerWeight){
    	this.playerWeight=playerWeight;
    }
    public String getPlayerBirth(){
    	return playerBirth;
    }
    public void setPlayerBirth(String playerBirth){
    	this.playerBirth=playerBirth;
    }
    public String getPlayerAge(){
    	return playerAge;
    }
    public void setPlayerAge(String playerAge){
    	this.playerAge=playerAge;
    }
    public String getPlayerExp(){
    	return playerExp;
    }
    public void setPlayerExp(String playerExp){
    	this.playerExp=playerExp;
    }
    public String getPlayerSchool(){
    	return playerSchool;
    }
    public void setPlayerSchool(String playerSchool){
    	this.playerSchool=playerSchool;
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
