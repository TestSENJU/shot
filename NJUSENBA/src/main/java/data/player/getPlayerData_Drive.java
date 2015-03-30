package data.player;

import java.util.Hashtable;
import java.util.Set;

import po.Player_AllScorePO;
import po.Player_AverageScorePO;
import po.Player_BasicInfoPO;

 /**
  * 
  * @author Administrator
  * @category basicinfo has been checked
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
     Set<String> keys = at.keySet();
     for (String key : keys) {
    	 System.out.println(at.get(key).getPlayerName());
    	 Player_BasicInfoPO pbip=bt.get(key);
    	 String strs[]=pbip.getBasicInfo();
    	 for(int i=0;i<strs.length;i++){
    		 System.out.print(strs[i]);
    	 } 
    	 System.out.println();
    	 double nums[]=at.get(key).getScoresAll();
    	 
    	 System.out.println(at.get(key).getNumOfMatches());
//    	 if(at.get(key).getNumOfMatches()!=at.get(key).getNumOfFirstMatches()){
//    		 System.out.println("");
//    	 }
    	 System.out.println(at.get(key).getNumOfFirstMatches());
    	 System.out.println(at.get(key).getTeam());
    	 System.out.println(at.get(key).getTeamArea());
    	 System.out.println(at.get(key).getTimeAll());
    	 System.out.println();
    	 for(int i=0;i<14;i++){
    		 System.out.println(nums[i]);
    		 }
    	 Player_AverageScorePO aver=vt.get(key);
    	 double ss[]=aver.getScoresAverage();
    	 String s=aver.getTimeAver();
    	 System.out.println(s);
    	 for(int i=0;i<ss.length;i++){
    		 System.out.println(ss[i]);
    	 }
		}
     
     
     
}
}
