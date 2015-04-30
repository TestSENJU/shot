package BL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import Data.PlayerDataService;
import Data.PlayerData_Impl;
import po.PlayerAllPlusRatePO;
import po.PlayerAveragePlusRatePO;
import po.PlayerBasicPO;
import po.PlayerShortPO;
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
			case 0:Collections.sort(result, new SortAllByNum(11, 0));break;
			case 1:Collections.sort(result, new SortAllByNum(0,0));break;
			case 2:Collections.sort(result, new SortAllByNum(1,0));break;
			case 3:Collections.sort(result, new SortAllByNum(0,2));break;
			case 4:Collections.sort(result, new SortAllByNum(8,0));break;
			case 5:Collections.sort(result, new SortAllByNum(7,0));break;
			case 6:Collections.sort(result, new SortAllByNum(10,0));break;
			case 7:Collections.sort(result, new SortAllByNum(9,0));break;
			case 8:Collections.sort(result, new SortAllByNum(0,1));break;
			case 9:Collections.sort(result, new SortAllByNum(15,0));break;
			case 10:Collections.sort(result, new SortAllByNum(2,0));break;
			case 11:Collections.sort(result, new SortAllByNum(3,0));break;
			case 12:Collections.sort(result, new SortAllByNum(4,0));break;
			case 13:Collections.sort(result, new SortAllByNum(0,3));break;
			}
			return result;
		}else{
			return null;
		}		
	}

	@SuppressWarnings("unused")
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
			case 0:Collections.sort(result, new SortAverageByNum(11,0));break;
			case 1:Collections.sort(result, new SortAverageByNum(0,0));break;
			case 2:Collections.sort(result, new SortAverageByNum(1,0));break;
			case 3:Collections.sort(result, new SortAverageByNum(0,2));break;
			case 4:Collections.sort(result, new SortAverageByNum(8,0));break;
			case 5:Collections.sort(result, new SortAverageByNum(7,0));break;
			case 6:Collections.sort(result, new SortAverageByNum(10,0));break;
			case 7:Collections.sort(result, new SortAverageByNum(9,0));break;
			case 8:Collections.sort(result, new SortAverageByNum(0,1));break;
			case 9:Collections.sort(result, new SortAverageByNum(15,0));break;
			case 10:Collections.sort(result, new SortAverageByNum(2,0));break;
			case 11:Collections.sort(result, new SortAverageByNum(3,0));break;
			case 12:Collections.sort(result, new SortAverageByNum(4,0));break;
			case 13:Collections.sort(result, new SortAverageByNum(0,3));break;
			}
			return result;
		} else
			return null;		
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

	public ArrayList<PlayerAverageVO> getImprovedPlayerByNum(int num) {
		// TODO Auto-generated method stub
		ArrayList<PlayerAverageVO>list=getPlayerAverage();
		
		switch(num){
		
		case 0:Collections.sort(list, new SortAverageByNum(24,0));break;
		case 1:Collections.sort(list, new SortAverageByNum(25,0));break;
		case 2:Collections.sort(list, new SortAverageByNum(26,0));break;
		}System.out.println(list.get(list.size()-1).getName());
		ArrayList<PlayerAverageVO> result=new ArrayList<PlayerAverageVO>();
		for(int i=list.size()-1;i>list.size()-6;i--){
			result.add(list.get(i));
		}
		return result;
	}

	public ArrayList<PlayerShortVO> getTodayHotPlayerByNum(int num) {
		// TODO Auto-generated method stub
		ArrayList<PlayerShortPO> polist=playerData.getShortPlayerToday(num);
		ArrayList<PlayerShortVO> volist=new ArrayList<PlayerShortVO>();
		for(int i=0;i<polist.size();i++){
			volist.add(new PlayerShortVO(polist.get(i)));
		}
		polist.clear();
		Collections.sort(volist, new SortShortByNum());
		if(volist.size()<=5){
			return volist;
		}else{
			ArrayList<PlayerShortVO> list=new ArrayList<PlayerShortVO>();
			for(int i=volist.size()-1;i>volist.size()-6;i--){
				list.add(volist.get(i));
			}
			return list;
		}
	}

	public ArrayList<PlayerShortVO> getHotPlayerByNum(int num) {
		// TODO Auto-generated method stub
		ArrayList<PlayerShortPO> polist=new ArrayList<PlayerShortPO>();
		switch(num){
		case 0:polist=playerData.getShortPlayerByNum(11);break;
		case 1:polist=playerData.getShortPlayerByNum(0);break;
		case 2:polist=playerData.getShortPlayerByNum(1);break;
		case 3:polist=playerData.getShortPlayerByNum(8);break;
		case 4:polist=playerData.getShortPlayerByNum(7);break;
		case 5:polist=playerData.getShortPlayerByNum(3);break;
		case 6:polist=playerData.getShortPlayerByNum(2);break;
		case 7:polist=playerData.getShortPlayerByNum(4);break;
		}
		if(polist!=null){
		
			ArrayList<PlayerShortVO> volist=new ArrayList<PlayerShortVO>();
			for(int i=0;i<polist.size();i++){
				volist.add(new PlayerShortVO(polist.get(i)));
			}
			Collections.sort(volist, new SortShortByNum());
			ArrayList<PlayerShortVO> list=new ArrayList<PlayerShortVO>();
			for(int i=volist.size()-1;i>=volist.size()-6;i--){
				list.add(volist.get(i));
			}
			return list;
		}else{
			return null;
		}
	
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
		if(playerData.getPlayerBasicByName(name)!=null){
			PlayerBasicVO vo=new PlayerBasicVO(playerData.getPlayerBasicByName(name));
			if(vo!=null){
				System.out.println(vo.getPlayerName());
				return vo;
			}else{
				System.out.println("getplayerbasicbyname vo");
				return null;
			}
		}
		else{
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

	public ArrayList<PlayerAllVO> getPlayerAllRankingByNumRaising(int num) {
		// TODO Auto-generated method stub
		ArrayList<PlayerAllVO> list=getPlayerAll();
		if(num>=0&&num<=23){
			Collections.sort(list, new SortAllByNum(num,0));
		}else if(num==24){
			Collections.sort(list, new SortAllByNum(0,1));
		}else if(num==25){
			Collections.sort(list, new SortAllByNum(0,4));
		}else if(num==26){
			Collections.sort(list, new SortAllByNum(0,5));
		}else if(num==27){
			Collections.sort(list, new SortAllByNum(0,6));

		}
		
		return list;
	}

	public ArrayList<PlayerAverageVO> getPlayerAvergaeRankingByNumRaising(int num) {
		// TODO Auto-generated method stub
		ArrayList<PlayerAverageVO> list=getPlayerAverage();
		if(num>=0&&num<=23){
			Collections.sort(list, new SortAverageByNum(num,0));
		}else if(num==24){
			Collections.sort(list, new SortAverageByNum(0,1));
		}else if(num==25){
			Collections.sort(list, new SortAverageByNum(0,4));
		}else if(num==26){
			Collections.sort(list, new SortAverageByNum(0,5));
		}else if(num==27){
			Collections.sort(list, new SortAverageByNum(0,6));
		}
		return list;
	}

	public ArrayList<PlayerAllVO> getPlayerAllRankingByNumDeclining(int num) {
		// TODO Auto-generated method stub
		ArrayList<PlayerAllVO> list=getPlayerAllRankingByNumRaising(num);
		Collections.reverse(list);
		return list;
	}

	public ArrayList<PlayerAverageVO> getPlayerAvergaeRankingByNumDeclining(int num) {
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
 *  4比赛场数
 *  5先发场数
 *  6字典序
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
			}else if(Integer.parseInt(strs1[0])==Integer.parseInt(strs2[0])&&Integer.parseInt(strs1[1])==Integer.parseInt(strs2[1])){
				return 0;
			}else{
				return -1;
			}
		}else if(this.option==0){
			double[] nums1=po1.getPlayerData();
			double[] nums2=po2.getPlayerData();
			if(nums1[comNum]>nums2[comNum]){
				return 1;
			}else if(nums1[comNum]==nums2[comNum]){
				return 0;
			}else 
			return -1;
		}else if(this.option==2){
			double[] nums1=po1.getPlayerData();
			double[] nums2=po2.getPlayerData();
			double num1=nums1[11]+nums1[0]+nums1[1];
			double num2=nums2[11]+nums2[0]+nums2[1];
			if(num1>num2){
				return 1;
			}else if(num1==num2){
				return 0;
			}else return -1;
		}else if(this.option==3){
			double[] nums1=po1.getPlayerData();
			double[] nums2=po2.getPlayerData();
			int i1=0;
			int i2=0;
			if(nums1[11]>10)i1++;
			if(nums1[0]>10)i1++;
			if(nums1[1]>10)i1++;
			if(nums1[7]>10)i1++;
			if(nums1[8]>10)i1++;
			
			if(nums2[11]>10)i2++;
			if(nums2[0]>10)i2++;
			if(nums2[1]>10)i2++;
			if(nums2[7]>10)i2++;
			if(nums2[8]>10)i2++;
			if(i1>i2) return 1;
			else if(i1==i2) return 0;
			else return -1;
		}else if(this.option==4){
			int num1=po1.getCompeteNum();
			int num2=po2.getCompeteNum();
			if(num1>num2){
				return 1;
			}else if(num1==num2){
				return 0;
			}else 
			return -1;
		}else if(this.option==5){
			int num1=po1.getOffensiveNum();
			int num2=po2.getOffensiveNum();
			if(num1>num2){
				return 1;
			}else if(num1==num2){
				return 0;
			}else
			return -1;
		}else if(this.option==6){
			String names[]=new String[2];
			names[0]=po1.getPlayerName();
			names[1]=po2.getPlayerName();
			Arrays.sort(names);
			if(names[1].equals(po1.getPlayerName())){
				return 1;
			}else if(names[0].equals(names[1])){
				return 0;
			}else
			return -1;
		}
		return 0;
	}
}
class SortShortByNum implements Comparator<Object>{
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		PlayerShortVO player1=(PlayerShortVO)o1;
		PlayerShortVO player2=(PlayerShortVO)o2;
 		if(player1.getNum()>player2.getNum()){
 			return 1;
 		}else if(player1.getNum()==player2.getNum()){
 			return 0;
 		}else{
 			return -1;
 		}
	}
	
}
class SortAverageByNum implements Comparator<Object>{
	int comNum;
	int option;
    public SortAverageByNum(int num,int op){
    	this.comNum=num;
    	this.option=op;
    }
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		PlayerAverageVO po1=(PlayerAverageVO) o1;
		PlayerAverageVO po2=(PlayerAverageVO)o2;
		if(this.option==1){
			String time1=po1.getPlayingTime();
			String time2=po2.getPlayingTime();
			String strs1[]=time1.split(":");
			String strs2[]=time2.split(":");
			if(Integer.parseInt(strs1[0])>Integer.parseInt(strs2[0])){
				return 1;
			}else if(Integer.parseInt(strs1[0])==Integer.parseInt(strs2[0])&&Integer.parseInt(strs1[1])>Integer.parseInt(strs2[1])){
				return 1;
			}else if(Integer.parseInt(strs1[0])==Integer.parseInt(strs2[0])&&Integer.parseInt(strs1[1])==Integer.parseInt(strs2[1])){
			    return 0;
			}else{
				return -1;
			}
		}else if(this.option==0){
			double[] nums1=po1.getPlayerData();
			double[] nums2=po2.getPlayerData();
			if(nums1[comNum]>nums2[comNum]){
				return 1;
			}else if(nums1[comNum]==nums2[comNum]){
				return 0;
			}
			return -1;
		}else if(this.option==2){
			double[] nums1=po1.getPlayerData();
			double[] nums2=po2.getPlayerData();
			double num1=nums1[11]+nums1[0]+nums1[1];
			double num2=nums2[11]+nums2[0]+nums2[1];
			if(num1>num2){
				return 1;
			}else if(num1==num2){
				return 0;
			}else {
				return -1;
			}
		}else if(this.option==3){
			double[] nums1=po1.getPlayerData();
			double[] nums2=po2.getPlayerData();
			int i1=0;
			int i2=0;
			if(nums1[11]>10)i1++;
			if(nums1[0]>10)i1++;
			if(nums1[1]>10)i1++;
			if(nums1[7]>10)i1++;
			if(nums1[8]>10)i1++;
			
			if(nums2[11]>10)i2++;
			if(nums2[0]>10)i2++;
			if(nums2[1]>10)i2++;
			if(nums2[7]>10)i2++;
			if(nums2[8]>10)i2++;
			if(i1>i2) return 1;
			else return -1;
		}else if(this.option==4){
			int num1=po1.getCompeteNum();
			int num2=po2.getCompeteNum();
			if(num1>num2){
				return 1;
			}else if(num1==num2){
				return 0;
			}else
			return -1;
		}else if(this.option==5){
			int num1=po1.getOffensiveNum();
			int num2=po2.getOffensiveNum();
			if(num1>num2){
				return 1;
			}else if(num1==num2){
				return 0;
			}else
			return -1;
		}else if(this.option==6){
			String names[]=new String[2];
			names[0]=po1.getName();
			names[1]=po2.getName();
			Arrays.sort(names);
			if(names[1].equals(po1.getName())){
				return 1;
			}else if(names[0].equals(names[1])){
				return 0;
			}else
			return -1;
		}
		return -1;
	}
}
