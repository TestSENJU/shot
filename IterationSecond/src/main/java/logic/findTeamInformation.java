package logic;
//查找球队信息
import VO.teamInfomationVO;

public class findTeamInformation {
     public teamInfomationVO findTeamInformationBy(String teamName){
    	 teamInfomationVO teamInformation=new teamInfomationVO();
    	 if(teamName.equals(teamInformation.getTeamAllName())||teamName.equals(teamInformation.getTeamNameAb())){
    		 return teamInformation;
    	 }
    	 else return null;
     }
}
