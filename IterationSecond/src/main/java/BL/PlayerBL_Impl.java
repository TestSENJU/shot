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

public class PlayerBL_Impl implements PlayerBL{
    PlayerDataService playerData=new PlayerData_Impl();
    
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
		for(int i=list.size()-1;i>list.size()-6;i++){
			result.add(list.get(i));
		}
		return list;
	}

	public ArrayList<PlayerAverageVO> getMostImprovedPlayerByNum(int num) {
		// TODO Auto-generated method stub
		ArrayList<PlayerAverageVO> list=getPlayerAverage();
		Collections.sort(list, new SortAverageByNum(num));
		ArrayList<PlayerAverageVO> result=new ArrayList<PlayerAverageVO>();
		for(int i=list.size()-1;i>list.size()-6;i++){
			result.add(list.get(i));
		}
		return result;
	}

	public ArrayList<PlayerAllVO> getPlayerAllRankingByNum(int num) {
		// TODO Auto-generated method stub
		ArrayList<PlayerAllVO> list=getPlayerAll();
		Collections.sort(list, new SortAllByNum(num));
		return list;
	}

	public ArrayList<PlayerAverageVO> getPlayerAvergaeRankingByNum(int num) {
		// TODO Auto-generated method stub
		ArrayList<PlayerAverageVO> list=getPlayerAverage();
		Collections.sort(list, new SortAverageByNum(num));
		return list;
	}

	public ArrayList<PlayerAverageVO> getTodayHotPlayerRankingByNum(int num,
			String time) {
		// TODO Auto-generated method stub
		return null;
	}

}
class SortAllByNum implements Comparator<Object>{
	int comNum;
    public SortAllByNum(int num){
    	this.comNum=num;
    }
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		PlayerAllVO po1=(PlayerAllVO) o1;
		PlayerAllVO po2=(PlayerAllVO)o2;
		double[] nums1=po1.getPlayerData();
		double[] nums2=po2.getPlayerData();
		if(nums1[comNum]>nums2[comNum]){
			return 1;
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
