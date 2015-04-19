package po;

import java.util.ArrayList;
/**
 * 
 * @author wyt
 * @param time
 * 比赛时间
 * @param team1
 * 一个队伍名字缩写
 * @param team2
 * 另一个队伍名字缩写
 * @param list1
 * 第一个队伍的各个球员的信息
 * @param list2
 * 第二个队伍的各个球员的信息
 * @param pointer
 * 总得分
 * @param pointerPart
 * 每一场的得分
 *
 */
public class MatchPO {
String name;
private String time;
private String team1;
private String team2;
private ArrayList<String[]> list1=new ArrayList<String[]>();
private ArrayList<String[]> list2=new ArrayList<String[]>();
private String pointer;
private ArrayList<String> pointerPart=new ArrayList<String>();
public MatchPO(String matchName){
	this.name=matchName;
	this.team1="0";
	this.team2="0";
	this.pointer="0";
	setBasicInfo();
}
private void setBasicInfo(){
	if(this.name!=null){
		String strs[]=this.name.split("_");
		this.time=strs[0]+"_"+strs[1];
		String ss[]=strs[2].split("-");
		this.team1=ss[0];
		this.team2=ss[1];
	}
}

public void setTime(String time) {
	this.time = time;
}
public void setPointerPart(ArrayList<String> pointerPart) {
	this.pointerPart = pointerPart;
}
public void setList1(ArrayList<String[]> list1) {
	this.list1 = list1;
}
public void setList2(ArrayList<String[]> list2) {
	this.list2 = list2;
}
public void setPointer(String str){
	this.pointer=str;
}
public void addPointerPart(String str){
	this.pointerPart.add(str);
}
public String getTime() {
	return time;
}
public String getTeam1() {
	return team1;
}
public String getTeam2() {
	return team2;
}
public ArrayList<String[]> getList1() {
	return list1;
}
public ArrayList<String[]> getList2() {
	return list2;
}
public String getPointer() {
	return pointer;
}
public ArrayList<String> getPointerPart() {
	return pointerPart;
}

}
