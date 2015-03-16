package po;

public class Player_AverageScorePO {
	//场均数据；
	private String timeAver;//上场时间
	private double scoresAverage[]=new double[14];

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
