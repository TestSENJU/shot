package VO;

public class teamInfomationVO {
     String teamAllName;//球队全名
     String teamNameAb;//球队名缩写
     String teamLocation;//所在地
     String teamCluster;//赛区
     String teamPartition;//分区
     String teamHomeCourt;//主场
     String teamSettingTime;//建立时间
     public teamInfomationVO(String teamAllName,String teamNameAb,String teamLocation,String teamCluster,String teamPartition,String teamHomeCourt,String teamSettingTime){
    	 this.teamAllName=teamAllName;
    	 this.teamNameAb=teamNameAb;
    	 this.teamLocation=teamLocation;
    	 this.teamCluster=teamCluster;
    	 this.teamPartition=teamPartition;
    	 this.teamHomeCourt=teamHomeCourt;
    	 this.teamSettingTime=teamSettingTime;
     }
     public teamInfomationVO(){
    	 
     }
     public String getTeamAllName(){
    	 return teamAllName;
     }
     public void setTeamAllName(String teamAllName){
    	 this.teamAllName=teamAllName;
     }
     public String getTeamNameAb(){
    	 return teamNameAb;
     }
     public void setTeamNameAb(String teamNameAb){
    	 this.teamNameAb=teamNameAb;
     }
     public String getTeamLocation(){
    	 return teamLocation;
     }
     public void setTeamLocation(String teamLocation){
    	 this.teamLocation=teamLocation;
     }
     public String getTeamCluster(){
    	 return teamCluster;
     }
     public void setTeamCluster(String teamCluster){
    	 this.teamCluster=teamCluster;
     }
     public String getTeamPartition(){
    	 return teamPartition;
     }
     public void setTeamPartition(String teamPartition){
    	 this.teamPartition=teamPartition;
     }
     public String getTeamHomeCourt(){
    	 return teamHomeCourt;
     }
     public void setTeamHomeCourt(String teamHomeCourt){
    	 this.teamHomeCourt=teamHomeCourt;
     }
     public String getTeamSettingTime(){
    	 return teamSettingTime;
     }
     public void setTeamSettingTime(String teamSettingTime){
    	 this.teamSettingTime=teamSettingTime;
     }
}

