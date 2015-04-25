package po;

public class MatchShortPO {
	String name;
	private String team1;
	private String team2;
	private String pointer;
	private String time;
	public MatchShortPO(String matchName){
		this.name=matchName;
		
	}
	public String getName() {
		return name;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getPointer() {
		return pointer;
	}
	public void setPointer(String pointer) {
		this.pointer = pointer;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
