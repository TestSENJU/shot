package vo;

import po.PlayerShortPO;

public class PlayerShortVO {
String playerName;
private String team;
private String location;
private double num;
public PlayerShortVO(String name){
	this.playerName=name;
}
public PlayerShortVO(PlayerShortPO po){
	this.playerName=po.getName();
	this.team=po.getTeam();
	this.location=po.getTeam();
	this.num=po.getNum();
}
public String getPlayerName() {
	return playerName;
}
public String getTeam() {
	return team;
}
public void setTeam(String team) {
	this.team = team;
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

}
