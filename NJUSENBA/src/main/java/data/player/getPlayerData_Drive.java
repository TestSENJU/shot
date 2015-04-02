package data.player;

import java.util.Hashtable;
import java.util.Set;

import po.Player_AllScorePO;
import po.Player_AverageScorePO;
import po.Player_BasicInfoPO;

/**
 * 
 * @author wyt
 * @category 测试球员数据部分
 *
 */
public class getPlayerData_Drive {
public static void main(String args[]){
     PlayerData pd=new PlayerData_Impl();
     
    Hashtable<String,Player_AverageScorePO> vt=new Hashtable<String,Player_AverageScorePO>();
     Hashtable<String,Player_BasicInfoPO> bt=new Hashtable<String,Player_BasicInfoPO>();
     bt=pd.getPlayerBasic();
     vt=pd.getPlayerAverage();
     
     Hashtable<String,Player_AllScorePO> at=pd.getPlayerAll(); 
     Set<String>keys1=at.keySet();
     
     for(String key:keys1){
    	 System.out.println(key);
    	 Player_AllScorePO playerAll=at.get(key);
    	 double nums[]=playerAll.getScoresAll();
    	 double teamNums[]=playerAll.getTeamAll();
    	 double competeNums[]=playerAll.getCompeteAll();
  	 
    	 //输出球员的总数据

    	 System.out.println("总参赛场数"+playerAll.getNumOfMatches());
    	 System.out.println("总先发场数"+playerAll.getNumOfFirstMatches());
    	 System.out.println("队伍"+playerAll.getTeam());
    	 System.out.println("联盟"+playerAll.getTeamArea());
    	 System.out.println("总上场时间"+playerAll.getTimeAll());
    	 System.out.println("球队总时间"+playerAll.getTimeTeam());
    	 System.out.println();
    	 for(int i=0;i<15;i++){
    		 System.out.println("个人"+nums[i]);
    		 }
    	 System.out.println();
    	 for(int i=0;i<teamNums.length;i++){
    		 System.out.println("球队"+teamNums[i]);
    	 }
    	 System.out.println();
    	 for(int i=0;i<competeNums.length;i++){
    		 System.out.println("对手"+competeNums[i]);
    	 }
    	 Player_BasicInfoPO pbip=bt.get(key);
    	 String strs[]=pbip.getBasicInfo();
    	 for(int i=0;i<strs.length;i++){
    		 System.out.println(strs[i]);
    		 //TODO
    		 //输出球员的基本信息
    	 } 
    	 Player_AverageScorePO playerAver=vt.get(key);
		 double ss[]=playerAver.getScoresAverage();
		 //输出平均数据
		 String s=playerAver.getTimeAver();
		 System.out.println(s);
		 for(int i=0;i<ss.length;i++){
			 System.out.println(ss[i]);
		 }
     }
     
     
}  
}

