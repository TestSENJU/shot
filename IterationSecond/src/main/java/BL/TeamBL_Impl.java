package BL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Data.TeamDataService;
import Data.TeamData_Impl;
import po.TeamAllPlusRatePO;
import po.TeamAveragePlusRatePO;
import po.TeamBasicPO;
import vo.TeamAllVO;
import vo.TeamAverageVO;
import vo.TeamBasicVO;

public class TeamBL_Impl implements TeamBL{
    TeamDataService teamData=new TeamData_Impl();
	public ArrayList<TeamAllVO> getTeamAll() {
		// TODO Auto-generated method stub
		ArrayList<TeamAllPlusRatePO> list=new ArrayList<TeamAllPlusRatePO>();
		list=teamData.getTeamAll();
		ArrayList<TeamAllVO> volist=new ArrayList<TeamAllVO>();
		for(int i=0;i<list.size();i++){
			volist.add(new TeamAllVO(list.get(i)));
		}
		return volist;
	}

	public ArrayList<TeamAverageVO> getTeamAverage() {
		// TODO Auto-generated method stub
		ArrayList<TeamAveragePlusRatePO> list=new ArrayList<TeamAveragePlusRatePO>();
		list=teamData.getTeamAverage();
		ArrayList<TeamAverageVO> volist=new ArrayList<TeamAverageVO>();
		for(int i=0;i<list.size();i++){
			volist.add(new TeamAverageVO(list.get(i)));
		}
		return volist;
	}

	public ArrayList<TeamBasicVO>getTeamBasic() {
		// TODO Auto-generated method stub
		ArrayList<TeamBasicPO> list=new ArrayList<TeamBasicPO>();
		list=teamData.getTeamBasic();
		ArrayList<TeamBasicVO> volist=new ArrayList<TeamBasicVO>();
		for(int i=0;i<list.size();i++){
			volist.add(new TeamBasicVO(list.get(i)));
		}
		return volist;
	}

	@SuppressWarnings("unused")
	public TeamBasicVO getTeamBasicByName(String name) {
		// TODO Auto-generated method stub
		TeamBasicVO vo=new TeamBasicVO(teamData.getTeamBasicByName(name));
		if(vo!=null){
			return vo;
		}else{
			System.out.println("getTeamBasicByName vo");
			return null;
		}
	}

	@SuppressWarnings("unused")
	public TeamAverageVO getTeamAverageByName(String name) {
		// TODO Auto-generated method stub
		TeamAverageVO vo=new TeamAverageVO(teamData.getTeamAverageByName(name));
		if(vo!=null){
			return vo;
		}else{
			System.out.println("getTeamBasicByName vo");
			return null;
		}
	}

	@SuppressWarnings("unused")
	public TeamAllVO getTeamAllByName(String name){
		// TODO Auto-generated method stub
		TeamAllVO vo=new TeamAllVO(teamData.getTeamAllByName(name));
		if(vo!=null){
			return vo;
		}else{
			System.out.println("getTeamAllByName vo");
			return null;
		}
	}

	public ArrayList<TeamAllVO> getTeamAllRankingByNumRaising(int num) {
		// TODO Auto-generated method stub
		ArrayList<TeamAllVO> list=getTeamAll();
		if(num==25){
			Collections.sort(list, new TeamSortAllByNum(0,1));
		}else{
			Collections.sort(list, new TeamSortAllByNum(num,0));
		}	
		return list;
	}

	public ArrayList<TeamAverageVO> getTeamAverageRankingByNum(int num) {
		// TODO Auto-generated method stub
		ArrayList<TeamAverageVO> list=getTeamAverage();
		if(num==25){
			Collections.sort(list, new TeamSortAverageByNum(0,1));
		}else{
			Collections.sort(list, new TeamSortAverageByNum(num,0));
		}

		return list;
	}

	public ArrayList<TeamAverageVO> getHotTeamByNum(int num) {
		// TODO Auto-generated method stub
		ArrayList<TeamAverageVO> list=getTeamAverage();
		switch(num){
		case 0:Collections.sort(list, new TeamSortAverageByNum(14,0));
		case 1:Collections.sort(list, new TeamSortAverageByNum(8,0));
		case 2:Collections.sort(list, new TeamSortAverageByNum(9,0));
		case 3:Collections.sort(list, new TeamSortAverageByNum(11,0));
		case 4:Collections.sort(list, new TeamSortAverageByNum(10,0));
		case 5:Collections.sort(list, new TeamSortAverageByNum(16,0));
		case 6:Collections.sort(list, new TeamSortAverageByNum(15,0));
		case 7:Collections.sort(list, new TeamSortAverageByNum(17,0));
		}
		ArrayList<TeamAverageVO> result=new ArrayList<TeamAverageVO>();
		for(int i=list.size()-1;i>=list.size()-6;i--){
			result.add(list.get(i));
		}
		return list;
	}

	public String getLongNameByShortName(String shortName) {
		// TODO Auto-generated method stub
		return teamData.getTeamName(shortName);
	}

	public ArrayList<String> getTeamNamesByStr(String str) {
		// TODO Auto-generated method stub
		return teamData.getTeamNameByStr(str);
	}

	public ArrayList<String> getLongTeamNames() {
		// TODO Auto-generated method stub
		ArrayList<String>list=new ArrayList<String>();
		list=getTeamNames();
		ArrayList<String> result=new ArrayList<String>();
		for(int i=0;i<list.size();i++){
			result.add(getLongNameByShortName(list.get(i)));
		}
		return result;
	}

	public ArrayList<String> getTeamNames() {
		// TODO Auto-generated method stub
		return teamData.getAllTeamNames();
	}

	public ArrayList<String> getPlayerNamesOfTeam(String teamName) {
		// TODO Auto-generated method stub
		return teamData.getPlayerNamesOfTeam(teamName);
	}

	public ArrayList<TeamAverageVO> getTeamAverageRankingByNumDeclining(int num) {
		// TODO Auto-generated method stub
		ArrayList<TeamAverageVO>list=getTeamAverageRankingByNum(num);
		Collections.reverse(list);
		return list;
	}
	public ArrayList<TeamAllVO> getTeamAllRankingByNumDeclining(int num) {
		// TODO Auto-generated method stub
		ArrayList<TeamAllVO> list=getTeamAllRankingByNumRaising(num);
		Collections.reverse(list);
		
		return list;
	}

}
class TeamSortAllByNum implements Comparator<Object>{
	int comNum;
	int option;
    public TeamSortAllByNum(int num,int op){
    	this.comNum=num;
    	this.option=op;
    }
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamAllVO po1=(TeamAllVO) o1;
		TeamAllVO po2=(TeamAllVO)o2;
		if(option==0){
		double[] nums1=po1.getTeamData();
		double[] nums2=po2.getTeamData();
		if(nums1[comNum]>nums2[comNum]){
			return 1;
		}
		return 0;
		}else{
			int num1=po1.getMatchNum();
			int num2=po2.getMatchNum();
			if(num1>num2){
				return 1;
			}else return 0;
		}
	
	}
}
class TeamSortAverageByNum implements Comparator<Object>{
	int comNum;
	int option;
    public TeamSortAverageByNum(int num,int op){
    	this.comNum=num;
    	this.option=op;
    }
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamAverageVO po1=(TeamAverageVO) o1;
		TeamAverageVO po2=(TeamAverageVO)o2;
		double[] nums1=po1.getTeamData();
		double[] nums2=po2.getTeamData();
		if(option==0){
			if(nums1[comNum]>nums2[comNum]){
				return 1;
			}
			return 0;
		}else{

			int num1=po1.getMatchNum();
			int num2=po2.getMatchNum();
			if(num1>num2){
				return 1;
			}else return 0;
		
		}
	
	}
}
