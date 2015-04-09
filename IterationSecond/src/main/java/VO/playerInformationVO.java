package VO;

public class playerInformationVO {
    String playerName;//姓名
    String playerNumber;//球衣号码
    String playerPosition;//位置
    String playerHeight;//身高
    String playerWeight;//体重
    String playerBirth;//生日
    String playerAge;//年龄
    String playerExp;//球龄
    String playerSchool;//毕业院校
    public playerInformationVO(String playerName,String playerNumber,String playerPosition,String playerHeight,String playerWeight,String 
    		playerBirth,String playerAge,String playerExp,String playerSchool){
    	
    	this.playerName=playerName;
    	this.playerNumber=playerNumber;
    	this.playerPosition=playerPosition;
    	this.playerHeight=playerHeight;
    	this.playerWeight=playerWeight;
    	this.playerBirth=playerBirth;
    	this.playerAge=playerAge;
    	this.playerExp=playerExp;
    	this.playerSchool=playerSchool;
    }
}
