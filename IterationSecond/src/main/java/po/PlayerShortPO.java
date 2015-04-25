package po;

public class PlayerShortPO {
String name;
private String location;
private double num;
private String team;
public PlayerShortPO(String playerName){
	this.name=playerName;
	
}
public String getName() {
	return name;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public double getNum() {
	return num;
}
public void setNum(double num) {
	this.num = num;
}
public String getTeam() {
	return team;
}
public void setTeam(String team) {
	this.team = team;
}

}
