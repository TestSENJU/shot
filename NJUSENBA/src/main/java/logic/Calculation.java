package logic;

public class Calculation {
	/**球队部分*/
	//计算命中率
	public double hitRate(double shootNum, double hitNum){
		return hitNum/shootNum;
	}
	//计算胜率
	public double winRate(double winSum, double matchSum){
		return winSum/matchSum;
	}
	//计算进攻回合
	public double attackRound(double shootNum, double hitNum, double freeThrow,
			double offensiveRebound, double defensiveRebound, double muffNum){
		return shootNum+0.4*freeThrow-
				1.07*(offensiveRebound/(offensiveRebound+defensiveRebound)*(shootNum-hitNum))
				+1.07*muffNum;
	}
	//计算进攻效率
	public double attackEfficiency(double attackRound, double score){
		return score/attackRound*100;
	}
	//计算防守效率[我方的防守回合当做对方的进攻回合
	public double defensiveEfficiency(double attackRound, double score){
		return score/attackRound*100;
	}
	//计算篮板效率-进攻篮板效率=前场篮板数量/(前场篮板数量+对手后场篮板数量)
	public double attackReboundRate(double offensiveRebound, double defensiveRebound){
		return offensiveRebound/(offensiveRebound+defensiveRebound);
	}
	//计算篮板效率-防守篮板效率=后场篮板的数量/(后场篮板数量+对手前场篮板数量)
	public double defensiveReboundRate(double defensiveRebound, double offensiveRebound){
		return defensiveRebound/(defensiveRebound+offensiveRebound);
	}
	//计算抢断效率[依然是把对方的进攻回合当做我方的防守回合
	public double stealRate(double attackRound, double stealNum){
		return stealNum/attackRound*100;
	}
	//计算助攻率
	public double assistingRate(double attackRound, double assisting){
		return assisting/attackRound*100;
	}
	/**球员部分*/
	//命中率和球队一样
	//计算效率
	public double rate(double score, double rebound, double assisting,
			double steal, double blockShot, double shootNum, double hitNum,
			double freeThrow, double freeThrowHit, double muffNum){
		return (score+rebound+assisting+steal+blockShot)-(shootNum-hitNum)-(freeThrow-freeThrowHit)-muffNum;
	}
	//GmSc效率值
	public double GmScEfficiency(double score, double hitNum, double shootNum,
			double freeThrow, double freeThrowHit, double offensiveRebound, double deffensiveRebound,
			double stealNum, double assisting, double blockShot, double foulNum, double muffNum){
		return score+0.4*hitNum-0.7*shootNum-0.4*(freeThrow-freeThrowHit)+
				0.7*offensiveRebound+0.3*deffensiveRebound+stealNum+0.7*assisting+
				0.7*blockShot-0.4*foulNum-muffNum;
	}
	//真实命中率[真是投篮命中率=得分/(2*(投篮出手数+0.44*罚球出手数))]
	public double trueHitRate(double score, double shootNum, double freeThrow){
		return score/(2*(shootNum+0.44*freeThrow));
	}
	//投篮效率=[(投篮命中数+0.5*三分命中数)/投篮出手数]
	public double shootEfficiency(double hitNum, double threePointerHit, double shootNum){
		return (hitNum+0.5*threePointerHit)/shootNum;
	}
	//篮板率
	//进攻篮板率
	//防守篮板率
	//助攻率
	//抢断率
	//盖帽率
	//失误率
	//使用率
}
