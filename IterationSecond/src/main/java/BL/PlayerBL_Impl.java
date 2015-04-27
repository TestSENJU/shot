package BL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Data.PlayerDataService;
import Data.PlayerData_Impl;
import po.PlayerAllPlusRatePO;
import po.PlayerAveragePlusRatePO;
import po.PlayerBasicPO;
import vo.PlayerAllVO;
import vo.PlayerAverageVO;
import vo.PlayerBasicVO;
import vo.PlayerShortVO;

public class PlayerBL_Impl implements PlayerBL{
    PlayerDataService playerData=new PlayerData_Impl();
    
	@SuppressWarnings("unused")
	public ArrayList<PlayerAllVO> getPlayerAllByMultipleConRaising(
			String location, String league, int num) {
		// TODO Auto-generated method stub
		ArrayList<String> listLocation=playerData.getPlayerByPosition(location);
		ArrayList<String> listLeague=playerData.getPlayerByLeague(league);
		ArrayList<String>list=new ArrayList<String>(listLocation);
		list.retainAll(listLeague);
		if(list!=null){
			ArrayList<PlayerAllVO>result=new ArrayList<PlayerAllVO>();
			for(int i=0;i<list.size();i++){
				result.add(new PlayerAllVO(playerData.getPlayerAllByName(list.get(i))));
			}
			switch(num){
			case 0:Collections.sort(result, new SortAllByNum(11));
			case 1:Collections.sort(result, new SortAllByNum(0));
			case 2:Collections.sort(result, new SortAllByNum(1));
			case 3:Collections.sort(result, new SortAllByNum());
			case 4:Collections.sort(result, new SortAllByNum(8));
			case 5:Collections.sort(result, new SortAllByNum(7));
			case 6:Collections.sort(result, new SortAllByNum(10));
			case 7:Collections.sort(result, new SortAllByNum(9));
			case 8:Collections.sort(result, new SortAllByNum());
			case 9:Collections.sort(result, new SortAllByNum(15));
			case 10:Collections.sort(result, new SortAllByNum(2));
			case 11:Collections.sort(result, new SortAllByNum(3));
			case 12:Collections.sort(result, new SortAllByNum(4));
			case 13:Collections.sort(result, new SortAllByNum());
			}
			return result;
		}else{
			return null;
		}		
	}

	public ArrayList<PlayerAverageVO> getPlayerAverageByMultipleConRaising(
			String location, String league, int num) {
		// TODO Auto-generated method stub
		ArrayList<String> listLocation=playerData.getPlayerByPosition(location);
		ArrayList<String> listLeague=playerData.getPlayerByLeague(league);
		ArrayList<String>list=new ArrayList<String>(listLocation);
		list.retainAll(listLeague);
		if(list!=null){
			ArrayList<PlayerAverageVO>result=new ArrayList<PlayerAverageVO>();
			for(int i=0;i<list.size();i++){
				result.add(new PlayerAverageVO(playerData.getPlayerAverageByName(list.get(i))));
			}
			switch(num){
			case 0:Collections.sort(result, new SortAverageByNum(11));
			case 1:Collections.sort(result, new SortAverageByNum(0));
			case 2:Collections.sort(result, new SortAverageByNum(1));
			case 3:Collections.sort(result, new SortAverageByNum());
			case 4:Collections.sort(result, new SortAverageByNum(8));
			case 5:Collections.sort(result, new SortAverageByNum(7));
			case 6:Collections.sort(result, new SortAverageByNum(10));
			case 7:Collections.sort(result, new SortAverageByNum(9));
			case 8:Collections.sort(result, new SortAverageByNum());
			case 9:Collections.sort(result, new SortAverageByNum(15));
			case 10:Collections.sort(result, new SortAverageByNum(2));
			case 11:Collections.sort(result, new SortAverageByNum(3));
			case 12:Collections.sort(result, new SortAverageByNum(4));
			case 13:Collections.sort(result, new SortAverageByNum());
			}
			return result;
		}else{
			return null;
		}		
	}

	public ArrayList<PlayerAllVO> getPlayerAllByMultipleConDeclining(
			String location, String league, int num) {
		// TODO Auto-generated method stub
		ArrayList<PlayerAllVO> list=getPlayerAllByMultipleConRaising(location,league,num);
		Collections.reverse(list);
		
		return list;
	}

	public ArrayList<PlayerAverageVO> getPlayerAverageByMultipleConDeclining(
			String location, String league, int num) {
		// TODO Auto-generated method stub
		ArrayList<PlayerAverageVO>list=getPlayerAverageByMultipleConRaising(location,league,num);
		Collections.reverse(list);
		return list;
	}

	public ArrayList<PlayerShortVO> getImprovedPlayerByNum(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PlayerShortVO> getTodayHotPlayerByNum(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PlayerShortVO> getHotPlayerByNum(int num) {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<String> getPlayerNames() {
		// TODO Auto-generated method stub
		return playerData.getAllPlayerNames();
	}

	public ArrayList<PlayerAllVO> getPlayerAll() {
		// TODO Auto-generated method stub
		ArrayList<PlayerAllPlusRatePO> list=new ArrayList<PlayerAllPlusRatePO>();
		list=playerData.getPlayerAll();
		ArrayList<PlayerAllVO> volist=new ArrayList<PlayerAllVO>();
		for(int i=0;i<list.size();i++){
			volist.add(new PlayerAllVO(list.get(i)));
		}
		return volist;
	}

	public ArrayList<PlayerAverageVO> getPlayerAverage() {
		// TODO Auto-generated method stub
		ArrayList<PlayerAveragePlusRatePO> list=new ArrayList<PlayerAveragePlusRatePO>();
		list=playerData.getPlayerAverage();
		ArrayList<PlayerAverageVO> volist=new ArrayList<PlayerAverageVO>();
		for(int i=0;i<list.size();i++){
			volist.add(new PlayerAverageVO(list.get(i)));
		}
		return volist;
	}

	public ArrayList<PlayerBasicVO> getPlayerBasic() {
		// TODO Auto-generated method stub
		ArrayList<PlayerBasicPO> list=new ArrayList<PlayerBasicPO>();
		list=playerData.getPlayerBasic();
		ArrayList<PlayerBasicVO> volist=new ArrayList<PlayerBasicVO>();
		for(int i=0;i<list.size();i++){
			volist.add(new PlayerBasicVO(list.get(i)));
		}
		return volist;
	}

	@SuppressWarnings("unused")
	public PlayerBasicVO getPlayerBasicByName(String name) {
		// TODO Auto-generated method stub
		PlayerBasicVO vo=new PlayerBasicVO(playerData.getPlayerBasicByName(name));
		if(vo!=null){
			System.out.println(vo.getPlayerName());
			return vo;
		}else{
			System.out.println("getplayerbasicbyname vo");
			return null;
		}
	}

	@SuppressWarnings("unused")
	public PlayerAllVO getPlayerAllByName(String name) {
		// TODO Auto-generated method stub
		PlayerAllVO vo=new PlayerAllVO(playerData.getPlayerAllByName(name));
		if(vo!=null){
			return vo;
		}else{
			System.out.println("PlayerAllVO vo");
			return null;
		}
	}

	@SuppressWarnings("unused")
	public PlayerAverageVO getPlayerAverageByName(String name) {
		// TODO Auto-generated method stub
		PlayerAverageVO vo=new PlayerAverageVO(playerData.getPlayerAverageByName(name));
		if(vo!=null){
			return vo;
		}else{
			System.out.println("PlayerAverageVO vo");
			return null;
		}
	}

	public ArrayList<String> getPlayerNamesByStr(String str) {
		// TODO Auto-generated method stub
		if(playerData.getPlayerNameByStr(str)!=null){
			return playerData.getPlayerNameByStr(str);
		}else{
			System.out.println("getPlayerNamesByStr vo");
			return null;
		}
		
	}
	public ArrayList<PlayerAverageVO> getHotPlayerRankingByNum(int num) {
		// TODO Auto-generated method stub
		ArrayList<PlayerAverageVO> list=getPlayerAverage();
		Collections.sort(list, new SortAverageByNum(num));
		ArrayList<PlayerAverageVO> result=new ArrayList<PlayerAverageVO>();
		for(int i=list.size()-1;i>list.size()-6;i--){
			result.add(list.get(i));
		}
		return list;
	}

	public ArrayList<PlayerAverageVO> getMostImprovedPlayerByNum(int num) {
		// TODO Auto-generated method stub
		ArrayList<PlayerAverageVO> list=getPlayerAverage();
		Collections.sort(list, new SortAverageByNum(num));
		ArrayList<PlayerAverageVO> result=new ArrayList<PlayerAverageVO>();
		for(int i=list.size()-1;i>list.size()-6;i--){
			result.add(list.get(i));
		}
		return result;
	}

	public ArrayList<PlayerAllVO> getPlayerAllRankingByNumRaising(int num) {
		// TODO Auto-generated method stub
		ArrayList<PlayerAllVO> list=getPlayerAll();
		Collections.sort(list, new SortAllByNum(num));
		return list;
	}

	public ArrayList<PlayerAverageVO> getPlayerAvergaeRankingByNumRaising(int num) {
		// TODO Auto-generated method stub
		ArrayList<PlayerAverageVO> list=getPlayerAverage();
		Collections.sort(list, new SortAverageByNum(num));
		return list;
	}

	public ArrayList<PlayerAverageVO> getTodayHotPlayerRankingByNum(int num) {
		// TODO Auto-generated method stub
		return getHotPlayerRankingByNum(num);
	}

	public ArrayList<PlayerAllVO> getPlayerAllRankingByNumDeclining(int num) {
		// TODO Auto-generated method stub
		ArrayList<PlayerAllVO> list=getPlayerAllRankingByNumRaising(num);
		Collections.reverse(list);
		return list;
	}

	public ArrayList<PlayerAverageVO> getPlayerAvergaeRankingByNumDeclining(
			int num) {
		// TODO Auto-generated method stub
		ArrayList<PlayerAverageVO> list=getPlayerAvergaeRankingByNumDeclining(num);
		Collections.reverse(list);
		return list;
	}

	public ArrayList<String> getPlayerNamesByBasic() {
		// TODO Auto-generated method stub
		return playerData.getPlayerNamesByBasic("players/info");
	}

}
/**
 * 
 * @author Administrator
 *  @param option
 *  0数组数字
 *  1时间
 *  2得分篮板助攻
 *  3两双
 */
class SortAllByNum implements Comparator<Object>{
	int comNum;
	int option;
    public SortAllByNum(int num,int op){
    	this.comNum=num;
    	this.option=op;
    }
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		PlayerAllVO po1=(PlayerAllVO) o1;
		PlayerAllVO po2=(PlayerAllVO)o2;
		if(this.option==1){
			String time1=po1.getPlayingTime();
			String time2=po2.getPlayingTime();
			String strs1[]=time1.split(":");
			String strs2[]=time2.split(":");
			if(Integer.parseInt(strs1[0])>Integer.parseInt(strs2[0])){
				return 1;
			}else if(Integer.parseInt(strs1[0])==Integer.parseInt(strs2[0])&&Integer.parseInt(strs1[1])>Integer.parseInt(strs2[1])){
				return 1;
			}else{
				return 0;
			}
		}else if(this.option==0){
			double[] nums1=po1.getPlayerData();
			double[] nums2=po2.getPlayerData();
			if(nums1[comNum]>nums2[comNum]){
				return 1;
			}
			return 0;
		}else if(this.option==2){
			double[] nums1=po1.getPlayerData();
			double[] nums2=po2.getPlayerData();
			double num1=nums1[11]+nums1[0]+nums1[1];
			double num2=nums2[11]+nums2[0]+nums2[1];
			if(num1>num2){
				return 1;
			}else{
				return 0;
			}
		}else if(this.option==3){
			return 0;
		}
		return 0;
	}
}
class SortAverageByNum implements Comparator<Object>{
	int comNum;
    public SortAverageByNum(int num){
    	this.comNum=num;
    }
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		PlayerAverageVO po1=(PlayerAverageVO) o1;
		PlayerAverageVO po2=(PlayerAverageVO)o2;
		double[] nums1=po1.getPlayerData();
		double[] nums2=po2.getPlayerData();
		if(nums1[comNum]>nums2[comNum]){
			return 1;
		}
		return 0;
	}
	
}
