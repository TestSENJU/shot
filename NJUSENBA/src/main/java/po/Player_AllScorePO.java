package po;

public class Player_AllScorePO {


//总数据
	private String timeAll;//上场时间
	private int numOfFirstMatches;//先发场数
	private int numOfMatches;//参赛场数
	private double scoresAll[]=new double[14];
	
	public Player_AllScorePO(){
		timeAll="0:0";
		numOfFirstMatches=0;
		 numOfMatches=0;
		for(int i=0;i<scoresAll.length;i++){
			scoresAll[i]=0;
		}
	}
	public void addFirstMatch(){
		this.numOfFirstMatches++;
	}
	public void addnumOfMatches(int num){
		this.numOfMatches+=num;
	}
	public void addnumOfFirstMatches(int num){
		this.numOfFirstMatches+=num;
	}
	public int getNumOfFirstMatches() {
		return numOfFirstMatches;
	}

	public void setNumOfFirstMatches(int numOfFirstMatches) {
		this.numOfFirstMatches = numOfFirstMatches;
	}

	public int getNumOfMatches() {
		return numOfMatches;
	}

	public void setNumOfMatches(int numOfMatches) {
		this.numOfMatches = numOfMatches;
	}
	public String getTimeAll() {
		return timeAll;
	}
	public void setTimeAll(String timeAll) {
		this.timeAll = timeAll;
	}
	//TODO
	public void addTimeAll(String timeAllAdd){
		String strs[]=timeAllAdd.split(":");
		String ss[]=this.timeAll.split(":");
		int seconds=Integer.parseInt(ss[1])+Integer.parseInt(strs[1]);
		if(seconds<60){
			this.timeAll=(Integer.parseInt(ss[0])+Integer.parseInt(strs[0])+"")
					+":"	+(seconds+"");	
		}else{
			this.timeAll=(Integer.parseInt(ss[0])+Integer.parseInt(strs[0])+1+"")
					+":"	+(seconds-60+"");	
		}
		
	}
	public void addAllScore(String strs[]){
		for(int i=0;i<scoresAll.length;i++){
			scoresAll[i]+=Integer.parseInt(strs[i]);
		}
	}

	public double[] getScoresAll() {
		return scoresAll;
	}
	public void setScoresAll(double[] scoresAll) {
		this.scoresAll = scoresAll;
	}
}
