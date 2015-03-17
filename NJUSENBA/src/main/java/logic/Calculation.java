package logic;

public class Calculation {
	/**球队部分*/
	//1.计算命中率
	public double hitRate(double shootNum, double hitNum){
		return hitNum/shootNum;
	}
	//1.计算胜率
	public double winRate(double winSum, double matchSum){
		return winSum/matchSum;
	}
	//2.计算进攻回合
	public double attackRound(double shootNum, double hitNum, double freeThrow,
			double offensiveRebound, double defensiveRebound, double muffNum){
		return shootNum+0.4*freeThrow-
				1.07*(offensiveRebound/(offensiveRebound+defensiveRebound)*(shootNum-hitNum))
				+1.07*muffNum;
	}
	//3.计算进攻效率
	public double attackEfficiency(double attackRound, double score){
		return score/attackRound*100;
	}
	//4.计算防守效率[我方的防守回合当做对方的进攻回合
	public double defensiveEfficiency(double attackRound, double score){
		return score/attackRound*100;
	}
	//5.计算篮板效率-进攻篮板效率=前场篮板数量/(前场篮板数量+对手后场篮板数量)
	public double attackReboundRate(double offensiveRebound, double defensiveRebound){
		return offensiveRebound/(offensiveRebound+defensiveRebound);
	}
	//6.计算篮板效率-防守篮板效率=后场篮板的数量/(后场篮板数量+对手前场篮板数量)
	public double defensiveReboundRate(double defensiveRebound, double offensiveRebound){
		return defensiveRebound/(defensiveRebound+offensiveRebound);
	}
	//7.计算抢断效率[依然是把对方的进攻回合当做我方的防守回合
	public double stealRate(double attackRound, double stealNum){
		return stealNum/attackRound*100;
	}
	//8.计算助攻率
	public double assistingRate(double attackRound, double assisting){
		return assisting/attackRound*100;
	}
	/**球员部分*/
	//命中率和球队一样
	//5.计算效率
	public double rate(double score, double rebound, double assisting,
			double steal, double blockShot, double shootNum, double hitNum,
			double freeThrow, double freeThrowHit, double muffNum){
		return (score+rebound+assisting+steal+blockShot)-(shootNum-hitNum)-(freeThrow-freeThrowHit)-muffNum;
	}
	//7.GmSc效率值
	public double GmScEfficiency(double score, double hitNum, double shootNum,
			double freeThrow, double freeThrowHit, double offensiveRebound, double deffensiveRebound,
			double stealNum, double assisting, double blockShot, double foulNum, double muffNum){
		return score+0.4*hitNum-0.7*shootNum-0.4*(freeThrow-freeThrowHit)+
				0.7*offensiveRebound+0.3*deffensiveRebound+stealNum+0.7*assisting+
				0.7*blockShot-0.4*foulNum-muffNum;
	}
	//8.真实命中率[真是投篮命中率=得分/(2*(投篮出手数+0.44*罚球出手数))]
	public double trueHitRate(double score, double shootNum, double freeThrow){
		return score/(2*(shootNum+0.44*freeThrow));
	}
	//9.投篮效率=[(投篮命中数+0.5*三分命中数)/投篮出手数]
	public double shootEfficiency(double hitNum, double threePointerHit, double shootNum){
		return (hitNum+0.5*threePointerHit)/shootNum;
	}
	//10.篮板率[球员篮板数*(球队所有球员上场时间/5)/球员上场时间/(球队总篮板+对手总篮板)]
	public double reboundRate(double reboundSingleSum, double playingTimeTeamSum,
			double playingTimeSingleSum, double reboundTeamSum,
			double reboundOpponentTeamSum){
		return reboundSingleSum*(playingTimeTeamSum/5)/playingTimeSingleSum/(reboundTeamSum+reboundOpponentTeamSum);
	}
	//11.进攻篮板率
	public double offensiveReboundRate(double offensiveReboundSingle, double playingTimeTeamSum,
			double playingTimeSingleSum, double offensiveReboundTeam,
			double offensiveReboundOpponentTeam){		
		return offensiveReboundSingle*(playingTimeTeamSum/5)/playingTimeSingleSum/(offensiveReboundTeam+offensiveReboundOpponentTeam);
	}
	//12.防守篮板率
	public double defensiveReboundRate(double defensiveReboundSingle, double playingTimeTeamSum,
			double playingTimeSingleSum, double defensiveReboundTeam,
			double defensiveReboundOpponentTeam){		
		return defensiveReboundSingle*(playingTimeTeamSum/5)/playingTimeSingleSum/(defensiveReboundTeam+defensiveReboundOpponentTeam);
	}
	//13.助攻率
	public double assistingRate(double assistSingle, double playingTimeSingle,
			double playingTimeTeam, double hitTeam, double hitSingle){
		return assistSingle/(playingTimeSingle/(playingTimeTeam/5)*hitTeam-hitSingle);
	}
	
	//14.抢断率-对手进攻次数指的是进攻回合
	public double stealRate(double stealSingle, double playingTimeTeam,
			double playingTimeSingle, double opponentAttackRound){
		return stealSingle*(playingTimeTeam/5)/playingTimeSingle/opponentAttackRound;
	}

	//15.盖帽率-投篮出手数包括三分出手数，投篮命中数包括三分命中数
	//
	public double blockShotRate(double blockShotSingle, double playingTimeTeam,
			double playingTimeSingle, double shootOpponentNum, double threePointOpponent){
		return blockShotSingle*(playingTimeTeam/5)/playingTimeSingle/(shootOpponentNum-threePointOpponent);
	}
	//16.失误率
	public double muffRate(double muffSingle, double shootSingle, 
			double threePointSingle, double freeThrowSingle){
		return muffSingle/((shootSingle-threePointSingle)+
				0.44*freeThrowSingle+muffSingle);
	}
	//17.使用率
	public double usage(double shootSingle, double freeThrowSingle, double muffSingle,
			double playingTimeTeam, double playingTimeSingle, double shootTeam,
			double freeThrowTeam, double muffTeam){
		return (shootSingle+0.44*freeThrowSingle+muffSingle)*(playingTimeTeam/5)
				/playingTimeSingle/(shootTeam+0.44*freeThrowTeam+muffTeam);
	}
}
