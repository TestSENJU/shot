package BL;

import java.util.ArrayList;
import java.util.Arrays;
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

	public TeamBasicVO getTeamBasicByName(String name) {
		// TODO Auto-generated method stub
		if(teamData.getTeamBasicByName(name)!=null){
			TeamBasicVO vo=new TeamBasicVO(teamData.getTeamBasicByName(name));
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

	public ArrayList<TeamAllVO> getTeamAllRankingByNumRaising(ArrayList<Integer>nums,int many) {
		// TODO Auto-generated method stub
		ArrayList<TeamAllVO> list=getTeamAll();
		ArrayList<int[]>numbers=getCompareNum(nums);
			Collections.sort(list, new TeamSortAllByNum(numbers));
		   if(list!=null){
	        	if(many<30){
	    			ArrayList<TeamAllVO> result=new ArrayList<TeamAllVO>();
	    			for(int i=list.size()-1;i>list.size()-(many+1);i--){				
	    				result.add(list.get(i));
	    			}
	    			return result;
	    		}else{
	    			Collections.reverse(list);
	    			return list;
	    		}	
	        }else{
	        	return null;
	        }
	}

	public ArrayList<TeamAverageVO> getTeamAverageRankingByNum(ArrayList<Integer>nums,int many) {
		// TODO Auto-generated method stub
		ArrayList<TeamAverageVO> list=getTeamAverage();
		ArrayList<int[]>numbers=getCompareNum(nums);
			Collections.sort(list, new TeamSortAverageByNum(numbers));
        if(list!=null){
        	if(many<30){
    			ArrayList<TeamAverageVO> result=new ArrayList<TeamAverageVO>();
    			for(int i=list.size()-1;i>list.size()-(many+1);i--){				
    				result.add(list.get(i));
    			}
    			return result;
    		}else{
    			Collections.reverse(list);
    			return list;
    		}	
        }else{
        	return null;
        }
	}
private ArrayList<int[]>getCompareNum(ArrayList<Integer>list){
	ArrayList<int[]>nums=new ArrayList<int[]>();
	for(int i=0;i<list.size();i++){
		if(list.get(i)<25){
			int n[]=new int[2];
			n[0]=list.get(i);
			n[1]=0;
			nums.add(n);
		}else{
			int n[]=new int[2];
			n[0]=0;
			n[1]=1;
			nums.add(n);
		}
	}
	return nums;
}
	public ArrayList<TeamAverageVO> getHotTeamByNum(ArrayList<Integer>nums,int many) {
		// TODO Auto-generated method stub
		ArrayList<TeamAverageVO> list=getTeamAverage();
		ArrayList<int[]>numbers=getCompareNum(nums);
		Collections.sort(list, new TeamSortAverageByNum(numbers));
		if(list!=null){
					if(many<30){
			ArrayList<TeamAverageVO> result=new ArrayList<TeamAverageVO>();
			for(int i=list.size()-1;i>list.size()-(many+1);i--){				
				result.add(list.get(i));
			}
			return result;
		}else{
			Collections.reverse(list);
			return list;
		}	
		}
		else {
			return null;
		}
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

	public ArrayList<TeamAverageVO> getTeamAverageRankingByNumDeclining(ArrayList<Integer>nums,int many) {
		// TODO Auto-generated method stub
		ArrayList<TeamAverageVO>list=getTeamAverageRankingByNum(nums,many);
		Collections.reverse(list);
		return list;
	}
	public ArrayList<TeamAllVO> getTeamAllRankingByNumDeclining(ArrayList<Integer>nums,int many) {
		// TODO Auto-generated method stub
		ArrayList<TeamAllVO> list=getTeamAllRankingByNumRaising(nums,many);
		Collections.reverse(list);
		
		return list;
	}

	public String getShortName(String longName) {
		// TODO Auto-generated method stub
		return teamData.getTeamShortName(longName);
	}

	public String getLleague(String shortName) {
		// TODO Auto-generated method stub
		return teamData.getLeague(shortName);
	}

}
class TeamSortAllByNum implements Comparator<Object>{
	ArrayList<Integer>numbers=new ArrayList<Integer>();
	ArrayList<Integer>options=new ArrayList<Integer>();
	
    public TeamSortAllByNum(ArrayList<int[]>nums){
    	for(int i=0;i<nums.size();i++){
    	this.numbers.add(nums.get(i)[0]);
    	this.options.add(nums.get(i)[1]);
    	}
    }
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamAllVO po1=(TeamAllVO) o1;
		TeamAllVO po2=(TeamAllVO)o2;
		for(int i=0;i<this.numbers.size();i++){
			if(this.options.get(i)==0){
				double[] nums1=po1.getTeamData();
				double[] nums2=po2.getTeamData();
				if(nums1[this.numbers.get(i)]>nums2[this.numbers.get(i)]){
					return 1;
				}else if(nums1[this.numbers.get(i)]==nums2[this.numbers.get(i)]){}
				else return -1;
				}else{
					int num1=po1.getMatchNum();
					int num2=po2.getMatchNum();
					if(num1>num2){
						return 1;
					}else if(num1==num2){
					}else{
						return -1;
					}					
					}
				}	
				String teamnames[]=new String[2];
				teamnames[0]=po1.getTeamName();
				teamnames[1]=po2.getTeamName();
				Arrays.sort(teamnames);
				if(po1.getTeamName().equals(teamnames[1])){
					return 1;
				}else
				return 0;
			}
		}
class TeamSortAverageByNum implements Comparator<Object>{
	ArrayList<Integer>numbers=new ArrayList<Integer>();
	ArrayList<Integer>options=new ArrayList<Integer>();
    public TeamSortAverageByNum(ArrayList<int[]>nums){
    	for(int i=0;i<nums.size();i++){
        	this.numbers.add(nums.get(i)[0]);
        	this.options.add(nums.get(i)[1]);
        	}
    }
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TeamAverageVO po1=(TeamAverageVO) o1;
		TeamAverageVO po2=(TeamAverageVO)o2;

		for(int i=0;i<this.numbers.size();i++){
			if(this.options.get(i)==0){
				double[] nums1=po1.getTeamData();
				double[] nums2=po2.getTeamData();
				if(nums1[this.numbers.get(i)]>nums2[this.numbers.get(i)]){
					return 1;
				}else if(nums1[this.numbers.get(i)]==nums2[this.numbers.get(i)]){}
				else return -1;
				}else{
					int num1=po1.getMatchNum();
					int num2=po2.getMatchNum();
					if(num1>num2){
						return 1;
					}else if(num1==num2){
					}else{
						return -1;
					}					
					}
				}	
				String teamnames[]=new String[2];
				teamnames[0]=po1.getTeamName();
				teamnames[1]=po2.getTeamName();
				Arrays.sort(teamnames);
				if(po1.getTeamName().equals(teamnames[1])){
					return 1;
				}else
				return 0;
			}
}
