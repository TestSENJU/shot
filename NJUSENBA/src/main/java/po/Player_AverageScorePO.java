package po;

import java.io.Serializable;

/**
 * 
 * @author wyt
 * 
 * @param timeAver
 *  平均上场时间
 *@param scoresAverage
 *!!以下都是平均值
 *  0投篮命中数
 *  1投篮出手数
 *  2三分命中数
 *  3三分出手数
 *  4罚球命中数
 *  5罚球出手数
 *  6进攻前场篮板数
 *  7进攻后场篮板数
 *  8总篮板数
 *  9助攻数
 *  10盖帽数
 *  11失误数
 *  12犯规数
 *  13个人得分
 */
public class Player_AverageScorePO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//场均数据；
	String playerName;
	private String timeAver;//上场时间
	private double scoresAverage[]=new double[14];
	
	public Player_AverageScorePO(String playerName){
		this.playerName=playerName;
		this.timeAver="0:0";
		for(int i=0;i<scoresAverage.length;i++){
			scoresAverage[i]=0.0;
		}
	}
public void setAllScore(Player_AllScorePO AllScore){
	if(AllScore!=null){
		if(AllScore.getNumOfMatches()!=0){
			this.playerName=AllScore.getPlayerName();
			double scoresAver[]=new double[14];
			double scoresAll[]=AllScore.getScoresAll();
			
			for(int i=0;i<14;i++){
				//数组里取平均
				scoresAver[i]=scoresAll[i]/AllScore.getNumOfMatches();
			}
			this.setScoresAverage(scoresAver);
			//妈妈！这个时间一直好烦啊！！都不想管他了
			String timeAll=AllScore.getTimeAll();
			int matches=AllScore.getNumOfMatches();
			String times[]=timeAll.split(":");
			int hour=(int)Double.parseDouble(times[0])/matches;
			double minutes=Double.parseDouble(times[1])/matches
					+(Double.parseDouble(times[0])/matches-hour)*60;
            this.setTimeAver(hour+""+":"+minutes);
		}
			
		}
	
}
	public String getTimeAver() {
		return timeAver;
	}
	public void setTimeAver(String timeAver) {
		this.timeAver = timeAver;
	}
	public double[] getScoresAverage() {
		return scoresAverage;
	}
	public void setScoresAverage(double[] scoresAverage) {
		this.scoresAverage = scoresAverage;
	}
	
}
