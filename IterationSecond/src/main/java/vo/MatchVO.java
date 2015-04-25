package vo;

import java.util.ArrayList;

import po.MatchPO;

public class MatchVO {
	//比赛名称
String name;
//比赛时间
private String time;
//前一支球队的名字
private String winTeam;
///后一支球队的
private String lostTeam;
//前一个队伍的数据，就是比赛文件里面那一行一行的
private ArrayList<String[]> winList=new ArrayList<String[]>();
//后一个队伍的数据，就是比赛文件里面那一行一行的
private ArrayList<String[]>lostList=new ArrayList<String[]>();
//总得分 比如85-112
private String winPointer;
private String lostPointer;
//每一个分场的得分
private ArrayList<String> pointerpart1=new ArrayList<String>();
private ArrayList<String>pointerpart2=new ArrayList<String>();

public MatchVO(String filename){
	this.name=filename;	
}
public MatchVO(MatchPO po){
	this.name=po.getName();
	this.time=po.getTime();
	String strs[]=po.getPointer().split("-");
	ArrayList<String>list=po.getPointerPart();

	if(Integer.parseInt(strs[0])<Integer.parseInt(strs[1])){
		this.winTeam=po.getTeam2();
		this.lostTeam=po.getTeam1();
		this.winList=po.getList2();
		this.lostList=po.getList1();
		this.winPointer=strs[1];
		this.lostPointer=strs[0];
		for(int i=0;i<list.size();i++){
			String ss[]=list.get(i).split("-");
			this.pointerpart1.add(ss[1]);
			this.pointerpart2.add(ss[0]);
		}
	}else{
		this.winTeam=po.getTeam1();
		this.lostTeam=po.getTeam2();
		this.winList=po.getList1();
		this.lostList=po.getList2();
		this.winPointer=strs[0];
		this.lostPointer=strs[1];
		for(int i=0;i<list.size();i++){
			String ss[]=list.get(i).split("-");
			this.pointerpart1.add(ss[0]);
			this.pointerpart2.add(ss[1]);
		}
	}
}
public String getName() {
	return name;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
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
public ArrayList<String[]> getWinList() {
	return winList;
}
public void setWinList(ArrayList<String[]> winList) {
	this.winList = winList;
}
public ArrayList<String[]> getLostList() {
	return lostList;
}
public void setLostList(ArrayList<String[]> lostList) {
	this.lostList = lostList;
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
public ArrayList<String> getPointerpart1() {
	return pointerpart1;
}
public void setPointerpart1(ArrayList<String> pointerpart1) {
	this.pointerpart1 = pointerpart1;
}
public ArrayList<String> getPointerpart2() {
	return pointerpart2;
}
public void setPointerpart2(ArrayList<String> pointerpart2) {
	this.pointerpart2 = pointerpart2;
}

}
