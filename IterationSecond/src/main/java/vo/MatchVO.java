package vo;

import java.util.ArrayList;

import po.MatchPO;

public class MatchVO {
	//比赛名称
String name;
//比赛时间
private String time;
//前一支球队的名字
private String team1;
///后一支球队的
private String team2;
//前一个队伍的数据，就是比赛文件里面那一行一行的
private ArrayList<String[]> list1=new ArrayList<String[]>();
//后一个队伍的数据，就是比赛文件里面那一行一行的
private ArrayList<String[]>list2=new ArrayList<String[]>();
//总得分 比如85-112
private String pointer;
//每一个分场的得分
private ArrayList<String> pointerpart=new ArrayList<String>();
public MatchVO(String filename){
	this.name=filename;	
}

public String getName() {
	return name;
}

public MatchVO(MatchPO po){
	this.name=po.getName();
	this.time=po.getTime();
	this.team1=po.getTeam1();
	this.team2=po.getTeam2();
	this.list1=po.getList1();
	this.list2=po.getList2();
	this.pointer=po.getPointer();
	this.pointerpart=po.getPointerPart();
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
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
public ArrayList<String[]> getList1() {
	return list1;
}
public void setList1(ArrayList<String[]> list1) {
	this.list1 = list1;
}
public ArrayList<String[]> getList2() {
	return list2;
}
public void setList2(ArrayList<String[]> list2) {
	this.list2 = list2;
}
public String getPointer() {
	return pointer;
}
public void setPointer(String pointer) {
	this.pointer = pointer;
}
public ArrayList<String> getPointerpart() {
	return pointerpart;
}
public void setPointerpart(ArrayList<String> pointerpart) {
	this.pointerpart = pointerpart;
}

}
