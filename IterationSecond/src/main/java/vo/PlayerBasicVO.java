package vo;

import po.PlayerBasicPO;

public class PlayerBasicVO {
	String playerName;
	private String[] basicInfo=new String[8];//球员基本信息，可以从player文件夹中读取的内容
	public PlayerBasicVO(String name){
		this.playerName=name;
	}
	public PlayerBasicVO(PlayerBasicPO po){
		this.playerName=po.getPlayerName();
		this.basicInfo=po.getBasicInfo();
	}
	public String[] getBasicInfo() {
		return basicInfo;
	}
	public void setBasicInfo(String[] basicInfo) {
		this.basicInfo = basicInfo;
	}
	
}
