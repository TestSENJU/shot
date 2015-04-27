package vo;

import po.MatchShortPO;

public class MatchShortVO {
String name;
private String winTeam;
private String lostTeam;
private String winPointer;
private String lostPointer;
private String time;
public MatchShortVO(String matchName){
	this.name=matchName;
	
}
public MatchShortVO(MatchShortPO po){
	this.name=po.getName();
	this.time=po.getTime();
	String strs[]=po.getPointer().split("-");
	if(Integer.parseInt(strs[0])<Integer.parseInt(strs[1])){
		this.winTeam=po.getTeam2();
		this.lostTeam=po.getTeam1();
		this.winPointer=strs[1];
		this.lostPointer=strs[0];
		
	}else{
		this.winTeam=po.getTeam1();
		this.lostTeam=po.getTeam2();
		this.winPointer=strs[0];
		this.lostPointer=strs[1];
	}
}

public String getName() {
	return name;
}
public String getWinTeam() {
	return winTeam;
}
public void setWinTeam(String winTeam) {
	this.winTeam = winTeam;
}
public String getLostTeam() {
	return lostTeam;
}
public void setLostTeam(String lostTeam) {
	this.lostTeam = lostTeam;
}
public String getWinPointer() {
	return winPointer;
}
public void setWinPointer(String winPointer) {
	this.winPointer = winPointer;
}
public String getLostPointer() {
	return lostPointer;
}
public void setLostPointer(String lostPointer) {
	this.lostPointer = lostPointer;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}

}
