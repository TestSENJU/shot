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
    
	public ArrayList<PlayerAllVO> getPlayerAllByMultipleConRaising(String location,String league,String age,ArrayList<Integer>nums,int many) {
		// TODO Auto-generated method stub
	ArrayList<String>list=getPlayerNamesByCon(location,league,age);
		if(list!=null){
			ArrayList<PlayerAllVO>result=new ArrayList<PlayerAllVO>();
			if(list.size()!=0){					
			for(int i=0;i<list.size();i++){
				result.add(new PlayerAllVO(playerData.getPlayerAllByName(list.get(i))));
			}
			ArrayList<int[]>numbers=getCompareNum(nums);
			Collections.sort(result, new SortAllByNum(numbers));		
			}else{
				result=getPlayerAllRankingByNumRaising(nums);			
			}
			if(many>result.size()){
				return result;
			}else{
				ArrayList<PlayerAllVO> returnlist=new ArrayList<PlayerAllVO>();
				for(int i=result.size()-1;i>result.size()-(many+1);i--){
					returnlist.add(result.get(i));
				}
				return returnlist;
			}
		}else{
			return null;
		}		
	
	}
private ArrayList<String> getPlayerNamesByCon(String location,String league,String age){
	ArrayList<String>list=new ArrayList<String>();
	ArrayList<String> listLocation=playerData.getPlayerByPosition(location);
	ArrayList<String> listLeague=playerData.getPlayerByLeague(league);
	ArrayList<String> listAge=playerData.getPlayerByAge(age);
	if(location!=null&&league!=null&&age!=null){
		list=new ArrayList<String>(listLocation);
		list.retainAll(listLeague);
		list.retainAll(listAge);
	}else if(location!=null&&league==null&&age!=null){
		list=new ArrayList<String>(listLocation);
		list.retainAll(listAge);
	}	else if(location==null&&league!=null&&age!=null){
		list=new ArrayList<String>(listLeague);
		list.retainAll(listAge);
	}else if(location!=null&&league!=null&&age==null){
		list=new ArrayList<String>(listLocation);
		list.retainAll(listLeague);
	}else if(location==null&&league==null&&age==null){
		
	}else if(location==null&&league==null&&age!=null){
		list=new ArrayList<String>(listAge);
	}else if(location!=null&&league==null&&age==null){
		list=new ArrayList<String>(listLocation);
	}else if(location==null&&league!=null&&age==null){
		list=new ArrayList<String>(listLeague);
	}
	return list;
}
	public ArrayList<PlayerAverageVO> getPlayerAverageByMultipleConRaising(String location,String league,String age,ArrayList<Integer>nums,int many) {
		// TODO Auto-generated method stub
		ArrayList<String>list=getPlayerNamesByCon(location,league,age);
		if(list!=null){
			ArrayList<PlayerAverageVO>result=new ArrayList<PlayerAverageVO>();
			if(list.size()!=0){					
			for(int i=0;i<list.size();i++){
				result.add(new PlayerAverageVO(playerData.getPlayerAverageByName(list.get(i))));
			}
			ArrayList<int[]>numbers=getCompareNum(nums);
			Collections.sort(result, new SortAverageByNum(numbers));		
			}else{
				result=getPlayerAvergaeRankingByNumRaising(nums);			
			}
			if(many>result.size()){
				return result;
			}else{
				ArrayList<PlayerAverageVO> returnlist=new ArrayList<PlayerAverageVO>();
				for(int i=result.size()-1;i>result.size()-(many+1);i--){
					returnlist.add(result.get(i));
				}
				return returnlist;
			}
		}else{
			return null;
		}		
	}

	public ArrayList<PlayerAllVO> getPlayerAllByMultipleConDeclining(String location,String league,String age,ArrayList<Integer>nums,int many) {
		// TODO Auto-generated method stub
		ArrayList<PlayerAllVO> list=getPlayerAllByMultipleConRaising(location,league,age,nums,many);
		Collections.reverse(list);
		
		return list;
	}

	public ArrayList<PlayerAverageVO> getPlayerAverageByMultipleConDeclining(String location,String league,String age,ArrayList<Integer>nums,int many) {
		// TODO Auto-generated method stub
		ArrayList<PlayerAverageVO>list=getPlayerAverageByMultipleConRaising(location,league,age,nums,many);
		Collections.reverse(list);
		return list;
	}

	public ArrayList<PlayerAverageVO> getImprovedPlayerByNum(ArrayList<Integer>nums,int many) {
		// TODO Auto-generated method stub
		ArrayList<PlayerAverageVO>list=getPlayerAverage();
		ArrayList<int[]>numbers=getCompareNum(nums);
		Collections.sort(list, new SortAverageByNum(numbers));
		ArrayList<PlayerAverageVO> result=new ArrayList<PlayerAverageVO>();
		if(many>list.size()){
			Collections.reverse(list);
			return list;
		}else{
			for(int i=list.size()-1;i>list.size()-many;i--){
				result.add(list.get(i));
			}
			return result;
		}
	}
	public ArrayList<PlayerShortVO> getTodayHotPlayerByNum(int num,int many) {
		// TODO Auto-generated method stub
		ArrayList<PlayerShortPO> polist=playerData.getShortPlayerToday(num);
		ArrayList<PlayerShortVO> volist=new ArrayList<PlayerShortVO>();
		for(int i=0;i<polist.size();i++){
			volist.add(new PlayerShortVO(polist.get(i)));
		}
		polist.clear();
		Collections.sort(volist, new SortShortByNum());
		if(volist.size()<=5){
			Collections.reverse(volist);
			return volist;
		}else{
			ArrayList<PlayerShortVO> list=new ArrayList<PlayerShortVO>();
			for(int i=volist.size()-1;i>volist.size()-6;i--){
				list.add(volist.get(i));
			}
			return list;
		}
	}

	public ArrayList<PlayerShortVO> getHotPlayerByNum(int num,int many) {
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

	public ArrayList<PlayerAllVO> getPlayerAllRankingByNumRaising(ArrayList<Integer>nums) {
		// TODO Auto-generated method stub
		ArrayList<PlayerAllVO> list=getPlayerAll();
		ArrayList<int[]>numbers=getCompareNum(nums);
			Collections.sort(list, new SortAllByNum(numbers));
		return list;
	}

	public ArrayList<PlayerAverageVO> getPlayerAvergaeRankingByNumRaising(ArrayList<Integer>nums) {
		// TODO Auto-generated method stub
		ArrayList<PlayerAverageVO> list=getPlayerAverage();
		ArrayList<int[]>numbers=getCompareNum(nums);
			Collections.sort(list, new SortAverageByNum(numbers));
		return list;
	}
private ArrayList<int[]> getCompareNum(ArrayList<Integer>nums){
	ArrayList<int[]>result=new ArrayList<int[]>();
	for(int i=0;i<nums.size();i++){
		if(nums.get(i)>=0&&nums.get(i)<=23){
			result.get(i)[0]=nums.get(i);
			result.get(i)[1]=0;
		}else if(nums.get(i)==24){
			result.get(i)[0]=0;
			result.get(i)[1]=1;
		}else if(nums.get(i)==25){
			result.get(i)[0]=0;
			result.get(i)[1]=4;
		}else if(nums.get(i)==26){
			result.get(i)[0]=0;
			result.get(i)[1]=5;
		}else if(nums.get(i)==27){
			result.get(i)[0]=0;
			result.get(i)[1]=6;
		}
	}
	return result;
}
	public ArrayList<PlayerAllVO> getPlayerAllRankingByNumDeclining(ArrayList<Integer>nums) {
		// TODO Auto-generated method stub
		ArrayList<PlayerAllVO> list=getPlayerAllRankingByNumRaising(nums);
		Collections.reverse(list);
		return list;
	}

	public ArrayList<PlayerAverageVO> getPlayerAvergaeRankingByNumDeclining(ArrayList<Integer>nums) {
		// TODO Auto-generated method stub
		ArrayList<PlayerAverageVO> list=getPlayerAvergaeRankingByNumDeclining(nums);
		Collections.reverse(list);
		return list;
	}

	public ArrayList<String> getPlayerNamesByBasic() {
		// TODO Auto-generated method stub
		return playerData.getPlayerNamesByBasic("players/info");
	}

	public ArrayList<String> getPlayerNamesByPosition(String position) {
		// TODO Auto-generated method stub
		return playerData.getPlayerByPosition(position);
	}

	public ArrayList<String> getPlayerNamesByLeague(String league) {
		// TODO Auto-generated method stub
		return playerData.getPlayerByLeague(league);
	}

	public ArrayList<String> getPlayerNamesByAge(String age) {
		// TODO Auto-generated method stub
		return playerData.getPlayerByAge(age);
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
	ArrayList<Integer>numbers;
	ArrayList<Integer>options;
    public SortAllByNum(ArrayList<int[]>nums){
    	for(int i=0;i<nums.size()-1;i++){
    		numbers.add(nums.get(i)[0]);
    		options.add(nums.get(i)[1]);
    	}
    }
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		PlayerAllVO po1=(PlayerAllVO) o1;
		PlayerAllVO po2=(PlayerAllVO)o2;
		for(int i=0;i<this.numbers.size()-1;i++){
			if(this.options.get(i)==1){
				String time1=po1.getPlayingTime();
				String time2=po2.getPlayingTime();
				String strs1[]=time1.split(":");
				String strs2[]=time2.split(":");
				if(Integer.parseInt(strs1[0])>Integer.parseInt(strs2[0])){
					return 1;
				}else if(Integer.parseInt(strs1[0])==Integer.parseInt(strs2[0])&&Integer.parseInt(strs1[1])>Integer.parseInt(strs2[1])){
					return 1;
				}else if(Integer.parseInt(strs1[0])==Integer.parseInt(strs2[0])&&Integer.parseInt(strs1[1])==Integer.parseInt(strs2[1])){
				}else{
					return -1;
				}
			}else if(this.options.get(i)==0){
				double[] nums1=po1.getPlayerData();
				double[] nums2=po2.getPlayerData();
				if(nums1[this.numbers.get(i)]>nums2[this.numbers.get(i)]){
					return 1;
				}else if(nums1[this.numbers.get(i)]==nums2[this.numbers.get(i)]){
				}
				return -1;
			}else if(this.options.get(i)==2){
				double[] nums1=po1.getPlayerData();
				double[] nums2=po2.getPlayerData();
				double num1=nums1[11]+nums1[0]+nums1[1];
				double num2=nums2[11]+nums2[0]+nums2[1];
				if(num1>num2){
					return 1;
				}else if(num1==num2){
					
				}else {
					return -1;
				}
			}else if(this.options.get(i)==3){
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
			}else if(this.options.get(i)==4){
				int num1=po1.getCompeteNum();
				int num2=po2.getCompeteNum();
				if(num1>num2){
					return 1;
				}else if(num1==num2){
					
				}else
				return -1;
			}else if(this.options.get(i)==5){
				int num1=po1.getOffensiveNum();
				int num2=po2.getOffensiveNum();
				if(num1>num2){
					return 1;
				}else if(num1==num2){
				   
				}else
				return -1;
			}else if(this.options.get(i)==6){
				String names[]=new String[2];
				names[0]=po1.getPlayerName();
				names[1]=po2.getPlayerName();
				Arrays.sort(names);
				if(names[1].equals(po1.getPlayerName())){
					return 1;
				}else if(names[0].equals(names[1])){
					
				}else
				return -1;
			}
			
		}
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
	ArrayList<Integer>numbers;
	ArrayList<Integer>options;
    public SortAverageByNum(ArrayList<int[]>nums){
    	for(int i=0;i<nums.size()-1;i++){
    		numbers.add(nums.get(i)[0]);
    		options.add(nums.get(i)[1]);
    	}
    }
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		PlayerAverageVO po1=(PlayerAverageVO) o1;
		PlayerAverageVO po2=(PlayerAverageVO)o2;
		for(int i=0;i<this.numbers.size()-1;i++){
			if(this.options.get(i)==1){
				String time1=po1.getPlayingTime();
				String time2=po2.getPlayingTime();
				String strs1[]=time1.split(":");
				String strs2[]=time2.split(":");
				if(Integer.parseInt(strs1[0])>Integer.parseInt(strs2[0])){
					return 1;
				}else if(Integer.parseInt(strs1[0])==Integer.parseInt(strs2[0])&&Integer.parseInt(strs1[1])>Integer.parseInt(strs2[1])){
					return 1;
				}else if(Integer.parseInt(strs1[0])==Integer.parseInt(strs2[0])&&Integer.parseInt(strs1[1])==Integer.parseInt(strs2[1])){
				}else{
					return -1;
				}
			}else if(this.options.get(i)==0){
				double[] nums1=po1.getPlayerData();
				double[] nums2=po2.getPlayerData();
				if(nums1[this.numbers.get(i)]>nums2[this.numbers.get(i)]){
					return 1;
				}else if(nums1[this.numbers.get(i)]==nums2[this.numbers.get(i)]){
				}
				return -1;
			}else if(this.options.get(i)==2){
				double[] nums1=po1.getPlayerData();
				double[] nums2=po2.getPlayerData();
				double num1=nums1[11]+nums1[0]+nums1[1];
				double num2=nums2[11]+nums2[0]+nums2[1];
				if(num1>num2){
					return 1;
				}else if(num1==num2){
					
				}else {
					return -1;
				}
			}else if(this.options.get(i)==3){
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
			}else if(this.options.get(i)==4){
				int num1=po1.getCompeteNum();
				int num2=po2.getCompeteNum();
				if(num1>num2){
					return 1;
				}else if(num1==num2){
					
				}else
				return -1;
			}else if(this.options.get(i)==5){
				int num1=po1.getOffensiveNum();
				int num2=po2.getOffensiveNum();
				if(num1>num2){
					return 1;
				}else if(num1==num2){
				   
				}else
				return -1;
			}else if(this.options.get(i)==6){
				String names[]=new String[2];
				names[0]=po1.getName();
				names[1]=po2.getName();
				Arrays.sort(names);
				if(names[1].equals(po1.getName())){
					return 1;
				}else if(names[0].equals(names[1])){
					
				}else
				return -1;
			}
			
		}
		String names[]=new String[2];
		names[0]=po1.getName();
		names[1]=po2.getName();
		Arrays.sort(names);
		if(names[1].equals(po1.getName())){
			return 1;
		}else if(names[0].equals(names[1])){
			return 0;
		}else{
			return -1;
		}
		
	}
}
