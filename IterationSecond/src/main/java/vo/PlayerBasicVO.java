package vo;

import po.PlayerBasicPO;

public class PlayerBasicVO {
	String playerName;
	/*
	 * * 0 Number
 * 1 Position
 * 2 height
 * 3 weight
 * 4 birth
 * 5 age
 * 6 exp
 * 7 school
	 */
	private String[] basicInfo=new String[8];//球员基本信息，可以从player文件夹中读取的内容
	public PlayerBasicVO(String name){
		this.playerName=name;
	}
	public PlayerBasicVO(PlayerBasicPO po){
		this.playerName=po.getPlayerName();
		this.basicInfo=po.getBasicInfo();
	}
	public String getPlayerName() {
		return playerName;
	}
	public String[] getBasicInfo() {
		return basicInfo;
	}
	public void setBasicInfo(String[] basicInfo) {
		this.basicInfo = basicInfo;
	}
	
}
