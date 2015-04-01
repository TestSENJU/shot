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
//     Player_AllScorePO playerAll=at.get("Aaron Gray");
//     Player_AverageScorePO playerAver=vt.get("Aaron Gray");
//     Player_BasicInfoPO playerBasic=bt.get("Aaron Gray");
//	 String strs[]=playerBasic.getBasicInfo();
//	 for(int i=0;i<strs.length;i++){
//		 System.out.print(strs[i]);
//		 //TODO
//	 } 
     System.out.println("sdf");
     System.out.println(at.size());
     Set<String>keys=at.keySet();
     
     for(String key:keys){
    	 Player_AllScorePO playerAll=at.get(key);
    	 double nums[]=playerAll.getScoresAll();
    	 System.out.println(nums.length);
//    	 if(nums==null) System.out.println("numsnull");
    	 double teamNums[]=playerAll.getTeamAll();
//    	 if(teamNums==null) System.out.println("teamnull");
    	 double competeNums[]=playerAll.getCompeteAll();
//    	 if(competeNums==null) System.out.println("competenull");
    	 
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
     }
	
//	 double ss[]=playerAver.getScoresAverage();
//	 //输出平均数据
//	 String s=playerAver.getTimeAver();
//	 System.out.println(s);
//	 for(int i=0;i<ss.length;i++){
//		 System.out.println(ss[i]);
//	 }
//     Set<String> keys = at.keySet();
//     for (String key : keys) {
//    	 System.out.println(at.get(key).getPlayerName());
//    	 Player_BasicInfoPO pbip=bt.get(key);
//    	 String strs[]=pbip.getBasicInfo();
//    	 for(int i=0;i<strs.length;i++){
//    		 System.out.print(strs[i]);
//    		 //TODO
//    		 //输出球员的基本信息
//    	 } 
//    	 System.out.println();
//    	 double nums[]=at.get(key).getScoresAll();
//    	 //输出球员的总数据
//    	 System.out.println(at.get(key).getNumOfMatches());
//    	 System.out.println(at.get(key).getNumOfFirstMatches());
//    	 System.out.println(at.get(key).getTeam());
//    	 System.out.println(at.get(key).getTeamArea());
//    	 System.out.println(at.get(key).getTimeAll());
//    	 System.out.println();
//    	 for(int i=0;i<14;i++){
//    		 System.out.println(nums[i]);
//    		 }
//    	 Player_AverageScorePO aver=vt.get(key);
//    	 double ss[]=aver.getScoresAverage();
//    	 //输出平均数据
//    	 String s=aver.getTimeAver();
//    	 System.out.println(s);
//    	 for(int i=0;i<ss.length;i++){
//    		 System.out.println(ss[i]);
//    	 }
//		}
//     
     
}  
}

